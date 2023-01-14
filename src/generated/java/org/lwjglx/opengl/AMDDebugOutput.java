package org.lwjglx.opengl;

public class AMDDebugOutput {
    public static void glDebugMessageEnableAMD(int category, int severity, java.nio.IntBuffer ids, boolean enabled) {
        org.lwjgl.opengl.AMDDebugOutput.glDebugMessageEnableAMD(category, severity, ids, enabled);
    }

    public static void glDebugMessageInsertAMD(int category, int severity, int id, java.lang.CharSequence buf) {
        org.lwjgl.opengl.AMDDebugOutput.glDebugMessageInsertAMD(category, severity, id, buf);
    }

    public static void glDebugMessageInsertAMD(int category, int severity, int id, java.nio.ByteBuffer buf) {
        org.lwjgl.opengl.AMDDebugOutput.glDebugMessageInsertAMD(category, severity, id, buf);
    }

    public static int glGetDebugMessageLogAMD(
            int count,
            java.nio.IntBuffer categories,
            java.nio.IntBuffer severities,
            java.nio.IntBuffer ids,
            java.nio.IntBuffer lengths,
            java.nio.ByteBuffer messageLog) {
        return org.lwjgl.opengl.AMDDebugOutput.glGetDebugMessageLogAMD(
                count, categories, severities, ids, lengths, messageLog);
    }
}
