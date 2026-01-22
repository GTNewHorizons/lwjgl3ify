package org.lwjglx;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLKeyboard.*;
import static org.lwjgl.sdl.SDLKeycode.*;
import static org.lwjgl.sdl.SDLMouse.*;
import static org.lwjgl.sdl.SDLPixels.*;
import static org.lwjgl.sdl.SDLVideo.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.sdl.SDL_Event;
import org.lwjgl.sdl.SDL_KeyboardEvent;
import org.lwjgl.sdl.SDL_MouseButtonEvent;
import org.lwjgl.sdl.SDL_MouseMotionEvent;
import org.lwjgl.sdl.SDL_MouseWheelEvent;
import org.lwjgl.sdl.SDL_TextInputEvent;
import org.lwjgl.sdl.SDL_WindowEvent;
import org.lwjglx.input.KeyCodes;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;
import org.lwjglx.opengl.Display;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;

/**
 * Singleton (static) class for handling the SDL event loop on the correct main thread.
 */
public class Lwjgl3ifyEventLoop {

    /**
     * Call on the thread that called Java main() to process incoming SDL events.
     */
    public static void pumpEvents() {
        MainThreadExec.runOnMainThread(Lwjgl3ifyEventLoop::internalPumpEvents);
    }

    public static final SDL_Event event = SDL_Event.calloc();
    public static final SDL_WindowEvent windowEvent = event.window();
    public static final SDL_KeyboardEvent keyEvent = event.key();
    public static final SDL_TextInputEvent textEvent = event.text();
    public static final SDL_MouseMotionEvent mouseMotionEvent = event.motion();
    public static final SDL_MouseButtonEvent mouseButtonEvent = event.button();
    public static final SDL_MouseWheelEvent mouseWheelEvent = event.wheel();

