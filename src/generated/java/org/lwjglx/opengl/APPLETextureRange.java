package org.lwjglx.opengl;

public class APPLETextureRange {

    public static final int GL_STORAGE_CACHED_APPLE = (int) 34238;
    public static final int GL_STORAGE_PRIVATE_APPLE = (int) 34237;
    public static final int GL_STORAGE_SHARED_APPLE = (int) 34239;
    public static final int GL_TEXTURE_RANGE_LENGTH_APPLE = (int) 34231;
    public static final int GL_TEXTURE_RANGE_POINTER_APPLE = (int) 34232;
    public static final int GL_TEXTURE_STORAGE_HINT_APPLE = (int) 34236;

    public static java.nio.Buffer glGetTexParameterPointervAPPLE(int arg0, int arg1, long arg2) {
        return org.lwjgl.opengl.APPLETextureRange.glGetTexParameterPointervAPPLE(arg0, arg1, arg2);
    }

    public static void glTextureRangeAPPLE(int target, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.APPLETextureRange.glTextureRangeAPPLE(target, pointer);
    }

}
