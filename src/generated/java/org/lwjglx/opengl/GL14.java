package org.lwjglx.opengl;

public class GL14 {
    public static final int GL_BLEND_COLOR = 32773;
    public static final int GL_BLEND_DST_ALPHA = 32970;
    public static final int GL_BLEND_DST_RGB = 32968;
    public static final int GL_BLEND_EQUATION = 32777;
    public static final int GL_BLEND_SRC_ALPHA = 32971;
    public static final int GL_BLEND_SRC_RGB = 32969;
    public static final int GL_COLOR_SUM = 33880;
    public static final int GL_COMPARE_R_TO_TEXTURE = 34894;
    public static final int GL_CURRENT_FOG_COORDINATE = 33875;
    public static final int GL_CURRENT_SECONDARY_COLOR = 33881;
    public static final int GL_DECR_WRAP = 34056;
    public static final int GL_DEPTH_COMPONENT16 = 33189;
    public static final int GL_DEPTH_COMPONENT24 = 33190;
    public static final int GL_DEPTH_COMPONENT32 = 33191;
    public static final int GL_DEPTH_TEXTURE_MODE = 34891;
    public static final int GL_FOG_COORDINATE = 33873;
    public static final int GL_FOG_COORDINATE_ARRAY = 33879;
    public static final int GL_FOG_COORDINATE_ARRAY_POINTER = 33878;
    public static final int GL_FOG_COORDINATE_ARRAY_STRIDE = 33877;
    public static final int GL_FOG_COORDINATE_ARRAY_TYPE = 33876;
    public static final int GL_FOG_COORDINATE_SOURCE = 33872;
    public static final int GL_FRAGMENT_DEPTH = 33874;
    public static final int GL_FUNC_ADD = 32774;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
    public static final int GL_FUNC_SUBTRACT = 32778;
    public static final int GL_GENERATE_MIPMAP = 33169;
    public static final int GL_GENERATE_MIPMAP_HINT = 33170;
    public static final int GL_INCR_WRAP = 34055;
    public static final int GL_MAX = 32776;
    public static final int GL_MAX_TEXTURE_LOD_BIAS = 34045;
    public static final int GL_MIN = 32775;
    public static final int GL_MIRRORED_REPEAT = 33648;
    public static final int GL_POINT_DISTANCE_ATTENUATION = 33065;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE = 33064;
    public static final int GL_POINT_SIZE_MAX = 33063;
    public static final int GL_POINT_SIZE_MIN = 33062;
    public static final int GL_SECONDARY_COLOR_ARRAY = 33886;
    public static final int GL_SECONDARY_COLOR_ARRAY_POINTER = 33885;
    public static final int GL_SECONDARY_COLOR_ARRAY_SIZE = 33882;
    public static final int GL_SECONDARY_COLOR_ARRAY_STRIDE = 33884;
    public static final int GL_SECONDARY_COLOR_ARRAY_TYPE = 33883;
    public static final int GL_TEXTURE_COMPARE_FUNC = 34893;
    public static final int GL_TEXTURE_COMPARE_MODE = 34892;
    public static final int GL_TEXTURE_DEPTH_SIZE = 34890;
    public static final int GL_TEXTURE_FILTER_CONTROL = 34048;
    public static final int GL_TEXTURE_LOD_BIAS = 34049;

    public static void glBlendColor(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.GL14.glBlendColor(red, green, blue, alpha);
    }

    public static void glBlendEquation(int mode) {
        org.lwjgl.opengl.GL14.glBlendEquation(mode);
    }

