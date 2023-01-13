package org.lwjglx.opengl;

public class GL44 {
    public static void glBufferStorage(int arg0, long arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glBufferStorage(int arg0, java.nio.ByteBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glBufferStorage(int arg0, java.nio.DoubleBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glBufferStorage(int arg0, java.nio.FloatBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glBufferStorage(int arg0, java.nio.IntBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glBufferStorage(int arg0, java.nio.LongBuffer arg1, int arg2) {

        org.lwjgl.opengl.GL44.glBufferStorage(arg0, org.lwjglx.MemoryUtil.getAddress(arg1), arg2);

    }

    public static void glBufferStorage(int arg0, java.nio.ShortBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL44.glBufferStorage(arg0, arg1, arg2);
    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.DoubleBuffer arg4) {
        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.FloatBuffer arg4) {
        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.IntBuffer arg4) {
        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.LongBuffer arg4) {
        final java.nio.ByteBuffer wrappedArg4 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg4);

        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, wrappedArg4);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg4, wrappedArg4);

    }

    public static void glClearTexImage(int arg0, int arg1, int arg2, int arg3, java.nio.ShortBuffer arg4) {
        org.lwjgl.opengl.GL44.glClearTexImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ByteBuffer arg10) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.DoubleBuffer arg10) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.FloatBuffer arg10) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.IntBuffer arg10) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.LongBuffer arg10) {
        final java.nio.ByteBuffer wrappedArg10 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg10);

        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, wrappedArg10);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg10, wrappedArg10);

    }

    public static void glClearTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ShortBuffer arg10) {
        org.lwjgl.opengl.GL44.glClearTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }


}
