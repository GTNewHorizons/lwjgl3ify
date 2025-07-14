package me.eigenraven.lwjgl3ify.mixins;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.builders.ITargetMod;
import com.gtnewhorizon.gtnhmixins.builders.TargetModBuilder;

public enum TargetedMod implements ITargetMod {

    FASTCRAFT("fastcraft.Tweaker", null, "fastcraft.Tweaker"),
    OPTIFINE("optifine.OptiFineForgeTweaker", "Optifine", null);

    /** Class that implements the IFMLLoadingPlugin interface */
    public final String coreModClass;
    private final TargetModBuilder builder;

    TargetedMod(String coreModClass, String modId, String targetClass) {
        this.coreModClass = coreModClass;
        this.builder = new TargetModBuilder().setCoreModClass(coreModClass)
            .setModId(modId)
            .setTargetClass(targetClass);
    }

    @NotNull
    @Override
    public TargetModBuilder getBuilder() {
        return builder;
    }
}
