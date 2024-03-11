package org.lwjgl.input;

import org.lwjglx.LWJGLException;

public class Mouse {

    public static final int EVENT_SIZE = (int) 22;

    public static void create() throws LWJGLException {
        org.lwjglx.input.Mouse.create();
    }

    public static void destroy() {
        org.lwjglx.input.Mouse.destroy();
    }

    public static int getButtonCount() {
        return org.lwjglx.input.Mouse.getButtonCount();
    }

    public static int getButtonIndex(java.lang.String arg0) {
        return org.lwjglx.input.Mouse.getButtonIndex(arg0);
    }

    public static java.lang.String getButtonName(int arg0) {
        return org.lwjglx.input.Mouse.getButtonName(arg0);
    }

    public static int getDWheel() {
        return org.lwjglx.input.Mouse.getDWheel();
    }

    public static int getDX() {
        return org.lwjglx.input.Mouse.getDX();
    }

    public static int getDY() {
        return org.lwjglx.input.Mouse.getDY();
    }

    public static int getEventButton() {
        return org.lwjglx.input.Mouse.getEventButton();
    }

    public static boolean getEventButtonState() {
        return org.lwjglx.input.Mouse.getEventButtonState();
    }

    public static int getEventDWheel() {
        return org.lwjglx.input.Mouse.getEventDWheel();
    }

    public static int getEventDX() {
        return org.lwjglx.input.Mouse.getEventDX();
    }

    public static int getEventDY() {
        return org.lwjglx.input.Mouse.getEventDY();
    }

    public static long getEventNanoseconds() {
        return org.lwjglx.input.Mouse.getEventNanoseconds();
    }

    public static int getEventX() {
        return org.lwjglx.input.Mouse.getEventX();
    }

    public static int getEventY() {
        return org.lwjglx.input.Mouse.getEventY();
    }

    public static org.lwjgl.input.Cursor getNativeCursor() {
        return null;
    }

    public static int getX() {
        return org.lwjglx.input.Mouse.getX();
    }

    public static int getY() {
        return org.lwjglx.input.Mouse.getY();
    }

    public static boolean hasWheel() {
        return org.lwjglx.input.Mouse.hasWheel();
    }

    public static boolean isButtonDown(int arg0) {
        return org.lwjglx.input.Mouse.isButtonDown(arg0);
    }

    public static boolean isClipMouseCoordinatesToWindow() {
        return org.lwjglx.input.Mouse.isClipMouseCoordinatesToWindow();
    }

    public static boolean isCreated() {
        return org.lwjglx.input.Mouse.isCreated();
    }

    public static boolean isGrabbed() {
        return org.lwjglx.input.Mouse.isGrabbed();
    }

    public static boolean isInsideWindow() {
        return org.lwjglx.input.Mouse.isInsideWindow();
    }

    public static boolean next() {
        return org.lwjglx.input.Mouse.next();
    }

    public static void poll() {
        org.lwjglx.input.Mouse.poll();
    }

    public static void setClipMouseCoordinatesToWindow(boolean arg0) {
        org.lwjglx.input.Mouse.setClipMouseCoordinatesToWindow(arg0);
    }

    public static void setCursorPosition(int arg0, int arg1) {
        org.lwjglx.input.Mouse.setCursorPosition(arg0, arg1);
    }

    public static void setGrabbed(boolean arg0) {
        org.lwjglx.input.Mouse.setGrabbed(arg0);
    }

    public static org.lwjgl.input.Cursor setNativeCursor(org.lwjgl.input.Cursor arg0) {
        return null;
    }

    public static void updateCursor() {
        org.lwjglx.input.Mouse.updateCursor();
    }
}
