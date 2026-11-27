package me.eigenraven.lwjgl3ify.mixins.late.biblio;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import jds.bibliocraft.gui.GuiBiblioTextField;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = GuiBiblioTextField.class)
public abstract class BiblioCraftTextField {

    @Inject(
        method = "textboxKeyTyped",
        at = @At(
            value = "INVOKE",
            target = "Ljds/bibliocraft/gui/GuiBiblioTextField;writeText(Ljava/lang/String;)V",
            remap = false),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lnet/minecraft/util/ChatAllowedCharacters;isAllowedCharacter(C)Z")),
        remap = false,
        cancellable = true)
    public void lwjgl3ify$fixDoubleChar(char typedChar, int keyCode, CallbackInfoReturnable<Boolean> cir) {
        // Without active text input SDL sends no text events, so the key event is the only source of the character
        if (keyCode != 0 && TextFieldHandler.isTextInputActive()) {
            cir.setReturnValue(true);
        }
    }
}
