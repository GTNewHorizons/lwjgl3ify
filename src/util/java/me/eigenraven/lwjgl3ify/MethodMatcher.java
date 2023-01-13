package me.eigenraven.lwjgl3ify;

import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class MethodMatcher {
    public final JarApiSet oldApi, newApi;
    public final Map.Entry<String, JarApiSet.ClassApi> oldClassNode;
    public final Map.Entry<String, JarApiSet.ClassApi> newClassNode;
    public final Map.Entry<String, MethodNode> oldMethodNode;
    public final MethodNode oldMethod;
    public final Type methodType;
    public final String[] argTypes;
    public final String[] argNames;

    public MethodMatcher(JarApiSet oldApi, JarApiSet newApi, Map.Entry<String, JarApiSet.ClassApi> oldClassNode, Map.Entry<String, JarApiSet.ClassApi> newClassNode, Map.Entry<String, MethodNode> oldMethodNode) {
        this.oldApi = oldApi;
        this.newApi = newApi;
        this.oldClassNode = oldClassNode;
        this.newClassNode = newClassNode;
        this.oldMethodNode = oldMethodNode;
        this.oldMethod = oldMethodNode.getValue();
        this.methodType = Type.getMethodType(oldMethod.desc);
        this.argTypes = Arrays.stream(methodType.getArgumentTypes())
            .map(Type::getClassName)
            .toArray(String[]::new);
        if (oldMethod.parameters == null) {
            this.argNames = IntStream.range(0, argTypes.length)
                .mapToObj(i -> "arg" + i)
                .toArray(String[]::new);
        } else {
            this.argNames = oldMethod.parameters.stream()
                .map(param -> param.name)
                .toArray(String[]::new);
        }
    }

    public MethodRedirector findMatch() {
        // Try 1:1 match first
        {
            final MethodNode directMatch = newClassNode.getValue().methods.get(oldMethodNode.getKey());
            if (directMatch != null) {
                System.out.println(" + " + oldMethodNode.getKey());
                return new MethodRedirector.DirectMethodRedirector(oldApi, newApi, oldClassNode, oldMethodNode, directMatch);
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
                final String maybeNewKey = nativeCallName.substring(1) + ":" + oldMethod.desc;
                final MethodNode nglMatch = newClassNode.getValue().methods.get(maybeNewKey);
                if (nglMatch != null) {
                    System.out.println(" > " + oldMethodNode.getKey() + " --> " + maybeNewKey);
                    return new MethodRedirector.DirectMethodRedirector(oldApi, newApi, oldClassNode, oldMethodNode, nglMatch);
                }
            }
        }
        // Remap argument types because lwjgl2's generator was not very smart
        if (nativeCallName != null) {
            final String newKey = nativeCallName.substring(1) + ":";
            final Map.Entry<String, MethodNode> fuzzyMatch = newClassNode.getValue().methods.ceilingEntry(newKey);
            if (fuzzyMatch.getValue().name.equals(nativeCallName.substring(1))) {
                final Type newType = Type.getMethodType(fuzzyMatch.getValue().desc);
                final String[] newArgTypes = Arrays.stream(newType.getArgumentTypes()).map(Type::getClassName).toArray(String[]::new);
                boolean success = true;
                if (newArgTypes.length == argTypes.length) {
                    final StringBuilder preCode = new StringBuilder();
                    final StringBuilder postCode = new StringBuilder();
                    final String[] changedArgs = new String[newArgTypes.length];
                    for (int i = 0; i < newArgTypes.length; i++) {
                        final String oldArgType = argTypes[i];
                        final String newArgType = newArgTypes[i];
                        if (!oldArgType.equals(newArgType)) {
                            if (newArgType.startsWith("java.nio.") && newArgType.endsWith("Buffer") && oldArgType.startsWith("java.nio.") && oldArgType.endsWith("Buffer")) {
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
                                changedArgs[i] = argNames[i] + ".device";
                            } else if (newArgType.equals("java.lang.CharSequence") && oldArgType.equals("java.lang.String")) {
                                // no-op
                            } else if ((newArgType.equals("java.nio.IntBuffer") || newArgType.equals("int[]")) && oldArgType.equals("int")) {
                                changedArgs[i] = "new int[]{" + argNames[i] + "}";
                            } else if ((newArgType.equals("java.nio.LongBuffer") || newArgType.equals("long[]")) && oldArgType.equals("long")) {
                                changedArgs[i] = "new long[]{" + argNames[i] + "}";
                            } else if (newArgType.equals("long") && oldArgType.startsWith("java.nio.") && oldArgType.endsWith("Buffer")) {
                                changedArgs[i] = "org.lwjglx.MemoryUtil.getAddress(" + argNames[i] + ")";
                            } else if (newArgType.equals("java.lang.CharSequence") && oldArgType.equals("java.nio.ByteBuffer")) {
                                changedArgs[i] = "me.eigenraven.lwjgl3ify.BufferCasts.bufferToCharSeq(" + argNames[i] + ")";
                            }
                            else {
                                success = false;
                                System.out.println(new UnsupportedOperationException(oldArgType + " -> " + newArgType + " in " + oldClassNode.getKey() + " : " + oldMethodNode.getKey()).toString());
                            }
                        }
                    }
                    if (success) {
                        return new MethodRedirector.TransformingRedirector(oldApi, newApi, oldClassNode, oldMethodNode, fuzzyMatch.getValue(), preCode.toString(), postCode.toString(), changedArgs);
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
            return new MethodMatcher(oldApi, newApi, oldClassNode, newApi.classes.floorEntry(superName), oldMethodNode).findMatch();
        }
        return null;
    }
}
