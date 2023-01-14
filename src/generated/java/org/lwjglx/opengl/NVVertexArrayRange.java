package org.lwjglx.opengl;

public class NVVertexArrayRange {
    public static void glFlushVertexArrayRangeNV() {
        org.lwjgl.opengl.NVVertexArrayRange.glFlushVertexArrayRangeNV();
    }

    public static void glVertexArrayRangeNV(java.nio.ByteBuffer pPointer) {
        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(pPointer);
    }

    public static void glVertexArrayRangeNV(java.nio.DoubleBuffer pPointer) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pPointer);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(pPointer, wrappedArg0);
    }

    public static void glVertexArrayRangeNV(java.nio.FloatBuffer pPointer) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pPointer);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(pPointer, wrappedArg0);
    }

    public static void glVertexArrayRangeNV(java.nio.IntBuffer pPointer) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pPointer);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(pPointer, wrappedArg0);
    }

    public static void glVertexArrayRangeNV(java.nio.ShortBuffer pPointer) {
        final java.nio.ByteBuffer wrappedArg0 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pPointer);

        org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(wrappedArg0);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(pPointer, wrappedArg0);
    }
}
