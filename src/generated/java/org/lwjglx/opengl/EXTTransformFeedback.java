package org.lwjglx.opengl;

public class EXTTransformFeedback {
    public static void glBeginTransformFeedbackEXT(int primitiveMode) {
        org.lwjgl.opengl.EXTTransformFeedback.glBeginTransformFeedbackEXT(primitiveMode);
    }

    public static void glBindBufferBaseEXT(int target, int index, int buffer) {
        org.lwjgl.opengl.EXTTransformFeedback.glBindBufferBaseEXT(target, index, buffer);
    }

    public static void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
        org.lwjgl.opengl.EXTTransformFeedback.glBindBufferOffsetEXT(target, index, buffer, offset);
    }

    public static void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
        org.lwjgl.opengl.EXTTransformFeedback.glBindBufferRangeEXT(target, index, buffer, offset, size);
    }

    public static void glEndTransformFeedbackEXT() {
        org.lwjgl.opengl.EXTTransformFeedback.glEndTransformFeedbackEXT();
    }

    public static java.lang.String glGetTransformFeedbackVaryingEXT(
            int program, int index, int bufSize, java.nio.IntBuffer size, java.nio.IntBuffer type) {
        return org.lwjgl.opengl.EXTTransformFeedback.glGetTransformFeedbackVaryingEXT(
                program, index, bufSize, size, type);
    }

    public static void glGetTransformFeedbackVaryingEXT(
            int program,
            int index,
            java.nio.IntBuffer length,
            java.nio.IntBuffer size,
            java.nio.IntBuffer type,
            java.nio.ByteBuffer name) {
        org.lwjgl.opengl.EXTTransformFeedback.glGetTransformFeedbackVaryingEXT(
                program, index, length, size, type, name);
    }

    public static void glTransformFeedbackVaryingsEXT(int program, java.lang.CharSequence[] varyings, int bufferMode) {
        org.lwjgl.opengl.EXTTransformFeedback.glTransformFeedbackVaryingsEXT(program, varyings, bufferMode);
    }
}
