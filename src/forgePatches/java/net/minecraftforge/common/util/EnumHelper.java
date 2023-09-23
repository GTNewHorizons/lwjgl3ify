package net.minecraftforge.common.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraft.block.BlockPressurePlate.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity.EnumEntitySize;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityPainting.EnumArt;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.gen.structure.StructureStrongholdPieces.Stronghold.Door;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.base.Throwables;

public class EnumHelper {

    // Some enums are decompiled with extra arguments, so lets check for that
    @SuppressWarnings("rawtypes")
    private static Class[][] commonTypes = { { EnumAction.class },
        { ArmorMaterial.class, int.class, int[].class, int.class },
        { EnumArt.class, String.class, int.class, int.class, int.class, int.class }, { EnumCreatureAttribute.class },
        { EnumCreatureType.class, Class.class, int.class, Material.class, boolean.class, boolean.class },
        { Door.class }, { EnumEnchantmentType.class }, { EnumEntitySize.class }, { Sensitivity.class },
        { MovingObjectType.class }, { EnumSkyBlock.class, int.class }, { EnumStatus.class },
        { ToolMaterial.class, int.class, int.class, float.class, float.class, int.class },
        { EnumRarity.class, EnumChatFormatting.class, String.class } };

    public static EnumAction addAction(String name) {
        return addEnum(EnumAction.class, name);
    }

    public static ArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts,
        int enchantability) {
        return addEnum(ArmorMaterial.class, name, durability, reductionAmounts, enchantability);
    }

    public static EnumArt addArt(String name, String tile, int sizeX, int sizeY, int offsetX, int offsetY) {
        return addEnum(EnumArt.class, name, tile, sizeX, sizeY, offsetX, offsetY);
    }

    public static EnumCreatureAttribute addCreatureAttribute(String name) {
        return addEnum(EnumCreatureAttribute.class, name);
    }

    @SuppressWarnings("rawtypes")
    public static EnumCreatureType addCreatureType(String name, Class typeClass, int maxNumber, Material material,
        boolean peaceful, boolean animal) {
        return addEnum(EnumCreatureType.class, name, typeClass, maxNumber, material, peaceful, animal);
    }

    public static Door addDoor(String name) {
        return addEnum(Door.class, name);
    }

    public static EnumEnchantmentType addEnchantmentType(String name) {
        return addEnum(EnumEnchantmentType.class, name);
    }

    public static EnumEntitySize addEntitySize(String name) {
        return addEnum(EnumEntitySize.class, name);
    }

    public static Sensitivity addSensitivity(String name) {
        return addEnum(Sensitivity.class, name);
    }

    public static MovingObjectType addMovingObjectType(String name) {
        return addEnum(MovingObjectType.class, name);
    }

    public static EnumSkyBlock addSkyBlock(String name, int lightValue) {
        return addEnum(EnumSkyBlock.class, name, lightValue);
    }

    public static EnumStatus addStatus(String name) {
        return addEnum(EnumStatus.class, name);
    }

    public static ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency,
        float damage, int enchantability) {
        return addEnum(ToolMaterial.class, name, harvestLevel, maxUses, efficiency, damage, enchantability);
    }

    public static EnumRarity addRarity(String name, EnumChatFormatting color, String displayName) {
        return addEnum(EnumRarity.class, name, color, displayName);
    }

    public static void setFailsafeFieldValue(Field field, Object target, Object value) throws Exception {
        try {
            setFieldHandle.invokeExact(field, target, value);
        } catch (Throwable e) {
            Throwables.propagate(e);
        }
    }

    public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Object... paramValues) {
        return addEnum(commonTypes, enumType, enumName, paramValues);
    }

    @SuppressWarnings("rawtypes")
    public static <T extends Enum<?>> T addEnum(Class[][] map, Class<T> enumType, String enumName,
        Object... paramValues) {
        for (Class[] lookup : map) {
            if (lookup[0] == enumType) {
                Class<?>[] paramTypes = new Class<?>[lookup.length - 1];
                if (paramTypes.length > 0) {
                    System.arraycopy(lookup, 1, paramTypes, 0, paramTypes.length);
                }
                return addEnum(enumType, enumName, paramTypes, paramValues);
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<?>> T addEnum(Class<T> enumType, String enumName, Class<?>[] paramTypes,
        Object[] paramValues) {
        if (!extensibleEnumIface.isAssignableFrom(enumType)) {
            throw new RuntimeException(
                "Enum " + enumType.getName() + " was not made extensible, add it to lwjgl3ify configs.");
        }

        try {
            paramTypes = ArrayUtils.add(paramTypes, 0, String.class);
            paramValues = ArrayUtils.add(paramValues, 0, enumName);

            final Method creatorHandle = enumType.getMethod("dynamicCreate", paramTypes);
            T newValue = (T) creatorHandle.invoke(null, paramValues);

            return newValue;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static final Class<?> extensibleEnumIface;
    private static final MethodHandle setFieldHandle;

    static {
        try {
            extensibleEnumIface = Class.forName("me.eigenraven.lwjgl3ify.IExtensibleEnum");
            Class<?> unsafeHacks = Class.forName("me.eigenraven.lwjgl3ify.UnsafeHacks");
            Method setFieldM = unsafeHacks.getMethod("setField", Field.class, Object.class, Object.class);
            setFieldHandle = MethodHandles.publicLookup()
                .unreflect(setFieldM);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
