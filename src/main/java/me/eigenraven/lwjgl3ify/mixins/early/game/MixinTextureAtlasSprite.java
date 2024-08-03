package me.eigenraven.lwjgl3ify.mixins.early.game;

import java.awt.image.BufferedImage;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.data.AnimationMetadataSection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TextureAtlasSprite.class)
public class MixinTextureAtlasSprite {

    @Inject(method = "loadSprite", at = @At("TAIL"))
    void cleanupAfterLoadSprite(BufferedImage[] frames, AnimationMetadataSection aniData, boolean anisotropicFiltering,
        CallbackInfo info) {
        for (BufferedImage img : frames) {
            // Close any NativeBackedImage instances
            if (img instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) img).close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
