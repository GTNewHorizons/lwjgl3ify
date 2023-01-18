package org.lwjglx.opengl;

public class ARBVertexBlend {
    public static final int GL_ACTIVE_VERTEX_UNITS_ARB = 34469;
    public static final int GL_CURRENT_WEIGHT_ARB = 34472;
    public static final int GL_MAX_VERTEX_UNITS_ARB = 34468;
    public static final int GL_MODELVIEW0_ARB = 5888;
    public static final int GL_MODELVIEW10_ARB = 34602;
    public static final int GL_MODELVIEW11_ARB = 34603;
    public static final int GL_MODELVIEW12_ARB = 34604;
    public static final int GL_MODELVIEW13_ARB = 34605;
    public static final int GL_MODELVIEW14_ARB = 34606;
    public static final int GL_MODELVIEW15_ARB = 34607;
    public static final int GL_MODELVIEW16_ARB = 34608;
    public static final int GL_MODELVIEW17_ARB = 34609;
    public static final int GL_MODELVIEW18_ARB = 34610;
    public static final int GL_MODELVIEW19_ARB = 34611;
    public static final int GL_MODELVIEW1_ARB = 34058;
    public static final int GL_MODELVIEW20_ARB = 34612;
    public static final int GL_MODELVIEW21_ARB = 34613;
    public static final int GL_MODELVIEW22_ARB = 34614;
    public static final int GL_MODELVIEW23_ARB = 34615;
    public static final int GL_MODELVIEW24_ARB = 34616;
    public static final int GL_MODELVIEW25_ARB = 34617;
    public static final int GL_MODELVIEW26_ARB = 34618;
    public static final int GL_MODELVIEW27_ARB = 34619;
    public static final int GL_MODELVIEW28_ARB = 34620;
    public static final int GL_MODELVIEW29_ARB = 34621;
    public static final int GL_MODELVIEW2_ARB = 34594;
    public static final int GL_MODELVIEW30_ARB = 34622;
    public static final int GL_MODELVIEW31_ARB = 34623;
    public static final int GL_MODELVIEW3_ARB = 34595;
    public static final int GL_MODELVIEW4_ARB = 34596;
    public static final int GL_MODELVIEW5_ARB = 34597;
    public static final int GL_MODELVIEW6_ARB = 34598;
    public static final int GL_MODELVIEW7_ARB = 34599;
    public static final int GL_MODELVIEW8_ARB = 34600;
    public static final int GL_MODELVIEW9_ARB = 34601;
    public static final int GL_VERTEX_BLEND_ARB = 34471;
    public static final int GL_WEIGHT_ARRAY_ARB = 34477;
    public static final int GL_WEIGHT_ARRAY_POINTER_ARB = 34476;
    public static final int GL_WEIGHT_ARRAY_SIZE_ARB = 34475;
    public static final int GL_WEIGHT_ARRAY_STRIDE_ARB = 34474;
    public static final int GL_WEIGHT_ARRAY_TYPE_ARB = 34473;
    public static final int GL_WEIGHT_SUM_UNITY_ARB = 34470;

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
