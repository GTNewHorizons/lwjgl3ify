package me.eigenraven.lwjgl3ify.core;

import java.awt.Toolkit;

import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;
import org.lwjglx.Sys;

import cpw.mods.fml.relauncher.FMLLaunchHandler;

public class LateInit {

    public static void lateConstruct() {
        // Ensure javax.script.ScriptEngineManager gets loaded
        try {
            Class.forName("javax.script.ScriptEngineManager");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (FMLLaunchHandler.side()
            .isClient()) {
            clientMacOsFix();
            Sys.initialize();
        }
    }

    private static void clientMacOsFix() {
        if (Platform.get() == Platform.MACOSX) {
            Configuration.GLFW_LIBRARY_NAME.set("glfw_async");
            Configuration.GLFW_CHECK_THREAD0.set(false);
            Toolkit.getDefaultToolkit(); // Initialize AWT before GLFW
        }
    }
}
