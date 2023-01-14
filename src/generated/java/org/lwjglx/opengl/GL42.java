package org.lwjglx.opengl;

public class GL42 {
    public static void glBindImageTexture(
            int unit, int texture, int level, boolean layered, int layer, int access, int format) {
        org.lwjgl.opengl.GL42.glBindImageTexture(unit, texture, level, layered, layer, access, format);
    }

    public static void glDrawArraysInstancedBaseInstance(
            int mode, int first, int count, int primcount, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawArraysInstancedBaseInstance(mode, first, count, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(
            int mode, int indices_count, int type, long indices_buffer_offset, int primcount, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseInstance(
                mode, indices_count, type, indices_buffer_offset, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(
            int mode, java.nio.ByteBuffer indices, int primcount, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(
            int mode, java.nio.IntBuffer indices, int primcount, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseInstance(
            int mode, java.nio.ShortBuffer indices, int primcount, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseInstance(mode, indices, primcount, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(
            int mode,
            int indices_count,
            int type,
            long indices_buffer_offset,
            int primcount,
            int basevertex,
            int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseVertexBaseInstance(
                mode, indices_count, type, indices_buffer_offset, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(
            int mode, java.nio.ByteBuffer indices, int primcount, int basevertex, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseVertexBaseInstance(
                mode, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(
            int mode, java.nio.IntBuffer indices, int primcount, int basevertex, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseVertexBaseInstance(
                mode, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawElementsInstancedBaseVertexBaseInstance(
            int mode, java.nio.ShortBuffer indices, int primcount, int basevertex, int baseinstance) {
        org.lwjgl.opengl.GL42.glDrawElementsInstancedBaseVertexBaseInstance(
                mode, indices, primcount, basevertex, baseinstance);
    }

    public static void glDrawTransformFeedbackInstanced(int mode, int id, int primcount) {
        org.lwjgl.opengl.GL42.glDrawTransformFeedbackInstanced(mode, id, primcount);
    }

    public static void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int primcount) {
        org.lwjgl.opengl.GL42.glDrawTransformFeedbackStreamInstanced(mode, id, stream, primcount);
    }

    public static void glGetActiveAtomicCounterBuffer(
            int program, int bufferIndex, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL42.glGetActiveAtomicCounterBufferiv(program, bufferIndex, pname, params);
    }

    public static void glGetInternalformat(int target, int internalformat, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL42.glGetInternalformativ(target, internalformat, pname, params);
    }

    public static void glMemoryBarrier(int barriers) {
        org.lwjgl.opengl.GL42.glMemoryBarrier(barriers);
    }

    public static void glTexStorage1D(int target, int levels, int internalformat, int width) {
        org.lwjgl.opengl.GL42.glTexStorage1D(target, levels, internalformat, width);
    }

    public static void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
        org.lwjgl.opengl.GL42.glTexStorage2D(target, levels, internalformat, width, height);
    }

    public static void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
        org.lwjgl.opengl.GL42.glTexStorage3D(target, levels, internalformat, width, height, depth);
    }
}
