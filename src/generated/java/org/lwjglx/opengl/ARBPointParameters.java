package org.lwjglx.opengl;

public class ARBPointParameters {
    public static void glPointParameterARB(int pname, java.nio.FloatBuffer pfParams) {
        org.lwjgl.opengl.ARBPointParameters.glPointParameterfvARB(pname, pfParams);
    }

    public static void glPointParameterfARB(int pname, float param) {
        org.lwjgl.opengl.ARBPointParameters.glPointParameterfARB(pname, param);
    }
}
