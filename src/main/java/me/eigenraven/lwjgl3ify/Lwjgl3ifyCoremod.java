package me.eigenraven.lwjgl3ify;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({"org.lwjglx", "org.lwjgl", "me.eigenraven.lwjgl3ify"})
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE - 2)
public class Lwjgl3ifyCoremod implements IFMLLoadingPlugin {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    @Override
    public String[] getASMTransformerClass() {
        LOGGER.info("Registering lwjgl3ify redirect transformer");
        return new String[] {"me.eigenraven.lwjgl3ify.LwjglRedirectTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
