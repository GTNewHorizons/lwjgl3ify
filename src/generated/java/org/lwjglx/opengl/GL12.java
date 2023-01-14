package org.lwjglx.opengl;

public class GL12 {
    public static void glCopyTexSubImage3D(
            int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
        org.lwjgl.opengl.GL12.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
    }

    public static void glDrawRangeElements(
            int mode, int start, int end, int indices_count, int type, long indices_buffer_offset) {
        org.lwjgl.opengl.GL12.glDrawRangeElements(mode, start, end, indices_count, type, indices_buffer_offset);
    }

    public static void glDrawRangeElements(int mode, int start, int end, java.nio.ByteBuffer indices) {
        org.lwjgl.opengl.GL12.glDrawRangeElements(mode, start, end, indices);
    }

    public static void glDrawRangeElements(int mode, int start, int end, java.nio.IntBuffer indices) {
        org.lwjgl.opengl.GL12.glDrawRangeElements(mode, start, end, indices);
    }

    public static void glDrawRangeElements(int mode, int start, int end, java.nio.ShortBuffer indices) {
        org.lwjgl.opengl.GL12.glDrawRangeElements(mode, start, end, indices);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            long pixels_buffer_offset) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels_buffer_offset);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexImage3D(
            int target,
            int level,
            int internalFormat,
            int width,
            int height,
            int depth,
            int border,
            int format,
            int type,
            java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexImage3D(
                target, level, internalFormat, width, height, depth, border, format, type, pixels);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            long pixels_buffer_offset) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels_buffer_offset);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }

    public static void glTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int type,
            java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL12.glTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
    }
}
