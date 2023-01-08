package me.eigenraven.lwjgl3ify;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.commons.RemappingClassAdapter;

public class LwjglRedirectTransformer extends Remapper implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        ClassReader reader = new ClassReader(basicClass);
        ClassWriter writer = new ClassWriter(0);
        ClassVisitor visitor = new RemappingClassAdapter(writer, this);

        try {
            reader.accept(visitor, 0);
        } catch (Exception e) {
            Lwjgl3ifyCoremod.LOGGER.warn("Couldn't remap class " + name + " | " + transformedName);
            return basicClass;
        }

        return writer.toByteArray();
    }

    @Override
    public String map(String typeName) {
        final String OLD_PREFIX = "org.lwjgl.";
        final String NEW_PREFIX = "org.lwjglx.";
        if (typeName.startsWith(OLD_PREFIX)) {
            return NEW_PREFIX + typeName.substring(OLD_PREFIX.length());
        } else {
            return typeName;
        }
    }
}
