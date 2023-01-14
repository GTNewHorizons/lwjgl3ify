package org.lwjglx.opengl;

public class ARBImaging {
    public static void glBlendColor(float red, float green, float blue, float alpha) {
        org.lwjgl.opengl.ARBImaging.glBlendColor(red, green, blue, alpha);
    }

    public static void glBlendEquation(int mode) {
        org.lwjgl.opengl.ARBImaging.glBlendEquation(mode);
    }

    public static void glColorSubTable(
            int target, int start, int count, int format, int type, long data_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glColorSubTable(target, start, count, format, type, data_buffer_offset);
    }

    public static void glColorSubTable(
            int target, int start, int count, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.ARBImaging.glColorSubTable(target, start, count, format, type, data);
    }

    public static void glColorSubTable(
            int target, int start, int count, int format, int type, java.nio.DoubleBuffer data) {

        org.lwjgl.opengl.ARBImaging.glColorSubTable(
                target, start, count, format, type, org.lwjglx.MemoryUtil.getAddress(data));
    }

    public static void glColorSubTable(
            int target, int start, int count, int format, int type, java.nio.FloatBuffer data) {

        org.lwjgl.opengl.ARBImaging.glColorSubTable(
                target, start, count, format, type, org.lwjglx.MemoryUtil.getAddress(data));
    }

    public static void glColorTable(
            int target, int internalFormat, int width, int format, int type, long data_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glColorTable(target, internalFormat, width, format, type, data_buffer_offset);
    }

    public static void glColorTable(
            int target, int internalFormat, int width, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.ARBImaging.glColorTable(target, internalFormat, width, format, type, data);
    }

    public static void glColorTable(
            int target, int internalFormat, int width, int format, int type, java.nio.DoubleBuffer data) {

        org.lwjgl.opengl.ARBImaging.glColorTable(
                target, internalFormat, width, format, type, org.lwjglx.MemoryUtil.getAddress(data));
    }

    public static void glColorTable(
            int target, int internalFormat, int width, int format, int type, java.nio.FloatBuffer data) {
        org.lwjgl.opengl.ARBImaging.glColorTable(target, internalFormat, width, format, type, data);
    }

