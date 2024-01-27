package me.eigenraven.lwjgl3ify.rfb;

import java.util.Arrays;
import java.util.jar.Manifest;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.ClassNode;

import com.gtnewhorizons.retrofuturabootstrap.api.ClassNodeHandle;
import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class LwjglRedirectTransformer extends Remapper implements RfbClassTransformer {

    int remaps = 0, calls = 0;

    public LwjglRedirectTransformer() {
        excludedPackages = Stream.concat(Arrays.stream(fromPrefixes), Arrays.stream(toPrefixes))
            .map(s -> s.replace('/', '.'))
            .toArray(String[]::new);
    }

    @Override
    public @NotNull String @Nullable [] sortAfter() {
        return new String[] { "*", "mixin:mixin" };
    }

    @Override
    public @NotNull String id() {
        return "redirect";
    }

    @Override
    public @NotNull String @Nullable [] additionalExclusions() {
        return excludedPackages;
    }

    @Override
    public boolean shouldTransformClass(@NotNull ExtensibleClassLoader classLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String className,
        @NotNull ClassNodeHandle nodeHandle) {
        return true;
    }

    @Override
    public void transformClass(@NotNull ExtensibleClassLoader classLoader, @NotNull RfbClassTransformer.Context context,
        @Nullable Manifest manifest, @NotNull String className, @NotNull ClassNodeHandle nodeHandle) {
        final ClassNode inputNode = nodeHandle.getNode();
        if (inputNode == null) {
            return;
        }

        final ClassNode outputNode = new ClassNode();
        final ClassVisitor visitor = new EscapingClassRemapper(outputNode);

        try {
            inputNode.accept(visitor);
        } catch (Lwjgl3AwareException e) {
            return;
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.warn("Couldn't remap class {}", className, e);
            return;
        }

        nodeHandle.setNode(outputNode);
    }

    final String[] fromPrefixes = new String[] { "org/lwjgl/", "javax/xml/bind/", "javax/servlet/" };
    final String[] toPrefixes = new String[] { "org/lwjglx/", "jakarta/xml/bind/", "jakarta/servlet/" };
    final String[] excludedPackages;

    @Override
    public String map(String typeName) {
        if (typeName == null) {
            return null;
        }
        calls++;
        for (int pfx = 0; pfx < fromPrefixes.length; pfx++) {
            if (typeName.startsWith(fromPrefixes[pfx])) {
                remaps++;
                return toPrefixes[pfx] + typeName.substring(fromPrefixes[pfx].length());
            }
        }

        return typeName;
    }

    public static class Lwjgl3AwareException extends RuntimeException {
    }

    public class EscapingClassRemapper extends ClassRemapper {

        public EscapingClassRemapper(ClassVisitor visitor) {
            super(visitor, LwjglRedirectTransformer.this);
        }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            if (desc.equals(Type.getDescriptor(Lwjgl3Aware.class))) {
                throw new Lwjgl3AwareException();
            }
            return super.visitAnnotation(desc, visible);
        }
    }
}
