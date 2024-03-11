package me.eigenraven.lwjgl3ify.api;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Provides direct access to raw key press and text input events.
 * The main benefit is the separation of key and char events, which allows proper dead key and unicode input handling.
 */
@SuppressWarnings({ "ForLoopReplaceableByForEach", "unused" }) // avoid allocations for performance
public class InputEvents {

    /** The key state change. */
    public enum KeyAction {
        PRESSED,
        REPEATED,
        RELEASED,
    }

    /** A key state change/repeat event. */
    public static class KeyEvent {

        /** The mapped LWJGL2 key code, e.g. {@link org.lwjglx.input.Keyboard#KEY_A} */
        public final int lwjgl2KeyCode;
        /** Raw codes from LWJGL3's GLFW */
        public final int glfwKeyCode, glfwScanCode;
        /** What happened to the key */
        public final KeyAction action;
        /** Modifiers held while the key action happened */
        public final boolean controlPressed, shiftPressed, altPressed, superPressed;

        /** Constructs a new KeyEvent with the given data. */
        public KeyEvent(int lwjgl2KeyCode, int glfwKeyCode, int glfwScanCode, KeyAction action, boolean controlPressed,
            boolean shiftPressed, boolean altPressed, boolean superPressed) {
            this.lwjgl2KeyCode = lwjgl2KeyCode;
            this.glfwKeyCode = glfwKeyCode;
            this.glfwScanCode = glfwScanCode;
            this.action = action;
            this.controlPressed = controlPressed;
            this.shiftPressed = shiftPressed;
            this.altPressed = altPressed;
            this.superPressed = superPressed;
        }
    }

    /** A text input event, indicating some text was typed - either via a keypress or IME input */
    public static class TextEvent {

        // Currently GLFW only provides individual chars, but a future string-oriented API is planned
        /** The text that was put in */
        public final String text;

        /** Constructs a new KeyEvent with the given data. */
        public TextEvent(String text) {
            this.text = text;
        }
    }

    /** Implement this interface and register it with this class to receive raw LWJGL3 input events. */
    public interface KeyboardListener {

        /** Handle a key press event */
        default void onKeyEvent(KeyEvent event) {}

        /** Handle a text input event */
        default void onTextEvent(TextEvent event) {}
    }

    private static final ArrayList<KeyboardListener> keyboardListeners = new ArrayList<>();
    private static final ArrayList<WeakReference<KeyboardListener>> weakKeyboardListeners = new ArrayList<>();

    /** Registers the given listener to receive events. */
    public static void addKeyboardListener(KeyboardListener listener) {
        keyboardListeners.add(listener);
    }

    /** Removes the given listener to no longer receive events. */
    public static void removeKeyboardListener(KeyboardListener listener) {
        keyboardListeners.remove(listener);
    }

    /**
     * Like {@link InputEvents#addKeyboardListener}, but only holds onto a {@link WeakReference} of the given object,
     * and cleans it up automatically once the object is collected.
     */
    public static void addWeakKeyboardListener(KeyboardListener listener) {
        weakKeyboardListeners.add(new WeakReference<>(listener));
    }

    /** Allows for early removal of a weak keyboard listener. */
    public static void removeWeakKeyboardListener(KeyboardListener listener) {
        for (int i = 0; i < weakKeyboardListeners.size(); i++) {
            if (weakKeyboardListeners.get(i)
                .get() == listener) {
                weakKeyboardListeners.remove(i);
                return;
            }
        }
    }

    /** Sends a synthetic key event to all the handlers. */
    public static void injectKeyEvent(final KeyEvent ev) {
        for (int i = 0; i < keyboardListeners.size(); i++) {
            final KeyboardListener listener = keyboardListeners.get(i);
            listener.onKeyEvent(ev);
        }
        for (int i = 0; i < weakKeyboardListeners.size(); i++) {
            final WeakReference<KeyboardListener> weak = weakKeyboardListeners.get(i);
            final KeyboardListener strong = weak.get();
            if (strong == null) {
                // remove dead reference
                weakKeyboardListeners.remove(i);
                i--;
            } else {
                strong.onKeyEvent(ev);
            }
        }
    }

    /** Sends a synthetic text event to all the handlers. */
    public static void injectTextEvent(final TextEvent ev) {
        for (int i = 0; i < keyboardListeners.size(); i++) {
            final KeyboardListener listener = keyboardListeners.get(i);
            listener.onTextEvent(ev);
        }
        for (int i = 0; i < weakKeyboardListeners.size(); i++) {
            final WeakReference<KeyboardListener> weak = weakKeyboardListeners.get(i);
            final KeyboardListener strong = weak.get();
            if (strong == null) {
                // remove dead reference
                weakKeyboardListeners.remove(i);
                i--;
            } else {
                strong.onTextEvent(ev);
            }
        }
    }
}
