package me.eigenraven.lwjgl3ify;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.eigenraven.lwjgl3ify.api.ConfigUtils;
import me.eigenraven.lwjgl3ify.core.Config;

@Mod(
    modid = "lwjgl3ify",
    name = "Lwjgl3ify",
    version = Tags.VERSION,
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*",
    guiFactory = "me.eigenraven.lwjgl3ify.client.GuiFactory")
public class Lwjgl3ify {

    public static Logger LOG = LogManager.getLogger("lwjgl3ify");

    @Mod.Instance
    public static Lwjgl3ify INSTANCE;

    @SidedProxy(
        clientSide = "me.eigenraven.lwjgl3ify.client.ClientProxy",
        serverSide = "me.eigenraven.lwjgl3ify.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        PROXY.runCompatHooks();
        LOG.info("Lwjgl3ify preInit - Java version {}", System.getProperty("java.specification.version"));

        // Test that ConfigUtils works as expected
        ConfigUtils utils = new ConfigUtils(LOG);
        if (!utils.isLwjgl3ifyLoaded()) {
            throw new IllegalStateException();
        }
        if (!utils.isConfigLoaded()) {
            throw new IllegalStateException();
        }
        if (utils.getExtensibleEnums() != Config.getExtensibleEnums()) {
            throw new IllegalStateException();
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        PROXY.registerEventHandler();
        final LaunchClassLoader loader = Launch.classLoader;
        try {
            final Field clExclusionsF = loader.getClass()
                .getDeclaredField("classLoaderExceptions");
            final Field tfExclusionsF = loader.getClass()
                .getDeclaredField("transformerExceptions");
            clExclusionsF.setAccessible(true);
            tfExclusionsF.setAccessible(true);
            @SuppressWarnings("unchecked")
            final Set<String> clExclusions = (Set<String>) clExclusionsF.get(loader);
            @SuppressWarnings("unchecked")
            final Set<String> tfExclusions = (Set<String>) tfExclusionsF.get(loader);
            final ArrayList<String> clExclusionsSorted = new ArrayList<>(clExclusions);
            clExclusionsSorted.sort(Comparator.naturalOrder());
            final ArrayList<String> tfExclusionsSorted = new ArrayList<>(tfExclusions);
            tfExclusionsSorted.sort(Comparator.naturalOrder());
            for (String exclusion : clExclusionsSorted) {
                LOG.info("LaunchClassLoader loader exclusion: {}", exclusion);
            }
            for (String exclusion : tfExclusionsSorted) {
                LOG.info("LaunchClassLoader transformer exclusion: {}", exclusion);
            }
        } catch (ReflectiveOperationException e) {
            LOG.warn(e);
        }
    }
}
