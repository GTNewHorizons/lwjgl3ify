package org.lwjglx.opengl;

public class GL30 {
    public static void glBeginConditionalRender(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glBeginConditionalRender(arg0, arg1);
    }

    public static void glBeginTransformFeedback(int arg0) {
        org.lwjgl.opengl.GL30.glBeginTransformFeedback(arg0);
    }

    public static void glBindBufferBase(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glBindBufferBase(arg0, arg1, arg2);
    }

    public static void glBindBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) {
        org.lwjgl.opengl.GL30.glBindBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glBindFragDataLocation(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.GL30.glBindFragDataLocation(arg0, arg1, arg2);
    }

    public static void glBindFragDataLocation(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL30.glBindFragDataLocation(arg0, arg1, arg2);
    }

    public static void glBindFramebuffer(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glBindFramebuffer(arg0, arg1);
    }

    public static void glBindRenderbuffer(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glBindRenderbuffer(arg0, arg1);
    }

    public static void glBindVertexArray(int arg0) {
        org.lwjgl.opengl.GL30.glBindVertexArray(arg0);
    }

    public static void glBlitFramebuffer(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        org.lwjgl.opengl.GL30.glBlitFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static int glCheckFramebufferStatus(int arg0) {
        return org.lwjgl.opengl.GL30.glCheckFramebufferStatus(arg0);
    }

    public static void glClampColor(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glClampColor(arg0, arg1);
    }

    public static void glClearBuffer(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL30.glClearBufferfv(arg0, arg1, arg2);
    }

    public static void glClearBuffer(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glClearBufferiv(arg0, arg1, arg2);
    }

    public static void glClearBufferfi(int arg0, int arg1, float arg2, int arg3) {
        org.lwjgl.opengl.GL30.glClearBufferfi(arg0, arg1, arg2, arg3);
    }

    public static void glClearBufferu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glClearBufferuiv(arg0, arg1, arg2);
    }

    public static void glColorMaski(int arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) {
        org.lwjgl.opengl.GL30.glColorMaski(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glDeleteFramebuffers(int arg0) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(arg0);
    }

    public static void glDeleteFramebuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(arg0);
    }

    public static void glDeleteRenderbuffers(int arg0) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(arg0);
    }

    public static void glDeleteRenderbuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(arg0);
    }

    public static void glDeleteVertexArrays(int arg0) {
        org.lwjgl.opengl.GL30.glDeleteVertexArrays(arg0);
    }

    public static void glDeleteVertexArrays(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glDeleteVertexArrays(arg0);
    }

    public static void glDisablei(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glDisablei(arg0, arg1);
    }

    public static void glEnablei(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glEnablei(arg0, arg1);
    }

    public static void glEndConditionalRender() {
        org.lwjgl.opengl.GL30.glEndConditionalRender();
    }

    public static void glEndTransformFeedback() {
        org.lwjgl.opengl.GL30.glEndTransformFeedback();
    }

    public static void glFlushMappedBufferRange(int arg0, long arg1, long arg2) {
        org.lwjgl.opengl.GL30.glFlushMappedBufferRange(arg0, arg1, arg2);
    }

    public static void glFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL30.glFramebufferRenderbuffer(arg0, arg1, arg2, arg3);
    }

    public static void glFramebufferTexture1D(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glFramebufferTexture1D(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glFramebufferTexture2D(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glFramebufferTexture2D(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glFramebufferTexture3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL30.glFramebufferTexture3D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glFramebufferTextureLayer(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glFramebufferTextureLayer(arg0, arg1, arg2, arg3, arg4);
    }

    public static int glGenFramebuffers() {
        return org.lwjgl.opengl.GL30.glGenFramebuffers();
    }

    public static void glGenFramebuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glGenFramebuffers(arg0);
    }

    public static int glGenRenderbuffers() {
        return org.lwjgl.opengl.GL30.glGenRenderbuffers();
    }

    public static void glGenRenderbuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glGenRenderbuffers(arg0);
    }

    public static int glGenVertexArrays() {
        return org.lwjgl.opengl.GL30.glGenVertexArrays();
    }

    public static void glGenVertexArrays(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL30.glGenVertexArrays(arg0);
    }

    public static void glGenerateMipmap(int arg0) {
        org.lwjgl.opengl.GL30.glGenerateMipmap(arg0);
    }

    public static void glGetBoolean(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetBooleani_v(arg0, arg1, arg2);
    }

    public static int glGetFragDataLocation(int arg0, java.lang.CharSequence arg1) {
        return org.lwjgl.opengl.GL30.glGetFragDataLocation(arg0, arg1);
    }

    public static int glGetFragDataLocation(int arg0, java.nio.ByteBuffer arg1) {
        return org.lwjgl.opengl.GL30.glGetFragDataLocation(arg0, arg1);
    }

    public static void glGetFramebufferAttachmentParameter(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
    }

    public static int glGetFramebufferAttachmentParameteri(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteri(arg0, arg1, arg2);
    }

    public static void glGetInteger(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetIntegeri_v(arg0, arg1, arg2);
    }

    public static void glGetRenderbufferParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetRenderbufferParameteriv(arg0, arg1, arg2);
    }

    public static int glGetRenderbufferParameteri(int arg0, int arg1) {
        return org.lwjgl.opengl.GL30.glGetRenderbufferParameteri(arg0, arg1);
    }

    public static java.lang.String glGetStringi(int arg0, int arg1) {
        return org.lwjgl.opengl.GL30.glGetStringi(arg0, arg1);
    }

    public static void glGetTexParameterI(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetTexParameterIiv(arg0, arg1, arg2);
    }

    public static int glGetTexParameterIi(int arg0, int arg1) {
        return org.lwjgl.opengl.GL30.glGetTexParameterIi(arg0, arg1);
    }

    public static void glGetTexParameterIu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetTexParameterIuiv(arg0, arg1, arg2);
    }

    public static int glGetTexParameterIui(int arg0, int arg1) {
        return org.lwjgl.opengl.GL30.glGetTexParameterIui(arg0, arg1);
    }

    public static java.lang.String glGetTransformFeedbackVarying(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4) {
        return org.lwjgl.opengl.GL30.glGetTransformFeedbackVarying(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTransformFeedbackVarying(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL30.glGetTransformFeedbackVarying(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glGetUniformu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetUniformuiv(arg0, arg1, arg2);
    }

    public static void glGetVertexAttribI(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIiv(arg0, arg1, arg2);
    }

    public static void glGetVertexAttribIu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIuiv(arg0, arg1, arg2);
    }

    public static boolean glIsEnabledi(int arg0, int arg1) {
        return org.lwjgl.opengl.GL30.glIsEnabledi(arg0, arg1);
    }

    public static boolean glIsFramebuffer(int arg0) {
        return org.lwjgl.opengl.GL30.glIsFramebuffer(arg0);
    }

    public static boolean glIsRenderbuffer(int arg0) {
        return org.lwjgl.opengl.GL30.glIsRenderbuffer(arg0);
    }

    public static boolean glIsVertexArray(int arg0) {
        return org.lwjgl.opengl.GL30.glIsVertexArray(arg0);
    }

    public static java.nio.ByteBuffer glMapBufferRange(int arg0, long arg1, long arg2, int arg3, java.nio.ByteBuffer arg4) {
        return org.lwjgl.opengl.GL30.glMapBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL30.glRenderbufferStorage(arg0, arg1, arg2, arg3);
    }

    public static void glRenderbufferStorageMultisample(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glRenderbufferStorageMultisample(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glTexParameterI(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glTexParameterIiv(arg0, arg1, arg2);
    }

    public static void glTexParameterIi(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glTexParameterIi(arg0, arg1, arg2);
    }

    public static void glTexParameterIu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL30.glTexParameterIuiv(arg0, arg1, arg2);
    }

    public static void glTexParameterIui(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glTexParameterIui(arg0, arg1, arg2);
    }

    public static void glTransformFeedbackVaryings(int arg0, java.lang.CharSequence[] arg1, int arg2) {
        org.lwjgl.opengl.GL30.glTransformFeedbackVaryings(arg0, arg1, arg2);
    }

    public static void glUniform1u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glUniform1uiv(arg0, arg1);
    }

    public static void glUniform1ui(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glUniform1ui(arg0, arg1);
    }

    public static void glUniform2u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glUniform2uiv(arg0, arg1);
    }

    public static void glUniform2ui(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glUniform2ui(arg0, arg1, arg2);
    }

    public static void glUniform3u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glUniform3uiv(arg0, arg1);
    }

    public static void glUniform3ui(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL30.glUniform3ui(arg0, arg1, arg2, arg3);
    }

    public static void glUniform4u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glUniform4uiv(arg0, arg1);
    }

    public static void glUniform4ui(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glUniform4ui(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribI1(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI1iv(arg0, arg1);
    }

    public static void glVertexAttribI1i(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI1i(arg0, arg1);
    }

    public static void glVertexAttribI1u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI1uiv(arg0, arg1);
    }

    public static void glVertexAttribI1ui(int arg0, int arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI1ui(arg0, arg1);
    }

    public static void glVertexAttribI2(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI2iv(arg0, arg1);
    }

    public static void glVertexAttribI2i(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glVertexAttribI2i(arg0, arg1, arg2);
    }

    public static void glVertexAttribI2u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI2uiv(arg0, arg1);
    }

    public static void glVertexAttribI2ui(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL30.glVertexAttribI2ui(arg0, arg1, arg2);
    }

    public static void glVertexAttribI3(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI3iv(arg0, arg1);
    }

    public static void glVertexAttribI3i(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL30.glVertexAttribI3i(arg0, arg1, arg2, arg3);
    }

    public static void glVertexAttribI3u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI3uiv(arg0, arg1);
    }

    public static void glVertexAttribI3ui(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL30.glVertexAttribI3ui(arg0, arg1, arg2, arg3);
    }

    public static void glVertexAttribI4(int arg0, java.nio.ByteBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4bv(arg0, arg1);
    }

    public static void glVertexAttribI4(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4iv(arg0, arg1);
    }

    public static void glVertexAttribI4(int arg0, java.nio.ShortBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4sv(arg0, arg1);
    }

    public static void glVertexAttribI4i(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribI4i(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribI4u(int arg0, java.nio.ByteBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4ubv(arg0, arg1);
    }

    public static void glVertexAttribI4u(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4uiv(arg0, arg1);
    }

    public static void glVertexAttribI4u(int arg0, java.nio.ShortBuffer arg1) {
        org.lwjgl.opengl.GL30.glVertexAttribI4usv(arg0, arg1);
    }

    public static void glVertexAttribI4ui(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribI4ui(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, long arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, java.nio.IntBuffer arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexAttribIPointer(int arg0, int arg1, int arg2, int arg3, java.nio.ShortBuffer arg4) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(arg0, arg1, arg2, arg3, arg4);
    }


}
