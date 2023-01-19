package me.eigenraven.lwjgl3ify.core;

import java.util.Arrays;
import java.util.List;

public class Config {
    public static final String[] DEFAULT_EXTENSIBLE_ENUMS = new String[] {
        // From EnumHelper
        "net.minecraft.item.EnumAction",
        "net.minecraft.item.ItemArmor$ArmorMaterial",
        "net.minecraft.entity.item.EntityPainting$EnumArt",
        "net.minecraft.entity.EnumCreatureAttribute",
        "net.minecraft.entity.EnumCreatureType",
        "net.minecraft.world.gen.structure.StructureStrongholdPieces$Stronghold$Door",
        "net.minecraft.enchantment.EnumEnchantmentType",
        "net.minecraft.entity.Entity$EnumEntitySize",
        "net.minecraft.block.BlockPressurePlate$Sensitivity",
        "net.minecraft.util.MovingObjectPosition$MovingObjectType",
        "net.minecraft.world.EnumSkyBlock",
        "net.minecraft.entity.player.EntityPlayer$EnumStatus",
        "net.minecraft.item.Item$ToolMaterial",
        "net.minecraft.item.EnumRarity",
        //
        "net.minecraftforge.event.terraingen.PopulateChunkEvent$Populate$EventType",
        "net.minecraftforge.event.terraingen.InitMapGenEvent$EventType",
        "net.minecraftforge.event.terraingen.OreGenEvent$GenerateMinable$EventType",
        "net.minecraftforge.event.terraingen.DecorateBiomeEvent$Decorate$EventType",
        // From GTNH crashes
        "vswe.stevesfactory.Localization",
        "vswe.stevesfactory.blocks.ClusterMethodRegistration",
        "vswe.stevesfactory.blocks.ConnectionBlockType",
        "vswe.stevesfactory.components.ComponentType",
        "vswe.stevesfactory.components.ConnectionSet",
        "vswe.stevesfactory.components.ConnectionOption",
    };


    // TODO: Make this an actual config file :P
    public static List<String> EXTENSIBLE_ENUMS = Arrays.asList(DEFAULT_EXTENSIBLE_ENUMS);
}
