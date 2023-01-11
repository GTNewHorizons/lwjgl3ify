package me.eigenraven.lwjgl3ify;

import com.google.common.collect.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class ComparisonTool {
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
        final ApiSet gl2 = new ApiSet();
        final ApiSet gl3 = new ApiSet();
        final ApiSet mod = new ApiSet();
        gl2Jars.stream().forEach(path -> gl2.addJar(new File(path)));
        gl3Jars.stream().forEach(path -> gl3.addJar(new File(path)));
        modJars.stream().forEach(path -> mod.addJar(new File(path)));
        try {
            FileUtils.writeStringToFile(new File("run/gl2dump.txt"), gl2.dump(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File("run/gl3dump.txt"), gl3.dump(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File("run/moddump.txt"), mod.dump(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final File outputRoot = new File("src/generated/java/");

        for (Map.Entry<String, ApiSet.ClassApi> gl2Entry : gl2.classes.entrySet()) {
            final ApiSet.ClassApi gl2Class = gl2Entry.getValue();
            final ApiSet.ClassApi gl3Class = gl3.classes.get(gl2Entry.getKey());
            final ApiSet.ClassApi modClass = mod.classes.get(gl2Entry.getKey());
            if (modClass != null) {
                for (Map.Entry<String, MethodNode> gl2Method : gl2Class.methods.entrySet()) {
                    final MethodNode modMethod = modClass.methods.get(gl2Method.getKey());
                    if (modMethod == null) {
                        System.out.println("Missing in mod: " + gl2Entry.getKey() + " : " + gl2Method.getKey());
                    }
                }
                continue;
            }
            if (gl3Class == null) {
                System.out.println("Missing gl3: " + gl2Entry.getKey());
                continue;
            }
            System.out.println(gl2Entry.getKey());
            final StringWriter proxyClass = new StringWriter();
            final PrintWriter proxyClassP = new PrintWriter(proxyClass);
            final String javaName = gl2Class.className.replace('/', '.');
            final File javaFile = new File(outputRoot, gl2Class.className.replace("/lwjgl/", "/lwjglx/") + ".java");
            final int lastDot = javaName.lastIndexOf('.');
            final String packageName = javaName.substring(0, lastDot);
            final String className = javaName.substring(lastDot + 1);
            proxyClassP.printf(
                "package %s;%n%npublic class %s {%n",
                packageName.replace(".lwjgl.", ".lwjglx."), className);
            for (Map.Entry<String, MethodNode> gl2Method : gl2Class.methods.entrySet()) {
                if (gl2Method.getValue().name.startsWith("<")) {
                    continue;
                }
                MethodNode gl3Method = gl3Class.methods.get(gl2Method.getKey());
                String nativeCallName = null;
                for (AbstractInsnNode insn : gl2Method.getValue().instructions) {
                    if (insn instanceof MethodInsnNode) {
                        MethodInsnNode min = (MethodInsnNode) insn;
                        if (min.name.startsWith("ngl")) {
                            nativeCallName = min.name;
                        }
                    }
                }
                if (gl3Method == null && nativeCallName != null) {
                    final String maybeNewKey = nativeCallName.substring(1) + ":" + gl2Method.getValue().desc;
                    gl3Method = gl3Class.methods.get(maybeNewKey);
                }
                final Type methodType = Type.getMethodType(gl2Method.getValue().desc);
                if (gl3Method != null) {
                    // We can remap the name
                    final String[] argTypes = Arrays.stream(methodType.getArgumentTypes())
                        .map(Type::getClassName)
                        .toArray(String[]::new);
                    final String[] argNames;
                    if (gl3Method.parameters == null) {
                        argNames = IntStream.range(0, argTypes.length)
                            .mapToObj(i -> "arg" + i)
                            .toArray(String[]::new);
                    } else {
                        argNames = gl3Method.parameters.stream()
                            .map(param -> param.name)
                            .toArray(String[]::new);
                    }
                    final String[] argDefs = Streams.zip(
                            Arrays.stream(argTypes), Arrays.stream(argNames), ((t, n) -> t + " " + n))
                        .toArray(String[]::new);
                    final String argDef = StringUtils.join(argDefs, ", ");
                    final String argCall = StringUtils.join(argNames, ", ");
                    proxyClassP.printf(
                        "    public %s %s(%s) {%n",
                        methodType.getReturnType().getClassName(), gl2Method.getValue().name, argDef);
                    proxyClassP.printf(
                        "        %s%s.%s(%s);%n    }%n%n",
                        methodType.getReturnType().equals(Type.VOID_TYPE) ? "" : "return ",
                        javaName,
                        gl3Method.name,
                        argCall);
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
