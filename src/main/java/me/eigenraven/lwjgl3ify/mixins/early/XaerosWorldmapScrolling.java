package me.eigenraven.lwjgl3ify.mixins.early;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import xaero.map.gui.GuiMap;

@Mixin(remap = false, value = { GuiMap.class })
public class XaerosWorldmapScrolling {

    @Redirect(
        method = "handleMouseInput",
        at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Mouse;getEventDWheel()I"))
    private int lwjgl3ify$rescaledGetEventDWheel() {
        return org.lwjglx.input.Mouse.getEventDWheel() * 120;
    }
}
