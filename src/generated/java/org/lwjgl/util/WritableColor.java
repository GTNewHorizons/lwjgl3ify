package org.lwjgl.util;

public interface WritableColor {

    public abstract void readABGR(java.nio.ByteBuffer arg0);

    public abstract void readARGB(java.nio.ByteBuffer arg0);

    public abstract void readBGR(java.nio.ByteBuffer arg0);

    public abstract void readBGRA(java.nio.ByteBuffer arg0);

    public abstract void readRGB(java.nio.ByteBuffer arg0);

    public abstract void readRGBA(java.nio.ByteBuffer arg0);

    public abstract void set(byte arg0, byte arg1, byte arg2);

    public abstract void set(byte arg0, byte arg1, byte arg2, byte arg3);

    public abstract void set(int arg0, int arg1, int arg2);

    public abstract void set(int arg0, int arg1, int arg2, int arg3);

    public abstract void setAlpha(byte arg0);

    public abstract void setAlpha(int arg0);

    public abstract void setBlue(byte arg0);

    public abstract void setBlue(int arg0);

    public abstract void setColor(org.lwjgl.util.ReadableColor arg0);

    public abstract void setGreen(byte arg0);

    public abstract void setGreen(int arg0);

    public abstract void setRed(byte arg0);

    public abstract void setRed(int arg0);

}
