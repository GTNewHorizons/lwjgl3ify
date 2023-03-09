package me.eigenraven.lwjgl3ify.mixins.game.ime;

import net.minecraft.client.gui.GuiScreenBook;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GuiScreenBook.class)
public interface IMixinGuiScreenBook {

    @Invoker
    void invokeFunc_146457_a(String p_146457_1_);
}
