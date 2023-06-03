package org.lwjgl.util;

public interface WritableRectangle {

    public abstract void setBounds(int arg0, int arg1, int arg2, int arg3);

    public abstract void setBounds(org.lwjgl.util.ReadablePoint arg0, org.lwjgl.util.ReadableDimension arg1);

    public abstract void setBounds(org.lwjgl.util.ReadableRectangle arg0);

}
