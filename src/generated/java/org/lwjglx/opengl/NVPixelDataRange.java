package org.lwjglx.opengl;

public class NVPixelDataRange {
    public static void glFlushPixelDataRangeNV(int arg0) {
        org.lwjgl.opengl.NVPixelDataRange.glFlushPixelDataRangeNV(arg0);
    }

    public static void glPixelDataRangeNV(int arg0, java.nio.ByteBuffer arg1) {
        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(arg0, arg1);
    }

    public static void glPixelDataRangeNV(int arg0, java.nio.DoubleBuffer arg1) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg1);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(arg0, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg1, wrappedArg1);

    }

    public static void glPixelDataRangeNV(int arg0, java.nio.FloatBuffer arg1) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg1);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(arg0, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg1, wrappedArg1);

    }

    public static void glPixelDataRangeNV(int arg0, java.nio.IntBuffer arg1) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg1);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(arg0, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg1, wrappedArg1);

    }

    public static void glPixelDataRangeNV(int arg0, java.nio.ShortBuffer arg1) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg1);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(arg0, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg1, wrappedArg1);

    }


}
