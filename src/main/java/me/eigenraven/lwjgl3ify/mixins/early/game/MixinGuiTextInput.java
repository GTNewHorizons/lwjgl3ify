package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiEditSign;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin({ GuiEditSign.class, GuiScreenBook.class })
public abstract class MixinGuiTextInput extends GuiScreen {

    @Inject(method = "initGui()V", at = @At("HEAD"))
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"))
    private void lwjgl3ify$onClose(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
