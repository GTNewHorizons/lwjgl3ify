package org.lwjglx.opengl;

public class ARBMapBufferRange {
    public static void glFlushMappedBufferRange(int target, long offset, long length) {
        org.lwjgl.opengl.ARBMapBufferRange.glFlushMappedBufferRange(target, offset, length);
    }

    public static java.nio.ByteBuffer glMapBufferRange(
            int target, long offset, long length, int access, java.nio.ByteBuffer old_buffer) {
        return org.lwjgl.opengl.ARBMapBufferRange.glMapBufferRange(target, offset, length, access, old_buffer);
    }
}
