package org.lwjgl.util;

public interface ReadableColor {

    public static final org.lwjgl.util.ReadableColor BLACK = null;
    public static final org.lwjgl.util.ReadableColor BLUE = null;
    public static final org.lwjgl.util.ReadableColor CYAN = null;
    public static final org.lwjgl.util.ReadableColor DKGREY = null;
    public static final org.lwjgl.util.ReadableColor GREEN = null;
    public static final org.lwjgl.util.ReadableColor GREY = null;
    public static final org.lwjgl.util.ReadableColor LTGREY = null;
    public static final org.lwjgl.util.ReadableColor ORANGE = null;
    public static final org.lwjgl.util.ReadableColor PURPLE = null;
    public static final org.lwjgl.util.ReadableColor RED = null;
    public static final org.lwjgl.util.ReadableColor WHITE = null;
    public static final org.lwjgl.util.ReadableColor YELLOW = null;

    public abstract int getAlpha();

    public abstract byte getAlphaByte();

    public abstract int getBlue();

    public abstract byte getBlueByte();

    public abstract int getGreen();

    public abstract byte getGreenByte();

    public abstract int getRed();

    public abstract byte getRedByte();

    public abstract void writeABGR(java.nio.ByteBuffer arg0);

    public abstract void writeARGB(java.nio.ByteBuffer arg0);

    public abstract void writeBGR(java.nio.ByteBuffer arg0);

    public abstract void writeBGRA(java.nio.ByteBuffer arg0);

    public abstract void writeRGB(java.nio.ByteBuffer arg0);

    public abstract void writeRGBA(java.nio.ByteBuffer arg0);

}
