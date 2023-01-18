package org.lwjglx.opengl;

public class ARBGetProgramBinary {
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;

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
