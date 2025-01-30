package org.lwjglx;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;
import org.lwjgl.sdl.SDL_Event;
import org.lwjgl.sdl.SDL_KeyboardEvent;
import org.lwjgl.sdl.SDL_MouseButtonEvent;
import org.lwjgl.sdl.SDL_MouseMotionEvent;
import org.lwjgl.sdl.SDL_MouseWheelEvent;
import org.lwjgl.sdl.SDL_WindowEvent;
import org.lwjgl.system.Platform;
import org.lwjglx.input.KeyCodes;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;
import org.lwjglx.opengl.Display;

import java.awt.event.KeyEvent;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLVideo.*;
import static org.lwjgl.sdl.SDLPixels.*;
import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLKeyboard.*;
import static org.lwjgl.sdl.SDLKeycode.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Singleton (static) class for handling the SDL event loop on the correct main thread.
 */
public class Lwjgl3ifyEventLoop {

    /**
     * Call on the thread that called Java main() to process incoming SDL events.
     */
    public static void pumpEvents() {
        MainThreadExec.runOnMainSelectorOnMac(Lwjgl3ifyEventLoop::internalPumpEvents);
    }

    public static final SDL_Event event = SDL_Event.calloc();
    public static final SDL_WindowEvent windowEvent = event.window();
    public static final SDL_KeyboardEvent keyEvent = event.key();
    public static final SDL_MouseMotionEvent mouseMotionEvent = event.motion();
    public static final SDL_MouseButtonEvent mouseButtonEvent = event.button();
    public static final SDL_MouseWheelEvent mouseWheelEvent = event.wheel();

