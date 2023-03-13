package me.eigenraven.lwjgl3ify.mixins.game.ime;

import javax.swing.*;

import me.eigenraven.lwjgl3ify.client.ime.IMEHelper;
import me.eigenraven.lwjgl3ify.client.ime.IMEWrapperSign;

import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;

import org.lwjglx.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiEditSign.class)
public class MixinGuiEditSign {

    @Shadow
    private int editLine;
    private int imeLine = -1;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void setSign(TileEntitySign p_i1097_1_, CallbackInfo ci) {
        IMEWrapperSign.instance.setSign((GuiEditSign) (Object) this, p_i1097_1_);
    }

    @Inject(method = "initGui", at = @At("RETURN"))
    private void initWrapper(CallbackInfo ci) {
        IMEWrapperSign.instance.setVisible(true);
        SwingUtilities.invokeLater(
                () -> IMEWrapperSign.instance.setLocation(
                        Display.getX() + Display.getWidth() / 2,
                        Display.getY() + (80) * IMEHelper.getFactor()));
    }

    @Inject(method = "onGuiClosed", at = @At("RETURN"))
    private void cleanWrapper(CallbackInfo ci) {
        IMEWrapperSign.instance.setVisible(false);
        SwingUtilities.invokeLater(() -> IMEWrapperSign.instance.getTextField().setText(""));
    }

    @Inject(method = "keyTyped", at = @At("RETURN"))
    private void handleLineSwitch(char typedChar, int keyCode, CallbackInfo ci) {
        if (imeLine != editLine) {
            imeLine = editLine;
            SwingUtilities.invokeLater(
                    () -> IMEWrapperSign.instance.setLocation(
                            Display.getX() + Display.getWidth() / 2,
                            Display.getY() + (imeLine * 10 + 80) * IMEHelper.getFactor()));
        }
    }
}
