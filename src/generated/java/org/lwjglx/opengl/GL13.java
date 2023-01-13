package org.lwjglx.opengl;

public class GL13 {
    public static void glActiveTexture(int arg0) {
        org.lwjgl.opengl.GL13.glActiveTexture(arg0);
    }

    public static void glClientActiveTexture(int arg0) {
        org.lwjgl.opengl.GL13.glClientActiveTexture(arg0);
    }

    public static void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.ByteBuffer arg6) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, java.nio.ByteBuffer arg7) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, java.nio.ByteBuffer arg7) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, java.nio.ByteBuffer arg9) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static void glGetCompressedTexImage(int arg0, int arg1, long arg2) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(arg0, arg1, arg2);
    }

    public static void glGetCompressedTexImage(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(arg0, arg1, arg2);
    }

    public static void glGetCompressedTexImage(int arg0, int arg1, java.nio.IntBuffer arg2) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(arg0, arg1, org.lwjglx.MemoryUtil.getAddress(arg2));

    }

    public static void glGetCompressedTexImage(int arg0, int arg1, java.nio.ShortBuffer arg2) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(arg0, arg1, org.lwjglx.MemoryUtil.getAddress(arg2));

    }

    public static void glLoadTransposeMatrix(java.nio.DoubleBuffer arg0) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixd(arg0);
    }

    public static void glLoadTransposeMatrix(java.nio.FloatBuffer arg0) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixf(arg0);
    }

    public static void glMultTransposeMatrix(java.nio.DoubleBuffer arg0) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixd(arg0);
    }

    public static void glMultTransposeMatrix(java.nio.FloatBuffer arg0) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixf(arg0);
    }

    public static void glMultiTexCoord1d(int arg0, double arg1) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1d(arg0, arg1);
    }

    public static void glMultiTexCoord1f(int arg0, float arg1) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1f(arg0, arg1);
    }

    public static void glMultiTexCoord2d(int arg0, double arg1, double arg2) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2d(arg0, arg1, arg2);
    }

    public static void glMultiTexCoord2f(int arg0, float arg1, float arg2) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2f(arg0, arg1, arg2);
    }

    public static void glMultiTexCoord3d(int arg0, double arg1, double arg2, double arg3) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3d(arg0, arg1, arg2, arg3);
    }

    public static void glMultiTexCoord3f(int arg0, float arg1, float arg2, float arg3) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3f(arg0, arg1, arg2, arg3);
    }

    public static void glMultiTexCoord4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4d(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glMultiTexCoord4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4f(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glSampleCoverage(float arg0, boolean arg1) {
        org.lwjgl.opengl.GL13.glSampleCoverage(arg0, arg1);
    }


}
