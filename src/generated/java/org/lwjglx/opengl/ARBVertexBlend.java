package org.lwjglx.opengl;

public class ARBVertexBlend {
    public static void glVertexBlendARB(int count) {
        org.lwjgl.opengl.ARBVertexBlend.glVertexBlendARB(count);
    }

    public static void glWeightARB(java.nio.ByteBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightbvARB(pWeights);
    }

    public static void glWeightARB(java.nio.DoubleBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightdvARB(pWeights);
    }

    public static void glWeightARB(java.nio.FloatBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightfvARB(pWeights);
    }

    public static void glWeightARB(java.nio.IntBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightivARB(pWeights);
    }

    public static void glWeightARB(java.nio.ShortBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightsvARB(pWeights);
    }

    public static void glWeightPointerARB(int size, int type, int stride, long pPointer_buffer_offset) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(size, type, stride, pPointer_buffer_offset);
    }

    public static void glWeightPointerARB(int size, int stride, java.nio.DoubleBuffer pPointer) {

        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(
                size,
                org.lwjgl.opengl.GL11.GL_DOUBLE,
                stride,
                me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pPointer));
    }

    public static void glWeightPointerARB(int size, int stride, java.nio.FloatBuffer pPointer) {

        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(size, org.lwjgl.opengl.GL11.GL_FLOAT, stride, pPointer);
    }

    public static void glWeightPointerARB(int size, boolean unsigned, int stride, java.nio.ByteBuffer pPointer) {

        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE : org.lwjgl.opengl.GL11.GL_BYTE),
                stride,
                org.lwjglx.MemoryUtil.getAddress(pPointer));
    }

    public static void glWeightPointerARB(int size, boolean unsigned, int stride, java.nio.IntBuffer pPointer) {

        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_INT : org.lwjgl.opengl.GL11.GL_INT),
                stride,
                org.lwjglx.MemoryUtil.getAddress(pPointer));
    }

    public static void glWeightPointerARB(int size, boolean unsigned, int stride, java.nio.ShortBuffer pPointer) {

        org.lwjgl.opengl.ARBVertexBlend.glWeightPointerARB(
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_SHORT : org.lwjgl.opengl.GL11.GL_SHORT),
                stride,
                org.lwjglx.MemoryUtil.getAddress(pPointer));
    }

    public static void glWeightuARB(java.nio.ByteBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightubvARB(pWeights);
    }

    public static void glWeightuARB(java.nio.IntBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightuivARB(pWeights);
    }

    public static void glWeightuARB(java.nio.ShortBuffer pWeights) {
        org.lwjgl.opengl.ARBVertexBlend.glWeightusvARB(pWeights);
    }
}
