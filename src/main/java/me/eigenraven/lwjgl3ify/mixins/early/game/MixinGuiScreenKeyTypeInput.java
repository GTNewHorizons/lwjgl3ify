package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreenKeyTypeInput {

    @Shadow
    protected abstract void keyTyped(char c, int keycode);

    @Inject(method = "handleKeyboardInput", at = @At("HEAD"), cancellable = true)
    private void lwjgl3ify$handleKeyboardInput(CallbackInfo ci) {
        if (Keyboard.getEventKeyState()) {
            int codepoint = org.lwjglx.input.Keyboard.getEventCodePoint();
            int keycode = Keyboard.getEventKey();
            char[] chars = Character.toChars(codepoint);
            for (char c : chars) {
                keyTyped(c, keycode);
            }
        }
        Minecraft.getMinecraft()
            .func_152348_aa();
        ci.cancel();
    }
}
