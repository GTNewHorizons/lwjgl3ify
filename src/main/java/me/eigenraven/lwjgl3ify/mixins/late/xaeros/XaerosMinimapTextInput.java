package me.eigenraven.lwjgl3ify.mixins.late.xaeros;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;
import xaero.common.gui.GuiAddWaypoint;
import xaero.common.gui.GuiEntityRadar;
import xaero.common.gui.GuiTransfer;
import xaero.common.gui.GuiWaypoints;

@Mixin(value = { GuiEntityRadar.class, GuiTransfer.class, GuiWaypoints.class, GuiAddWaypoint.class })
public abstract class XaerosMinimapTextInput extends GuiScreen {

    // Ensure "initGui" exists in the target class
    @Unique
    @Override
    public void initGui() {}

    // Ensure "onGuiClosed" exists in the target class
    @Unique
    @Override
    public void onGuiClosed() {}

    @Inject(method = "initGui()V", at = @At("HEAD"))
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"))
    public void lwjgl3ify$onGuiClosed(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
