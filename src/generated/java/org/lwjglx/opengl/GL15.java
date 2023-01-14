package org.lwjglx.opengl;

public class GL15 {
    public static void glBeginQuery(int target, int id) {
        org.lwjgl.opengl.GL15.glBeginQuery(target, id);
    }

    public static void glBindBuffer(int target, int buffer) {
        org.lwjgl.opengl.GL15.glBindBuffer(target, buffer);
    }

    public static void glBufferData(int target, long data_size, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data_size, usage);
    }

    public static void glBufferData(int target, java.nio.ByteBuffer data, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data, usage);
    }

    public static void glBufferData(int target, java.nio.DoubleBuffer data, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data, usage);
    }

    public static void glBufferData(int target, java.nio.FloatBuffer data, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data, usage);
    }

    public static void glBufferData(int target, java.nio.IntBuffer data, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data, usage);
    }

    public static void glBufferData(int target, java.nio.ShortBuffer data, int usage) {
        org.lwjgl.opengl.GL15.glBufferData(target, data, usage);
    }

    public static void glBufferSubData(int target, long offset, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL15.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(int target, long offset, java.nio.DoubleBuffer data) {
        org.lwjgl.opengl.GL15.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(int target, long offset, java.nio.FloatBuffer data) {
        org.lwjgl.opengl.GL15.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(int target, long offset, java.nio.IntBuffer data) {
        org.lwjgl.opengl.GL15.glBufferSubData(target, offset, data);
    }

    public static void glBufferSubData(int target, long offset, java.nio.ShortBuffer data) {
        org.lwjgl.opengl.GL15.glBufferSubData(target, offset, data);
    }

    public static void glDeleteBuffers(int buffer) {
        org.lwjgl.opengl.GL15.glDeleteBuffers(buffer);
    }

    public static void glDeleteBuffers(java.nio.IntBuffer buffers) {
        org.lwjgl.opengl.GL15.glDeleteBuffers(buffers);
    }

    public static void glDeleteQueries(int id) {
        org.lwjgl.opengl.GL15.glDeleteQueries(id);
    }

    public static void glDeleteQueries(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.GL15.glDeleteQueries(ids);
    }

    public static void glEndQuery(int target) {
        org.lwjgl.opengl.GL15.glEndQuery(target);
    }

    public static int glGenBuffers() {
        return org.lwjgl.opengl.GL15.glGenBuffers();
    }

    public static void glGenBuffers(java.nio.IntBuffer buffers) {
        org.lwjgl.opengl.GL15.glGenBuffers(buffers);
    }

    public static int glGenQueries() {
        return org.lwjgl.opengl.GL15.glGenQueries();
    }

    public static void glGenQueries(java.nio.IntBuffer ids) {
        org.lwjgl.opengl.GL15.glGenQueries(ids);
    }

    public static void glGetBufferParameter(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL15.glGetBufferParameteriv(target, pname, params);
    }

    public static int glGetBufferParameteri(int target, int pname) {
        return org.lwjgl.opengl.GL15.glGetBufferParameteri(target, pname);
    }

    public static void glGetBufferSubData(int target, long offset, java.nio.ByteBuffer data) {
        org.lwjgl.opengl.GL15.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(int target, long offset, java.nio.DoubleBuffer data) {
        org.lwjgl.opengl.GL15.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(int target, long offset, java.nio.FloatBuffer data) {
        org.lwjgl.opengl.GL15.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(int target, long offset, java.nio.IntBuffer data) {
        org.lwjgl.opengl.GL15.glGetBufferSubData(target, offset, data);
    }

    public static void glGetBufferSubData(int target, long offset, java.nio.ShortBuffer data) {
        org.lwjgl.opengl.GL15.glGetBufferSubData(target, offset, data);
    }

    public static void glGetQuery(int target, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL15.glGetQueryiv(target, pname, params);
    }

    public static void glGetQueryObject(int id, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL15.glGetQueryObjectiv(id, pname, params);
    }

    public static int glGetQueryObjecti(int id, int pname) {
        return org.lwjgl.opengl.GL15.glGetQueryObjecti(id, pname);
    }

    public static void glGetQueryObjectu(int id, int pname, java.nio.IntBuffer params) {
        org.lwjgl.opengl.GL15.glGetQueryObjectuiv(id, pname, params);
    }

    public static int glGetQueryObjectui(int id, int pname) {
        return org.lwjgl.opengl.GL15.glGetQueryObjectui(id, pname);
    }

    public static int glGetQueryi(int target, int pname) {
        return org.lwjgl.opengl.GL15.glGetQueryi(target, pname);
    }

    public static boolean glIsBuffer(int buffer) {
        return org.lwjgl.opengl.GL15.glIsBuffer(buffer);
    }

    public static boolean glIsQuery(int id) {
        return org.lwjgl.opengl.GL15.glIsQuery(id);
    }

    public static java.nio.ByteBuffer glMapBuffer(int target, int access, long length, java.nio.ByteBuffer old_buffer) {
        return org.lwjgl.opengl.GL15.glMapBuffer(target, access, length, old_buffer);
    }

    public static java.nio.ByteBuffer glMapBuffer(int target, int access, java.nio.ByteBuffer old_buffer) {
        return org.lwjgl.opengl.GL15.glMapBuffer(target, access, old_buffer);
    }

    public static boolean glUnmapBuffer(int target) {
        return org.lwjgl.opengl.GL15.glUnmapBuffer(target);
    }
}
