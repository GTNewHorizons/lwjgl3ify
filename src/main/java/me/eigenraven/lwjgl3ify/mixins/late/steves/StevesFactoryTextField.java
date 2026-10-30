package me.eigenraven.lwjgl3ify.mixins.late.steves;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import vswe.stevesfactory.components.TextBoxLogic;
import vswe.stevesfactory.interfaces.GuiManager;

@Mixin(value = TextBoxLogic.class)
public abstract class StevesFactoryTextField {

    @Inject(
        method = "onKeyStroke",
        at = @At(
            value = "INVOKE",
            target = "Lvswe/stevesfactory/components/TextBoxLogic;addText(Lvswe/stevesfactory/interfaces/GuiManager;Ljava/lang/String;)V",
            remap = false),
        slice = @Slice(from = @At(value = "INVOKE", target = "Ljava/lang/Character;isISOControl(C)Z")),
        remap = false,
        cancellable = true)
    public void lwjgl3ify$fixDoubleChar(GuiManager gui, char c, int k, CallbackInfo ci) {
        if (k != 0) {
            ci.cancel();
        }
    }
}
