package org.lwjglx.opengl;

public class ARBTextureMultisample {
    public static void glSampleMaski(int index, int mask) {
        org.lwjgl.opengl.ARBTextureMultisample.glSampleMaski(index, mask);
    }

    public static void glTexImage2DMultisample(
            int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        org.lwjgl.opengl.ARBTextureMultisample.glTexImage2DMultisample(
                target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexImage3DMultisample(
            int target,
            int samples,
            int internalformat,
            int width,
            int height,
            int depth,
            boolean fixedsamplelocations) {
        org.lwjgl.opengl.ARBTextureMultisample.glTexImage3DMultisample(
                target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }
}
