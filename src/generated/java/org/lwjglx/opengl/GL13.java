package org.lwjglx.opengl;

public class GL13 {
    public static final int GL_ACTIVE_TEXTURE = 34016;
    public static final int GL_ADD_SIGNED = 34164;
    public static final int GL_CLAMP_TO_BORDER = 33069;
    public static final int GL_CLIENT_ACTIVE_TEXTURE = 34017;
    public static final int GL_COMBINE = 34160;
    public static final int GL_COMBINE_ALPHA = 34162;
    public static final int GL_COMBINE_RGB = 34161;
    public static final int GL_COMPRESSED_ALPHA = 34025;
    public static final int GL_COMPRESSED_INTENSITY = 34028;
    public static final int GL_COMPRESSED_LUMINANCE = 34026;
    public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 34027;
    public static final int GL_COMPRESSED_RGB = 34029;
    public static final int GL_COMPRESSED_RGBA = 34030;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
    public static final int GL_CONSTANT = 34166;
    public static final int GL_DOT3_RGB = 34478;
    public static final int GL_DOT3_RGBA = 34479;
    public static final int GL_INTERPOLATE = 34165;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
    public static final int GL_MAX_TEXTURE_UNITS = 34018;
    public static final int GL_MULTISAMPLE = 32925;
    public static final int GL_MULTISAMPLE_BIT = 536870912;
    public static final int GL_NORMAL_MAP = 34065;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
    public static final int GL_OPERAND0_ALPHA = 34200;
    public static final int GL_OPERAND0_RGB = 34192;
    public static final int GL_OPERAND1_ALPHA = 34201;
    public static final int GL_OPERAND1_RGB = 34193;
    public static final int GL_OPERAND2_ALPHA = 34202;
    public static final int GL_OPERAND2_RGB = 34194;
    public static final int GL_PREVIOUS = 34168;
    public static final int GL_PRIMARY_COLOR = 34167;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP = 34075;
    public static final int GL_REFLECTION_MAP = 34066;
    public static final int GL_RGB_SCALE = 34163;
    public static final int GL_SAMPLES = 32937;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
    public static final int GL_SAMPLE_ALPHA_TO_ONE = 32927;
    public static final int GL_SAMPLE_BUFFERS = 32936;
    public static final int GL_SAMPLE_COVERAGE = 32928;
    public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
    public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
    public static final int GL_SOURCE0_ALPHA = 34184;
    public static final int GL_SOURCE0_RGB = 34176;
    public static final int GL_SOURCE1_ALPHA = 34185;
    public static final int GL_SOURCE1_RGB = 34177;
    public static final int GL_SOURCE2_ALPHA = 34186;
    public static final int GL_SOURCE2_RGB = 34178;
    public static final int GL_SUBTRACT = 34023;
    public static final int GL_TEXTURE0 = 33984;
    public static final int GL_TEXTURE10 = 33994;
    public static final int GL_TEXTURE11 = 33995;
    public static final int GL_TEXTURE12 = 33996;
    public static final int GL_TEXTURE13 = 33997;
    public static final int GL_TEXTURE14 = 33998;
    public static final int GL_TEXTURE15 = 33999;
    public static final int GL_TEXTURE16 = 34000;
    public static final int GL_TEXTURE17 = 34001;
    public static final int GL_TEXTURE18 = 34002;
    public static final int GL_TEXTURE19 = 34003;
    public static final int GL_TEXTURE1 = 33985;
    public static final int GL_TEXTURE20 = 34004;
    public static final int GL_TEXTURE21 = 34005;
    public static final int GL_TEXTURE22 = 34006;
    public static final int GL_TEXTURE23 = 34007;
    public static final int GL_TEXTURE24 = 34008;
    public static final int GL_TEXTURE25 = 34009;
    public static final int GL_TEXTURE26 = 34010;
    public static final int GL_TEXTURE27 = 34011;
    public static final int GL_TEXTURE28 = 34012;
    public static final int GL_TEXTURE29 = 34013;
    public static final int GL_TEXTURE2 = 33986;
    public static final int GL_TEXTURE30 = 34014;
    public static final int GL_TEXTURE31 = 34015;
    public static final int GL_TEXTURE3 = 33987;
    public static final int GL_TEXTURE4 = 33988;
    public static final int GL_TEXTURE5 = 33989;
    public static final int GL_TEXTURE6 = 33990;
    public static final int GL_TEXTURE7 = 33991;
    public static final int GL_TEXTURE8 = 33992;
    public static final int GL_TEXTURE9 = 33993;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
    public static final int GL_TEXTURE_COMPRESSED = 34465;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 34464;
    public static final int GL_TEXTURE_COMPRESSION_HINT = 34031;
    public static final int GL_TEXTURE_CUBE_MAP = 34067;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
    public static final int GL_TRANSPOSE_COLOR_MATRIX = 34022;
    public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 34019;
    public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 34020;
    public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 34021;

