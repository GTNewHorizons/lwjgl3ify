package me.eigenraven.lwjgl3ify.mixins.early.game.openurl;

import net.minecraft.client.gui.GuiScreenDemo;
import net.minecraft.client.gui.GuiScreenResourcePacks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ GuiScreenDemo.class, GuiScreenResourcePacks.class })
public class MixinGuiScreenDemoResourcePacks {

    @ModifyConstant(
        method = { "actionPerformed(Lnet/minecraft/client/gui/GuiButton;)V", },
        constant = @Constant(stringValue = "java.awt.Desktop"),
        require = 0)
    private String lwjgl3ify$openUrlInSdl(String original) {
        return "me.eigenraven.lwjgl3ify.redirects.Desktop";
    }
}
