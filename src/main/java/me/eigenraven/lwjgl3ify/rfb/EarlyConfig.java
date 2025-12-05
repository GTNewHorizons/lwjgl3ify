package me.eigenraven.lwjgl3ify.rfb;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gtnewhorizons.retrofuturabootstrap.api.RetroFuturaBootstrap;

public class EarlyConfig {

    public static final String[] DEFAULT_EXTENSIBLE_ENUMS = new String[] {
        // From EnumHelper
        "net.minecraft.item.EnumAction", "net.minecraft.item.ItemArmor$ArmorMaterial",
        "net.minecraft.entity.item.EntityPainting$EnumArt", "net.minecraft.entity.EnumCreatureAttribute",
        "net.minecraft.entity.EnumCreatureType",
        "net.minecraft.world.gen.structure.StructureStrongholdPieces$Stronghold$Door",
        "net.minecraft.enchantment.EnumEnchantmentType", "net.minecraft.entity.Entity$EnumEntitySize",
        "net.minecraft.block.BlockPressurePlate$Sensitivity",
        "net.minecraft.util.MovingObjectPosition$MovingObjectType", "net.minecraft.world.EnumSkyBlock",
        "net.minecraft.entity.player.EntityPlayer$EnumStatus", "net.minecraft.item.Item$ToolMaterial",
        "net.minecraft.item.EnumRarity",
        //
        "net.minecraftforge.event.terraingen.PopulateChunkEvent$Populate$EventType",
        "net.minecraftforge.event.terraingen.InitMapGenEvent$EventType",
        "net.minecraftforge.event.terraingen.OreGenEvent$GenerateMinable$EventType",
        "net.minecraftforge.event.terraingen.DecorateBiomeEvent$Decorate$EventType",
        "net.minecraftforge.common.BiomeDictionary$Type",
        // From GTNH crashes
        "vswe.stevesfactory.Localization", "vswe.stevesfactory.blocks.ClusterMethodRegistration",
        "vswe.stevesfactory.blocks.ConnectionBlockType", "vswe.stevesfactory.components.ComponentType",
        "vswe.stevesfactory.components.ConnectionSet", "vswe.stevesfactory.components.ConnectionOption",
        "ic2.core.init.InternalName", "gregtech.api.enums.Element", "gregtech.api.enums.OrePrefixes",
        "net.minecraft.client.audio.MusicTicker$MusicType", "org.bukkit.Material",
        "buildcraft.api.transport.IPipeTile$PipeType", "thaumcraft.common.entities.golems.EnumGolemType",
        // Non-GTNH Mods Compat
        // The Lord of the Rings Mod: Legacy
        "net.minecraft.event.HoverEvent$Action",
        // LotR Addons
        "lotr.common.fac.LOTRFaction", "lotr.common.quest.LOTRMiniQuestFactory", "lotr.common.world.map.LOTRWaypoint",
        "lotr.common.world.map.LOTRWaypoint$Region", "lotr.common.world.spawning.LOTRInvasions",
        "lotr.common.LOTRShields", "lotr.common.LOTRDimension$DimensionRegion",
        "lotr.common.item.LOTRItemBanner$BannerType", "lotr.common.LOTRAchievement$Category",
        "lotr.client.gui.LOTRMapLabels",
        // Reika's mods
        "net.minecraft.client.audio.SoundCategory",
        "Reika.RotaryCraft.TileEntities.Processing.TileEntityFuelConverter$Conversions",
        "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Fertility",
        "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Speeds",
        "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Flowering",
        "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Territory",
        "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Life",
        "Reika.DragonAPI.ModInteract.Bees.ButterflyAlleleRegistry$Fertility",
        "Reika.DragonAPI.ModInteract.Bees.ButterflyAlleleRegistry$Life", "Reika.DragonAPI.ModRegistry.ModCropList",
        // Et Futurum Requiem
        "net.minecraft.world.WorldSettings$GameType",
        "ganymedes01.etfuturum.tileentities.TileEntityBanner$EnumBannerPattern",
        // EnderIO Addons
        "crazypants.enderio.ModObject",
        //
    };

    public static final Set<String> EXTENSIBLE_ENUMS = new HashSet<>(Arrays.asList(DEFAULT_EXTENSIBLE_ENUMS));

    public static class ConfigObject {

        public String[] extensibleEnums;
    }

    private static boolean isLoaded = false;

    public static void load() {
        if (isLoaded) {
            return;
        }
        isLoaded = true;

        final Path gamePath = RetroFuturaBootstrap.API.gameDirectory();
        final Path earlyConfigPath = gamePath.resolve("config")
            .resolve("lwjgl3ify-early.json");
        final Gson gson = new GsonBuilder().disableJdkUnsafe()
            .setPrettyPrinting()
            .create();
        ConfigObject cfg = new ConfigObject();
        if (Files.exists(earlyConfigPath)) {
            try {
                final String earlyConfigContents = new String(
                    Files.readAllBytes(earlyConfigPath),
                    StandardCharsets.UTF_8);
                ConfigObject parsedConfig = gson.fromJson(earlyConfigContents, ConfigObject.class);
                if (Objects.nonNull(parsedConfig)) {
                    cfg = parsedConfig;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (cfg.extensibleEnums != null) {
            EXTENSIBLE_ENUMS.addAll(Arrays.asList(cfg.extensibleEnums));
        }
        cfg.extensibleEnums = EXTENSIBLE_ENUMS.toArray(new String[0]);

        final String jsonCfg = gson.toJson(cfg);
        try {
            Files.createDirectories(earlyConfigPath.getParent());
            Files.write(earlyConfigPath, jsonCfg.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
