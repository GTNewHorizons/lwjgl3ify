package me.eigenraven.lwjgl3ify.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import me.eigenraven.lwjgl3ify.WasFinalObjectHolder;

public class UnfinalizeObjectHoldersTransformer implements IClassTransformer {

    // Keep ClassNode-operating transformers together for efficiency (don't read/write the class multiple times)
    final ExtensibleEnumTransformerHelper enumTransformer = new ExtensibleEnumTransformerHelper();
    final FixConstantPoolInterfaceMethodRefHelper cpiMethodRefTransformer = new FixConstantPoolInterfaceMethodRefHelper();

    private static boolean isHolder(List<AnnotationNode> annotations) {
        if (annotations == null) {
            return false;
        }
        for (AnnotationNode annotationNode : annotations) {
            // Java 17 uses $ instead of /
            final String desc = annotationNode.desc.replace('$', '/');
            if (desc.contains("cpw/mods/fml/common/registry/GameRegistry/ObjectHolder")) {
                return true;
            }
            if (desc.contains("cpw/mods/fml/common/registry/GameRegistry/ItemStackHolder")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null) {
            return null;
        }
        if (transformedName.startsWith("me.eigenraven.lwjgl3ify")) {
            return basicClass;
        }
        try {
            final ClassReader reader = new ClassReader(basicClass);
            final ClassNode node = new ClassNode();
            reader.accept(node, ClassReader.EXPAND_FRAMES);
            final Type classType = Type.getType("L" + name.replace('.', '/') + ";");

            boolean transformClass = false;
            boolean workDone = false;
            if (transformedName.equals("net.minecraft.init.Blocks")
                    || transformedName.equals("net.minecraft.init.Items")) {
                transformClass = true;
            }
            transformClass |= isHolder(node.visibleAnnotations);
            if (transformedName.equals("team.chisel.init.ChiselBlocks")) {
                Lwjgl3ifyCoremod.LOGGER.info("chiselblocks");
            }
            int fieldsModified = 0;
            for (FieldNode field : node.fields) {
                boolean transform = transformClass;
                if (!transform) {
                    transform = isHolder(field.visibleAnnotations);
                }
                if (transform) {
                    workDone = true;
                    if ((field.access & Opcodes.ACC_FINAL) != 0) {
                        if (field.visibleAnnotations == null) {
                            field.visibleAnnotations = new ArrayList<>(1);
                            field.visibleAnnotations
                                    .add(new AnnotationNode(Type.getDescriptor(WasFinalObjectHolder.class)));
                        }
                        field.access = field.access & (~Opcodes.ACC_FINAL);
                    }
                    fieldsModified++;
                }
            }
            if (workDone) {
                Lwjgl3ifyCoremod.LOGGER.info("Unfinalized {} Holder fields in {}", fieldsModified, transformedName);
            }

            if (Config.getExtensibleEnums().contains(transformedName)) {
                if (node.interfaces == null) {
                    node.interfaces = new ArrayList<>(1);
                }
                node.interfaces.add(enumTransformer.MARKER_IFACE.getInternalName());
            }

            final boolean enumsTransformed = enumTransformer.processClassWithFlags(node, classType);

            if (enumsTransformed) {
                workDone = true;
                Lwjgl3ifyCoremod.LOGGER.info("Dynamicized enum {}={}", name, transformedName);
            }

            final boolean ifaceMethodRefsTransformed = cpiMethodRefTransformer.transform(node);

            if (ifaceMethodRefsTransformed) {
                workDone = true;
                Lwjgl3ifyCoremod.LOGGER.warn(
                        "Fixed missing CONSTANT_InterfaceMethodRef miscompilation in {}={}",
                        name,
                        transformedName);
            }

            if (workDone) {
                final ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                node.accept(writer);
                return writer.toByteArray();
            }
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.error("Error when unfinalizing ObjectHolder transformer", e);
        }
        return basicClass;
    }
}
