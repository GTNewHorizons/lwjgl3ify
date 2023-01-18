package org.lwjgl.util.vector;

public abstract class Vector {
    public final float length() {
        throw new UnsupportedOperationException();
    }

    public abstract float lengthSquared();

    public abstract org.lwjgl.util.vector.Vector load(java.nio.FloatBuffer arg0);

    public abstract org.lwjgl.util.vector.Vector negate();

    public final org.lwjgl.util.vector.Vector normalise() {
        throw new UnsupportedOperationException();
    }

    public abstract org.lwjgl.util.vector.Vector scale(float arg0);

    public abstract org.lwjgl.util.vector.Vector store(java.nio.FloatBuffer arg0);
}
