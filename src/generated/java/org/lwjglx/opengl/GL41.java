package org.lwjglx.opengl;

public class GL41 {
    public static void glActiveShaderProgram(int arg0, int arg1) {
        org.lwjgl.opengl.GL41.glActiveShaderProgram(arg0, arg1);
    }

    public static void glBindProgramPipeline(int arg0) {
        org.lwjgl.opengl.GL41.glBindProgramPipeline(arg0);
    }

    public static void glClearDepthf(float arg0) {
        org.lwjgl.opengl.GL41.glClearDepthf(arg0);
    }

    public static int glCreateShaderProgram(int arg0, java.lang.CharSequence arg1) {
        return org.lwjgl.opengl.GL41.glCreateShaderProgramv(arg0, arg1);
    }

    public static int glCreateShaderProgram(int arg0, java.nio.ByteBuffer arg1) {

        int returnValue = org.lwjgl.opengl.GL41.glCreateShaderProgramv(arg0, me.eigenraven.lwjgl3ify.BufferCasts.bufferToCharSeq(arg1));

        return returnValue;
    }

    public static void glDeleteProgramPipelines(int arg0) {
        org.lwjgl.opengl.GL41.glDeleteProgramPipelines(arg0);
    }

    public static void glDeleteProgramPipelines(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL41.glDeleteProgramPipelines(arg0);
    }

    public static void glDepthRangeArray(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL41.glDepthRangeArrayv(arg0, arg1);
    }

    public static void glDepthRangeIndexed(int arg0, double arg1, double arg2) {
        org.lwjgl.opengl.GL41.glDepthRangeIndexed(arg0, arg1, arg2);
    }

    public static void glDepthRangef(float arg0, float arg1) {
        org.lwjgl.opengl.GL41.glDepthRangef(arg0, arg1);
    }

    public static int glGenProgramPipelines() {
        return org.lwjgl.opengl.GL41.glGenProgramPipelines();
    }

    public static void glGenProgramPipelines(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL41.glGenProgramPipelines(arg0);
    }

    public static void glGetDouble(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glGetDoublei_v(arg0, arg1, arg2);
    }

    public static void glGetFloat(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL41.glGetFloati_v(arg0, arg1, arg2);
    }

    public static void glGetProgramBinary(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.GL41.glGetProgramBinary(arg0, arg1, arg2, arg3);
    }

    public static void glGetProgramPipeline(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glGetProgramPipelineiv(arg0, arg1, arg2);
    }

    public static java.lang.String glGetProgramPipelineInfoLog(int arg0, int arg1) {
        return org.lwjgl.opengl.GL41.glGetProgramPipelineInfoLog(arg0, arg1);
    }

    public static void glGetProgramPipelineInfoLog(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL41.glGetProgramPipelineInfoLog(arg0, arg1, arg2);
    }

    public static int glGetProgramPipelinei(int arg0, int arg1) {
        return org.lwjgl.opengl.GL41.glGetProgramPipelinei(arg0, arg1);
    }

    public static void glGetShaderPrecisionFormat(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL41.glGetShaderPrecisionFormat(arg0, arg1, arg2, arg3);
    }

    public static void glGetVertexAttribL(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glGetVertexAttribLdv(arg0, arg1, arg2);
    }

    public static boolean glIsProgramPipeline(int arg0) {
        return org.lwjgl.opengl.GL41.glIsProgramPipeline(arg0);
    }

    public static void glProgramBinary(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramBinary(arg0, arg1, arg2);
    }

    public static void glProgramParameteri(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL41.glProgramParameteri(arg0, arg1, arg2);
    }

    public static void glProgramUniform1(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1dv(arg0, arg1, arg2);
    }

    public static void glProgramUniform1(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1fv(arg0, arg1, arg2);
    }

    public static void glProgramUniform1(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1iv(arg0, arg1, arg2);
    }

    public static void glProgramUniform1d(int arg0, int arg1, double arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1d(arg0, arg1, arg2);
    }

    public static void glProgramUniform1f(int arg0, int arg1, float arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1f(arg0, arg1, arg2);
    }

    public static void glProgramUniform1i(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1i(arg0, arg1, arg2);
    }

    public static void glProgramUniform1u(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1uiv(arg0, arg1, arg2);
    }

    public static void glProgramUniform1ui(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform1ui(arg0, arg1, arg2);
    }

    public static void glProgramUniform2(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform2dv(arg0, arg1, arg2);
    }

    public static void glProgramUniform2(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform2fv(arg0, arg1, arg2);
    }

    public static void glProgramUniform2(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform2iv(arg0, arg1, arg2);
    }

