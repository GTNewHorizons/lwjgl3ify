package me.eigenraven.lwjgl3ify.mixins.late.biblio;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import jds.bibliocraft.gui.GuiClipboard;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = GuiClipboard.class)
public class BiblioCraftClipboard {

    @Inject(method = "initGui()V", at = @At("HEAD"))
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"))
    private void lwjgl3ify$onClosed(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
