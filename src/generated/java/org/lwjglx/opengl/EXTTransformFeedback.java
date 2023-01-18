package org.lwjglx.opengl;

public class EXTTransformFeedback {
    public static final int GL_INTERLEAVED_ATTRIBS_EXT = 35980;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_EXT = 35978;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_EXT = 35979;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_EXT = 35968;
    public static final int GL_PRIMITIVES_GENERATED_EXT = 35975;
    public static final int GL_RASTERIZER_DISCARD_EXT = 35977;
    public static final int GL_SEPARATE_ATTRIBS_EXT = 35981;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING_EXT = 35983;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_EXT = 35982;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE_EXT = 35967;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE_EXT = 35973;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START_EXT = 35972;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_EXT = 35976;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS_EXT = 35971;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH_EXT = 35958;

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
