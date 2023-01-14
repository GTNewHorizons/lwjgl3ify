package org.lwjglx.opengl;

public class ARBDrawIndirect {
    public static void glDrawArraysIndirect(int mode, long indirect_buffer_offset) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawArraysIndirect(mode, indirect_buffer_offset);
    }

    public static void glDrawArraysIndirect(int mode, java.nio.ByteBuffer indirect) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(int mode, java.nio.IntBuffer indirect) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawArraysIndirect(mode, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, long indirect_buffer_offset) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawElementsIndirect(mode, type, indirect_buffer_offset);
    }

    public static void glDrawElementsIndirect(int mode, int type, java.nio.ByteBuffer indirect) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, java.nio.IntBuffer indirect) {
        org.lwjgl.opengl.ARBDrawIndirect.glDrawElementsIndirect(mode, type, indirect);
    }
}
