package org.lwjglx.opengl;

public class GL40 {
    public static final int GL_ACTIVE_SUBROUTINES = 36325;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 36424;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 36326;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 36423;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 36425;
    public static final int GL_COMPATIBLE_SUBROUTINES = 36427;
    public static final int GL_DOUBLE_MAT2 = 36678;
    public static final int GL_DOUBLE_MAT2x3 = 36681;
    public static final int GL_DOUBLE_MAT2x4 = 36682;
    public static final int GL_DOUBLE_MAT3 = 36679;
    public static final int GL_DOUBLE_MAT3x2 = 36683;
    public static final int GL_DOUBLE_MAT3x4 = 36684;
    public static final int GL_DOUBLE_MAT4 = 36680;
    public static final int GL_DOUBLE_MAT4x2 = 36685;
    public static final int GL_DOUBLE_MAT4x3 = 36686;
    public static final int GL_DOUBLE_VEC2 = 36860;
    public static final int GL_DOUBLE_VEC3 = 36861;
    public static final int GL_DOUBLE_VEC4 = 36862;
    public static final int GL_DRAW_INDIRECT_BUFFER = 36671;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 36675;
    public static final int GL_FRACTIONAL_EVEN = 36476;
    public static final int GL_FRACTIONAL_ODD = 36475;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 36445;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 34943;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 36878;
    public static final int GL_ISOLINES = 36474;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 36382;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 36383;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 36444;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 36442;
    public static final int GL_MAX_PATCH_VERTICES = 36477;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 36767;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36447;
    public static final int GL_MAX_SUBROUTINES = 36327;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 36328;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 34924;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 36483;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 36481;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 36485;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 36489;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 36479;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 34925;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 36486;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 36482;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 36490;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 36480;
    public static final int GL_MAX_TESS_GEN_LEVEL = 36478;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 36484;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 36464;
    public static final int GL_MAX_VERTEX_STREAMS = 36465;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 36443;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 36446;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 35895;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 36426;
    public static final int GL_PATCHES = 14;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 36467;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 36468;
    public static final int GL_PATCH_VERTICES = 36466;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 36875;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 36876;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 36877;
    public static final int GL_SAMPLE_SHADING = 35894;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 36469;
    public static final int GL_TESS_CONTROL_SHADER = 36488;
    public static final int GL_TESS_EVALUATION_SHADER = 36487;
    public static final int GL_TESS_GEN_MODE = 36470;
    public static final int GL_TESS_GEN_POINT_MODE = 36473;
    public static final int GL_TESS_GEN_SPACING = 36471;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 36472;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 36874;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 36873;
    public static final int GL_TRANSFORM_FEEDBACK = 36386;
    public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 36389;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 36388;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 36387;
    public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 36387;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 34032;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 34033;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 36879;

    public static void glBeginQueryIndexed(int target, int index, int id) {
        org.lwjgl.opengl.GL40.glBeginQueryIndexed(target, index, id);
    }

    public static void glBindTransformFeedback(int target, int id) {
        org.lwjgl.opengl.GL40.glBindTransformFeedback(target, id);
    }

