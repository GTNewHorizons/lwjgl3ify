package me.eigenraven.lwjgl3ify;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class JarApiSet {

    public final TreeMap<String, ClassApi> classes = new TreeMap<>();

    public void addJar(File jarFile) {
        if (!jarFile.exists()) {
            throw new UnsupportedOperationException("Input does not exist: " + jarFile);
        }
        try (FileInputStream fis = FileUtils.openInputStream(jarFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            JarInputStream jis = new JarInputStream(bis)) {
            JarEntry entry;
            while ((entry = jis.getNextJarEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }
                if (entry.getName()
                    .endsWith(".class")) {
                    byte[] classBytes = IOUtils.toByteArray(CloseShieldInputStream.wrap(jis));
                    addClassBytes(classBytes);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addClassBytes(byte[] bytes) {
        ClassReader classReader = new ClassReader(bytes);
        ClassNode root = new ClassNode();
        classReader.accept(root, ClassReader.EXPAND_FRAMES);
        if (root.name.contains("module-info") || root.name.contains("package-info")) {
            return;
        }
        if ((root.access & Opcodes.ACC_PUBLIC) == 0) {
            return;
        }
        String className = root.name;
        if (className.startsWith("org/lwjglx/")) {
            className = "org/lwjgl/" + StringUtils.removeStart(className, "org/lwjglx/");
        }
        final ClassApi api = new ClassApi(root);
        this.classes.put(className, api);
    }

    public static class ClassApi {

        public final ClassNode asmNode;
        public final String className;
        public final TreeMap<String, MethodNode> methods = new TreeMap<>();
        public final TreeMap<String, FieldNode> fields = new TreeMap<>();

        public ClassApi(ClassNode node) {
            this.asmNode = node;
            className = node.name;
            for (MethodNode method : node.methods) {
                if ((method.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED)) == 0) {
                    continue;
                }
                final String sig = (method.name + ":" + method.desc).replace("/lwjglx/", "/lwjgl/");
                methods.put(sig, method);
            }
            for (FieldNode field : node.fields) {
                if ((field.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED)) == 0) {
                    continue;
                }
                final String sig = (field.name + ":" + field.desc).replace("/lwjglx/", "/lwjgl/");
                fields.put(sig, field);
            }
        }

        public String dump() {
            StringBuilder builder = new StringBuilder(1024);
            builder.append("## METHODS\n");
            methods.keySet()
                .forEach(key -> {
                    builder.append(' ');
                    builder.append(key);
                    builder.append('\n');
                });
            builder.append("## FIELDS\n");
            fields.keySet()
                .forEach(key -> {
                    builder.append(' ');
                    builder.append(key);
                    builder.append('\n');
                });
            return builder.toString();
        }
    }

    public String dump() {
        StringBuilder builder = new StringBuilder(1024);
        for (Map.Entry<String, ClassApi> entry : classes.entrySet()) {
            builder.append("##### ");
            builder.append(entry.getKey());
            builder.append('\n');
            builder.append(
                entry.getValue()
                    .dump());
            builder.append('\n');
        }
        return builder.toString();
    }
}
