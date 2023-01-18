package org.lwjglx.opengl;

public class EXTBlendFuncSeparate {
    public static final int GL_BLEND_DST_ALPHA_EXT = 32970;
    public static final int GL_BLEND_DST_RGB_EXT = 32968;
    public static final int GL_BLEND_SRC_ALPHA_EXT = 32971;
    public static final int GL_BLEND_SRC_RGB_EXT = 32969;

    public static void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
        org.lwjgl.opengl.EXTBlendFuncSeparate.glBlendFuncSeparateEXT(
                sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
    }
}
