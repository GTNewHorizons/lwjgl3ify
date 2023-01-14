package org.lwjglx.opengl;

public class KHRDebug {
    public static void glDebugMessageControl(
            int source, int type, int severity, java.nio.IntBuffer ids, boolean enabled) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageControl(source, type, severity, ids, enabled);
    }

    public static void glDebugMessageInsert(int source, int type, int id, int severity, java.lang.CharSequence buf) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageInsert(source, type, id, severity, buf);
    }

    public static void glDebugMessageInsert(int source, int type, int id, int severity, java.nio.ByteBuffer buf) {
        org.lwjgl.opengl.KHRDebug.glDebugMessageInsert(source, type, id, severity, buf);
    }

    public static int glGetDebugMessageLog(
            int count,
            java.nio.IntBuffer sources,
            java.nio.IntBuffer types,
            java.nio.IntBuffer ids,
            java.nio.IntBuffer severities,
            java.nio.IntBuffer lengths,
            java.nio.ByteBuffer messageLog) {
        return org.lwjgl.opengl.KHRDebug.glGetDebugMessageLog(
                count, sources, types, ids, severities, lengths, messageLog);
    }

    public static java.lang.String glGetObjectLabel(int identifier, int name, int bufSize) {
        return org.lwjgl.opengl.KHRDebug.glGetObjectLabel(identifier, name, bufSize);
    }

    public static void glGetObjectLabel(
            int identifier, int name, java.nio.IntBuffer length, java.nio.ByteBuffer label) {
        org.lwjgl.opengl.KHRDebug.glGetObjectLabel(identifier, name, length, label);
    }

    public static void glObjectLabel(int identifier, int name, java.lang.CharSequence label) {
        org.lwjgl.opengl.KHRDebug.glObjectLabel(identifier, name, label);
    }

    public static void glObjectLabel(int identifier, int name, java.nio.ByteBuffer label) {
        org.lwjgl.opengl.KHRDebug.glObjectLabel(identifier, name, label);
    }

    public static void glPopDebugGroup() {
        org.lwjgl.opengl.KHRDebug.glPopDebugGroup();
    }

    public static void glPushDebugGroup(int source, int id, java.lang.CharSequence message) {
        org.lwjgl.opengl.KHRDebug.glPushDebugGroup(source, id, message);
    }

    public static void glPushDebugGroup(int source, int id, java.nio.ByteBuffer message) {
        org.lwjgl.opengl.KHRDebug.glPushDebugGroup(source, id, message);
    }
}
