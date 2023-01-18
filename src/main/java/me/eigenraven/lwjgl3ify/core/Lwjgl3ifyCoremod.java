package me.eigenraven.lwjgl3ify.core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.List;
import java.util.Map;
import me.eigenraven.lwjgl3ify.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({
    "org.lwjglx",
    "org.lwjgl",
    "org.lwjgl.input",
    "org.lwjglx.input",
    "me.eigenraven.lwjgl3ify.core"
})
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE - 2)
public class Lwjgl3ifyCoremod implements IFMLLoadingPlugin {

    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);

    @Override
    public String[] getASMTransformerClass() {
        LOGGER.info("Registering lwjgl3ify redirect transformer");

        List<String> tweakClasses = GlobalProperties.get(MixinServiceLaunchWrapper.BLACKBOARD_KEY_TWEAKCLASSES);
        if (tweakClasses != null) {
            tweakClasses.add(PostMixinTransformInjector.class.getName());
        }

        return new String[] {LwjglRedirectTransformer.class.getName()};
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
