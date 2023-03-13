package me.eigenraven.lwjgl3ify.mixins.game.ime;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GuiScreen.class)
public interface IMixinGuiScreen {

    @Invoker
    void invokeKeyTyped(char typedChar, int keyCode);
}
