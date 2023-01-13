package org.lwjglx.opengl;

public class ARBShaderObjects {
    public static void glAttachObjectARB(int arg0, int arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glAttachObjectARB(arg0, arg1);
    }

    public static void glCompileShaderARB(int arg0) {
        org.lwjgl.opengl.ARBShaderObjects.glCompileShaderARB(arg0);
    }

    public static int glCreateProgramObjectARB() {
        return org.lwjgl.opengl.ARBShaderObjects.glCreateProgramObjectARB();
    }

    public static int glCreateShaderObjectARB(int arg0) {
        return org.lwjgl.opengl.ARBShaderObjects.glCreateShaderObjectARB(arg0);
    }

    public static void glDeleteObjectARB(int arg0) {
        org.lwjgl.opengl.ARBShaderObjects.glDeleteObjectARB(arg0);
    }

    public static void glDetachObjectARB(int arg0, int arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glDetachObjectARB(arg0, arg1);
    }

    public static void glGetActiveUniformARB(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.ARBShaderObjects.glGetActiveUniformARB(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glGetAttachedObjectsARB(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetAttachedObjectsARB(arg0, arg1, arg2);
    }

    public static int glGetHandleARB(int arg0) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetHandleARB(arg0);
    }

    public static java.lang.String glGetInfoLogARB(int arg0, int arg1) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetInfoLogARB(arg0, arg1);
    }

    public static void glGetInfoLogARB(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetInfoLogARB(arg0, arg1, arg2);
    }

    public static void glGetObjectParameterARB(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterfvARB(arg0, arg1, arg2);
    }

    public static void glGetObjectParameterARB(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterivARB(arg0, arg1, arg2);
    }

    public static int glGetObjectParameteriARB(int arg0, int arg1) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameteriARB(arg0, arg1);
    }

    public static java.lang.String glGetShaderSourceARB(int arg0, int arg1) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetShaderSourceARB(arg0, arg1);
    }

    public static void glGetShaderSourceARB(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetShaderSourceARB(arg0, arg1, arg2);
    }

    public static void glGetUniformARB(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetUniformfvARB(arg0, arg1, arg2);
    }

    public static void glGetUniformARB(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glGetUniformivARB(arg0, arg1, arg2);
    }

    public static int glGetUniformLocationARB(int arg0, java.lang.CharSequence arg1) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetUniformLocationARB(arg0, arg1);
    }

    public static int glGetUniformLocationARB(int arg0, java.nio.ByteBuffer arg1) {
        return org.lwjgl.opengl.ARBShaderObjects.glGetUniformLocationARB(arg0, arg1);
    }

    public static void glLinkProgramARB(int arg0) {
        org.lwjgl.opengl.ARBShaderObjects.glLinkProgramARB(arg0);
    }

    public static void glShaderSourceARB(int arg0, java.lang.CharSequence arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glShaderSourceARB(arg0, arg1);
    }

    public static void glShaderSourceARB(int arg0, java.nio.ByteBuffer arg1) {

        org.lwjgl.opengl.ARBShaderObjects.glShaderSourceARB(arg0, me.eigenraven.lwjgl3ify.BufferCasts.bufferToCharSeq(arg1));

    }

    public static void glShaderSourceARB(int arg0, java.lang.CharSequence[] arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glShaderSourceARB(arg0, arg1);
    }

    public static void glUniform1ARB(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform1fvARB(arg0, arg1);
    }

    public static void glUniform1ARB(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform1ivARB(arg0, arg1);
    }

    public static void glUniform1fARB(int arg0, float arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform1fARB(arg0, arg1);
    }

    public static void glUniform1iARB(int arg0, int arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform1iARB(arg0, arg1);
    }

    public static void glUniform2ARB(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform2fvARB(arg0, arg1);
    }

    public static void glUniform2ARB(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform2ivARB(arg0, arg1);
    }

    public static void glUniform2fARB(int arg0, float arg1, float arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform2fARB(arg0, arg1, arg2);
    }

    public static void glUniform2iARB(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform2iARB(arg0, arg1, arg2);
    }

    public static void glUniform3ARB(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform3fvARB(arg0, arg1);
    }

    public static void glUniform3ARB(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform3ivARB(arg0, arg1);
    }

    public static void glUniform3fARB(int arg0, float arg1, float arg2, float arg3) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform3fARB(arg0, arg1, arg2, arg3);
    }

    public static void glUniform3iARB(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform3iARB(arg0, arg1, arg2, arg3);
    }

    public static void glUniform4ARB(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform4fvARB(arg0, arg1);
    }

    public static void glUniform4ARB(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform4ivARB(arg0, arg1);
    }

    public static void glUniform4fARB(int arg0, float arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform4fARB(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glUniform4iARB(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.ARBShaderObjects.glUniform4iARB(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glUniformMatrix2ARB(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix2fvARB(arg0, arg1, arg2);
    }

    public static void glUniformMatrix3ARB(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix3fvARB(arg0, arg1, arg2);
    }

    public static void glUniformMatrix4ARB(int arg0, boolean arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix4fvARB(arg0, arg1, arg2);
    }

    public static void glUseProgramObjectARB(int arg0) {
        org.lwjgl.opengl.ARBShaderObjects.glUseProgramObjectARB(arg0);
    }

    public static void glValidateProgramARB(int arg0) {
        org.lwjgl.opengl.ARBShaderObjects.glValidateProgramARB(arg0);
    }


}
