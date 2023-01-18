package org.lwjglx.opengl;

public class AMDDebugOutput {
    public static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
    public static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
    public static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
    public static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;
    public static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
    public static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
    public static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
    public static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
    public static final int GL_DEBUG_LOGGED_MESSAGES_AMD = 37189;
    public static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
    public static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_AMD = 37188;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_AMD = 37187;

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
