package me.eigenraven.lwjgl3ify.core;

import java.util.concurrent.atomic.AtomicBoolean;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Fixes a compilation bug of the java 8 compiler leading to the following exception at runtime:
 * cpw.mods.fml.common.LoaderException: java.lang.IncompatibleClassChangeError: Inconsistent constant pool data
 * in classfile for class com/gtnewhorizon/structurelib/alignment/IAlignmentLimits. Method
 *    'boolean lambda$static$0(net.minecraftforge.common.util.ForgeDirection,
 *    com.gtnewhorizon.structurelib.alignment.enumerable.Rotation, com.gtnewhorizon.structurelib.alignment.enumerable.Flip)'
 * at index 77 is CONSTANT_MethodRef and should be CONSTANT_InterfaceMethodRef
 */
public class FixConstantPoolInterfaceMethodRefHelper {
    public boolean transform(ClassNode node) {
        if (System.getProperty("java.specification.version", "1.8").trim().startsWith("1.8")) {
            return false;
        }
        if ((node.access & Opcodes.ACC_INTERFACE) == 0) {
            return false;
        }
        boolean changesMade = false;
        final String internalClassName = node.name;
        if (node.methods != null) {
            for (MethodNode method : node.methods) {
                if (method.instructions != null) {
                    for (AbstractInsnNode insn : method.instructions) {
                        changesMade |= validateInstruction(internalClassName, insn);
                    }
                }
            }
        }
        return changesMade;
    }

    private boolean validateInstruction(String internalClassName, AbstractInsnNode rawInsn) {
        AtomicBoolean changed = new AtomicBoolean(false);
        switch (rawInsn.getType()) {
            case AbstractInsnNode.INVOKE_DYNAMIC_INSN:
                final InvokeDynamicInsnNode insn = (InvokeDynamicInsnNode) rawInsn;
                insn.bsm = fixHandle(internalClassName, insn.bsm, changed);
                if (insn.bsmArgs != null) {
                    for (int i = 0; i < insn.bsmArgs.length; i++) {
                        final Object arg = insn.bsmArgs[i];
                        if (arg instanceof Handle) {
                            insn.bsmArgs[i] = fixHandle(internalClassName, (Handle) arg, changed);
                        }
                    }
                }
                break;
            default:
                // no-op
                break;
        }
        return changed.get();
    }

    private Handle fixHandle(String internalClassName, Handle handle, AtomicBoolean changed) {
        if (!handle.isInterface() && handle.getOwner().equals(internalClassName)) {
            changed.set(true);
            return new Handle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), true);
        }
        return handle;
    }
}
