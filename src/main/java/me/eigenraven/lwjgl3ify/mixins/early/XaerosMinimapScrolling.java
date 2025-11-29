package me.eigenraven.lwjgl3ify.mixins.early;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import xaero.common.gui.GuiAddWaypoint;
import xaero.common.gui.GuiEntityRadar;
import xaero.common.gui.GuiTransfer;
import xaero.common.gui.GuiWaypoints;

@Mixin(remap = false, value = { GuiAddWaypoint.class, GuiEntityRadar.class, GuiTransfer.class, GuiWaypoints.class })
public class XaerosMinimapScrolling {

    @Redirect(
        method = "handleMouseInput",
        at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Mouse;getEventDWheel()I"))
    private int lwjgl3ify$rescaledGetEventDWheel() {
        return org.lwjglx.input.Mouse.getEventDWheel() * 120;
    }
}
