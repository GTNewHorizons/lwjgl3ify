package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.sdl.SDLClipboard.*;
import static org.lwjgl.sdl.SDLKeyboard.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.sdl.SDLClipboard;
import org.lwjglx.opengl.Display;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.core.Config;

/** @see me.eigenraven.lwjgl3ify.mixins.early.game.MixinGuiTextField */
public final class TextFieldHandler {

    private static int textInputDepth = 0;
    private static final WeakReference<GuiTextField> NULL_TEXT_FIELD = new WeakReference<>(null);
    private static WeakReference<GuiTextField> focusedTextInput = NULL_TEXT_FIELD;
    public static final StringBuilder textBuffer = new StringBuilder(8);

    public static void beginTextInput() {
        if (textInputDepth == Integer.MAX_VALUE) {
            return;
        }
        if (textInputDepth++ == 0) {
            if (Config.DEBUG_PRINT_KEY_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG] Beginning text input");
            }
            MainThreadExec.runOnMainThread(() -> { SDL_StartTextInput(Display.getWindow()); });
        }
    }

    public static void endTextInput(@Nullable GuiTextField textField) {
        if (textInputDepth <= 0) {
            return;
        }
        if (--textInputDepth == 0) {
            if (Config.DEBUG_PRINT_KEY_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG] Stopping text input");
            }
            MainThreadExec.runOnMainThread(() -> { SDL_StopTextInput(Display.getWindow()); });
        }
        if (textField != null && textField == focusedTextInput.get()) {
            focusedTextInput = NULL_TEXT_FIELD;
        }
    }

    public static void resetTextInput() {
        if (textInputDepth != 0) {
            if (Config.DEBUG_PRINT_KEY_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG] Stopping text input (reset)");
            }
            MainThreadExec.runOnMainThread(() -> { SDL_StopTextInput(Display.getWindow()); });
            textInputDepth = 0;
        }
        focusedTextInput = NULL_TEXT_FIELD;
    }

    public static void setFocusedTextField(GuiTextField textField) {
        if (focusedTextInput.get() != textField) {
            focusedTextInput = new WeakReference<>(textField);
        }
    }

    public static void onTextInput(InputEvents.TextEvent event) {
        final GuiTextField textField = focusedTextInput.get();
        if (textInputDepth <= 0 || textField == null) {
            return;
        }
        if (event.text.chars()
            .allMatch(chr -> ChatAllowedCharacters.isAllowedCharacter((char) chr))) {
            textBuffer.append(event.text);
        }
    }

    public static String getClipboardText() {
        return MainThreadExec.runOnMainThread(SDLClipboard::SDL_GetClipboardText);
    }

    public static void setClipboardText(final String newText) {
        if (newText == null || newText.isEmpty()) {
            MainThreadExec.runOnMainThread(SDLClipboard::SDL_ClearClipboardData);
            return;
        }
        final boolean putOnStack = newText.length() < 1024;
        if (putOnStack) {
            MainThreadExec.runOnMainThread(() -> SDL_SetClipboardText(newText));
            return;
        }
        final ByteBuffer nativeText = memUTF8(newText, true);
        try {
            MainThreadExec.runOnMainThread(() -> SDL_SetClipboardText(nativeText));
        } finally {
            memFree(nativeText);
        }
    }
}
