package me.eigenraven.lwjgl3ify;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "lwjgl3ify",
        name = "Lwjgl3ify",
        version = Tags.VERSION,
        acceptedMinecraftVersions = "[1.7.10]",
        acceptableRemoteVersions = "*")
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
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        PROXY.registerF3Handler();
    }
}
