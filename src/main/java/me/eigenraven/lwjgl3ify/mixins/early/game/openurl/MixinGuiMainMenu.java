package me.eigenraven.lwjgl3ify.mixins.early.game.openurl;

import net.minecraft.client.gui.GuiMainMenu;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ GuiMainMenu.class })
public class MixinGuiMainMenu {

    @ModifyConstant(
        method = { "Lnet/minecraft/client/gui/GuiMainMenu;confirmClicked(ZI)V" },
        constant = @Constant(stringValue = "java.awt.Desktop"),
        require = 0)
    private String lwjgl3ify$openUrlInSdl(String original) {
        return "me.eigenraven.lwjgl3ify.redirects.Desktop";
    }
}
