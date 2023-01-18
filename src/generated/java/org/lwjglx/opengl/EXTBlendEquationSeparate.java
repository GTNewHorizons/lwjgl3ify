package org.lwjglx.opengl;

public class EXTBlendEquationSeparate {
    public static final int GL_BLEND_EQUATION_ALPHA_EXT = 34877;
    public static final int GL_BLEND_EQUATION_RGB_EXT = 32777;

    public static void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
        org.lwjgl.opengl.EXTBlendEquationSeparate.glBlendEquationSeparateEXT(modeRGB, modeAlpha);
    }
}
