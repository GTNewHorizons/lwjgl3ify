package me.eigenraven.lwjgl3ify.core;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.asm.transformers.EventSubscriptionTransformer;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

/**
 * Mixins inject themselves at the end of the asm transformer chain in the class loader via a ITweaker hack, we do the same for compatibility because lwjgl3ify has to run after mixins.
 * @see org.spongepowered.asm.mixin.EnvironmentStateTweaker
 * @see org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper
 */
public class PostMixinTransformInjector implements ITweaker {
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        // no-op
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        try {
            // Wrap EventSubscriptionTransformer
            final Field transformersF = classLoader.getClass().getDeclaredField("transformers");
            transformersF.setAccessible(true);
            final List<IClassTransformer> transformers = (List<IClassTransformer>) transformersF.get(classLoader);

            final AtomicInteger replaces = new AtomicInteger();
            transformers.replaceAll(tf -> {
                if (tf instanceof EventSubscriptionTransformer) {
                    replaces.getAndIncrement();
                    return new EventSubscriptionTransformerFixer();
                } else {
                    return tf;
                }
            });
            Lwjgl3ifyCoremod.LOGGER.info("Replaced {} transformers with more compatible variants", replaces.get());
        } catch (Throwable e) {
            Throwables.propagate(e);
        }
    }

    @Override
    public String getLaunchTarget() {
        // no-op
        return null;
    }

    @Override
    public String[] getLaunchArguments() {
        // Here we can inject ourselves
        Launch.classLoader.registerTransformer(LwjglRedirectTransformer.class.getName());
        return new String[0];
    }
}
