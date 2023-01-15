package org.lwjglx.opengl;

public class GL32 {
    public static void glDrawElementsBaseVertex(
            int mode, int indices_count, int type, long indices_buffer_offset, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsBaseVertex(mode, indices_count, type, indices_buffer_offset, basevertex);
    }

    public static void glDrawElementsBaseVertex(int mode, java.nio.ByteBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(int mode, java.nio.IntBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void glDrawElementsBaseVertex(int mode, java.nio.ShortBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsBaseVertex(mode, indices, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(
            int mode, int indices_count, int type, long indices_buffer_offset, int primcount, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsInstancedBaseVertex(
                mode, indices_count, type, indices_buffer_offset, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(
            int mode, java.nio.ByteBuffer indices, int primcount, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(
            int mode, java.nio.IntBuffer indices, int primcount, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void glDrawElementsInstancedBaseVertex(
            int mode, java.nio.ShortBuffer indices, int primcount, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawElementsInstancedBaseVertex(mode, indices, primcount, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(
            int mode, int start, int end, int indices_count, int type, long indices_buffer_offset, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawRangeElementsBaseVertex(
                mode, start, end, indices_count, type, indices_buffer_offset, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(
            int mode, int start, int end, java.nio.ByteBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(
            int mode, int start, int end, java.nio.IntBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static void glDrawRangeElementsBaseVertex(
            int mode, int start, int end, java.nio.ShortBuffer indices, int basevertex) {
        org.lwjgl.opengl.GL32.glDrawRangeElementsBaseVertex(mode, start, end, indices, basevertex);
    }

    public static org.lwjglx.opengl.GLSync glFenceSync(int condition, int flags) {

        org.lwjglx.opengl.GLSync returnValue =
                new org.lwjglx.opengl.GLSync(org.lwjgl.opengl.GL32.glFenceSync(condition, flags));

        return returnValue;
    }

    public static void glFramebufferTexture(int target, int attachment, int texture, int level) {
        org.lwjgl.opengl.GL32.glFramebufferTexture(target, attachment, texture, level);
    }

    public static void glGetBufferParameter(int target, int pname, java.nio.LongBuffer params) {
        org.lwjgl.opengl.GL32.glGetBufferParameteri64v(target, pname, params);
    }

    public static long glGetBufferParameteri64(int target, int pname) {
        return org.lwjgl.opengl.GL32.glGetBufferParameteri64(target, pname);
    }

    public static long glGetInteger64(int pname) {
        return org.lwjgl.opengl.GL32.glGetInteger64(pname);
    }

    public static void glGetInteger64(int value, int index, java.nio.LongBuffer data) {
        org.lwjgl.opengl.GL32.glGetInteger64i_v(value, index, data);
    }

    public static void glGetInteger64(int pname, java.nio.LongBuffer data) {
        org.lwjgl.opengl.GL32.glGetInteger64v(pname, data);
    }

    public static void glGetMultisample(int pname, int index, java.nio.FloatBuffer val) {
        org.lwjgl.opengl.GL32.glGetMultisamplefv(pname, index, val);
    }

    public static void glProvokingVertex(int mode) {
        org.lwjgl.opengl.GL32.glProvokingVertex(mode);
    }

    public static void glSampleMaski(int index, int mask) {
        org.lwjgl.opengl.GL32.glSampleMaski(index, mask);
    }

    public static void glTexImage2DMultisample(
            int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        org.lwjgl.opengl.GL32.glTexImage2DMultisample(
                target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexImage3DMultisample(
            int target,
            int samples,
            int internalformat,
            int width,
            int height,
            int depth,
            boolean fixedsamplelocations) {
        org.lwjgl.opengl.GL32.glTexImage3DMultisample(
                target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }
}
