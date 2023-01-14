package org.lwjglx.opengl;

public class ARBTimerQuery {
    public static long glGetQueryObjecti64(int id, int pname) {
        return org.lwjgl.opengl.ARBTimerQuery.glGetQueryObjecti64(id, pname);
    }

    public static long glGetQueryObjectui64(int id, int pname) {
        return org.lwjgl.opengl.ARBTimerQuery.glGetQueryObjectui64(id, pname);
    }

    public static void glQueryCounter(int id, int target) {
        org.lwjgl.opengl.ARBTimerQuery.glQueryCounter(id, target);
    }
}
