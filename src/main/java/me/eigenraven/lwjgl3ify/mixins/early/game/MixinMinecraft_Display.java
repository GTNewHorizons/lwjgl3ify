package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(Minecraft.class)
public class MixinMinecraft_Display {

    @ModifyExpressionValue(
        method = "func_147120_f",
        at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;fullscreen:Z"))
    private boolean lwjgl3ify$alwaysUpdateScreenSize(boolean wasFullscreen) {
        // This is negated in the original code, return false to always pass the first half of the if check
        return false;
    }
}