    public static void glProgramUniform2d(int arg0, int arg1, double arg2, double arg3) {
        org.lwjgl.opengl.GL41.glProgramUniform2d(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniform2f(int arg0, int arg1, float arg2, float arg3) {
        org.lwjgl.opengl.GL41.glProgramUniform2f(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniform2i(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL41.glProgramUniform2i(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniform2u(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform2uiv(arg0, arg1, arg2);
    }

    public static void glProgramUniform2ui(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL41.glProgramUniform2ui(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniform3(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform3dv(arg0, arg1, arg2);
    }

    public static void glProgramUniform3(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform3fv(arg0, arg1, arg2);
    }

    public static void glProgramUniform3(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform3iv(arg0, arg1, arg2);
    }

    public static void glProgramUniform3d(int arg0, int arg1, double arg2, double arg3, double arg4) {
        org.lwjgl.opengl.GL41.glProgramUniform3d(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glProgramUniform3f(int arg0, int arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.GL41.glProgramUniform3f(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glProgramUniform3i(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL41.glProgramUniform3i(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glProgramUniform3u(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform3uiv(arg0, arg1, arg2);
    }

    public static void glProgramUniform3ui(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL41.glProgramUniform3ui(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glProgramUniform4(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform4dv(arg0, arg1, arg2);
    }

    public static void glProgramUniform4(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform4fv(arg0, arg1, arg2);
    }

    public static void glProgramUniform4(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform4iv(arg0, arg1, arg2);
    }

    public static void glProgramUniform4d(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5) {
        org.lwjgl.opengl.GL41.glProgramUniform4d(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glProgramUniform4f(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5) {
        org.lwjgl.opengl.GL41.glProgramUniform4f(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glProgramUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL41.glProgramUniform4i(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glProgramUniform4u(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL41.glProgramUniform4uiv(arg0, arg1, arg2);
    }

    public static void glProgramUniform4ui(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL41.glProgramUniform4ui(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glProgramUniformMatrix2(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix2(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix2x3(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2x3dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix2x3(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2x3fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix2x4(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2x4dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix2x4(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix2x4fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3x2(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3x2dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3x2(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3x2fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3x4(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3x4dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix3x4(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix3x4fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4x2(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4x2dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4x2(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4x2fv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4x3(int arg0, int arg1, boolean arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4x3dv(arg0, arg1, arg2, arg3);
    }

    public static void glProgramUniformMatrix4x3(int arg0, int arg1, boolean arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL41.glProgramUniformMatrix4x3fv(arg0, arg1, arg2, arg3);
    }

    public static void glReleaseShaderCompiler() {
        org.lwjgl.opengl.GL41.glReleaseShaderCompiler();
    }

    public static void glScissorArray(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL41.glScissorArrayv(arg0, arg1);
    }

    public static void glScissorIndexed(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL41.glScissorIndexed(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glScissorIndexed(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL41.glScissorIndexedv(arg0, arg1);
    }

    public static void glShaderBinary(java.nio.IntBuffer arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL41.glShaderBinary(arg0, arg1, arg2);
    }

    public static void glUseProgramStages(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL41.glUseProgramStages(arg0, arg1, arg2);
    }

    public static void glValidateProgramPipeline(int arg0) {
        org.lwjgl.opengl.GL41.glValidateProgramPipeline(arg0);
    }

    public static void glVertexAttribL1(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL41.glVertexAttribL1dv(arg0, arg1);
    }

    public static void glVertexAttribL1d(int arg0, double arg1) {
        org.lwjgl.opengl.GL41.glVertexAttribL1d(arg0, arg1);
    }

    public static void glVertexAttribL2(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL41.glVertexAttribL2dv(arg0, arg1);
    }

    public static void glVertexAttribL2d(int arg0, double arg1, double arg2) {
        org.lwjgl.opengl.GL41.glVertexAttribL2d(arg0, arg1, arg2);
    }

    public static void glVertexAttribL3(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL41.glVertexAttribL3dv(arg0, arg1);
    }

    public static void glVertexAttribL3d(int arg0, double arg1, double arg2, double arg3) {
        org.lwjgl.opengl.GL41.glVertexAttribL3d(arg0, arg1, arg2, arg3);
    }

    public static void glVertexAttribL4(int arg0, java.nio.DoubleBuffer arg1) {
        org.lwjgl.opengl.GL41.glVertexAttribL4dv(arg0, arg1);
    }

    public static void glVertexAttribL4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
        org.lwjgl.opengl.GL41.glVertexAttribL4d(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribLPointer(int arg0, int arg1, int arg2, java.nio.DoubleBuffer arg3) {
        org.lwjgl.opengl.GL41.glVertexAttribLPointer(arg0, arg1, arg2, arg3);
    }

    public static void glViewportArray(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL41.glViewportArrayv(arg0, arg1);
    }

    public static void glViewportIndexed(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL41.glViewportIndexedfv(arg0, arg1);
    }

    public static void glViewportIndexedf(int arg0, float arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.GL41.glViewportIndexedf(arg0, arg1, arg2, arg3, arg4);
    }


}
