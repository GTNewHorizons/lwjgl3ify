package org.lwjglx.opengl;

public class GL43 {
    public static void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
        org.lwjgl.opengl.GL43.glBindVertexBuffer(bindingindex, buffer, offset, stride);
    }

    public static void glClearBufferData(
            int target, int internalformat, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL43.glClearBufferData(target, internalformat, format, type, data);
    }

    public static void glClearBufferSubData(
            int target, int internalformat, long offset, long size, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL43.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
    }

    public static void glCopyImageSubData(
            int srcName,
            int srcTarget,
            int srcLevel,
            int srcX,
            int srcY,
            int srcZ,
            int dstName,
            int dstTarget,
            int dstLevel,
            int dstX,
            int dstY,
            int dstZ,
            int srcWidth,
            int srcHeight,
            int srcDepth) {
        org.lwjgl.opengl.GL43.glCopyImageSubData(
                srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ,
                srcWidth, srcHeight, srcDepth);
    }

    public static void glDebugMessageControl(
            int source, int type, int severity, java.nio.IntBuffer ids, boolean enabled) {
        org.lwjgl.opengl.GL43.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    public static void glDebugMessageInsert(int source, int type, int id, int severity, java.lang.CharSequence buf) {
        org.lwjgl.opengl.GL43.glDebugMessageInsert(source, type, id, severity, buf);
    }

    public static void glDebugMessageInsert(int source, int type, int id, int severity, java.nio.ByteBuffer buf) {
        org.lwjgl.opengl.GL43.glDebugMessageInsert(source, type, id, severity, buf);
    }

    public static void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
        org.lwjgl.opengl.GL43.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z);
    }

    public static void glDispatchComputeIndirect(long indirect) {
        org.lwjgl.opengl.GL43.glDispatchComputeIndirect(indirect);
    }

    public static void glFramebufferParameteri(int target, int pname, int param) {
        org.lwjgl.opengl.GL43.glFramebufferParameteri(target, pname, param);
    }

    public static int glGetDebugMessageLog(
            int count,
            java.nio.IntBuffer sources,
            java.nio.IntBuffer types,
            java.nio.IntBuffer ids,
            java.nio.IntBuffer severities,
            java.nio.IntBuffer lengths,
            java.nio.ByteBuffer messageLog) {
        return org.lwjgl.opengl.GL43.glGetDebugMessageLog(count, sources, types, ids, severities, lengths, messageLog);
    }

    public static void glGetFramebufferParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL43.glGetFramebufferParameteriv(target, pname, params);
    }

    public static int glGetFramebufferParameteri(int target, int pname) {
        return org.lwjgl.opengl.GL43.glGetFramebufferParameteri(target, pname);
    }

    public static void glGetInternalformat(int target, int internalformat, int pname, java.nio.LongBuffer params) {
        org.lwjgl.opengl.GL43.glGetInternalformati64v(target, internalformat, pname, params);
    }

    public static long glGetInternalformati64(int target, int internalformat, int pname) {
        return org.lwjgl.opengl.GL43.glGetInternalformati64(target, internalformat, pname);
    }

    public static java.lang.String glGetObjectLabel(int identifier, int name, int bufSize) {
        return org.lwjgl.opengl.GL43.glGetObjectLabel(identifier, name, bufSize);
    }

    public static void glGetObjectLabel(
            int identifier, int name, java.nio.IntBuffer length, java.nio.ByteBuffer label) {
        org.lwjgl.opengl.GL43.glGetObjectLabel(identifier, name, length, label);
    }

    public static void glGetProgramInterface(int program, int programInterface, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL43.glGetProgramInterfaceiv(program, programInterface, pname, params);
    }

    public static int glGetProgramInterfacei(int program, int programInterface, int pname) {
        return org.lwjgl.opengl.GL43.glGetProgramInterfacei(program, programInterface, pname);
    }

    public static void glGetProgramResource(
            int program,
            int programInterface,
            int index,
            java.nio.IntBuffer props,
            java.nio.IntBuffer length,
            java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL43.glGetProgramResourceiv(program, programInterface, index, props, length, params);
    }

    public static int glGetProgramResourceIndex(int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static int glGetProgramResourceIndex(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static int glGetProgramResourceLocation(int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int glGetProgramResourceLocation(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int glGetProgramResourceLocationIndex(
            int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    public static int glGetProgramResourceLocationIndex(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceLocationIndex(program, programInterface, name);
    }

    public static java.lang.String glGetProgramResourceName(int program, int programInterface, int index, int bufSize) {
        return org.lwjgl.opengl.GL43.glGetProgramResourceName(program, programInterface, index, bufSize);
    }

    public static void glGetProgramResourceName(
            int program, int programInterface, int index, java.nio.IntBuffer length, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL43.glGetProgramResourceName(program, programInterface, index, length, name);
    }

    public static void glInvalidateBufferData(int buffer) {
        org.lwjgl.opengl.GL43.glInvalidateBufferData(buffer);
    }

    public static void glInvalidateBufferSubData(int buffer, long offset, long length) {
        org.lwjgl.opengl.GL43.glInvalidateBufferSubData(buffer, offset, length);
    }

    public static void glInvalidateFramebuffer(int target, java.nio.IntBuffer attachments) {
        org.lwjgl.opengl.GL43.glInvalidateFramebuffer(target, attachments);
    }

    public static void glInvalidateSubFramebuffer(
            int target, java.nio.IntBuffer attachments, int x, int y, int width, int height) {
        org.lwjgl.opengl.GL43.glInvalidateSubFramebuffer(target, attachments, x, y, width, height);
    }

    public static void glInvalidateTexImage(int texture, int level) {
        org.lwjgl.opengl.GL43.glInvalidateTexImage(texture, level);
    }

    public static void glInvalidateTexSubImage(
            int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) {
        org.lwjgl.opengl.GL43.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth);
    }

    public static void glMultiDrawArraysIndirect(int mode, long indirect_buffer_offset, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(mode, indirect_buffer_offset, primcount, stride);
    }

    public static void glMultiDrawArraysIndirect(int mode, java.nio.ByteBuffer indirect, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(mode, indirect, primcount, stride);
    }

    public static void glMultiDrawArraysIndirect(int mode, java.nio.IntBuffer indirect, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawArraysIndirect(mode, indirect, primcount, stride);
    }

    public static void glMultiDrawElementsIndirect(
            int mode, int type, long indirect_buffer_offset, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(mode, type, indirect_buffer_offset, primcount, stride);
    }

    public static void glMultiDrawElementsIndirect(
            int mode, int type, java.nio.ByteBuffer indirect, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(mode, type, indirect, primcount, stride);
    }

    public static void glMultiDrawElementsIndirect(
            int mode, int type, java.nio.IntBuffer indirect, int primcount, int stride) {
        org.lwjgl.opengl.GL43.glMultiDrawElementsIndirect(mode, type, indirect, primcount, stride);
    }

    public static void glObjectLabel(int identifier, int name, java.lang.CharSequence label) {
        org.lwjgl.opengl.GL43.glObjectLabel(identifier, name, label);
    }

    public static void glObjectLabel(int identifier, int name, java.nio.ByteBuffer label) {
        org.lwjgl.opengl.GL43.glObjectLabel(identifier, name, label);
    }

    public static void glPopDebugGroup() {
        org.lwjgl.opengl.GL43.glPopDebugGroup();
    }

    public static void glPushDebugGroup(int source, int id, java.lang.CharSequence message) {
        org.lwjgl.opengl.GL43.glPushDebugGroup(source, id, message);
    }

    public static void glPushDebugGroup(int source, int id, java.nio.ByteBuffer message) {
        org.lwjgl.opengl.GL43.glPushDebugGroup(source, id, message);
    }

    public static void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) {
        org.lwjgl.opengl.GL43.glShaderStorageBlockBinding(program, storageBlockIndex, storageBlockBinding);
    }

    public static void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
        org.lwjgl.opengl.GL43.glTexBufferRange(target, internalformat, buffer, offset, size);
    }

    public static void glTexStorage2DMultisample(
            int target, int samples, int internalformat, int width, int height, boolean fixedsamplelocations) {
        org.lwjgl.opengl.GL43.glTexStorage2DMultisample(
                target, samples, internalformat, width, height, fixedsamplelocations);
    }

    public static void glTexStorage3DMultisample(
            int target,
            int samples,
            int internalformat,
            int width,
            int height,
            int depth,
            boolean fixedsamplelocations) {
        org.lwjgl.opengl.GL43.glTexStorage3DMultisample(
                target, samples, internalformat, width, height, depth, fixedsamplelocations);
    }

    public static void glTextureView(
            int texture,
            int target,
            int origtexture,
            int internalformat,
            int minlevel,
            int numlevels,
            int minlayer,
            int numlayers) {
        org.lwjgl.opengl.GL43.glTextureView(
                texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
    }

    public static void glVertexAttribBinding(int attribindex, int bindingindex) {
        org.lwjgl.opengl.GL43.glVertexAttribBinding(attribindex, bindingindex);
    }

    public static void glVertexAttribFormat(
            int attribindex, int size, int type, boolean normalized, int relativeoffset) {
        org.lwjgl.opengl.GL43.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
    }

    public static void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
        org.lwjgl.opengl.GL43.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) {
        org.lwjgl.opengl.GL43.glVertexAttribLFormat(attribindex, size, type, relativeoffset);
    }

    public static void glVertexBindingDivisor(int bindingindex, int divisor) {
        org.lwjgl.opengl.GL43.glVertexBindingDivisor(bindingindex, divisor);
    }
}
