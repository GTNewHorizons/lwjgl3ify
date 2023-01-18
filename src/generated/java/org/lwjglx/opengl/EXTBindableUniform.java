package org.lwjglx.opengl;

public class EXTBindableUniform {
    public static final int GL_MAX_BINDABLE_UNIFORM_SIZE_EXT = 36333;
    public static final int GL_MAX_FRAGMENT_BINDABLE_UNIFORMS_EXT = 36323;
    public static final int GL_MAX_GEOMETRY_BINDABLE_UNIFORMS_EXT = 36324;
    public static final int GL_MAX_VERTEX_BINDABLE_UNIFORMS_EXT = 36322;
    public static final int GL_UNIFORM_BUFFER_BINDING_EXT = 36335;
    public static final int GL_UNIFORM_BUFFER_EXT = 36334;

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
