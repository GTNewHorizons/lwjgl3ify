package me.eigenraven.lwjgl3ify.mixins.early.fml;

import java.lang.reflect.Field;

import net.minecraft.init.Blocks;
import net.minecraft.util.RegistryNamespaced;

import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.google.common.base.Throwables;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameData;

@Mixin(targets = { "cpw.mods.fml.common.registry.ObjectHolderRef" }, remap = false)
public class ObjectHolderRef {

    @Shadow(remap = false)
    private Field field;

    @Shadow(remap = false)
    private String injectedObject;

    @Shadow(remap = false)
    private boolean isBlock;

    @Shadow(remap = false)
    private boolean isItem;

    /**
     * @author eigenraven
     * @reason Simple helper function
     */
    @Overwrite(remap = false)
    public static void makeWritable(Field f) {
        try {
            f.setAccessible(true);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    /**
     * @author eigenraven
     * @reason Logic has to be significantly altered
     */
    @Overwrite(remap = false)
    public void apply() {
        Object thing;
        RegistryNamespaced registry;
        if (isBlock) {
            registry = GameData.getBlockRegistry();
            thing = registry.getObject(injectedObject);
            if (thing == Blocks.air) {
                thing = null;
            }
        } else if (isItem) {
            registry = GameData.getItemRegistry();
            thing = registry.getObject(injectedObject);
        } else {
            thing = null;
        }

        if (thing == null) {
            FMLLog.getLogger()
                .log(
                    Level.DEBUG,
                    "Unable to lookup {} for {}. This means the object wasn't registered. It's likely just mod options.",
                    injectedObject,
                    field);
            return;
        }
        try {
            field.set(null, thing);
            FMLLog.finer("Set field " + field.toString() + " to " + thing);
        } catch (Throwable e) {
            FMLLog.log(Level.WARN, e, "Unable to set %s with value %s (%s)", this.field, thing, this.injectedObject);
        }
    }
}
