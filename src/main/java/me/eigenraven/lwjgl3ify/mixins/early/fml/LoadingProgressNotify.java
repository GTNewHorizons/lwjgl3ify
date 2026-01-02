package me.eigenraven.lwjgl3ify.mixins.early.fml;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import cpw.mods.fml.common.ProgressManager;
import me.eigenraven.lwjgl3ify.client.ClientProxy;

@SuppressWarnings("deprecation")
@Mixin(value = ProgressManager.ProgressBar.class, remap = false)
public class LoadingProgressNotify {

    @Inject(at = @At("RETURN"), method = "step(Ljava/lang/String;)V")
    private void notifyLwjgl3ify(String message, CallbackInfo ci) {
        ClientProxy.onProgressUpdate();
    }
}
