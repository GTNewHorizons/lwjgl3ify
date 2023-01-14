package org.lwjglx.opengl;

public class ARBUniformBufferObject {
    public static void glBindBufferBase(int target, int index, int buffer) {
        org.lwjgl.opengl.ARBUniformBufferObject.glBindBufferBase(target, index, buffer);
    }

    public static void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
        org.lwjgl.opengl.ARBUniformBufferObject.glBindBufferRange(target, index, buffer, offset, size);
    }

    public static java.lang.String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize);
    }

    public static void glGetActiveUniformBlockName(
            int program, int uniformBlockIndex, java.nio.IntBuffer length, java.nio.ByteBuffer uniformBlockName) {
        org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformBlockName(
                program, uniformBlockIndex, length, uniformBlockName);
    }

    public static int glGetActiveUniformBlocki(int program, int uniformBlockIndex, int pname) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
    }

    public static java.lang.String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformName(program, uniformIndex, bufSize);
    }

    public static void glGetActiveUniformName(
            int program, int uniformIndex, java.nio.IntBuffer length, java.nio.ByteBuffer uniformName) {
        org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformName(program, uniformIndex, length, uniformName);
    }

    public static int glGetActiveUniformsi(int program, int uniformIndex, int pname) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsi(program, uniformIndex, pname);
    }

    public static int glGetUniformBlockIndex(int program, java.lang.CharSequence uniformBlockName) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetUniformBlockIndex(program, uniformBlockName);
    }

    public static int glGetUniformBlockIndex(int program, java.nio.ByteBuffer uniformBlockName) {
        return org.lwjgl.opengl.ARBUniformBufferObject.glGetUniformBlockIndex(program, uniformBlockName);
    }

    public static void glGetUniformIndices(
            int program, java.lang.CharSequence[] uniformNames, java.nio.IntBuffer uniformIndices) {
        org.lwjgl.opengl.ARBUniformBufferObject.glGetUniformIndices(program, uniformNames, uniformIndices);
    }

    public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
        org.lwjgl.opengl.ARBUniformBufferObject.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
    }
}
