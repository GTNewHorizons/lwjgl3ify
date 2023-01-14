package org.lwjglx.opengl;

public class GL14 {
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
