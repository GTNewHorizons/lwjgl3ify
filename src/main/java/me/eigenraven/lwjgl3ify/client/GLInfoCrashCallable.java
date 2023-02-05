package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.opengl.GL11.GL_RENDERER;
import static org.lwjgl.opengl.GL11.GL_VENDOR;
import static org.lwjgl.opengl.GL11.GL_VERSION;
import static org.lwjgl.opengl.GL11.glGetString;

import org.lwjgl.opengl.GL;

import cpw.mods.fml.common.ICrashCallable;

public class GLInfoCrashCallable implements ICrashCallable {

    @Override
    public String getLabel() {
        return "GL info";
    }

    @Override
    public String call() throws Exception {
        boolean hasGlContext = true;
        try {
            if (GL.getCapabilities() == null) {
                hasGlContext = false;
            }
        } catch (IllegalStateException ise) {
            // No OpenGL context in current thread
            hasGlContext = false;
        }
        if (hasGlContext) {
            return "' Vendor: '" + glGetString(GL_VENDOR)
                    + "' Version: '"
                    + glGetString(GL_VERSION)
                    + "' Renderer: '"
                    + glGetString(GL_RENDERER)
                    + "'";
        } else {
            return "No OpenGL context present in the calling thread: " + Thread.currentThread().getName();
        }
    }
}
