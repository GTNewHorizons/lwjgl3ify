package org.lwjgl.util.glu;

public interface GLUtessellatorCallback {

    public abstract void begin(int arg0);

    public abstract void beginData(int arg0, java.lang.Object arg1);

    public abstract void combine(double[] arg0, java.lang.Object[] arg1, float[] arg2, java.lang.Object[] arg3);

    public abstract void combineData(double[] arg0, java.lang.Object[] arg1, float[] arg2, java.lang.Object[] arg3,
        java.lang.Object arg4);

    public abstract void edgeFlag(boolean arg0);

    public abstract void edgeFlagData(boolean arg0, java.lang.Object arg1);

    public abstract void end();

    public abstract void endData(java.lang.Object arg0);

    public abstract void error(int arg0);

    public abstract void errorData(int arg0, java.lang.Object arg1);

    public abstract void vertex(java.lang.Object arg0);

    public abstract void vertexData(java.lang.Object arg0, java.lang.Object arg1);

}
