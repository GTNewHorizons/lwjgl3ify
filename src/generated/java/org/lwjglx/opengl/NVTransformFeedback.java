package org.lwjglx.opengl;

public class NVTransformFeedback {
    public static void glActiveVaryingNV(int program, java.lang.CharSequence name) {
        org.lwjgl.opengl.NVTransformFeedback.glActiveVaryingNV(program, name);
    }

    public static void glActiveVaryingNV(int program, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.NVTransformFeedback.glActiveVaryingNV(program, name);
    }

    public static void glBeginTransformFeedbackNV(int primitiveMode) {
        org.lwjgl.opengl.NVTransformFeedback.glBeginTransformFeedbackNV(primitiveMode);
    }

    public static void glBindBufferBaseNV(int target, int index, int buffer) {
        org.lwjgl.opengl.NVTransformFeedback.glBindBufferBaseNV(target, index, buffer);
    }

    public static void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
        org.lwjgl.opengl.NVTransformFeedback.glBindBufferOffsetNV(target, index, buffer, offset);
    }

    public static void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
        org.lwjgl.opengl.NVTransformFeedback.glBindBufferRangeNV(target, index, buffer, offset, size);
    }

    public static void glEndTransformFeedbackNV() {
        org.lwjgl.opengl.NVTransformFeedback.glEndTransformFeedbackNV();
    }

    public static void glGetActiveVaryingNV(
            int program,
            int index,
            java.nio.IntBuffer length,
            java.nio.IntBuffer size,
            java.nio.IntBuffer type,
            java.nio.ByteBuffer name) {
        org.lwjgl.opengl.NVTransformFeedback.glGetActiveVaryingNV(program, index, length, size, type, name);
    }

    public static int glGetTransformFeedbackVaryingNV(int program, int index) {
        return org.lwjgl.opengl.NVTransformFeedback.glGetTransformFeedbackVaryingNV(program, index);
    }

    public static void glGetTransformFeedbackVaryingNV(int program, int index, java.nio.IntBuffer location) {
        org.lwjgl.opengl.NVTransformFeedback.glGetTransformFeedbackVaryingNV(program, index, location);
    }

    public static int glGetVaryingLocationNV(int program, java.lang.CharSequence name) {
        return org.lwjgl.opengl.NVTransformFeedback.glGetVaryingLocationNV(program, name);
    }

    public static int glGetVaryingLocationNV(int program, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.NVTransformFeedback.glGetVaryingLocationNV(program, name);
    }

    public static void glTransformFeedbackAttribsNV(java.nio.IntBuffer attribs, int bufferMode) {
        org.lwjgl.opengl.NVTransformFeedback.glTransformFeedbackAttribsNV(attribs, bufferMode);
    }

    public static void glTransformFeedbackVaryingsNV(int program, java.nio.IntBuffer locations, int bufferMode) {
        org.lwjgl.opengl.NVTransformFeedback.glTransformFeedbackVaryingsNV(program, locations, bufferMode);
    }
}
