package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import me.eigenraven.lwjgl3ify.api.FloatMouseHelper;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {

    @Shadow
    private Minecraft mc;

    @Definition(id = "intX", field = "Lnet/minecraft/util/MouseHelper;deltaX:I")
    @Expression("(float)?.intX")
    @ModifyExpressionValue(method = "updateCameraAndRender", at = @At("MIXINEXTRAS:EXPRESSION"))
    float useFloatingX(float original) {
        return ((FloatMouseHelper) this.mc.mouseHelper).lwjgl3ify$getFloatDX();
    }

    @Definition(id = "intY", field = "Lnet/minecraft/util/MouseHelper;deltaY:I")
    @Expression("(float)?.intY")
    @ModifyExpressionValue(method = "updateCameraAndRender", at = @At("MIXINEXTRAS:EXPRESSION"))
    float useFloatingY(float original) {
        return ((FloatMouseHelper) this.mc.mouseHelper).lwjgl3ify$getFloatDY();
    }
}
