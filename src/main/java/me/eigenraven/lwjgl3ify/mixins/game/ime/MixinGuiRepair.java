package me.eigenraven.lwjgl3ify.mixins.game.ime;

import me.eigenraven.lwjgl3ify.client.ime.IMEWrapperTextField;

import net.minecraft.client.gui.GuiRepair;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiRepair.class)
public class MixinGuiRepair {

    @Shadow
    private void func_147090_g() {}

    @Inject(method = "initGui", at = @At("RETURN"))
    private void setUpdater(CallbackInfo ci) {
        IMEWrapperTextField.instance.updater = gui -> ((MixinGuiRepair) (Object) gui).func_147090_g();
    }
}
