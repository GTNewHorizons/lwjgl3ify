package me.eigenraven.lwjgl3ify.relauncher;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import net.minecraft.launchwrapper.Launch;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.fakelwjgl3ify.SafeRuntimeExit;
import me.eigenraven.lwjgl3ify.Tags;

public class Relauncher {

    static final Logger logger = LogManager.getLogger("Lwjgl3ify/Relauncher");
    static final String[] SYSTEM_PROPERTY_PREFIXES = new String[] { "java.", "os.", "path.", "file.", "line.", "user.",
        "native.", "com.sun.", "sun.", "awt.", };
    static final String[] RECOMMENDED_JAVA_ARGS = Tags.RECOMMENDED_JAVA_ARGS.split("\t");
    final Path osCache;
    final Path mavenDownloadPath;
    final String[] args;
    final String gameVersion;
    final Downloader downloader;
    final RelauncherUserInterface gui;
    Path forgePatchesJarPath;

    public void runtimeExit(int exitCode) {
        SafeRuntimeExit.exitRuntime(exitCode);
    }

    public Relauncher(String[] args, String gameVersion) {
        this.args = args;
        this.gameVersion = gameVersion;

        final String userHome = System.getProperty("user.home");
        final String system = System.getProperty("os.name")
            .toLowerCase();
        Path cacheDir;
        try {
            if (system.contains("win")) {
                String localAppData = System.getenv("LOCALAPPDATA");
                if (localAppData != null) {
                    cacheDir = Paths.get(localAppData, "lwjgl3ify");
                } else {
                    cacheDir = Paths.get(userHome, "AppData", "Local", "lwjgl3ify");
                }
            } else if (system.contains("mac")) {
                cacheDir = Paths.get(userHome, "Library", "Caches", "lwjgl3ify");
            } else {
                String xdgCacheHome = System.getenv("XDG_CACHE_HOME");
                if (xdgCacheHome == null) {
                    cacheDir = Paths.get(userHome, ".cache", "lwjgl3ify");
                } else {
                    cacheDir = Paths.get(xdgCacheHome, "lwjgl3ify");
                }
            }
        } catch (InvalidPathException e) {
            if (system.contains("win")) {
                cacheDir = Paths.get(userHome, "AppData", "Local", "lwjgl3ify");
            } else {
                cacheDir = Paths.get(userHome, ".cache", "lwjgl3ify");
            }
            logger.warn(
                "An error occurred while the lwjgl3ify relauncher cache path was created. The environment variable TEMP or LOCALAPPDATA could be set incorrectly. Using the default cache location: {}",
                cacheDir,
                e);
        }
        osCache = cacheDir;

        final String mavenDownloadRoot = System.getProperty("lwjgl3ify.relauncher.mavenDownloadRoot", "");
        final Path mavenDownloadPath;
        if (mavenDownloadRoot.isEmpty()) {
            mavenDownloadPath = osCache.resolve("maven");
        } else {
            mavenDownloadPath = Paths.get(mavenDownloadRoot);
        }
        if (!Files.isDirectory(mavenDownloadPath)) {
            try {
                Files.createDirectories(mavenDownloadPath);
            } catch (IOException e) {
                logger.fatal("Could not create Maven download cache at {}", mavenDownloadPath, e);
                FMLCommonHandler.instance()
                    .exitJava(1, false);
            }
        }
        this.mavenDownloadPath = mavenDownloadPath;
        RelauncherConfig.load();

        this.gui = new RelauncherUserInterface(this);

        downloader = new Downloader(mavenDownloadPath);
        downloader.loadTasks();
        final int dlTasks = downloader.remainingTasks();
        if (dlTasks > 0) {
            logger.info("We need to download {} libraries into the cache at {}", dlTasks, mavenDownloadPath);
            gui.downloadWithGui(downloader);
        } else {
            logger.info("All libraries found in the cache at {}", mavenDownloadPath);
        }
    }

