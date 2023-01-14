package org.lwjglx.opengl;

public class ARBProgramInterfaceQuery {
    public static int glGetProgramInterfacei(int program, int programInterface, int pname) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramInterfacei(program, programInterface, pname);
    }

    public static int glGetProgramResourceIndex(int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static int glGetProgramResourceIndex(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceIndex(program, programInterface, name);
    }

    public static int glGetProgramResourceLocation(int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int glGetProgramResourceLocation(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocation(program, programInterface, name);
    }

    public static int glGetProgramResourceLocationIndex(
            int program, int programInterface, java.lang.CharSequence name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocationIndex(
                program, programInterface, name);
    }

    public static int glGetProgramResourceLocationIndex(int program, int programInterface, java.nio.ByteBuffer name) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocationIndex(
                program, programInterface, name);
    }

    public static java.lang.String glGetProgramResourceName(int program, int programInterface, int index, int bufSize) {
        return org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceName(
                program, programInterface, index, bufSize);
    }

    public static void glGetProgramResourceName(
            int program, int programInterface, int index, java.nio.IntBuffer length, java.nio.ByteBuffer name) {
        org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceName(
                program, programInterface, index, length, name);
    }
}
