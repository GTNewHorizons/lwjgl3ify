package org.lwjglx.input;

import static org.lwjgl.sdl.SDLMouse.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.sdl.SDLVideo;
import org.lwjgl.sdl.SDL_MouseMotionEvent;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.Sys;
import org.lwjglx.opengl.Display;

import me.eigenraven.lwjgl3ify.api.FloatMouseHelper;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;

public class Mouse {

    // Fields for reflection compatibility with lwjgl2
    public static final int EVENT_SIZE = 1 + 1 + 4 + 4 + 4 + 8;
    private static ByteBuffer buttons = BufferUtils.createByteBuffer(32);
    private static IntBuffer coord_buffer = BufferUtils.createIntBuffer(32);
    private static ByteBuffer readBuffer = BufferUtils.createByteBuffer(32);

    private static boolean grabbed = false;

    private static int lastEventX = 0;
    private static int lastEventY = 0;

    private static int latestX = 0;
    private static int latestY = 0;

    private static int x = 0;
    private static int y = 0;

    private static int dx = 0, dy = 0, dwheel = 0;
    private static float dxFloat = 0, dyFloat = 0;

    private static EventQueue queue = new EventQueue(128);

    public static volatile int sdlMouseButtonFlags = 0;

    private static int[] buttonEvents = new int[queue.getMaxEvents()];
    private static boolean[] buttonEventStates = new boolean[queue.getMaxEvents()];
    private static int[] xEvents = new int[queue.getMaxEvents()];
    private static int[] yEvents = new int[queue.getMaxEvents()];
    private static int[] wheelEvents = new int[queue.getMaxEvents()];
    private static int[] lastxEvents = new int[queue.getMaxEvents()];
    private static int[] lastyEvents = new int[queue.getMaxEvents()];
    private static long[] nanoTimeEvents = new long[queue.getMaxEvents()];

    private static boolean clipPostionToDisplay = true;
    private static int ignoreNextDelta = 0;
    private static int ignoreNextMove = 0;

    public static int sdlToLwjglMouseButton(byte sdlMouseButton) {
        return switch (sdlMouseButton) {
            case SDL_BUTTON_LEFT -> 0;
            case SDL_BUTTON_RIGHT -> 1;
            case SDL_BUTTON_MIDDLE -> 2;
            case SDL_BUTTON_X1 -> 3;
            case SDL_BUTTON_X2 -> 4;
            default -> sdlMouseButton;
        };
    }

    public static byte lwjglToSdlMouseButton(int lwjglMouseButton) {
        return switch (lwjglMouseButton) {
            case 0 -> SDL_BUTTON_LEFT;
            case 1 -> SDL_BUTTON_RIGHT;
            case 2 -> SDL_BUTTON_MIDDLE;
            case 3 -> SDL_BUTTON_X1;
            case 4 -> SDL_BUTTON_X2;
            default -> (byte) lwjglMouseButton;
        };
    }

    // Accumulate small floating-point movements
    static float dxAccum = 0.0f, dyAccum = 0.0f;

    public static void addMoveEvent(SDL_MouseMotionEvent event) {
        if (ignoreNextMove > 0) {
            ignoreNextMove--;
            return;
        }
        float scale = Display.getPixelScaleFactor();
        final float mouseX = event.x() * scale;
        final float mouseY = event.y() * scale;
        // convert from screen-space coordinates to framebuffer coordinates
        dxFloat += event.xrel() * scale;
        dyFloat -= event.yrel() * scale;
        dxAccum += event.xrel() * scale;
        dyAccum -= event.yrel() * scale;
        final int wholeDx = Math.round(dxAccum), wholeDy = Math.round(dyAccum);
        dxAccum -= wholeDx;
        dyAccum -= wholeDy;
        dx += wholeDx;
        dy += wholeDy;
        latestX = (int) mouseX;
        latestY = Display.getHeight() - (int) mouseY;
        if (ignoreNextDelta > 0) {
            ignoreNextDelta--;
            x = latestX;
            y = latestY;
            lastEventX = latestX;
            lastEventY = latestY;
            dx = 0;
            dy = 0;
            dxAccum = 0;
            dyAccum = 0;
            dxFloat = 0;
            dyFloat = 0;
        }

        lastxEvents[queue.getNextPos()] = lastEventX;
        lastyEvents[queue.getNextPos()] = lastEventY;
        lastEventX = latestX;
        lastEventY = latestY;

        xEvents[queue.getNextPos()] = latestX;
        yEvents[queue.getNextPos()] = latestY;

        wheelEvents[queue.getNextPos()] = 0;

        buttonEvents[queue.getNextPos()] = -1;
        buttonEventStates[queue.getNextPos()] = false;

        nanoTimeEvents[queue.getNextPos()] = Sys.getNanoTime();

        queue.add();
    }

