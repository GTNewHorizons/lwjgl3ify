package me.eigenraven.lwjgl3ify.mixins.late.xaeros;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import xaero.map.gui.GuiMap;

@Mixin(value = { GuiMap.class })
public class XaerosWorldmapScrolling {

    // Optional because an old hodgepodge patch might also do the same
    @ModifyConstant(method = "handleMouseInput", constant = @Constant(intValue = 120), expect = -1)
    private int lwjgl3ify$rescaledGetEventDWheel(int original) {
        return 1;
    }
}
