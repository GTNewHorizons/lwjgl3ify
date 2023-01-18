package org.lwjglx.opengl;

public class KHRRobustness {
    public static final int GL_CONTEXT_LOST = 1287;
    public static final int GL_CONTEXT_ROBUST_ACCESS = 37107;
    public static final int GL_GUILTY_CONTEXT_RESET = 33363;
    public static final int GL_INNOCENT_CONTEXT_RESET = 33364;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 33362;
    public static final int GL_NO_RESET_NOTIFICATION = 33377;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 33366;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 33365;

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
