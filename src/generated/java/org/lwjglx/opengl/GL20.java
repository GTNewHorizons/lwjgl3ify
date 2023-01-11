package org.lwjglx.opengl;

public class GL20 {
    public void glAttachShader(int arg0, int arg1) {
        org.lwjgl.opengl.GL20.glAttachShader(arg0, arg1);
    }

    public void glBindAttribLocation(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.GL20.glBindAttribLocation(arg0, arg1, arg2);
    }

    public void glBindAttribLocation(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL20.glBindAttribLocation(arg0, arg1, arg2);
    }

    public void glBlendEquationSeparate(int arg0, int arg1) {
        org.lwjgl.opengl.GL20.glBlendEquationSeparate(arg0, arg1);
    }

    public void glCompileShader(int arg0) {
        org.lwjgl.opengl.GL20.glCompileShader(arg0);
    }

    public int glCreateProgram() {
        return org.lwjgl.opengl.GL20.glCreateProgram();
    }

    public int glCreateShader(int arg0) {
        return org.lwjgl.opengl.GL20.glCreateShader(arg0);
    }

    public void glDeleteProgram(int arg0) {
        org.lwjgl.opengl.GL20.glDeleteProgram(arg0);
    }

    public void glDeleteShader(int arg0) {
        org.lwjgl.opengl.GL20.glDeleteShader(arg0);
    }

    public void glDetachShader(int arg0, int arg1) {
        org.lwjgl.opengl.GL20.glDetachShader(arg0, arg1);
    }

    public void glDisableVertexAttribArray(int arg0) {
        org.lwjgl.opengl.GL20.glDisableVertexAttribArray(arg0);
    }

    public void glDrawBuffers(int arg0) {
        org.lwjgl.opengl.GL20.glDrawBuffers(arg0);
    }

