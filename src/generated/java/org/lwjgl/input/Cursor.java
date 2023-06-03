package org.lwjgl.input;

public class Cursor {

    public static final int CURSOR_8_BIT_ALPHA = (int) 2;
    public static final int CURSOR_ANIMATION = (int) 4;
    public static final int CURSOR_ONE_BIT_TRANSPARENCY = (int) 1;

    public void destroy() {
        throw new UnsupportedOperationException();
    }

    public static int getCapabilities() {
        throw new UnsupportedOperationException();
    }

    public static int getMaxCursorSize() {
        throw new UnsupportedOperationException();
    }

    public static int getMinCursorSize() {
        throw new UnsupportedOperationException();
    }

}
