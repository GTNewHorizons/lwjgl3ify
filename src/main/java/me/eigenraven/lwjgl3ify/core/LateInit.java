package me.eigenraven.lwjgl3ify.core;

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
            Sys.initialize();
        }
    }
}
