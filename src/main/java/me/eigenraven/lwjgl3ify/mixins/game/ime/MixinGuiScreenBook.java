package me.eigenraven.lwjgl3ify.mixins.game.ime;

import javax.swing.*;

import me.eigenraven.lwjgl3ify.client.ime.ICursorProvider;
import me.eigenraven.lwjgl3ify.client.ime.IMEHelper;
import me.eigenraven.lwjgl3ify.client.ime.IMEWrapperBook;
import me.eigenraven.lwjgl3ify.client.ime.ISetPageable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.util.EnumChatFormatting;

import org.lwjglx.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreenBook.class)
public class MixinGuiScreenBook extends GuiScreen implements ISetPageable {

    @Shadow
    private boolean bookIsUnsigned;

    /**
     * pageGetCurrent
     * 
     * @return String of current page
     */
    @Shadow
    private String func_146456_p() {
        return "";
    }

    /**
     * pageSetCurrent
     * 
     * @param p_146457_1_ String to set
     */
    @Shadow
    private void func_146457_a(String p_146457_1_) {}

    @Inject(method = "initGui", at = @At("HEAD"))
    private void initWrapper(CallbackInfo ci) {
        if (bookIsUnsigned) {
            IMEWrapperBook.instance.setBookGui((GuiScreenBook) (Object) this);
            IMEWrapperBook.instance.setText(func_146456_p());
            IMEWrapperBook.instance.setVisible(true);
            this.func_146457_a(this.func_146456_p());
        }
    }

    @Inject(method = "onGuiClosed", at = @At("RETURN"))
    private void closeWrapper(CallbackInfo ci) {
        IMEWrapperBook.instance.setVisible(false);
    }

    @Inject(
            method = "actionPerformed",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiScreenBook;updateButtons()V"))
    private void updateJTextToCurrent(CallbackInfo ci) {
        IMEWrapperBook.instance.setText(func_146456_p());
    }

    @Inject(
            method = "func_146457_a",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/GuiScreenBook;field_146481_r:Z"))
    private void updateCursorLocation(CallbackInfo ci) {
        Minecraft.getMinecraft()
                .func_152344_a(
                        () -> SwingUtilities.invokeLater(
                                () -> IMEWrapperBook.instance.setLocation(
                                        Display.getX() + Display.getWidth() / 2
                                                + IMEHelper.getFactor()
                                                        * (((ICursorProvider) fontRendererObj).getLastX() - 64),
                                        Display.getY() + IMEHelper.getFactor()
                                                * (((ICursorProvider) fontRendererObj).getLastY() + 30))));
    }

    @Override
    public boolean canPageSet(String s) {
        int i = this.fontRendererObj.splitStringWidth(s + "" + EnumChatFormatting.BLACK + "_", 118);
        return i <= 118 && s.length() < 256;
    }
}
