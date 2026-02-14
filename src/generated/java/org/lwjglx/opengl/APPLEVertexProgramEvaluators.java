package org.lwjglx.opengl;

public class APPLEVertexProgramEvaluators {

    public static final int GL_VERTEX_ATTRIB_MAP1_APPLE = (int) 35328;
    public static final int GL_VERTEX_ATTRIB_MAP1_COEFF_APPLE = (int) 35331;
    public static final int GL_VERTEX_ATTRIB_MAP1_DOMAIN_APPLE = (int) 35333;
    public static final int GL_VERTEX_ATTRIB_MAP1_ORDER_APPLE = (int) 35332;
    public static final int GL_VERTEX_ATTRIB_MAP1_SIZE_APPLE = (int) 35330;
    public static final int GL_VERTEX_ATTRIB_MAP2_APPLE = (int) 35329;
    public static final int GL_VERTEX_ATTRIB_MAP2_COEFF_APPLE = (int) 35335;
    public static final int GL_VERTEX_ATTRIB_MAP2_DOMAIN_APPLE = (int) 35337;
    public static final int GL_VERTEX_ATTRIB_MAP2_ORDER_APPLE = (int) 35336;
    public static final int GL_VERTEX_ATTRIB_MAP2_SIZE_APPLE = (int) 35334;

    public static void glDisableVertexAttribAPPLE(int index, int pname) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators.glDisableVertexAttribAPPLE(index, pname);
    }

    public static void glEnableVertexAttribAPPLE(int index, int pname) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators.glEnableVertexAttribAPPLE(index, pname);
    }

    public static boolean glIsVertexAttribEnabledAPPLE(int index, int pname) {
        return org.lwjgl.opengl.APPLEVertexProgramEvaluators.glIsVertexAttribEnabledAPPLE(index, pname);
    }

    public static void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order,
        java.nio.DoubleBuffer points) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators
            .glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points);
    }

    public static void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order,
        java.nio.FloatBuffer points) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators
            .glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points);
    }

    public static void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder,
        double v1, double v2, int vstride, int vorder, java.nio.DoubleBuffer points) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators
            .glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
    }

    public static void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder,
        float v1, float v2, int vstride, int vorder, java.nio.FloatBuffer points) {
        org.lwjgl.opengl.APPLEVertexProgramEvaluators
            .glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
    }

}
