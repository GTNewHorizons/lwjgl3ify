package org.lwjglx.opengl;

public class ARBTextureBufferObject {
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 35883;
    public static final int GL_TEXTURE_BINDING_BUFFER_ARB = 35884;
    public static final int GL_TEXTURE_BUFFER_ARB = 35882;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 35885;
    public static final int GL_TEXTURE_BUFFER_FORMAT_ARB = 35886;

    public static void glTexBufferARB(int target, int internalformat, int buffer) {
        org.lwjgl.opengl.ARBTextureBufferObject.glTexBufferARB(target, internalformat, buffer);
    }
}
