package org.lwjglx.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class ARBSync {

    public static final int GL_ALREADY_SIGNALED = (int) 37146;
    public static final int GL_CONDITION_SATISFIED = (int) 37148;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = (int) 37137;
    public static final int GL_OBJECT_TYPE = (int) 37138;
    public static final int GL_SIGNALED = (int) 37145;
    public static final int GL_SYNC_CONDITION = (int) 37139;
    public static final int GL_SYNC_FENCE = (int) 37142;
    public static final int GL_SYNC_FLAGS = (int) 37141;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = (int) 1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = (int) 37143;
    public static final int GL_SYNC_STATUS = (int) 37140;
    public static final int GL_TIMEOUT_EXPIRED = (int) 37147;
    public static final long GL_TIMEOUT_IGNORED = (long) -1;
    public static final int GL_UNSIGNALED = (int) 37144;
    public static final int GL_WAIT_FAILED = (int) 37149;

    public static long glGetInteger64(int pname) {
        return org.lwjgl.opengl.ARBSync.glGetInteger64(pname);
    }

    public static org.lwjglx.opengl.GLSync glFenceSync(int condition, int flags) {
        return new org.lwjglx.opengl.GLSync(org.lwjgl.opengl.ARBSync.glFenceSync(condition, flags));
    }

    public static boolean glIsSync(org.lwjglx.opengl.GLSync sync) {
        return org.lwjgl.opengl.ARBSync.glIsSync(sync.getPointer());
    }

    public static void glDeleteSync(org.lwjglx.opengl.GLSync sync) {
        org.lwjgl.opengl.ARBSync.glDeleteSync(sync.getPointer());
    }

    public static int glClientWaitSync(org.lwjglx.opengl.GLSync sync, int flags, long timeout) {
        return org.lwjgl.opengl.ARBSync.glClientWaitSync(sync.getPointer(), flags, timeout);
    }

    public static void glWaitSync(org.lwjglx.opengl.GLSync sync, int flags, long timeout) {
        org.lwjgl.opengl.ARBSync.glWaitSync(sync.getPointer(), flags, timeout);
    }

    public static void glGetInteger64(int pname, LongBuffer params) {
        org.lwjgl.opengl.ARBSync.glGetInteger64v(pname, params);
    }

    public static void glGetSync(org.lwjglx.opengl.GLSync sync, int pname, IntBuffer length, IntBuffer values) {
        org.lwjgl.opengl.ARBSync.glGetSynciv(sync.getPointer(), pname, length, values);
    }

    /**
     * Overloads glGetSynciv.
     * <p>
     * 
     * @deprecated Will be removed in 3.0. Use {@link #glGetSynci} instead.
     */
    @Deprecated
    public static int glGetSync(org.lwjglx.opengl.GLSync sync, int pname) {
        return org.lwjgl.opengl.ARBSync.glGetSynci(sync.getPointer(), pname, null);
    }

    /** Overloads glGetSynciv. */
    public static int glGetSynci(org.lwjglx.opengl.GLSync sync, int pname) {
        return org.lwjgl.opengl.ARBSync.glGetSynci(sync.getPointer(), pname, null);
    }
}
