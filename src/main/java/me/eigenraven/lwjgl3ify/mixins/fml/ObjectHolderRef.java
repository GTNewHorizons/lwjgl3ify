package me.eigenraven.lwjgl3ify.mixins.fml;

import com.google.common.base.Throwables;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameData;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.init.Blocks;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import sun.misc.Unsafe;

@Mixin(
        targets = {"cpw.mods.fml.common.registry.ObjectHolderRef"},
        remap = false)
public class ObjectHolderRef {

    @Shadow(remap = false)
    private Field field;

    @Shadow(remap = false)
    private String injectedObject;

    @Shadow(remap = false)
    private boolean isBlock;

    @Shadow(remap = false)
    private boolean isItem;

    @Shadow(remap = false)
    private static Field modifiersField;

    @Shadow(remap = false)
    private static Object reflectionFactory;

    @Shadow(remap = false)
    private static Method newFieldAccessor;

    @Shadow(remap = false)
    private static Method fieldAccessorSet;

    private static MethodHandle fieldSetter;
    private static Unsafe unsafe;
    private static Object fieldBase;
    private static long fieldOffset;

    @Overwrite(remap = false)
    private static void makeWritable(Field f) {
        try {
            if (unsafe == null) {
                final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
                unsafeField.setAccessible(true);
                unsafe = (Unsafe) unsafeField.get(null);
            }
            fieldBase = unsafe.staticFieldBase(f);
            fieldOffset = unsafe.staticFieldOffset(f);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    @Overwrite
    public void apply() {
        Object thing;
        if (isBlock) {
            thing = GameData.getBlockRegistry().getObject(injectedObject);
            if (thing == Blocks.air) {
                thing = null;
            }
        } else if (isItem) {
            thing = GameData.getItemRegistry().getObject(injectedObject);
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
            // https://stackoverflow.com/questions/61141836/change-static-final-field-in-java-12
            unsafe.putObject(fieldBase, fieldOffset, thing);
        } catch (Throwable e) {
            FMLLog.log(Level.WARN, e, "Unable to set %s with value %s (%s)", this.field, thing, this.injectedObject);
        }
    }
}