    public static void glActiveTexture(int texture) {
        org.lwjgl.opengl.GL13.glActiveTexture(texture);
    }

    public static void glClientActiveTexture(int texture) {
        org.lwjgl.opengl.GL13.glClientActiveTexture(texture);
    }

    public static void glCompressedTexImage1D(
            int target,
            int level,
            int internalformat,
            int width,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(
                target, level, internalformat, width, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage1D(
            int target, int level, int internalformat, int width, int border, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage1D(target, level, internalformat, width, border, data);
    }

    public static void glCompressedTexImage2D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(
                target, level, internalformat, width, height, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage2D(
            int target, int level, int internalformat, int width, int height, int border, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage2D(target, level, internalformat, width, height, border, data);
    }

    public static void glCompressedTexImage3D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int depth,
            int border,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(
                target, level, internalformat, width, height, depth, border, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexImage3D(
            int target,
            int level,
            int internalformat,
            int width,
            int height,
            int depth,
            int border,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, data);
    }

    public static void glCompressedTexSubImage1D(
            int target, int level, int xoffset, int width, int format, int data_imageSize, long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(
                target, level, xoffset, width, format, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexSubImage1D(
            int target, int level, int xoffset, int width, int format, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage1D(target, level, xoffset, width, format, data);
    }

    public static void glCompressedTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(
                target, level, xoffset, yoffset, width, height, format, data_imageSize, data_buffer_offset);
    }

    public static void glCompressedTexSubImage2D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int width,
            int height,
            int format,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, data);
    }

    public static void glCompressedTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            int data_imageSize,
            long data_buffer_offset) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(
                target,
                level,
                xoffset,
                yoffset,
                zoffset,
                width,
                height,
                depth,
                format,
                data_imageSize,
                data_buffer_offset);
    }

    public static void glCompressedTexSubImage3D(
            int target,
            int level,
            int xoffset,
            int yoffset,
            int zoffset,
            int width,
            int height,
            int depth,
            int format,
            java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL13.glCompressedTexSubImage3D(
                target, level, xoffset, yoffset, zoffset, width, height, depth, format, data);
    }

    public static void glGetCompressedTexImage(int target, int lod, long img_buffer_offset) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, img_buffer_offset);
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.ByteBuffer img) {
        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, img);
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.IntBuffer img) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjglx.MemoryUtil.getAddress(img));
    }

    public static void glGetCompressedTexImage(int target, int lod, java.nio.ShortBuffer img) {

        org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjglx.MemoryUtil.getAddress(img));
    }

    public static void glLoadTransposeMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixd(m);
    }

    public static void glLoadTransposeMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL13.glLoadTransposeMatrixf(m);
    }

    public static void glMultTransposeMatrix(java.nio.DoubleBuffer m) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixd(m);
    }

    public static void glMultTransposeMatrix(java.nio.FloatBuffer m) {
        org.lwjgl.opengl.GL13.glMultTransposeMatrixf(m);
    }

    public static void glMultiTexCoord1d(int target, double s) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1d(target, s);
    }

    public static void glMultiTexCoord1f(int target, float s) {
        org.lwjgl.opengl.GL13.glMultiTexCoord1f(target, s);
    }

    public static void glMultiTexCoord2d(int target, double s, double t) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2d(target, s, t);
    }

    public static void glMultiTexCoord2f(int target, float s, float t) {
        org.lwjgl.opengl.GL13.glMultiTexCoord2f(target, s, t);
    }

    public static void glMultiTexCoord3d(int target, double s, double t, double r) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3d(target, s, t, r);
    }

    public static void glMultiTexCoord3f(int target, float s, float t, float r) {
        org.lwjgl.opengl.GL13.glMultiTexCoord3f(target, s, t, r);
    }

    public static void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4d(target, s, t, r, q);
    }

    public static void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
        org.lwjgl.opengl.GL13.glMultiTexCoord4f(target, s, t, r, q);
    }

    public static void glSampleCoverage(float value, boolean invert) {
        org.lwjgl.opengl.GL13.glSampleCoverage(value, invert);
    }
}
