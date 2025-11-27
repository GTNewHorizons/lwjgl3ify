package me.eigenraven.lwjgl3ify.mixins;

import javax.annotation.Nonnull;

import com.gtnewhorizon.gtnhmixins.builders.IMixins;
import com.gtnewhorizon.gtnhmixins.builders.MixinBuilder;

import me.eigenraven.lwjgl3ify.core.Config;

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
    STB_TEXTURE_LOADING(
        new MixinBuilder()
            .addClientMixins("game.MixinTextureAtlasSprite", "game.MixinTextureMap")
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_LOADING)),
    TEXT_FIELD_SDL_INPUT(
        new MixinBuilder()
            .addClientMixins("game.MixinGuiTextField", "game.MixinGuiScreen")),
    OPEN_URL_WITH_SDL(
        new MixinBuilder()
            .addClientMixins(
                "game.openurl.MixinGuiChat",
                "game.openurl.MixinGuiMainMenu",
                "game.openurl.MixinGuiScreenDemoResourcePacks",
                "game.openurl.MixinGuiStreamUnavailable")),

    // apply the texture stitching mixin if
    // - you don't have fastcraft
    // - or you have fastcraft and the force enabled setting
    // - or you have fastcraft 1.25 and optifine
    STB_TEXTURE_STITCHING(
        new MixinBuilder()
            .addClientMixins("game.MixinStitcher")
            .addExcludedMod(TargetedMod.FASTCRAFT_ANY)
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_STITCHING)),
    STB_TEXTURE_STITCHING_FORCE(
        new MixinBuilder()
            .addClientMixins("game.MixinStitcher")
            .addRequiredMod(TargetedMod.FASTCRAFT_ANY)
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_STITCHING && Config.MIXIN_STBI_IGNORE_FASTCRAFT)),
    STB_TEXTURE_STITCHING_FOR_FASCRAFT(
        new MixinBuilder()
            .addClientMixins("game.MixinStitcher")
            .addRequiredMod(TargetedMod.FASTCRAFT_1_25)
            .addRequiredMod(TargetedMod.OPTIFINE)
            .setApplyIf(() -> Config.MIXIN_STBI_TEXTURE_STITCHING && !Config.MIXIN_STBI_IGNORE_FASTCRAFT));
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
