package me.eigenraven.lwjgl3ify.mixins.game.ime;

import javax.swing.*;

import me.eigenraven.lwjgl3ify.client.ime.IControableTextField;
import me.eigenraven.lwjgl3ify.client.ime.IMEHelper;
import me.eigenraven.lwjgl3ify.client.ime.IMEWrapperTextField;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import org.lwjglx.opengl.Display;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(GuiTextField.class)
public class MixinGuiTextField implements IControableTextField {

    @Shadow
    private FontRenderer field_146211_a;
    private int imeX = 0, imeY = 0;
    @Shadow
    private String text;
    @Shadow
    private int maxStringLength;
    @Shadow
    private int cursorPosition;

    @Shadow
    public void setCursorPositionEnd() {}

    @Shadow
    public void setSelectionPos(int p_146199_1_) {}

    @Shadow
    public boolean getVisible() {
        return false;
    }

    @Inject(
            method = "setText",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiTextField;setCursorPositionEnd()V"))
    private void updateJText(String p_146180_1_, CallbackInfo ci) {
        IMEWrapperTextField.instance.setText(this.text);
    }

    @Inject(
            method = "writeText",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiTextField;moveCursorBy(I)V"))
    private void updateJText2(String p_146191_1_, CallbackInfo ci) {
        IMEWrapperTextField.instance.setText(this.text);
    }

    @Inject(
            method = "deleteFromCursor",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/gui/GuiTextField;text:Ljava/lang/String;",
                    opcode = Opcodes.PUTFIELD),
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private void updateJText3(int p_146175_1_, CallbackInfo ci, boolean flag, int j, int k, String s) {
        IMEWrapperTextField.instance.setText(s);
    }

    @Inject(method = "setMaxStringLength", at = @At("RETURN"))
    private void updateJText4(int p_146203_1_, CallbackInfo ci) {
        if (text.length() > p_146203_1_) {
            IMEWrapperTextField.instance.setText(this.text);
        }
    }

    @Inject(method = "setFocused", at = @At("RETURN"))
    private void handleFocus(boolean p_146195_1_, CallbackInfo ci) {
        IMEWrapperTextField.instance.setGuiTextField((GuiTextField) (Object) this);
        if (p_146195_1_ && !IMEWrapperTextField.instance.isVisible()) {
            IMEWrapperTextField.instance.setVisible(true);
            IMEWrapperTextField.instance.setText(text);
        } else if (!p_146195_1_ && IMEWrapperTextField.instance.isVisible()) {
            IMEWrapperTextField.instance.setVisible(false);
        }
    }

    @Inject(
            method = "drawTextBox",
            at = @At(value = "JUMP", opcode = Opcodes.IFNE),
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private void updateWrapperLocation(CallbackInfo ci, int i, int j, int k, String s, boolean flag, boolean flag1,
            int l, int i1, int j1, boolean flag2, int k1) {
        if (imeX != k1 + 1 || imeY != i1 + this.field_146211_a.FONT_HEIGHT - 2) {
            imeX = k1 + 1;
            imeY = i1 + this.field_146211_a.FONT_HEIGHT - 2;
            updateWrapperLocation();
        }
    }

    @Override
    public void setTextNoSync(String textIn) {
        if (textIn.length() > this.maxStringLength) {
            this.text = textIn.substring(0, this.maxStringLength);
        } else {
            this.text = textIn;
        }
        this.setCursorPositionEnd();
    }

    @Override
    public void setCursorPositionNoSync(int pos) {
        this.cursorPosition = pos;
    }

    @Override
    public void setSelection(int cursor, int end) {
        setCursorPositionNoSync(cursor);
        setSelectionPos(end);
    }

    private void updateWrapperLocation() {
        SwingUtilities.invokeLater(() -> {
            IMEWrapperTextField.instance.getTextField().moveCaretPosition(this.cursorPosition);
            GuiScreen s = Minecraft.getMinecraft().currentScreen;
            if (imeY == 0 || s == null) {
                IMEWrapperTextField.instance.setLocation(Display.getX(), Display.getY() + Display.getHeight());
                return;
            }
            int f = IMEHelper.getFactor();
            IMEWrapperTextField.instance.setLocation(Display.getX() + imeX * f, Display.getY() + imeY * f);
        });
    }
}
