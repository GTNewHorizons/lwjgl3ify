package me.eigenraven.lwjgl3ify;

import java.io.PrintWriter;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import com.google.common.collect.Streams;

public abstract class MethodRedirector {

    public final MethodMatcher matcher;

    public final String javaClassName;

    public final String access;
    private final String packageName;
    private final String className;

    protected MethodRedirector(MethodMatcher matcher) {
        this.matcher = matcher;

        String access = ((matcher.oldMethod.access & Opcodes.ACC_PROTECTED) == 0) ? "public" : "protected";
        if ((matcher.oldMethod.access & Opcodes.ACC_STATIC) != 0) {
            access = access + " static";
        }
        this.access = access;
        this.javaClassName = matcher.oldClassNode.getValue().className.replace('/', '.')
            .replace(".lwjglx.", ".lwjgl.");
        final int lastDot = javaClassName.lastIndexOf('.');
        this.packageName = javaClassName.substring(0, lastDot);
        this.className = javaClassName.substring(lastDot + 1);
    }

    public void outputRedirector(final PrintWriter writer) {
        final String[] argDefs = Streams
            .zip(Arrays.stream(matcher.argTypes), Arrays.stream(matcher.argNames), ((t, n) -> t + " " + n))
            .toArray(String[]::new);
        final String argDef = StringUtils.join(argDefs, ", ");
        writer.printf(
            "    %s %s %s(%s) {%n",
            access,
            matcher.methodType.getReturnType()
                .getClassName()
                .replace(".lwjgl.", ".lwjglx."),
            matcher.oldMethod.name,
            argDef);
        this.writeBody(writer);
        writer.printf("    }%n%n");
    }

    protected abstract void writeBody(final PrintWriter writer);

    public static class DirectMethodRedirector extends MethodRedirector {

        public final MethodNode newMethod;

        public DirectMethodRedirector(MethodMatcher matcher, MethodNode newMethod) {
            super(matcher);
            this.newMethod = newMethod;
        }

        @Override
        protected void writeBody(PrintWriter writer) {
            final String argCall = StringUtils.join(matcher.argNames, ", ");
            writer.printf(
                "        %s%s.%s(%s);%n",
                matcher.methodType.getReturnType()
                    .equals(Type.VOID_TYPE) ? "" : "return ",
                this.javaClassName,
                newMethod.name,
                argCall);
        }
    }

    public static class TransformingRedirector extends DirectMethodRedirector {

        public final String preCode, postCode;
        public final String[] argumentReplacements;

        public TransformingRedirector(MethodMatcher matcher, MethodNode newMethod, String preCode, String postCode,
            String[] argumentReplacements) {
            super(matcher, newMethod);
            this.preCode = preCode;
            this.postCode = postCode;
            this.argumentReplacements = argumentReplacements;
        }

        @Override
        protected void writeBody(PrintWriter writer) {
            final String[] transformedArgNames = Arrays
                .copyOf(matcher.argNames, Math.max(matcher.argNames.length, argumentReplacements.length));
            for (int i = 0; i < transformedArgNames.length; i++) {
                if (i < argumentReplacements.length && argumentReplacements[i] != null) {
                    transformedArgNames[i] = argumentReplacements[i];
                }
            }
            final String argCall = StringUtils.join(transformedArgNames, ", ");
            if (preCode != null) {
                writer.println(preCode);
            }
            if (matcher.methodType.getReturnType()
                .equals(Type.VOID_TYPE)) {
                writer.printf("        %s.%s(%s);%n", this.javaClassName, newMethod.name, argCall);
            } else {
                final String retType = matcher.methodType.getReturnType()
                    .getClassName()
                    .replace(".lwjgl.", ".lwjglx.");
                String preRet = "", postRet = "";
                if (retType.endsWith("ALCdevice")) {
                    preRet = "new org.lwjglx.openal.ALCdevice(";
                    postRet = ")";
                }
                if (retType.endsWith("GLSync")) {
                    preRet = "new org.lwjglx.opengl.GLSync(";
                    postRet = ")";
                }
                writer.printf(
                    "        %s returnValue = %s%s.%s(%s)%s;%n",
                    retType,
                    preRet,
                    this.javaClassName,
                    newMethod.name,
                    argCall,
                    postRet);
            }
            if (postCode != null) {
                writer.println(postCode);
            }
            if (!matcher.methodType.getReturnType()
                .equals(Type.VOID_TYPE)) {
                writer.println("        return returnValue;");
            }
        }
    }
}
