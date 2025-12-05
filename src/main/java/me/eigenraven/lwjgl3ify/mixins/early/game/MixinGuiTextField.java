package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.gui.GuiTextField;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(GuiTextField.class)
public class MixinGuiTextField {

    @Shadow
    private boolean isFocused;

    @Inject(method = "setFocused", at = @At("HEAD"))
    private void lwjgl3ify$onFocusChange(boolean nowFocused, CallbackInfo ci) {
        final GuiTextField self = (GuiTextField) (Object) this;
        final boolean wasFocused = isFocused;
        if (nowFocused) {
            TextFieldHandler.setFocusedTextField(self);
        }
        if (nowFocused == wasFocused) {
            return;
        }
        if (nowFocused) {
            TextFieldHandler.beginTextInput();
        } else {
            TextFieldHandler.endTextInput(self);
        }
    }

    @Redirect(
        method = "textboxKeyTyped",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiTextField;writeText(Ljava/lang/String;)V"),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lnet/minecraft/util/ChatAllowedCharacters;isAllowedCharacter(C)Z")))
    private void lwjgl3ify$denyStandardTextInput(GuiTextField instance, String s) {
        // Inject queued IME text input
        final GuiTextField self = (GuiTextField) (Object) this;
        self.writeText(TextFieldHandler.textBuffer.toString());
        TextFieldHandler.textBuffer.delete(0, TextFieldHandler.textBuffer.length());
    }
}
