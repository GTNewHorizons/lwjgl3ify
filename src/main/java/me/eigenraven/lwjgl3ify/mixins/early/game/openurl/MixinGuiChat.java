package me.eigenraven.lwjgl3ify.mixins.early.game.openurl;

import net.minecraft.client.gui.GuiChat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ GuiChat.class })
public class MixinGuiChat {

    @ModifyConstant(
        method = { "Lnet/minecraft/client/gui/GuiChat;func_146407_a(Ljava/net/URI;)V" },
        constant = @Constant(stringValue = "java.awt.Desktop"),
        require = 0)
    private String lwjgl3ify$openUrlInSdl(String original) {
        return "me.eigenraven.lwjgl3ify.redirects.Desktop";
    }
}
