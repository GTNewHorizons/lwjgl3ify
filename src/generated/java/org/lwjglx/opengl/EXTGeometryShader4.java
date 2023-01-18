package org.lwjglx.opengl;

public class EXTGeometryShader4 {
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED_EXT = 36263;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT = 36052;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_EXT = 36265;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_EXT = 36264;
    public static final int GL_GEOMETRY_INPUT_TYPE_EXT = 36315;
    public static final int GL_GEOMETRY_OUTPUT_TYPE_EXT = 36316;
    public static final int GL_GEOMETRY_SHADER_EXT = 36313;
    public static final int GL_GEOMETRY_VERTICES_OUT_EXT = 36314;
    public static final int GL_LINES_ADJACENCY_EXT = 10;
    public static final int GL_LINE_STRIP_ADJACENCY_EXT = 11;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES_EXT = 36320;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_EXT = 35881;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_EXT = 36321;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_EXT = 36319;
    public static final int GL_MAX_GEOMETRY_VARYING_COMPONENTS_EXT = 36317;
    public static final int GL_MAX_VARYING_COMPONENTS_EXT = 35659;
    public static final int GL_MAX_VERTEX_VARYING_COMPONENTS_EXT = 36318;
    public static final int GL_PROGRAM_POINT_SIZE_EXT = 34370;
    public static final int GL_TRIANGLES_ADJACENCY_EXT = 12;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY_EXT = 13;

    public static void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
        org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureEXT(target, attachment, texture, level);
    }

    public static void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
        org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
    }

    public static void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
        org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
    }

    public static void glProgramParameteriEXT(int program, int pname, int value) {
        org.lwjgl.opengl.EXTGeometryShader4.glProgramParameteriEXT(program, pname, value);
    }
}
