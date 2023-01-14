package org.lwjglx.opengl;

public class NVPathRendering {
    public static void glCopyPathNV(int resultPath, int srcPath) {
        org.lwjgl.opengl.NVPathRendering.glCopyPathNV(resultPath, srcPath);
    }

    public static void glCoverFillPathInstancedNV(
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            int coverMode,
            int transformType,
            java.nio.FloatBuffer transformValues) {
        org.lwjgl.opengl.NVPathRendering.glCoverFillPathInstancedNV(
                pathNameType, paths, pathBase, coverMode, transformType, transformValues);
    }

    public static void glCoverFillPathNV(int path, int coverMode) {
        org.lwjgl.opengl.NVPathRendering.glCoverFillPathNV(path, coverMode);
    }

    public static void glCoverStrokePathInstancedNV(
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            int coverMode,
            int transformType,
            java.nio.FloatBuffer transformValues) {
        org.lwjgl.opengl.NVPathRendering.glCoverStrokePathInstancedNV(
                pathNameType, paths, pathBase, coverMode, transformType, transformValues);
    }

    public static void glCoverStrokePathNV(int name, int coverMode) {
        org.lwjgl.opengl.NVPathRendering.glCoverStrokePathNV(name, coverMode);
    }

    public static void glDeletePathsNV(int path, int range) {
        org.lwjgl.opengl.NVPathRendering.glDeletePathsNV(path, range);
    }

    public static int glGenPathsNV(int range) {
        return org.lwjgl.opengl.NVPathRendering.glGenPathsNV(range);
    }

    public static void glGetPathColorGenNV(int color, int pname, java.nio.FloatBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathColorGenfvNV(color, pname, value);
    }

    public static void glGetPathColorGenNV(int color, int pname, java.nio.IntBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathColorGenivNV(color, pname, value);
    }

