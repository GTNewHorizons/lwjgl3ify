package me.eigenraven.lwjgl3ify.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.lwjglx.opengl.Display;
import org.lwjglx.opengl.GLContext;

/**
 * Capability names a non-GL backend advertises when no real GL context exists.
 */
public final class GLCapabilitiesOverride {

    private static volatile Set<String> caps = Collections.emptySet();

    /** May be called before or during Display.create(); capabilities are rebuilt at the end of create(). */
    public static void set(Set<String> capabilityNames) {
        caps = Collections.unmodifiableSet(new HashSet<>(capabilityNames));
        if (Display.isCreated() && !Display.hasGLContext()) {
            GLContext.refreshCapabilities();
        }
    }

    public static Set<String> get() {
        return caps;
    }
}
