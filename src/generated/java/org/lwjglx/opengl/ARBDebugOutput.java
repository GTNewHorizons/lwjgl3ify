package org.lwjglx.opengl;

public class ARBDebugOutput {
    public static void glDebugMessageControlARB(
            int source, int type, int severity, java.nio.IntBuffer ids, boolean enabled) {
        org.lwjgl.opengl.ARBDebugOutput.glDebugMessageControlARB(source, type, severity, ids, enabled);
    }

    public static void glDebugMessageInsertARB(int source, int type, int id, int severity, java.lang.CharSequence buf) {
        org.lwjgl.opengl.ARBDebugOutput.glDebugMessageInsertARB(source, type, id, severity, buf);
    }

    public static void glDebugMessageInsertARB(int source, int type, int id, int severity, java.nio.ByteBuffer buf) {
        org.lwjgl.opengl.ARBDebugOutput.glDebugMessageInsertARB(source, type, id, severity, buf);
    }

    public static int glGetDebugMessageLogARB(
            int count,
            java.nio.IntBuffer sources,
            java.nio.IntBuffer types,
            java.nio.IntBuffer ids,
            java.nio.IntBuffer severities,
            java.nio.IntBuffer lengths,
            java.nio.ByteBuffer messageLog) {
        return org.lwjgl.opengl.ARBDebugOutput.glGetDebugMessageLogARB(
                count, sources, types, ids, severities, lengths, messageLog);
    }
}
