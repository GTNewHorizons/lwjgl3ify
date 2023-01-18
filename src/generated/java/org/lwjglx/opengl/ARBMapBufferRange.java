package org.lwjglx.opengl;

public class ARBMapBufferRange {
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 16;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 8;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 4;
    public static final int GL_MAP_READ_BIT = 1;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 32;
    public static final int GL_MAP_WRITE_BIT = 2;

    public static void glFlushMappedBufferRange(int target, long offset, long length) {
        org.lwjgl.opengl.ARBMapBufferRange.glFlushMappedBufferRange(target, offset, length);
    }

    public static java.nio.ByteBuffer glMapBufferRange(
            int target, long offset, long length, int access, java.nio.ByteBuffer old_buffer) {
        return org.lwjgl.opengl.ARBMapBufferRange.glMapBufferRange(target, offset, length, access, old_buffer);
    }
}
