package me.eigenraven.lwjgl3ify.core;

import java.util.List;
import java.util.Map;

import me.eigenraven.lwjgl3ify.Tags;

import net.minecraft.launchwrapper.LaunchClassLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({ "org.lwjglx", "org.lwjgl", "org.lwjgl.input", "org.lwjglx.input" })
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE - 2)
public class Lwjgl3ifyCoremod implements IFMLLoadingPlugin {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    public Lwjgl3ifyCoremod() {
        Config.loadConfig();
        try {
            LaunchClassLoader launchLoader = (LaunchClassLoader) getClass().getClassLoader();
            launchLoader.addClassLoaderExclusion("javax");
        } catch (ClassCastException e) {
            LOGGER.warn("Unsupported launch class loader type " + getClass().getClassLoader().getClass(), e);
        }
        // Ensure javax.script.ScriptEngineManager gets loaded
        try {
            Class.forName("javax.script.ScriptEngineManager");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            // AWT event loop deadlocks the main thread with Lwjgl3
            System.setProperty("java.awt.headless", "true");
        }
    }

    @Override
    public String[] getASMTransformerClass() {
        LOGGER.info("Registering lwjgl3ify redirect transformer");

        List<String> tweakClasses = GlobalProperties.get(MixinServiceLaunchWrapper.BLACKBOARD_KEY_TWEAKCLASSES);
        if (tweakClasses != null) {
            tweakClasses.add(PostMixinTransformInjector.class.getName());
        }

        return new String[] { LwjglRedirectTransformer.class.getName(),
                UnfinalizeObjectHoldersTransformer.class.getName() };
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
