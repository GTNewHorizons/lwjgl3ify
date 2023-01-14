package org.lwjglx.opengl;

public class GL31 {
    public static void glCopyBufferSubData(
            int readtarget, int writetarget, long readoffset, long writeoffset, long size) {
        org.lwjgl.opengl.GL31.glCopyBufferSubData(readtarget, writetarget, readoffset, writeoffset, size);
    }

    public static void glDrawArraysInstanced(int mode, int first, int count, int primcount) {
        org.lwjgl.opengl.GL31.glDrawArraysInstanced(mode, first, count, primcount);
    }

    public static void glDrawElementsInstanced(
            int mode, int indices_count, int type, long indices_buffer_offset, int primcount) {
        org.lwjgl.opengl.GL31.glDrawElementsInstanced(mode, indices_count, type, indices_buffer_offset, primcount);
    }

    public static void glDrawElementsInstanced(int mode, java.nio.ByteBuffer indices, int primcount) {
        org.lwjgl.opengl.GL31.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glDrawElementsInstanced(int mode, java.nio.IntBuffer indices, int primcount) {
        org.lwjgl.opengl.GL31.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glDrawElementsInstanced(int mode, java.nio.ShortBuffer indices, int primcount) {
        org.lwjgl.opengl.GL31.glDrawElementsInstanced(mode, indices, primcount);
    }

    public static void glGetActiveUniformBlock(
            int program, int uniformBlockIndex, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL31.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
    }

    public static java.lang.String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
        return org.lwjgl.opengl.GL31.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize);
    }

    public static void glGetActiveUniformBlockName(
            int program, int uniformBlockIndex, java.nio.IntBuffer length, java.nio.ByteBuffer uniformBlockName) {
        org.lwjgl.opengl.GL31.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName);
    }

    public static int glGetActiveUniformBlocki(int program, int uniformBlockIndex, int pname) {
        return org.lwjgl.opengl.GL31.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
    }

    public static java.lang.String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
        return org.lwjgl.opengl.GL31.glGetActiveUniformName(program, uniformIndex, bufSize);
    }

    public static void glGetActiveUniformName(
            int program, int uniformIndex, java.nio.IntBuffer length, java.nio.ByteBuffer uniformName) {
        org.lwjgl.opengl.GL31.glGetActiveUniformName(program, uniformIndex, length, uniformName);
    }

    public static void glGetActiveUniforms(
            int program, java.nio.IntBuffer uniformIndices, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL31.glGetActiveUniformsiv(program, uniformIndices, pname, params);
    }

    public static int glGetActiveUniformsi(int program, int uniformIndex, int pname) {
        return org.lwjgl.opengl.GL31.glGetActiveUniformsi(program, uniformIndex, pname);
    }

    public static int glGetUniformBlockIndex(int program, java.lang.CharSequence uniformBlockName) {
        return org.lwjgl.opengl.GL31.glGetUniformBlockIndex(program, uniformBlockName);
    }

    public static int glGetUniformBlockIndex(int program, java.nio.ByteBuffer uniformBlockName) {
        return org.lwjgl.opengl.GL31.glGetUniformBlockIndex(program, uniformBlockName);
    }

    public static void glGetUniformIndices(
            int program, java.lang.CharSequence[] uniformNames, java.nio.IntBuffer uniformIndices) {
        org.lwjgl.opengl.GL31.glGetUniformIndices(program, uniformNames, uniformIndices);
    }

    public static void glPrimitiveRestartIndex(int index) {
        org.lwjgl.opengl.GL31.glPrimitiveRestartIndex(index);
    }

    public static void glTexBuffer(int target, int internalformat, int buffer) {
        org.lwjgl.opengl.GL31.glTexBuffer(target, internalformat, buffer);
    }

    public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
        org.lwjgl.opengl.GL31.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
    }
}
