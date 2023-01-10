package me.eigenraven.lwjgl3ify;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ComparisonTool {
    public static void main(String[] args) {
        new ComparisonTool().run(args);
    }

    public void run(String[] args) {
        new File("run").mkdirs();
        final ArrayList<String> gl2Jars = new ArrayList<>();
        final ArrayList<String> gl3Jars = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("--2:")) {
                gl2Jars.add(StringUtils.removeStart(arg, "--2:"));
            } else if (arg.startsWith("--3:")) {
                gl3Jars.add(StringUtils.removeStart(arg, "--3:"));
            }
        }
        final ApiSet gl2 = new ApiSet();
        final ApiSet gl3 = new ApiSet();
        gl2Jars.stream().forEach(path -> gl2.addJar(new File(path)));
        gl3Jars.stream().forEach(path -> gl3.addJar(new File(path)));
        try {
            FileUtils.writeStringToFile(new File("run/gl2dump.txt"), gl2.dump(), StandardCharsets.UTF_8);
            FileUtils.writeStringToFile(new File("run/gl3dump.txt"), gl3.dump(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<String, ApiSet.ClassApi> gl2Entry : gl2.classes.entrySet()) {
            final ApiSet.ClassApi gl2Class = gl2Entry.getValue();
            final ApiSet.ClassApi gl3Class = gl3.classes.get(gl2Entry.getKey());
            if (gl3Class == null) {
                System.out.println("Missing gl3: " + gl2Entry.getKey());
                continue;
            }
            System.out.println(gl2Entry.getKey());
            for (Map.Entry<String, MethodNode> gl2Method : gl2Class.methods.entrySet()) {
                final MethodNode gl3Method = gl3Class.methods.get(gl2Method.getKey());
                String nativeCallName = null;
                if (gl2Method.getKey().startsWith("glGetProgramStage")) {
                    System.out.println('x');
                }
                for (AbstractInsnNode insn : gl2Method.getValue().instructions) {
                    if (insn instanceof MethodInsnNode) {
                        MethodInsnNode min = (MethodInsnNode) insn;
                        if (min.name.startsWith("ngl")) {
                            nativeCallName = min.name;
                        }
                    }
                }
                if (gl3Method == null) {
                    if (nativeCallName != null) {
                        final String maybeNewKey = nativeCallName.substring(1) + ":" + gl2Method.getValue().desc;
                        final MethodNode newGl3Method = gl3Class.methods.get(maybeNewKey);
                        if (newGl3Method != null) {
                            System.out.println(" * " + gl2Method.getKey() + " --> " + maybeNewKey);
                            continue;
                        }
                    }
                    System.out.println(" - " + gl2Method.getKey());
                } else {
                    // System.out.println(" + " + gl2Method.getKey());
                }
            }
        }
    }
}