    public static void glColorTableParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glColorTableParameterfv(target, pname, params);
    }

    public static void glColorTableParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glColorTableParameteriv(target, pname, params);
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, long image_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(
                target, internalformat, width, format, type, image_buffer_offset);
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, java.nio.ByteBuffer image) {
        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(target, internalformat, width, format, type, image);
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, java.nio.DoubleBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(
                target, internalformat, width, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, java.nio.FloatBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(
                target, internalformat, width, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, java.nio.IntBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(
                target, internalformat, width, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionFilter1D(
            int target, int internalformat, int width, int format, int type, java.nio.ShortBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(
                target, internalformat, width, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionFilter2D(
            int target, int internalformat, int width, int height, int format, int type, long image_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(
                target, internalformat, width, height, format, type, image_buffer_offset);
    }

    public static void glConvolutionFilter2D(
            int target, int internalformat, int width, int height, int format, int type, java.nio.ByteBuffer image) {
        org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(target, internalformat, width, height, format, type, image);
    }

    public static void glConvolutionFilter2D(
            int target, int internalformat, int width, int height, int format, int type, java.nio.IntBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(
                target, internalformat, width, height, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionFilter2D(
            int target, int internalformat, int width, int height, int format, int type, java.nio.ShortBuffer image) {

        org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(
                target, internalformat, width, height, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glConvolutionParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glConvolutionParameterfv(target, pname, params);
    }

    public static void glConvolutionParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glConvolutionParameteriv(target, pname, params);
    }

    public static void glConvolutionParameterf(int target, int pname, float params) {
        org.lwjgl.opengl.ARBImaging.glConvolutionParameterf(target, pname, params);
    }

    public static void glConvolutionParameteri(int target, int pname, int params) {
        org.lwjgl.opengl.ARBImaging.glConvolutionParameteri(target, pname, params);
    }

    public static void glCopyColorSubTable(int target, int start, int x, int y, int width) {
        org.lwjgl.opengl.ARBImaging.glCopyColorSubTable(target, start, x, y, width);
    }

    public static void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
        org.lwjgl.opengl.ARBImaging.glCopyColorTable(target, internalformat, x, y, width);
    }

    public static void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
        org.lwjgl.opengl.ARBImaging.glCopyConvolutionFilter1D(target, internalformat, x, y, width);
    }

    public static void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
        org.lwjgl.opengl.ARBImaging.glCopyConvolutionFilter2D(target, internalformat, x, y, width, height);
    }

    public static void glGetColorTable(int target, int format, int type, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.ARBImaging.glGetColorTable(target, format, type, data);
    }

    public static void glGetColorTable(int target, int format, int type, java.nio.DoubleBuffer data) {

        org.lwjgl.opengl.ARBImaging.glGetColorTable(target, format, type, org.lwjglx.MemoryUtil.getAddress(data));
    }

    public static void glGetColorTable(int target, int format, int type, java.nio.FloatBuffer data) {
        org.lwjgl.opengl.ARBImaging.glGetColorTable(target, format, type, data);
    }

    public static void glGetColorTableParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetColorTableParameterfv(target, pname, params);
    }

    public static void glGetColorTableParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetColorTableParameteriv(target, pname, params);
    }

    public static void glGetConvolutionFilter(int target, int format, int type, long image_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, image_buffer_offset);
    }

    public static void glGetConvolutionFilter(int target, int format, int type, java.nio.ByteBuffer image) {
        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, image);
    }

    public static void glGetConvolutionFilter(int target, int format, int type, java.nio.DoubleBuffer image) {

        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(
                target, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glGetConvolutionFilter(int target, int format, int type, java.nio.FloatBuffer image) {

        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(
                target, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glGetConvolutionFilter(int target, int format, int type, java.nio.IntBuffer image) {

        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(
                target, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glGetConvolutionFilter(int target, int format, int type, java.nio.ShortBuffer image) {

        org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(
                target, format, type, org.lwjglx.MemoryUtil.getAddress(image));
    }

    public static void glGetConvolutionParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetConvolutionParameterfv(target, pname, params);
    }

    public static void glGetConvolutionParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetConvolutionParameteriv(target, pname, params);
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, long values_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, values_buffer_offset);
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, java.nio.ByteBuffer values) {
        org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, values);
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, java.nio.DoubleBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetHistogram(
                target, reset, format, type, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, java.nio.FloatBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetHistogram(
                target, reset, format, type, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, java.nio.IntBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetHistogram(
                target, reset, format, type, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetHistogram(int target, boolean reset, int format, int type, java.nio.ShortBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetHistogram(
                target, reset, format, type, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetHistogramParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetHistogramParameterfv(target, pname, params);
    }

    public static void glGetHistogramParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetHistogramParameteriv(target, pname, params);
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, long values_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, values_buffer_offset);
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, java.nio.ByteBuffer values) {
        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, values);
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, java.nio.DoubleBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, java.nio.FloatBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, java.nio.IntBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetMinmax(int target, boolean reset, int format, int types, java.nio.ShortBuffer values) {

        org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjglx.MemoryUtil.getAddress(values));
    }

    public static void glGetMinmaxParameter(int target, int pname, java.nio.FloatBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetMinmaxParameterfv(target, pname, params);
    }

    public static void glGetMinmaxParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.ARBImaging.glGetMinmaxParameteriv(target, pname, params);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ByteBuffer span) {
        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, column, span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ByteBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ByteBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.IntBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.IntBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.IntBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.IntBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ShortBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ShortBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ByteBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ByteBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.IntBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.IntBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.IntBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.IntBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ShortBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ShortBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ByteBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ByteBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.IntBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.IntBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.IntBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.IntBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ShortBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ShortBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ByteBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ByteBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.IntBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.IntBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.IntBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.IntBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ShortBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ShortBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ByteBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ByteBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ByteBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.DoubleBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.IntBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.IntBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.IntBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.IntBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ByteBuffer span) {

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                span);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ShortBuffer column,
            java.nio.DoubleBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ShortBuffer column,
            java.nio.IntBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glGetSeparableFilter(
            int target,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ShortBuffer column,
            java.nio.ShortBuffer span) {
        final java.nio.ByteBuffer wrappedArg5 = me.eigenraven.lwjgl3ify.BufferCasts.toByteBuffer(span);

        org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(
                target,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column),
                wrappedArg5);
        me.eigenraven.lwjgl3ify.BufferCasts.updateBuffer(span, wrappedArg5);
    }

    public static void glHistogram(int target, int width, int internalformat, boolean sink) {
        org.lwjgl.opengl.ARBImaging.glHistogram(target, width, internalformat, sink);
    }

    public static void glMinmax(int target, int internalformat, boolean sink) {
        org.lwjgl.opengl.ARBImaging.glMinmax(target, internalformat, sink);
    }

    public static void glResetHistogram(int target) {
        org.lwjgl.opengl.ARBImaging.glResetHistogram(target);
    }

    public static void glResetMinmax(int target) {
        org.lwjgl.opengl.ARBImaging.glResetMinmax(target);
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            long row_buffer_offset,
            long column_buffer_offset) {
        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target, internalformat, width, height, format, type, row_buffer_offset, column_buffer_offset);
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ByteBuffer column) {
        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target, internalformat, width, height, format, type, row, column);
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.DoubleBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.FloatBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.IntBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ByteBuffer row,
            java.nio.ShortBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ByteBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.DoubleBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.FloatBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.IntBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.DoubleBuffer row,
            java.nio.ShortBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ByteBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.DoubleBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.FloatBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.IntBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.FloatBuffer row,
            java.nio.ShortBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ByteBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.DoubleBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.FloatBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.IntBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.IntBuffer row,
            java.nio.ShortBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ByteBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.DoubleBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.FloatBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.IntBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }

    public static void glSeparableFilter2D(
            int target,
            int internalformat,
            int width,
            int height,
            int format,
            int type,
            java.nio.ShortBuffer row,
            java.nio.ShortBuffer column) {

        org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(
                target,
                internalformat,
                width,
                height,
                format,
                type,
                org.lwjglx.MemoryUtil.getAddress(row),
                org.lwjglx.MemoryUtil.getAddress(column));
    }
}
