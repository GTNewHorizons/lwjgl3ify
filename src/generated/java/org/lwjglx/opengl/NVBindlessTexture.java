package org.lwjglx.opengl;

public class NVBindlessTexture {
    public static long glGetImageHandleNV(int arg0, int arg1, boolean arg2, int arg3, int arg4) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetImageHandleNV(arg0, arg1, arg2, arg3, arg4);
    }

    public static long glGetTextureHandleNV(int arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetTextureHandleNV(arg0);
    }

    public static long glGetTextureSamplerHandleNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetTextureSamplerHandleNV(arg0, arg1);
    }

    public static boolean glIsImageHandleResidentNV(long arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glIsImageHandleResidentNV(arg0);
    }

    public static boolean glIsTextureHandleResidentNV(long arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glIsTextureHandleResidentNV(arg0);
    }

    public static void glMakeImageHandleNonResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeImageHandleNonResidentNV(arg0);
    }

    public static void glMakeImageHandleResidentNV(long arg0, int arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeImageHandleResidentNV(arg0, arg1);
    }

    public static void glMakeTextureHandleNonResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeTextureHandleNonResidentNV(arg0);
    }

    public static void glMakeTextureHandleResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeTextureHandleResidentNV(arg0);
    }

    public static void glProgramUniformHandleuNV(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.NVBindlessTexture.glProgramUniformHandleui64vNV(arg0, arg1, arg2);
    }

    public static void glProgramUniformHandleui64NV(int arg0, int arg1, long arg2) {
        org.lwjgl.opengl.NVBindlessTexture.glProgramUniformHandleui64NV(arg0, arg1, arg2);
    }

    public static void glUniformHandleuNV(int arg0, java.nio.LongBuffer arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glUniformHandleui64vNV(arg0, arg1);
    }

    public static void glUniformHandleui64NV(int arg0, long arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glUniformHandleui64NV(arg0, arg1);
    }


}
