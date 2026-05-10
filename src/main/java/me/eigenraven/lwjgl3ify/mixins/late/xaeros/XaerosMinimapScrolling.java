package me.eigenraven.lwjgl3ify.mixins.late.xaeros;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;
import xaero.common.gui.GuiAddWaypoint;
import xaero.common.gui.GuiEntityRadar;
import xaero.common.gui.GuiTransfer;
import xaero.common.gui.GuiWaypoints;

@Mixin(value = { GuiAddWaypoint.class, GuiEntityRadar.class, GuiTransfer.class, GuiWaypoints.class })
public class XaerosMinimapScrolling {

    // Optional because an old hodgepodge patch might also do the same
    @ModifyConstant(method = "handleMouseInput", constant = @Constant(intValue = 120), expect = -1)
    private int lwjgl3ify$rescaledGetEventDWheel(int original) {
        return 1;
    }

    @Inject(method = "initGui()V", at = @At("HEAD"), remap = false)
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Inject(method = "onGuiClosed()V", at = @At("HEAD"), remap = false)
    private void lwjgl3ify$onClose(CallbackInfo ci) {
        TextFieldHandler.endTextInput(null);
    }
}
