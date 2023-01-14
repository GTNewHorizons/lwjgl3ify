package org.lwjglx.opengl;

public class AMDSparseTexture {
    public static void glTexStorageSparseAMD(
            int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
        org.lwjgl.opengl.AMDSparseTexture.glTexStorageSparseAMD(
                target, internalFormat, width, height, depth, layers, flags);
    }

    public static void glTextureStorageSparseAMD(
            int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
        org.lwjgl.opengl.AMDSparseTexture.glTextureStorageSparseAMD(
                texture, target, internalFormat, width, height, depth, layers, flags);
    }
}
