package me.eigenraven.lwjgl3ify.mixins;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

import me.eigenraven.lwjgl3ify.core.Config;

// TODO: have someone who knows what they're doing rewrite these descriptions
public enum Mixins implements IMixins {

    // spotless:off
    FORGE_JAVA9(
        new MixinBuilder("FML Java 9+ compatibility patch")
            .addCommonMixins(
                "fml.ItemStackHolderRef",
                "fml.JarDiscoverer",
                "fml.ObjectHolderRef",
                "fml.ObjectHolderRegistry")),
    FIX_UNICODE_INPUT(
        new MixinBuilder("Fix the input method to support all Unicode")
            .addClientMixins("game.MixinGuiScreenKeyTypeInput")),
    FIX_DEADKEY_KEYBINDING(
        new MixinBuilder("Improved KeyBinding handling to handle dead keys")
            .addClientMixins("game.MixinMinecraftKeyBinding")),
    BORDERLESS_FULLSCREEN(
        new MixinBuilder()
            .addClientMixins("game.MixinBorderlessWindow")),
    STB_TEXTURE_LOADING(
        new MixinBuilder()
            .addClientMixins("game.MixinTextureAtlasSprite", "game.MixinTextureMap")
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_LOADING)),
    STB_TEXTURE_STITCHING(
        new MixinBuilder()
            .addClientMixins("game.MixinStitcher")
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_STITCHING));
    // spotless:on

    private final MixinBuilder builder;

    Mixins(MixinBuilder builder) {
        this.builder = builder.setPhase(Phase.EARLY);
    }

    @Nonnull
    @Override
    public MixinBuilder getBuilder() {
        return this.builder;
    }
}
