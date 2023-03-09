package me.eigenraven.lwjgl3ify.mixins.game.ime;

import me.eigenraven.lwjgl3ify.client.ime.IMEHelper;
import me.eigenraven.lwjgl3ify.client.ime.IMEWrapperTextField;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow
    public GuiScreen currentScreen;

    @Inject(
            method = "displayGuiScreen",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraftforge/client/event/GuiOpenEvent;gui:Lnet/minecraft/client/gui/GuiScreen;",
                    opcode = Opcodes.GETFIELD))
    private void screenSwitchingHook(GuiScreen guiScreenIn, CallbackInfo ci) {
        IMEWrapperTextField.instance.setVisible(false);
        IMEWrapperTextField.instance.updater = gui -> {};
    }

    @Inject(method = "resize", at = @At(value = "RETURN"))
    private void updateResolution(int width, int height, CallbackInfo ci) {
        if (this.currentScreen != null) {
            IMEHelper.scaledResolution = new ScaledResolution((Minecraft) (Object) this, width, height);
        }
    }
}
