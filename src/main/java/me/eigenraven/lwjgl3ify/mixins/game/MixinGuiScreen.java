package me.eigenraven.lwjgl3ify.mixins.game;

import net.minecraft.client.gui.GuiScreen;

import org.lwjglx.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen {

    @Shadow
    public void handleMouseInput() {}

    @Shadow
    protected void keyTyped(char typedChar, int keyCode) {}

    @Shadow
    public void handleKeyboardInput() {}

    @Inject(method = "handleInput()V", at = @At("HEAD"))
    private void injectHandleInput(CallbackInfo ci) {
        if (Keyboard.isCreated()) {
            while (Keyboard.InputFix_hasNextChar()) {
                this.keyTyped(Keyboard.InputFix_nextChar(), 0);
            }
        }
    }

}
