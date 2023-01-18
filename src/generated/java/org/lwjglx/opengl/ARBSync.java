package org.lwjglx.opengl;

public class ARBSync {
    public static final int GL_ALREADY_SIGNALED = 37146;
    public static final int GL_CONDITION_SATISFIED = 37148;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
    public static final int GL_OBJECT_TYPE = 37138;
    public static final int GL_SIGNALED = 37145;
    public static final int GL_SYNC_CONDITION = 37139;
    public static final int GL_SYNC_FENCE = 37142;
    public static final int GL_SYNC_FLAGS = 37141;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
    public static final int GL_SYNC_STATUS = 37140;
    public static final int GL_TIMEOUT_EXPIRED = 37147;
    public static final long GL_TIMEOUT_IGNORED = -1;
    public static final int GL_UNSIGNALED = 37144;
    public static final int GL_WAIT_FAILED = 37149;

    public static long glGetInteger64(int pname) {
        return org.lwjgl.opengl.ARBSync.glGetInteger64(pname);
    }
}
