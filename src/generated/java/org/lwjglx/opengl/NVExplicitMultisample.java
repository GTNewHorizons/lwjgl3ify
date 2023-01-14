package org.lwjglx.opengl;

public class NVExplicitMultisample {
    public static void glGetMultisampleNV(int pname, int index, java.nio.FloatBuffer val) {
        org.lwjgl.opengl.NVExplicitMultisample.glGetMultisamplefvNV(pname, index, val);
    }

    public static void glSampleMaskIndexedNV(int index, int mask) {
        org.lwjgl.opengl.NVExplicitMultisample.glSampleMaskIndexedNV(index, mask);
    }

    public static void glTexRenderbufferNV(int target, int renderbuffer) {
        org.lwjgl.opengl.NVExplicitMultisample.glTexRenderbufferNV(target, renderbuffer);
    }
}
