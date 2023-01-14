package org.lwjglx.opengl;

public class EXTFramebufferObject {
    public static void glBindFramebufferEXT(int target, int framebuffer) {
        org.lwjgl.opengl.EXTFramebufferObject.glBindFramebufferEXT(target, framebuffer);
    }

    public static void glBindRenderbufferEXT(int target, int renderbuffer) {
        org.lwjgl.opengl.EXTFramebufferObject.glBindRenderbufferEXT(target, renderbuffer);
    }

    public static int glCheckFramebufferStatusEXT(int target) {
        return org.lwjgl.opengl.EXTFramebufferObject.glCheckFramebufferStatusEXT(target);
    }

    public static void glDeleteFramebuffersEXT(int framebuffer) {
        org.lwjgl.opengl.EXTFramebufferObject.glDeleteFramebuffersEXT(framebuffer);
    }

    public static void glDeleteFramebuffersEXT(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.EXTFramebufferObject.glDeleteFramebuffersEXT(framebuffers);
    }

    public static void glDeleteRenderbuffersEXT(int renderbuffer) {
        org.lwjgl.opengl.EXTFramebufferObject.glDeleteRenderbuffersEXT(renderbuffer);
    }

    public static void glDeleteRenderbuffersEXT(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.EXTFramebufferObject.glDeleteRenderbuffersEXT(renderbuffers);
    }

    public static void glFramebufferRenderbufferEXT(
            int target, int attachment, int renderbuffertarget, int renderbuffer) {
        org.lwjgl.opengl.EXTFramebufferObject.glFramebufferRenderbufferEXT(
                target, attachment, renderbuffertarget, renderbuffer);
    }

    public static void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.EXTFramebufferObject.glFramebufferTexture1DEXT(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.EXTFramebufferObject.glFramebufferTexture2DEXT(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture3DEXT(
            int target, int attachment, int textarget, int texture, int level, int zoffset) {
        org.lwjgl.opengl.EXTFramebufferObject.glFramebufferTexture3DEXT(
                target, attachment, textarget, texture, level, zoffset);
    }

    public static int glGenFramebuffersEXT() {
        return org.lwjgl.opengl.EXTFramebufferObject.glGenFramebuffersEXT();
    }

    public static void glGenFramebuffersEXT(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.EXTFramebufferObject.glGenFramebuffersEXT(framebuffers);
    }

    public static int glGenRenderbuffersEXT() {
        return org.lwjgl.opengl.EXTFramebufferObject.glGenRenderbuffersEXT();
    }

    public static void glGenRenderbuffersEXT(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.EXTFramebufferObject.glGenRenderbuffersEXT(renderbuffers);
    }

    public static void glGenerateMipmapEXT(int target) {
        org.lwjgl.opengl.EXTFramebufferObject.glGenerateMipmapEXT(target);
    }

    public static void glGetFramebufferAttachmentParameterEXT(
            int target, int attachment, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.EXTFramebufferObject.glGetFramebufferAttachmentParameterivEXT(
                target, attachment, pname, params);
    }

    public static int glGetFramebufferAttachmentParameteriEXT(int target, int attachment, int pname) {
        return org.lwjgl.opengl.EXTFramebufferObject.glGetFramebufferAttachmentParameteriEXT(target, attachment, pname);
    }

    public static void glGetRenderbufferParameterEXT(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.EXTFramebufferObject.glGetRenderbufferParameterivEXT(target, pname, params);
    }

    public static int glGetRenderbufferParameteriEXT(int target, int pname) {
        return org.lwjgl.opengl.EXTFramebufferObject.glGetRenderbufferParameteriEXT(target, pname);
    }

    public static boolean glIsFramebufferEXT(int framebuffer) {
        return org.lwjgl.opengl.EXTFramebufferObject.glIsFramebufferEXT(framebuffer);
    }

    public static boolean glIsRenderbufferEXT(int renderbuffer) {
        return org.lwjgl.opengl.EXTFramebufferObject.glIsRenderbufferEXT(renderbuffer);
    }

    public static void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
        org.lwjgl.opengl.EXTFramebufferObject.glRenderbufferStorageEXT(target, internalformat, width, height);
    }
}
