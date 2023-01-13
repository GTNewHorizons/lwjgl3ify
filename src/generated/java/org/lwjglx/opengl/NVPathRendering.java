package org.lwjglx.opengl;

public class NVPathRendering {
    public static void glCopyPathNV(int arg0, int arg1) {
        org.lwjgl.opengl.NVPathRendering.glCopyPathNV(arg0, arg1);
    }

    public static void glCoverFillPathInstancedNV(int arg0, java.nio.ByteBuffer arg1, int arg2, int arg3, int arg4, java.nio.FloatBuffer arg5) {
        org.lwjgl.opengl.NVPathRendering.glCoverFillPathInstancedNV(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCoverFillPathNV(int arg0, int arg1) {
        org.lwjgl.opengl.NVPathRendering.glCoverFillPathNV(arg0, arg1);
    }

    public static void glCoverStrokePathInstancedNV(int arg0, java.nio.ByteBuffer arg1, int arg2, int arg3, int arg4, java.nio.FloatBuffer arg5) {
        org.lwjgl.opengl.NVPathRendering.glCoverStrokePathInstancedNV(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glCoverStrokePathNV(int arg0, int arg1) {
        org.lwjgl.opengl.NVPathRendering.glCoverStrokePathNV(arg0, arg1);
    }

    public static void glDeletePathsNV(int arg0, int arg1) {
        org.lwjgl.opengl.NVPathRendering.glDeletePathsNV(arg0, arg1);
    }

    public static int glGenPathsNV(int arg0) {
        return org.lwjgl.opengl.NVPathRendering.glGenPathsNV(arg0);
    }

    public static void glGetPathColorGenNV(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathColorGenfvNV(arg0, arg1, arg2);
    }

    public static void glGetPathColorGenNV(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathColorGenivNV(arg0, arg1, arg2);
    }

    public static float glGetPathColorGenfNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathColorGenfNV(arg0, arg1);
    }

    public static int glGetPathColorGeniNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathColorGeniNV(arg0, arg1);
    }

    public static void glGetPathCommandsNV(int arg0, java.nio.ByteBuffer arg1) {
        org.lwjgl.opengl.NVPathRendering.glGetPathCommandsNV(arg0, arg1);
    }

    public static void glGetPathCoordsNV(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.NVPathRendering.glGetPathCoordsNV(arg0, arg1);
    }

    public static void glGetPathDashArrayNV(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.NVPathRendering.glGetPathDashArrayNV(arg0, arg1);
    }

    public static float glGetPathLengthNV(int arg0, int arg1, int arg2) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathLengthNV(arg0, arg1, arg2);
    }

    public static void glGetPathMetricRangeNV(int arg0, int arg1, int arg2, int arg3, java.nio.FloatBuffer arg4) {
        org.lwjgl.opengl.NVPathRendering.glGetPathMetricRangeNV(arg0, arg1, arg2, arg3, arg4);
    }

    public static void glGetPathMetricsNV(int arg0, int arg1, java.nio.ByteBuffer arg2, int arg3, int arg4, java.nio.FloatBuffer arg5) {
        org.lwjgl.opengl.NVPathRendering.glGetPathMetricsNV(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glGetPathParameterNV(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathParameterivNV(arg0, arg1, arg2);
    }

    public static float glGetPathParameterfNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathParameterfNV(arg0, arg1);
    }

    public static void glGetPathParameterfvNV(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathParameterfvNV(arg0, arg1, arg2);
    }

    public static int glGetPathParameteriNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathParameteriNV(arg0, arg1);
    }

    public static void glGetPathSpacingNV(int arg0, int arg1, java.nio.ByteBuffer arg2, int arg3, float arg4, float arg5, int arg6, java.nio.FloatBuffer arg7) {
        org.lwjgl.opengl.NVPathRendering.glGetPathSpacingNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glGetPathTexGenNV(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathTexGenfvNV(arg0, arg1, arg2);
    }

    public static void glGetPathTexGenNV(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glGetPathTexGenivNV(arg0, arg1, arg2);
    }

    public static float glGetPathTexGenfNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathTexGenfNV(arg0, arg1);
    }

    public static int glGetPathTexGeniNV(int arg0, int arg1) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathTexGeniNV(arg0, arg1);
    }

    public static void glInterpolatePathsNV(int arg0, int arg1, int arg2, float arg3) {
        org.lwjgl.opengl.NVPathRendering.glInterpolatePathsNV(arg0, arg1, arg2, arg3);
    }

    public static boolean glIsPathNV(int arg0) {
        return org.lwjgl.opengl.NVPathRendering.glIsPathNV(arg0);
    }

