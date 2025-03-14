package me.eigenraven.lwjgl3ify.rfb.transformers;

import java.util.HashSet;
import java.util.Set;
import java.util.jar.Manifest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.gtnewhorizons.retrofuturabootstrap.api.ClassNodeHandle;
import com.gtnewhorizons.retrofuturabootstrap.api.ExtensibleClassLoader;
import com.gtnewhorizons.retrofuturabootstrap.api.RetroFuturaBootstrap;
import com.gtnewhorizons.retrofuturabootstrap.api.RfbClassTransformer;

public class LoadSuperclassTransformer implements RfbClassTransformer {

    private static final Logger LOGGER = LogManager.getLogger("lwjgl3ify");

    @Override
    public @NotNull String id() {
        return "load-superclass";
    }

    @Override
    public boolean shouldTransformClass(@NotNull ExtensibleClassLoader classLoader, @NotNull Context context,
        @Nullable Manifest manifest, @NotNull String className, @NotNull ClassNodeHandle classNode) {
        return classLoader == RetroFuturaBootstrap.API.launchClassLoader();
    }

    @Override
    public void transformClass(@NotNull ExtensibleClassLoader classLoader, @NotNull Context context,
        @Nullable Manifest manifest, @NotNull String className, @NotNull ClassNodeHandle classNode) {
        if (!classNode.isPresent()) {
            return;
        }
        String superName = "";
        try {
            final Set<String> visited = new HashSet<>();
            visited.add(className);
            superName = classNode.getFastAccessor()
                .binarySuperName()
                .replace('/', '.');
            while (visited.add(superName) && !"java.lang.Object".equals(superName)) {
                Class<?> outer = classLoader.findClass(superName);
                // getSuperclass() should load it, but we want to make sure this classloader's cache is populated
                superName = outer.getSuperclass()
                    .getName();
            }
        } catch (Throwable t) {
            LOGGER.warn("Could not load superclass {} of {}", superName, className, t);
        }

    }
}
