package me.eigenraven.lwjgl3ify.redirects;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.jar.JarFile;

import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RetroFuturaBootstrap;
import com.mumfrey.liteloader.launch.InjectionStrategy;

import cpw.mods.fml.common.fakelwjgl3ify.SafeRuntimeExit;

@SuppressWarnings("unused") // used by ASM
public abstract class LiteLoaderClassPathUtilities {

    private static Field ucp = null;
    private static Field classPathURLs = null;
    private static Field classPathPath = null;
    private static Field classPathLoaderMap = null;
    private static Field classPathLoaderList = null;
    private static boolean canInject;
    private static boolean canTerminate;
    private static final MethodHandle rfg$addURL;

    static {
        try {
            final Class<URLClassLoader> uclClass = URLClassLoader.class;
            final Method addURL = uclClass.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            // Allowed by our add-opens flags
            rfg$addURL = MethodHandles.lookup()
                .unreflect(addURL);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static void injectIntoClassPath(URLClassLoader classLoader, URL url, InjectionStrategy strategy) {
        addURL(classLoader, url);
    }

    public static void injectIntoClassPath(URLClassLoader classLoader, URL url) {
        addURL(classLoader, url);
    }

    public static void injectIntoClassPath(URLClassLoader classLoader, URL url, URL above) {
        addURL(classLoader, url);
    }

    public static void injectIntoClassPath(URLClassLoader classLoader, URL url, String above) {
        addURL(classLoader, url);
    }

    public static void addURL(URLClassLoader classLoader, URL url) {
        if (classLoader instanceof ExtensibleClassLoader) {
            ((ExtensibleClassLoader) classLoader).addURL(url);
        } else {
            try {
                rfg$addURL.invokeExact((URLClassLoader) classLoader, (URL) url);
            } catch (Throwable t) {
                // ignored
            }
        }
    }

    public static boolean isJarOnClassPath(File jarFile) {
        try {
            String jarURL = jarFile.toURI()
                .toURL()
                .toString();
            URL[] classPath = RetroFuturaBootstrap.API.compatClassLoader()
                .getURLs();

            for (URL classPathEntry : classPath) {
                if (classPathEntry.toString()
                    .equals(jarURL)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return false;
    }

    public static File getPathToResource(Class<?> contextClass, String resource) {
        URL res = contextClass.getResource(resource);
        if (res == null) {
            return null;
        } else {
            boolean returnParent = true;
            String jarPath = res.toString();
            if (jarPath.startsWith("jar:") && jarPath.indexOf('!') > -1) {
                jarPath = jarPath.substring(4, jarPath.indexOf('!'));
                returnParent = false;
            }

            if (jarPath.startsWith("file:")) {
                try {
                    File targetFile = new File(new URI(jarPath));
                    return returnParent ? targetFile.getParentFile() : targetFile;
                } catch (URISyntaxException exc) {
                    // ignored
                }
            }

            return null;
        }
    }

    public static boolean deleteClassPathJarContaining(Class<?> contextClass, String resource) {
        return false;
    }

    public static boolean deleteClassPathJar(String jarFileName) {
        return false;
    }

    public static void terminateRuntime(int status) {
        if (canTerminate) {
            SafeRuntimeExit.exitRuntime(status);
        } else {
            throw new IllegalStateException();
        }
    }

    private static JarFile getJarFromClassLoader(URLClassLoader classLoader, String fileName,
        boolean removeFromClassPath) {
        try {
            final URL[] urls = classLoader.getURLs();
            for (final URL url : urls) {
                final URI uri = url.toURI();
                if (uri.getPath()
                    .endsWith(fileName)) {
                    final File f = Paths.get(uri)
                        .toFile();
                    return new JarFile(f, false, JarFile.OPEN_READ);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return null;
    }
}