    public static boolean glIsPointInFillPathNV(int arg0, int arg1, float arg2, float arg3) {
        return org.lwjgl.opengl.NVPathRendering.glIsPointInFillPathNV(arg0, arg1, arg2, arg3);
    }

    public static boolean glIsPointInStrokePathNV(int arg0, float arg1, float arg2) {
        return org.lwjgl.opengl.NVPathRendering.glIsPointInStrokePathNV(arg0, arg1, arg2);
    }

    public static void glPathColorGenNV(int arg0, int arg1, int arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.NVPathRendering.glPathColorGenNV(arg0, arg1, arg2, arg3);
    }

    public static void glPathCommandsNV(int arg0, java.nio.ByteBuffer arg1, int arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.NVPathRendering.glPathCommandsNV(arg0, arg1, arg2, arg3);
    }

    public static void glPathCoordsNV(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathCoordsNV(arg0, arg1, arg2);
    }

    public static void glPathCoverDepthFuncNV(int arg0) {
        org.lwjgl.opengl.NVPathRendering.glPathCoverDepthFuncNV(arg0);
    }

    public static void glPathDashArrayNV(int arg0, java.nio.FloatBuffer arg1) {
        org.lwjgl.opengl.NVPathRendering.glPathDashArrayNV(arg0, arg1);
    }

    public static void glPathFogGenNV(int arg0) {
        org.lwjgl.opengl.NVPathRendering.glPathFogGenNV(arg0);
    }

    public static void glPathGlyphRangeNV(int arg0, int arg1, java.nio.ByteBuffer arg2, int arg3, int arg4, int arg5, int arg6, int arg7, float arg8) {
        org.lwjgl.opengl.NVPathRendering.glPathGlyphRangeNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glPathGlyphsNV(int arg0, int arg1, java.nio.ByteBuffer arg2, int arg3, int arg4, java.nio.ByteBuffer arg5, int arg6, int arg7, float arg8) {
        org.lwjgl.opengl.NVPathRendering.glPathGlyphsNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static void glPathParameterNV(int arg0, int arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterfvNV(arg0, arg1, arg2);
    }

    public static void glPathParameterNV(int arg0, int arg1, java.nio.IntBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterivNV(arg0, arg1, arg2);
    }

    public static void glPathParameterfNV(int arg0, int arg1, float arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterfNV(arg0, arg1, arg2);
    }

    public static void glPathParameteriNV(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathParameteriNV(arg0, arg1, arg2);
    }

    public static void glPathStencilFuncNV(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathStencilFuncNV(arg0, arg1, arg2);
    }

    public static void glPathStringNV(int arg0, int arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glPathStringNV(arg0, arg1, arg2);
    }

    public static void glPathSubCommandsNV(int arg0, int arg1, int arg2, java.nio.ByteBuffer arg3, int arg4, java.nio.ByteBuffer arg5) {
        org.lwjgl.opengl.NVPathRendering.glPathSubCommandsNV(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static void glPathSubCoordsNV(int arg0, int arg1, int arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.NVPathRendering.glPathSubCoordsNV(arg0, arg1, arg2, arg3);
    }

    public static boolean glPointAlongPathNV(int arg0, int arg1, int arg2, float arg3, java.nio.FloatBuffer arg4, java.nio.FloatBuffer arg5, java.nio.FloatBuffer arg6, java.nio.FloatBuffer arg7) {
        return org.lwjgl.opengl.NVPathRendering.glPointAlongPathNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static void glStencilFillPathInstancedNV(int arg0, java.nio.ByteBuffer arg1, int arg2, int arg3, int arg4, int arg5, java.nio.FloatBuffer arg6) {
        org.lwjgl.opengl.NVPathRendering.glStencilFillPathInstancedNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glStencilFillPathNV(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.NVPathRendering.glStencilFillPathNV(arg0, arg1, arg2);
    }

    public static void glStencilStrokePathInstancedNV(int arg0, java.nio.ByteBuffer arg1, int arg2, int arg3, int arg4, int arg5, java.nio.FloatBuffer arg6) {
        org.lwjgl.opengl.NVPathRendering.glStencilStrokePathInstancedNV(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static void glStencilStrokePathNV(int arg0, int arg1, int arg2) {
        org.lwjgl.opengl.NVPathRendering.glStencilStrokePathNV(arg0, arg1, arg2);
    }

    public static void glTransformPathNV(int arg0, int arg1, int arg2, java.nio.FloatBuffer arg3) {
        org.lwjgl.opengl.NVPathRendering.glTransformPathNV(arg0, arg1, arg2, arg3);
    }

    public static void glWeightPathsNV(int arg0, java.nio.IntBuffer arg1, java.nio.FloatBuffer arg2) {
        org.lwjgl.opengl.NVPathRendering.glWeightPathsNV(arg0, arg1, arg2);
    }


}
