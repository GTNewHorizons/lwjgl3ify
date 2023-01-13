package org.lwjglx.openal;

public class AL11 {
    public static void alBuffer3f(int arg0, int arg1, float arg2, float arg3, float arg4) {
        org.lwjgl.openal.AL11.alBuffer3f(arg0, arg1, arg2, arg3, arg4);
    }

    public static void alBuffer3i(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.openal.AL11.alBuffer3i(arg0, arg1, arg2, arg3, arg4);
    }

    public static void alBuffer(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.openal.AL11.alBufferfv(arg0, arg1, arg2);
    }

    public static void alBuffer(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.openal.AL11.alBufferiv(arg0, arg1, arg2);
    }

    public static void alBufferf(int arg0, int arg1, float arg2) {
        org.lwjgl.openal.AL11.alBufferf(arg0, arg1, arg2);
    }

    public static void alBufferi(int arg0, int arg1, int arg2) {
        org.lwjgl.openal.AL11.alBufferi(arg0, arg1, arg2);
    }

    public static void alGetBuffer(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.openal.AL11.alGetBufferfv(arg0, arg1, arg2);
    }

    public static void alGetBuffer(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.openal.AL11.alGetBufferiv(arg0, arg1, arg2);
    }

    public static float alGetBufferf(int arg0, int arg1) {
        return org.lwjgl.openal.AL11.alGetBufferf(arg0, arg1);
    }

    public static int alGetBufferi(int arg0, int arg1) {
        return org.lwjgl.openal.AL11.alGetBufferi(arg0, arg1);
    }

    public static void alGetListeneri(int arg0, java.nio.FloatBuffer arg1) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg1);

        org.lwjgl.openal.AL11.alGetListeneriv(arg0, wrappedArg1.asIntBuffer());
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg1, wrappedArg1);

    }

    public static void alListener3i(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.openal.AL11.alListener3i(arg0, arg1, arg2, arg3);
    }

    public static void alSource3i(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.openal.AL11.alSource3i(arg0, arg1, arg2, arg3, arg4);
    }

    public static void alSource(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.openal.AL11.alSourceiv(arg0, arg1, arg2);
    }

    public static void alSpeedOfSound(float arg0) {
        org.lwjgl.openal.AL11.alSpeedOfSound(arg0);
    }


}
