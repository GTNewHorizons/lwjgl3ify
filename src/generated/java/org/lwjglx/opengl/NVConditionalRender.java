package org.lwjglx.opengl;

public class NVConditionalRender {
    public static final int GL_QUERY_BY_REGION_NO_WAIT_NV = 36374;
    public static final int GL_QUERY_BY_REGION_WAIT_NV = 36373;
    public static final int GL_QUERY_NO_WAIT_NV = 36372;
    public static final int GL_QUERY_WAIT_NV = 36371;

    public static void glBeginConditionalRenderNV(int id, int mode) {
        org.lwjgl.opengl.NVConditionalRender.glBeginConditionalRenderNV(id, mode);
    }

    public static void glEndConditionalRenderNV() {
        org.lwjgl.opengl.NVConditionalRender.glEndConditionalRenderNV();
    }
}
