package me.eigenraven.lwjgl3ify.mixins.late.bq;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import betterquesting.api2.client.gui.GuiScreenCanvas;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = GuiScreenCanvas.class)
public abstract class BqTextInput extends GuiScreen {

    @Inject(method = "initPanel()V", at = @At("HEAD"), remap = false)
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"), remap = false)
    private void lwjgl3ify$onClose(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
