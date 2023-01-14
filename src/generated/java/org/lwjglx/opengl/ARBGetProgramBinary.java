package org.lwjglx.opengl;

public class ARBGetProgramBinary {
    public static void glGetProgramBinary(
            int program, java.nio.IntBuffer length, java.nio.IntBuffer binaryFormat, java.nio.ByteBuffer binary) {
        org.lwjgl.opengl.ARBGetProgramBinary.glGetProgramBinary(program, length, binaryFormat, binary);
    }

    public static void glProgramBinary(int program, int binaryFormat, java.nio.ByteBuffer binary) {
        org.lwjgl.opengl.ARBGetProgramBinary.glProgramBinary(program, binaryFormat, binary);
    }

    public static void glProgramParameteri(int program, int pname, int value) {
        org.lwjgl.opengl.ARBGetProgramBinary.glProgramParameteri(program, pname, value);
    }
}
