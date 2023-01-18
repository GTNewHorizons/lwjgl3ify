package org.lwjglx.opengl;

public class ARBFramebufferNoAttachments {
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;

    public static void glFramebufferParameteri(int target, int pname, int param) {
        org.lwjgl.opengl.ARBFramebufferNoAttachments.glFramebufferParameteri(target, pname, param);
    }

    public static int glGetFramebufferParameteri(int target, int pname) {
        return org.lwjgl.opengl.ARBFramebufferNoAttachments.glGetFramebufferParameteri(target, pname);
    }

    public static void glGetNamedFramebufferParameterEXT(int framebuffer, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBFramebufferNoAttachments.glGetNamedFramebufferParameterivEXT(framebuffer, pname, params);
    }

    public static void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
        org.lwjgl.opengl.ARBFramebufferNoAttachments.glNamedFramebufferParameteriEXT(framebuffer, pname, param);
    }
}
