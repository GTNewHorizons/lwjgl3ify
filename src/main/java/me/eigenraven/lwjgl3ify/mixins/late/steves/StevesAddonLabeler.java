package me.eigenraven.lwjgl3ify.mixins.late.steves;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;
import stevesaddons.interfaces.GuiLabeler;

@Mixin(value = GuiLabeler.class)
public class StevesAddonLabeler {

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
        at = @At(value = "INVOKE", target = "Lstevesaddons/interfaces/GuiTextField;keyTyped(CI)V", remap = false),
        cancellable = true)
    private void lwjgl3ify$fixDoubleChar(char character, int keyCode, CallbackInfo ci) {
        if (Character.isLetterOrDigit(character) && keyCode != 0) {
            ci.cancel();
        }
    }
}
