package org.lwjglx.opengl;

public class GL20 {
    public static void glAttachShader(int program, int shader) {
        org.lwjgl.opengl.GL20.glAttachShader(program, shader);
    }

    public static void glBindAttribLocation(int program, int index, java.lang.CharSequence name) {
        org.lwjgl.opengl.GL20.glBindAttribLocation(program, index, name);
    }

    public static void glBindAttribLocation(int program, int index, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL20.glBindAttribLocation(program, index, name);
    }

    public static void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
        org.lwjgl.opengl.GL20.glBlendEquationSeparate(modeRGB, modeAlpha);
    }

    public static void glCompileShader(int shader) {
        org.lwjgl.opengl.GL20.glCompileShader(shader);
    }

    public static int glCreateProgram() {
        return org.lwjgl.opengl.GL20.glCreateProgram();
    }

    public static int glCreateShader(int type) {
        return org.lwjgl.opengl.GL20.glCreateShader(type);
    }

    public static void glDeleteProgram(int program) {
        org.lwjgl.opengl.GL20.glDeleteProgram(program);
    }

    public static void glDeleteShader(int shader) {
        org.lwjgl.opengl.GL20.glDeleteShader(shader);
    }

    public static void glDetachShader(int program, int shader) {
        org.lwjgl.opengl.GL20.glDetachShader(program, shader);
    }

    public static void glDisableVertexAttribArray(int index) {
        org.lwjgl.opengl.GL20.glDisableVertexAttribArray(index);
    }

    public static void glDrawBuffers(int buffer) {
        org.lwjgl.opengl.GL20.glDrawBuffers(buffer);
    }

    public static void glDrawBuffers(java.nio.IntBuffer buffers) {
        org.lwjgl.opengl.GL20.glDrawBuffers(buffers);
    }

    public static void glEnableVertexAttribArray(int index) {
        org.lwjgl.opengl.GL20.glEnableVertexAttribArray(index);
    }

    public static void glGetActiveAttrib(
            int program,
            int index,
            java.nio.IntBuffer length,
            java.nio.IntBuffer size,
            java.nio.IntBuffer type,
            java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL20.glGetActiveAttrib(program, index, length, size, type, name);
    }

    public static void glGetActiveUniform(
            int program,
            int index,
            java.nio.IntBuffer length,
            java.nio.IntBuffer size,
            java.nio.IntBuffer type,
            java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL20.glGetActiveUniform(program, index, length, size, type, name);
    }

    public static void glGetAttachedShaders(int program, java.nio.IntBuffer count, java.nio.IntBuffer shaders) {
        org.lwjgl.opengl.GL20.glGetAttachedShaders(program, count, shaders);
    }

    public static int glGetAttribLocation(int program, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL20.glGetAttribLocation(program, name);
    }

    public static int glGetAttribLocation(int program, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL20.glGetAttribLocation(program, name);
    }

    public static void glGetProgram(int program, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL20.glGetProgramiv(program, pname, params);
    }

    public static java.lang.String glGetProgramInfoLog(int program, int maxLength) {
        return org.lwjgl.opengl.GL20.glGetProgramInfoLog(program, maxLength);
    }

    public static void glGetProgramInfoLog(int program, java.nio.IntBuffer length, java.nio.ByteBuffer infoLog) {
        org.lwjgl.opengl.GL20.glGetProgramInfoLog(program, length, infoLog);
    }

    public static int glGetProgrami(int program, int pname) {
        return org.lwjgl.opengl.GL20.glGetProgrami(program, pname);
    }

    public static void glGetShader(int shader, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL20.glGetShaderiv(shader, pname, params);
    }

    public static java.lang.String glGetShaderInfoLog(int shader, int maxLength) {
        return org.lwjgl.opengl.GL20.glGetShaderInfoLog(shader, maxLength);
    }

    public static void glGetShaderInfoLog(int shader, java.nio.IntBuffer length, java.nio.ByteBuffer infoLog) {
        org.lwjgl.opengl.GL20.glGetShaderInfoLog(shader, length, infoLog);
    }

    public static java.lang.String glGetShaderSource(int shader, int maxLength) {
        return org.lwjgl.opengl.GL20.glGetShaderSource(shader, maxLength);
    }

    public static void glGetShaderSource(int shader, java.nio.IntBuffer length, java.nio.ByteBuffer source) {
        org.lwjgl.opengl.GL20.glGetShaderSource(shader, length, source);
    }

    public static int glGetShaderi(int shader, int pname) {
        return org.lwjgl.opengl.GL20.glGetShaderi(shader, pname);
    }

    public static void glGetUniform(int program, int location, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL20.glGetUniformfv(program, location, params);
    }

    public static void glGetUniform(int program, int location, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL20.glGetUniformiv(program, location, params);
    }

    public static int glGetUniformLocation(int program, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL20.glGetUniformLocation(program, name);
    }

    public static int glGetUniformLocation(int program, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL20.glGetUniformLocation(program, name);
    }

    public static void glGetVertexAttrib(int index, int pname, java.nio.DoubleBuffer params) {
        org.lwjgl.opengl.GL20.glGetVertexAttribdv(index, pname, params);
    }

    public static void glGetVertexAttrib(int index, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL20.glGetVertexAttribfv(index, pname, params);
    }

    public static void glGetVertexAttrib(int index, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL20.glGetVertexAttribiv(index, pname, params);
    }

    public static boolean glIsProgram(int program) {
        return org.lwjgl.opengl.GL20.glIsProgram(program);
    }

    public static boolean glIsShader(int shader) {
        return org.lwjgl.opengl.GL20.glIsShader(shader);
    }

    public static void glLinkProgram(int program) {
        org.lwjgl.opengl.GL20.glLinkProgram(program);
    }

    public static void glShaderSource(int shader, java.lang.CharSequence string) {
        org.lwjgl.opengl.GL20.glShaderSource(shader, string);
    }

    public static void glShaderSource(int shader, java.nio.ByteBuffer string) {

        org.lwjgl.opengl.GL20.glShaderSource(shader, me.eigenraven.lwjgl3ify.BufferCasts.bufferToCharSeq(string));
    }

    public static void glShaderSource(int shader, java.lang.CharSequence[] strings) {
        org.lwjgl.opengl.GL20.glShaderSource(shader, strings);
    }

    public static void glStencilFuncSeparate(int face, int func, int ref, int mask) {
        org.lwjgl.opengl.GL20.glStencilFuncSeparate(face, func, ref, mask);
    }

    public static void glStencilMaskSeparate(int face, int mask) {
        org.lwjgl.opengl.GL20.glStencilMaskSeparate(face, mask);
    }

    public static void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
        org.lwjgl.opengl.GL20.glStencilOpSeparate(face, sfail, dpfail, dppass);
    }

    public static void glUniform1(int location, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL20.glUniform1fv(location, values);
    }

    public static void glUniform1(int location, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL20.glUniform1iv(location, values);
    }

    public static void glUniform1f(int location, float v0) {
        org.lwjgl.opengl.GL20.glUniform1f(location, v0);
    }

    public static void glUniform1i(int location, int v0) {
        org.lwjgl.opengl.GL20.glUniform1i(location, v0);
    }

    public static void glUniform2(int location, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL20.glUniform2fv(location, values);
    }

    public static void glUniform2(int location, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL20.glUniform2iv(location, values);
    }

    public static void glUniform2f(int location, float v0, float v1) {
        org.lwjgl.opengl.GL20.glUniform2f(location, v0, v1);
    }

    public static void glUniform2i(int location, int v0, int v1) {
        org.lwjgl.opengl.GL20.glUniform2i(location, v0, v1);
    }

    public static void glUniform3(int location, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL20.glUniform3fv(location, values);
    }

    public static void glUniform3(int location, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL20.glUniform3iv(location, values);
    }

    public static void glUniform3f(int location, float v0, float v1, float v2) {
        org.lwjgl.opengl.GL20.glUniform3f(location, v0, v1, v2);
    }

    public static void glUniform3i(int location, int v0, int v1, int v2) {
        org.lwjgl.opengl.GL20.glUniform3i(location, v0, v1, v2);
    }

    public static void glUniform4(int location, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL20.glUniform4fv(location, values);
    }

    public static void glUniform4(int location, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL20.glUniform4iv(location, values);
    }

    public static void glUniform4f(int location, float v0, float v1, float v2, float v3) {
        org.lwjgl.opengl.GL20.glUniform4f(location, v0, v1, v2, v3);
    }

    public static void glUniform4i(int location, int v0, int v1, int v2, int v3) {
        org.lwjgl.opengl.GL20.glUniform4i(location, v0, v1, v2, v3);
    }

    public static void glUniformMatrix2(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL20.glUniformMatrix2fv(location, transpose, matrices);
    }

    public static void glUniformMatrix3(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL20.glUniformMatrix3fv(location, transpose, matrices);
    }

    public static void glUniformMatrix4(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL20.glUniformMatrix4fv(location, transpose, matrices);
    }

    public static void glUseProgram(int program) {
        org.lwjgl.opengl.GL20.glUseProgram(program);
    }

    public static void glValidateProgram(int program) {
        org.lwjgl.opengl.GL20.glValidateProgram(program);
    }

    public static void glVertexAttrib1d(int index, double x) {
        org.lwjgl.opengl.GL20.glVertexAttrib1d(index, x);
    }

    public static void glVertexAttrib1f(int index, float x) {
        org.lwjgl.opengl.GL20.glVertexAttrib1f(index, x);
    }

    public static void glVertexAttrib1s(int index, short x) {
        org.lwjgl.opengl.GL20.glVertexAttrib1s(index, x);
    }

    public static void glVertexAttrib2d(int index, double x, double y) {
        org.lwjgl.opengl.GL20.glVertexAttrib2d(index, x, y);
    }

    public static void glVertexAttrib2f(int index, float x, float y) {
        org.lwjgl.opengl.GL20.glVertexAttrib2f(index, x, y);
    }

    public static void glVertexAttrib2s(int index, short x, short y) {
        org.lwjgl.opengl.GL20.glVertexAttrib2s(index, x, y);
    }

    public static void glVertexAttrib3d(int index, double x, double y, double z) {
        org.lwjgl.opengl.GL20.glVertexAttrib3d(index, x, y, z);
    }

    public static void glVertexAttrib3f(int index, float x, float y, float z) {
        org.lwjgl.opengl.GL20.glVertexAttrib3f(index, x, y, z);
    }

    public static void glVertexAttrib3s(int index, short x, short y, short z) {
        org.lwjgl.opengl.GL20.glVertexAttrib3s(index, x, y, z);
    }

    public static void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
        org.lwjgl.opengl.GL20.glVertexAttrib4Nub(index, x, y, z, w);
    }

    public static void glVertexAttrib4d(int index, double x, double y, double z, double w) {
        org.lwjgl.opengl.GL20.glVertexAttrib4d(index, x, y, z, w);
    }

    public static void glVertexAttrib4f(int index, float x, float y, float z, float w) {
        org.lwjgl.opengl.GL20.glVertexAttrib4f(index, x, y, z, w);
    }

    public static void glVertexAttrib4s(int index, short x, short y, short z, short w) {
        org.lwjgl.opengl.GL20.glVertexAttrib4s(index, x, y, z, w);
    }

    public static void glVertexAttribPointer(
            int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset) {
        org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, type, normalized, stride, buffer_buffer_offset);
    }

    public static void glVertexAttribPointer(
            int index, int size, int type, boolean normalized, int stride, java.nio.ByteBuffer buffer) {
        org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, type, normalized, stride, buffer);
    }

    public static void glVertexAttribPointer(
            int index, int size, boolean normalized, int stride, java.nio.DoubleBuffer buffer) {

        org.lwjgl.opengl.GL20.glVertexAttribPointer(
                index,
                size,
                org.lwjgl.opengl.GL11.GL_DOUBLE,
                normalized,
                stride,
                me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(buffer));
    }

    public static void glVertexAttribPointer(
            int index, int size, boolean normalized, int stride, java.nio.FloatBuffer buffer) {

        org.lwjgl.opengl.GL20.glVertexAttribPointer(
                index, size, org.lwjgl.opengl.GL11.GL_FLOAT, normalized, stride, buffer);
    }

    public static void glVertexAttribPointer(
            int index, int size, boolean unsigned, boolean normalized, int stride, java.nio.ByteBuffer buffer) {

        org.lwjgl.opengl.GL20.glVertexAttribPointer(
                index,
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE : org.lwjgl.opengl.GL11.GL_BYTE),
                normalized,
                stride,
                org.lwjglx.MemoryUtil.getAddress(buffer));
    }

    public static void glVertexAttribPointer(
            int index, int size, boolean unsigned, boolean normalized, int stride, java.nio.IntBuffer buffer) {

        org.lwjgl.opengl.GL20.glVertexAttribPointer(
                index,
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_INT : org.lwjgl.opengl.GL11.GL_INT),
                normalized,
                stride,
                org.lwjglx.MemoryUtil.getAddress(buffer));
    }

    public static void glVertexAttribPointer(
            int index, int size, boolean unsigned, boolean normalized, int stride, java.nio.ShortBuffer buffer) {

        org.lwjgl.opengl.GL20.glVertexAttribPointer(
                index,
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT : org.lwjgl.opengl.GL11.GL_SHORT),
                normalized,
                stride,
                org.lwjglx.MemoryUtil.getAddress(buffer));
    }
}
