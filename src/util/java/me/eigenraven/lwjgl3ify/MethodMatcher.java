package me.eigenraven.lwjgl3ify;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.LocalVariableNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class MethodMatcher {

    public final JarApiSet oldApi, newApi;
    public final Map.Entry<String, JarApiSet.ClassApi> oldClassNode;
    public final Map.Entry<String, JarApiSet.ClassApi> newClassNode;
    public final Map.Entry<String, MethodNode> oldMethodNode;
    public final MethodNode oldMethod;
    public final Type methodType;
    public final String[] argTypes;
    public final String[] argNames;

    public static String[] getArgumentNames(MethodNode method) {
        Type[] asmTypes = Type.getMethodType(method.desc)
            .getArgumentTypes();
        String[] argNames = new String[asmTypes.length];
        for (int i = 0; i < argNames.length; i++) {
            if (method.localVariables != null && method.localVariables.size() > i) {
                final LocalVariableNode lvar = method.localVariables.get(i);
                if (lvar.desc.equals(asmTypes[i].getDescriptor())) {
                    argNames[i] = lvar.name;
                }
            }
            if (argNames[i] == null) {
                argNames[i] = "arg" + i;
            }
        }
        return argNames;
    }

    public MethodMatcher(JarApiSet oldApi, JarApiSet newApi, Map.Entry<String, JarApiSet.ClassApi> oldClassNode,
        Map.Entry<String, JarApiSet.ClassApi> newClassNode, Map.Entry<String, MethodNode> oldMethodNode) {
        this.oldApi = oldApi;
        this.newApi = newApi;
        this.oldClassNode = oldClassNode;
        this.newClassNode = newClassNode;
        this.oldMethodNode = oldMethodNode;
        this.oldMethod = oldMethodNode.getValue();
        this.methodType = Type.getMethodType(oldMethod.desc);
        Type[] asmTypes = methodType.getArgumentTypes();
        this.argTypes = Arrays.stream(asmTypes)
            .map(Type::getClassName)
            .toArray(String[]::new);
        this.argNames = getArgumentNames(oldMethod);
    }

    public MethodRedirector findMatch() {
        // Try 1:1 match first
        {
            final MethodNode directMatch = newClassNode.getValue().methods.get(oldMethodNode.getKey());
            if (directMatch != null) {
                System.out.println(" + " + oldMethodNode.getKey());
                return new MethodRedirector.DirectMethodRedirector(this, directMatch);
            }
        }
        // Find by native name
        String nativeCallName = null;
        {
            for (AbstractInsnNode insn : oldMethod.instructions) {
                if (insn instanceof MethodInsnNode) {
                    MethodInsnNode min = (MethodInsnNode) insn;
                    if (min.name.startsWith("ngl") || min.name.startsWith("nal")) {
                        nativeCallName = min.name;
                        break;
                    }
                }
            }
            if (nativeCallName != null) {
                if (nativeCallName.endsWith("B0")) {
                    nativeCallName = StringUtils.removeEnd(nativeCallName, "BO");
                }
                final String maybeNewKey = nativeCallName.substring(1) + ":" + oldMethod.desc;
                final MethodNode nglMatch = newClassNode.getValue().methods.get(maybeNewKey);
                if (nglMatch != null) {
                    System.out.println(" > " + oldMethodNode.getKey() + " --> " + maybeNewKey);
                    return new MethodRedirector.DirectMethodRedirector(this, nglMatch);
                }
            }
        }
        final String bufferArg = Arrays.stream(argTypes)
            .filter(a -> a.contains("Buffer"))
            .findFirst()
            .orElse(null);
        final int bufferArgIdx = ArrayUtils.indexOf(argTypes, bufferArg);
        // Check if adding a type is enough
        if (nativeCallName != null) {
            final String descWithType = (nativeCallName.substring(1) + ":(I" + oldMethod.desc.substring(1))
                .replace("DoubleBuffer", "ByteBuffer");
            final MethodNode withTypeMatch = newClassNode.getValue().methods.get(descWithType);
            if (withTypeMatch != null) {
                final String[] newArgNames = getArgumentNames(withTypeMatch);
                final int typeArg = ArrayUtils.indexOf(newArgNames, "type");
                if (typeArg >= 0 && bufferArg != null) {
                    final String glType;
                    String[] changedArgs = ArrayUtils.clone(argNames);
                    switch (bufferArg) {
                        case "java.nio.ByteBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_BYTE";
                            break;
                        case "java.nio.ShortBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_SHORT";
                            break;
                        case "java.nio.IntBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_INT";
                            break;
                        case "java.nio.LongBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_LONG";
                            break;
                        case "java.nio.FloatBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_FLOAT";
                            break;
                        case "java.nio.DoubleBuffer":
                            glType = "org.lwjgl.opengl.GL11.GL_DOUBLE";
                            changedArgs[bufferArgIdx] = "me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer("
                                + changedArgs[bufferArgIdx]
                                + ")";
                            break;
                        default:
                            throw new IllegalStateException(bufferArg);
                    }
                    changedArgs = ArrayUtils.insert(typeArg, changedArgs, glType);
                    System.out.println(" > " + oldMethodNode.getKey() + " --> " + descWithType + " @" + glType);
                    return new MethodRedirector.TransformingRedirector(this, withTypeMatch, "", "", changedArgs);
                }
            }
        }
        // Remap argument types because lwjgl2's generator was not very smart
        if (nativeCallName != null) {
            final String newKey = nativeCallName.substring(1) + ":";
            final Map.Entry<String, MethodNode> fuzzyMatch = newClassNode.getValue().methods.ceilingEntry(newKey);
            if (fuzzyMatch.getValue().name.equals(nativeCallName.substring(1))) {
                final Type newType = Type.getMethodType(fuzzyMatch.getValue().desc);
                final String[] newArgTypes = Arrays.stream(newType.getArgumentTypes())
                    .map(Type::getClassName)
                    .toArray(String[]::new);
                boolean success = true;
                if (newArgTypes.length == argTypes.length) {
                    final StringBuilder preCode = new StringBuilder();
                    final StringBuilder postCode = new StringBuilder();
                    final String[] changedArgs = new String[newArgTypes.length];
                    final String[] newArgNames = getArgumentNames(fuzzyMatch.getValue());
                    for (int i = 0; i < newArgTypes.length; i++) {
                        final String oldArgType = argTypes[i];
                        final String newArgType = newArgTypes[i];
                        List<AnnotationNode>[] paramAnnotations = fuzzyMatch.getValue().visibleParameterAnnotations;
                        String newNativeType = "";
                        if (paramAnnotations != null && paramAnnotations.length > i && !paramAnnotations[i].isEmpty()) {
                            for (AnnotationNode annotation : paramAnnotations[i]) {
                                if (annotation.desc.equals("Lorg/lwjgl/system/NativeType;")) {
                                    newNativeType = annotation.values.get(1)
                                        .toString()
                                        .trim();
                                }
                            }
                        }
                        if (!oldArgType.equals(newArgType)) {
                            if (newArgType.startsWith("java.nio.") && newArgType.endsWith("Buffer")
                                && oldArgType.startsWith("java.nio.")
                                && oldArgType.endsWith("Buffer")) {
                                final String oldBufferType = StringUtils.removeStart(oldArgType, "java.nio.");
                                final String newBufferType = StringUtils.removeStart(newArgType, "java.nio.");
                                preCode.append("        final java.nio.ByteBuffer wrappedArg");
                                preCode.append(i);
                                preCode.append(" = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(");
                                preCode.append(argNames[i]);
                                preCode.append(");");
                                preCode.append(System.lineSeparator());
                                changedArgs[i] = "wrappedArg" + i;
                                if (!newBufferType.equals("ByteBuffer")) {
                                    changedArgs[i] += ".as" + newBufferType + "()";
                                }
                                postCode.append("        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(");
                                postCode.append(argNames[i]);
                                postCode.append(", wrappedArg");
                                postCode.append(i);
                                postCode.append(");");
                                postCode.append(System.lineSeparator());
                            } else if (newArgType.equals("long") && oldArgType.equals("org.lwjgl.openal.ALCdevice")) {
                                argTypes[i] = "org.lwjglx.openal.ALCdevice";
                                changedArgs[i] = argNames[i] + ".device";
                            } else if (newArgType.equals("java.lang.CharSequence")
                                && oldArgType.equals("java.lang.String")) {
                                    // no-op
                                } else if ((newArgType.equals("java.nio.IntBuffer") || newArgType.equals("int[]"))
                                    && oldArgType.equals("int")) {
                                        changedArgs[i] = "new int[]{" + argNames[i] + "}";
                                    } else if ((newArgType.equals("java.nio.LongBuffer") || newArgType.equals("long[]"))
                                        && oldArgType.equals("long")) {
                                            changedArgs[i] = "new long[]{" + argNames[i] + "}";
                                        } else if (newArgType.equals("long") && newNativeType.endsWith("*")
                                            && oldArgType.startsWith("java.nio.")
                                            && oldArgType.endsWith("Buffer")) {
                                                changedArgs[i] = "org.lwjglx.MemoryUtil.getAddress(" + argNames[i]
                                                    + ")";
                                            } else if (newArgType.equals("java.lang.CharSequence")
                                                && oldArgType.equals("java.nio.ByteBuffer")) {
                                                    changedArgs[i] = "me.eigenraven.lwjgl3ify.BufferCasts.bufferToCharSeq("
                                                        + argNames[i]
                                                        + ")";
                                                } else if (newArgType.equals("int") && oldArgType.equals("boolean")
                                                    && argNames[i].equals("unsigned")
                                                    && newArgNames[i].equals("type")) {
                                                        final String newArg;
                                                        switch (bufferArg) {
                                                            case "java.nio.ByteBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE : org.lwjgl.opengl.GL11.GL_BYTE)";
                                                                break;
                                                            case "java.nio.ShortBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT : org.lwjgl.opengl.GL11.GL_SHORT)";
                                                                break;
                                                            case "java.nio.IntBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_INT : org.lwjgl.opengl.GL11.GL_INT)";
                                                                break;
                                                            case "java.nio.LongBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_LONG : org.lwjgl.opengl.GL11.GL_LONG)";
                                                                break;
                                                            case "java.nio.FloatBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_FLOAT : org.lwjgl.opengl.GL11.GL_FLOAT)";
                                                                break;
                                                            case "java.nio.DoubleBuffer":
                                                                newArg = "(unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_DOUBLE : org.lwjgl.opengl.GL11.GL_DOUBLE)";
                                                                changedArgs[bufferArgIdx] = "me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer("
                                                                    + changedArgs[bufferArgIdx]
                                                                    + ")";
                                                                break;
                                                            default:
                                                                throw new IllegalStateException(bufferArg);
                                                        }
                                                        changedArgs[i] = newArg;
                                                    } else {
                                                        success = false;
                                                        System.out.println(
                                                            new UnsupportedOperationException(
                                                                oldArgType + " -> "
                                                                    + newArgType
                                                                    + " in "
                                                                    + oldClassNode.getKey()
                                                                    + " : "
                                                                    + oldMethodNode.getKey()).toString());
                                                    }
                        }
                    }
                    if (success) {
                        return new MethodRedirector.TransformingRedirector(
                            this,
                            fuzzyMatch.getValue(),
                            preCode.toString(),
                            postCode.toString(),
                            changedArgs);
                    }
                }
            }
        }
        // Find in superclass if possible
        final String superName = newClassNode.getValue().asmNode.superName;
        if (superName.startsWith("org/lwjgl")) {
            final JarApiSet.ClassApi superClass = newApi.classes.get(superName);
            if (superClass == null) {
                throw new IllegalStateException();
            }
            return new MethodMatcher(oldApi, newApi, oldClassNode, newApi.classes.floorEntry(superName), oldMethodNode)
                .findMatch();
        }
        return null;
    }
}
