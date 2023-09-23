package org.lwjgl.opengl;

public interface InputImplementation {

    public abstract java.lang.Object createCursor(int arg0, int arg1, int arg2, int arg3, int arg4,
        java.nio.IntBuffer arg5, java.nio.IntBuffer arg6);

    public abstract void createKeyboard();

    public abstract void createMouse();

    public abstract void destroyCursor(java.lang.Object arg0);

    public abstract void destroyKeyboard();

    public abstract void destroyMouse();

    public abstract int getButtonCount();

    public abstract int getHeight();

    public abstract int getMaxCursorSize();

    public abstract int getMinCursorSize();

    public abstract int getNativeCursorCapabilities();

    public abstract int getWidth();

    public abstract void grabMouse(boolean arg0);

    public abstract boolean hasWheel();

    public abstract boolean isInsideWindow();

    public abstract void pollKeyboard(java.nio.ByteBuffer arg0);

    public abstract void pollMouse(java.nio.IntBuffer arg0, java.nio.ByteBuffer arg1);

    public abstract void readKeyboard(java.nio.ByteBuffer arg0);

    public abstract void readMouse(java.nio.ByteBuffer arg0);

    public abstract void setCursorPosition(int arg0, int arg1);

    public abstract void setNativeCursor(java.lang.Object arg0);

}
