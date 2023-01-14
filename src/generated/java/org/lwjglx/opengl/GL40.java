package org.lwjglx.opengl;

public class GL40 {
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