    public List<String> createClasspath() {
        final List<String> classpath = new ArrayList<>();
        try {
            // Extract RFB&libraries jar
            final byte[] forgePatchesData = IOUtils.toByteArray(
                Objects.requireNonNull(
                    Relauncher.class.getResourceAsStream("forgePatches.zip"),
                    "missing bundled forgePatches jar"));
            final String forgePatchesDigest = DigestUtils.sha256Hex(forgePatchesData);
            final Path jarsDir = mavenDownloadPath.getParent()
                .resolve("jars");
            Files.createDirectories(jarsDir);
            final Path jarFile = jarsDir.resolve("forgePatches-" + forgePatchesDigest + ".jar");
            if (!Files.exists(jarFile)) {
                logger.info("Extracting bundled early classpath libraries to {}", jarFile);
                Files.write(jarFile, forgePatchesData, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
            } else {
                logger.info("Using previously extracted bundled early classpath libraries from {}", jarFile);
            }
            classpath.add(jarFile.toString());
            this.forgePatchesJarPath = jarFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (final Path cpFile : downloader.jarPaths()) {
            if (!Files.exists(cpFile)) {
                continue;
            }
            classpath.add(
                cpFile.toAbsolutePath()
                    .toString());
        }
        return classpath;
    }

    private static long getCurrentPid() {
        final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        // getName is implemented to return getPid() + "@" + hostname
        final String combinedPidHostname = runtime.getName();
        final String[] parts = combinedPidHostname.split("@", 2);
        return Integer.parseInt(parts[0]);
    }

    @SuppressWarnings("deprecation")
    public void run() throws IOException {
        gui.startSettingsIfNeeded();
        if (!gui.runClicked) {
            runtimeExit(0);
            return;
        }

        URL myJarUrl = Relauncher.class.getProtectionDomain()
            .getCodeSource()
            .getLocation();
        // In case of broken LW-like classloaders that pass in jar: urls as the code source
        while ("jar".equalsIgnoreCase(myJarUrl.getProtocol())) {
            final String str = myJarUrl.toString();
            myJarUrl = new URL(str.substring(4, str.lastIndexOf('!')));
        }
        final Path myJarPath;
        try {
            myJarPath = Paths.get(myJarUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        final List<String> cmd = new ArrayList<>();
        cmd.addAll(Arrays.asList(RECOMMENDED_JAVA_ARGS));
        if (SystemUtils.IS_OS_MAC) {
            cmd.add("-XstartOnFirstThread");
        }
        cmd.addAll(RelauncherConfig.config.toJvmArgs());
        cmd.add("-cp");
        cmd.add(StringUtils.join(createClasspath(), File.pathSeparatorChar));
        // Forward any custom system properties
        outer: for (final Map.Entry<Object, Object> prop : System.getProperties()
            .entrySet()) {
            if (prop.getKey() == null || prop.getValue() == null) {
                continue;
            }
            final String key = prop.getKey()
                .toString();
            for (final String systemPrefix : SYSTEM_PROPERTY_PREFIXES) {
                if (key.startsWith(systemPrefix)) {
                    continue outer;
                }
            }
            final String value = prop.getValue()
                .toString();
            cmd.add("-D" + key + "=" + value);
        }

        cmd.add("com.gtnewhorizons.retrofuturabootstrap.MainStartOnFirstThread");

        cmd.addAll(
            Arrays.asList(
                "--version",
                gameVersion,
                "--gameDir",
                Launch.minecraftHome.toString(),
                "--assetsDir",
                Launch.assetsDir.toString(),
                "--tweakClass",
                "cpw.mods.fml.common.launcher.FMLTweaker"));
        cmd.addAll(Arrays.asList(args));

        final Path argFile = Files.createTempFile("lwjgl3ify-relaunch-", ".arg");
        Files.write(
            argFile,
            cmd.stream()
                .map(c -> '"' + StringEscapeUtils.escapeJava(c) + '"')
                .collect(Collectors.toList()),
            StandardCharsets.UTF_8);

        final List<String> bootstrapCmd = new ArrayList<>();
        final String[] javas = RelauncherConfig.config.javaInstallationsCache;
        final int javaIdx = RelauncherConfig.config.javaInstallation;
        final String javaPath;
        if (javaIdx < 0 || javaIdx >= javas.length) {
            javaPath = SystemUtils.IS_OS_WINDOWS ? "javaw" : "java";
        } else {
            javaPath = javas[javaIdx];
        }
        bootstrapCmd.add(javaPath);
        if (RelauncherConfig.config.forwardLogs) {
            bootstrapCmd.add("@" + argFile);
        } else {
            bootstrapCmd.add("-Xms16M");
            bootstrapCmd.add("-Xmx256M");
            bootstrapCmd.add("-cp");
            bootstrapCmd.add(forgePatchesJarPath + File.pathSeparator + myJarPath);
            bootstrapCmd.add("me.eigenraven.lwjgl3ify.relauncherstub.RelauncherStubMain");
            bootstrapCmd.add(Long.toString(getCurrentPid()));
            bootstrapCmd.add("true");
            bootstrapCmd.add(javaPath);
            bootstrapCmd.add(argFile.toString());
        }

        final ProcessBuilder pb = new ProcessBuilder(bootstrapCmd);
        pb.inheritIO();
        if (!RelauncherConfig.config.forwardLogs) {
            pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
        }
        logger.info("Starting relaunched process using args {}", bootstrapCmd);
        final Process p = pb.start();
        if (RelauncherConfig.config.forwardLogs) {
            while (p.isAlive()) {
                try {
                    p.waitFor();
                    break;
                } catch (InterruptedException e) {
                    continue;
                }
            }
            runtimeExit(p.exitValue());
        } else {
            // Wait for the "quit" message from the child process
            try {
                p.getInputStream()
                    .read(new byte[6]);
            } catch (IOException e) {
                // ignored
            }
            runtimeExit(0);
        }
    }
}
