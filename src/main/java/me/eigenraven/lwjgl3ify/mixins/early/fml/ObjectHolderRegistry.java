package me.eigenraven.lwjgl3ify.mixins.early.fml;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import me.eigenraven.lwjgl3ify.WasFinalObjectHolder;

@Mixin(value = { cpw.mods.fml.common.registry.ObjectHolderRegistry.class }, remap = false)
public abstract class ObjectHolderRegistry {

    @Redirect(
        method = { "cpw.mods.fml.common.registry.ObjectHolderRegistry.scanClassForFields" },
        at = @At(value = "INVOKE", target = "Ljava/lang/reflect/Field;getModifiers()I"),
        remap = false,
        require = 1)
    public int getFieldModifiersProxy(Field f) {
        int mods = f.getModifiers();
        if (f.isAnnotationPresent(WasFinalObjectHolder.class)) {
            mods |= Modifier.FINAL;
        }
        return mods;
    }
}
