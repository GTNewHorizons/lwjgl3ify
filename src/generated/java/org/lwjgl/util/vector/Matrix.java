package org.lwjgl.util.vector;

public abstract class Matrix {
    public abstract float determinant();

    public abstract org.lwjgl.util.vector.Matrix invert();

    public abstract org.lwjgl.util.vector.Matrix load(java.nio.FloatBuffer arg0);

    public abstract org.lwjgl.util.vector.Matrix loadTranspose(java.nio.FloatBuffer arg0);

    public abstract org.lwjgl.util.vector.Matrix negate();

    public abstract org.lwjgl.util.vector.Matrix setIdentity();

    public abstract org.lwjgl.util.vector.Matrix setZero();

    public abstract org.lwjgl.util.vector.Matrix store(java.nio.FloatBuffer arg0);

    public abstract org.lwjgl.util.vector.Matrix storeTranspose(java.nio.FloatBuffer arg0);

    public abstract org.lwjgl.util.vector.Matrix transpose();
}
