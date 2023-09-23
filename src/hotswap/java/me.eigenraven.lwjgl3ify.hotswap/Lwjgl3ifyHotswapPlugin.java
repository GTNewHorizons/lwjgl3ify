package me.eigenraven.lwjgl3ify.hotswap;

import java.security.ProtectionDomain;

import org.hotswap.agent.annotation.LoadEvent;
import org.hotswap.agent.annotation.OnClassLoadEvent;
import org.hotswap.agent.annotation.Plugin;
import org.hotswap.agent.config.PluginManager;
import org.hotswap.agent.logging.AgentLogger;

@Plugin(
    name = "Lwjgl3ifyHSA",
    description = "Runs LaunchWrapper transformers as needed for reloaded classes.",
    testedVersions = "1.7.10",
    expectedVersions = "1.7.10")
public class Lwjgl3ifyHotswapPlugin {

    public static final String PLUGIN_PACKAGE = "me.eigenraven.lwjgl3ify.hotswap";
    private static AgentLogger LOGGER = AgentLogger.getLogger(Lwjgl3ifyHotswapPlugin.class);

    @OnClassLoadEvent(classNameRegexp = ".*", events = LoadEvent.REDEFINE)
    public static byte[] reloadClass(byte[] inputClassBytes, ClassLoader classLoader, String className,
        ProtectionDomain protectionDomain) {
        final Thread curThread = Thread.currentThread();
        final ClassLoader ctxLoader = curThread.getContextClassLoader();
        try {
            if (classLoader.getClass()
                .getName()
                .equals("net.minecraft.launchwrapper.LaunchClassLoader")) {
                LOGGER.debug("Retransforming {}", className);
                PluginManager.getInstance()
                    .initClassLoader(classLoader, protectionDomain);
                final Class<?> helper = Class
                    .forName("me.eigenraven.lwjgl3ify.hotswap.TransformHelper", true, classLoader);
                curThread.setContextClassLoader(classLoader);
                byte[] newClassBytes = (byte[]) helper
                    .getMethod("transform", classLoader.getClass(), String.class, byte[].class)
                    .invoke(null, classLoader, className, inputClassBytes);
                curThread.setContextClassLoader(ctxLoader);
                return newClassBytes;
            }
        } catch (Exception e) {
            LOGGER.error("Error when attempting to pass {} through LaunchClassLoader", e, className);
            e.printStackTrace();
        } finally {
            curThread.setContextClassLoader(ctxLoader);
        }
        return inputClassBytes;
    }
}
