package me.eigenraven.lwjgl3ify;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = "lwjgl3ify", name = "Lwjgl3ify", version = Tags.VERSION, acceptedMinecraftVersions = "[1.7.10]")
public class Lwjgl3ify {
    private static Logger LOG = LogManager.getLogger(Tags.MODID);

    public static Lwjgl3ify INSTANCE;

    // Can't use @SidedProxy because it seems to crash because of the post-mixin injection hack
    public static CommonProxy PROXY;

    public Lwjgl3ify() {
        INSTANCE = this;
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (FMLCommonHandler.instance().getSide().isClient()) {
            PROXY = new ClientProxy();
        } else {
            PROXY = new CommonProxy();
        }
        PROXY.registerF3Handler();
    }
}
