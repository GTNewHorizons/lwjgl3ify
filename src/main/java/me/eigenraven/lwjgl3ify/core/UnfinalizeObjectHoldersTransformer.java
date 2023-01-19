package me.eigenraven.lwjgl3ify.core;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

public class UnfinalizeObjectHoldersTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null) {
            return null;
        }
        try {
            final ClassReader reader = new ClassReader(basicClass);
            final ClassNode node = new ClassNode();
            reader.accept(node, ClassReader.EXPAND_FRAMES);

            boolean transformClass = false;
            boolean workDone = false;
            if (transformedName.equals("net.minecraft.init.Blocks")
                    || transformedName.equals("net.minecraft.init.Items")) {
                transformClass = true;
            }
            if (node.visibleAnnotations != null) {
                for (AnnotationNode annotationNode : node.visibleAnnotations) {
                    if (annotationNode.desc.contains("cpw/mods/fml/common/registry/GameRegistry/ObjectHolder")) {
                        transformClass = true;
                        break;
                    }
                    if (annotationNode.desc.contains("cpw/mods/fml/common/registry/GameRegistry/ItemStackHolder")) {
                        transformClass = true;
                        break;
                    }
                }
            }
            int fieldsModified = 0;
            for (FieldNode field : node.fields) {
                boolean transform = transformClass;
                if (!transform) {
                    if (field.visibleAnnotations != null) {
                        for (AnnotationNode annotationNode : field.visibleAnnotations) {
                            if (annotationNode.desc.contains(
                                    "cpw/mods/fml/common/registry/GameRegistry/ObjectHolder")) {
                                transform = true;
                                break;
                            }
                            if (annotationNode.desc.contains(
                                    "cpw/mods/fml/common/registry/GameRegistry/ItemStackHolder")) {
                                transformClass = true;
                                break;
                            }
                        }
                    }
                }
                if (transform) {
                    workDone = true;
                    field.access = field.access & (~Opcodes.ACC_FINAL);
                    fieldsModified++;
                }
            }
            if (workDone) {
                Lwjgl3ifyCoremod.LOGGER.info("Unfinalized {} Holder fields in {}", fieldsModified, transformedName);
                final ClassWriter writer = new ClassWriter(0);
                node.accept(writer);
                return writer.toByteArray();
            }
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.error("Error when unfinalizing ObjectHolder transformer", e);
        }
        return basicClass;
    }
}
