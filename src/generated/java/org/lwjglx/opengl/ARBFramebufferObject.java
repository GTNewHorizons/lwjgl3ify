package org.lwjglx.opengl;

public class ARBFramebufferObject {
    public static void glBindFramebuffer(int target, int framebuffer) {
        org.lwjgl.opengl.ARBFramebufferObject.glBindFramebuffer(target, framebuffer);
    }

    public static void glBindRenderbuffer(int target, int renderbuffer) {
        org.lwjgl.opengl.ARBFramebufferObject.glBindRenderbuffer(target, renderbuffer);
    }

    public static void glBlitFramebuffer(
            int srcX0,
            int srcY0,
            int srcX1,
            int srcY1,
            int dstX0,
            int dstY0,
            int dstX1,
            int dstY1,
            int mask,
            int filter) {
        org.lwjgl.opengl.ARBFramebufferObject.glBlitFramebuffer(
                srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    public static int glCheckFramebufferStatus(int target) {
        return org.lwjgl.opengl.ARBFramebufferObject.glCheckFramebufferStatus(target);
    }

    public static void glDeleteFramebuffers(int framebuffer) {
        org.lwjgl.opengl.ARBFramebufferObject.glDeleteFramebuffers(framebuffer);
    }

    public static void glDeleteFramebuffers(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.ARBFramebufferObject.glDeleteFramebuffers(framebuffers);
    }

    public static void glDeleteRenderbuffers(int renderbuffer) {
        org.lwjgl.opengl.ARBFramebufferObject.glDeleteRenderbuffers(renderbuffer);
    }

    public static void glDeleteRenderbuffers(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.ARBFramebufferObject.glDeleteRenderbuffers(renderbuffers);
    }

    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        org.lwjgl.opengl.ARBFramebufferObject.glFramebufferRenderbuffer(
                target, attachment, renderbuffertarget, renderbuffer);
    }

    public static void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.ARBFramebufferObject.glFramebufferTexture1D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.ARBFramebufferObject.glFramebufferTexture2D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture3D(
            int target, int attachment, int textarget, int texture, int level, int layer) {
        org.lwjgl.opengl.ARBFramebufferObject.glFramebufferTexture3D(
                target, attachment, textarget, texture, level, layer);
    }

    public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
        org.lwjgl.opengl.ARBFramebufferObject.glFramebufferTextureLayer(target, attachment, texture, level, layer);
    }

    public static int glGenFramebuffers() {
        return org.lwjgl.opengl.ARBFramebufferObject.glGenFramebuffers();
    }

    public static void glGenFramebuffers(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.ARBFramebufferObject.glGenFramebuffers(framebuffers);
    }

    public static int glGenRenderbuffers() {
        return org.lwjgl.opengl.ARBFramebufferObject.glGenRenderbuffers();
    }

    public static void glGenRenderbuffers(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.ARBFramebufferObject.glGenRenderbuffers(renderbuffers);
    }

    public static void glGenerateMipmap(int target) {
        org.lwjgl.opengl.ARBFramebufferObject.glGenerateMipmap(target);
    }

    public static int glGetFramebufferAttachmentParameteri(int target, int attachment, int pname) {
        return org.lwjgl.opengl.ARBFramebufferObject.glGetFramebufferAttachmentParameteri(target, attachment, pname);
    }

    public static int glGetRenderbufferParameteri(int target, int pname) {
        return org.lwjgl.opengl.ARBFramebufferObject.glGetRenderbufferParameteri(target, pname);
    }

    public static boolean glIsFramebuffer(int framebuffer) {
        return org.lwjgl.opengl.ARBFramebufferObject.glIsFramebuffer(framebuffer);
    }

    public static boolean glIsRenderbuffer(int renderbuffer) {
        return org.lwjgl.opengl.ARBFramebufferObject.glIsRenderbuffer(renderbuffer);
    }

    public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
        org.lwjgl.opengl.ARBFramebufferObject.glRenderbufferStorage(target, internalformat, width, height);
    }

    public static void glRenderbufferStorageMultisample(
            int target, int samples, int internalformat, int width, int height) {
        org.lwjgl.opengl.ARBFramebufferObject.glRenderbufferStorageMultisample(
                target, samples, internalformat, width, height);
    }
}
