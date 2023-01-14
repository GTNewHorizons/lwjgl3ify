package org.lwjglx.opengl;

public class ARBDrawBuffers {
    public static void glDrawBuffersARB(int buffer) {

        org.lwjgl.opengl.ARBDrawBuffers.glDrawBuffersARB(new int[] {buffer});
    }

    public static void glDrawBuffersARB(java.nio.IntBuffer buffers) {
        org.lwjgl.opengl.ARBDrawBuffers.glDrawBuffersARB(buffers);
    }
}
