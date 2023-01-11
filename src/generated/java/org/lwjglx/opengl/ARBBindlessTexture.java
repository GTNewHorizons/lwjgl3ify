package org.lwjglx.opengl;

public class ARBBindlessTexture {
    public long glGetImageHandleARB(int arg0, int arg1, boolean arg2, int arg3, int arg4) {
        return org.lwjgl.opengl.ARBBindlessTexture.glGetImageHandleARB(arg0, arg1, arg2, arg3, arg4);
    }

    public long glGetTextureHandleARB(int arg0) {
        return org.lwjgl.opengl.ARBBindlessTexture.glGetTextureHandleARB(arg0);
    }

    public long glGetTextureSamplerHandleARB(int arg0, int arg1) {
        return org.lwjgl.opengl.ARBBindlessTexture.glGetTextureSamplerHandleARB(arg0, arg1);
    }

    public void glGetVertexAttribLuARB(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.ARBBindlessTexture.glGetVertexAttribLui64vARB(arg0, arg1, arg2);
    }

    public boolean glIsImageHandleResidentARB(long arg0) {
        return org.lwjgl.opengl.ARBBindlessTexture.glIsImageHandleResidentARB(arg0);
    }

    public boolean glIsTextureHandleResidentARB(long arg0) {
        return org.lwjgl.opengl.ARBBindlessTexture.glIsTextureHandleResidentARB(arg0);
    }

    public void glMakeImageHandleNonResidentARB(long arg0) {
        org.lwjgl.opengl.ARBBindlessTexture.glMakeImageHandleNonResidentARB(arg0);
    }

    public void glMakeImageHandleResidentARB(long arg0, int arg1) {
        org.lwjgl.opengl.ARBBindlessTexture.glMakeImageHandleResidentARB(arg0, arg1);
    }

    public void glMakeTextureHandleNonResidentARB(long arg0) {
        org.lwjgl.opengl.ARBBindlessTexture.glMakeTextureHandleNonResidentARB(arg0);
    }

    public void glMakeTextureHandleResidentARB(long arg0) {
        org.lwjgl.opengl.ARBBindlessTexture.glMakeTextureHandleResidentARB(arg0);
    }

    public void glProgramUniformHandleuARB(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.ARBBindlessTexture.glProgramUniformHandleui64vARB(arg0, arg1, arg2);
    }

    public void glProgramUniformHandleui64ARB(int arg0, int arg1, long arg2) {
        org.lwjgl.opengl.ARBBindlessTexture.glProgramUniformHandleui64ARB(arg0, arg1, arg2);
    }

    public void glUniformHandleuARB(int arg0, java.nio.LongBuffer arg1) {
        org.lwjgl.opengl.ARBBindlessTexture.glUniformHandleui64vARB(arg0, arg1);
    }

    public void glUniformHandleui64ARB(int arg0, long arg1) {
        org.lwjgl.opengl.ARBBindlessTexture.glUniformHandleui64ARB(arg0, arg1);
    }

    public void glVertexAttribL1uARB(int arg0, java.nio.LongBuffer arg1) {
        org.lwjgl.opengl.ARBBindlessTexture.glVertexAttribL1ui64vARB(arg0, arg1);
    }

    public void glVertexAttribL1ui64ARB(int arg0, long arg1) {
        org.lwjgl.opengl.ARBBindlessTexture.glVertexAttribL1ui64ARB(arg0, arg1);
    }


}
