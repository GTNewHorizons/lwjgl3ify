package me.eigenraven.lwjgl3ify.mixins.game;

import net.minecraft.client.gui.GuiScreen;

import org.lwjglx.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import com.github.wohaopa.InputFix;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen {

    @Shadow
    public void handleMouseInput() {}

    @Shadow
    protected void keyTyped(char typedChar, int keyCode) {}

    @Shadow
    public void handleKeyboardInput() {}

    @Inject(method = "handleInput", at = @At("HEAD"))
    private void injectHandleInput() {
        if (Keyboard.isCreated()) {
            while (InputFix.hasNextChar()) {
                this.keyTyped(InputFix.nextChar(), 0);
            }
        }
    }

}
