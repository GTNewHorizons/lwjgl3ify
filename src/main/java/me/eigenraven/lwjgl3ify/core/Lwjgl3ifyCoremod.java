package me.eigenraven.lwjgl3ify.core;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

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
        if (FMLLaunchHandler.side()
            .isClient()) {
            final boolean hasFastcraft = loadedCoreMods.contains("fastcraft.Tweaker");
            final boolean hasOptifine = loadedCoreMods.contains("optifine.OptiFineForgeTweaker");
            final boolean fcBugFixedByOF = isFastcraftVersion1_25();
            final boolean fcBugTriggered = hasFastcraft && !(hasOptifine && fcBugFixedByOF);
            if (fcBugTriggered && !Config.MIXIN_STBI_IGNORE_FASTCRAFT) {
                LOGGER.error(
                    "Not using STB stitching mixins because FastCraft is installed to prevent rapidly flashing screen. Remove FastCraft or "
                        + (!fcBugFixedByOF ? "update to FastCraft 1.25 and " : "")
                        + "add OptiFine to enable these performance-improving patches.");
                Config.MIXIN_STBI_TEXTURE_STITCHING = false;
            }
        }

        return Mixins.getEarlyMixins(loadedCoreMods);
    }

    private static boolean isFastcraftVersion1_25() {
        // FastCraft tweaker hasn't run yet so no easy way to grab version.
        // Let's compare the hash of fastcraft.a, which contains the version string in both 1.23 and 1.25.
        try {
            byte[] bytes = Launch.classLoader.getClassBytes("fastcraft.a");

            if (bytes == null) return false;

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(bytes);

            final byte[] fc125AHash = new byte[] { -125, -16, 44, -79, -105, 108, -65, -19, 56, -98, -65, -94, 0, -49,
                66, -58, -60, -39, -23, 55, 87, 127, -77, 100, 73, -92, 37, 84, 115, -114, -76, -23 };

            return Arrays.equals(fc125AHash, hash);
        } catch (Exception e) {
            return false;
        }
    }
}
