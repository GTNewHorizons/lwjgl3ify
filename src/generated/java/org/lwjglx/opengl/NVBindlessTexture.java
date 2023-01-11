package org.lwjglx.opengl;

public class NVBindlessTexture {
    public long glGetImageHandleNV(int arg0, int arg1, boolean arg2, int arg3, int arg4) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetImageHandleNV(arg0, arg1, arg2, arg3, arg4);
    }

    public long glGetTextureHandleNV(int arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetTextureHandleNV(arg0);
    }

    public long glGetTextureSamplerHandleNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVBindlessTexture.glGetTextureSamplerHandleNV(arg0, arg1);
    }

    public boolean glIsImageHandleResidentNV(long arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glIsImageHandleResidentNV(arg0);
    }

    public boolean glIsTextureHandleResidentNV(long arg0) {
        return org.lwjgl.opengl.NVBindlessTexture.glIsTextureHandleResidentNV(arg0);
    }

    public void glMakeImageHandleNonResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeImageHandleNonResidentNV(arg0);
    }

    public void glMakeImageHandleResidentNV(long arg0, int arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeImageHandleResidentNV(arg0, arg1);
    }

    public void glMakeTextureHandleNonResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeTextureHandleNonResidentNV(arg0);
    }

    public void glMakeTextureHandleResidentNV(long arg0) {
        org.lwjgl.opengl.NVBindlessTexture.glMakeTextureHandleResidentNV(arg0);
    }

    public void glProgramUniformHandleuNV(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.NVBindlessTexture.glProgramUniformHandleui64vNV(arg0, arg1, arg2);
    }

    public void glProgramUniformHandleui64NV(int arg0, int arg1, long arg2) {
        org.lwjgl.opengl.NVBindlessTexture.glProgramUniformHandleui64NV(arg0, arg1, arg2);
    }

    public void glUniformHandleuNV(int arg0, java.nio.LongBuffer arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glUniformHandleui64vNV(arg0, arg1);
    }

    public void glUniformHandleui64NV(int arg0, long arg1) {
        org.lwjgl.opengl.NVBindlessTexture.glUniformHandleui64NV(arg0, arg1);
    }


}
