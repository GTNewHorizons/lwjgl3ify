package org.lwjglx.opengl;

public class APPLEElementArray {

    public static final int GL_ELEMENT_ARRAY_APPLE = (int) 34664;
    public static final int GL_ELEMENT_ARRAY_POINTER_APPLE = (int) 34666;
    public static final int GL_ELEMENT_ARRAY_TYPE_APPLE = (int) 34665;

    public static void glDrawElementArrayAPPLE(int mode, int first, int count) {
        org.lwjgl.opengl.APPLEElementArray.glDrawElementArrayAPPLE(mode, first, count);
    }

    public static void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
        org.lwjgl.opengl.APPLEElementArray.glDrawRangeElementArrayAPPLE(mode, start, end, first, count);
    }

    public static void glElementPointerAPPLE(java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.APPLEElementArray.glElementPointerAPPLE(pointer);
    }

    public static void glElementPointerAPPLE(java.nio.IntBuffer pointer) {
        org.lwjgl.opengl.APPLEElementArray.glElementPointerAPPLE(pointer);
    }

    public static void glElementPointerAPPLE(java.nio.ShortBuffer pointer) {
        org.lwjgl.opengl.APPLEElementArray.glElementPointerAPPLE(pointer);
    }

    public static void glMultiDrawElementArrayAPPLE(int mode, java.nio.IntBuffer first, java.nio.IntBuffer count) {
        org.lwjgl.opengl.APPLEElementArray.glMultiDrawElementArrayAPPLE(mode, first, count);
    }

    public static void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, java.nio.IntBuffer first,
        java.nio.IntBuffer count) {
        org.lwjgl.opengl.APPLEElementArray.glMultiDrawRangeElementArrayAPPLE(mode, start, end, first, count);
    }

}
