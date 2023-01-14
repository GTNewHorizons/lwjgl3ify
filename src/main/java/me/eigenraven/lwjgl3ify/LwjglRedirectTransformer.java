package me.eigenraven.lwjgl3ify;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

public class LwjglRedirectTransformer extends Remapper implements IClassTransformer {
    int remaps = 0, calls = 0;

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
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
        calls++;
        final String OLD_PREFIX = "org/lwjgl/";
        final String NEW_PREFIX = "org/lwjglx/";
        if (typeName.startsWith(OLD_PREFIX)) {
            remaps++;
            final String newName = NEW_PREFIX + typeName.substring(OLD_PREFIX.length());
            return newName;
        } else {
            return typeName;
        }
    }
}