    public void glDrawBuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL20.glDrawBuffers(arg0);
    }

    public void glEnableVertexAttribArray(int arg0) {
        org.lwjgl.opengl.GL20.glEnableVertexAttribArray(arg0);
    }

    public void glGetActiveAttrib(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL20.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public void glGetActiveUniform(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL20.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public void glGetAttachedShaders(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetAttachedShaders(arg0, arg1, arg2);
    }

    public int glGetAttribLocation(int arg0, java.lang.CharSequence arg1) {
        return org.lwjgl.opengl.GL20.glGetAttribLocation(arg0, arg1);
    }

    public int glGetAttribLocation(int arg0, java.nio.ByteBuffer arg1) {
        return org.lwjgl.opengl.GL20.glGetAttribLocation(arg0, arg1);
    }

    public void glGetProgram(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetProgramiv(arg0, arg1, arg2);
    }

    public java.lang.String glGetProgramInfoLog(int arg0, int arg1) {
        return org.lwjgl.opengl.GL20.glGetProgramInfoLog(arg0, arg1);
    }

    public void glGetProgramInfoLog(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetProgramInfoLog(arg0, arg1, arg2);
    }

    public int glGetProgrami(int arg0, int arg1) {
        return org.lwjgl.opengl.GL20.glGetProgrami(arg0, arg1);
    }

    public void glGetShader(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetShaderiv(arg0, arg1, arg2);
    }

    public java.lang.String glGetShaderInfoLog(int arg0, int arg1) {
        return org.lwjgl.opengl.GL20.glGetShaderInfoLog(arg0, arg1);
    }

    public void glGetShaderInfoLog(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetShaderInfoLog(arg0, arg1, arg2);
    }

    public java.lang.String glGetShaderSource(int arg0, int arg1) {
        return org.lwjgl.opengl.GL20.glGetShaderSource(arg0, arg1);
    }

    public void glGetShaderSource(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetShaderSource(arg0, arg1, arg2);
    }

    public int glGetShaderi(int arg0, int arg1) {
        return org.lwjgl.opengl.GL20.glGetShaderi(arg0, arg1);
    }

    public void glGetUniform(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetUniformfv(arg0, arg1, arg2);
    }

    public void glGetUniform(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetUniformiv(arg0, arg1, arg2);
    }

    public int glGetUniformLocation(int arg0, java.lang.CharSequence arg1) {
        return org.lwjgl.opengl.GL20.glGetUniformLocation(arg0, arg1);
    }

    public int glGetUniformLocation(int arg0, java.nio.ByteBuffer arg1) {
        return org.lwjgl.opengl.GL20.glGetUniformLocation(arg0, arg1);
    }

    public void glGetVertexAttrib(int arg0, int arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetVertexAttribdv(arg0, arg1, arg2);
    }

    public void glGetVertexAttrib(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetVertexAttribfv(arg0, arg1, arg2);
    }

    public void glGetVertexAttrib(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL20.glGetVertexAttribiv(arg0, arg1, arg2);
    }

    public boolean glIsProgram(int arg0) {
        return org.lwjgl.opengl.GL20.glIsProgram(arg0);
    }

    public boolean glIsShader(int arg0) {
        return org.lwjgl.opengl.GL20.glIsShader(arg0);
    }

    public void glLinkProgram(int arg0) {
        org.lwjgl.opengl.GL20.glLinkProgram(arg0);
    }

    public void glShaderSource(int arg0, java.lang.CharSequence arg1) {
        org.lwjgl.opengl.GL20.glShaderSource(arg0, arg1);
    }

    public void glShaderSource(int arg0, java.lang.CharSequence[] arg1) {
        org.lwjgl.opengl.GL20.glShaderSource(arg0, arg1);
    }

    public void glStencilFuncSeparate(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL20.glStencilFuncSeparate(arg0, arg1, arg2, arg3);
    }

    public void glStencilMaskSeparate(int arg0, int arg1) {
        org.lwjgl.opengl.GL20.glStencilMaskSeparate(arg0, arg1);
    }

    public void glStencilOpSeparate(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL20.glStencilOpSeparate(arg0, arg1, arg2, arg3);
    }

    public void glUniform1(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform1fv(arg0, arg1);
    }

    public void glUniform1(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform1iv(arg0, arg1);
    }

    public void glUniform1f(int arg0, float arg1) {
        org.lwjgl.opengl.GL20.glUniform1f(arg0, arg1);
    }

    public void glUniform1i(int arg0, int arg1) {
        org.lwjgl.opengl.GL20.glUniform1i(arg0, arg1);
    }

    public void glUniform2(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform2fv(arg0, arg1);
    }

    public void glUniform2(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform2iv(arg0, arg1);
    }

    public void glUniform2f(int arg0, float arg1, float arg2) {
        org.lwjgl.opengl.GL20.glUniform2f(arg0, arg1, arg2);
    }

    public void glUniform2i(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL20.glUniform2i(arg0, arg1, arg2);
    }

    public void glUniform3(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform3fv(arg0, arg1);
    }

    public void glUniform3(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform3iv(arg0, arg1);
    }

    public void glUniform3f(int arg0, float arg1, float arg2, float arg3) {
        org.lwjgl.opengl.GL20.glUniform3f(arg0, arg1, arg2, arg3);
    }

    public void glUniform3i(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL20.glUniform3i(arg0, arg1, arg2, arg3);
    }

    public void glUniform4(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform4fv(arg0, arg1);
    }

    public void glUniform4(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL20.glUniform4iv(arg0, arg1);
    }

    public void glUniform4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.GL20.glUniform4f(arg0, arg1, arg2, arg3, arg4);
    }

    public void glUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL20.glUniform4i(arg0, arg1, arg2, arg3, arg4);
    }

    public void glUniformMatrix2(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL20.glUniformMatrix2fv(arg0, arg1, arg2);
    }

    public void glUniformMatrix3(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL20.glUniformMatrix3fv(arg0, arg1, arg2);
    }

    public void glUniformMatrix4(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL20.glUniformMatrix4fv(arg0, arg1, arg2);
    }

    public void glUseProgram(int arg0) {
        org.lwjgl.opengl.GL20.glUseProgram(arg0);
    }

    public void glValidateProgram(int arg0) {
        org.lwjgl.opengl.GL20.glValidateProgram(arg0);
    }

    public void glVertexAttrib1d(int arg0, double arg1) {
        org.lwjgl.opengl.GL20.glVertexAttrib1d(arg0, arg1);
    }

    public void glVertexAttrib1f(int arg0, float arg1) {
        org.lwjgl.opengl.GL20.glVertexAttrib1f(arg0, arg1);
    }

    public void glVertexAttrib1s(int arg0, short arg1) {
        org.lwjgl.opengl.GL20.glVertexAttrib1s(arg0, arg1);
    }

    public void glVertexAttrib2d(int arg0, double arg1, double arg2) {
        org.lwjgl.opengl.GL20.glVertexAttrib2d(arg0, arg1, arg2);
    }

    public void glVertexAttrib2f(int arg0, float arg1, float arg2) {
        org.lwjgl.opengl.GL20.glVertexAttrib2f(arg0, arg1, arg2);
    }

    public void glVertexAttrib2s(int arg0, short arg1, short arg2) {
        org.lwjgl.opengl.GL20.glVertexAttrib2s(arg0, arg1, arg2);
    }

    public void glVertexAttrib3d(int arg0, double arg1, double arg2, double arg3) {
        org.lwjgl.opengl.GL20.glVertexAttrib3d(arg0, arg1, arg2, arg3);
    }

    public void glVertexAttrib3f(int arg0, float arg1, float arg2, float arg3) {
        org.lwjgl.opengl.GL20.glVertexAttrib3f(arg0, arg1, arg2, arg3);
    }

    public void glVertexAttrib3s(int arg0, short arg1, short arg2, short arg3) {
        org.lwjgl.opengl.GL20.glVertexAttrib3s(arg0, arg1, arg2, arg3);
    }

    public void glVertexAttrib4Nub(int arg0, byte arg1, byte arg2, byte arg3, byte arg4) {
        org.lwjgl.opengl.GL20.glVertexAttrib4Nub(arg0, arg1, arg2, arg3, arg4);
    }

    public void glVertexAttrib4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
        org.lwjgl.opengl.GL20.glVertexAttrib4d(arg0, arg1, arg2, arg3, arg4);
    }

    public void glVertexAttrib4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.GL20.glVertexAttrib4f(arg0, arg1, arg2, arg3, arg4);
    }

    public void glVertexAttrib4s(int arg0, short arg1, short arg2, short arg3, short arg4) {
        org.lwjgl.opengl.GL20.glVertexAttrib4s(arg0, arg1, arg2, arg3, arg4);
    }

    public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, long arg5) {
        org.lwjgl.opengl.GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public void glVertexAttribPointer(int arg0, int arg1, int arg2, boolean arg3, int arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL20.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
    }


}
