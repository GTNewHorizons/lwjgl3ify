package org.lwjglx.opengl;

public class KHRRobustness {
    public static int glGetGraphicsResetStatus() {
        return org.lwjgl.opengl.KHRRobustness.glGetGraphicsResetStatus();
    }

    public static void glReadnPixels(
            int x, int y, int width, int height, int format, int type, int pixels_bufSize, long pixels_buffer_offset) {
        org.lwjgl.opengl.KHRRobustness.glReadnPixels(
                x, y, width, height, format, type, pixels_bufSize, pixels_buffer_offset);
    }

    public static void glReadnPixels(
            int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.KHRRobustness.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(
            int x, int y, int width, int height, int format, int type, java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.KHRRobustness.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(
            int x, int y, int width, int height, int format, int type, java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.KHRRobustness.glReadnPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadnPixels(
            int x, int y, int width, int height, int format, int type, java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.KHRRobustness.glReadnPixels(x, y, width, height, format, type, pixels);
    }
}
