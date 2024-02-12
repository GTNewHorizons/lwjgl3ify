package me.eigenraven.lwjgl3ify.relauncher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
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
            searchLinuxDirs(out);
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

    private static String getProcessOutput(String... cmd) {
        try {
            final Process p = new ProcessBuilder(cmd).redirectOutput(ProcessBuilder.Redirect.PIPE)
                .start();
            String stdout = IOUtils.toString(p.getInputStream());
            p.waitFor();
            return stdout;
        } catch (IOException | InterruptedException e) {
            return "";
        }
    }

}