    public static void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
        org.lwjgl.opengl.GL14.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
    }

    public static void glFogCoordPointer(int type, int stride, long data_buffer_offset) {
        org.lwjgl.opengl.GL14.glFogCoordPointer(type, stride, data_buffer_offset);
    }

    public static void glFogCoordPointer(int stride, java.nio.DoubleBuffer data) {

        org.lwjgl.opengl.GL14.glFogCoordPointer(
                org.lwjgl.opengl.GL11.GL_DOUBLE, stride, me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data));
    }

    public static void glFogCoordPointer(int stride, java.nio.FloatBuffer data) {

        org.lwjgl.opengl.GL14.glFogCoordPointer(org.lwjgl.opengl.GL11.GL_FLOAT, stride, data);
    }

    public static void glFogCoordd(double coord) {
        org.lwjgl.opengl.GL14.glFogCoordd(coord);
    }

    public static void glFogCoordf(float coord) {
        org.lwjgl.opengl.GL14.glFogCoordf(coord);
    }

    public static void glMultiDrawArrays(int mode, java.nio.IntBuffer piFirst, java.nio.IntBuffer piCount) {
        org.lwjgl.opengl.GL14.glMultiDrawArrays(mode, piFirst, piCount);
    }

    public static void glPointParameter(int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL14.glPointParameterfv(pname, params);
    }

    public static void glPointParameter(int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL14.glPointParameteriv(pname, params);
    }

    public static void glPointParameterf(int pname, float param) {
        org.lwjgl.opengl.GL14.glPointParameterf(pname, param);
    }

    public static void glPointParameteri(int pname, int param) {
        org.lwjgl.opengl.GL14.glPointParameteri(pname, param);
    }

    public static void glSecondaryColor3b(byte red, byte green, byte blue) {
        org.lwjgl.opengl.GL14.glSecondaryColor3b(red, green, blue);
    }

    public static void glSecondaryColor3d(double red, double green, double blue) {
        org.lwjgl.opengl.GL14.glSecondaryColor3d(red, green, blue);
    }

    public static void glSecondaryColor3f(float red, float green, float blue) {
        org.lwjgl.opengl.GL14.glSecondaryColor3f(red, green, blue);
    }

    public static void glSecondaryColor3ub(byte red, byte green, byte blue) {
        org.lwjgl.opengl.GL14.glSecondaryColor3ub(red, green, blue);
    }

    public static void glSecondaryColorPointer(int size, int type, int stride, long data_buffer_offset) {
        org.lwjgl.opengl.GL14.glSecondaryColorPointer(size, type, stride, data_buffer_offset);
    }

    public static void glSecondaryColorPointer(int size, int stride, java.nio.DoubleBuffer data) {

        org.lwjgl.opengl.GL14.glSecondaryColorPointer(
                size, org.lwjgl.opengl.GL11.GL_DOUBLE, stride, me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data));
    }

    public static void glSecondaryColorPointer(int size, int stride, java.nio.FloatBuffer data) {

        org.lwjgl.opengl.GL14.glSecondaryColorPointer(size, org.lwjgl.opengl.GL11.GL_FLOAT, stride, data);
    }

    public static void glSecondaryColorPointer(int size, boolean unsigned, int stride, java.nio.ByteBuffer data) {

        org.lwjgl.opengl.GL14.glSecondaryColorPointer(
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE : org.lwjgl.opengl.GL11.GL_BYTE),
                stride,
                org.lwjglx.MemoryUtil.getAddress(data));
    }

    public static void glWindowPos2d(double x, double y) {
        org.lwjgl.opengl.GL14.glWindowPos2d(x, y);
    }

    public static void glWindowPos2f(float x, float y) {
        org.lwjgl.opengl.GL14.glWindowPos2f(x, y);
    }

    public static void glWindowPos2i(int x, int y) {
        org.lwjgl.opengl.GL14.glWindowPos2i(x, y);
    }

    public static void glWindowPos3d(double x, double y, double z) {
        org.lwjgl.opengl.GL14.glWindowPos3d(x, y, z);
    }

    public static void glWindowPos3f(float x, float y, float z) {
        org.lwjgl.opengl.GL14.glWindowPos3f(x, y, z);
    }

    public static void glWindowPos3i(int x, int y, int z) {
        org.lwjgl.opengl.GL14.glWindowPos3i(x, y, z);
    }
}
