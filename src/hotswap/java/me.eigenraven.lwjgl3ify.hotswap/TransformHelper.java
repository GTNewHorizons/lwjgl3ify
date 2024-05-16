package me.eigenraven.lwjgl3ify.hotswap;

import java.lang.reflect.Field;
import java.util.Set;

import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.LaunchClassLoader;

import com.gtnewhorizons.retrofuturabootstrap.Main;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

/**
 * Helper functions that run within the app classloader domain
 */
public class TransformHelper {

    static Field classLoaderExceptionsField;
    static Field xformerExceptionsField;

    @SuppressWarnings("unchecked")
    public static byte[] transform(LaunchClassLoader loader, String name, byte[] classBytes) throws Exception {
        if (classLoaderExceptionsField == null) {
            classLoaderExceptionsField = loader.getClass()
                .getDeclaredField("classLoaderExceptions");
            classLoaderExceptionsField.setAccessible(true);
        }
        if (xformerExceptionsField == null) {
            xformerExceptionsField = loader.getClass()
                .getDeclaredField("transformerExceptions");
            xformerExceptionsField.setAccessible(true);
        }
        Set<String> loaderExceptions = (Set<String>) classLoaderExceptionsField.get(loader);
        Set<String> xformerExceptions = (Set<String>) xformerExceptionsField.get(loader);
        for (final String exception : loaderExceptions) {
            if (name.startsWith(exception)) {
                return classBytes;
            }
        }
        for (final String exception : xformerExceptions) {
            if (name.startsWith(exception)) {
                return classBytes;
            }
        }

        for (final IClassTransformer xformer : loader.getTransformers()) {
            classBytes = xformer.transform(name, name, classBytes);
        }
        classBytes = loader.runRfbTransformers(
            Main.getRfbTransformers(),
            RfbClassTransformer.Context.LCL_WITH_TRANSFORMS,
            null,
            name,
            classBytes);

        return classBytes;
    }
}
