package me.eigenraven.lwjgl3ify.mixins.fml;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import cpw.mods.fml.common.discovery.asm.ModAnnotationVisitor;
import cpw.mods.fml.common.discovery.asm.ModClassVisitor;
import cpw.mods.fml.common.discovery.asm.ModFieldVisitor;
import cpw.mods.fml.common.discovery.asm.ModMethodVisitor;

@Mixin(
    value = { ModClassVisitor.class, ModAnnotationVisitor.class, ModFieldVisitor.class, ModMethodVisitor.class },
    remap = false)
public class ModVisitorAsmVersion {

    @ModifyConstant(method = "<init>*", constant = @Constant(intValue = Opcodes.ASM5), remap = false)
    private static int lwjgl3ify$acceptNewerAsm(int original) {
        return Opcodes.ASM9;
    }
}
