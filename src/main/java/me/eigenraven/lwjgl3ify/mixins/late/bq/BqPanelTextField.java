package me.eigenraven.lwjgl3ify.mixins.late.bq;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import betterquesting.api2.client.gui.controls.PanelTextField;

@Mixin(value = PanelTextField.class)
public abstract class BqPanelTextField {

    @Inject(
        method = "onKeyTyped",
        at = @At(
            value = "INVOKE",
            target = "Lbetterquesting/api2/client/gui/controls/PanelTextField;writeText(Ljava/lang/String;)V",
            remap = false),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lnet/minecraft/util/ChatAllowedCharacters;isAllowedCharacter(C)Z")),
        remap = false,
        cancellable = true)
    public void lwjgl3ify$fixDoubleChar(char typedChar, int keyCode, CallbackInfoReturnable<Boolean> cir) {
        if (keyCode != 0) {
            cir.setReturnValue(true);
        }
    }
}
