package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.util.MouseHelper;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.api.FloatMouseHelper;

@Mixin(MouseHelper.class)
public class MixinMouseHelper implements FloatMouseHelper {

    @Shadow
    public int deltaX;

    @Shadow
    public int deltaY;

    public float lwjgl3ify$deltaX = 0;
    public float lwjgl3ify$deltaY = 0;

    @Inject(method = "mouseXYChange", at = @At("HEAD"), cancellable = true)
    void mouseXYChange(CallbackInfo ci) {
        org.lwjglx.input.Mouse.lwjgl3ify$updateMouseHelper(this);
        ci.cancel();
    }

    @Override
    public int lwjgl3ify$getIntDX() {
        return deltaX;
    }

    @Override
    public int lwjgl3ify$getIntDY() {
        return deltaY;
    }

    @Override
    public void lwjgl3ify$setIntDX(int value) {
        deltaX = value;
    }

    @Override
    public void lwjgl3ify$setIntDY(int value) {
        deltaY = value;
    }

    @Override
    public float lwjgl3ify$getFloatDX() {
        return lwjgl3ify$deltaX;
    }

    @Override
    public float lwjgl3ify$getFloatDY() {
        return lwjgl3ify$deltaY;
    }

    @Override
    public void lwjgl3ify$setFloatDX(float value) {
        lwjgl3ify$deltaX = value;
    }

    @Override
    public void lwjgl3ify$setFloatDY(float value) {
        lwjgl3ify$deltaY = value;
    }
}
