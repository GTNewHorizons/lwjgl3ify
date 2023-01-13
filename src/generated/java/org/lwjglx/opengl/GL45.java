package org.lwjglx.opengl;

public class GL45 {
    public static void glBindTextureUnit(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glBindTextureUnit(arg0, arg1);
    }

    public static void glBlitNamedFramebuffer(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        org.lwjgl.opengl.GL45.glBlitNamedFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static int glCheckNamedFramebufferStatus(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glCheckNamedFramebufferStatus(arg0, arg1);
    }

    public static void glClearNamedBufferData(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL45.glClearNamedBufferData(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glClearNamedBufferSubData(int arg0, int arg1, long arg2, long arg3, int arg4, int arg5, java.nio.ByteBuffer arg6) {
        org.lwjgl.opengl.GL45.glClearNamedBufferSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glClearNamedFramebuffer(int arg0, int arg1, int arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL45.glClearNamedFramebufferfv(arg0, arg1, arg2, arg3);
    }

    public static void glClearNamedFramebuffer(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glClearNamedFramebufferiv(arg0, arg1, arg2, arg3);
    }

    public static void glClearNamedFramebufferu(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glClearNamedFramebufferuiv(arg0, arg1, arg2, arg3);
    }

    public static void glClipControl(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glClipControl(arg0, arg1);
    }

    public static void glCompressedTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
        org.lwjgl.opengl.GL45.glCompressedTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glCompressedTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.GL45.glCompressedTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCompressedTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        org.lwjgl.opengl.GL45.glCompressedTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glCompressedTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, java.nio.ByteBuffer arg7) {
        org.lwjgl.opengl.GL45.glCompressedTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glCompressedTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) {
        org.lwjgl.opengl.GL45.glCompressedTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glCompressedTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ByteBuffer arg10) {

        org.lwjgl.opengl.GL45.glCompressedTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, org.lwjglx.MemoryUtil.getAddress(arg10));

    }

    public static void glCopyNamedBufferSubData(int arg0, int arg1, long arg2, long arg3, long arg4) {
        org.lwjgl.opengl.GL45.glCopyNamedBufferSubData(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glCopyTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL45.glCopyTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCopyTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        org.lwjgl.opengl.GL45.glCopyTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glCopyTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        org.lwjgl.opengl.GL45.glCopyTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static int glCreateBuffers() {
        return org.lwjgl.opengl.GL45.glCreateBuffers();
    }

    public static void glCreateBuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateBuffers(arg0);
    }

    public static int glCreateFramebuffers() {
        return org.lwjgl.opengl.GL45.glCreateFramebuffers();
    }

    public static void glCreateFramebuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateFramebuffers(arg0);
    }

    public static int glCreateProgramPipelines() {
        return org.lwjgl.opengl.GL45.glCreateProgramPipelines();
    }

    public static void glCreateProgramPipelines(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateProgramPipelines(arg0);
    }

    public static int glCreateQueries(int arg0) {
        return org.lwjgl.opengl.GL45.glCreateQueries(arg0);
    }

    public static void glCreateQueries(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL45.glCreateQueries(arg0, arg1);
    }

    public static int glCreateRenderbuffers() {
        return org.lwjgl.opengl.GL45.glCreateRenderbuffers();
    }

    public static void glCreateRenderbuffers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateRenderbuffers(arg0);
    }

    public static int glCreateSamplers() {
        return org.lwjgl.opengl.GL45.glCreateSamplers();
    }

    public static void glCreateSamplers(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateSamplers(arg0);
    }

    public static int glCreateTextures(int arg0) {
        return org.lwjgl.opengl.GL45.glCreateTextures(arg0);
    }

    public static void glCreateTextures(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL45.glCreateTextures(arg0, arg1);
    }

    public static int glCreateTransformFeedbacks() {
        return org.lwjgl.opengl.GL45.glCreateTransformFeedbacks();
    }

    public static void glCreateTransformFeedbacks(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateTransformFeedbacks(arg0);
    }

    public static int glCreateVertexArrays() {
        return org.lwjgl.opengl.GL45.glCreateVertexArrays();
    }

    public static void glCreateVertexArrays(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.GL45.glCreateVertexArrays(arg0);
    }

    public static void glDisableVertexArrayAttrib(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glDisableVertexArrayAttrib(arg0, arg1);
    }

    public static void glEnableVertexArrayAttrib(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glEnableVertexArrayAttrib(arg0, arg1);
    }

    public static void glFlushMappedNamedBufferRange(int arg0, long arg1, long arg2) {
        org.lwjgl.opengl.GL45.glFlushMappedNamedBufferRange(arg0, arg1, arg2);
    }

    public static void glGenerateTextureMipmap(int arg0) {
        org.lwjgl.opengl.GL45.glGenerateTextureMipmap(arg0);
    }

    public static void glGetCompressedTextureImage(int arg0, int arg1, int arg2, long arg3) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureImage(arg0, arg1, arg2, arg3);
    }