    public static void addButtonEvent(int button, boolean pressed) {
        lastxEvents[queue.getNextPos()] = lastEventX;
        lastyEvents[queue.getNextPos()] = lastEventY;
        lastEventX = latestX;
        lastEventY = latestY;

        xEvents[queue.getNextPos()] = latestX;
        yEvents[queue.getNextPos()] = latestY;

        wheelEvents[queue.getNextPos()] = 0;

        buttonEvents[queue.getNextPos()] = button;
        buttonEventStates[queue.getNextPos()] = pressed;

        nanoTimeEvents[queue.getNextPos()] = Sys.getNanoTime();

        queue.add();
    }

    static double fractionalWheelPosition = 0.0;
    // Used for our config screen for ease of access
    public static double totalScrollAmount = 0.0;

    public static void addWheelEvent(double delta) {
        if (Config.INPUT_INVERT_WHEEL) {
            delta = -delta;
        }
        delta *= Config.INPUT_SCROLL_SPEED;
        if (Config.FORCE_DISCRETE_SCROLLING) {
            delta = Math.signum(delta);
        }

        final int lastWheel = (int) fractionalWheelPosition;
        fractionalWheelPosition += delta;
        totalScrollAmount += delta;
        final int newWheel = (int) fractionalWheelPosition;
        if (newWheel != lastWheel) {
            lastxEvents[queue.getNextPos()] = lastEventX;
            lastyEvents[queue.getNextPos()] = lastEventY;
            lastEventX = latestX;
            lastEventY = latestY;
            dwheel += newWheel - lastWheel;

            xEvents[queue.getNextPos()] = latestX;
            yEvents[queue.getNextPos()] = latestY;

            wheelEvents[queue.getNextPos()] = newWheel - lastWheel;

            buttonEvents[queue.getNextPos()] = -1;
            buttonEventStates[queue.getNextPos()] = false;

            nanoTimeEvents[queue.getNextPos()] = Sys.getNanoTime();

            queue.add();
        }
        fractionalWheelPosition = fractionalWheelPosition % 1;
    }

    public static void poll() {

        if (!grabbed && clipPostionToDisplay) {
            if (latestX < 0) latestX = 0;
            if (latestY < 0) latestY = 0;
            if (latestX > Display.getWidth() - 1) latestX = Display.getWidth() - 1;
            if (latestY > Display.getHeight() - 1) latestY = Display.getHeight() - 1;
        }

        x = latestX;
        y = latestY;
    }

    public static void create() {
        if (currentCursor != null) {
            setNativeCursor(currentCursor);
        }
    }

    public static boolean isCreated() {
        return Display.isCreated();
    }

    public static void setGrabbed(boolean grab) {
        if (grabbed == grab) {
            return;
        }
        MainThreadExec.runOnMainThread(() -> {
            try (final MemoryStack ms = MemoryStack.stackPush()) {
                final IntBuffer w = ms.ints(0);
                final IntBuffer h = ms.ints(0);
                SDLVideo.SDL_GetWindowSize(Display.getWindow(), w, h);
                if (!grab) {
                    SDL_WarpMouseInWindow(Display.getWindow(), w.get(0) / 2.0f, h.get(0) / 2.0f);
                }
                SDL_SetWindowRelativeMouseMode(Display.getWindow(), grab);
                if (!grab) {
                    SDL_WarpMouseInWindow(Display.getWindow(), w.get(0) / 2.0f, h.get(0) / 2.0f);
                }
                dx = 0;
                dy = 0;
                dxAccum = 0;
                dyAccum = 0;
                dxFloat = 0;
                dyFloat = 0;
            }
        });
        grabbed = grab;
    }

    public static boolean isGrabbed() {
        return grabbed;
    }

