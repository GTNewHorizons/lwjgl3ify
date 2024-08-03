package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.Minecraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

/**
 * Use raw key events for keybind handling to handle dead keys, etc.
 */
@Mixin(Minecraft.class)
public class MixinMinecraftKeyBinding {

    @Redirect(
        method = "runTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;setKeyBindState(IZ)V"),
        slice = @Slice(from = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;next()Z", remap = false)))
    private void lwjgl3ify$noKeybindUpdateHere(int eventKey, boolean eventKeyState) {
        // Disable, handled in the client proxy
    }

    @Redirect(
        method = "runTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/settings/KeyBinding;onTick(I)V"),
        slice = @Slice(from = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Keyboard;next()Z", remap = false)))
    private void lwjgl3ify$noKeybindTickHere(int eventKey) {
        // Disable, handled in the client proxy
    }
}
