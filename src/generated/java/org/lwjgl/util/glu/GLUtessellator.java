package org.lwjgl.util.glu;

public interface GLUtessellator {

    public abstract void gluBeginPolygon();

    public abstract void gluDeleteTess();

    public abstract void gluEndPolygon();

    public abstract void gluGetTessProperty(int arg0, double[] arg1, int arg2);

    public abstract void gluNextContour(int arg0);

    public abstract void gluTessBeginContour();

    public abstract void gluTessBeginPolygon(java.lang.Object arg0);

    public abstract void gluTessCallback(int arg0, org.lwjgl.util.glu.GLUtessellatorCallback arg1);

    public abstract void gluTessEndContour();

    public abstract void gluTessEndPolygon();

    public abstract void gluTessNormal(double arg0, double arg1, double arg2);

    public abstract void gluTessProperty(int arg0, double arg1);

    public abstract void gluTessVertex(double[] arg0, int arg1, java.lang.Object arg2);

}
