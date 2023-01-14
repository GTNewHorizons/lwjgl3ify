package org.lwjglx.opengl;

public class ARBTextureBufferRange {
    public static void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
        org.lwjgl.opengl.ARBTextureBufferRange.glTexBufferRange(target, internalformat, buffer, offset, size);
    }

    public static void glTextureBufferRangeEXT(
            int texture, int target, int internalformat, int buffer, long offset, long size) {
        org.lwjgl.opengl.ARBTextureBufferRange.glTextureBufferRangeEXT(
                texture, target, internalformat, buffer, offset, size);
    }
}
