package org.lwjglx.opengl;

public class KHRDebug {
    public static void glDebugMessageControl(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, boolean arg4) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageControl(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, java.lang.CharSequence arg4) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4);
    }

    public static int glGetDebugMessageLog(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.IntBuffer arg5, java.nio.ByteBuffer arg6) {
        return org.lwjgl.opengl.KHRDebug.glGetDebugMessageLog(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static java.lang.String glGetObjectLabel(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.KHRDebug.glGetObjectLabel(arg0, arg1, arg2);
    }

    public static void glGetObjectLabel(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.KHRDebug.glGetObjectLabel(arg0, arg1, arg2, arg3);
    }

    public static void glObjectLabel(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.KHRDebug.glObjectLabel(arg0, arg1, arg2);
    }

    public static void glObjectLabel(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.KHRDebug.glObjectLabel(arg0, arg1, arg2);
    }

    public static void glPopDebugGroup() {
        org.lwjgl.opengl.KHRDebug.glPopDebugGroup();
    }

    public static void glPushDebugGroup(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.KHRDebug.glPushDebugGroup(arg0, arg1, arg2);
    }

    public static void glPushDebugGroup(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.KHRDebug.glPushDebugGroup(arg0, arg1, arg2);
    }


}
