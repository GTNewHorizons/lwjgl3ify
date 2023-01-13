package org.lwjglx.opengl;

public class NVVertexArrayRange {
    public static void glFlushVertexArrayRangeNV() {
        org.lwjgl.opengl.NVVertexArrayRange.glFlushVertexArrayRangeNV();
    }

    public static void glVertexArrayRangeNV(java.nio.ByteBuffer arg0) {
        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(arg0);
    }

    public static void glVertexArrayRangeNV(java.nio.DoubleBuffer arg0) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg0);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg0, wrappedArg0);

    }

    public static void glVertexArrayRangeNV(java.nio.FloatBuffer arg0) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg0);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg0, wrappedArg0);

    }

    public static void glVertexArrayRangeNV(java.nio.IntBuffer arg0) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg0);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg0, wrappedArg0);

    }

    public static void glVertexArrayRangeNV(java.nio.ShortBuffer arg0) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(arg0);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(arg0, wrappedArg0);

    }


}