    public static float glGetPathColorGenfNV(int color, int pname) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathColorGenfNV(color, pname);
    }

    public static int glGetPathColorGeniNV(int color, int pname) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathColorGeniNV(color, pname);
    }

    public static void glGetPathCommandsNV(int name, java.nio.ByteBuffer commands) {
        org.lwjgl.opengl.NVPathRendering.glGetPathCommandsNV(name, commands);
    }

    public static void glGetPathCoordsNV(int name, java.nio.FloatBuffer coords) {
        org.lwjgl.opengl.NVPathRendering.glGetPathCoordsNV(name, coords);
    }

    public static void glGetPathDashArrayNV(int name, java.nio.FloatBuffer dashArray) {
        org.lwjgl.opengl.NVPathRendering.glGetPathDashArrayNV(name, dashArray);
    }

    public static float glGetPathLengthNV(int path, int startSegment, int numSegments) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathLengthNV(path, startSegment, numSegments);
    }

    public static void glGetPathMetricRangeNV(
            int metricQueryMask, int fistPathName, int numPaths, int stride, java.nio.FloatBuffer metrics) {
        org.lwjgl.opengl.NVPathRendering.glGetPathMetricRangeNV(
                metricQueryMask, fistPathName, numPaths, stride, metrics);
    }

    public static void glGetPathMetricsNV(
            int metricQueryMask,
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            int stride,
            java.nio.FloatBuffer metrics) {
        org.lwjgl.opengl.NVPathRendering.glGetPathMetricsNV(
                metricQueryMask, pathNameType, paths, pathBase, stride, metrics);
    }

    public static void glGetPathParameterNV(int name, int param, java.nio.IntBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathParameterivNV(name, param, value);
    }

    public static float glGetPathParameterfNV(int name, int param) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathParameterfNV(name, param);
    }

    public static void glGetPathParameterfvNV(int name, int param, java.nio.FloatBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathParameterfvNV(name, param, value);
    }

    public static int glGetPathParameteriNV(int name, int param) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathParameteriNV(name, param);
    }

    public static void glGetPathSpacingNV(
            int pathListMode,
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            float advanceScale,
            float kerningScale,
            int transformType,
            java.nio.FloatBuffer returnedSpacing) {
        org.lwjgl.opengl.NVPathRendering.glGetPathSpacingNV(
                pathListMode,
                pathNameType,
                paths,
                pathBase,
                advanceScale,
                kerningScale,
                transformType,
                returnedSpacing);
    }

    public static void glGetPathTexGenNV(int texCoordSet, int pname, java.nio.FloatBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathTexGenfvNV(texCoordSet, pname, value);
    }

    public static void glGetPathTexGenNV(int texCoordSet, int pname, java.nio.IntBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glGetPathTexGenivNV(texCoordSet, pname, value);
    }

    public static float glGetPathTexGenfNV(int texCoordSet, int pname) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathTexGenfNV(texCoordSet, pname);
    }

    public static int glGetPathTexGeniNV(int texCoordSet, int pname) {
        return org.lwjgl.opengl.NVPathRendering.glGetPathTexGeniNV(texCoordSet, pname);
    }

    public static void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
        org.lwjgl.opengl.NVPathRendering.glInterpolatePathsNV(resultPath, pathA, pathB, weight);
    }

    public static boolean glIsPathNV(int path) {
        return org.lwjgl.opengl.NVPathRendering.glIsPathNV(path);
    }

    public static boolean glIsPointInFillPathNV(int path, int mask, float x, float y) {
        return org.lwjgl.opengl.NVPathRendering.glIsPointInFillPathNV(path, mask, x, y);
    }

    public static boolean glIsPointInStrokePathNV(int path, float x, float y) {
        return org.lwjgl.opengl.NVPathRendering.glIsPointInStrokePathNV(path, x, y);
    }

    public static void glPathColorGenNV(int color, int genMode, int colorFormat, java.nio.FloatBuffer coeffs) {
        org.lwjgl.opengl.NVPathRendering.glPathColorGenNV(color, genMode, colorFormat, coeffs);
    }

    public static void glPathCommandsNV(
            int path, java.nio.ByteBuffer commands, int coordType, java.nio.ByteBuffer coords) {
        org.lwjgl.opengl.NVPathRendering.glPathCommandsNV(path, commands, coordType, coords);
    }

    public static void glPathCoordsNV(int path, int coordType, java.nio.ByteBuffer coords) {
        org.lwjgl.opengl.NVPathRendering.glPathCoordsNV(path, coordType, coords);
    }

    public static void glPathCoverDepthFuncNV(int zfunc) {
        org.lwjgl.opengl.NVPathRendering.glPathCoverDepthFuncNV(zfunc);
    }

    public static void glPathDashArrayNV(int path, java.nio.FloatBuffer dashArray) {
        org.lwjgl.opengl.NVPathRendering.glPathDashArrayNV(path, dashArray);
    }

    public static void glPathFogGenNV(int genMode) {
        org.lwjgl.opengl.NVPathRendering.glPathFogGenNV(genMode);
    }

    public static void glPathGlyphRangeNV(
            int firstPathName,
            int fontTarget,
            java.nio.ByteBuffer fontName,
            int fontStyle,
            int firstGlyph,
            int numGlyphs,
            int handleMissingGlyphs,
            int pathParameterTemplate,
            float emScale) {
        org.lwjgl.opengl.NVPathRendering.glPathGlyphRangeNV(
                firstPathName,
                fontTarget,
                fontName,
                fontStyle,
                firstGlyph,
                numGlyphs,
                handleMissingGlyphs,
                pathParameterTemplate,
                emScale);
    }

    public static void glPathGlyphsNV(
            int firstPathName,
            int fontTarget,
            java.nio.ByteBuffer fontName,
            int fontStyle,
            int type,
            java.nio.ByteBuffer charcodes,
            int handleMissingGlyphs,
            int pathParameterTemplate,
            float emScale) {
        org.lwjgl.opengl.NVPathRendering.glPathGlyphsNV(
                firstPathName,
                fontTarget,
                fontName,
                fontStyle,
                type,
                charcodes,
                handleMissingGlyphs,
                pathParameterTemplate,
                emScale);
    }

    public static void glPathParameterNV(int path, int pname, java.nio.FloatBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterfvNV(path, pname, value);
    }

    public static void glPathParameterNV(int path, int pname, java.nio.IntBuffer value) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterivNV(path, pname, value);
    }

    public static void glPathParameterfNV(int path, int pname, float value) {
        org.lwjgl.opengl.NVPathRendering.glPathParameterfNV(path, pname, value);
    }

    public static void glPathParameteriNV(int path, int pname, int value) {
        org.lwjgl.opengl.NVPathRendering.glPathParameteriNV(path, pname, value);
    }

    public static void glPathStencilFuncNV(int func, int ref, int mask) {
        org.lwjgl.opengl.NVPathRendering.glPathStencilFuncNV(func, ref, mask);
    }

    public static void glPathStringNV(int path, int format, java.nio.ByteBuffer pathString) {
        org.lwjgl.opengl.NVPathRendering.glPathStringNV(path, format, pathString);
    }

    public static void glPathSubCommandsNV(
            int path,
            int commandStart,
            int commandsToDelete,
            java.nio.ByteBuffer commands,
            int coordType,
            java.nio.ByteBuffer coords) {
        org.lwjgl.opengl.NVPathRendering.glPathSubCommandsNV(
                path, commandStart, commandsToDelete, commands, coordType, coords);
    }

    public static void glPathSubCoordsNV(int path, int coordStart, int coordType, java.nio.ByteBuffer coords) {
        org.lwjgl.opengl.NVPathRendering.glPathSubCoordsNV(path, coordStart, coordType, coords);
    }

    public static boolean glPointAlongPathNV(
            int path,
            int startSegment,
            int numSegments,
            float distance,
            java.nio.FloatBuffer x,
            java.nio.FloatBuffer y,
            java.nio.FloatBuffer tangentX,
            java.nio.FloatBuffer tangentY) {
        return org.lwjgl.opengl.NVPathRendering.glPointAlongPathNV(
                path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
    }

    public static void glStencilFillPathInstancedNV(
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            int fillMode,
            int mask,
            int transformType,
            java.nio.FloatBuffer transformValues) {
        org.lwjgl.opengl.NVPathRendering.glStencilFillPathInstancedNV(
                pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
    }

    public static void glStencilFillPathNV(int path, int fillMode, int mask) {
        org.lwjgl.opengl.NVPathRendering.glStencilFillPathNV(path, fillMode, mask);
    }

    public static void glStencilStrokePathInstancedNV(
            int pathNameType,
            java.nio.ByteBuffer paths,
            int pathBase,
            int reference,
            int mask,
            int transformType,
            java.nio.FloatBuffer transformValues) {
        org.lwjgl.opengl.NVPathRendering.glStencilStrokePathInstancedNV(
                pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
    }

    public static void glStencilStrokePathNV(int path, int reference, int mask) {
        org.lwjgl.opengl.NVPathRendering.glStencilStrokePathNV(path, reference, mask);
    }

    public static void glTransformPathNV(
            int resultPath, int srcPath, int transformType, java.nio.FloatBuffer transformValues) {
        org.lwjgl.opengl.NVPathRendering.glTransformPathNV(resultPath, srcPath, transformType, transformValues);
    }

    public static void glWeightPathsNV(int resultPath, java.nio.IntBuffer paths, java.nio.FloatBuffer weights) {
        org.lwjgl.opengl.NVPathRendering.glWeightPathsNV(resultPath, paths, weights);
    }
}
