package org.lwjglx.opengl;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryStack;

public class APPLEObjectPurgeable {

    public static final int GL_BUFFER_OBJECT_APPLE = (int) 34227;
    public static final int GL_PURGEABLE_APPLE = (int) 35357;
    public static final int GL_RELEASED_APPLE = (int) 35353;
    public static final int GL_RETAINED_APPLE = (int) 35355;
    public static final int GL_UNDEFINED_APPLE = (int) 35356;
    public static final int GL_VOLATILE_APPLE = (int) 35354;

    public static void glGetObjectParameterAPPLE(int objectType, int name, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.APPLEObjectPurgeable.glGetObjectParameterivAPPLE(objectType, name, pname, params);
    }

    public static int glGetObjectParameteriAPPLE(int objectType, int name, int pname) {
        try (MemoryStack ms = MemoryStack.stackPush()) {
            IntBuffer val = ms.ints(1);
            org.lwjgl.opengl.APPLEObjectPurgeable.glGetObjectParameterivAPPLE(objectType, name, pname, val);
            return val.get(0);
        }
    }

    public static int glObjectPurgeableAPPLE(int objectType, int name, int option) {
        return org.lwjgl.opengl.APPLEObjectPurgeable.glObjectPurgeableAPPLE(objectType, name, option);
    }

    public static int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
        return org.lwjgl.opengl.APPLEObjectPurgeable.glObjectUnpurgeableAPPLE(objectType, name, option);
    }

}
