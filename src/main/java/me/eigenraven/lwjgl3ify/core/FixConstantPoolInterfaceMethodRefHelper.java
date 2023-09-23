package me.eigenraven.lwjgl3ify.core;

import java.util.concurrent.atomic.AtomicBoolean;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodNode;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;

/**
 * Fixes a compilation bug of the java 8 compiler leading to the following exception at runtime:
 * cpw.mods.fml.common.LoaderException: java.lang.IncompatibleClassChangeError: Inconsistent constant pool data in
 * classfile for class com/gtnewhorizon/structurelib/alignment/IAlignmentLimits. Method 'boolean
 * lambda$static$0(net.minecraftforge.common.util.ForgeDirection,
 * com.gtnewhorizon.structurelib.alignment.enumerable.Rotation,
 * com.gtnewhorizon.structurelib.alignment.enumerable.Flip)' at index 77 is CONSTANT_MethodRef and should be
 * CONSTANT_InterfaceMethodRef
 */
public class FixConstantPoolInterfaceMethodRefHelper {

    public boolean transform(ClassNode node) {
        if (System.getProperty("java.specification.version", "1.8")
            .trim()
            .startsWith("1.8")) {
            return false;
        }
        final boolean iAmAnInterface = ((node.access & Opcodes.ACC_INTERFACE) != 0);
        boolean changesMade = false;
        final String internalClassName = node.name;
        if (node.methods != null) {
            for (MethodNode method : node.methods) {
                if (method.instructions != null) {
                    for (AbstractInsnNode insn : method.instructions) {
                        changesMade |= validateInstruction(internalClassName, iAmAnInterface, insn);
                    }
                }
            }
        }
        return changesMade;
    }

    private boolean validateInstruction(String internalClassName, boolean iAmAnInterface, AbstractInsnNode rawInsn) {
        AtomicBoolean changed = new AtomicBoolean(false);
        switch (rawInsn.getType()) {
            case AbstractInsnNode.INVOKE_DYNAMIC_INSN -> {
                final InvokeDynamicInsnNode insn = (InvokeDynamicInsnNode) rawInsn;
                insn.bsm = fixHandle(internalClassName, iAmAnInterface, insn.bsm, changed);
                if (insn.bsmArgs != null) {
                    for (int i = 0; i < insn.bsmArgs.length; i++) {
                        final Object arg = insn.bsmArgs[i];
                        if (arg instanceof Handle handle) {
                            insn.bsmArgs[i] = fixHandle(internalClassName, iAmAnInterface, handle, changed);
                        }
                    }
                }
            }
            default -> {}
            // no-op
        }
        return changed.get();
    }

    private Handle fixHandle(String internalClassName, boolean iAmAnInterface, Handle handle, AtomicBoolean changed) {
        if (!handle.isInterface()) {
            final boolean fixSelfReference = handle.getOwner()
                .equals(internalClassName) && iAmAnInterface;
            boolean fixJavaReference = false;
            if (!fixSelfReference && handle.getOwner()
                .startsWith("java/")) {
                final String regularName = handle.getOwner()
                    .replace('/', '.');
                try {
                    final Class<?> javaClass = Class.forName(regularName);
                    if (javaClass.isInterface()) {
                        fixJavaReference = true;
                    }
                } catch (ClassNotFoundException cnfe) {
                    // no-op
                    Lwjgl3ify.LOG.warn("Reference to non-existing java class {} found.", regularName, cnfe);
                }
            }
            if (fixSelfReference || fixJavaReference) {
                changed.set(true);
                return new Handle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), true);
            }
        }
        return handle;
    }
}
