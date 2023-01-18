package me.eigenraven.lwjgl3ify.core;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

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
        ClassVisitor visitor = new RemappingClassAdapter(writer, this);

        try {
            reader.accept(visitor, ClassReader.EXPAND_FRAMES);
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.warn("Couldn't remap class {}", transformedName, e);
            return basicClass;
        }

        return writer.toByteArray();
    }

    @Override
    public String map(String typeName) {
        if (typeName == null) {
            return null;
        }
        calls++;
        final String OLD_PREFIX_GL = "org/lwjgl/";
        final String NEW_PREFIX_GL = "org/lwjglx/";
        final String OLD_PREFIX_PCS = "paulscode/sound/libraries/";
        final String NEW_PREFIX_PCS = "me/eigenraven/lwjgl3ify/paulscode/sound/libraries/";
        if (typeName.startsWith(OLD_PREFIX_GL)) {
            remaps++;
            final String newName = NEW_PREFIX_GL + typeName.substring(OLD_PREFIX_GL.length());
            return newName;
        } else if (typeName.startsWith(OLD_PREFIX_PCS)) {
            remaps++;
            return NEW_PREFIX_PCS + typeName.substring(OLD_PREFIX_PCS.length());
        } else {
            return typeName;
        }
    }
}
