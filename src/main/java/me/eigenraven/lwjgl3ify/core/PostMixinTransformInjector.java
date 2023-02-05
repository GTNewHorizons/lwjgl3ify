package me.eigenraven.lwjgl3ify.core;

import java.io.File;
import java.util.List;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

/**
 * Mixins inject themselves at the end of the asm transformer chain in the class loader via a ITweaker hack, we do the
 * same for compatibility because lwjgl3ify has to run after mixins.
 * 
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
        // no-op
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
