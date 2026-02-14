package org.lwjglx.opengl;

public class APPLEVertexArrayObject {

    public static final int GL_VERTEX_ARRAY_BINDING_APPLE = (int) 34229;

    public static void glBindVertexArrayAPPLE(int array) {
        org.lwjgl.opengl.APPLEVertexArrayObject.glBindVertexArrayAPPLE(array);
    }

    public static void glDeleteVertexArraysAPPLE(int array) {
        org.lwjgl.opengl.APPLEVertexArrayObject.glDeleteVertexArraysAPPLE(array);
    }

    public static void glDeleteVertexArraysAPPLE(java.nio.IntBuffer arrays) {
        org.lwjgl.opengl.APPLEVertexArrayObject.glDeleteVertexArraysAPPLE(arrays);
    }

    public static int glGenVertexArraysAPPLE() {
        return org.lwjgl.opengl.APPLEVertexArrayObject.glGenVertexArraysAPPLE();
    }

    public static void glGenVertexArraysAPPLE(java.nio.IntBuffer arrays) {
        org.lwjgl.opengl.APPLEVertexArrayObject.glGenVertexArraysAPPLE(arrays);
    }

    public static boolean glIsVertexArrayAPPLE(int array) {
        return org.lwjgl.opengl.APPLEVertexArrayObject.glIsVertexArrayAPPLE(array);
    }

}
