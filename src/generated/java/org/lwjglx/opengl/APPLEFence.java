package org.lwjglx.opengl;

public class APPLEFence {

    public static final int GL_DRAW_PIXELS_APPLE = (int) 35338;
    public static final int GL_FENCE_APPLE = (int) 35339;

    public static void glDeleteFencesAPPLE(int fence) {
        org.lwjgl.opengl.APPLEFence.glDeleteFencesAPPLE(fence);
    }

    public static void glDeleteFencesAPPLE(java.nio.IntBuffer fences) {
        org.lwjgl.opengl.APPLEFence.glDeleteFencesAPPLE(fences);
    }

    public static void glFinishFenceAPPLE(int fence) {
        org.lwjgl.opengl.APPLEFence.glFinishFenceAPPLE(fence);
    }

    public static void glFinishObjectAPPLE(int object, int name) {
        org.lwjgl.opengl.APPLEFence.glFinishObjectAPPLE(object, name);
    }

    public static int glGenFencesAPPLE() {
        return org.lwjgl.opengl.APPLEFence.glGenFencesAPPLE();
    }

    public static void glGenFencesAPPLE(java.nio.IntBuffer fences) {
        org.lwjgl.opengl.APPLEFence.glGenFencesAPPLE(fences);
    }

    public static boolean glIsFenceAPPLE(int fence) {
        return org.lwjgl.opengl.APPLEFence.glIsFenceAPPLE(fence);
    }

    public static void glSetFenceAPPLE(int fence) {
        org.lwjgl.opengl.APPLEFence.glSetFenceAPPLE(fence);
    }

    public static boolean glTestFenceAPPLE(int fence) {
        return org.lwjgl.opengl.APPLEFence.glTestFenceAPPLE(fence);
    }

    public static boolean glTestObjectAPPLE(int object, int name) {
        return org.lwjgl.opengl.APPLEFence.glTestObjectAPPLE(object, name);
    }

}
