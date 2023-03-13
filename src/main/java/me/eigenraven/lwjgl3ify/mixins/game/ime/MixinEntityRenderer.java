package me.eigenraven.lwjgl3ify.mixins.game.ime;

import me.eigenraven.lwjgl3ify.client.ime.IMEHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

import org.lwjglx.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {

    private boolean prevActive = true;

    @Inject(method = "updateCameraAndRender", at = @At(value = "HEAD"))
    private void preventWrapperLostFocus(float p_78480_1_, CallbackInfo ci) {
        boolean flag2 = Display.isActive();
        if (!prevActive && flag2) {
            IMEHelper.keepWrapperFocused();
        }
        prevActive = flag2;
    }

    @Redirect(
            method = "updateCameraAndRender",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;displayInGameMenu()V"))
    private void addIMECheck(Minecraft instance) {
        if (!(Display.isVisible() && IMEHelper.isAnyWrapperVisible())) {
            instance.displayInGameMenu();
        }
    }
}
