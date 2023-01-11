package org.lwjglx.opengl;

public class GL43 {
    public void glBindVertexBuffer(int arg0, int arg1, long arg2, int arg3) {
        org.lwjgl.opengl.GL43.glBindVertexBuffer(arg0, arg1, arg2, arg3);
    }

    public void glClearBufferData(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL43.glClearBufferData(arg0, arg1, arg2, arg3, arg4);
    }

    public void glClearBufferSubData(int arg0, int arg1, long arg2, long arg3, int arg4, int arg5, java.nio.ByteBuffer arg6) {
        org.lwjgl.opengl.GL43.glClearBufferSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void glCopyImageSubData(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
        org.lwjgl.opengl.GL43.glCopyImageSubData(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    public void glDebugMessageControl(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, boolean arg4) {
        org.lwjgl.opengl.GL43.glDebugMessageControl(arg0, arg1, arg2, arg3, arg4);
    }

    public void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, java.lang.CharSequence arg4) {
        org.lwjgl.opengl.GL43.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4);
    }

    public void glDebugMessageInsert(int arg0, int arg1, int arg2, int arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL43.glDebugMessageInsert(arg0, arg1, arg2, arg3, arg4);
    }

    public void glDispatchCompute(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL43.glDispatchCompute(arg0, arg1, arg2);
    }

    public void glDispatchComputeIndirect(long arg0) {
        org.lwjgl.opengl.GL43.glDispatchComputeIndirect(arg0);
    }

    public void glFramebufferParameteri(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL43.glFramebufferParameteri(arg0, arg1, arg2);
    }

    public int glGetDebugMessageLog(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.IntBuffer arg5, java.nio.ByteBuffer arg6) {
        return org.lwjgl.opengl.GL43.glGetDebugMessageLog(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void glGetFramebufferParameter(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.GL43.glGetFramebufferParameteriv(arg0, arg1, arg2);
    }

    public int glGetFramebufferParameteri(int arg0, int arg1) {
        return org.lwjgl.opengl.GL43.glGetFramebufferParameteri(arg0, arg1);
    }

    public void glGetInternalformat(int arg0, int arg1, int arg2, java.nio.LongBuffer arg3) {
        org.lwjgl.opengl.GL43.glGetInternalformati64v(arg0, arg1, arg2, arg3);
    }

    public long glGetInternalformati64(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL43.glGetInternalformati64(arg0, arg1, arg2);
    }

    public java.lang.String glGetObjectLabel(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL43.glGetObjectLabel(arg0, arg1, arg2);
    }

    public void glGetObjectLabel(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.GL43.glGetObjectLabel(arg0, arg1, arg2, arg3);
    }

    public void glGetProgramInterface(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.GL43.glGetProgramInterfaceiv(arg0, arg1, arg2, arg3);
    }

    public int glGetProgramInterfacei(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramInterfacei(arg0, arg1, arg2);
    }

    public void glGetProgramResource(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, java.nio.IntBuffer arg4, java.nio.IntBuffer arg5) {
        org.lwjgl.opengl.GL43.glGetProgramResourceiv(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public int glGetProgramResourceIndex(int arg0, int arg1, java.lang.CharSequence arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceIndex(arg0, arg1, arg2);
    }

    public int glGetProgramResourceIndex(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceIndex(arg0, arg1, arg2);
    }

    public int glGetProgramResourceLocation(int arg0, int arg1, java.lang.CharSequence arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocation(arg0, arg1, arg2);
    }

    public int glGetProgramResourceLocation(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocation(arg0, arg1, arg2);
    }

    public int glGetProgramResourceLocationIndex(int arg0, int arg1, java.lang.CharSequence arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocationIndex(arg0, arg1, arg2);
    }

    public int glGetProgramResourceLocationIndex(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocationIndex(arg0, arg1, arg2);
    }

    public java.lang.String glGetProgramResourceName(int arg0, int arg1, int arg2, int arg3) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceName(arg0, arg1, arg2, arg3);
    }

    public void glGetProgramResourceName(int arg0, int arg1, int arg2, java.nio.IntBuffer arg3, java.nio.ByteBuffer arg4) {
        org.lwjgl.opengl.GL43.glGetProgramResourceName(arg0, arg1, arg2, arg3, arg4);
    }

    public void glInvalidateBufferData(int arg0) {
        org.lwjgl.opengl.GL43.glInvalidateBufferData(arg0);
    }

    public void glInvalidateBufferSubData(int arg0, long arg1, long arg2) {
        org.lwjgl.opengl.GL43.glInvalidateBufferSubData(arg0, arg1, arg2);
    }

    public void glInvalidateFramebuffer(int arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.GL43.glInvalidateFramebuffer(arg0, arg1);
    }

    public void glInvalidateSubFramebuffer(int arg0, java.nio.IntBuffer arg1, int arg2, int arg3, int arg4, int arg5) {
        org.lwjgl.opengl.GL43.glInvalidateSubFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public void glInvalidateTexImage(int arg0, int arg1) {
        org.lwjgl.opengl.GL43.glInvalidateTexImage(arg0, arg1);
    }

    public void glInvalidateTexSubImage(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        org.lwjgl.opengl.GL43.glInvalidateTexSubImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public void glMultiDrawArraysIndirect(int arg0, long arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3);
    }

    public void glMultiDrawArraysIndirect(int arg0, java.nio.ByteBuffer arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3);
    }

    public void glMultiDrawArraysIndirect(int arg0, java.nio.IntBuffer arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(arg0, arg1, arg2, arg3);
    }

    public void glMultiDrawElementsIndirect(int arg0, int arg1, long arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4);
    }

    public void glMultiDrawElementsIndirect(int arg0, int arg1, java.nio.ByteBuffer arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4);
    }

    public void glMultiDrawElementsIndirect(int arg0, int arg1, java.nio.IntBuffer arg2, int arg3, int arg4) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(arg0, arg1, arg2, arg3, arg4);
    }

    public void glObjectLabel(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.GL43.glObjectLabel(arg0, arg1, arg2);
    }

    public void glObjectLabel(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL43.glObjectLabel(arg0, arg1, arg2);
    }

    public void glPopDebugGroup() {
        org.lwjgl.opengl.GL43.glPopDebugGroup();
    }

    public void glPushDebugGroup(int arg0, int arg1, java.lang.CharSequence arg2) {
        org.lwjgl.opengl.GL43.glPushDebugGroup(arg0, arg1, arg2);
    }

    public void glPushDebugGroup(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.GL43.glPushDebugGroup(arg0, arg1, arg2);
    }

    public void glShaderStorageBlockBinding(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.GL43.glShaderStorageBlockBinding(arg0, arg1, arg2);
    }

    public void glTexBufferRange(int arg0, int arg1, int arg2, long arg3, long arg4) {
        org.lwjgl.opengl.GL43.glTexBufferRange(arg0, arg1, arg2, arg3, arg4);
    }

    public void glTexStorage2DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        org.lwjgl.opengl.GL43.glTexStorage2DMultisample(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public void glTexStorage3DMultisample(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) {
        org.lwjgl.opengl.GL43.glTexStorage3DMultisample(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void glTextureView(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        org.lwjgl.opengl.GL43.glTextureView(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public void glVertexAttribBinding(int arg0, int arg1) {
        org.lwjgl.opengl.GL43.glVertexAttribBinding(arg0, arg1);
    }

    public void glVertexAttribFormat(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        org.lwjgl.opengl.GL43.glVertexAttribFormat(arg0, arg1, arg2, arg3, arg4);
    }

    public void glVertexAttribIFormat(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL43.glVertexAttribIFormat(arg0, arg1, arg2, arg3);
    }

    public void glVertexAttribLFormat(int arg0, int arg1, int arg2, int arg3) {
        org.lwjgl.opengl.GL43.glVertexAttribLFormat(arg0, arg1, arg2, arg3);
    }

    public void glVertexBindingDivisor(int arg0, int arg1) {
        org.lwjgl.opengl.GL43.glVertexBindingDivisor(arg0, arg1);
    }


}
