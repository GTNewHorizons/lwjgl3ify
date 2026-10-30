package me.eigenraven.lwjgl3ify.mixins.late.steves;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;
import vswe.stevesfactory.interfaces.GuiManager;

@Mixin(value = GuiManager.class)
public abstract class StevesFactoryManager extends GuiScreen {

    @Override
    public void initGui() {
        super.initGui();
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"))
    private void lwjgl3ify$onClosed(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
