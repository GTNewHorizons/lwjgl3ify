package org.lwjglx.opengl;

public class ARBViewportArray {
    public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
    public static final int GL_LAST_VERTEX_CONVENTION = 36430;
    public static final int GL_LAYER_PROVOKING_VERTEX = 33374;
    public static final int GL_MAX_VIEWPORTS = 33371;
    public static final int GL_PROVOKING_VERTEX = 36431;
    public static final int GL_UNDEFINED_VERTEX = 33376;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 33373;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 33375;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 33372;

    public static void glDepthRangeIndexed(int index, double n, double f) {
        org.lwjgl.opengl.ARBViewportArray.glDepthRangeIndexed(index, n, f);
    }

    public static void glScissorIndexed(int index, int left, int bottom, int width, int height) {
        org.lwjgl.opengl.ARBViewportArray.glScissorIndexed(index, left, bottom, width, height);
    }

    public static void glViewportIndexedf(int index, float x, float y, float w, float h) {
        org.lwjgl.opengl.ARBViewportArray.glViewportIndexedf(index, x, y, w, h);
    }
}
