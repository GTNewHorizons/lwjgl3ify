package me.eigenraven.lwjgl3ify.rfb.transformers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Manifest;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.gtnewhorizons.retrofuturabootstrap.api.ClassHeaderMetadata;
import com.gtnewhorizons.retrofuturabootstrap.api.ClassNodeHandle;
import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

import me.eigenraven.lwjgl3ify.WasFinalObjectHolder;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class UnfinalizeObjectHoldersTransformer implements RfbClassTransformer {

    private final static Set<String> objectHolders = new HashSet<>(
        Arrays.asList(
            "Lcpw/mods/fml/common/registry/GameRegistry$ObjectHolder;",
            "Lcpw/mods/fml/common/registry/GameRegistry$ItemStackHolder;",
            "Lcpw/mods/fml/common/registry/GameRegistry/ObjectHolder;",
            "Lcpw/mods/fml/common/registry/GameRegistry/ItemStackHolder;"));

    private final static byte[][] objectHolderBytes = Arrays.stream(objectHolders.toArray(new String[0]))
        .map(s -> s.getBytes(StandardCharsets.UTF_8))
        .toArray(byte[][]::new);

    private final static ClassHeaderMetadata.NeedleIndex scanIndex = new ClassHeaderMetadata.NeedleIndex(
        objectHolderBytes).exactMatch();

    @Pattern("[a-z0-9-]+")
    @Override
    public @NotNull String id() {
        return "unfinalize-object-holders";
    }

    @Override
    public boolean shouldTransformClass(@NotNull ExtensibleClassLoader classLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String className,
        @NotNull ClassNodeHandle classNode) {
        if (!classNode.isPresent()) {
            return false;
        }
        if (className.equals("net.minecraft.init.Blocks") || className.equals("net.minecraft.init.Items")) {
            return true;
        }
        final ClassHeaderMetadata metadata = classNode.getOriginalMetadata();
        if (metadata == null) {
            return false;
        }
        return metadata.hasSubstrings(scanIndex);
    }

    @Override
    public boolean transformClassIfNeeded(@NotNull ExtensibleClassLoader classLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String name,
        @NotNull ClassNodeHandle classNodeHandle) {
        final ClassNode node = classNodeHandle.getNode();
        if (node == null) {
            return false;
        }

        final boolean isClassObjectHolder = name.equals("net.minecraft.init.Blocks")
            || name.equals("net.minecraft.init.Items")
            || isObjectHolder(node.visibleAnnotations);
        int fieldsModified = 0;

        for (final FieldNode field : node.fields) {
            final boolean isObjectHolder = isClassObjectHolder || isObjectHolder(field.visibleAnnotations);
            final boolean isFinal = (field.access & Opcodes.ACC_FINAL) != 0;
            if (isObjectHolder && isFinal) {
                if (field.visibleAnnotations == null) {
                    field.visibleAnnotations = new ArrayList<>(1);
                }
                field.visibleAnnotations.add(new AnnotationNode(Type.getDescriptor(WasFinalObjectHolder.class)));
                field.access = field.access & (~Opcodes.ACC_FINAL);
                fieldsModified++;
            }
        }

        if (fieldsModified > 0) {
            Lwjgl3ifyCoremod.LOGGER.debug("Unfinalized {} Holder fields in {}", fieldsModified, name);
            return true;
        }
        return false;
    }

    private static boolean isObjectHolder(List<AnnotationNode> annotations) {
        if (annotations == null) {
            return false;
        }
        for (AnnotationNode annotationNode : annotations) {
            if (objectHolders.contains(annotationNode.desc)) {
                return true;
            }
        }
        return false;
    }
}
