package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.GuiTextFieldExt;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(GuiTextField.class)
public class MixinGuiTextField implements GuiTextFieldExt {

    @Shadow
    private boolean isFocused;

    @Shadow
    @Final
    private FontRenderer field_146211_a;

    @Shadow
    private String text;

    @Shadow
    private int lineScrollOffset;

    @Shadow
    private int cursorPosition;

    @Override
    public int lwjgl3ify$getCaretOffset() {
        final GuiTextField self = (GuiTextField) (Object) this;
        final FontRenderer font = field_146211_a != null ? field_146211_a : Minecraft.getMinecraft().fontRenderer;
        if (font == null || text == null) {
            return 0;
        }
        final int scroll = Math.max(0, Math.min(lineScrollOffset, text.length()));
        final String visible = font.trimStringToWidth(text.substring(scroll), self.getWidth());
        final int caret = Math.max(0, Math.min(cursorPosition - scroll, visible.length()));
        return font.getStringWidth(visible.substring(0, caret));
    }

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
