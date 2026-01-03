package me.eigenraven.lwjgl3ify.redirects;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import me.eigenraven.lwjgl3ify.client.ClientProxy;

public final class ProgressBar {

    public static void onProgressUpdate() {
        if (FMLLaunchHandler.side()
            .isClient()) {
            ClientAccess.onProgressUpdate();
        }
    }

    public static final class ClientAccess {

        public static void onProgressUpdate() {
            ClientProxy.onProgressUpdate();
        }
    }
}
