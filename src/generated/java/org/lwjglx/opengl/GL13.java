package org.lwjglx.opengl;

public class GL13 {
    public static void glActiveTexture(int texture) {
        org.lwjgl.opengl.GL13.glActiveTexture(texture);
    }

    public static void glClientActiveTexture(int texture) {
        org.lwjgl.opengl.GL13.glClientActiveTexture(texture);
    }

    public static void glCompressedTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(
                target, level, internalformat, width, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage1D(
            int target, int level, int internalformat, int width, int border, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(target, level, internalformat, width, border, data);
    }

    public static void glCompressedTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(
                target, level, internalformat, width, height, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage2D(
            int target, int level, int internalformat, int width, int height, int border, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(target, level, internalformat, width, height, border, data);
    }

    public static void glCompressedTexImage3D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int depth,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(
                target, level, internalformat, width, height, depth, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage3D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int depth,
            int border,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, data);
    }

    public static void glCompressedTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int data_imageSize, long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(
                target, level, xoffset, width, format, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexSubImage1D(
            int target, int level, int xoffset, int width, int format, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(target, level, xoffset, width, format, data);
    }

    public static void glCompressedTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(
                target, level, xoffset, yoffset, width, height, format, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data);
    }

    public static void glCompressedTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(
                target,
                level,
                xoffset,
                yoffset,
                zoffset,
                width,
                height,
                depth,
                format,
                data_imageSize,
                data_buffer_offset);
    }

    public static void glCompressedTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
    }

    public static void glGetCompressedTexImage(int target, int lod, long img_buffer_offset) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, img_buffer_offset);
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.ByteBuffer img) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, img);
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.IntBuffer img) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjglx.MemoryUtil.getAddress(img));
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.ShortBuffer img) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjglx.MemoryUtil.getAddress(img));
    }

    public static void glLoadTransposeMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixd(m);
    }

    public static void glLoadTransposeMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixf(m);
    }

    public static void glMultTransposeMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixd(m);
    }

    public static void glMultTransposeMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixf(m);
    }

    public static void glMultiTexCoord1d(int target, double s) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1d(target, s);
    }

    public static void glMultiTexCoord1f(int target, float s) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1f(target, s);
    }

    public static void glMultiTexCoord2d(int target, double s, double t) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2d(target, s, t);
    }

    public static void glMultiTexCoord2f(int target, float s, float t) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2f(target, s, t);
    }

    public static void glMultiTexCoord3d(int target, double s, double t, double r) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3d(target, s, t, r);
    }

    public static void glMultiTexCoord3f(int target, float s, float t, float r) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3f(target, s, t, r);
    }

    public static void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4d(target, s, t, r, q);
    }

    public static void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4f(target, s, t, r, q);
    }

    public static void glSampleCoverage(float value, boolean invert) {
        org.lwjgl.opengl.GL13.glSampleCoverage(value, invert);
    }
}
