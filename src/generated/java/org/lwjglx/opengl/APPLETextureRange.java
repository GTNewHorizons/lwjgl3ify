package org.lwjglx.opengl;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.lwjglx.BufferUtils;

public class APPLETextureRange {

    public static final int GL_STORAGE_CACHED_APPLE = (int) 34238;
    public static final int GL_STORAGE_PRIVATE_APPLE = (int) 34237;
    public static final int GL_STORAGE_SHARED_APPLE = (int) 34239;
    public static final int GL_TEXTURE_RANGE_LENGTH_APPLE = (int) 34231;
    public static final int GL_TEXTURE_RANGE_POINTER_APPLE = (int) 34232;
    public static final int GL_TEXTURE_STORAGE_HINT_APPLE = (int) 34236;

    public static java.nio.Buffer glGetTexParameterPointervAPPLE(int arg0, int arg1, long resultSize) {
        ByteBuffer output = BufferUtils
            .createByteBuffer(Math.toIntExact(resultSize * org.lwjgl.system.Pointer.POINTER_SIZE));
        org.lwjgl.opengl.APPLETextureRange.nglGetTexParameterPointervAPPLE(arg0, arg1, MemoryUtil.memAddress(output));
        return output;
    }

    public static void glTextureRangeAPPLE(int target, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.APPLETextureRange.glTextureRangeAPPLE(target, pointer);
    }

}
