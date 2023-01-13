
package me.eigenraven.lwjgl3ify;

import com.google.common.collect.Streams;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import java.util.stream.IntStream;

public abstract class MethodRedirector {
    public final JarApiSet oldApi, newApi;
    public final Map.Entry<String, JarApiSet.ClassApi> oldClassNode;
    public final Map.Entry<String, MethodNode> oldMethodNode;
    public final MethodNode oldMethod;

    public final String javaClassName;

    public final Type methodType;
    public final String[] argTypes;
    public final String[] argNames;
    public final String access;
    private final String packageName;
    private final String className;

    protected MethodRedirector(JarApiSet oldApi, JarApiSet newApi, Map.Entry<String, JarApiSet.ClassApi> oldClassNode, Map.Entry<String, MethodNode> oldMethodNode) {
        this.oldApi = oldApi;
        this.newApi = newApi;
        this.oldClassNode = oldClassNode;
        this.oldMethodNode = oldMethodNode;
        this.oldMethod = oldMethodNode.getValue();
        this.methodType = Type.getMethodType(oldMethod.desc);
        this.argTypes = Arrays.stream(methodType.getArgumentTypes())
            .map(Type::getClassName)
            .map(t -> t.replace(".lwjgl.", ".lwjglx."))
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
        String access = ((oldMethod.access & Opcodes.ACC_PROTECTED) == 0) ? "public" : "protected";
        if ((oldMethod.access & Opcodes.ACC_STATIC) != 0) {
            access = access + " static";
        }
        this.access = access;
        this.javaClassName = oldClassNode.getValue().className.replace('/', '.').replace(".lwjglx.", ".lwjgl.");
        final int lastDot = javaClassName.lastIndexOf('.');
        this.packageName = javaClassName.substring(0, lastDot);
        this.className = javaClassName.substring(lastDot + 1);
    }

    public void outputRedirector(final PrintWriter writer) {
        final String[] argDefs = Streams.zip(
                Arrays.stream(argTypes), Arrays.stream(argNames), ((t, n) -> t + " " + n))
            .toArray(String[]::new);
        final String argDef = StringUtils.join(argDefs, ", ");
        writer.printf(
            "    %s %s %s(%s) {%n",
            access, methodType.getReturnType().getClassName().replace(".lwjgl.", ".lwjglx."), oldMethod.name, argDef);
        this.writeBody(writer);
        writer.printf("    }%n%n");
    }

    protected abstract void writeBody(final PrintWriter writer);

    public static class DirectMethodRedirector extends MethodRedirector {

        public final MethodNode newMethod;

        public DirectMethodRedirector(JarApiSet oldApi, JarApiSet newApi, Map.Entry<String, JarApiSet.ClassApi> oldClassNode, Map.Entry<String, MethodNode> oldMethodNode, MethodNode newMethod) {
            super(oldApi, newApi, oldClassNode, oldMethodNode);
            this.newMethod = newMethod;
        }

        @Override
        protected void writeBody(PrintWriter writer) {
            final String argCall = StringUtils.join(argNames, ", ");
            writer.printf(
                "        %s%s.%s(%s);%n",
                methodType.getReturnType().equals(Type.VOID_TYPE) ? "" : "return ",
                this.javaClassName,
                newMethod.name,
                argCall);
        }
    }

    public static class TransformingRedirector extends DirectMethodRedirector {
        public final String preCode, postCode;
        public final String[] argumentReplacements;

        public TransformingRedirector(JarApiSet oldApi, JarApiSet newApi, Map.Entry<String, JarApiSet.ClassApi> oldClassNode, Map.Entry<String, MethodNode> oldMethodNode, MethodNode newMethod, String preCode, String postCode, String[] argumentReplacements) {
            super(oldApi, newApi, oldClassNode, oldMethodNode, newMethod);
            this.preCode = preCode;
            this.postCode = postCode;
            this.argumentReplacements = argumentReplacements;
        }

        @Override
        protected void writeBody(PrintWriter writer) {
            final String[] transformedArgNames = Arrays.copyOf(argNames, argNames.length);
            for (int i = 0; i < transformedArgNames.length; i++) {
                if (i < argumentReplacements.length && argumentReplacements[i] != null) {
                    transformedArgNames[i] = argumentReplacements[i];
                }
            }
            final String argCall = StringUtils.join(transformedArgNames, ", ");
            if (preCode != null) { writer.println(preCode);}
            writer.printf(
                "        %s%s.%s(%s);%n",
                methodType.getReturnType().equals(Type.VOID_TYPE) ? "" : methodType.getReturnType().getClassName().replace(".lwjgl.", ".lwjglx.") + " returnValue = ",
                this.javaClassName,
                newMethod.name,
                argCall);
            if (postCode != null) { writer.println(postCode);}
            if (!methodType.getReturnType().equals(Type.VOID_TYPE)) {
                writer.println("        return returnValue;");
            }
        }
    }
}
