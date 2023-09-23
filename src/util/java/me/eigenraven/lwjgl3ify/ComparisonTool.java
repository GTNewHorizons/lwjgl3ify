package me.eigenraven.lwjgl3ify;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import com.google.common.collect.Streams;

public class ComparisonTool {

    final String[] EXCLUDES = new String[] { "AWTGLCanvas", "FastIntMap", "FastIntMap$Entry",
        "FastIntMap$EntryIterator", "MappedObjectClassLoader" };

    public static void main(String[] args) {
        new ComparisonTool().run(args);
    }

    public void run(String[] args) {
        new File("run").mkdirs();
        final ArrayList<String> gl2Jars = new ArrayList<>();
        final ArrayList<String> gl3Jars = new ArrayList<>();
        final ArrayList<String> modJars = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("--2:")) {
                gl2Jars.add(StringUtils.removeStart(arg, "--2:"));
            } else if (arg.startsWith("--3:")) {
                gl3Jars.add(StringUtils.removeStart(arg, "--3:"));
            } else if (arg.startsWith("--M:")) {
                modJars.add(StringUtils.removeStart(arg, "--M:"));
            }
        }
        final JarApiSet gl2 = new JarApiSet();
        final JarApiSet gl3 = new JarApiSet();
        final JarApiSet mod = new JarApiSet();
        gl2Jars.stream()
            .forEach(path -> gl2.addJar(new File(path)));
        gl3Jars.stream()
            .forEach(path -> gl3.addJar(new File(path)));
        modJars.stream()
            .forEach(path -> mod.addJar(new File(path)));
        try {
            FileUtils.writeStringToFile(new File("run/gl2dump.txt"), gl2.dump(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File("run/gl3dump.txt"), gl3.dump(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File("run/moddump.txt"), mod.dump(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final File outputRoot = new File("src/generated/java/");

        for (Map.Entry<String, JarApiSet.ClassApi> gl2Entry : gl2.classes.entrySet()) {
            final JarApiSet.ClassApi gl2Class = gl2Entry.getValue();
            final JarApiSet.ClassApi gl3Class = gl3.classes.get(gl2Entry.getKey());
            final JarApiSet.ClassApi modClass = mod.classes.get(gl2Entry.getKey());
            if (gl2Class.className.contains("CL") || gl2Class.className.contains("opencl")
                || gl2Class.className.contains("opengles")) {
                continue;
            }
            if (modClass != null) {
                for (Map.Entry<String, MethodNode> gl2Method : gl2Class.methods.entrySet()) {
                    final MethodNode modMethod = modClass.methods.get(gl2Method.getKey());
                    if (modMethod == null) {
                        System.out.println("Missing in mod: " + gl2Entry.getKey() + " : " + gl2Method.getKey());
                    }
                }
            }

            final boolean existsInGl3 = (gl3Class != null);
            if (Arrays.stream(EXCLUDES)
                .anyMatch(gl2Class.className::endsWith)) {
                continue;
            }

            final StringWriter proxyClass = new StringWriter();
            final PrintWriter proxyClassP = new PrintWriter(proxyClass);
            final String javaName = gl2Class.className.replace('/', '.');
            final String transformedClassName = existsInGl3 ? gl2Class.className.replace("/lwjgl/", "/lwjglx/")
                : gl2Class.className;
            final File javaFile = new File(outputRoot, transformedClassName + ".java");
            final int lastDot = javaName.lastIndexOf('.');
            final String packageName = javaName.substring(0, lastDot);
            final String transformedPackageName = existsInGl3 ? javaName.substring(0, lastDot)
                .replace(".lwjgl.", ".lwjglx.") : javaName.substring(0, lastDot);
            final String className = javaName.substring(lastDot + 1);
            String classType = "class";
            if ((gl2Class.asmNode.access & Opcodes.ACC_INTERFACE) != 0) {
                classType = "interface";
            } else if ((gl2Class.asmNode.access & Opcodes.ACC_ABSTRACT) != 0) {
                classType = "abstract class";
            }
            final String superName = gl2Class.asmNode.superName.replace('/', '.');
            final String extendSpec = (superName == null || "java.lang.Object".equals(superName)) ? ""
                : " extends " + (existsInGl3 ? superName.replace(".lwjgl.", ".lwjglx.") : superName);
            proxyClassP
                .printf("package %s;%n%npublic %s %s%s {%n", transformedPackageName, classType, className, extendSpec);

            for (FieldNode gl2Field : gl2Class.fields.values()) {
                if (gl2Field.name.contains("<")) {
                    continue;
                }
                if ((gl2Field.access & Opcodes.ACC_PUBLIC) == 0) {
                    continue;
                }
                if ((gl2Field.access & Opcodes.ACC_SYNTHETIC) != 0) {
                    continue;
                }
                String protKws = "";
                if ((gl2Field.access & Opcodes.ACC_STATIC) != 0) {
                    protKws += " static";
                }
                final boolean isFinal = (gl2Field.access & Opcodes.ACC_FINAL) != 0;
                if (isFinal) {
                    protKws += " final";
                }
                String initializer;
                final String fieldType = Type.getType(gl2Field.desc)
                    .getClassName();
                if (gl2Field.value == null) {
                    switch (Type.getType(gl2Field.desc)
                        .getClassName()) {
                        case "boolean":
                            initializer = " = false";
                            break;
                        case "byte":
                        case "char":
                        case "short":
                        case "int":
                        case "long":
                            initializer = " = 0";
                            break;
                        case "float":
                            initializer = " = 0.0F";
                            break;
                        case "double":
                            initializer = " = 0.0D";
                            break;
                        default:
                            initializer = " = null";
                            break;
                    }
                } else {
                    initializer = " = (" + fieldType + ") " + gl2Field.value;
                    if (gl2Field.value instanceof Float) {
                        initializer += "F";
                    } else if (gl2Field.value instanceof String) {
                        initializer = " = \"" + StringEscapeUtils.escapeJava((String) gl2Field.value) + "\"";
                    }
                }
                proxyClassP.printf(
                    "        public%s %s %s%s;%n",
                    protKws,
                    existsInGl3 ? fieldType.replace("org.lwjgl.", "org.lwjglx.") : fieldType,
                    gl2Field.name,
                    initializer);
            }

            if (!existsInGl3) {
                System.out.println("Missing gl3: " + gl2Entry.getKey());
                // Generate a dummy class for mixins etc. to have a reference

                for (MethodNode gl2Method : gl2Class.methods.values()) {
                    if (gl2Method.name.startsWith("<")) {
                        continue;
                    }
                    if ((gl2Method.access & Opcodes.ACC_PUBLIC) == 0) {
                        continue;
                    }
                    if ((gl2Method.access & Opcodes.ACC_SYNTHETIC) != 0) {
                        continue;
                    }
                    String protKws = "";
                    String body = " {throw new UnsupportedOperationException();}";
                    if ((gl2Method.access & Opcodes.ACC_STATIC) != 0) {
                        protKws += " static";
                    }
                    if ((gl2Method.access & Opcodes.ACC_FINAL) != 0) {
                        protKws += " final";
                    }
                    if ((gl2Method.access & Opcodes.ACC_ABSTRACT) != 0) {
                        protKws += " abstract";
                        body = ";";
                    }
                    final Type mType = Type.getMethodType(gl2Method.desc);
                    final String retType = mType.getReturnType()
                        .getClassName();
                    final String[] argTypes = Arrays.stream(mType.getArgumentTypes())
                        .map(Type::getClassName)
                        .toArray(String[]::new);
                    final String[] argNames = IntStream.range(0, argTypes.length)
                        .mapToObj(i -> "arg" + i)
                        .toArray(String[]::new);
                    final String argDefs = StringUtils.join(
                        Streams.zip(Arrays.stream(argTypes), Arrays.stream(argNames), (t, n) -> t + " " + n)
                            .toArray(String[]::new),
                        ", ");
                    proxyClassP
                        .printf("        public%s %s %s(%s)%s%n", protKws, retType, gl2Method.name, argDefs, body);
                }

                proxyClassP.printf("%n}%n");
                proxyClassP.flush();
                try {
                    FileUtils.forceMkdirParent(javaFile);
                    FileUtils.writeStringToFile(javaFile, proxyClass.toString(), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                continue;
            }
            if (modClass != null) {
                continue;
            }
            final Map.Entry<String, JarApiSet.ClassApi> gl3Entry = gl3.classes.floorEntry(gl2Entry.getKey());
            if (!gl3Entry.getKey()
                .equals(gl2Entry.getKey())) {
                throw new IllegalStateException();
            }
            System.out.println(gl2Entry.getKey());
            for (Map.Entry<String, MethodNode> gl2Method : gl2Class.methods.entrySet()) {
                if (gl2Method.getValue().name.startsWith("<")) {
                    continue;
                }
                final MethodMatcher matcher = new MethodMatcher(gl2, gl3, gl2Entry, gl3Entry, gl2Method);
                final MethodRedirector redirector = matcher.findMatch();
                if (redirector != null) {
                    redirector.outputRedirector(proxyClassP);
                } else {
                    System.out.println(" - " + gl2Method.getKey());
                }
            }
            proxyClassP.printf("%n}%n");
            proxyClassP.flush();
            try {
                FileUtils.forceMkdirParent(javaFile);
                FileUtils.writeStringToFile(javaFile, proxyClass.toString(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
