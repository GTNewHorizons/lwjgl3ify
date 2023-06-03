package org.lwjgl.opengl;

public interface Drawable {

    public abstract void destroy();

    public abstract boolean isCurrent();

    public abstract void makeCurrent();

    public abstract void releaseContext();

    public abstract void setCLSharingProperties(org.lwjgl.PointerBuffer arg0);

}
