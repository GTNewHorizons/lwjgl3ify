package org.lwjglx.opengl;

public class EXTPointParameters {
    public static void glPointParameterEXT(int pname, java.nio.FloatBuffer pfParams) {
        org.lwjgl.opengl.EXTPointParameters.glPointParameterfvEXT(pname, pfParams);
    }

    public static void glPointParameterfEXT(int pname, float param) {
        org.lwjgl.opengl.EXTPointParameters.glPointParameterfEXT(pname, param);
    }
}
