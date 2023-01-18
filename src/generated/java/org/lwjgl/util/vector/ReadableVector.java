package org.lwjgl.util.vector;

public interface ReadableVector {
    public abstract float length();

    public abstract float lengthSquared();

    public abstract org.lwjgl.util.vector.Vector store(java.nio.FloatBuffer arg0);
}
