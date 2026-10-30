package me.eigenraven.lwjgl3ify.mixins.late.etfuturum;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ganymedes01.etfuturum.client.gui.inventory.GuiEditWoodSign;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = GuiEditWoodSign.class)
public class EtfuturumWoodSign {

    @Inject(method = "initGui()V", at = @At("HEAD"))
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"))
    private void lwjgl3ify$onClosed(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }

    @Inject(
        method = "keyTyped",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ChatAllowedCharacters;isAllowedCharacter(C)Z"),
        cancellable = true)
    private void lwjgl3ify$fixDoubleChar(char typedChar, int keyCode, CallbackInfo ci) {
        if (keyCode != 0) {
            ci.cancel();
        }
    }
}
