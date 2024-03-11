package me.eigenraven.lwjgl3ify.relauncher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Locates JVM installations in standard OS paths.
 * Standard paths collected from <a href=
 * "https://github.com/gradle/gradle/blob/6437c60bbbfdc98f65f7d55dcf971e01db3fb543/platforms/jvm/jvm-services/src/main/java/org/gradle/jvm/toolchain/internal/LinuxInstallationSupplier.java">Gradle's
 * installation suppliers</a>
 */
public final class JvmLocator {

    private JvmLocator() {}

    /** @return List of paths to executable java(w.exe) binaries */
    public static List<Path> detectJavaInstalls(List<String> cache) {
        final ArrayList<Path> out = new ArrayList<>();

        for (final String cacheEntry : cache) {
            final Path p = Paths.get(cacheEntry);
            if (Files.isRegularFile(p)) {
                out.add(p);
            }
        }

        if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_FREE_BSD) {
            try {
                searchLinuxDirs(out);
            } catch (Throwable t) {
                Relauncher.logger.warn("Could not scan JVM homes", t);
            }
        }

        if (SystemUtils.IS_OS_MAC) {
            try {
                searchMacJavaHomes(out);
            } catch (Throwable t) {
                Relauncher.logger.warn("Could not scan JVM homes", t);
            }
        }

        if (SystemUtils.IS_OS_WINDOWS) {
            try {
                searchWindowsRegistry(out);
            } catch (Throwable t) {
                Relauncher.logger.warn("Could not scan JVM homes", t);
            }
        }

        Collections.sort(out);
        return Lists.newArrayList(Sets.newLinkedHashSet(out));
    }

    private static final boolean IS_UNIXY = !SystemUtils.IS_OS_WINDOWS;
    private static final Function<Path, Path> BIN_JAVA_RESOLVER = IS_UNIXY ? (p -> p.resolve("bin")
        .resolve("java"))
        : (p -> p.resolve("bin")
            .resolve("javaw.exe"));

    // Finds subdirectories with bin/java executables
    private static void searchDirs(List<Path> out, String... dirs) {
        for (final String dir : dirs) {
            final Path path = Paths.get(dir);
            if (!Files.isDirectory(path)) {
                continue;
            }
            final Path simpleChild = BIN_JAVA_RESOLVER.apply(path);
            if (Files.isRegularFile(simpleChild)) {
                out.add(simpleChild);
            }
            try (final Stream<Path> children = Files.list(path)) {
                children.forEach(child -> {
                    final Path binJava = BIN_JAVA_RESOLVER.apply(child);
                    if (Files.isRegularFile(binJava)) {
                        out.add(binJava);
                    }
                });
            } catch (IOException e) {
                // ignored
            }
        }
    }

    private static void searchLinuxDirs(List<Path> out) {
        searchDirs(out, "/usr/lib/jvm", "/usr/lib/java", "/usr/java", "/usr/local/java", "/opt/java");
        if (!Files.isSymbolicLink(Paths.get("/usr/lib64"))) {
            searchDirs(out, "/usr/lib64/jvm", "/usr/lib64/java");
        }
    }

    private static final Pattern OSX_INSTALLATION_PATTERN = Pattern.compile(".+\\s+(/.+)");

    private static void searchMacJavaHomes(List<Path> out) {
        final String[] cmdOut = getProcessOutput("/usr/libexec/java_home", "-V").split("\n");
        for (final String outLine : cmdOut) {
            final Matcher matcher = OSX_INSTALLATION_PATTERN.matcher(outLine);
            if (matcher.matches()) {
                final String javaHome = matcher.group(1);
                final Path binJava = BIN_JAVA_RESOLVER.apply(Paths.get(javaHome));
                if (Files.isRegularFile(binJava)) {
                    out.add(binJava);
                }
            }
        }
    }

    private static void searchWindowsRegistry(List<Path> out) {
        // OpenJDK candidates
        final List<String> javaHomes = new ArrayList<>();
        Stream.of("SOFTWARE\\AdoptOpenJDK\\JDK", "SOFTWARE\\Eclipse Adoptium\\JDK", "SOFTWARE\\Eclipse Foundation\\JDK")
            .forEach(p -> javaHomes.addAll(scanRegistryJvms(p, "\\hotspot\\MSI", "Path")));
        // Other JDKs
        Stream
            .of(
                "SOFTWARE\\JavaSoft\\JDK",
                "SOFTWARE\\JavaSoft\\Java Development Kit",
                "SOFTWARE\\JavaSoft\\Java Runtime Environment",
                "SOFTWARE\\Wow6432Node\\JavaSoft\\Java Development Kit",
                "SOFTWARE\\Wow6432Node\\JavaSoft\\Java Runtime Environment")
            .forEach(p -> javaHomes.addAll(scanRegistryJvms(p, "", "JavaHome")));
        for (final String javaHome : javaHomes) {
            final Path binJava = BIN_JAVA_RESOLVER.apply(Paths.get(javaHome));
            if (Files.isRegularFile(binJava)) {
                out.add(binJava);
            }
        }
    }

    private static List<String> scanRegistryJvms(String sdkSubkey, String path, String value) {
        return getRegistrySubkeys("HKLM\\" + sdkSubkey).stream()
            .map(withVersion -> getRegistryKey(withVersion + path, value))
            .collect(Collectors.toList());
    }

    private static String getRegistryKey(String location, String key) {
        final String out = getProcessOutput("REG.EXE", "QUERY", location, "/v", key);
        if (out.isEmpty()) {
            return null;
        }
        if (!out.contains(key)) {
            return null;
        }
        for (String line : out.split("\n")) {
            // key[spaces]REG_type[spaces]value
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (!line.startsWith(key)) {
                continue;
            }
            line = line.substring(key.length())
                .trim();
            final String firstWord = line.split("\\s+")[0];
            line = line.substring(firstWord.length())
                .trim();
            return line;
        }
        return null;
    }

    // HKCU\a -> HKCU\a\b, HKCU\a\c, ...
    private static List<String> getRegistrySubkeys(String location) {
        final String out = getProcessOutput("REG.EXE", "QUERY", location);
        if (out.isEmpty()) {
            return Collections.emptyList();
        }
        final String sublocationPrefix = location + '\\';
        if (!out.contains(sublocationPrefix)) {
            return Collections.emptyList();
        }
        final List<String> ret = new ArrayList<>();
        for (String line : out.split("\n")) {
            // key[spaces]REG_type[spaces]value
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            if (!line.startsWith(sublocationPrefix)) {
                continue;
            }
            ret.add(line);
        }
        return ret;
    }

    private static String getProcessOutput(String... cmd) {
        try {
            final ProcessBuilder pb = new ProcessBuilder(cmd).redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE);
            pb.environment()
                .remove("JAVA_VERSION");
            final Process p = pb.start();
            String stdout = IOUtils.toString(p.getInputStream()) + "\n" + IOUtils.toString(p.getErrorStream());
            final int ec = p.waitFor();
            if (ec != 0) {
                return "";
            }
            return stdout.trim();
        } catch (IOException | InterruptedException e) {
            return "";
        }
    }

}
