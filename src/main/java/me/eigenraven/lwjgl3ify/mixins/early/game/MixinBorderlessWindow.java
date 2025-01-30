package me.eigenraven.lwjgl3ify.mixins.early.game;

import static org.lwjgl.glfw.GLFW.*;

import net.minecraft.client.Minecraft;

import org.lwjglx.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.core.Config;

@Mixin(Minecraft.class)
public class MixinBorderlessWindow {

    @Inject(method = "Lnet/minecraft/client/Minecraft;toggleFullscreen()V", at = @At("HEAD"), cancellable = true)
    public void toggleFullscreen(CallbackInfo ci) {
        if (Config.WINDOW_BORDERLESS_REPLACES_FULLSCREEN) {
            ci.cancel();

            // TODO Display.toggleBorderless();
        }
    }
}
