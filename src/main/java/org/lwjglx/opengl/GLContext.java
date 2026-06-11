package org.lwjglx.opengl;

public class GLContext {

    private static ContextCapabilities contextCapabilities = new ContextCapabilities();

    public static ContextCapabilities getCapabilities() {
        return contextCapabilities;
    }

    /**
     * Rebuild the capabilities from the current GL context or
     * {@link me.eigenraven.lwjgl3ify.api.GLCapabilitiesOverride}.
     */
    public static void refreshCapabilities() {
        contextCapabilities = new ContextCapabilities();
    }
}
