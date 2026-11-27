package me.eigenraven.lwjgl3ify.mixins.late.logistics;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import logisticspipes.utils.gui.SearchBar;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(value = SearchBar.class)
public abstract class LogisticsPipesTextField {

    @Inject(
        method = "handleKey",
        at = @At(value = "INVOKE", target = "Ljava/lang/Character;isISOControl(C)Z"),
        remap = false,
        cancellable = true)
    public void lwjgl3ify$fixDoubleChar(char typedChar, int keyCode, CallbackInfoReturnable<Boolean> cir) {
        // Without active text input SDL sends no text events, so the key event is the only source of the character
        if (keyCode != 0 && TextFieldHandler.isTextInputActive()) {
            cir.setReturnValue(true);
        }
    }
}
