package me.eigenraven.lwjgl3ify.mixins.early.oc;

import org.lwjglx.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/// InputBuffer$class is public and could be specified directly, but doing so causes IDEA's linter to implode.
/// TODO undo this whenever that bug is fixed
@SuppressWarnings("UnusedMixin")
@Mixin(remap = false, targets = { "li.cil.oc.client.gui.traits.InputBuffer$class" })
public class OcInputBuffer {

    @Redirect(
        method = "handleKeyboardInput",
        at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;getEventKey()I"),
        expect = -1)
    private static int useLwjgl3ifyNonScancodeKeycodeForKeyboardInput() {
        return Keyboard.lwjgl3ify$getEventKeyNonScancode();
    }
}
