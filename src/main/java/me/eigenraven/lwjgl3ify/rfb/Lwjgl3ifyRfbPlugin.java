package me.eigenraven.lwjgl3ify.rfb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gtnewhorizons.retrofuturabootstrap.api.PluginContext;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbPlugin;

public class Lwjgl3ifyRfbPlugin implements RfbPlugin {

    @Override
    public void onConstruction(PluginContext ctx) {
        EarlyConfig.load();
    }

    @Override
    public @NotNull RfbClassTransformer @Nullable [] makeTransformers() {
        return new RfbClassTransformer[] { new LwjglRedirectTransformer(), new ExtensibleEnumTransformer(),
            new UnfinalizeObjectHoldersTransformer() };
    }
}