    private static void internalPumpEvents() {
        if (!SDL_IsMainThread()) {
            throw new IllegalStateException("SDL Event pump called from a non-main thread " + Thread.currentThread());
        }
        while(SDL_PollEvent(event)) {
            if (Display.lwjgl3ify$handleSdlEvent()) {
                continue;
            }
            switch(event.type()) {
                case SDL_EVENT_MOUSE_MOTION -> {

                    Mouse.addMoveEvent(mouseMotionEvent.x(), mouseMotionEvent.y());
                }
                case SDL_EVENT_MOUSE_BUTTON_DOWN, SDL_EVENT_MOUSE_BUTTON_UP -> {
                    Mouse.addButtonEvent(mouseButtonEvent.button(), event.type() == SDL_EVENT_MOUSE_BUTTON_DOWN);
                }
                case SDL_EVENT_MOUSE_WHEEL -> {
                    float xoffset = mouseWheelEvent.x();
                    float yoffset = mouseWheelEvent.y();
                    Mouse.addWheelEvent(yoffset == 0 ? (Config.INPUT_INVERT_X_WHEEL ? -xoffset : xoffset) : yoffset);
                }
                default -> {}
            }
        }
    }

//    private static void handleKeyEvent() {
//        if (Config.DEBUG_PRINT_KEY_EVENTS) {
//            Lwjgl3ify.LOG.info(
//                "[DEBUG-KEY] key window:{} key:{} ({}) scancode:{} action:{} mods:{} charname:{} naive-char:{}",
//                window,
//                key,
//                glfwKeycodeNames.getOrDefault(key, "unknown"),
//                scancode,
//                action == GLFW_PRESS ? "PRESS" : (action == GLFW_RELEASE ? "RELEASE" : "REPEAT"),
//                mods,
//                KeyEvent.getKeyText(KeyCodes.lwjglToAwt(KeyCodes.glfwToLwjgl(key))),
//                (key >= 32 && key < 127) ? ((char) key) : '?');
//        }
//        final InputEvents.KeyAction enumAction = switch (action) {
//            case GLFW_PRESS -> InputEvents.KeyAction.PRESSED;
//            case GLFW_RELEASE -> InputEvents.KeyAction.RELEASED;
//            case GLFW_REPEAT -> InputEvents.KeyAction.REPEATED;
//            default -> InputEvents.KeyAction.PRESSED;
//        };
//        InputEvents.injectKeyEvent(
//            new InputEvents.KeyEvent(
//                KeyCodes.glfwToLwjgl(key),
//                key,
//                scancode,
//                enumAction,
//                (mods & GLFW_MOD_CONTROL) != 0,
//                (mods & GLFW_MOD_SHIFT) != 0,
//                (mods & GLFW_MOD_ALT) != 0,
//                (mods & GLFW_MOD_SUPER) != 0));
//        cancelNextChar = false;
//        if (action == GLFW_PRESS) {
//            if (key == GLFW_KEY_LEFT_ALT) {
//                lastAltIsRightAlt = false;
//            } else if (key == GLFW_KEY_RIGHT_ALT) {
//                lastAltIsRightAlt = true;
//            }
//        }
//        if (key > GLFW_KEY_SPACE && key <= GLFW_KEY_GRAVE_ACCENT) { // Handle keys have a char. Exclude space to
//            // avoid extra input when switching IME
//
//            /*
//             * AltGr and LAlt require special consideration.
//             * On Windows, AltGr and Ctrl+Alt send the same `mods` value of ALT|CTRL in this event.
//             * This means that to distinguish potential text input from special key combos we have to look at
//             * the last pressed Alt key side.
//             * Ctrl combos have to send a (key & 0x1f) ASCII Escape code to work correctly with a lot of older
//             * mods, but this obviously breaks text input.
//             * Therefore, we assume text input with AltGr, and control combination input with Left Alt, but both
//             * can be switched in the config if the player desires.
//             */
//            final boolean isAlt = (GLFW_MOD_ALT & mods) != 0;
//            final boolean isAltGr = lastAltIsRightAlt;
//            final boolean ctrlGraphicalMode;
//            if (isAlt) {
//                if (isAltGr) {
//                    ctrlGraphicalMode = !Config.INPUT_ALTGR_ESCAPE_CODES;
//                } else {
//                    // is left alt
//                    ctrlGraphicalMode = Config.INPUT_CTRL_ALT_TEXT;
//                }
//                if (ctrlGraphicalMode) {
//                    Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) (key & 0x1f));
//                }
//            } else {
//                ctrlGraphicalMode = false;
//            }
//
//            if ((GLFW_MOD_SUPER & mods) != 0) {
//                Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) key);
//                if (Platform.get() != Platform.MACOSX) {
//                    // MacOS doesn't send a char event for Cmd+KEY presses, but other platforms do.
//                    cancelNextChar = true;
//                }
//            } else if ((GLFW_MOD_CONTROL & mods) != 0 && !ctrlGraphicalMode) { // Handle ctrl + x/c/v.
//                if (Config.DEBUG_PRINT_KEY_EVENTS) {
//                    Lwjgl3ify.LOG.info(
//                        "[DEBUG-KEY] Handling key as escape code, skipping next char input. isAlt:{} isAltGr:{}",
//                        isAlt,
//                        isAltGr);
//                }
//                Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) (key & 0x1f));
//                cancelNextChar = true; // Cancel char event from ctrl key since its already handled here
//            } else if (action > 0) { // Delay press and repeat key event to actual char input. There is ALWAYS a
//                // char after them
//                ingredientKeyEvent = new Keyboard.KeyEvent(
//                    KeyCodes.glfwToLwjgl(key),
//                    '\0',
//                    action > 1 ? Keyboard.KeyState.REPEAT : Keyboard.KeyState.PRESS,
//                    Sys.getNanoTime());
//            } else { // Release event
//                if (ingredientKeyEvent != null && ingredientKeyEvent.key == KeyCodes.glfwToLwjgl(key)) {
//                    ingredientKeyEvent.queueOutOfOrderRelease = true;
//                }
//                Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, '\0');
//            }
//        } else { // Other key with no char event associated
//            char mappedChar = switch (key) {
//                case GLFW_KEY_ENTER -> 0x0D;
//                case GLFW_KEY_ESCAPE -> 0x1B;
//                case GLFW_KEY_TAB -> 0x09;
//                case GLFW_KEY_BACKSPACE -> 0x08;
//                default -> '\0';
//            };
//            Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, mappedChar);
//        }
//    }
//
//    private static void handleTextEvent() {
//        if (Config.DEBUG_PRINT_KEY_EVENTS) {
//            Lwjgl3ify.LOG
//                .info("[DEBUG-KEY] char window:{} codepoint:{} char:{}", window, codepoint, (char) codepoint);
//        }
//        InputEvents.injectTextEvent(new InputEvents.TextEvent(String.valueOf((char) codepoint)));
//        if (cancelNextChar) { // Char event being cancelled
//            cancelNextChar = false;
//        } else if (ingredientKeyEvent != null) {
//            ingredientKeyEvent.aChar = (char) codepoint; // Send char with ASCII key event here
//            Keyboard.addRawKeyEvent(ingredientKeyEvent);
//            if (ingredientKeyEvent.queueOutOfOrderRelease) {
//                ingredientKeyEvent = ingredientKeyEvent.copy();
//                ingredientKeyEvent.state = Keyboard.KeyState.RELEASE;
//                Keyboard.addRawKeyEvent(ingredientKeyEvent);
//            }
//            ingredientKeyEvent = null;
//        } else {
//            Keyboard.addCharEvent(0, (char) codepoint); // Non-ASCII chars
//        }
//    }
}
