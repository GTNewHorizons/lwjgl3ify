package org.lwjglx.opengl;

public class EXTTimerQuery {
    public static void glGetQueryObjectEXT(int id, int pname, java.nio.LongBuffer params) {
        org.lwjgl.opengl.EXTTimerQuery.glGetQueryObjecti64vEXT(id, pname, params);
    }

    public static void glGetQueryObjectuEXT(int id, int pname, java.nio.LongBuffer params) {
        org.lwjgl.opengl.EXTTimerQuery.glGetQueryObjectui64vEXT(id, pname, params);
    }
}
