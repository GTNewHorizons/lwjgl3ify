package org.lwjglx.opengl;

public class GL40 {
    public void glBeginQueryIndexed(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL40.glBeginQueryIndexed(arg0, arg1, arg2);
    }

    public void glBindTransformFeedback(int arg0, int arg1) {
        org.lwjgl.opengl.GL40.glBindTransformFeedback(arg0, arg1);
    }

    public void glBlendEquationSeparatei(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL40.glBlendEquationSeparatei(arg0, arg1, arg2);
    }

    public void glBlendEquationi(int arg0, int arg1) {
        org.lwjgl.opengl.GL40.glBlendEquationi(arg0, arg1);
    }

    public void glBlendFuncSeparatei(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL40.glBlendFuncSeparatei(arg0, arg1, arg2, arg3, arg4);
    }

    public void glBlendFunci(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL40.glBlendFunci(arg0, arg1, arg2);
    }

    public void glDeleteTransformFeedbacks(int arg0) {
        org.lwjgl.opengl.GL40.glDeleteTransformFeedbacks(arg0);
    }

    public void glDeleteTransformFeedbacks(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL40.glDeleteTransformFeedbacks(arg0);
    }

    public void glDrawArraysIndirect(int arg0, long arg1) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(arg0, arg1);
    }

    public void glDrawArraysIndirect(int arg0, java.nio.ByteBuffer arg1) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(arg0, arg1);
    }

    public void glDrawArraysIndirect(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL40.glDrawArraysIndirect(arg0, arg1);
    }

    public void glDrawElementsIndirect(int arg0, int arg1, long arg2) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(arg0, arg1, arg2);
    }

    public void glDrawElementsIndirect(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(arg0, arg1, arg2);
    }

    public void glDrawElementsIndirect(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL40.glDrawElementsIndirect(arg0, arg1, arg2);
    }

    public void glDrawTransformFeedback(int arg0, int arg1) {
        org.lwjgl.opengl.GL40.glDrawTransformFeedback(arg0, arg1);
    }

    public void glDrawTransformFeedbackStream(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL40.glDrawTransformFeedbackStream(arg0, arg1, arg2);
    }

    public void glEndQueryIndexed(int arg0, int arg1) {
        org.lwjgl.opengl.GL40.glEndQueryIndexed(arg0, arg1);
    }

    public int glGenTransformFeedbacks() {
        return org.lwjgl.opengl.GL40.glGenTransformFeedbacks();
    }

    public void glGenTransformFeedbacks(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL40.glGenTransformFeedbacks(arg0);
    }

    public java.lang.String glGetActiveSubroutineName(int arg0, int arg1, int arg2, int arg3) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineName(arg0, arg1, arg2, arg3);
    }

    public void glGetActiveSubroutineName(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineName(arg0, arg1, arg2, arg3, arg4);
    }

    public void glGetActiveSubroutineUniform(int arg0, int arg1, int arg2, int arg3, java.nio.IntBuffer arg4) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformiv(arg0, arg1, arg2, arg3, arg4);
    }

    public java.lang.String glGetActiveSubroutineUniformName(int arg0, int arg1, int arg2, int arg3) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformName(arg0, arg1, arg2, arg3);
    }

    public void glGetActiveSubroutineUniformName(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformName(arg0, arg1, arg2, arg3, arg4);
    }

    public int glGetActiveSubroutineUniformi(int arg0, int arg1, int arg2, int arg3) {
        return org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformi(arg0, arg1, arg2, arg3);
    }

    public void glGetProgramStage(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL40.glGetProgramStageiv(arg0, arg1, arg2, arg3);
    }

    public int glGetProgramStagei(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL40.glGetProgramStagei(arg0, arg1, arg2);
    }

    public void glGetQueryIndexed(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL40.glGetQueryIndexediv(arg0, arg1, arg2, arg3);
    }

    public int glGetQueryIndexedi(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL40.glGetQueryIndexedi(arg0, arg1, arg2);
    }

    public int glGetSubroutineIndex(int arg0, int arg1, java.lang.CharSequence arg2) {
        return org.lwjgl.opengl.GL40.glGetSubroutineIndex(arg0, arg1, arg2);
    }

    public int glGetSubroutineIndex(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL40.glGetSubroutineIndex(arg0, arg1, arg2);
    }

    public int glGetSubroutineUniformLocation(int arg0, int arg1, java.lang.CharSequence arg2) {
        return org.lwjgl.opengl.GL40.glGetSubroutineUniformLocation(arg0, arg1, arg2);
    }

    public int glGetSubroutineUniformLocation(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL40.glGetSubroutineUniformLocation(arg0, arg1, arg2);
    }

    public void glGetUniform(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glGetUniformdv(arg0, arg1, arg2);
    }

    public void glGetUniformSubroutineu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL40.glGetUniformSubroutineuiv(arg0, arg1, arg2);
    }

    public int glGetUniformSubroutineui(int arg0, int arg1) {
        return org.lwjgl.opengl.GL40.glGetUniformSubroutineui(arg0, arg1);
    }

    public boolean glIsTransformFeedback(int arg0) {
        return org.lwjgl.opengl.GL40.glIsTransformFeedback(arg0);
    }

    public void glMinSampleShading(float arg0) {
        org.lwjgl.opengl.GL40.glMinSampleShading(arg0);
    }

    public void glPatchParameter(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL40.glPatchParameterfv(arg0, arg1);
    }

    public void glPatchParameteri(int arg0, int arg1) {
        org.lwjgl.opengl.GL40.glPatchParameteri(arg0, arg1);
    }

    public void glPauseTransformFeedback() {
        org.lwjgl.opengl.GL40.glPauseTransformFeedback();
    }

    public void glResumeTransformFeedback() {
        org.lwjgl.opengl.GL40.glResumeTransformFeedback();
    }

    public void glUniform1(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL40.glUniform1dv(arg0, arg1);
    }

    public void glUniform1d(int arg0, double arg1) {
        org.lwjgl.opengl.GL40.glUniform1d(arg0, arg1);
    }

    public void glUniform2(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL40.glUniform2dv(arg0, arg1);
    }

    public void glUniform2d(int arg0, double arg1, double arg2) {
        org.lwjgl.opengl.GL40.glUniform2d(arg0, arg1, arg2);
    }

    public void glUniform3(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL40.glUniform3dv(arg0, arg1);
    }

    public void glUniform3d(int arg0, double arg1, double arg2, double arg3) {
        org.lwjgl.opengl.GL40.glUniform3d(arg0, arg1, arg2, arg3);
    }

    public void glUniform4(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL40.glUniform4dv(arg0, arg1);
    }

    public void glUniform4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
        org.lwjgl.opengl.GL40.glUniform4d(arg0, arg1, arg2, arg3, arg4);
    }

    public void glUniformMatrix2(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix2dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix2x3(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix2x3dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix2x4(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix2x4dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix3(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix3dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix3x2(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix3x2dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix3x4(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix3x4dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix4(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix4dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix4x2(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix4x2dv(arg0, arg1, arg2);
    }

    public void glUniformMatrix4x3(int arg0, boolean arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL40.glUniformMatrix4x3dv(arg0, arg1, arg2);
    }

    public void glUniformSubroutinesu(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL40.glUniformSubroutinesuiv(arg0, arg1);
    }


}
