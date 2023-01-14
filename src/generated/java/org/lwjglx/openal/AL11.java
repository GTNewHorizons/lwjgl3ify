package org.lwjglx.openal;

public class AL11 {
    public static void alBuffer3f(int buffer, int pname, float v1, float v2, float v3) {
        org.lwjgl.openal.AL11.alBuffer3f(buffer, pname, v1, v2, v3);
    }

    public static void alBuffer3i(int buffer, int pname, int v1, int v2, int v3) {
        org.lwjgl.openal.AL11.alBuffer3i(buffer, pname, v1, v2, v3);
    }

    public static void alBuffer(int buffer, int pname, java.nio.FloatBuffer value) {
        org.lwjgl.openal.AL11.alBufferfv(buffer, pname, value);
    }

    public static void alBuffer(int buffer, int pname, java.nio.IntBuffer value) {
        org.lwjgl.openal.AL11.alBufferiv(buffer, pname, value);
    }

    public static void alBufferf(int buffer, int pname, float value) {
        org.lwjgl.openal.AL11.alBufferf(buffer, pname, value);
    }

    public static void alBufferi(int buffer, int pname, int value) {
        org.lwjgl.openal.AL11.alBufferi(buffer, pname, value);
    }

    public static void alGetBuffer(int buffer, int pname, java.nio.FloatBuffer values) {
        org.lwjgl.openal.AL11.alGetBufferfv(buffer, pname, values);
    }

    public static void alGetBuffer(int buffer, int pname, java.nio.IntBuffer values) {
        org.lwjgl.openal.AL11.alGetBufferiv(buffer, pname, values);
    }

    public static float alGetBufferf(int buffer, int pname) {
        return org.lwjgl.openal.AL11.alGetBufferf(buffer, pname);
    }

    public static int alGetBufferi(int buffer, int pname) {
        return org.lwjgl.openal.AL11.alGetBufferi(buffer, pname);
    }

    public static void alGetListeneri(int pname, java.nio.FloatBuffer intdata) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(intdata);

        org.lwjgl.openal.AL11.alGetListeneriv(pname, wrappedArg1.asIntBuffer());
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(intdata, wrappedArg1);
    }

    public static void alListener3i(int pname, int v1, int v2, int v3) {
        org.lwjgl.openal.AL11.alListener3i(pname, v1, v2, v3);
    }

    public static void alSource3i(int source, int pname, int v1, int v2, int v3) {
        org.lwjgl.openal.AL11.alSource3i(source, pname, v1, v2, v3);
    }

    public static void alSource(int source, int pname, java.nio.IntBuffer value) {
        org.lwjgl.openal.AL11.alSourceiv(source, pname, value);
    }

    public static void alSpeedOfSound(float value) {
        org.lwjgl.openal.AL11.alSpeedOfSound(value);
    }
}