    public static void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
        org.lwjgl.opengl.GL40.glBlendEquationSeparatei(buf, modeRGB, modeAlpha);
    }

    public static void glBlendEquationi(int buf, int mode) {
        org.lwjgl.opengl.GL40.glBlendEquationi(buf, mode);
    }

    public static void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        org.lwjgl.opengl.GL40.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
    }

    public static void glBlendFunci(int buf, int src, int dst) {
        org.lwjgl.opengl.GL40.glBlendFunci(buf, src, dst);
    }

    public static void glDeleteTransformFeedbacks(int id) {
        org.lwjgl.opengl.GL40.glDeleteTransformFeedbacks(id);
    }

    public static void glDeleteTransformFeedbacks(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.GL40.glDeleteTransformFeedbacks(ids);
    }

    public static void glDrawArraysIndirect(int mode, long indirect_buffer_offset) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(mode, indirect_buffer_offset);
    }

    public static void glDrawArraysIndirect(int mode, java.nio.ByteBuffer indirect) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(int mode, java.nio.IntBuffer indirect) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, long indirect_buffer_offset) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(mode, type, indirect_buffer_offset);
    }

    public static void glDrawElementsIndirect(int mode, int type, java.nio.ByteBuffer indirect) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, java.nio.IntBuffer indirect) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawTransformFeedback(int mode, int id) {
        org.lwjgl.opengl.GL40.glDrawTransformFeedback(mode, id);
    }

    public static void glDrawTransformFeedbackStream(int mode, int id, int stream) {
        org.lwjgl.opengl.GL40.glDrawTransformFeedbackStream(mode, id, stream);
    }

    public static void glEndQueryIndexed(int target, int index) {
        org.lwjgl.opengl.GL40.glEndQueryIndexed(target, index);
    }

    public static int glGenTransformFeedbacks() {
        return org.lwjgl.opengl.GL40.glGenTransformFeedbacks();
    }

    public static void glGenTransformFeedbacks(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.GL40.glGenTransformFeedbacks(ids);
    }

    public static java.lang.String glGetActiveSubroutineName(int program, int shadertype, int index, int bufsize) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineName(program, shadertype, index, bufsize);
    }

    public static void glGetActiveSubroutineName(
            int program, int shadertype, int index, java.nio.IntBuffer length, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineName(program, shadertype, index, length, name);
    }

    public static void glGetActiveSubroutineUniform(
            int program, int shadertype, int index, int pname, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
    }

    public static java.lang.String glGetActiveSubroutineUniformName(
            int program, int shadertype, int index, int bufsize) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformName(program, shadertype, index, bufsize);
    }

    public static void glGetActiveSubroutineUniformName(
            int program, int shadertype, int index, java.nio.IntBuffer length, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformName(program, shadertype, index, length, name);
    }

    public static int glGetActiveSubroutineUniformi(int program, int shadertype, int index, int pname) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformi(program, shadertype, index, pname);
    }

    public static void glGetProgramStage(int program, int shadertype, int pname, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL40.glGetProgramStageiv(program, shadertype, pname, values);
    }

    public static int glGetProgramStagei(int program, int shadertype, int pname) {
        return org.lwjgl.opengl.GL40.glGetProgramStagei(program, shadertype, pname);
    }

    public static void glGetQueryIndexed(int target, int index, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL40.glGetQueryIndexediv(target, index, pname, params);
    }

    public static int glGetQueryIndexedi(int target, int index, int pname) {
        return org.lwjgl.opengl.GL40.glGetQueryIndexedi(target, index, pname);
    }

    public static int glGetSubroutineIndex(int program, int shadertype, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL40.glGetSubroutineIndex(program, shadertype, name);
    }

    public static int glGetSubroutineIndex(int program, int shadertype, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL40.glGetSubroutineIndex(program, shadertype, name);
    }

    public static int glGetSubroutineUniformLocation(int program, int shadertype, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL40.glGetSubroutineUniformLocation(program, shadertype, name);
    }

    public static int glGetSubroutineUniformLocation(int program, int shadertype, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL40.glGetSubroutineUniformLocation(program, shadertype, name);
    }

    public static void glGetUniform(int program, int location, java.nio.DoubleBuffer params) {
        org.lwjgl.opengl.GL40.glGetUniformdv(program, location, params);
    }

    public static void glGetUniformSubroutineu(int shadertype, int location, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL40.glGetUniformSubroutineuiv(shadertype, location, params);
    }

    public static int glGetUniformSubroutineui(int shadertype, int location) {
        return org.lwjgl.opengl.GL40.glGetUniformSubroutineui(shadertype, location);
    }

    public static boolean glIsTransformFeedback(int id) {
        return org.lwjgl.opengl.GL40.glIsTransformFeedback(id);
    }

    public static void glMinSampleShading(float value) {
        org.lwjgl.opengl.GL40.glMinSampleShading(value);
    }

    public static void glPatchParameter(int pname, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL40.glPatchParameterfv(pname, values);
    }

    public static void glPatchParameteri(int pname, int value) {
        org.lwjgl.opengl.GL40.glPatchParameteri(pname, value);
    }

    public static void glPauseTransformFeedback() {
        org.lwjgl.opengl.GL40.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        org.lwjgl.opengl.GL40.glResumeTransformFeedback();
    }

    public static void glUniform1(int location, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniform1dv(location, value);
    }

    public static void glUniform1d(int location, double x) {
        org.lwjgl.opengl.GL40.glUniform1d(location, x);
    }

    public static void glUniform2(int location, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniform2dv(location, value);
    }

    public static void glUniform2d(int location, double x, double y) {
        org.lwjgl.opengl.GL40.glUniform2d(location, x, y);
    }

    public static void glUniform3(int location, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniform3dv(location, value);
    }

    public static void glUniform3d(int location, double x, double y, double z) {
        org.lwjgl.opengl.GL40.glUniform3d(location, x, y, z);
    }

    public static void glUniform4(int location, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniform4dv(location, value);
    }

    public static void glUniform4d(int location, double x, double y, double z, double w) {
        org.lwjgl.opengl.GL40.glUniform4d(location, x, y, z, w);
    }

    public static void glUniformMatrix2(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix2dv(location, transpose, value);
    }

    public static void glUniformMatrix2x3(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix2x3dv(location, transpose, value);
    }

    public static void glUniformMatrix2x4(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix2x4dv(location, transpose, value);
    }

    public static void glUniformMatrix3(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix3dv(location, transpose, value);
    }

    public static void glUniformMatrix3x2(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix3x2dv(location, transpose, value);
    }

    public static void glUniformMatrix3x4(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix3x4dv(location, transpose, value);
    }

    public static void glUniformMatrix4(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix4dv(location, transpose, value);
    }

    public static void glUniformMatrix4x2(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix4x2dv(location, transpose, value);
    }

    public static void glUniformMatrix4x3(int location, boolean transpose, java.nio.DoubleBuffer value) {
        org.lwjgl.opengl.GL40.glUniformMatrix4x3dv(location, transpose, value);
    }

    public static void glUniformSubroutinesu(int shadertype, java.nio.IntBuffer indices) {
        org.lwjgl.opengl.GL40.glUniformSubroutinesuiv(shadertype, indices);
    }
}