    private static void internalPumpEvents() {
        if (!SDL_IsMainThread()) {
            throw new IllegalStateException("SDL Event pump called from a non-main thread " + Thread.currentThread());
        }
        while (SDL_PollEvent(event)) {
            if (Display.lwjgl3ify$handleSdlEvent()) {
                continue;
            }
            switch (event.type()) {
                case SDL_EVENT_MOUSE_MOTION -> {
                    if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                        Lwjgl3ify.LOG.info(
                            "[DEBUG-MOUSE] Motion ns:{} x:{} y:{} xrel:{} yrel:{}",
                            mouseMotionEvent.timestamp(),
                            mouseMotionEvent.x(),
                            mouseMotionEvent.y(),
                            mouseMotionEvent.xrel(),
                            mouseMotionEvent.yrel());
                    }
                    Mouse.addMoveEvent(mouseMotionEvent);
                }
                case SDL_EVENT_MOUSE_BUTTON_DOWN, SDL_EVENT_MOUSE_BUTTON_UP -> {
                    if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                        Lwjgl3ify.LOG.info(
                            "[DEBUG-MOUSE] Press ns:{} button:{} press:{} clicks:{} x:{} y:{}",
                            mouseButtonEvent.timestamp(),
                            mouseButtonEvent.button(),
                            mouseButtonEvent.down(),
                            mouseButtonEvent.clicks(),
                            mouseButtonEvent.x(),
                            mouseButtonEvent.y());
                    }
                    Mouse.addButtonEvent(
                        Mouse.sdlToLwjglMouseButton(mouseButtonEvent.button()),
                        event.type() == SDL_EVENT_MOUSE_BUTTON_DOWN);
                }
                case SDL_EVENT_MOUSE_WHEEL -> {
                    float xoffset = mouseWheelEvent.x();
                    float yoffset = mouseWheelEvent.y();
                    Mouse.addWheelEvent(yoffset == 0 ? (Config.INPUT_INVERT_X_WHEEL ? -xoffset : xoffset) : yoffset);
                }
                case SDL_EVENT_KEYMAP_CHANGED -> {
                    Lwjgl3ify.LOG.info("System keyboard layout changed, reloading key names");
                    Keyboard.populateKeyLookupTables();
                }
                case SDL_EVENT_KEY_DOWN, SDL_EVENT_KEY_UP -> {
                    handleKeyEvent();
                }
                case SDL_EVENT_TEXT_INPUT -> {
                    handleTextEvent();
                }
                default -> {}
            }
        }
        Mouse.sdlMouseButtonFlags = nSDL_GetMouseState(0, 0);
    }

    private static char rawKeyCodeToChar(int rawKeyCode) {
        if (rawKeyCode < 0xFFFF) {
            return (char) rawKeyCode;
        } else {
            return '\0';
        }
    }

    // Assumes event type of SDL_EVENT_KEY_DOWN or SDL_EVENT_KEY_UP
    private static void handleKeyEvent() {
        final long ns = keyEvent.timestamp();
        final boolean isDown = keyEvent.down();
        final boolean isRepeat = keyEvent.repeat();
        final short kmods = keyEvent.mod();
        final int keyCode = keyEvent.key();
        final int scanCode = keyEvent.scancode();
        final long keyNamePtr = nSDL_GetKeyName(keyCode);
        final int rawKeyCode = SDL_GetKeyFromScancode(scanCode, kmods, false);
        final int lwjgl2KeyCode = KeyCodes.sdlKeycodeToLwjgl(keyCode);
        final int lwjgl2ScanCode = KeyCodes.sdlScancodeToLwjgl(keyCode);

        if (Config.DEBUG_PRINT_KEY_EVENTS) {
            Lwjgl3ify.LOG.info(
                "[DEBUG-KEY] key ns:{} key:{} ({}) rawKey:{} scancode:{} isDown:{} {} mods:{} naive-char:{}",
                ns,
                keyCode,
                memUTF8Safe(keyNamePtr),
                rawKeyCode,
                scanCode,
                isDown ? "PRESS" : "RELEASE",
                isRepeat ? "REPEAT" : "",
                kmods,
                (rawKeyCode >= 32 && rawKeyCode < 0xFF_FFFF) ? ((char) rawKeyCode) : '?');
        }

        final InputEvents.KeyAction enumAction;
        if (isDown) {
            enumAction = isRepeat ? InputEvents.KeyAction.REPEATED : InputEvents.KeyAction.PRESSED;
        } else {
            enumAction = InputEvents.KeyAction.RELEASED;
        }
        InputEvents.injectKeyEvent(
            new InputEvents.KeyEvent(
                lwjgl2KeyCode,
                lwjgl2ScanCode,
                keyCode,
                scanCode,
                rawKeyCode,
                enumAction,
                kmods,
                keyNamePtr));
        if (rawKeyCode >= SDLK_SPACE && rawKeyCode <= SDLK_TILDE) {
            /*
             * AltGr and LAlt require special consideration.
             * On Windows, AltGr and Ctrl+Alt send the same `mods` value of ALT|CTRL in this event.
             * This means that to distinguish potential text input from special key combos we have to look at
             * the last pressed Alt key side.
             * Ctrl combos have to send a (key & 0x1f) ASCII Escape code to work correctly with a lot of older
             * mods, but this obviously breaks text input.
             * Therefore, we assume text input with AltGr, and control combination input with Left Alt, but both
             * can be switched in the config if the player desires.
             */
            final boolean isAlt = (kmods & SDL_KMOD_ALT) != 0;
            final boolean isAltGr = (kmods & SDL_KMOD_RALT) != 0;
            final boolean ctrlGraphicalMode;
            if (isAlt) {
                if (isAltGr) {
                    ctrlGraphicalMode = !Config.INPUT_ALTGR_ESCAPE_CODES;
                } else {
                    // is left alt
                    ctrlGraphicalMode = Config.INPUT_CTRL_ALT_TEXT;
                }
                if (ctrlGraphicalMode) {
                    Keyboard.addSdlKeyEvent(keyCode, scanCode, enumAction, kmods, (char) (keyCode & 0x1f), ns);
                }
            } else {
                ctrlGraphicalMode = false;
            }
            if ((SDL_KMOD_GUI & kmods) != 0) {
                Keyboard.addSdlKeyEvent(keyCode, scanCode, enumAction, kmods, rawKeyCodeToChar(rawKeyCode), ns);
            } else if ((SDL_KMOD_CTRL & kmods) != 0 && !ctrlGraphicalMode) { // Handle ctrl + x/c/v.
                if (Config.DEBUG_PRINT_KEY_EVENTS) {
                    Lwjgl3ify.LOG.info(
                        "[DEBUG-KEY] Handling key as escape code, skipping next char input. isAlt:{} isAltGr:{}",
                        isAlt,
                        isAltGr);
                }
                Keyboard.addSdlKeyEvent(keyCode, scanCode, enumAction, kmods, (char) (keyCode & 0x1f), ns);
            } else {
                Keyboard.addSdlKeyEvent(keyCode, scanCode, enumAction, kmods, rawKeyCodeToChar(rawKeyCode), ns);
            }
        } else { // Other key with no char event associated
            Keyboard.addSdlKeyEvent(keyCode, scanCode, enumAction, kmods, rawKeyCodeToChar(rawKeyCode), ns);
        }
    }

    private static void handleTextEvent() {
        final long ns = textEvent.timestamp();
        final String text = textEvent.textString();
        if (text == null) {
            return;
        }
        if (Config.DEBUG_PRINT_KEY_EVENTS) {
            Lwjgl3ify.LOG.info("[DEBUG-KEY] ns:{} text:<{}>", ns, text);
        }
        InputEvents.injectTextEvent(new InputEvents.TextEvent(text));
        text.chars()
            .forEachOrdered(c -> Keyboard.addCharEvent(Keyboard.KEY_NONE, c));
    }
}
