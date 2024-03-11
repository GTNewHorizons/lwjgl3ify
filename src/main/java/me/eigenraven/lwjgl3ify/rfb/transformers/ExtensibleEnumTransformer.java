package me.eigenraven.lwjgl3ify.rfb.transformers;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import com.gtnewhorizons.retrofuturabootstrap.api.ClassNodeHandle;
import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

import me.eigenraven.lwjgl3ify.IExtensibleEnum;
import me.eigenraven.lwjgl3ify.api.MakeEnumExtensible;
import me.eigenraven.lwjgl3ify.rfb.EarlyConfig;

public class ExtensibleEnumTransformer implements RfbClassTransformer {

    private final Logger LOGGER = LogManager.getLogger("lwjgl3ify");
    private final Type STRING = Type.getType(String.class);
    private final Type ENUM = Type.getType(Enum.class);
    public final Type MARKER_IFACE = Type.getType(IExtensibleEnum.class);
    public final Type MARKER_ANNOTATION = Type.getType(MakeEnumExtensible.class);
    private final Type ARRAY_UTILS = Type.getType("Lorg/apache/commons/lang3/ArrayUtils;"); // Don't directly reference
    // this to prevent class
    // loading.
    private final String ADD_DESC = Type
        .getMethodDescriptor(Type.getType(Object[].class), Type.getType(Object[].class), Type.getType(Object.class));
    private final Type UNSAFE_HACKS = Type.getType("Lme/eigenraven/lwjgl3ify/UnsafeHacks;"); // Again, not direct
    // reference to prevent
    // class loading.
    private final String CLEAN_DESC = Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(Class.class));
    private final String NAME_DESC = Type.getMethodDescriptor(STRING);
    private final String EQUALS_DESC = Type.getMethodDescriptor(Type.BOOLEAN_TYPE, STRING);
    public static final String CREATE_METHOD_NAME = "dynamicCreate";

    @Pattern("[a-z0-9-]+")
    @Override
    public @NotNull String id() {
        return "extensible-enum";
    }

    @Override
    public boolean shouldTransformClass(@NotNull ExtensibleClassLoader extensibleClassLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String className,
        @NotNull ClassNodeHandle classNodeHandle) {
        return classNodeHandle.getFastAccessor() != null && classNodeHandle.getFastAccessor()
            .isEnum();
    }

    @Override
    public void transformClass(@NotNull ExtensibleClassLoader extensibleClassLoader,
        @NotNull RfbClassTransformer.Context context, @Nullable Manifest manifest, @NotNull String className,
        @NotNull ClassNodeHandle classNodeHandle) {
        final Type classType = Type.getObjectType(className.replace('.', '/'));
        final ClassNode classNode = classNodeHandle.getNode();
        if (classNode == null) {
            return;
        }

        if (EarlyConfig.EXTENSIBLE_ENUMS.contains(className)) {
            if (classNode.interfaces == null) {
                classNode.interfaces = new ArrayList<>(1);
            }
            classNode.interfaces.add(MARKER_IFACE.getInternalName());
        }

        Type array = Type.getType("[" + classType.getDescriptor());
        final int flags = Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC;

        final FieldNode values = classNode.fields.stream()
            .filter(f -> f.desc.contentEquals(array.getDescriptor()) && ((f.access & flags) == flags))
            .findFirst()
            .orElse(
                classNode.fields.stream()
                    .filter(f -> f.desc.contentEquals(array.getDescriptor()) && f.name.equals("$VALUES"))
                    .findFirst()
                    .orElse(null));

        boolean process = false;
        if (classNode.interfaces.contains(MARKER_IFACE.getInternalName())) {
            process = true;
        } else if (classNode.visibleAnnotations != null && !classNode.visibleAnnotations.isEmpty()) {
            for (AnnotationNode annotation : classNode.visibleAnnotations) {
                if (annotation.desc.equals(MARKER_ANNOTATION.getDescriptor())) {
                    process = true;
                }
            }
        }
        if (!process) {
            return;
        }

        classNodeHandle.computeMaxs();
        classNodeHandle.computeFrames();

        List<MethodNode> constructors = classNode.methods.stream()
            .filter(m -> m.name.equals("<init>"))
            .collect(Collectors.toList());

        // Static methods named "create" with first argument as a string
        List<MethodNode> candidates = constructors.stream()
            .map(ctor -> {
                final String[] exceptions = ctor.exceptions == null ? null : ctor.exceptions.toArray(new String[0]);
                final Type ctorDesc = Type.getMethodType(ctor.desc);
                final Type creatorDesc = Type
                    .getMethodType(classType, ArrayUtils.remove(ctorDesc.getArgumentTypes(), 1));
                final MethodNode creator = new MethodNode(
                    ctor.access,
                    CREATE_METHOD_NAME,
                    creatorDesc.getDescriptor(),
                    null,
                    exceptions);
                creator.access = Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC;
                return creator;
            })
            .collect(Collectors.toList());

        if (candidates.isEmpty()) {
            throw new IllegalStateException(
                "IExtensibleEnum has no candidate factory methods: " + classType.getClassName());
        }

        classNode.methods.addAll(candidates);

        candidates.forEach(mtd -> {
            Type[] args = Type.getArgumentTypes(mtd.desc);
            if (args.length == 0 || !args[0].equals(STRING)) {
                if (LOGGER.isErrorEnabled()) {
                    String sb = "Enum has create method without String as first parameter:\n" + "  Enum: "
                        + classType.getDescriptor()
                        + "\n"
                        + "  Target: "
                        + mtd.name
                        + mtd.desc
                        + "\n";
                    LOGGER.error(sb);
                }
                throw new IllegalStateException(
                    "Enum has create method without String as first parameter: " + mtd.name + mtd.desc);
            }

            Type ret = Type.getReturnType(mtd.desc);
            if (!ret.equals(classType)) {
                if (LOGGER.isErrorEnabled()) {
                    String sb = "Enum has create method with incorrect return type:\n" + "  Enum: "
                        + classType.getDescriptor()
                        + "\n"
                        + "  Target: "
                        + mtd.name
                        + mtd.desc
                        + "\n"
                        + "  Found: "
                        + ret.getClassName()
                        + ", Expected: "
                        + classType.getClassName();
                    LOGGER.error(sb);
                }
                throw new IllegalStateException(
                    "Enum has create method with incorrect return type: " + mtd.name + mtd.desc);
            }

            Type[] ctrArgs = new Type[args.length + 1];
            ctrArgs[0] = STRING;
            ctrArgs[1] = Type.INT_TYPE;
            for (int x = 1; x < args.length; x++) ctrArgs[1 + x] = args[x];

            String desc = Type.getMethodDescriptor(Type.VOID_TYPE, ctrArgs);

            MethodNode ctr = classNode.methods.stream()
                .filter(m -> m.name.equals("<init>") && m.desc.equals(desc))
                .findFirst()
                .orElse(null);
            if (ctr == null) {
                if (LOGGER.isErrorEnabled()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Enum has create method with no matching constructor:\n");
                    sb.append("  Enum: ")
                        .append(classType.getDescriptor())
                        .append("\n");
                    sb.append("  Candidate: ")
                        .append(mtd.desc)
                        .append("\n");
                    sb.append("  Target: ")
                        .append(desc)
                        .append("\n");
                    classNode.methods.stream()
                        .filter(m -> m.name.equals("<init>"))
                        .forEach(
                            m -> sb.append("        : ")
                                .append(m.desc)
                                .append("\n"));
                    LOGGER.error(sb.toString());
                }
                throw new IllegalStateException("Enum has create method with no matching constructor: " + desc);
            }

            if (values == null) {
                if (LOGGER.isErrorEnabled()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Enum has create method but we could not find $VALUES. Found:\n");
                    classNode.fields.stream()
                        .filter(f -> (f.access & Opcodes.ACC_STATIC) != 0)
                        .forEach(
                            m -> sb.append("  ")
                                .append(m.name)
                                .append(" ")
                                .append(m.desc)
                                .append("\n"));
                    LOGGER.error(sb.toString());
                }
                throw new IllegalStateException("Enum has create method but we could not find $VALUES");
            }

            values.access &= values.access & ~Opcodes.ACC_FINAL; // Strip the final so JITer doesn't inline things.

            mtd.access |= Opcodes.ACC_SYNCHRONIZED;
            mtd.instructions.clear();
            mtd.localVariables.clear();
            if (mtd.tryCatchBlocks != null) {
                mtd.tryCatchBlocks.clear();
            }
            if (mtd.visibleLocalVariableAnnotations != null) {
                mtd.visibleLocalVariableAnnotations.clear();
            }
            if (mtd.invisibleLocalVariableAnnotations != null) {
                mtd.invisibleLocalVariableAnnotations.clear();
            }
            InstructionAdapter ins = new InstructionAdapter(mtd);

            int vars = 0;
            for (Type arg : args) vars += arg.getSize();

            {
                vars += 1; // int x
                Label for_start = new Label();
                Label for_condition = new Label();
                Label for_inc = new Label();

                ins.iconst(0);
                ins.store(vars, Type.INT_TYPE);
                ins.goTo(for_condition);
                // if (!VALUES[x].name().equalsIgnoreCase(name)) goto for_inc
                ins.mark(for_start);
                ins.getstatic(classType.getInternalName(), values.name, values.desc);
                ins.load(vars, Type.INT_TYPE);
                ins.aload(array);
                ins.invokevirtual(ENUM.getInternalName(), "name", NAME_DESC, false);
                ins.load(0, STRING);
                ins.invokevirtual(STRING.getInternalName(), "equalsIgnoreCase", EQUALS_DESC, false);
                ins.ifeq(for_inc);
                // return VALUES[x];
                ins.getstatic(classType.getInternalName(), values.name, values.desc);
                ins.load(vars, Type.INT_TYPE);
                ins.aload(array);
                ins.areturn(classType);
                // x++
                ins.mark(for_inc);
                ins.iinc(vars, 1);
                // if (x < VALUES.length) goto for_start
                ins.mark(for_condition);
                ins.load(vars, Type.INT_TYPE);
                ins.getstatic(classType.getInternalName(), values.name, values.desc);
                ins.arraylength();
                ins.ificmplt(for_start);
            }

            {
                vars += 1; // enum ret;
                // ret = new ThisType(name, VALUES.length, args..)
                ins.anew(classType);
                ins.dup();
                ins.load(0, STRING);
                ins.getstatic(classType.getInternalName(), values.name, values.desc);
                ins.arraylength();
                int idx = 1;
                for (int x = 1; x < args.length; x++) {
                    ins.load(idx, args[x]);
                    idx += args[x].getSize();
                }
                ins.invokespecial(classType.getInternalName(), "<init>", desc, false);
                ins.store(vars, classType);
                // VALUES = ArrayUtils.add(VALUES, ret)
                ins.getstatic(classType.getInternalName(), values.name, values.desc);
                ins.load(vars, classType);
                ins.invokestatic(ARRAY_UTILS.getInternalName(), "add", ADD_DESC, false);
                ins.checkcast(array);
                ins.putstatic(classType.getInternalName(), values.name, values.desc);
                // EnumHelper.cleanEnumCache(ThisType.class)
                ins.visitLdcInsn(classType);
                ins.invokestatic(UNSAFE_HACKS.getInternalName(), "cleanEnumCache", CLEAN_DESC, false);
                // init ret
                ins.load(vars, classType);
                ins.invokeinterface(MARKER_IFACE.getInternalName(), "init", "()V");
                // return ret
                ins.load(vars, classType);
                ins.areturn(classType);
            }
        });
    }
}
