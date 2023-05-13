package me.eigenraven.lwjgl3ify;

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

    public static Logger LOG = LogManager.getLogger(Tags.MODID);

    @Mod.Instance
    public static Lwjgl3ify INSTANCE;

    @SidedProxy(clientSide = Tags.GROUPNAME + ".ClientProxy", serverSide = Tags.GROUPNAME + ".CommonProxy")
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
        PROXY.registerF3Handler();
    }
}
