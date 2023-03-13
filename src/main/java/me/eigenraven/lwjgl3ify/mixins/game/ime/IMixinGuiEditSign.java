package me.eigenraven.lwjgl3ify.mixins.game.ime;

import net.minecraft.client.gui.inventory.GuiEditSign;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GuiEditSign.class)
public interface IMixinGuiEditSign {

    @Accessor
    int getEditLine();
}
