package me.eigenraven.lwjgl3ify.mixins;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;

import com.gtnewhorizon.gtnhmixins.builders.ITargetMod;
import com.gtnewhorizon.gtnhmixins.builders.TargetModBuilder;

public enum TargetedMod implements ITargetMod {

    FASTCRAFT_1_25(new TargetModBuilder().setTargetClass("fastcraft.a")
        .setClassNodeTest(cn -> {
            // we look for the strings in the call :
            // Launch.blackboard.put("fcVersion", "1.25");
            for (MethodNode mn : cn.methods) {
                for (AbstractInsnNode node : mn.instructions.toArray()) {
                    if (node instanceof LdcInsnNode && "fcVersion".equals(((LdcInsnNode) node).cst)) {
                        AbstractInsnNode next = node.getNext();
                        return next instanceof LdcInsnNode && "1.25".equals(((LdcInsnNode) next).cst);
                    }
                }
            }
            return false;
        })),
    FASTCRAFT_ANY(new TargetModBuilder().setCoreModClass("fastcraft.Tweaker")),
    OPTIFINE(new TargetModBuilder().setCoreModClass("optifine.OptiFineForgeTweaker")),
    XAEROS_MINIMAP(new TargetModBuilder().setModId("XaeroMinimap")),
    XAEROS_WORLDMAP(new TargetModBuilder().setModId("XaeroWorldMap")),
    // Support both the NH fork and upstream
    OPENCOMPUTERS(new TargetModBuilder().setCoreModClass("li.cil.oc.common.launch.TransformerLoader")
        .setModId("OpenComputers"))
    //
    ;

    private final TargetModBuilder builder;

    TargetedMod(TargetModBuilder builder) {
        this.builder = builder;
    }

    @NotNull
    @Override
    public TargetModBuilder getBuilder() {
        return builder;
    }
}
