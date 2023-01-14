package org.lwjglx.opengl;

public class GL11 {
    public static void glAccum(int op, float value) {
        org.lwjgl.opengl.GL11.glAccum(op, value);
    }

    public static void glAlphaFunc(int func, float ref) {
        org.lwjgl.opengl.GL11.glAlphaFunc(func, ref);
    }

    public static boolean glAreTexturesResident(java.nio.IntBuffer textures, java.nio.ByteBuffer residences) {
        return org.lwjgl.opengl.GL11.glAreTexturesResident(textures, residences);
    }

    public static void glArrayElement(int i) {
        org.lwjgl.opengl.GL11.glArrayElement(i);
    }

    public static void glBegin(int mode) {
        org.lwjgl.opengl.GL11.glBegin(mode);
    }

    public static void glBindTexture(int target, int texture) {
        org.lwjgl.opengl.GL11.glBindTexture(target, texture);
    }

    public static void glBitmap(
            int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset) {
        org.lwjgl.opengl.GL11.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap_buffer_offset);
    }

    public static void glBitmap(
            int width, int height, float xorig, float yorig, float xmove, float ymove, java.nio.ByteBuffer bitmap) {
        org.lwjgl.opengl.GL11.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
    }

    public static void glBlendFunc(int sfactor, int dfactor) {
        org.lwjgl.opengl.GL11.glBlendFunc(sfactor, dfactor);
    }

    public static void glCallList(int list) {
        org.lwjgl.opengl.GL11.glCallList(list);
    }

    public static void glCallLists(java.nio.ByteBuffer lists) {
        org.lwjgl.opengl.GL11.glCallLists(lists);
    }

    public static void glCallLists(java.nio.IntBuffer lists) {
        org.lwjgl.opengl.GL11.glCallLists(lists);
    }

    public static void glCallLists(java.nio.ShortBuffer lists) {
        org.lwjgl.opengl.GL11.glCallLists(lists);
    }

    public static void glClear(int mask) {
        org.lwjgl.opengl.GL11.glClear(mask);
    }

    public static void glClearAccum(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.GL11.glClearAccum(red, green, blue, alpha);
    }

    public static void glClearColor(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.GL11.glClearColor(red, green, blue, alpha);
    }

    public static void glClearDepth(double depth) {
        org.lwjgl.opengl.GL11.glClearDepth(depth);
    }

    public static void glClearStencil(int s) {
        org.lwjgl.opengl.GL11.glClearStencil(s);
    }

    public static void glClipPlane(int plane, java.nio.DoubleBuffer equation) {
        org.lwjgl.opengl.GL11.glClipPlane(plane, equation);
    }

    public static void glColor3b(byte red, byte green, byte blue) {
        org.lwjgl.opengl.GL11.glColor3b(red, green, blue);
    }

    public static void glColor3d(double red, double green, double blue) {
        org.lwjgl.opengl.GL11.glColor3d(red, green, blue);
    }

    public static void glColor3f(float red, float green, float blue) {
        org.lwjgl.opengl.GL11.glColor3f(red, green, blue);
    }

    public static void glColor3ub(byte red, byte green, byte blue) {
        org.lwjgl.opengl.GL11.glColor3ub(red, green, blue);
    }

    public static void glColor4b(byte red, byte green, byte blue, byte alpha) {
        org.lwjgl.opengl.GL11.glColor4b(red, green, blue, alpha);
    }

    public static void glColor4d(double red, double green, double blue, double alpha) {
        org.lwjgl.opengl.GL11.glColor4d(red, green, blue, alpha);
    }

    public static void glColor4f(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.GL11.glColor4f(red, green, blue, alpha);
    }

    public static void glColor4ub(byte red, byte green, byte blue, byte alpha) {
        org.lwjgl.opengl.GL11.glColor4ub(red, green, blue, alpha);
    }

    public static void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
        org.lwjgl.opengl.GL11.glColorMask(red, green, blue, alpha);
    }

    public static void glColorMaterial(int face, int mode) {
        org.lwjgl.opengl.GL11.glColorMaterial(face, mode);
    }

    public static void glColorPointer(int size, int type, int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glColorPointer(size, type, stride, pointer_buffer_offset);
    }

    public static void glColorPointer(int size, int type, int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glColorPointer(size, type, stride, pointer);
    }

    public static void glColorPointer(int size, int stride, java.nio.DoubleBuffer pointer) {

        org.lwjgl.opengl.GL11.glColorPointer(
                size,
                org.lwjgl.opengl.GL11.GL_DOUBLE,
                stride,
                me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pointer));
    }

    public static void glColorPointer(int size, int stride, java.nio.FloatBuffer pointer) {

        org.lwjgl.opengl.GL11.glColorPointer(size, org.lwjgl.opengl.GL11.GL_FLOAT, stride, pointer);
    }

    public static void glColorPointer(int size, boolean unsigned, int stride, java.nio.ByteBuffer pointer) {

        org.lwjgl.opengl.GL11.glColorPointer(
                size,
                (unsigned ? org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE : org.lwjgl.opengl.GL11.GL_BYTE),
                stride,
                org.lwjglx.MemoryUtil.getAddress(pointer));
    }

    public static void glCopyPixels(int x, int y, int width, int height, int type) {
        org.lwjgl.opengl.GL11.glCopyPixels(x, y, width, height, type);
    }

    public static void glCopyTexImage1D(
            int target, int level, int internalFormat, int x, int y, int width, int border) {
        org.lwjgl.opengl.GL11.glCopyTexImage1D(target, level, internalFormat, x, y, width, border);
    }

    public static void glCopyTexImage2D(
            int target, int level, int internalFormat, int x, int y, int width, int height, int border) {
        org.lwjgl.opengl.GL11.glCopyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    }

    public static void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
        org.lwjgl.opengl.GL11.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
    }

    public static void glCopyTexSubImage2D(
            int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
        org.lwjgl.opengl.GL11.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
    }

    public static void glCullFace(int mode) {
        org.lwjgl.opengl.GL11.glCullFace(mode);
    }

    public static void glDeleteLists(int list, int range) {
        org.lwjgl.opengl.GL11.glDeleteLists(list, range);
    }

    public static void glDeleteTextures(int texture) {
        org.lwjgl.opengl.GL11.glDeleteTextures(texture);
    }

    public static void glDeleteTextures(java.nio.IntBuffer textures) {
        org.lwjgl.opengl.GL11.glDeleteTextures(textures);
    }

    public static void glDepthFunc(int func) {
        org.lwjgl.opengl.GL11.glDepthFunc(func);
    }

    public static void glDepthMask(boolean flag) {
        org.lwjgl.opengl.GL11.glDepthMask(flag);
    }

    public static void glDepthRange(double zNear, double zFar) {
        org.lwjgl.opengl.GL11.glDepthRange(zNear, zFar);
    }

    public static void glDisable(int cap) {
        org.lwjgl.opengl.GL11.glDisable(cap);
    }

    public static void glDisableClientState(int cap) {
        org.lwjgl.opengl.GL11.glDisableClientState(cap);
    }

    public static void glDrawArrays(int mode, int first, int count) {
        org.lwjgl.opengl.GL11.glDrawArrays(mode, first, count);
    }

    public static void glDrawBuffer(int mode) {
        org.lwjgl.opengl.GL11.glDrawBuffer(mode);
    }

    public static void glDrawElements(int mode, int indices_count, int type, long indices_buffer_offset) {
        org.lwjgl.opengl.GL11.glDrawElements(mode, indices_count, type, indices_buffer_offset);
    }

    public static void glDrawElements(int mode, int count, int type, java.nio.ByteBuffer indices) {

        org.lwjgl.opengl.GL11.glDrawElements(mode, count, type, org.lwjglx.MemoryUtil.getAddress(indices));
    }

    public static void glDrawElements(int mode, java.nio.ByteBuffer indices) {
        org.lwjgl.opengl.GL11.glDrawElements(mode, indices);
    }

    public static void glDrawElements(int mode, java.nio.IntBuffer indices) {
        org.lwjgl.opengl.GL11.glDrawElements(mode, indices);
    }

    public static void glDrawElements(int mode, java.nio.ShortBuffer indices) {
        org.lwjgl.opengl.GL11.glDrawElements(mode, indices);
    }

    public static void glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glDrawPixels(width, height, format, type, pixels_buffer_offset);
    }

    public static void glDrawPixels(int width, int height, int format, int type, java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glDrawPixels(width, height, format, type, pixels);
    }

    public static void glDrawPixels(int width, int height, int format, int type, java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glDrawPixels(width, height, format, type, pixels);
    }

    public static void glDrawPixels(int width, int height, int format, int type, java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glDrawPixels(width, height, format, type, pixels);
    }

    public static void glEdgeFlag(boolean flag) {
        org.lwjgl.opengl.GL11.glEdgeFlag(flag);
    }

    public static void glEdgeFlagPointer(int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glEdgeFlagPointer(stride, pointer_buffer_offset);
    }

    public static void glEdgeFlagPointer(int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glEdgeFlagPointer(stride, pointer);
    }

    public static void glEnable(int cap) {
        org.lwjgl.opengl.GL11.glEnable(cap);
    }

    public static void glEnableClientState(int cap) {
        org.lwjgl.opengl.GL11.glEnableClientState(cap);
    }

    public static void glEnd() {
        org.lwjgl.opengl.GL11.glEnd();
    }

    public static void glEndList() {
        org.lwjgl.opengl.GL11.glEndList();
    }

    public static void glEvalCoord1d(double u) {
        org.lwjgl.opengl.GL11.glEvalCoord1d(u);
    }

    public static void glEvalCoord1f(float u) {
        org.lwjgl.opengl.GL11.glEvalCoord1f(u);
    }

    public static void glEvalCoord2d(double u, double v) {
        org.lwjgl.opengl.GL11.glEvalCoord2d(u, v);
    }

    public static void glEvalCoord2f(float u, float v) {
        org.lwjgl.opengl.GL11.glEvalCoord2f(u, v);
    }

    public static void glEvalMesh1(int mode, int i1, int i2) {
        org.lwjgl.opengl.GL11.glEvalMesh1(mode, i1, i2);
    }

    public static void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
        org.lwjgl.opengl.GL11.glEvalMesh2(mode, i1, i2, j1, j2);
    }

    public static void glEvalPoint1(int i) {
        org.lwjgl.opengl.GL11.glEvalPoint1(i);
    }

    public static void glEvalPoint2(int i, int j) {
        org.lwjgl.opengl.GL11.glEvalPoint2(i, j);
    }

    public static void glFeedbackBuffer(int type, java.nio.FloatBuffer buffer) {
        org.lwjgl.opengl.GL11.glFeedbackBuffer(type, buffer);
    }

    public static void glFinish() {
        org.lwjgl.opengl.GL11.glFinish();
    }

    public static void glFlush() {
        org.lwjgl.opengl.GL11.glFlush();
    }

    public static void glFog(int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glFogfv(pname, params);
    }

    public static void glFog(int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glFogiv(pname, params);
    }

    public static void glFogf(int pname, float param) {
        org.lwjgl.opengl.GL11.glFogf(pname, param);
    }

    public static void glFogi(int pname, int param) {
        org.lwjgl.opengl.GL11.glFogi(pname, param);
    }

    public static void glFrontFace(int mode) {
        org.lwjgl.opengl.GL11.glFrontFace(mode);
    }

    public static void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
        org.lwjgl.opengl.GL11.glFrustum(left, right, bottom, top, zNear, zFar);
    }

    public static int glGenLists(int range) {
        return org.lwjgl.opengl.GL11.glGenLists(range);
    }

    public static int glGenTextures() {
        return org.lwjgl.opengl.GL11.glGenTextures();
    }

    public static void glGenTextures(java.nio.IntBuffer textures) {
        org.lwjgl.opengl.GL11.glGenTextures(textures);
    }

    public static boolean glGetBoolean(int pname) {
        return org.lwjgl.opengl.GL11.glGetBoolean(pname);
    }

    public static void glGetBoolean(int pname, java.nio.ByteBuffer params) {
        org.lwjgl.opengl.GL11.glGetBooleanv(pname, params);
    }

    public static void glGetClipPlane(int plane, java.nio.DoubleBuffer equation) {
        org.lwjgl.opengl.GL11.glGetClipPlane(plane, equation);
    }

    public static double glGetDouble(int pname) {
        return org.lwjgl.opengl.GL11.glGetDouble(pname);
    }

    public static void glGetDouble(int pname, java.nio.DoubleBuffer params) {
        org.lwjgl.opengl.GL11.glGetDoublev(pname, params);
    }

    public static int glGetError() {
        return org.lwjgl.opengl.GL11.glGetError();
    }

    public static float glGetFloat(int pname) {
        return org.lwjgl.opengl.GL11.glGetFloat(pname);
    }

    public static void glGetFloat(int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetFloatv(pname, params);
    }

    public static int glGetInteger(int pname) {
        return org.lwjgl.opengl.GL11.glGetInteger(pname);
    }

    public static void glGetInteger(int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetIntegerv(pname, params);
    }

    public static void glGetLight(int light, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetLightfv(light, pname, params);
    }

    public static void glGetLight(int light, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetLightiv(light, pname, params);
    }

    public static void glGetMap(int target, int query, java.nio.DoubleBuffer v) {
        org.lwjgl.opengl.GL11.glGetMapdv(target, query, v);
    }

    public static void glGetMap(int target, int query, java.nio.FloatBuffer v) {
        org.lwjgl.opengl.GL11.glGetMapfv(target, query, v);
    }

    public static void glGetMap(int target, int query, java.nio.IntBuffer v) {
        org.lwjgl.opengl.GL11.glGetMapiv(target, query, v);
    }

    public static void glGetMaterial(int face, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetMaterialfv(face, pname, params);
    }

    public static void glGetMaterial(int face, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetMaterialiv(face, pname, params);
    }

    public static void glGetPixelMap(int map, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL11.glGetPixelMapfv(map, values);
    }

    public static void glGetPixelMapfv(int map, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glGetPixelMapfv(map, values_buffer_offset);
    }

    public static void glGetPixelMapu(int map, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL11.glGetPixelMapuiv(map, values);
    }

    public static void glGetPixelMapu(int map, java.nio.ShortBuffer values) {
        org.lwjgl.opengl.GL11.glGetPixelMapusv(map, values);
    }

    public static void glGetPixelMapuiv(int map, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glGetPixelMapuiv(map, values_buffer_offset);
    }

    public static void glGetPixelMapusv(int map, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glGetPixelMapusv(map, values_buffer_offset);
    }

    public static void glGetPolygonStipple(long mask_buffer_offset) {
        org.lwjgl.opengl.GL11.glGetPolygonStipple(mask_buffer_offset);
    }

    public static void glGetPolygonStipple(java.nio.ByteBuffer mask) {
        org.lwjgl.opengl.GL11.glGetPolygonStipple(mask);
    }

    public static java.lang.String glGetString(int name) {
        return org.lwjgl.opengl.GL11.glGetString(name);
    }

    public static void glGetTexEnv(int coord, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexEnvfv(coord, pname, params);
    }

    public static void glGetTexEnv(int coord, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexEnviv(coord, pname, params);
    }

    public static float glGetTexEnvf(int coord, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexEnvf(coord, pname);
    }

    public static int glGetTexEnvi(int coord, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexEnvi(coord, pname);
    }

    public static void glGetTexGen(int coord, int pname, java.nio.DoubleBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexGendv(coord, pname, params);
    }

    public static void glGetTexGen(int coord, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexGenfv(coord, pname, params);
    }

    public static void glGetTexGen(int coord, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexGeniv(coord, pname, params);
    }

    public static double glGetTexGend(int coord, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexGend(coord, pname);
    }

    public static float glGetTexGenf(int coord, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexGenf(coord, pname);
    }

    public static int glGetTexGeni(int coord, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexGeni(coord, pname);
    }

    public static void glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels_buffer_offset);
    }

    public static void glGetTexImage(int target, int level, int format, int type, java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels);
    }

    public static void glGetTexImage(int target, int level, int format, int type, java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels);
    }

    public static void glGetTexImage(int target, int level, int format, int type, java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels);
    }

    public static void glGetTexImage(int target, int level, int format, int type, java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels);
    }

    public static void glGetTexImage(int target, int level, int format, int type, java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glGetTexImage(target, level, format, type, pixels);
    }

    public static void glGetTexLevelParameter(int target, int level, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexLevelParameterfv(target, level, pname, params);
    }

    public static void glGetTexLevelParameter(int target, int level, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexLevelParameteriv(target, level, pname, params);
    }

    public static float glGetTexLevelParameterf(int target, int level, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexLevelParameterf(target, level, pname);
    }

    public static int glGetTexLevelParameteri(int target, int level, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexLevelParameteri(target, level, pname);
    }

    public static void glGetTexParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexParameterfv(target, pname, params);
    }

    public static void glGetTexParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glGetTexParameteriv(target, pname, params);
    }

    public static float glGetTexParameterf(int target, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexParameterf(target, pname);
    }

    public static int glGetTexParameteri(int target, int pname) {
        return org.lwjgl.opengl.GL11.glGetTexParameteri(target, pname);
    }

    public static void glHint(int target, int mode) {
        org.lwjgl.opengl.GL11.glHint(target, mode);
    }

    public static void glInitNames() {
        org.lwjgl.opengl.GL11.glInitNames();
    }

    public static void glInterleavedArrays(int format, int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer_buffer_offset);
    }

    public static void glInterleavedArrays(int format, int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer);
    }

    public static void glInterleavedArrays(int format, int stride, java.nio.DoubleBuffer pointer) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer);
    }

    public static void glInterleavedArrays(int format, int stride, java.nio.FloatBuffer pointer) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer);
    }

    public static void glInterleavedArrays(int format, int stride, java.nio.IntBuffer pointer) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer);
    }

    public static void glInterleavedArrays(int format, int stride, java.nio.ShortBuffer pointer) {
        org.lwjgl.opengl.GL11.glInterleavedArrays(format, stride, pointer);
    }

    public static boolean glIsEnabled(int cap) {
        return org.lwjgl.opengl.GL11.glIsEnabled(cap);
    }

    public static boolean glIsList(int list) {
        return org.lwjgl.opengl.GL11.glIsList(list);
    }

    public static boolean glIsTexture(int texture) {
        return org.lwjgl.opengl.GL11.glIsTexture(texture);
    }

    public static void glLight(int light, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glLightfv(light, pname, params);
    }

    public static void glLight(int light, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glLightiv(light, pname, params);
    }

    public static void glLightModel(int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glLightModelfv(pname, params);
    }

    public static void glLightModel(int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glLightModeliv(pname, params);
    }

    public static void glLightModelf(int pname, float param) {
        org.lwjgl.opengl.GL11.glLightModelf(pname, param);
    }

    public static void glLightModeli(int pname, int param) {
        org.lwjgl.opengl.GL11.glLightModeli(pname, param);
    }

    public static void glLightf(int light, int pname, float param) {
        org.lwjgl.opengl.GL11.glLightf(light, pname, param);
    }

    public static void glLighti(int light, int pname, int param) {
        org.lwjgl.opengl.GL11.glLighti(light, pname, param);
    }

    public static void glLineStipple(int factor, short pattern) {
        org.lwjgl.opengl.GL11.glLineStipple(factor, pattern);
    }

    public static void glLineWidth(float width) {
        org.lwjgl.opengl.GL11.glLineWidth(width);
    }

    public static void glListBase(int base) {
        org.lwjgl.opengl.GL11.glListBase(base);
    }

    public static void glLoadIdentity() {
        org.lwjgl.opengl.GL11.glLoadIdentity();
    }

    public static void glLoadMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL11.glLoadMatrixd(m);
    }

    public static void glLoadMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL11.glLoadMatrixf(m);
    }

    public static void glLoadName(int name) {
        org.lwjgl.opengl.GL11.glLoadName(name);
    }

    public static void glLogicOp(int opcode) {
        org.lwjgl.opengl.GL11.glLogicOp(opcode);
    }

    public static void glMap1d(int target, double u1, double u2, int stride, int order, java.nio.DoubleBuffer points) {
        org.lwjgl.opengl.GL11.glMap1d(target, u1, u2, stride, order, points);
    }

    public static void glMap1f(int target, float u1, float u2, int stride, int order, java.nio.FloatBuffer points) {
        org.lwjgl.opengl.GL11.glMap1f(target, u1, u2, stride, order, points);
    }

    public static void glMap2d(
            int target,
            double u1,
            double u2,
            int ustride,
            int uorder,
            double v1,
            double v2,
            int vstride,
            int vorder,
            java.nio.DoubleBuffer points) {
        org.lwjgl.opengl.GL11.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
    }

    public static void glMap2f(
            int target,
            float u1,
            float u2,
            int ustride,
            int uorder,
            float v1,
            float v2,
            int vstride,
            int vorder,
            java.nio.FloatBuffer points) {
        org.lwjgl.opengl.GL11.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
    }

    public static void glMapGrid1d(int un, double u1, double u2) {
        org.lwjgl.opengl.GL11.glMapGrid1d(un, u1, u2);
    }

    public static void glMapGrid1f(int un, float u1, float u2) {
        org.lwjgl.opengl.GL11.glMapGrid1f(un, u1, u2);
    }

    public static void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
        org.lwjgl.opengl.GL11.glMapGrid2d(un, u1, u2, vn, v1, v2);
    }

    public static void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
        org.lwjgl.opengl.GL11.glMapGrid2f(un, u1, u2, vn, v1, v2);
    }

    public static void glMaterial(int face, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glMaterialfv(face, pname, params);
    }

    public static void glMaterial(int face, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glMaterialiv(face, pname, params);
    }

    public static void glMaterialf(int face, int pname, float param) {
        org.lwjgl.opengl.GL11.glMaterialf(face, pname, param);
    }

    public static void glMateriali(int face, int pname, int param) {
        org.lwjgl.opengl.GL11.glMateriali(face, pname, param);
    }

    public static void glMatrixMode(int mode) {
        org.lwjgl.opengl.GL11.glMatrixMode(mode);
    }

    public static void glMultMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL11.glMultMatrixd(m);
    }

    public static void glMultMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL11.glMultMatrixf(m);
    }

    public static void glNewList(int list, int mode) {
        org.lwjgl.opengl.GL11.glNewList(list, mode);
    }

    public static void glNormal3b(byte nx, byte ny, byte nz) {
        org.lwjgl.opengl.GL11.glNormal3b(nx, ny, nz);
    }

    public static void glNormal3d(double nx, double ny, double nz) {
        org.lwjgl.opengl.GL11.glNormal3d(nx, ny, nz);
    }

    public static void glNormal3f(float nx, float ny, float nz) {
        org.lwjgl.opengl.GL11.glNormal3f(nx, ny, nz);
    }

    public static void glNormal3i(int nx, int ny, int nz) {
        org.lwjgl.opengl.GL11.glNormal3i(nx, ny, nz);
    }

    public static void glNormalPointer(int type, int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glNormalPointer(type, stride, pointer_buffer_offset);
    }

    public static void glNormalPointer(int type, int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glNormalPointer(type, stride, pointer);
    }

    public static void glNormalPointer(int stride, java.nio.ByteBuffer pointer) {

        org.lwjgl.opengl.GL11.glNormalPointer(org.lwjgl.opengl.GL11.GL_BYTE, stride, pointer);
    }

    public static void glNormalPointer(int stride, java.nio.DoubleBuffer pointer) {

        org.lwjgl.opengl.GL11.glNormalPointer(
                org.lwjgl.opengl.GL11.GL_DOUBLE, stride, me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pointer));
    }

    public static void glNormalPointer(int stride, java.nio.FloatBuffer pointer) {

        org.lwjgl.opengl.GL11.glNormalPointer(org.lwjgl.opengl.GL11.GL_FLOAT, stride, pointer);
    }

    public static void glNormalPointer(int stride, java.nio.IntBuffer pointer) {

        org.lwjgl.opengl.GL11.glNormalPointer(org.lwjgl.opengl.GL11.GL_INT, stride, pointer);
    }

    public static void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
        org.lwjgl.opengl.GL11.glOrtho(left, right, bottom, top, zNear, zFar);
    }

    public static void glPassThrough(float token) {
        org.lwjgl.opengl.GL11.glPassThrough(token);
    }

    public static void glPixelMap(int map, java.nio.FloatBuffer values) {
        org.lwjgl.opengl.GL11.glPixelMapfv(map, values);
    }

    public static void glPixelMapfv(int map, int values_mapsize, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glPixelMapfv(map, values_mapsize, values_buffer_offset);
    }

    public static void glPixelMapu(int map, java.nio.IntBuffer values) {
        org.lwjgl.opengl.GL11.glPixelMapuiv(map, values);
    }

    public static void glPixelMapu(int map, java.nio.ShortBuffer values) {
        org.lwjgl.opengl.GL11.glPixelMapusv(map, values);
    }

    public static void glPixelMapuiv(int map, int values_mapsize, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glPixelMapuiv(map, values_mapsize, values_buffer_offset);
    }

    public static void glPixelMapusv(int map, int values_mapsize, long values_buffer_offset) {
        org.lwjgl.opengl.GL11.glPixelMapusv(map, values_mapsize, values_buffer_offset);
    }

    public static void glPixelStoref(int pname, float param) {
        org.lwjgl.opengl.GL11.glPixelStoref(pname, param);
    }

    public static void glPixelStorei(int pname, int param) {
        org.lwjgl.opengl.GL11.glPixelStorei(pname, param);
    }

    public static void glPixelTransferf(int pname, float param) {
        org.lwjgl.opengl.GL11.glPixelTransferf(pname, param);
    }

    public static void glPixelTransferi(int pname, int param) {
        org.lwjgl.opengl.GL11.glPixelTransferi(pname, param);
    }

    public static void glPixelZoom(float xfactor, float yfactor) {
        org.lwjgl.opengl.GL11.glPixelZoom(xfactor, yfactor);
    }

    public static void glPointSize(float size) {
        org.lwjgl.opengl.GL11.glPointSize(size);
    }

    public static void glPolygonMode(int face, int mode) {
        org.lwjgl.opengl.GL11.glPolygonMode(face, mode);
    }

    public static void glPolygonOffset(float factor, float units) {
        org.lwjgl.opengl.GL11.glPolygonOffset(factor, units);
    }

    public static void glPolygonStipple(long mask_buffer_offset) {
        org.lwjgl.opengl.GL11.glPolygonStipple(mask_buffer_offset);
    }

    public static void glPolygonStipple(java.nio.ByteBuffer mask) {
        org.lwjgl.opengl.GL11.glPolygonStipple(mask);
    }

    public static void glPopAttrib() {
        org.lwjgl.opengl.GL11.glPopAttrib();
    }

    public static void glPopClientAttrib() {
        org.lwjgl.opengl.GL11.glPopClientAttrib();
    }

    public static void glPopMatrix() {
        org.lwjgl.opengl.GL11.glPopMatrix();
    }

    public static void glPopName() {
        org.lwjgl.opengl.GL11.glPopName();
    }

    public static void glPrioritizeTextures(java.nio.IntBuffer textures, java.nio.FloatBuffer priorities) {
        org.lwjgl.opengl.GL11.glPrioritizeTextures(textures, priorities);
    }

    public static void glPushAttrib(int mask) {
        org.lwjgl.opengl.GL11.glPushAttrib(mask);
    }

    public static void glPushClientAttrib(int mask) {
        org.lwjgl.opengl.GL11.glPushClientAttrib(mask);
    }

    public static void glPushMatrix() {
        org.lwjgl.opengl.GL11.glPushMatrix();
    }

    public static void glPushName(int name) {
        org.lwjgl.opengl.GL11.glPushName(name);
    }

    public static void glRasterPos2d(double x, double y) {
        org.lwjgl.opengl.GL11.glRasterPos2d(x, y);
    }

    public static void glRasterPos2f(float x, float y) {
        org.lwjgl.opengl.GL11.glRasterPos2f(x, y);
    }

    public static void glRasterPos2i(int x, int y) {
        org.lwjgl.opengl.GL11.glRasterPos2i(x, y);
    }

    public static void glRasterPos3d(double x, double y, double z) {
        org.lwjgl.opengl.GL11.glRasterPos3d(x, y, z);
    }

    public static void glRasterPos3f(float x, float y, float z) {
        org.lwjgl.opengl.GL11.glRasterPos3f(x, y, z);
    }

    public static void glRasterPos3i(int x, int y, int z) {
        org.lwjgl.opengl.GL11.glRasterPos3i(x, y, z);
    }

    public static void glRasterPos4d(double x, double y, double z, double w) {
        org.lwjgl.opengl.GL11.glRasterPos4d(x, y, z, w);
    }

    public static void glRasterPos4f(float x, float y, float z, float w) {
        org.lwjgl.opengl.GL11.glRasterPos4f(x, y, z, w);
    }

    public static void glRasterPos4i(int x, int y, int z, int w) {
        org.lwjgl.opengl.GL11.glRasterPos4i(x, y, z, w);
    }

    public static void glReadBuffer(int mode) {
        org.lwjgl.opengl.GL11.glReadBuffer(mode);
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels_buffer_offset);
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, java.nio.DoubleBuffer pixels) {

        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, org.lwjglx.MemoryUtil.getAddress(pixels));
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glReadPixels(
            int x, int y, int width, int height, int format, int type, java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glReadPixels(x, y, width, height, format, type, pixels);
    }

    public static void glRectd(double x1, double y1, double x2, double y2) {
        org.lwjgl.opengl.GL11.glRectd(x1, y1, x2, y2);
    }

    public static void glRectf(float x1, float y1, float x2, float y2) {
        org.lwjgl.opengl.GL11.glRectf(x1, y1, x2, y2);
    }

    public static void glRecti(int x1, int y1, int x2, int y2) {
        org.lwjgl.opengl.GL11.glRecti(x1, y1, x2, y2);
    }

    public static int glRenderMode(int mode) {
        return org.lwjgl.opengl.GL11.glRenderMode(mode);
    }

    public static void glRotated(double angle, double x, double y, double z) {
        org.lwjgl.opengl.GL11.glRotated(angle, x, y, z);
    }

    public static void glRotatef(float angle, float x, float y, float z) {
        org.lwjgl.opengl.GL11.glRotatef(angle, x, y, z);
    }

    public static void glScaled(double x, double y, double z) {
        org.lwjgl.opengl.GL11.glScaled(x, y, z);
    }

    public static void glScalef(float x, float y, float z) {
        org.lwjgl.opengl.GL11.glScalef(x, y, z);
    }

    public static void glScissor(int x, int y, int width, int height) {
        org.lwjgl.opengl.GL11.glScissor(x, y, width, height);
    }

    public static void glSelectBuffer(java.nio.IntBuffer buffer) {
        org.lwjgl.opengl.GL11.glSelectBuffer(buffer);
    }

    public static void glShadeModel(int mode) {
        org.lwjgl.opengl.GL11.glShadeModel(mode);
    }

    public static void glStencilFunc(int func, int ref, int mask) {
        org.lwjgl.opengl.GL11.glStencilFunc(func, ref, mask);
    }

    public static void glStencilMask(int mask) {
        org.lwjgl.opengl.GL11.glStencilMask(mask);
    }

    public static void glStencilOp(int fail, int zfail, int zpass) {
        org.lwjgl.opengl.GL11.glStencilOp(fail, zfail, zpass);
    }

    public static void glTexCoord1d(double s) {
        org.lwjgl.opengl.GL11.glTexCoord1d(s);
    }

    public static void glTexCoord1f(float s) {
        org.lwjgl.opengl.GL11.glTexCoord1f(s);
    }

    public static void glTexCoord2d(double s, double t) {
        org.lwjgl.opengl.GL11.glTexCoord2d(s, t);
    }

    public static void glTexCoord2f(float s, float t) {
        org.lwjgl.opengl.GL11.glTexCoord2f(s, t);
    }

    public static void glTexCoord3d(double s, double t, double r) {
        org.lwjgl.opengl.GL11.glTexCoord3d(s, t, r);
    }

    public static void glTexCoord3f(float s, float t, float r) {
        org.lwjgl.opengl.GL11.glTexCoord3f(s, t, r);
    }

    public static void glTexCoord4d(double s, double t, double r, double q) {
        org.lwjgl.opengl.GL11.glTexCoord4d(s, t, r, q);
    }

    public static void glTexCoord4f(float s, float t, float r, float q) {
        org.lwjgl.opengl.GL11.glTexCoord4f(s, t, r, q);
    }

    public static void glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glTexCoordPointer(size, type, stride, pointer_buffer_offset);
    }

    public static void glTexCoordPointer(int size, int type, int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glTexCoordPointer(size, type, stride, pointer);
    }

    public static void glTexCoordPointer(int size, int stride, java.nio.DoubleBuffer pointer) {

        org.lwjgl.opengl.GL11.glTexCoordPointer(
                size,
                org.lwjgl.opengl.GL11.GL_DOUBLE,
                stride,
                me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pointer));
    }

    public static void glTexCoordPointer(int size, int stride, java.nio.FloatBuffer pointer) {

        org.lwjgl.opengl.GL11.glTexCoordPointer(size, org.lwjgl.opengl.GL11.GL_FLOAT, stride, pointer);
    }

    public static void glTexCoordPointer(int size, int stride, java.nio.IntBuffer pointer) {

        org.lwjgl.opengl.GL11.glTexCoordPointer(size, org.lwjgl.opengl.GL11.GL_INT, stride, pointer);
    }

    public static void glTexCoordPointer(int size, int stride, java.nio.ShortBuffer pointer) {

        org.lwjgl.opengl.GL11.glTexCoordPointer(size, org.lwjgl.opengl.GL11.GL_SHORT, stride, pointer);
    }

    public static void glTexEnv(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glTexEnvfv(target, pname, params);
    }

    public static void glTexEnv(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glTexEnviv(target, pname, params);
    }

    public static void glTexEnvf(int target, int pname, float param) {
        org.lwjgl.opengl.GL11.glTexEnvf(target, pname, param);
    }

    public static void glTexEnvi(int target, int pname, int param) {
        org.lwjgl.opengl.GL11.glTexEnvi(target, pname, param);
    }

    public static void glTexGen(int coord, int pname, java.nio.DoubleBuffer params) {
        org.lwjgl.opengl.GL11.glTexGendv(coord, pname, params);
    }

    public static void glTexGen(int coord, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.GL11.glTexGenfv(coord, pname, params);
    }

    public static void glTexGen(int coord, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL11.glTexGeniv(coord, pname, params);
    }

    public static void glTexGend(int coord, int pname, double param) {
        org.lwjgl.opengl.GL11.glTexGend(coord, pname, param);
    }

    public static void glTexGenf(int coord, int pname, float param) {
        org.lwjgl.opengl.GL11.glTexGenf(coord, pname, param);
    }

    public static void glTexGeni(int coord, int pname, int param) {
        org.lwjgl.opengl.GL11.glTexGeni(coord, pname, param);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glTexImage1D(
                target, level, internalformat, width, border, format, type, pixels_buffer_offset);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int format,
            int type,
            java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glTexImage2D(
                target, level, internalformat, width, height, border, format, type, pixels_buffer_offset);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int format,
            int type,
            java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
    }

    public static void glTexParameter(int target, int pname, java.nio.FloatBuffer param) {
        org.lwjgl.opengl.GL11.glTexParameterfv(target, pname, param);
    }

    public static void glTexParameter(int target, int pname, java.nio.IntBuffer param) {
        org.lwjgl.opengl.GL11.glTexParameteriv(target, pname, param);
    }

    public static void glTexParameterf(int target, int pname, float param) {
        org.lwjgl.opengl.GL11.glTexParameterf(target, pname, param);
    }

    public static void glTexParameteri(int target, int pname, int param) {
        org.lwjgl.opengl.GL11.glTexParameteri(target, pname, param);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels_buffer_offset);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int type, java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            long pixels_buffer_offset) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(
                target, level, xoffset, yoffset, width, height, format, type, pixels_buffer_offset);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer pixels) {
        org.lwjgl.opengl.GL11.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
    }

    public static void glTranslated(double x, double y, double z) {
        org.lwjgl.opengl.GL11.glTranslated(x, y, z);
    }

    public static void glTranslatef(float x, float y, float z) {
        org.lwjgl.opengl.GL11.glTranslatef(x, y, z);
    }

    public static void glVertex2d(double x, double y) {
        org.lwjgl.opengl.GL11.glVertex2d(x, y);
    }

    public static void glVertex2f(float x, float y) {
        org.lwjgl.opengl.GL11.glVertex2f(x, y);
    }

    public static void glVertex2i(int x, int y) {
        org.lwjgl.opengl.GL11.glVertex2i(x, y);
    }

    public static void glVertex3d(double x, double y, double z) {
        org.lwjgl.opengl.GL11.glVertex3d(x, y, z);
    }

    public static void glVertex3f(float x, float y, float z) {
        org.lwjgl.opengl.GL11.glVertex3f(x, y, z);
    }

    public static void glVertex3i(int x, int y, int z) {
        org.lwjgl.opengl.GL11.glVertex3i(x, y, z);
    }

    public static void glVertex4d(double x, double y, double z, double w) {
        org.lwjgl.opengl.GL11.glVertex4d(x, y, z, w);
    }

    public static void glVertex4f(float x, float y, float z, float w) {
        org.lwjgl.opengl.GL11.glVertex4f(x, y, z, w);
    }

    public static void glVertex4i(int x, int y, int z, int w) {
        org.lwjgl.opengl.GL11.glVertex4i(x, y, z, w);
    }

    public static void glVertexPointer(int size, int type, int stride, long pointer_buffer_offset) {
        org.lwjgl.opengl.GL11.glVertexPointer(size, type, stride, pointer_buffer_offset);
    }

    public static void glVertexPointer(int size, int type, int stride, java.nio.ByteBuffer pointer) {
        org.lwjgl.opengl.GL11.glVertexPointer(size, type, stride, pointer);
    }

    public static void glVertexPointer(int size, int stride, java.nio.DoubleBuffer pointer) {

        org.lwjgl.opengl.GL11.glVertexPointer(
                size,
                org.lwjgl.opengl.GL11.GL_DOUBLE,
                stride,
                me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(pointer));
    }

    public static void glVertexPointer(int size, int stride, java.nio.FloatBuffer pointer) {

        org.lwjgl.opengl.GL11.glVertexPointer(size, org.lwjgl.opengl.GL11.GL_FLOAT, stride, pointer);
    }

    public static void glVertexPointer(int size, int stride, java.nio.IntBuffer pointer) {

        org.lwjgl.opengl.GL11.glVertexPointer(size, org.lwjgl.opengl.GL11.GL_INT, stride, pointer);
    }

    public static void glVertexPointer(int size, int stride, java.nio.ShortBuffer pointer) {

        org.lwjgl.opengl.GL11.glVertexPointer(size, org.lwjgl.opengl.GL11.GL_SHORT, stride, pointer);
    }

    public static void glViewport(int x, int y, int width, int height) {
        org.lwjgl.opengl.GL11.glViewport(x, y, width, height);
    }
}
