package me.eigenraven.lwjgl3ify.mixins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import me.eigenraven.lwjgl3ify.core.Config;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

// TODO: have someone who knows what they're doing rewrite these descriptions
public enum Mixins {

    // client and server FML Java 9+ compatibility patches
    FORGE_JAVA9(new Builder("FML Java 9+ compatibility patch").addTargetedMod(TargetedMod.VANILLA)
        .setSide(Side.BOTH)
        .setPhase(Phase.EARLY)
        .addMixinClasses(
            "fml.ItemStackHolderRef",
            "fml.JarDiscoverer",
            "fml.ObjectHolderRef",
            "fml.ObjectHolderRegistry")
        .setApplyIf(() -> true)),

    // client only
    FIX_DEADKEY_KEYBINDING(
        new Builder("Improved KeyBinding handling to handle dead keys").addTargetedMod(TargetedMod.VANILLA)
            .setSide(Side.CLIENT)
            .setPhase(Phase.EARLY)
            .addMixinClasses("game.MixinMinecraftKeyBinding")
            .setApplyIf(() -> true)),
    BORDERLESS_FULLSCREEN(new Builder("Adds the borderless mode").addTargetedMod(TargetedMod.VANILLA)
        .setSide(Side.CLIENT)
        .setPhase(Phase.EARLY)
        .addMixinClasses("game.MixinBorderlessWindow")
        .setApplyIf(() -> true)),
    STB_LOADING(new Builder("STB texture loading mixin").addTargetedMod(TargetedMod.VANILLA)
        .setSide(Side.CLIENT)
        .setPhase(Phase.EARLY)
        .addMixinClasses("game.MixinTextureAtlasSprite", "game.MixinTextureMap")
        .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_LOADING)),

    // the config is disabled in the coremod if the fastcraft bug is triggered
    STB_STITCHING(new Builder("STB texture stitching mixin").addTargetedMod(TargetedMod.VANILLA)
        .setSide(Side.CLIENT)
        .setPhase(Phase.EARLY)
        .addMixinClasses("game.MixinStitcher")
        .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_STITCHING));

    private final List<String> mixinClasses;
    private final List<TargetedMod> targetedMods;
    private final List<TargetedMod> excludedMods;
    private final Supplier<Boolean> applyIf;
    private final Phase phase;
    private final Side side;

    Mixins(Builder builder) {
        this.mixinClasses = builder.mixinClasses;
        this.targetedMods = builder.targetedMods;
        this.excludedMods = builder.excludedMods;
        this.applyIf = builder.applyIf;
        this.phase = builder.phase;
        this.side = builder.side;
        if (this.mixinClasses.isEmpty()) {
            throw new RuntimeException("No mixin class specified for Mixin : " + this.name());
        }
        if (this.targetedMods.isEmpty()) {
            throw new RuntimeException("No targeted mods specified for Mixin : " + this.name());
        }
        if (this.applyIf == null) {
            throw new RuntimeException("No ApplyIf function specified for Mixin : " + this.name());
        }
        if (this.phase == null) {
            throw new RuntimeException("No Phase specified for Mixin : " + this.name());
        }
        if (this.side == null) {
            throw new RuntimeException("No Side function specified for Mixin : " + this.name());
        }
    }

    public static List<String> getEarlyMixins(Set<String> loadedCoreMods) {
        final List<String> mixins = new ArrayList<>();
        final List<String> notLoading = new ArrayList<>();
        for (Mixins mixin : Mixins.values()) {
            if (mixin.phase == Phase.EARLY) {
                if (mixin.shouldLoad(loadedCoreMods, Collections.emptySet())) {
                    mixins.addAll(mixin.mixinClasses);
                } else {
                    notLoading.addAll(mixin.mixinClasses);
                }
            }
        }
        Lwjgl3ifyCoremod.LOGGER.info("Not loading the following EARLY mixins: {}", notLoading.toString());
        return mixins;
    }

    public static List<String> getLateMixins(Set<String> loadedMods) {
        // NOTE: Any targetmod here needs a modid, not a coremod id
        final List<String> mixins = new ArrayList<>();
        final List<String> notLoading = new ArrayList<>();
        for (Mixins mixin : Mixins.values()) {
            if (mixin.phase == Phase.LATE) {
                if (mixin.shouldLoad(Collections.emptySet(), loadedMods)) {
                    mixins.addAll(mixin.mixinClasses);
                } else {
                    notLoading.addAll(mixin.mixinClasses);
                }
            }
        }
        Lwjgl3ifyCoremod.LOGGER.info("Not loading the following LATE mixins: {}", notLoading.toString());
        return mixins;
    }

    private boolean shouldLoadSide() {
        return side == Side.BOTH || (side == Side.SERVER && FMLLaunchHandler.side()
            .isServer())
            || (side == Side.CLIENT && FMLLaunchHandler.side()
                .isClient());
    }

    private boolean allModsLoaded(List<TargetedMod> targetedMods, Set<String> loadedCoreMods, Set<String> loadedMods) {
        if (targetedMods.isEmpty()) return false;

        for (TargetedMod target : targetedMods) {
            if (target == TargetedMod.VANILLA) continue;

            // Check coremod first
            if (!loadedCoreMods.isEmpty() && target.coreModClass != null
                && !loadedCoreMods.contains(target.coreModClass)) return false;
            else if (!loadedMods.isEmpty() && target.modId != null && !loadedMods.contains(target.modId)) return false;
        }

        return true;
    }

    private boolean noModsLoaded(List<TargetedMod> targetedMods, Set<String> loadedCoreMods, Set<String> loadedMods) {
        if (targetedMods.isEmpty()) return true;

        for (TargetedMod target : targetedMods) {
            if (target == TargetedMod.VANILLA) continue;

            // Check coremod first
            if (!loadedCoreMods.isEmpty() && target.coreModClass != null
                && loadedCoreMods.contains(target.coreModClass)) return false;
            else if (!loadedMods.isEmpty() && target.modId != null && loadedMods.contains(target.modId)) return false;
        }

        return true;
    }

    private boolean shouldLoad(Set<String> loadedCoreMods, Set<String> loadedMods) {
        return (shouldLoadSide() && applyIf.get()
            && allModsLoaded(targetedMods, loadedCoreMods, loadedMods)
            && noModsLoaded(excludedMods, loadedCoreMods, loadedMods));
    }

    private static class Builder {

        private final String name;
        private final List<String> mixinClasses = new ArrayList<>();
        private final List<TargetedMod> targetedMods = new ArrayList<>();
        private final List<TargetedMod> excludedMods = new ArrayList<>();
        private Supplier<Boolean> applyIf = null;
        private Phase phase = null;
        private Side side = null;

        public Builder(String name) {
            this.name = name;
        }

        public Builder addMixinClasses(String... mixinClasses) {
            this.mixinClasses.addAll(Arrays.asList(mixinClasses));
            return this;
        }

        public Builder setPhase(Phase phase) {
            if (this.phase != null) {
                throw new RuntimeException("Trying to define Phase twice for " + this.name);
            }
            this.phase = phase;
            return this;
        }

        public Builder setSide(Side side) {
            if (this.side != null) {
                throw new RuntimeException("Trying to define Side twice for " + this.name);
            }
            this.side = side;
            return this;
        }

        public Builder setApplyIf(Supplier<Boolean> applyIf) {
            this.applyIf = applyIf;
            return this;
        }

        public Builder addTargetedMod(TargetedMod mod) {
            this.targetedMods.add(mod);
            return this;
        }

        public Builder addExcludedMod(TargetedMod mod) {
            this.excludedMods.add(mod);
            return this;
        }
    }

    private enum Side {
        BOTH,
        CLIENT,
        SERVER
    }

    private enum Phase {
        EARLY,
        LATE,
    }
}
