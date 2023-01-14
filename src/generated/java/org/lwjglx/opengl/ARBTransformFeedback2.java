package org.lwjglx.opengl;

public class ARBTransformFeedback2 {
    public static void glBindTransformFeedback(int target, int id) {
        org.lwjgl.opengl.ARBTransformFeedback2.glBindTransformFeedback(target, id);
    }

    public static void glDeleteTransformFeedbacks(int id) {
        org.lwjgl.opengl.ARBTransformFeedback2.glDeleteTransformFeedbacks(id);
    }

    public static void glDeleteTransformFeedbacks(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.ARBTransformFeedback2.glDeleteTransformFeedbacks(ids);
    }

    public static void glDrawTransformFeedback(int mode, int id) {
        org.lwjgl.opengl.ARBTransformFeedback2.glDrawTransformFeedback(mode, id);
    }

    public static int glGenTransformFeedbacks() {
        return org.lwjgl.opengl.ARBTransformFeedback2.glGenTransformFeedbacks();
    }

    public static void glGenTransformFeedbacks(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.ARBTransformFeedback2.glGenTransformFeedbacks(ids);
    }

    public static boolean glIsTransformFeedback(int id) {
        return org.lwjgl.opengl.ARBTransformFeedback2.glIsTransformFeedback(id);
    }

    public static void glPauseTransformFeedback() {
        org.lwjgl.opengl.ARBTransformFeedback2.glPauseTransformFeedback();
    }

    public static void glResumeTransformFeedback() {
        org.lwjgl.opengl.ARBTransformFeedback2.glResumeTransformFeedback();
    }
}
