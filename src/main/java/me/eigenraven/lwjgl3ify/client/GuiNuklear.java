package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;

import net.minecraft.client.gui.GuiScreen;

import org.lwjgl.nuklear.NkVec2;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.input.Mouse;
import org.lwjglx.opengl.Display;

import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TIntArrayList;
import me.eigenraven.lwjgl3ify.api.InputEvents;

public class GuiNuklear extends GuiScreen implements InputEvents.KeyboardListener {

    public final NuklearUi ui;

    // Event buffers
    private final TCharArrayList textInput = new TCharArrayList(10);
    private int scrollInput = 0;
    private static final int KEY_RELEASED_MASK = 0x8000_0000;
    private final TIntArrayList keyPresses = new TIntArrayList(10);
    private final TIntArrayList mousePresses = new TIntArrayList(10);
    private final TIntArrayList mouseXs = new TIntArrayList(10);
    private final TIntArrayList mouseYs = new TIntArrayList(10);

    public GuiNuklear(NuklearUi ui) {
        this.ui = ui;
    }

    @Override
    public void initGui() {
        InputEvents.addWeakKeyboardListener(this);
    }

    @Override
    public void onGuiClosed() {
        InputEvents.removeWeakKeyboardListener(this);
    }

    @Override
    public void onKeyEvent(InputEvents.KeyEvent event) {
        int keycode = event.glfwKeyCode;
        if (event.action == InputEvents.KeyAction.RELEASED) {
            keycode |= KEY_RELEASED_MASK;
        }
        keyPresses.add(keycode);
    }

    @Override
    public void onTextEvent(InputEvents.TextEvent event) {
        for (int i = 0; i < event.text.length(); i++) {
            textInput.add(event.text.charAt(i));
        }
    }

    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        scrollInput += Mouse.getEventDWheel();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        mousePresses.add(mouseButton);
        mouseXs.add(Mouse.getX());
        mouseYs.add(Mouse.getY());
    }

    @Override
    protected void mouseMovedOrUp(int mouseX, int mouseY, int button) {
        super.mouseMovedOrUp(mouseX, mouseY, button);
        if (button >= 0) {
            mousePresses.add(button | KEY_RELEASED_MASK);
            mouseXs.add(Mouse.getX());
            mouseYs.add(Mouse.getY());
        }
    }

    private void updateInput() {
        final var ctx = ui.ctx;
        final int winH = Display.getHeight();

        nk_input_begin(ctx);
        try (final MemoryStack stack = MemoryStack.stackPush()) {
            nk_input_motion(ctx, Mouse.getX(), winH - Mouse.getY());
            if (!textInput.isEmpty()) {
                for (int i = 0; i < textInput.size(); i++) {
                    nk_input_unicode(ctx, textInput.get(i));
                }
                textInput.clear();
            }
            if (!keyPresses.isEmpty()) {
                for (int i = 0; i < keyPresses.size(); i++) {
                    int key = keyPresses.get(i);
                    boolean pressed = ((key & KEY_RELEASED_MASK) == 0);
                    key = key & ~KEY_RELEASED_MASK;
                    final long window = Display.getWindow();
                    switch (key) {
                        case GLFW_KEY_DELETE:
                            nk_input_key(ctx, NK_KEY_DEL, pressed);
                            break;
                        case GLFW_KEY_ENTER:
                            nk_input_key(ctx, NK_KEY_ENTER, pressed);
                            break;
                        case GLFW_KEY_TAB:
                            nk_input_key(ctx, NK_KEY_TAB, pressed);
                            break;
                        case GLFW_KEY_BACKSPACE:
                            nk_input_key(ctx, NK_KEY_BACKSPACE, pressed);
                            break;
                        case GLFW_KEY_UP:
                            nk_input_key(ctx, NK_KEY_UP, pressed);
                            break;
                        case GLFW_KEY_DOWN:
                            nk_input_key(ctx, NK_KEY_DOWN, pressed);
                            break;
                        case GLFW_KEY_HOME:
                            nk_input_key(ctx, NK_KEY_TEXT_START, pressed);
                            nk_input_key(ctx, NK_KEY_SCROLL_START, pressed);
                            break;
                        case GLFW_KEY_END:
                            nk_input_key(ctx, NK_KEY_TEXT_END, pressed);
                            nk_input_key(ctx, NK_KEY_SCROLL_END, pressed);
                            break;
                        case GLFW_KEY_PAGE_DOWN:
                            nk_input_key(ctx, NK_KEY_SCROLL_DOWN, pressed);
                            break;
                        case GLFW_KEY_PAGE_UP:
                            nk_input_key(ctx, NK_KEY_SCROLL_UP, pressed);
                            break;
                        case GLFW_KEY_LEFT_SHIFT:
                        case GLFW_KEY_RIGHT_SHIFT:
                            nk_input_key(ctx, NK_KEY_SHIFT, pressed);
                            break;
                        case GLFW_KEY_LEFT_CONTROL:
                        case GLFW_KEY_RIGHT_CONTROL:
                            if (pressed) {
                                nk_input_key(ctx, NK_KEY_COPY, glfwGetKey(window, GLFW_KEY_C) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_PASTE, glfwGetKey(window, GLFW_KEY_P) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_CUT, glfwGetKey(window, GLFW_KEY_X) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_TEXT_UNDO, glfwGetKey(window, GLFW_KEY_Z) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_TEXT_REDO, glfwGetKey(window, GLFW_KEY_R) == GLFW_PRESS);
                                nk_input_key(
                                    ctx,
                                    NK_KEY_TEXT_WORD_LEFT,
                                    glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS);
                                nk_input_key(
                                    ctx,
                                    NK_KEY_TEXT_WORD_RIGHT,
                                    glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_TEXT_LINE_START, glfwGetKey(window, GLFW_KEY_B) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_TEXT_LINE_END, glfwGetKey(window, GLFW_KEY_E) == GLFW_PRESS);
                            } else {
                                nk_input_key(ctx, NK_KEY_LEFT, glfwGetKey(window, GLFW_KEY_LEFT) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_RIGHT, glfwGetKey(window, GLFW_KEY_RIGHT) == GLFW_PRESS);
                                nk_input_key(ctx, NK_KEY_COPY, false);
                                nk_input_key(ctx, NK_KEY_PASTE, false);
                                nk_input_key(ctx, NK_KEY_CUT, false);
                                nk_input_key(ctx, NK_KEY_SHIFT, false);
                            }
                            break;
                    }
                }
            }
            if (scrollInput != 0) {
                nk_input_scroll(
                    ctx,
                    NkVec2.malloc(stack)
                        .set(0.0f, scrollInput));
                scrollInput = 0;
            }
            if (!mousePresses.isEmpty()) {
                for (int i = 0; i < mousePresses.size(); i++) {
                    int btn = mousePresses.get(i);
                    final boolean pressed = ((btn & KEY_RELEASED_MASK) == 0);
                    btn = btn & ~KEY_RELEASED_MASK;
                    final int nk_btn = switch (btn) {
                        case 0 -> NK_BUTTON_LEFT;
                        case 1 -> NK_BUTTON_RIGHT;
                        case 2 -> NK_BUTTON_MIDDLE;
                        default -> NK_BUTTON_LEFT;
                    };
                    nk_input_button(ctx, nk_btn, mouseXs.get(i), winH - mouseYs.get(i), pressed);
                }
                mousePresses.clear();
                mouseXs.clear();
                mouseYs.clear();
            }
        } finally {
            nk_input_end(ctx);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        updateInput();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
