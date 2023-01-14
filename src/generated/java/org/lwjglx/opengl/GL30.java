package org.lwjglx.opengl;

public class GL30 {
    public static void glBeginConditionalRender(int id, int mode) {
        org.lwjgl.opengl.GL30.glBeginConditionalRender(id, mode);
    }

    public static void glBeginTransformFeedback(int primitiveMode) {
        org.lwjgl.opengl.GL30.glBeginTransformFeedback(primitiveMode);
    }

    public static void glBindBufferBase(int target, int index, int buffer) {
        org.lwjgl.opengl.GL30.glBindBufferBase(target, index, buffer);
    }

    public static void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
        org.lwjgl.opengl.GL30.glBindBufferRange(target, index, buffer, offset, size);
    }

    public static void glBindFragDataLocation(int program, int colorNumber, java.lang.CharSequence name) {
        org.lwjgl.opengl.GL30.glBindFragDataLocation(program, colorNumber, name);
    }

    public static void glBindFragDataLocation(int program, int colorNumber, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL30.glBindFragDataLocation(program, colorNumber, name);
    }

    public static void glBindFramebuffer(int target, int framebuffer) {
        org.lwjgl.opengl.GL30.glBindFramebuffer(target, framebuffer);
    }

    public static void glBindRenderbuffer(int target, int renderbuffer) {
        org.lwjgl.opengl.GL30.glBindRenderbuffer(target, renderbuffer);
    }

    public static void glBindVertexArray(int array) {
        org.lwjgl.opengl.GL30.glBindVertexArray(array);
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
        org.lwjgl.opengl.GL30.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    }

    public static int glCheckFramebufferStatus(int target) {
        return org.lwjgl.opengl.GL30.glCheckFramebufferStatus(target);
    }

    public static void glClampColor(int target, int clamp) {
        org.lwjgl.opengl.GL30.glClampColor(target, clamp);
    }

    public static void glClearBuffer(int buffer, int drawbuffer, java.nio.FloatBuffer value) {
        org.lwjgl.opengl.GL30.glClearBufferfv(buffer, drawbuffer, value);
    }

    public static void glClearBuffer(int buffer, int drawbuffer, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glClearBufferiv(buffer, drawbuffer, value);
    }

    public static void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
        org.lwjgl.opengl.GL30.glClearBufferfi(buffer, drawbuffer, depth, stencil);
    }

    public static void glClearBufferu(int buffer, int drawbuffer, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glClearBufferuiv(buffer, drawbuffer, value);
    }

    public static void glColorMaski(int buf, boolean r, boolean g, boolean b, boolean a) {
        org.lwjgl.opengl.GL30.glColorMaski(buf, r, g, b, a);
    }

    public static void glDeleteFramebuffers(int framebuffer) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(framebuffer);
    }

    public static void glDeleteFramebuffers(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.GL30.glDeleteFramebuffers(framebuffers);
    }

    public static void glDeleteRenderbuffers(int renderbuffer) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(renderbuffer);
    }

    public static void glDeleteRenderbuffers(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.GL30.glDeleteRenderbuffers(renderbuffers);
    }

    public static void glDeleteVertexArrays(int array) {
        org.lwjgl.opengl.GL30.glDeleteVertexArrays(array);
    }

    public static void glDeleteVertexArrays(java.nio.IntBuffer arrays) {
        org.lwjgl.opengl.GL30.glDeleteVertexArrays(arrays);
    }

    public static void glDisablei(int target, int index) {
        org.lwjgl.opengl.GL30.glDisablei(target, index);
    }

    public static void glEnablei(int target, int index) {
        org.lwjgl.opengl.GL30.glEnablei(target, index);
    }

    public static void glEndConditionalRender() {
        org.lwjgl.opengl.GL30.glEndConditionalRender();
    }

    public static void glEndTransformFeedback() {
        org.lwjgl.opengl.GL30.glEndTransformFeedback();
    }

    public static void glFlushMappedBufferRange(int target, long offset, long length) {
        org.lwjgl.opengl.GL30.glFlushMappedBufferRange(target, offset, length);
    }

    public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
        org.lwjgl.opengl.GL30.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
    }

    public static void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.GL30.glFramebufferTexture1D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
        org.lwjgl.opengl.GL30.glFramebufferTexture2D(target, attachment, textarget, texture, level);
    }

    public static void glFramebufferTexture3D(
            int target, int attachment, int textarget, int texture, int level, int zoffset) {
        org.lwjgl.opengl.GL30.glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
    }

    public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
        org.lwjgl.opengl.GL30.glFramebufferTextureLayer(target, attachment, texture, level, layer);
    }

    public static int glGenFramebuffers() {
        return org.lwjgl.opengl.GL30.glGenFramebuffers();
    }

    public static void glGenFramebuffers(java.nio.IntBuffer framebuffers) {
        org.lwjgl.opengl.GL30.glGenFramebuffers(framebuffers);
    }

    public static int glGenRenderbuffers() {
        return org.lwjgl.opengl.GL30.glGenRenderbuffers();
    }

    public static void glGenRenderbuffers(java.nio.IntBuffer renderbuffers) {
        org.lwjgl.opengl.GL30.glGenRenderbuffers(renderbuffers);
    }

    public static int glGenVertexArrays() {
        return org.lwjgl.opengl.GL30.glGenVertexArrays();
    }

    public static void glGenVertexArrays(java.nio.IntBuffer arrays) {
        org.lwjgl.opengl.GL30.glGenVertexArrays(arrays);
    }

    public static void glGenerateMipmap(int target) {
        org.lwjgl.opengl.GL30.glGenerateMipmap(target);
    }

    public static void glGetBoolean(int value, int index, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL30.glGetBooleani_v(value, index, data);
    }

    public static int glGetFragDataLocation(int program, java.lang.CharSequence name) {
        return org.lwjgl.opengl.GL30.glGetFragDataLocation(program, name);
    }

    public static int glGetFragDataLocation(int program, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.GL30.glGetFragDataLocation(program, name);
    }

    public static void glGetFramebufferAttachmentParameter(
            int target, int attachment, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
    }

    public static int glGetFramebufferAttachmentParameteri(int target, int attachment, int pname) {
        return org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteri(target, attachment, pname);
    }

    public static void glGetInteger(int value, int index, java.nio.IntBuffer data) {
        org.lwjgl.opengl.GL30.glGetIntegeri_v(value, index, data);
    }

    public static void glGetRenderbufferParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetRenderbufferParameteriv(target, pname, params);
    }

    public static int glGetRenderbufferParameteri(int target, int pname) {
        return org.lwjgl.opengl.GL30.glGetRenderbufferParameteri(target, pname);
    }

    public static java.lang.String glGetStringi(int name, int index) {
        return org.lwjgl.opengl.GL30.glGetStringi(name, index);
    }

    public static void glGetTexParameterI(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetTexParameterIiv(target, pname, params);
    }

    public static int glGetTexParameterIi(int target, int pname) {
        return org.lwjgl.opengl.GL30.glGetTexParameterIi(target, pname);
    }

    public static void glGetTexParameterIu(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetTexParameterIuiv(target, pname, params);
    }

    public static int glGetTexParameterIui(int target, int pname) {
        return org.lwjgl.opengl.GL30.glGetTexParameterIui(target, pname);
    }

    public static java.lang.String glGetTransformFeedbackVarying(
            int program, int index, int bufSize, java.nio.IntBuffer size, java.nio.IntBuffer type) {
        return org.lwjgl.opengl.GL30.glGetTransformFeedbackVarying(program, index, bufSize, size, type);
    }

    public static void glGetTransformFeedbackVarying(
            int program,
            int index,
            java.nio.IntBuffer length,
            java.nio.IntBuffer size,
            java.nio.IntBuffer type,
            java.nio.ByteBuffer name) {
        org.lwjgl.opengl.GL30.glGetTransformFeedbackVarying(program, index, length, size, type, name);
    }

    public static void glGetUniformu(int program, int location, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetUniformuiv(program, location, params);
    }

    public static void glGetVertexAttribI(int index, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIiv(index, pname, params);
    }

    public static void glGetVertexAttribIu(int index, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glGetVertexAttribIuiv(index, pname, params);
    }

    public static boolean glIsEnabledi(int target, int index) {
        return org.lwjgl.opengl.GL30.glIsEnabledi(target, index);
    }

    public static boolean glIsFramebuffer(int framebuffer) {
        return org.lwjgl.opengl.GL30.glIsFramebuffer(framebuffer);
    }

    public static boolean glIsRenderbuffer(int renderbuffer) {
        return org.lwjgl.opengl.GL30.glIsRenderbuffer(renderbuffer);
    }

    public static boolean glIsVertexArray(int array) {
        return org.lwjgl.opengl.GL30.glIsVertexArray(array);
    }

    public static java.nio.ByteBuffer glMapBufferRange(
            int target, long offset, long length, int access, java.nio.ByteBuffer old_buffer) {
        return org.lwjgl.opengl.GL30.glMapBufferRange(target, offset, length, access, old_buffer);
    }

    public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
        org.lwjgl.opengl.GL30.glRenderbufferStorage(target, internalformat, width, height);
    }

    public static void glRenderbufferStorageMultisample(
            int target, int samples, int internalformat, int width, int height) {
        org.lwjgl.opengl.GL30.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
    }

    public static void glTexParameterI(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glTexParameterIiv(target, pname, params);
    }

    public static void glTexParameterIi(int target, int pname, int param) {
        org.lwjgl.opengl.GL30.glTexParameterIi(target, pname, param);
    }

    public static void glTexParameterIu(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL30.glTexParameterIuiv(target, pname, params);
    }

    public static void glTexParameterIui(int target, int pname, int param) {
        org.lwjgl.opengl.GL30.glTexParameterIui(target, pname, param);
    }

    public static void glTransformFeedbackVaryings(int program, java.lang.CharSequence[] varyings, int bufferMode) {
        org.lwjgl.opengl.GL30.glTransformFeedbackVaryings(program, varyings, bufferMode);
    }

    public static void glUniform1u(int location, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glUniform1uiv(location, value);
    }

    public static void glUniform1ui(int location, int v0) {
        org.lwjgl.opengl.GL30.glUniform1ui(location, v0);
    }

    public static void glUniform2u(int location, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glUniform2uiv(location, value);
    }

    public static void glUniform2ui(int location, int v0, int v1) {
        org.lwjgl.opengl.GL30.glUniform2ui(location, v0, v1);
    }

    public static void glUniform3u(int location, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glUniform3uiv(location, value);
    }

    public static void glUniform3ui(int location, int v0, int v1, int v2) {
        org.lwjgl.opengl.GL30.glUniform3ui(location, v0, v1, v2);
    }

    public static void glUniform4u(int location, java.nio.IntBuffer value) {
        org.lwjgl.opengl.GL30.glUniform4uiv(location, value);
    }

    public static void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
        org.lwjgl.opengl.GL30.glUniform4ui(location, v0, v1, v2, v3);
    }

    public static void glVertexAttribI1(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI1iv(index, v);
    }

    public static void glVertexAttribI1i(int index, int x) {
        org.lwjgl.opengl.GL30.glVertexAttribI1i(index, x);
    }

    public static void glVertexAttribI1u(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI1uiv(index, v);
    }

    public static void glVertexAttribI1ui(int index, int x) {
        org.lwjgl.opengl.GL30.glVertexAttribI1ui(index, x);
    }

    public static void glVertexAttribI2(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI2iv(index, v);
    }

    public static void glVertexAttribI2i(int index, int x, int y) {
        org.lwjgl.opengl.GL30.glVertexAttribI2i(index, x, y);
    }

    public static void glVertexAttribI2u(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI2uiv(index, v);
    }

    public static void glVertexAttribI2ui(int index, int x, int y) {
        org.lwjgl.opengl.GL30.glVertexAttribI2ui(index, x, y);
    }

    public static void glVertexAttribI3(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI3iv(index, v);
    }

    public static void glVertexAttribI3i(int index, int x, int y, int z) {
        org.lwjgl.opengl.GL30.glVertexAttribI3i(index, x, y, z);
    }

    public static void glVertexAttribI3u(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI3uiv(index, v);
    }

    public static void glVertexAttribI3ui(int index, int x, int y, int z) {
        org.lwjgl.opengl.GL30.glVertexAttribI3ui(index, x, y, z);
    }

    public static void glVertexAttribI4(int index, java.nio.ByteBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4bv(index, v);
    }

    public static void glVertexAttribI4(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4iv(index, v);
    }

    public static void glVertexAttribI4(int index, java.nio.ShortBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4sv(index, v);
    }

    public static void glVertexAttribI4i(int index, int x, int y, int z, int w) {
        org.lwjgl.opengl.GL30.glVertexAttribI4i(index, x, y, z, w);
    }

    public static void glVertexAttribI4u(int index, java.nio.ByteBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4ubv(index, v);
    }

    public static void glVertexAttribI4u(int index, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4uiv(index, v);
    }

    public static void glVertexAttribI4u(int index, java.nio.ShortBuffer v) {
        org.lwjgl.opengl.GL30.glVertexAttribI4usv(index, v);
    }

    public static void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
        org.lwjgl.opengl.GL30.glVertexAttribI4ui(index, x, y, z, w);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, long buffer_buffer_offset) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(index, size, type, stride, buffer_buffer_offset);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, java.nio.ByteBuffer buffer) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(index, size, type, stride, buffer);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, java.nio.IntBuffer buffer) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(index, size, type, stride, buffer);
    }

    public static void glVertexAttribIPointer(int index, int size, int type, int stride, java.nio.ShortBuffer buffer) {
        org.lwjgl.opengl.GL30.glVertexAttribIPointer(index, size, type, stride, buffer);
    }
}
