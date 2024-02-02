package me.eigenraven.lwjgl3ify.relauncher;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.FMLLaunchHandler;

public class Lwjgl3ifyRelauncherTweaker implements ITweaker {

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        if (Launch.blackboard.get("lwjgl3ify:rfb-booted") != Boolean.TRUE) {
            if (FMLLaunchHandler.side()
                .isServer()) {
                LogManager.getLogger()
                    .fatal(
                        "lwjgl3ify relauncher does not support server launches, install according to lwjgl3ify's README.");
                FMLCommonHandler.instance()
                    .exitJava(1, false);
            }
            // Not launched via RFB, transfer control to the relauncher.
            try {
                new Relauncher(args.toArray(new String[0]), profile).run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() {
        return null;
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
