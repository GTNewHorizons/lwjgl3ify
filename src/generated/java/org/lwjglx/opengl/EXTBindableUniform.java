package org.lwjglx.opengl;

public class EXTBindableUniform {
    public static int glGetUniformBufferSizeEXT(int program, int location) {
        return org.lwjgl.opengl.EXTBindableUniform.glGetUniformBufferSizeEXT(program, location);
    }

    public static long glGetUniformOffsetEXT(int program, int location) {
        return org.lwjgl.opengl.EXTBindableUniform.glGetUniformOffsetEXT(program, location);
    }

    public static void glUniformBufferEXT(int program, int location, int buffer) {
        org.lwjgl.opengl.EXTBindableUniform.glUniformBufferEXT(program, location, buffer);
    }
}
