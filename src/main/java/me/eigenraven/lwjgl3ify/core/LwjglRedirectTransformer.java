package me.eigenraven.lwjgl3ify.core;

import net.minecraft.launchwrapper.IClassTransformer;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.commons.ClassRemapper;
import org.spongepowered.asm.lib.commons.Remapper;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;

public class LwjglRedirectTransformer extends Remapper implements IClassTransformer {

    int remaps = 0, calls = 0;

    public static LwjglRedirectTransformer activeInstance = null;

    public LwjglRedirectTransformer() {
        // Only use the last constructed transformer
        activeInstance = this;
    }

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (this != activeInstance) {
            return basicClass;
        }
        if (basicClass == null) {
            return null;
        }
        if (name.contains("lwjgl3ify")) {
            return basicClass;
        }
        ClassReader reader = new ClassReader(basicClass);
        ClassWriter writer = new ClassWriter(0);
        ClassVisitor visitor = new EscapingClassRemapper(writer);

        try {
            reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        } catch (Lwjgl3AwareException e) {
            return basicClass;
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.warn("Couldn't remap class {}", transformedName, e);
            return basicClass;
        }

        return writer.toByteArray();
    }

    final String[] fromPrefixes = new String[] { "org/lwjgl/", "javax/xml/bind/", "javax/servlet/" };

    final String[] toPrefixes = new String[] { "org/lwjglx/", "jakarta/xml/bind/", "jakarta/servlet/" };

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

        public EscapingClassRemapper(ClassWriter writer) {
            super(writer, LwjglRedirectTransformer.this);
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
