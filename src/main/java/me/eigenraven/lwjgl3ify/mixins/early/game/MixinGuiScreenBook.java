package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.util.ChatAllowedCharacters;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(GuiScreenBook.class)
public class MixinGuiScreenBook implements InputEvents.KeyboardListener {

    @Shadow
    private void func_146459_b(String p_146459_1_) {}

    @Inject(method = "initGui", at = @At("HEAD"))
    private void lwjgl3ify$onOpen(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed", at = @At("HEAD"))
    private void lwjgl3ify$onClose(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }

    @Redirect(
        method = "keyTypedInBook",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ChatAllowedCharacters;isAllowedCharacter(C)Z"))
    private boolean lwjgl3ify$denyStandardTextInput(char character) {
        // Inject queued IME text input
        return false;
    }

    @Override
    public void onTextEvent(InputEvents.TextEvent event) {
        final String toAppend = event.text;
        if (!event.text.chars()
            .allMatch(chr -> ChatAllowedCharacters.isAllowedCharacter((char) chr))) {
            return;
        }
        func_146459_b(toAppend);
    }
}
