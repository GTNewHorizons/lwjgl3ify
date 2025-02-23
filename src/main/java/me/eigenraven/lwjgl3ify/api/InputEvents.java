package me.eigenraven.lwjgl3ify.api;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

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

        /**
         * The mapped LWJGL2 key code, e.g. {@link org.lwjglx.input.Keyboard#KEY_A} - keyCode is the code based on the
         * label, scanCode is based on the key position equivalent on a QWERTY keyboard.
         */
        public final int lwjgl2KeyCode, lwjgl2ScanCode;
        /**
         * Raw codes from LWJGL3's SDL, e.g. {@link org.lwjgl.sdl.SDLKeycode#SDLK_A} and
         * {@link org.lwjgl.sdl.SDLScancode#SDL_SCANCODE_A}
         */
        public final int sdlKeyCode, sdlScanCode;
        /**
         * SDL key code decoded with SDL_GetKeyFromScancode(_, _, false), corresponding to a Unicode codepoint for the
         * key if a single one exists
         */
        public final int sdlRawKeyCode;
        /** What happened to the key */
        public final KeyAction action;
        /** Modifiers held while the key action happened, e.g. {@link org.lwjgl.sdl.SDLKeycode#SDL_KMOD_LCTRL} */
        public final short sdlKeyModifiers;
        /**
         * Pointer to a UTF-8 string containing the name of the key. Can be decoded on-demand with
         * {@link org.lwjgl.system.MemoryUtil#memUTF8(long)}
         */
        public final long keyNamePointer;

        /** Constructs a new KeyEvent with the given data. */
        public KeyEvent(int lwjgl2KeyCode, int lwjgl2ScanCode, int sdlKeyCode, int sdlScanCode, int sdlRawKeyCode,
            KeyAction action, short sdlKeyModifiers, long keyNamePointer) {
            this.lwjgl2KeyCode = lwjgl2KeyCode;
            this.lwjgl2ScanCode = lwjgl2ScanCode;
            this.sdlKeyCode = sdlKeyCode;
            this.sdlScanCode = sdlScanCode;
            this.sdlRawKeyCode = sdlRawKeyCode;
            this.action = action;
            this.sdlKeyModifiers = sdlKeyModifiers;
            this.keyNamePointer = keyNamePointer;
        }
    }

    /** A text input event, indicating some text was typed - either via a keypress or IME input */
    public static class TextEvent {

        /** The text that was put in */
        public final String text;

        /** Constructs a new KeyEvent with the given data. */
        public TextEvent(String text) {
            this.text = text;
        }
    }

    /**
     * Implement this interface and register it with this class to receive raw LWJGL3 input events. You can also
     * implement it on a Gui class to automatically receive events when the GUI is open.
     */
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
        final GuiScreen gui = Minecraft.getMinecraft().currentScreen;
        if (gui instanceof KeyboardListener kl) {
            kl.onKeyEvent(ev);
        }
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
        final GuiScreen gui = Minecraft.getMinecraft().currentScreen;
        if (gui instanceof KeyboardListener kl) {
            kl.onTextEvent(ev);
        }
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

    /**
     * Turns on {@link TextEvent} generation.
     */
    public static void beginTextInput() {
        TextFieldHandler.beginTextInput();
    }

    /**
     * Turns off {@link TextEvent} generation.
     */
    public static void endTextInput() {
        TextFieldHandler.endTextInput(null);
    }
}
