package org.lwjglx.opengl;

public class EXTFramebufferObject {
    public static final int GL_COLOR_ATTACHMENT0_EXT = 36064;
    public static final int GL_COLOR_ATTACHMENT10_EXT = 36074;
    public static final int GL_COLOR_ATTACHMENT11_EXT = 36075;
    public static final int GL_COLOR_ATTACHMENT12_EXT = 36076;
    public static final int GL_COLOR_ATTACHMENT13_EXT = 36077;
    public static final int GL_COLOR_ATTACHMENT14_EXT = 36078;
    public static final int GL_COLOR_ATTACHMENT15_EXT = 36079;
    public static final int GL_COLOR_ATTACHMENT1_EXT = 36065;
    public static final int GL_COLOR_ATTACHMENT2_EXT = 36066;
    public static final int GL_COLOR_ATTACHMENT3_EXT = 36067;
    public static final int GL_COLOR_ATTACHMENT4_EXT = 36068;
    public static final int GL_COLOR_ATTACHMENT5_EXT = 36069;
    public static final int GL_COLOR_ATTACHMENT6_EXT = 36070;
    public static final int GL_COLOR_ATTACHMENT7_EXT = 36071;
    public static final int GL_COLOR_ATTACHMENT8_EXT = 36072;
    public static final int GL_COLOR_ATTACHMENT9_EXT = 36073;
    public static final int GL_DEPTH_ATTACHMENT_EXT = 36096;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT = 36052;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT = 36050;
    public static final int GL_FRAMEBUFFER_BINDING_EXT = 36006;
    public static final int GL_FRAMEBUFFER_COMPLETE_EXT = 36053;
    public static final int GL_FRAMEBUFFER_EXT = 36160;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 36057;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 36058;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT = 36061;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION_EXT = 1286;
    public static final int GL_MAX_COLOR_ATTACHMENTS_EXT = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE_EXT = 34024;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE_EXT = 36179;
    public static final int GL_RENDERBUFFER_BINDING_EXT = 36007;
    public static final int GL_RENDERBUFFER_BLUE_SIZE_EXT = 36178;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE_EXT = 36180;
    public static final int GL_RENDERBUFFER_EXT = 36161;
    public static final int GL_RENDERBUFFER_GREEN_SIZE_EXT = 36177;
    public static final int GL_RENDERBUFFER_HEIGHT_EXT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_EXT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE_EXT = 36176;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE_EXT = 36181;
    public static final int GL_RENDERBUFFER_WIDTH_EXT = 36162;
    public static final int GL_STENCIL_ATTACHMENT_EXT = 36128;
    public static final int GL_STENCIL_INDEX16_EXT = 36169;
    public static final int GL_STENCIL_INDEX1_EXT = 36166;
    public static final int GL_STENCIL_INDEX4_EXT = 36167;
    public static final int GL_STENCIL_INDEX8_EXT = 36168;

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
