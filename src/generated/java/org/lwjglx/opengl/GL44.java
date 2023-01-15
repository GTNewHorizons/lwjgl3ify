package org.lwjglx.opengl;

public class GL44 {
    public static void glBufferStorage(int target, long size, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, size, flags);
    }

    public static void glBufferStorage(int target, java.nio.ByteBuffer data, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(int target, java.nio.DoubleBuffer data, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(int target, java.nio.FloatBuffer data, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(int target, java.nio.IntBuffer data, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, data, flags);
    }

    public static void glBufferStorage(int target, java.nio.ShortBuffer data, int flags) {
        org.lwjgl.opengl.GL44.glBufferStorage(target, data, flags);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, data);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.DoubleBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, data);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.FloatBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, data);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.IntBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, data);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.LongBuffer data) {
        final java.nio.ByteBuffer wrappedArg4 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, wrappedArg4);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg4);
    }

    public static void glClearTexImage(int texture, int level, int format, int type, java.nio.ShortBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, data);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.DoubleBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.FloatBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.IntBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.LongBuffer data) {
        final java.nio.ByteBuffer wrappedArg10 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, wrappedArg10);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg10);
    }

    public static void glClearTexSubImage(
            int texture,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.ShortBuffer data) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(
                texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
    }
}
