package me.eigenraven.lwjgl3ify.mixins.game;

import me.eigenraven.lwjgl3ify.textures.NativeBackedImage;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Mixin(TextureMap.class)
public abstract class MixinTextureMap extends AbstractTexture {
    @Redirect(method = "loadTextureAtlas", at = @At(value = "INVOKE", target = "Ljavax/imageio/ImageIO;read(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;", remap = false))
    private BufferedImage redirectImageRead(InputStream stream) {
        try {
            return NativeBackedImage.make(stream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
