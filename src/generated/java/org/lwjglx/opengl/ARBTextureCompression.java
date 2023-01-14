package org.lwjglx.opengl;

public class ARBTextureCompression {
    public static void glCompressedTexImage1DARB(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int pData_imageSize,
            long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexImage1DARB(
                target, level, internalformat, width, border, pData_imageSize, pData_buffer_offset);
    }

    public static void glCompressedTexImage2DARB(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int pData_imageSize,
            long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexImage2DARB(
                target, level, internalformat, width, height, border, pData_imageSize, pData_buffer_offset);
    }

    public static void glCompressedTexImage3DARB(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int depth,
            int border,
            int pData_imageSize,
            long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexImage3DARB(
                target, level, internalformat, width, height, depth, border, pData_imageSize, pData_buffer_offset);
    }

    public static void glCompressedTexSubImage1DARB(
            int target, int level, int xoffset, int width, int format, int pData_imageSize, long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage1DARB(
                target, level, xoffset, width, format, pData_imageSize, pData_buffer_offset);
    }

    public static void glCompressedTexSubImage1DARB(
            int target, int level, int xoffset, int width, int format, java.nio.ByteBuffer pData) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage1DARB(
                target, level, xoffset, width, format, pData);
    }

    public static void glCompressedTexSubImage2DARB(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int pData_imageSize,
            long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage2DARB(
                target, level, xoffset, yoffset, width, height, format, pData_imageSize, pData_buffer_offset);
    }

    public static void glCompressedTexSubImage2DARB(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            java.nio.ByteBuffer pData) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage2DARB(
                target, level, xoffset, yoffset, width, height, format, pData);
    }

    public static void glCompressedTexSubImage3DARB(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int pData_imageSize,
            long pData_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage3DARB(
                target,
                level,
                xoffset,
                yoffset,
                zoffset,
                width,
                height,
                depth,
                format,
                pData_imageSize,
                pData_buffer_offset);
    }

    public static void glCompressedTexSubImage3DARB(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            java.nio.ByteBuffer pData) {
        org.lwjgl.opengl.ARBTextureCompression.glCompressedTexSubImage3DARB(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, pData);
    }

    public static void glGetCompressedTexImageARB(int target, int lod, long pImg_buffer_offset) {
        org.lwjgl.opengl.ARBTextureCompression.glGetCompressedTexImageARB(target, lod, pImg_buffer_offset);
    }

    public static void glGetCompressedTexImageARB(int target, int lod, java.nio.ByteBuffer pImg) {
        org.lwjgl.opengl.ARBTextureCompression.glGetCompressedTexImageARB(target, lod, pImg);
    }
}
