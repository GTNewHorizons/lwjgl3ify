package me.eigenraven.lwjgl3ify.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import com.gtnewhorizon.gtnhmixins.builders.IMixins;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import me.eigenraven.lwjgl3ify.mixins.Mixins;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE - 2)
public class Lwjgl3ifyCoremod implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public static final Logger LOGGER = LogManager.getLogger("lwjgl3ify");

    public Lwjgl3ifyCoremod() {
        try {
            LaunchClassLoader launchLoader = (LaunchClassLoader) getClass().getClassLoader();
            launchLoader.addClassLoaderExclusion("org.hotswap.agent");
            launchLoader.addClassLoaderExclusion("org.lwjglx.debug");
        } catch (ClassCastException e) {
            LOGGER.warn(
                "Unsupported launch class loader type " + getClass().getClassLoader()
                    .getClass(),
                e);
        }
        Config.loadConfig();
        if (Launch.blackboard.get("lwjgl3ify:rfb-booted") != Boolean.TRUE) {
            return;
        }
        LateInit.lateConstruct();
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
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

    @Override
    public String getMixinConfig() {
        return "mixins.lwjgl3ify.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        final List<String> mixins = IMixins.getEarlyMixins(Mixins.class, loadedCoreMods);
        if (FMLLaunchHandler.side()
            .isClient() && Config.MIXIN_STBI_TEXTURE_STITCHING
            && !mixins.contains("game.MixinStitcher")) {
            Lwjgl3ifyCoremod.LOGGER.error(
                "Disabled STB stitching mixins to prevent rapidly flashing screen."
                    + " Remove FastCraft or update to FastCraft 1.25 and "
                    + "add OptiFine to enable these performance-improving patches.");
        }
        return mixins;
    }
}
