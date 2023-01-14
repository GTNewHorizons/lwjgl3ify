package org.lwjglx.opengl;

public class ARBFramebufferNoAttachments {
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
