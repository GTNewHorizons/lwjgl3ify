package org.lwjglx.opengl;

public class NVPixelDataRange {
    public static void glFlushPixelDataRangeNV(int target) {
        org.lwjgl.opengl.NVPixelDataRange.glFlushPixelDataRangeNV(target);
    }

    public static void glPixelDataRangeNV(int target, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, data);
    }

    public static void glPixelDataRangeNV(int target, java.nio.DoubleBuffer data) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg1);
    }

    public static void glPixelDataRangeNV(int target, java.nio.FloatBuffer data) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg1);
    }

    public static void glPixelDataRangeNV(int target, java.nio.IntBuffer data) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg1);
    }

    public static void glPixelDataRangeNV(int target, java.nio.ShortBuffer data) {
        final java.nio.ByteBuffer wrappedArg1 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(data);

        org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, wrappedArg1);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(data, wrappedArg1);
    }
}
