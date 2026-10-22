package me.eigenraven.lwjgl3ify.mixins.late.logistics;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import logisticspipes.gui.orderer.GuiOrderer;
import logisticspipes.gui.popup.GuiAddTracking;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = { GuiOrderer.class, GuiAddTracking.class })
public abstract class LogisticsPipesTextInput extends GuiScreen {

    @Inject(method = "initGui()V", at = @At("HEAD"))
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        TextFieldHandler.endTextInput(null);
    }
}