    public static void glGetCompressedTextureImage(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureImage(arg0, arg1, arg2);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, long arg9) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.ByteBuffer arg8) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.DoubleBuffer arg8) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.FloatBuffer arg8) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.IntBuffer arg8) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glGetCompressedTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.ShortBuffer arg8) {
        org.lwjgl.opengl.GL45.glGetCompressedTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static int glGetGraphicsResetStatus() {
        return org.lwjgl.opengl.GL45.glGetGraphicsResetStatus();
    }

    public static void glGetNamedBufferParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferParameteriv(arg0, arg1, arg2);
    }

    public static void glGetNamedBufferParameter(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferParameteri64v(arg0, arg1, arg2);
    }

    public static long glGetNamedBufferParameteri64(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetNamedBufferParameteri64(arg0, arg1);
    }

    public static int glGetNamedBufferParameteri(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetNamedBufferParameteri(arg0, arg1);
    }

    public static void glGetNamedBufferSubData(int arg0, long arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glGetNamedBufferSubData(int arg0, long arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glGetNamedBufferSubData(int arg0, long arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glGetNamedBufferSubData(int arg0, long arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glGetNamedBufferSubData(int arg0, long arg1, java.nio.ShortBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glGetNamedFramebufferAttachmentParameter(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetNamedFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
    }

    public static void glGetNamedFramebufferParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedFramebufferParameteriv(arg0, arg1, arg2);
    }

    public static void glGetNamedRenderbufferParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetNamedRenderbufferParameteriv(arg0, arg1, arg2);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, int arg4, long arg5) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, java.nio.DoubleBuffer arg4) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, java.nio.FloatBuffer arg4) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, java.nio.IntBuffer arg4) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTextureImage(int arg0, int arg1, int arg2, int arg3, java.nio.ShortBuffer arg4) {
        org.lwjgl.opengl.GL45.glGetTextureImage(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetTextureLevelParameter(int arg0, int arg1, int arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetTextureLevelParameterfv(arg0, arg1, arg2, arg3);
    }

    public static void glGetTextureLevelParameter(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetTextureLevelParameteriv(arg0, arg1, arg2, arg3);
    }

    public static float glGetTextureLevelParameterf(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL45.glGetTextureLevelParameterf(arg0, arg1, arg2);
    }

    public static int glGetTextureLevelParameteri(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL45.glGetTextureLevelParameteri(arg0, arg1, arg2);
    }

    public static void glGetTextureParameter(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetTextureParameterfv(arg0, arg1, arg2);
    }

    public static void glGetTextureParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetTextureParameteriv(arg0, arg1, arg2);
    }

    public static void glGetTextureParameterI(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetTextureParameterIiv(arg0, arg1, arg2);
    }

    public static int glGetTextureParameterIi(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetTextureParameterIi(arg0, arg1);
    }

    public static void glGetTextureParameterIu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetTextureParameterIuiv(arg0, arg1, arg2);
    }

    public static int glGetTextureParameterIui(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetTextureParameterIui(arg0, arg1);
    }

    public static float glGetTextureParameterf(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetTextureParameterf(arg0, arg1);
    }

    public static int glGetTextureParameteri(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetTextureParameteri(arg0, arg1);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, long arg11) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ByteBuffer arg10) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.DoubleBuffer arg10) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.FloatBuffer arg10) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.IntBuffer arg10) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glGetTextureSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ShortBuffer arg10) {
        org.lwjgl.opengl.GL45.glGetTextureSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glGetTransformFeedback(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetTransformFeedbacki_v(arg0, arg1, arg2, arg3);
    }

    public static void glGetTransformFeedback(int arg0, int arg1, int arg2, java.nio.LongBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetTransformFeedbacki64_v(arg0, arg1, arg2, arg3);
    }

    public static void glGetTransformFeedback(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetTransformFeedbackiv(arg0, arg1, arg2);
    }

    public static long glGetTransformFeedbacki64(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL45.glGetTransformFeedbacki64(arg0, arg1, arg2);
    }

    public static int glGetTransformFeedbacki(int arg0, int arg1) {
        return org.lwjgl.opengl.GL45.glGetTransformFeedbacki(arg0, arg1);
    }

    public static int glGetTransformFeedbacki(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL45.glGetTransformFeedbacki(arg0, arg1, arg2);
    }

    public static void glGetVertexArray(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetVertexArrayiv(arg0, arg1, arg2);
    }

    public static long glGetVertexArrayIndexed64i(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL45.glGetVertexArrayIndexed64i(arg0, arg1, arg2);
    }

    public static void glGetVertexArrayIndexed64i(int arg0, int arg1, int arg2, java.nio.LongBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetVertexArrayIndexed64iv(arg0, arg1, arg2, arg3);
    }

    public static void glGetVertexArrayIndexed(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL45.glGetVertexArrayIndexediv(arg0, arg1, arg2, arg3);
    }

    public static void glGetnUniform(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetnUniformfv(arg0, arg1, arg2);
    }

    public static void glGetnUniform(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetnUniformiv(arg0, arg1, arg2);
    }

    public static void glGetnUniformu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glGetnUniformuiv(arg0, arg1, arg2);
    }

    public static void glInvalidateNamedFramebufferData(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL45.glInvalidateNamedFramebufferData(arg0, arg1);
    }

    public static void glInvalidateNamedFramebufferSubData(int arg0, java.nio.IntBuffer arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL45.glInvalidateNamedFramebufferSubData(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static java.nio.ByteBuffer glMapNamedBuffer(int arg0, int arg1, long arg2, java.nio.ByteBuffer arg3) {
        return org.lwjgl.opengl.GL45.glMapNamedBuffer(arg0, arg1, arg2, arg3);
    }

    public static java.nio.ByteBuffer glMapNamedBuffer(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL45.glMapNamedBuffer(arg0, arg1, arg2);
    }

    public static java.nio.ByteBuffer glMapNamedBufferRange(int arg0, long arg1, long arg2, int arg3, java.nio.ByteBuffer arg4) {
        return org.lwjgl.opengl.GL45.glMapNamedBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glMemoryBarrierByRegion(int arg0) {
        org.lwjgl.opengl.GL45.glMemoryBarrierByRegion(arg0);
    }

    public static void glNamedBufferData(int arg0, long arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferData(int arg0, java.nio.ByteBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferData(int arg0, java.nio.DoubleBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferData(int arg0, java.nio.FloatBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferData(int arg0, java.nio.IntBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferData(int arg0, java.nio.ShortBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferData(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, long arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, java.nio.ByteBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, java.nio.DoubleBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, java.nio.FloatBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, java.nio.IntBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferStorage(int arg0, java.nio.LongBuffer arg1, int arg2) {

        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, org.lwjglx.MemoryUtil.getAddress(arg1), arg2);

    }

    public static void glNamedBufferStorage(int arg0, java.nio.ShortBuffer arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferStorage(arg0, arg1, arg2);
    }

    public static void glNamedBufferSubData(int arg0, long arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glNamedBufferSubData(int arg0, long arg1, java.nio.DoubleBuffer arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glNamedBufferSubData(int arg0, long arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glNamedBufferSubData(int arg0, long arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glNamedBufferSubData(int arg0, long arg1, java.nio.ShortBuffer arg2) {
        org.lwjgl.opengl.GL45.glNamedBufferSubData(arg0, arg1, arg2);
    }

    public static void glNamedFramebufferDrawBuffer(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glNamedFramebufferDrawBuffer(arg0, arg1);
    }

    public static void glNamedFramebufferDrawBuffers(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL45.glNamedFramebufferDrawBuffers(arg0, arg1);
    }

    public static void glNamedFramebufferParameteri(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glNamedFramebufferParameteri(arg0, arg1, arg2);
    }

    public static void glNamedFramebufferReadBuffer(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glNamedFramebufferReadBuffer(arg0, arg1);
    }

    public static void glNamedFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL45.glNamedFramebufferRenderbuffer(arg0, arg1, arg2, arg3);
    }

    public static void glNamedFramebufferTexture(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL45.glNamedFramebufferTexture(arg0, arg1, arg2, arg3);
    }

    public static void glNamedFramebufferTextureLayer(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL45.glNamedFramebufferTextureLayer(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glNamedRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL45.glNamedRenderbufferStorage(arg0, arg1, arg2, arg3);
    }

    public static void glNamedRenderbufferStorageMultisample(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL45.glNamedRenderbufferStorageMultisample(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) {
        org.lwjgl.opengl.GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.ByteBuffer arg6) {
        org.lwjgl.opengl.GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.FloatBuffer arg6) {
        org.lwjgl.opengl.GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.IntBuffer arg6) {
        org.lwjgl.opengl.GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glReadnPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.ShortBuffer arg6) {
        org.lwjgl.opengl.GL45.glReadnPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureBarrier() {
        org.lwjgl.opengl.GL45.glTextureBarrier();
    }

    public static void glTextureBuffer(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glTextureBuffer(arg0, arg1, arg2);
    }

    public static void glTextureBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) {
        org.lwjgl.opengl.GL45.glTextureBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glTextureParameter(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.GL45.glTextureParameterfv(arg0, arg1, arg2);
    }

    public static void glTextureParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glTextureParameteriv(arg0, arg1, arg2);
    }

    public static void glTextureParameterI(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glTextureParameterIiv(arg0, arg1, arg2);
    }

    public static void glTextureParameterIu(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL45.glTextureParameterIuiv(arg0, arg1, arg2);
    }

    public static void glTextureParameterf(int arg0, int arg1, float arg2) {
        org.lwjgl.opengl.GL45.glTextureParameterf(arg0, arg1, arg2);
    }

    public static void glTextureParameteri(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glTextureParameteri(arg0, arg1, arg2);
    }

    public static void glTextureStorage1D(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL45.glTextureStorage1D(arg0, arg1, arg2, arg3);
    }

    public static void glTextureStorage2D(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL45.glTextureStorage2D(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glTextureStorage2DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        org.lwjgl.opengl.GL45.glTextureStorage2DMultisample(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glTextureStorage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL45.glTextureStorage3D(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glTextureStorage3DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) {
        org.lwjgl.opengl.GL45.glTextureStorage3DMultisample(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.ByteBuffer arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.DoubleBuffer arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.FloatBuffer arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.IntBuffer arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.nio.ShortBuffer arg6) {
        org.lwjgl.opengl.GL45.glTextureSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.ByteBuffer arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.DoubleBuffer arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.FloatBuffer arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.IntBuffer arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.nio.ShortBuffer arg8) {
        org.lwjgl.opengl.GL45.glTextureSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, long arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ByteBuffer arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.DoubleBuffer arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.FloatBuffer arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.IntBuffer arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTextureSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.nio.ShortBuffer arg10) {
        org.lwjgl.opengl.GL45.glTextureSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static void glTransformFeedbackBufferBase(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glTransformFeedbackBufferBase(arg0, arg1, arg2);
    }

    public static void glTransformFeedbackBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) {
        org.lwjgl.opengl.GL45.glTransformFeedbackBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public static boolean glUnmapNamedBuffer(int arg0) {
        return org.lwjgl.opengl.GL45.glUnmapNamedBuffer(arg0);
    }

    public static void glVertexArrayAttribBinding(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glVertexArrayAttribBinding(arg0, arg1, arg2);
    }

    public static void glVertexArrayAttribFormat(int arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
        org.lwjgl.opengl.GL45.glVertexArrayAttribFormat(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glVertexArrayAttribIFormat(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL45.glVertexArrayAttribIFormat(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexArrayAttribLFormat(int arg0, int arg1, int arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL45.glVertexArrayAttribLFormat(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glVertexArrayBindingDivisor(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL45.glVertexArrayBindingDivisor(arg0, arg1, arg2);
    }

    public static void glVertexArrayElementBuffer(int arg0, int arg1) {
        org.lwjgl.opengl.GL45.glVertexArrayElementBuffer(arg0, arg1);
    }

    public static void glVertexArrayVertexBuffer(int arg0, int arg1, int arg2, long arg3, int arg4) {
        org.lwjgl.opengl.GL45.glVertexArrayVertexBuffer(arg0, arg1, arg2, arg3, arg4);
    }


}
