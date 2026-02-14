package org.lwjglx.opengl;

public class APPLEFlushBufferRange {

    public static final int GL_BUFFER_FLUSHING_UNMAP_APPLE = (int) 35347;
    public static final int GL_BUFFER_SERIALIZED_MODIFY_APPLE = (int) 35346;

    public static void glBufferParameteriAPPLE(int target, int pname, int param) {
        org.lwjgl.opengl.APPLEFlushBufferRange.glBufferParameteriAPPLE(target, pname, param);
    }

    public static void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
        org.lwjgl.opengl.APPLEFlushBufferRange.glFlushMappedBufferRangeAPPLE(target, offset, size);
    }

}
