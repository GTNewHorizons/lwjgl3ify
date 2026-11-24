package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.sdl.SDLClipboard.*;
import static org.lwjgl.sdl.SDLKeyboard.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ChatAllowedCharacters;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.sdl.SDLClipboard;
import org.lwjgl.sdl.SDL_Rect;
import org.lwjgl.system.MemoryStack;
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
    private static final int[] lastTextInputArea = new int[5];
    private static boolean textInputAreaSent = false;
    private static boolean textInputAreaSet = false;

    public static boolean isTextInputActive() {
        return textInputDepth > 0;
    }

    public static void beginTextInput() {
        if (textInputDepth == Integer.MAX_VALUE) {
            return;
        }
        if (textInputDepth++ == 0) {
            if (Config.DEBUG_PRINT_KEY_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG] Beginning text input");
            }
            MainThreadExec.runOnMainThread(() -> { SDL_StartTextInput(Display.getWindow()); });
            textInputAreaSent = false;
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
            textBuffer.setLength(0);
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
        textBuffer.setLength(0);
    }

    public static void setFocusedTextField(GuiTextField textField) {
        if (focusedTextInput.get() != textField) {
            focusedTextInput = new WeakReference<>(textField);
            textInputAreaSent = false;
        }
    }

    public static void updateTextInputArea() {
        if (textInputDepth <= 0) {
            return;
        }
        final GuiTextField textField = focusedTextInput.get();
        if (textField == null || !textField.isFocused() || !textField.getVisible()) {
            if (textInputAreaSet) {
                if (!MainThreadExec.runOnMainThread(() -> SDL_SetTextInputArea(Display.getWindow(), null, 0))) {
                    return;
                }
                textInputAreaSet = false;
                textInputAreaSent = false;
                if (Config.DEBUG_PRINT_KEY_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG] Text input area cleared");
                }
            }
            return;
        }
        final Minecraft mc = Minecraft.getMinecraft();
        final int scale = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight).getScaleFactor();
        final boolean background = textField.getEnableBackgroundDrawing();
        final int textX = background ? textField.xPosition + 4 : textField.xPosition;
        final int textY = background ? textField.yPosition + (textField.height - 8) / 2 : textField.yPosition;
        final float windowScale = scale / Display.getPixelScaleFactor();
        final int x = Math.round(textX * windowScale);
        final int y = Math.round((textY - 1) * windowScale);
        final int w = Math.round(textField.getWidth() * windowScale);
        final int h = Math.round((mc.fontRenderer.FONT_HEIGHT + 2) * windowScale);
        final int cursor = Math.round(((GuiTextFieldExt) textField).lwjgl3ify$getCaretOffset() * windowScale);
        final int[] area = lastTextInputArea;
        if (textInputAreaSent && area[0] == x && area[1] == y && area[2] == w && area[3] == h && area[4] == cursor) {
            return;
        }
        area[0] = x;
        area[1] = y;
        area[2] = w;
        area[3] = h;
        area[4] = cursor;
        textInputAreaSet = true;
        textInputAreaSent = MainThreadExec.runOnMainThread(() -> {
            try (MemoryStack stack = MemoryStack.stackPush()) {
                final SDL_Rect.Buffer rect = SDL_Rect.malloc(1, stack);
                rect.get(0)
                    .set(x, y, w, h);
                return SDL_SetTextInputArea(Display.getWindow(), rect, cursor);
            }
        });
        if (Config.DEBUG_PRINT_KEY_EVENTS) {
            Lwjgl3ify.LOG.info(
                "[DEBUG] Text input area x={} y={} w={} h={} cursor={} sent={}",
                x,
                y,
                w,
                h,
                cursor,
                textInputAreaSent);
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
