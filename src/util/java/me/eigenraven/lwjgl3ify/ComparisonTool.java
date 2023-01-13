package me.eigenraven.lwjgl3ify;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

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
        final JarApiSet gl2 = new JarApiSet();
        final JarApiSet gl3 = new JarApiSet();
        final JarApiSet mod = new JarApiSet();
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

        for (Map.Entry<String, JarApiSet.ClassApi> gl2Entry : gl2.classes.entrySet()) {
            final JarApiSet.ClassApi gl2Class = gl2Entry.getValue();
            final JarApiSet.ClassApi gl3Class = gl3.classes.get(gl2Entry.getKey());
            final JarApiSet.ClassApi modClass = mod.classes.get(gl2Entry.getKey());
            if (gl2Class.className.contains("CL") || gl2Class.className.contains("opencl") || gl2Class.className.contains("opengles")) {
                continue;
            }
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
            final Map.Entry<String, JarApiSet.ClassApi> gl3Entry = gl3.classes.floorEntry(gl2Entry.getKey());
            if (!gl3Entry.getKey().equals(gl2Entry.getKey())) {
                throw new IllegalStateException();
            }
            System.out.println(gl2Entry.getKey());
            final StringWriter proxyClass = new StringWriter();
            final PrintWriter proxyClassP = new PrintWriter(proxyClass);
            final String javaName = gl2Class.className.replace('/', '.');
            final File javaFile = new File(outputRoot, gl2Class.className.replace("/lwjgl/", "/lwjglx/") + ".java");
            final int lastDot = javaName.lastIndexOf('.');
            final String packageName = javaName.substring(0, lastDot);
            final String className = javaName.substring(lastDot + 1);
            final String superName = gl2Class.asmNode.superName;
            final String extendSpec = (superName == null || "java/lang/Object".equals(superName)) ? "" : " extends " + superName.replace('/', '.').replace(".lwjgl.", ".lwjglx.");
            proxyClassP.printf(
                "package %s;%n%npublic class %s%s {%n",
                packageName.replace(".lwjgl.", ".lwjglx."), className, extendSpec);
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
