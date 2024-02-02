package me.eigenraven.lwjgl3ify.rfb;

import net.minecraft.launchwrapper.Launch;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gtnewhorizons.retrofuturabootstrap.api.PluginContext;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbPlugin;

import me.eigenraven.lwjgl3ify.rfb.transformers.ExtensibleEnumTransformer;
import me.eigenraven.lwjgl3ify.rfb.transformers.LwjglRedirectTransformer;
import me.eigenraven.lwjgl3ify.rfb.transformers.UnfinalizeObjectHoldersTransformer;

public class Lwjgl3ifyRfbPlugin implements RfbPlugin {

    @Override
    public void onConstruction(PluginContext ctx) {
        Launch.blackboard.put("lwjgl3ify:rfb-booted", Boolean.TRUE);
        EarlyConfig.load();
    }

    @Override
    public @NotNull RfbClassTransformer @Nullable [] makeTransformers() {
        return new RfbClassTransformer[] { new LwjglRedirectTransformer(), new ExtensibleEnumTransformer(),
            new UnfinalizeObjectHoldersTransformer() };
    }
}
