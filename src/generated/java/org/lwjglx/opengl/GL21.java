package org.lwjglx.opengl;

public class GL21 {
    public static void glUniformMatrix2x3(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix2x3fv(location, transpose, matrices);
    }

    public static void glUniformMatrix2x4(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix2x4fv(location, transpose, matrices);
    }

    public static void glUniformMatrix3x2(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix3x2fv(location, transpose, matrices);
    }

    public static void glUniformMatrix3x4(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix3x4fv(location, transpose, matrices);
    }

    public static void glUniformMatrix4x2(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix4x2fv(location, transpose, matrices);
    }

    public static void glUniformMatrix4x3(int location, boolean transpose, java.nio.FloatBuffer matrices) {
        org.lwjgl.opengl.GL21.glUniformMatrix4x3fv(location, transpose, matrices);
    }
}
