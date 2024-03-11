package me.eigenraven.lwjgl3ify.rfb.transformers;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.stream.Stream;

import net.minecraft.launchwrapper.LaunchClassLoader;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.ClassNode;

import com.gtnewhorizons.retrofuturabootstrap.api.ClassHeaderMetadata;
import com.gtnewhorizons.retrofuturabootstrap.api.ClassNodeHandle;
import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class LwjglRedirectTransformer extends Remapper implements RfbClassTransformer {

    /** Attribute to set to "true" on a JAR to skip class transforms from this transformer entirely */
    public static final Attributes.Name MANIFEST_SAFE_ATTRIBUTE = new Attributes.Name("Lwjgl3ify-Aware");

    int remaps = 0, calls = 0;

    public LwjglRedirectTransformer() {
        excludedPackages = Stream.concat(Arrays.stream(fromPrefixes), Arrays.stream(toPrefixes))
            .map(s -> s.replace('/', '.'))
            .toArray(String[]::new);
        quickScans = Arrays.stream(fromPrefixes)
            .map(s -> s.getBytes(StandardCharsets.UTF_8))
            .toArray(byte[][]::new);
    }

    @Override
    public @NotNull String @Nullable [] sortAfter() {
        return new String[] { "*", "mixin:mixin" };
    }

    @Pattern("[a-z0-9-]+")
    @Override
    public @NotNull String id() {
        return "redirect";
    }

    @Override
    public @NotNull String @Nullable [] additionalExclusions() {
        return excludedPackages;
    }

    @Override
    public void onRegistration(@NotNull ExtensibleClassLoader classLoader) {
        if (classLoader instanceof LaunchClassLoader lcl) {
            lcl.addClassLoaderExclusion("me.eigenraven.lwjgl3ify.pack200.");
        }
    }

    @Override
    public boolean shouldTransformClass(@NotNull ExtensibleClassLoader classLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String className,
        @NotNull ClassNodeHandle nodeHandle) {
        if (!nodeHandle.isPresent()) {
            return false;
        }
        if (manifest != null && "true".equals(
            manifest.getMainAttributes()
                .getValue(MANIFEST_SAFE_ATTRIBUTE))) {
            return false;
        }
        if (!nodeHandle.isOriginal()) {
            return true;
        }
        final byte[] original = nodeHandle.getOriginalBytes();
        if (original == null) {
            return false;
        }
        for (final byte[] pattern : quickScans) {
            if (ClassHeaderMetadata.hasSubstring(original, pattern)) {
                return true;
            }
        }
        return false;
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

    final String[] fromPrefixes = new String[] { "org/lwjgl/", "javax/xml/bind/", "java/util/jar/Pack200",
        "jdk/nashorn/", "com/mumfrey/liteloader/launch/ClassPathUtilities", "javax/activity/InvalidActivityException" };
    final String[] toPrefixes = new String[] { "org/lwjglx/", "jakarta/xml/bind/",
        "me/eigenraven/lwjgl3ify/redirects/Pack200", "org/openjdk/nashorn/",
        "me/eigenraven/lwjgl3ify/redirects/LiteLoaderClassPathUtilities",
        "me/eigenraven/lwjgl3ify/redirects/InvalidActivityException" };
    final byte[][] quickScans;
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
