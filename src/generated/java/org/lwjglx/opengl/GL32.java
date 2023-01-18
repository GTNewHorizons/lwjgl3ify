package org.lwjglx.opengl;

public class GL32 {
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
    public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
    public static final int GL_CONTEXT_PROFILE_MASK = 37158;
    public static final int GL_DEPTH_CLAMP = 34383;
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
    public static final int GL_GEOMETRY_INPUT_TYPE = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316;
    public static final int GL_GEOMETRY_SHADER = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT = 36314;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_LINES_ADJACENCY = 10;
    public static final int GL_LINE_STRIP_ADJACENCY = 11;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
    public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157;
    public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
    public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
    public static final int GL_MAX_INTEGER_SAMPLES = 37136;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_PROGRAM_POINT_SIZE = 34370;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
    public static final int GL_SAMPLE_MASK = 36433;
    public static final int GL_SAMPLE_MASK_VALUE = 36434;
    public static final int GL_SAMPLE_POSITION = 36432;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
    public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
    public static final int GL_TEXTURE_SAMPLES = 37126;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final long GL_TIMEOUT_IGNORED = -1;
    public static final int GL_TRIANGLES_ADJACENCY = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
    public static final int GL_WAIT_FAILED = 37149;

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