    public static boolean isButtonDown(int button) {
        return (sdlMouseButtonFlags & (1 << (lwjglToSdlMouseButton(button) - 1))) != 0;
    }

    public static boolean next() {
        return queue.next();
    }

    public static int getEventX() {
        return xEvents[queue.getCurrentPos()];
    }

    public static int getEventY() {
        return yEvents[queue.getCurrentPos()];
    }

    public static int getEventDX() {
        return xEvents[queue.getCurrentPos()] - lastxEvents[queue.getCurrentPos()];
    }

    public static int getEventDY() {
        return yEvents[queue.getCurrentPos()] - lastyEvents[queue.getCurrentPos()];
    }

    public static long getEventNanoseconds() {
        return nanoTimeEvents[queue.getCurrentPos()];
    }

    public static int getEventButton() {
        return buttonEvents[queue.getCurrentPos()];
    }

    public static boolean getEventButtonState() {
        return buttonEventStates[queue.getCurrentPos()];
    }

    public static int getEventDWheel() {
        return wheelEvents[queue.getCurrentPos()];
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static int getDX() {
        int value = dx;
        dx = 0;
        dxFloat = 0;
        return value;
    }

    public static int getDY() {
        int value = dy;
        dy = 0;
        dyFloat = 0;
        return value;
    }

    public static float lwjgl3ify$getDXFloat() {
        float value = dxFloat;
        dx = 0;
        dxFloat = 0;
        return value;
    }

    public static float lwjgl3ify$getDYFloat() {
        float value = dyFloat;
        dy = 0;
        dyFloat = 0;
        return value;
    }

    public static void lwjgl3ify$updateMouseHelper(FloatMouseHelper mouseHelper) {
        mouseHelper.lwjgl3ify$setIntDX(dx);
        mouseHelper.lwjgl3ify$setIntDY(dy);
        mouseHelper.lwjgl3ify$setFloatDX(dxFloat);
        mouseHelper.lwjgl3ify$setFloatDY(dyFloat);
        dx = 0;
        dxFloat = 0;
        dy = 0;
        dyFloat = 0;
    }

    public static int getDWheel() {
        int value = dwheel;
        dwheel = 0;
        return value;
    }

    public static int getButtonCount() {
        return 8; // max mouse buttons supported by GLFW
    }

    public static void setClipMouseCoordinatesToWindow(boolean clip) {
        clipPostionToDisplay = clip;
    }

    public static void setCursorPosition(int new_x, int new_y) {
        if (grabbed) {
            return;
        }
        // convert back from framebuffer coordinates to screen-space coordinates
        float inv_scale = 1.0f / Display.getPixelScaleFactor();
        MainThreadExec.runOnMainThread(
            () -> { SDL_WarpMouseInWindow(Display.getWindow(), new_x * inv_scale, new_y * inv_scale); });
    }

    private static Cursor currentCursor;
    private static long systemCursor;

    public static synchronized Cursor getNativeCursor() {
        return currentCursor;
    }

    public static synchronized Cursor setNativeCursor(final Cursor cursor) {
        final Cursor prevCursor = currentCursor;
        currentCursor = cursor;
        if (!Display.isCreated()) {
            return prevCursor;
        }

        if (cursor == null) {
            if (systemCursor == 0) {
                systemCursor = Sys.checkSdl(SDL_CreateSystemCursor(SDL_SYSTEM_CURSOR_DEFAULT));
            }
            MainThreadExec.runOnMainThread(() -> SDL_SetCursor(systemCursor));
        } else {
            cursor.sdlSet();
        }

        return prevCursor;
    }

    public static void destroy() {}

    public static int getButtonIndex(String buttonName) {
        if (buttonName.matches("BUTTON[0-9]+")) {
            return Integer.parseInt(StringUtils.removeStart(buttonName, "BUTTON"));
        } else {
            return -1;
        }
    }

    public static String getButtonName(int button) {
        return "BUTTON" + button;
    }

    public static boolean hasWheel() {
        return true;
    }

    public static boolean isClipMouseCoordinatesToWindow() {
        return clipPostionToDisplay;
    }

    public static boolean isInsideWindow() {
        return Display.isVisible();
    }

    public static void updateCursor() {
        // no-op
    }
}
