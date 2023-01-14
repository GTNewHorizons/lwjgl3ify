package org.lwjglx.opengl;

public class ARBCopyBuffer {
    public static void glCopyBufferSubData(
            int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
        org.lwjgl.opengl.ARBCopyBuffer.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
    }
}
