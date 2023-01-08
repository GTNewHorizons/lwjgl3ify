package me.eigenraven.lwjgl3ify;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "lwjgl3ify", name = "Lwjgl3ify", version = Tags.VERSION, acceptedMinecraftVersions = "[1.7.10]")
public class Lwjgl3ify {
    private static Logger LOG = LogManager.getLogger(Tags.MODID);

    @Mod.Instance
    public static Lwjgl3ify INSTANCE;

    @SidedProxy(clientSide = Tags.GROUPNAME + ".ClientProxy", serverSide = Tags.GROUPNAME + ".CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) {
        LOG.info("LWJGL3ify reached the preinit stage");
        PROXY.registerF3Handler();
    }
}
