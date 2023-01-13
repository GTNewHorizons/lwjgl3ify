package org.lwjglx.opengl;

public class EXTTimerQuery {
    public static void glGetQueryObjectEXT(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.EXTTimerQuery.glGetQueryObjecti64vEXT(arg0, arg1, arg2);
    }

    public static void glGetQueryObjectuEXT(int arg0, int arg1, java.nio.LongBuffer arg2) {
        org.lwjgl.opengl.EXTTimerQuery.glGetQueryObjectui64vEXT(arg0, arg1, arg2);
    }


}
