package me.eigenraven.lwjgl3ify.relauncher;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.jetbrains.annotations.NotNull;

import com.google.common.base.Throwables;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Downloader {

    public final @NotNull Path mavenCachePath;
    private final AtomicInteger remainingTasks = new AtomicInteger(0);
    private final List<Path> jarPaths = new ArrayList<>();
    private final List<DownloadTask> tasks = new ArrayList<>();
    private final ConcurrentLinkedDeque<Throwable> taskExceptions = new ConcurrentLinkedDeque<>();

    public Downloader(@NotNull Path mavenCachePath) {
        this.mavenCachePath = Objects.requireNonNull(mavenCachePath);
    }

    public int remainingTasks() {
        return remainingTasks.get() + tasks.size();
    }

    public void loadTasks() {
        try {
            String os = "";
            final boolean isArm = SystemUtils.OS_ARCH.equalsIgnoreCase("aarch64")
                || SystemUtils.OS_ARCH.toLowerCase(Locale.ROOT)
                    .startsWith("arm");
            if (SystemUtils.IS_OS_WINDOWS) {
                os = isArm ? "windows-arm64" : "windows";
            } else if (SystemUtils.IS_OS_MAC) {
                os = isArm ? "osx-arm64" : "osx";
            } else if (SystemUtils.IS_OS_LINUX) {
                // There is also linux-arm32, but does anyone care?
                os = isArm ? "linux-arm64" : "linux";
            } else {
                throw new UnsupportedOperationException(
                    "Unknown operating system " + SystemUtils.OS_NAME + ":" + SystemUtils.OS_ARCH);
            }
            final JsonElement versionRoot;
            try (final InputStream is = Downloader.class.getResourceAsStream("version.json");
                final BufferedInputStream bis = new BufferedInputStream(is);
                final InputStreamReader rdr = new InputStreamReader(bis, StandardCharsets.UTF_8)) {
                versionRoot = JsonParser.parseReader(rdr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            final JsonArray libraries = versionRoot.getAsJsonObject()
                .getAsJsonArray("libraries");
            for (final JsonElement libraryR : libraries) {
                final JsonObject elLibrary = libraryR.getAsJsonObject();
                if (!passesRules(elLibrary, os)) {
                    continue;
                }
                final String elGav = elLibrary.getAsJsonPrimitive("name")
                    .getAsString();
                if (elLibrary.has("downloads")) {
                    final JsonObject elDownloads = elLibrary.getAsJsonObject("downloads");
                    // URL artifact
                    if (elDownloads.has("artifact")) {
                        // No classifiers
                        final JsonObject elArtifact = elDownloads.getAsJsonObject("artifact");
                        addArtifactDownload(elGav, elArtifact, tasks);
                    } else {
                        // Classifiers
                        // TODO - twitch, jinput
                    }
                } else {
                    // Maven artifact
                    final String elMavenUrl = elLibrary.getAsJsonPrimitive("url")
                        .getAsString();
                    final GavCoords gav = new GavCoords(elGav);
                    if (gav.mArtifact.equals("lwjgl3ify")) {
                        continue;
                    }

                    final String mURL = elMavenUrl + gav.mPath;
                    final Path path = mavenCachePath.resolve(gav.mPath);
                    final URL url = new URL(mURL);
                    jarPaths.add(path);
                    tasks.add(new DownloadTask(url, null, path));
                }
            }

            for (Iterator<DownloadTask> it = tasks.iterator(); it.hasNext();) {
                final DownloadTask task = it.next();
                if (Files.exists(task.targetLocation)) {
                    // already downloaded, skip
                    it.remove();
                }
            }
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    public void runDownloads() {
        final Path cacheLockPath = mavenCachePath.resolve("cache.lock");
        if (!Files.exists(cacheLockPath)) {
            try {
                Files.createFile(cacheLockPath);
            } catch (FileAlreadyExistsException e) {
                // ignored
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (final FileChannel cacheChannel = FileChannel.open(cacheLockPath, StandardOpenOption.WRITE)) {
            FileLock cacheLock = cacheChannel.tryLock(); // released by closing the channel
            if (cacheLock == null) {
                Relauncher.logger.warn("Another process is already holding a lock on {}, waiting", cacheLockPath);
                cacheLock = cacheChannel.lock();
            }

            final ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
                final Thread t = new Thread(r);
                t.setName("Lwjgl3ify downloader");
                t.setDaemon(true);
                return t;
            });
            try {
                remainingTasks.addAndGet(tasks.size());
                for (final DownloadTask task : tasks) {
                    executor.submit(() -> {
                        try {
                            task.download();
                        } catch (Throwable e) {
                            taskExceptions.add(e);
                        }
                        remainingTasks.decrementAndGet();
                    });
                }
                tasks.clear();
                executor.shutdown();
                executor.awaitTermination(7, TimeUnit.DAYS);
                if (!taskExceptions.isEmpty()) {
                    Relauncher.logger.error("Exceptions happened during download task execution:");
                    Throwable last = null;
                    while (!taskExceptions.isEmpty()) {
                        last = taskExceptions.removeFirst();
                        Relauncher.logger.error("Download exception", last);
                    }
                    if (last != null) {
                        throw Throwables.propagate(last);
                    }
                }
            } finally {
                executor.shutdownNow();
            }

        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    private void addArtifactDownload(String name, JsonObject elArtifact, List<DownloadTask> tasks)
        throws MalformedURLException, DecoderException {
        final String elPath;
        if (elArtifact.has("path")) {
            elPath = elArtifact.getAsJsonPrimitive("path")
                .getAsString();
        } else {
            final GavCoords gav = new GavCoords(name);
            elPath = gav.mPath;
        }
        final String elUrl = elArtifact.getAsJsonPrimitive("url")
            .getAsString();
        final String elSha1 = elArtifact.getAsJsonPrimitive("sha1")
            .getAsString();
        final URL url = new URL(elUrl);
        final Path path = mavenCachePath.resolve(elPath);
        final byte[] sha1 = Hex.decodeHex(elSha1.toCharArray());
        jarPaths.add(path);
        tasks.add(new DownloadTask(url, sha1, path));
    }

    private static boolean passesRules(final JsonObject library, final String os) {
        if (library.has("rules")) {
            final JsonArray elRules = library.getAsJsonArray("rules");
            boolean allowed = false;
            for (final JsonElement ruleR : elRules) {
                final JsonObject elRule = ruleR.getAsJsonObject();
                if (elRule.has("os")) {
                    final JsonObject elOs = elRule.getAsJsonObject("os");
                    if (elOs.has("name")) {
                        final String elOsName = elOs.get("name")
                            .getAsString();
                        if (!os.equals(elOsName)) {
                            continue;
                        }
                    }
                }
                if (elRule.has("action")) {
                    final String elAction = elRule.get("action")
                        .getAsString();
                    switch (elAction) {
                        case "allow" -> allowed = true;
                        case "disallow" -> allowed = false;
                        default -> throw new IllegalStateException("Illegal rule action: " + elAction);
                    }
                }
            }
            return allowed;
        } else {
            return true;
        }
    }

    public static final class GavCoords {

        public final String[] gav;
        final String mGroup;
        final String mArtifact;
        final String mVersion;
        final String mClassifier;
        final String mGroupPath;
        final String mFilename;

        final String mPath;

        public GavCoords(final String elGav) {
            gav = elGav.split(":");
            mGroup = (gav.length > 2) ? gav[0] : "";
            mArtifact = (gav.length > 2) ? gav[1] : gav[0];
            mVersion = (gav.length > 2) ? gav[2] : gav[1];
            mClassifier = (gav.length > 3) ? gav[3] : "";
            mGroupPath = mGroup.replace('.', '/');

            String mFilename = mArtifact;
            if (!mVersion.isEmpty()) {
                mFilename += '-' + mVersion;
            }
            if (!mClassifier.isEmpty()) {
                mFilename += '-' + mClassifier;
            }
            mFilename += ".jar";
            this.mFilename = mFilename;

            mPath = mGroupPath + '/' + mArtifact + '/' + mVersion + '/' + mFilename;
        }
    }

    public static final class DownloadTask {

        private final URL sourceUrl;
        private final byte[] checksum;
        private final Path targetLocation;

        public DownloadTask(URL sourceUrl, byte[] checksum, Path targetLocation) {
            this.sourceUrl = sourceUrl;
            this.checksum = checksum;
            this.targetLocation = targetLocation;
        }

        public URL sourceUrl() {
            return sourceUrl;
        }

        public byte[] checksum() {
            return checksum;
        }

        public Path targetLocation() {
            return targetLocation;
        }

        public void download() throws IOException {
            final Path targetDir = targetLocation.getParent();

            Files.createDirectories(targetDir);
            Files.deleteIfExists(targetLocation);

            byte[] data = null;
            Relauncher.logger.info("Downloading {} from {}", targetLocation, sourceUrl);
            for (int retries = 0; retries < 5; retries++) {
                try {
                    data = IOUtils.toByteArray(sourceUrl);
                    if (checksum != null) {
                        final byte[] dataSum = DigestUtils.sha1(data);
                        if (!Arrays.equals(dataSum, checksum)) {
                            throw new RuntimeException("Checksum mismatch for " + targetLocation);
                        }
                    }
                } catch (Exception e) {
                    if (retries != 4) {
                        continue;
                    } else {
                        throw e;
                    }
                }
            }
            Objects.requireNonNull(data);
            Files.write(targetLocation, data);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (DownloadTask) obj;
            return Objects.equals(this.sourceUrl, that.sourceUrl) && Objects.equals(this.checksum, that.checksum)
                && Objects.equals(this.targetLocation, that.targetLocation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sourceUrl, checksum, targetLocation);
        }

        @Override
        public String toString() {
            return "DownloadTask[" + "sourceUrl="
                + sourceUrl
                + ", "
                + "checksum="
                + checksum
                + ", "
                + "targetLocation="
                + targetLocation
                + ']';
        }
    }
}
