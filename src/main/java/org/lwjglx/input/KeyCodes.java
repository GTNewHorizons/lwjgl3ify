package org.lwjglx.input;

import static org.lwjgl.sdl.SDLKeycode.*;
import static org.lwjgl.sdl.SDLScancode.*;

import java.awt.event.KeyEvent;

import org.lwjgl.glfw.GLFW;

public class KeyCodes {

    /**
     * This is the additional key that ISO
     * keyboards have over ANSI ones,
     * located between left shift and Y.
     * Produces GRAVE ACCENT and TILDE in a
     * US or UK Mac layout, REVERSE SOLIDUS
     * (backslash) and VERTICAL LINE in a
     * US or UK Windows layout, and
     * LESS-THAN SIGN and GREATER-THAN SIGN
     * in a Swiss German, German, or French
     * layout.
     */
    public static final int L3F_SDLK_NONUSBACKSLASH = SDL_SCANCODE_NONUSBACKSLASH | SDLK_SCANCODE_MASK;

    public static final int L3F_SDLK_INTERNATIONAL2 = SDL_SCANCODE_INTERNATIONAL2 | SDLK_SCANCODE_MASK;
    /** Yen */
    public static final int L3F_SDLK_INTERNATIONAL3 = SDL_SCANCODE_INTERNATIONAL3 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL4 = SDL_SCANCODE_INTERNATIONAL4 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL5 = SDL_SCANCODE_INTERNATIONAL5 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL6 = SDL_SCANCODE_INTERNATIONAL6 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL7 = SDL_SCANCODE_INTERNATIONAL7 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL8 = SDL_SCANCODE_INTERNATIONAL8 | SDLK_SCANCODE_MASK;
    public static final int L3F_SDLK_INTERNATIONAL9 = SDL_SCANCODE_INTERNATIONAL9 | SDLK_SCANCODE_MASK;
    /** Hangul/English toggle */
    public static final int L3F_SDLK_LANG1 = SDL_SCANCODE_LANG1 | SDLK_SCANCODE_MASK;
    /** Hanja conversion */
    public static final int L3F_SDLK_LANG2 = SDL_SCANCODE_LANG2 | SDLK_SCANCODE_MASK;
    /** Katakana */
    public static final int L3F_SDLK_LANG3 = SDL_SCANCODE_LANG3 | SDLK_SCANCODE_MASK;
    /** Hiragana */
    public static final int L3F_SDLK_LANG4 = SDL_SCANCODE_LANG4 | SDLK_SCANCODE_MASK;
    /** Zenkaku/Hankaku */
    public static final int L3F_SDLK_LANG5 = SDL_SCANCODE_LANG5 | SDLK_SCANCODE_MASK;
    /** reserved */
    public static final int L3F_SDLK_LANG6 = SDL_SCANCODE_LANG6 | SDLK_SCANCODE_MASK;
    /** reserved */
    public static final int L3F_SDLK_LANG7 = SDL_SCANCODE_LANG7 | SDLK_SCANCODE_MASK;
    /** reserved */
    public static final int L3F_SDLK_LANG8 = SDL_SCANCODE_LANG8 | SDLK_SCANCODE_MASK;
    /** reserved */
    public static final int L3F_SDLK_LANG9 = SDL_SCANCODE_LANG9 | SDLK_SCANCODE_MASK;

    public static int glfwToLwjgl(int glfwKeyCode) {
        if (glfwKeyCode > GLFW.GLFW_KEY_LAST) {
            return glfwKeyCode;
        }
        return switch (glfwKeyCode) {
            case GLFW.GLFW_KEY_UNKNOWN -> Keyboard.KEY_UNLABELED; // arbitrary mapping to fix text input here
            case GLFW.GLFW_KEY_ESCAPE -> Keyboard.KEY_ESCAPE;
            case GLFW.GLFW_KEY_BACKSPACE -> Keyboard.KEY_BACK;
            case GLFW.GLFW_KEY_TAB -> Keyboard.KEY_TAB;
            case GLFW.GLFW_KEY_ENTER -> Keyboard.KEY_RETURN;
            case GLFW.GLFW_KEY_SPACE -> Keyboard.KEY_SPACE;
            case GLFW.GLFW_KEY_LEFT_CONTROL -> Keyboard.KEY_LCONTROL;
            case GLFW.GLFW_KEY_LEFT_SHIFT -> Keyboard.KEY_LSHIFT;
            case GLFW.GLFW_KEY_LEFT_ALT -> Keyboard.KEY_LMENU;
            case GLFW.GLFW_KEY_LEFT_SUPER -> Keyboard.KEY_LMETA;
            case GLFW.GLFW_KEY_RIGHT_CONTROL -> Keyboard.KEY_RCONTROL;
            case GLFW.GLFW_KEY_RIGHT_SHIFT -> Keyboard.KEY_RSHIFT;
            case GLFW.GLFW_KEY_RIGHT_ALT -> Keyboard.KEY_RMENU;
            case GLFW.GLFW_KEY_RIGHT_SUPER -> Keyboard.KEY_RMETA;
            case GLFW.GLFW_KEY_1 -> Keyboard.KEY_1;
            case GLFW.GLFW_KEY_2 -> Keyboard.KEY_2;
            case GLFW.GLFW_KEY_3 -> Keyboard.KEY_3;
            case GLFW.GLFW_KEY_4 -> Keyboard.KEY_4;
            case GLFW.GLFW_KEY_5 -> Keyboard.KEY_5;
            case GLFW.GLFW_KEY_6 -> Keyboard.KEY_6;
            case GLFW.GLFW_KEY_7 -> Keyboard.KEY_7;
            case GLFW.GLFW_KEY_8 -> Keyboard.KEY_8;
            case GLFW.GLFW_KEY_9 -> Keyboard.KEY_9;
            case GLFW.GLFW_KEY_0 -> Keyboard.KEY_0;
            case GLFW.GLFW_KEY_A -> Keyboard.KEY_A;
            case GLFW.GLFW_KEY_B -> Keyboard.KEY_B;
            case GLFW.GLFW_KEY_C -> Keyboard.KEY_C;
            case GLFW.GLFW_KEY_D -> Keyboard.KEY_D;
            case GLFW.GLFW_KEY_E -> Keyboard.KEY_E;
            case GLFW.GLFW_KEY_F -> Keyboard.KEY_F;
            case GLFW.GLFW_KEY_G -> Keyboard.KEY_G;
            case GLFW.GLFW_KEY_H -> Keyboard.KEY_H;
            case GLFW.GLFW_KEY_I -> Keyboard.KEY_I;
            case GLFW.GLFW_KEY_J -> Keyboard.KEY_J;
            case GLFW.GLFW_KEY_K -> Keyboard.KEY_K;
            case GLFW.GLFW_KEY_L -> Keyboard.KEY_L;
            case GLFW.GLFW_KEY_M -> Keyboard.KEY_M;
            case GLFW.GLFW_KEY_N -> Keyboard.KEY_N;
            case GLFW.GLFW_KEY_O -> Keyboard.KEY_O;
            case GLFW.GLFW_KEY_P -> Keyboard.KEY_P;
            case GLFW.GLFW_KEY_Q -> Keyboard.KEY_Q;
            case GLFW.GLFW_KEY_R -> Keyboard.KEY_R;
            case GLFW.GLFW_KEY_S -> Keyboard.KEY_S;
            case GLFW.GLFW_KEY_T -> Keyboard.KEY_T;
            case GLFW.GLFW_KEY_U -> Keyboard.KEY_U;
            case GLFW.GLFW_KEY_V -> Keyboard.KEY_V;
            case GLFW.GLFW_KEY_W -> Keyboard.KEY_W;
            case GLFW.GLFW_KEY_X -> Keyboard.KEY_X;
            case GLFW.GLFW_KEY_Y -> Keyboard.KEY_Y;
            case GLFW.GLFW_KEY_Z -> Keyboard.KEY_Z;
            case GLFW.GLFW_KEY_UP -> Keyboard.KEY_UP;
            case GLFW.GLFW_KEY_DOWN -> Keyboard.KEY_DOWN;
            case GLFW.GLFW_KEY_LEFT -> Keyboard.KEY_LEFT;
            case GLFW.GLFW_KEY_RIGHT -> Keyboard.KEY_RIGHT;
            case GLFW.GLFW_KEY_INSERT -> Keyboard.KEY_INSERT;
            case GLFW.GLFW_KEY_DELETE -> Keyboard.KEY_DELETE;
            case GLFW.GLFW_KEY_HOME -> Keyboard.KEY_HOME;
            case GLFW.GLFW_KEY_END -> Keyboard.KEY_END;
            case GLFW.GLFW_KEY_PAGE_UP -> Keyboard.KEY_PRIOR;
            case GLFW.GLFW_KEY_PAGE_DOWN -> Keyboard.KEY_NEXT;
            case GLFW.GLFW_KEY_F1 -> Keyboard.KEY_F1;
            case GLFW.GLFW_KEY_F2 -> Keyboard.KEY_F2;
            case GLFW.GLFW_KEY_F3 -> Keyboard.KEY_F3;
            case GLFW.GLFW_KEY_F4 -> Keyboard.KEY_F4;
            case GLFW.GLFW_KEY_F5 -> Keyboard.KEY_F5;
            case GLFW.GLFW_KEY_F6 -> Keyboard.KEY_F6;
            case GLFW.GLFW_KEY_F7 -> Keyboard.KEY_F7;
            case GLFW.GLFW_KEY_F8 -> Keyboard.KEY_F8;
            case GLFW.GLFW_KEY_F9 -> Keyboard.KEY_F9;
            case GLFW.GLFW_KEY_F10 -> Keyboard.KEY_F10;
            case GLFW.GLFW_KEY_F11 -> Keyboard.KEY_F11;
            case GLFW.GLFW_KEY_F12 -> Keyboard.KEY_F12;
            case GLFW.GLFW_KEY_F13 -> Keyboard.KEY_F13;
            case GLFW.GLFW_KEY_F14 -> Keyboard.KEY_F14;
            case GLFW.GLFW_KEY_F15 -> Keyboard.KEY_F15;
            case GLFW.GLFW_KEY_F16 -> Keyboard.KEY_F16;
            case GLFW.GLFW_KEY_F17 -> Keyboard.KEY_F17;
            case GLFW.GLFW_KEY_F18 -> Keyboard.KEY_F18;
            case GLFW.GLFW_KEY_F19 -> Keyboard.KEY_F19;
            case GLFW.GLFW_KEY_KP_1 -> Keyboard.KEY_NUMPAD1;
            case GLFW.GLFW_KEY_KP_2 -> Keyboard.KEY_NUMPAD2;
            case GLFW.GLFW_KEY_KP_3 -> Keyboard.KEY_NUMPAD3;
            case GLFW.GLFW_KEY_KP_4 -> Keyboard.KEY_NUMPAD4;
            case GLFW.GLFW_KEY_KP_5 -> Keyboard.KEY_NUMPAD5;
            case GLFW.GLFW_KEY_KP_6 -> Keyboard.KEY_NUMPAD6;
            case GLFW.GLFW_KEY_KP_7 -> Keyboard.KEY_NUMPAD7;
            case GLFW.GLFW_KEY_KP_8 -> Keyboard.KEY_NUMPAD8;
            case GLFW.GLFW_KEY_KP_9 -> Keyboard.KEY_NUMPAD9;
            case GLFW.GLFW_KEY_KP_0 -> Keyboard.KEY_NUMPAD0;
            case GLFW.GLFW_KEY_KP_ADD -> Keyboard.KEY_ADD;
            case GLFW.GLFW_KEY_KP_SUBTRACT -> Keyboard.KEY_SUBTRACT;
            case GLFW.GLFW_KEY_KP_MULTIPLY -> Keyboard.KEY_MULTIPLY;
            case GLFW.GLFW_KEY_KP_DIVIDE -> Keyboard.KEY_DIVIDE;
            case GLFW.GLFW_KEY_KP_DECIMAL -> Keyboard.KEY_DECIMAL;
            case GLFW.GLFW_KEY_KP_EQUAL -> Keyboard.KEY_NUMPADEQUALS;
            case GLFW.GLFW_KEY_KP_ENTER -> Keyboard.KEY_NUMPADENTER;
            case GLFW.GLFW_KEY_NUM_LOCK -> Keyboard.KEY_NUMLOCK;
            case GLFW.GLFW_KEY_SEMICOLON -> Keyboard.KEY_SEMICOLON;
            case GLFW.GLFW_KEY_BACKSLASH -> Keyboard.KEY_BACKSLASH;
            case GLFW.GLFW_KEY_COMMA -> Keyboard.KEY_COMMA;
            case GLFW.GLFW_KEY_PERIOD -> Keyboard.KEY_PERIOD;
            case GLFW.GLFW_KEY_SLASH -> Keyboard.KEY_SLASH;
            case GLFW.GLFW_KEY_GRAVE_ACCENT -> Keyboard.KEY_GRAVE;
            case GLFW.GLFW_KEY_CAPS_LOCK -> Keyboard.KEY_CAPITAL;
            case GLFW.GLFW_KEY_SCROLL_LOCK -> Keyboard.KEY_SCROLL;
            case GLFW.GLFW_KEY_WORLD_1 -> Keyboard.KEY_CIRCUMFLEX; // "World" keys could be anything depending on
                                                                   // keyboard layout, pick something arbitrary
            case GLFW.GLFW_KEY_WORLD_2 -> Keyboard.KEY_YEN;
            case GLFW.GLFW_KEY_PAUSE -> Keyboard.KEY_PAUSE;
            case GLFW.GLFW_KEY_MINUS -> Keyboard.KEY_MINUS;
            case GLFW.GLFW_KEY_EQUAL -> Keyboard.KEY_EQUALS;
            case GLFW.GLFW_KEY_LEFT_BRACKET -> Keyboard.KEY_LBRACKET;
            case GLFW.GLFW_KEY_RIGHT_BRACKET -> Keyboard.KEY_RBRACKET;
            case GLFW.GLFW_KEY_APOSTROPHE -> Keyboard.KEY_APOSTROPHE;
            // public static final int KEY_AT = 0x91; /* (NEC PC98) */
            // public static final int KEY_COLON = 0x92; /* (NEC PC98) */
            // public static final int KEY_UNDERLINE = 0x93; /* (NEC PC98) */

            // public static final int KEY_KANA = 0x70; /* (Japanese keyboard) */
            // public static final int KEY_CONVERT = 0x79; /* (Japanese keyboard) */
            // public static final int KEY_NOCONVERT = 0x7B; /* (Japanese keyboard) */
            // public static final int KEY_YEN = 0x7D; /* (Japanese keyboard) */
            // public static final int KEY_CIRCUMFLEX = 0x90; /* (Japanese keyboard) */
            // public static final int KEY_KANJI = 0x94; /* (Japanese keyboard) */
            // public static final int KEY_STOP = 0x95; /* (NEC PC98) */
            // public static final int KEY_AX = 0x96; /* (Japan AX) */
            // public static final int KEY_UNLABELED = 0x97; /* (J3100) */
            // public static final int KEY_SECTION = 0xA7; /* Section symbol (Mac) */
            // public static final int KEY_NUMPADCOMMA = 0xB3; /* , on numeric keypad (NEC PC98) */
            // public static final int KEY_SYSRQ = 0xB7;
            // public static final int KEY_FUNCTION = 0xC4; /* Function (Mac) */
            // public static final int KEY_CLEAR = 0xDA; /* Clear key (Mac) */

            // public static final int KEY_APPS = 0xDD; /* AppMenu key */
            // public static final int KEY_POWER = 0xDE;
            // public static final int KEY_SLEEP = 0xDF;

            default -> Keyboard.KEY_NONE;
        };
    }

    public static int lwjglToGlfw(int lwjglKeyCode) {
        if (lwjglKeyCode > GLFW.GLFW_KEY_LAST) {
            return lwjglKeyCode;
        }
        return switch (lwjglKeyCode) {
            case Keyboard.KEY_NONE -> 0;
            case Keyboard.KEY_UNLABELED -> GLFW.GLFW_KEY_UNKNOWN; // arbitrary mapping to fix text input here
            case Keyboard.KEY_ESCAPE -> GLFW.GLFW_KEY_ESCAPE;
            case Keyboard.KEY_BACK -> GLFW.GLFW_KEY_BACKSPACE;
            case Keyboard.KEY_TAB -> GLFW.GLFW_KEY_TAB;
            case Keyboard.KEY_RETURN -> GLFW.GLFW_KEY_ENTER;
            case Keyboard.KEY_SPACE -> GLFW.GLFW_KEY_SPACE;
            case Keyboard.KEY_LCONTROL -> GLFW.GLFW_KEY_LEFT_CONTROL;
            case Keyboard.KEY_LSHIFT -> GLFW.GLFW_KEY_LEFT_SHIFT;
            case Keyboard.KEY_LMENU -> GLFW.GLFW_KEY_LEFT_ALT;
            case Keyboard.KEY_LMETA -> GLFW.GLFW_KEY_LEFT_SUPER;
            case Keyboard.KEY_RCONTROL -> GLFW.GLFW_KEY_RIGHT_CONTROL;
            case Keyboard.KEY_RSHIFT -> GLFW.GLFW_KEY_RIGHT_SHIFT;
            case Keyboard.KEY_RMENU -> GLFW.GLFW_KEY_RIGHT_ALT;
            case Keyboard.KEY_RMETA -> GLFW.GLFW_KEY_RIGHT_SUPER;
            case Keyboard.KEY_1 -> GLFW.GLFW_KEY_1;
            case Keyboard.KEY_2 -> GLFW.GLFW_KEY_2;
            case Keyboard.KEY_3 -> GLFW.GLFW_KEY_3;
            case Keyboard.KEY_4 -> GLFW.GLFW_KEY_4;
            case Keyboard.KEY_5 -> GLFW.GLFW_KEY_5;
            case Keyboard.KEY_6 -> GLFW.GLFW_KEY_6;
            case Keyboard.KEY_7 -> GLFW.GLFW_KEY_7;
            case Keyboard.KEY_8 -> GLFW.GLFW_KEY_8;
            case Keyboard.KEY_9 -> GLFW.GLFW_KEY_9;
            case Keyboard.KEY_0 -> GLFW.GLFW_KEY_0;
            case Keyboard.KEY_A -> GLFW.GLFW_KEY_A;
            case Keyboard.KEY_B -> GLFW.GLFW_KEY_B;
            case Keyboard.KEY_C -> GLFW.GLFW_KEY_C;
            case Keyboard.KEY_D -> GLFW.GLFW_KEY_D;
            case Keyboard.KEY_E -> GLFW.GLFW_KEY_E;
            case Keyboard.KEY_F -> GLFW.GLFW_KEY_F;
            case Keyboard.KEY_G -> GLFW.GLFW_KEY_G;
            case Keyboard.KEY_H -> GLFW.GLFW_KEY_H;
            case Keyboard.KEY_I -> GLFW.GLFW_KEY_I;
            case Keyboard.KEY_J -> GLFW.GLFW_KEY_J;
            case Keyboard.KEY_K -> GLFW.GLFW_KEY_K;
            case Keyboard.KEY_L -> GLFW.GLFW_KEY_L;
            case Keyboard.KEY_M -> GLFW.GLFW_KEY_M;
            case Keyboard.KEY_N -> GLFW.GLFW_KEY_N;
            case Keyboard.KEY_O -> GLFW.GLFW_KEY_O;
            case Keyboard.KEY_P -> GLFW.GLFW_KEY_P;
            case Keyboard.KEY_Q -> GLFW.GLFW_KEY_Q;
            case Keyboard.KEY_R -> GLFW.GLFW_KEY_R;
            case Keyboard.KEY_S -> GLFW.GLFW_KEY_S;
            case Keyboard.KEY_T -> GLFW.GLFW_KEY_T;
            case Keyboard.KEY_U -> GLFW.GLFW_KEY_U;
            case Keyboard.KEY_V -> GLFW.GLFW_KEY_V;
            case Keyboard.KEY_W -> GLFW.GLFW_KEY_W;
            case Keyboard.KEY_X -> GLFW.GLFW_KEY_X;
            case Keyboard.KEY_Y -> GLFW.GLFW_KEY_Y;
            case Keyboard.KEY_Z -> GLFW.GLFW_KEY_Z;
            case Keyboard.KEY_UP -> GLFW.GLFW_KEY_UP;
            case Keyboard.KEY_DOWN -> GLFW.GLFW_KEY_DOWN;
            case Keyboard.KEY_LEFT -> GLFW.GLFW_KEY_LEFT;
            case Keyboard.KEY_RIGHT -> GLFW.GLFW_KEY_RIGHT;
            case Keyboard.KEY_INSERT -> GLFW.GLFW_KEY_INSERT;
            case Keyboard.KEY_DELETE -> GLFW.GLFW_KEY_DELETE;
            case Keyboard.KEY_HOME -> GLFW.GLFW_KEY_HOME;
            case Keyboard.KEY_END -> GLFW.GLFW_KEY_END;
            case Keyboard.KEY_PRIOR -> GLFW.GLFW_KEY_PAGE_UP;
            case Keyboard.KEY_NEXT -> GLFW.GLFW_KEY_PAGE_DOWN;
            case Keyboard.KEY_F1 -> GLFW.GLFW_KEY_F1;
            case Keyboard.KEY_F2 -> GLFW.GLFW_KEY_F2;
            case Keyboard.KEY_F3 -> GLFW.GLFW_KEY_F3;
            case Keyboard.KEY_F4 -> GLFW.GLFW_KEY_F4;
            case Keyboard.KEY_F5 -> GLFW.GLFW_KEY_F5;
            case Keyboard.KEY_F6 -> GLFW.GLFW_KEY_F6;
            case Keyboard.KEY_F7 -> GLFW.GLFW_KEY_F7;
            case Keyboard.KEY_F8 -> GLFW.GLFW_KEY_F8;
            case Keyboard.KEY_F9 -> GLFW.GLFW_KEY_F9;
            case Keyboard.KEY_F10 -> GLFW.GLFW_KEY_F10;
            case Keyboard.KEY_F11 -> GLFW.GLFW_KEY_F11;
            case Keyboard.KEY_F12 -> GLFW.GLFW_KEY_F12;
            case Keyboard.KEY_F13 -> GLFW.GLFW_KEY_F13;
            case Keyboard.KEY_F14 -> GLFW.GLFW_KEY_F14;
            case Keyboard.KEY_F15 -> GLFW.GLFW_KEY_F15;
            case Keyboard.KEY_F16 -> GLFW.GLFW_KEY_F16;
            case Keyboard.KEY_F17 -> GLFW.GLFW_KEY_F17;
            case Keyboard.KEY_F18 -> GLFW.GLFW_KEY_F18;
            case Keyboard.KEY_F19 -> GLFW.GLFW_KEY_F19;
            case Keyboard.KEY_NUMPAD1 -> GLFW.GLFW_KEY_KP_1;
            case Keyboard.KEY_NUMPAD2 -> GLFW.GLFW_KEY_KP_2;
            case Keyboard.KEY_NUMPAD3 -> GLFW.GLFW_KEY_KP_3;
            case Keyboard.KEY_NUMPAD4 -> GLFW.GLFW_KEY_KP_4;
            case Keyboard.KEY_NUMPAD5 -> GLFW.GLFW_KEY_KP_5;
            case Keyboard.KEY_NUMPAD6 -> GLFW.GLFW_KEY_KP_6;
            case Keyboard.KEY_NUMPAD7 -> GLFW.GLFW_KEY_KP_7;
            case Keyboard.KEY_NUMPAD8 -> GLFW.GLFW_KEY_KP_8;
            case Keyboard.KEY_NUMPAD9 -> GLFW.GLFW_KEY_KP_9;
            case Keyboard.KEY_NUMPAD0 -> GLFW.GLFW_KEY_KP_0;
            case Keyboard.KEY_ADD -> GLFW.GLFW_KEY_KP_ADD;
            case Keyboard.KEY_SUBTRACT -> GLFW.GLFW_KEY_KP_SUBTRACT;
            case Keyboard.KEY_MULTIPLY -> GLFW.GLFW_KEY_KP_MULTIPLY;
            case Keyboard.KEY_DIVIDE -> GLFW.GLFW_KEY_KP_DIVIDE;
            case Keyboard.KEY_DECIMAL -> GLFW.GLFW_KEY_KP_DECIMAL;
            case Keyboard.KEY_NUMPADEQUALS -> GLFW.GLFW_KEY_KP_EQUAL;
            case Keyboard.KEY_NUMPADENTER -> GLFW.GLFW_KEY_KP_ENTER;
            case Keyboard.KEY_NUMLOCK -> GLFW.GLFW_KEY_NUM_LOCK;
            case Keyboard.KEY_SEMICOLON -> GLFW.GLFW_KEY_SEMICOLON;
            case Keyboard.KEY_BACKSLASH -> GLFW.GLFW_KEY_BACKSLASH;
            case Keyboard.KEY_COMMA -> GLFW.GLFW_KEY_COMMA;
            case Keyboard.KEY_PERIOD -> GLFW.GLFW_KEY_PERIOD;
            case Keyboard.KEY_SLASH -> GLFW.GLFW_KEY_SLASH;
            case Keyboard.KEY_GRAVE -> GLFW.GLFW_KEY_GRAVE_ACCENT;
            case Keyboard.KEY_CAPITAL -> GLFW.GLFW_KEY_CAPS_LOCK;
            case Keyboard.KEY_SCROLL -> GLFW.GLFW_KEY_SCROLL_LOCK;
            case Keyboard.KEY_PAUSE -> GLFW.GLFW_KEY_PAUSE;
            case Keyboard.KEY_CIRCUMFLEX -> GLFW.GLFW_KEY_WORLD_1; // "World" keys could be anything depending on
                                                                   // keyboard layout, pick something arbitrary
            case Keyboard.KEY_YEN -> GLFW.GLFW_KEY_WORLD_2;

            case Keyboard.KEY_MINUS -> GLFW.GLFW_KEY_MINUS;
            case Keyboard.KEY_EQUALS -> GLFW.GLFW_KEY_EQUAL;
            case Keyboard.KEY_LBRACKET -> GLFW.GLFW_KEY_LEFT_BRACKET;
            case Keyboard.KEY_RBRACKET -> GLFW.GLFW_KEY_RIGHT_BRACKET;
            case Keyboard.KEY_APOSTROPHE -> GLFW.GLFW_KEY_APOSTROPHE;
            // public static final int KEY_AT = 0x91; /* (NEC PC98) */
            // public static final int KEY_COLON = 0x92; /* (NEC PC98) */
            // public static final int KEY_UNDERLINE = 0x93; /* (NEC PC98) */

            // public static final int KEY_KANA = 0x70; /* (Japanese keyboard) */
            // public static final int KEY_CONVERT = 0x79; /* (Japanese keyboard) */
            // public static final int KEY_NOCONVERT = 0x7B; /* (Japanese keyboard) */
            // public static final int KEY_YEN = 0x7D; /* (Japanese keyboard) */

            // public static final int KEY_CIRCUMFLEX = 0x90; /* (Japanese keyboard) */
            // public static final int KEY_KANJI = 0x94; /* (Japanese keyboard) */
            // public static final int KEY_STOP = 0x95; /* (NEC PC98) */
            // public static final int KEY_AX = 0x96; /* (Japan AX) */
            // public static final int KEY_UNLABELED = 0x97; /* (J3100) */
            // public static final int KEY_SECTION = 0xA7; /* Section symbol (Mac) */
            // public static final int KEY_NUMPADCOMMA = 0xB3; /* , on numeric keypad (NEC PC98) */
            // public static final int KEY_SYSRQ = 0xB7;
            // public static final int KEY_FUNCTION = 0xC4; /* Function (Mac) */

            // public static final int KEY_CLEAR = 0xDA; /* Clear key (Mac) */

            // public static final int KEY_APPS = 0xDD; /* AppMenu key */
            // public static final int KEY_POWER = 0xDE;
            // public static final int KEY_SLEEP = 0xDF;

            default -> GLFW.GLFW_KEY_UNKNOWN;
        };
    }

    public static int sdlKeycodeToLwjgl(int sdlKeycode) {
        return switch (sdlKeycode) {
            case -1 -> Keyboard.KEY_UNLABELED;
            case SDLK_ESCAPE -> Keyboard.KEY_ESCAPE;
            case SDLK_BACKSPACE -> Keyboard.KEY_BACK;
            case SDLK_TAB -> Keyboard.KEY_TAB;
            case SDLK_RETURN -> Keyboard.KEY_RETURN;
            case SDLK_SPACE -> Keyboard.KEY_SPACE;
            case SDLK_LCTRL -> Keyboard.KEY_LCONTROL;
            case SDLK_LSHIFT -> Keyboard.KEY_LSHIFT;
            case SDLK_MENU -> Keyboard.KEY_LMENU;
            case SDLK_LGUI -> Keyboard.KEY_LMETA;
            case SDLK_RCTRL -> Keyboard.KEY_RCONTROL;
            case SDLK_RSHIFT -> Keyboard.KEY_RSHIFT;
            case SDLK_1 -> Keyboard.KEY_1;
            case SDLK_2 -> Keyboard.KEY_2;
            case SDLK_3 -> Keyboard.KEY_3;
            case SDLK_4 -> Keyboard.KEY_4;
            case SDLK_5 -> Keyboard.KEY_5;
            case SDLK_6 -> Keyboard.KEY_6;
            case SDLK_7 -> Keyboard.KEY_7;
            case SDLK_8 -> Keyboard.KEY_8;
            case SDLK_9 -> Keyboard.KEY_9;
            case SDLK_0 -> Keyboard.KEY_0;
            case SDLK_A -> Keyboard.KEY_A;
            case SDLK_B -> Keyboard.KEY_B;
            case SDLK_C -> Keyboard.KEY_C;
            case SDLK_D -> Keyboard.KEY_D;
            case SDLK_E -> Keyboard.KEY_E;
            case SDLK_F -> Keyboard.KEY_F;
            case SDLK_G -> Keyboard.KEY_G;
            case SDLK_H -> Keyboard.KEY_H;
            case SDLK_I -> Keyboard.KEY_I;
            case SDLK_J -> Keyboard.KEY_J;
            case SDLK_K -> Keyboard.KEY_K;
            case SDLK_L -> Keyboard.KEY_L;
            case SDLK_M -> Keyboard.KEY_M;
            case SDLK_N -> Keyboard.KEY_N;
            case SDLK_O -> Keyboard.KEY_O;
            case SDLK_P -> Keyboard.KEY_P;
            case SDLK_Q -> Keyboard.KEY_Q;
            case SDLK_R -> Keyboard.KEY_R;
            case SDLK_S -> Keyboard.KEY_S;
            case SDLK_T -> Keyboard.KEY_T;
            case SDLK_U -> Keyboard.KEY_U;
            case SDLK_V -> Keyboard.KEY_V;
            case SDLK_W -> Keyboard.KEY_W;
            case SDLK_X -> Keyboard.KEY_X;
            case SDLK_Y -> Keyboard.KEY_Y;
            case SDLK_Z -> Keyboard.KEY_Z;
            case SDLK_UP -> Keyboard.KEY_UP;
            case SDLK_DOWN -> Keyboard.KEY_DOWN;
            case SDLK_LEFT -> Keyboard.KEY_LEFT;
            case SDLK_RIGHT -> Keyboard.KEY_RIGHT;
            case SDLK_INSERT -> Keyboard.KEY_INSERT;
            case SDLK_DELETE -> Keyboard.KEY_DELETE;
            case SDLK_HOME -> Keyboard.KEY_HOME;
            case SDLK_END -> Keyboard.KEY_END;
            case SDLK_PAGEUP -> Keyboard.KEY_PRIOR;
            case SDLK_PAGEDOWN -> Keyboard.KEY_NEXT;
            case SDLK_F1 -> Keyboard.KEY_F1;
            case SDLK_F2 -> Keyboard.KEY_F2;
            case SDLK_F3 -> Keyboard.KEY_F3;
            case SDLK_F4 -> Keyboard.KEY_F4;
            case SDLK_F5 -> Keyboard.KEY_F5;
            case SDLK_F6 -> Keyboard.KEY_F6;
            case SDLK_F7 -> Keyboard.KEY_F7;
            case SDLK_F8 -> Keyboard.KEY_F8;
            case SDLK_F9 -> Keyboard.KEY_F9;
            case SDLK_F10 -> Keyboard.KEY_F10;
            case SDLK_F11 -> Keyboard.KEY_F11;
            case SDLK_F12 -> Keyboard.KEY_F12;
            case SDLK_F13 -> Keyboard.KEY_F13;
            case SDLK_F14 -> Keyboard.KEY_F14;
            case SDLK_F15 -> Keyboard.KEY_F15;
            case SDLK_F16 -> Keyboard.KEY_F16;
            case SDLK_F17 -> Keyboard.KEY_F17;
            case SDLK_F18 -> Keyboard.KEY_F18;
            case SDLK_F19 -> Keyboard.KEY_F19;
            case SDLK_KP_1 -> Keyboard.KEY_NUMPAD1;
            case SDLK_KP_2 -> Keyboard.KEY_NUMPAD2;
            case SDLK_KP_3 -> Keyboard.KEY_NUMPAD3;
            case SDLK_KP_4 -> Keyboard.KEY_NUMPAD4;
            case SDLK_KP_5 -> Keyboard.KEY_NUMPAD5;
            case SDLK_KP_6 -> Keyboard.KEY_NUMPAD6;
            case SDLK_KP_7 -> Keyboard.KEY_NUMPAD7;
            case SDLK_KP_8 -> Keyboard.KEY_NUMPAD8;
            case SDLK_KP_9 -> Keyboard.KEY_NUMPAD9;
            case SDLK_KP_0 -> Keyboard.KEY_NUMPAD0;
            case SDLK_KP_PLUS -> Keyboard.KEY_ADD;
            case SDLK_KP_MINUS -> Keyboard.KEY_SUBTRACT;
            case SDLK_KP_MULTIPLY -> Keyboard.KEY_MULTIPLY;
            case SDLK_KP_DIVIDE -> Keyboard.KEY_DIVIDE;
            case SDLK_KP_DECIMAL -> Keyboard.KEY_DECIMAL;
            case SDLK_KP_EQUALS -> Keyboard.KEY_NUMPADEQUALS;
            case SDLK_KP_ENTER -> Keyboard.KEY_NUMPADENTER;
            case SDLK_NUMLOCKCLEAR -> Keyboard.KEY_NUMLOCK;
            case SDLK_SEMICOLON -> Keyboard.KEY_SEMICOLON;
            case SDLK_BACKSLASH -> Keyboard.KEY_BACKSLASH;
            case SDLK_COMMA -> Keyboard.KEY_COMMA;
            case SDLK_PERIOD -> Keyboard.KEY_PERIOD;
            case SDLK_SLASH -> Keyboard.KEY_SLASH;
            case SDLK_GRAVE -> Keyboard.KEY_GRAVE;
            case SDLK_CAPSLOCK -> Keyboard.KEY_CAPITAL;
            case SDLK_SCROLLLOCK -> Keyboard.KEY_SCROLL;
            case SDLK_PAUSE -> Keyboard.KEY_PAUSE;

            case SDLK_MINUS -> Keyboard.KEY_MINUS;
            case SDLK_EQUALS -> Keyboard.KEY_EQUALS;
            case SDLK_LEFTBRACKET -> Keyboard.KEY_LBRACKET;
            case SDLK_RIGHTBRACKET -> Keyboard.KEY_RBRACKET;
            case SDLK_APOSTROPHE -> Keyboard.KEY_APOSTROPHE;
            case SDLK_AT -> Keyboard.KEY_AT; /* (NEC PC98) */
            case SDLK_COLON -> Keyboard.KEY_COLON; /* (NEC PC98) */
            // case SDLK_UNDERLINE -> Keyboard.KEY_UNDERLINE; /* (NEC PC98) */

            case L3F_SDLK_LANG3 -> Keyboard.KEY_KANA; /* (Japanese keyboard) */
            case L3F_SDLK_LANG2 -> Keyboard.KEY_CONVERT; /* (Japanese keyboard) */
            case L3F_SDLK_LANG4 -> Keyboard.KEY_NOCONVERT; /* (Japanese keyboard) */
            case L3F_SDLK_INTERNATIONAL3 -> Keyboard.KEY_YEN; /* (Japanese keyboard) */

            case L3F_SDLK_LANG1 -> Keyboard.KEY_CIRCUMFLEX; /* (Japanese keyboard) */
            case L3F_SDLK_LANG5 -> Keyboard.KEY_KANJI; /* (Japanese keyboard) */
            case SDLK_STOP -> Keyboard.KEY_STOP; /* (NEC PC98) */
            case L3F_SDLK_LANG6 -> Keyboard.KEY_AX; /* (Japan AX) */
            case L3F_SDLK_LANG8 -> Keyboard.KEY_SECTION; /* Section symbol (Mac) */
            case SDLK_KP_COMMA -> Keyboard.KEY_NUMPADCOMMA; /* , on numeric keypad (NEC PC98) */
            case SDLK_SYSREQ -> Keyboard.KEY_SYSRQ;
            // case SDLK_UNKNOWN -> Keyboard.KEY_FUNCTION; /* Function (Mac) */

            case SDLK_CLEAR -> Keyboard.KEY_CLEAR; /* Clear key (Mac) */

            case SDLK_APPLICATION -> Keyboard.KEY_APPS; /* AppMenu key */
            case SDLK_POWER -> Keyboard.KEY_POWER;
            case SDLK_SLEEP -> Keyboard.KEY_SLEEP;

            default -> Keyboard.KEY_NONE;
        };
    }

    public static int sdlScancodeToLwjgl(int sdlScancode) {
        return switch (sdlScancode) {
            case -1 -> Keyboard.KEY_UNLABELED;
            case SDL_SCANCODE_ESCAPE -> Keyboard.KEY_ESCAPE;
            case SDL_SCANCODE_BACKSPACE -> Keyboard.KEY_BACK;
            case SDL_SCANCODE_TAB -> Keyboard.KEY_TAB;
            case SDL_SCANCODE_RETURN -> Keyboard.KEY_RETURN;
            case SDL_SCANCODE_SPACE -> Keyboard.KEY_SPACE;
            case SDL_SCANCODE_LCTRL -> Keyboard.KEY_LCONTROL;
            case SDL_SCANCODE_LSHIFT -> Keyboard.KEY_LSHIFT;
            case SDL_SCANCODE_MENU -> Keyboard.KEY_LMENU;
            case SDL_SCANCODE_LGUI -> Keyboard.KEY_LMETA;
            case SDL_SCANCODE_RCTRL -> Keyboard.KEY_RCONTROL;
            case SDL_SCANCODE_RSHIFT -> Keyboard.KEY_RSHIFT;
            case SDL_SCANCODE_1 -> Keyboard.KEY_1;
            case SDL_SCANCODE_2 -> Keyboard.KEY_2;
            case SDL_SCANCODE_3 -> Keyboard.KEY_3;
            case SDL_SCANCODE_4 -> Keyboard.KEY_4;
            case SDL_SCANCODE_5 -> Keyboard.KEY_5;
            case SDL_SCANCODE_6 -> Keyboard.KEY_6;
            case SDL_SCANCODE_7 -> Keyboard.KEY_7;
            case SDL_SCANCODE_8 -> Keyboard.KEY_8;
            case SDL_SCANCODE_9 -> Keyboard.KEY_9;
            case SDL_SCANCODE_0 -> Keyboard.KEY_0;
            case SDL_SCANCODE_A -> Keyboard.KEY_A;
            case SDL_SCANCODE_B -> Keyboard.KEY_B;
            case SDL_SCANCODE_C -> Keyboard.KEY_C;
            case SDL_SCANCODE_D -> Keyboard.KEY_D;
            case SDL_SCANCODE_E -> Keyboard.KEY_E;
            case SDL_SCANCODE_F -> Keyboard.KEY_F;
            case SDL_SCANCODE_G -> Keyboard.KEY_G;
            case SDL_SCANCODE_H -> Keyboard.KEY_H;
            case SDL_SCANCODE_I -> Keyboard.KEY_I;
            case SDL_SCANCODE_J -> Keyboard.KEY_J;
            case SDL_SCANCODE_K -> Keyboard.KEY_K;
            case SDL_SCANCODE_L -> Keyboard.KEY_L;
            case SDL_SCANCODE_M -> Keyboard.KEY_M;
            case SDL_SCANCODE_N -> Keyboard.KEY_N;
            case SDL_SCANCODE_O -> Keyboard.KEY_O;
            case SDL_SCANCODE_P -> Keyboard.KEY_P;
            case SDL_SCANCODE_Q -> Keyboard.KEY_Q;
            case SDL_SCANCODE_R -> Keyboard.KEY_R;
            case SDL_SCANCODE_S -> Keyboard.KEY_S;
            case SDL_SCANCODE_T -> Keyboard.KEY_T;
            case SDL_SCANCODE_U -> Keyboard.KEY_U;
            case SDL_SCANCODE_V -> Keyboard.KEY_V;
            case SDL_SCANCODE_W -> Keyboard.KEY_W;
            case SDL_SCANCODE_X -> Keyboard.KEY_X;
            case SDL_SCANCODE_Y -> Keyboard.KEY_Y;
            case SDL_SCANCODE_Z -> Keyboard.KEY_Z;
            case SDL_SCANCODE_UP -> Keyboard.KEY_UP;
            case SDL_SCANCODE_DOWN -> Keyboard.KEY_DOWN;
            case SDL_SCANCODE_LEFT -> Keyboard.KEY_LEFT;
            case SDL_SCANCODE_RIGHT -> Keyboard.KEY_RIGHT;
            case SDL_SCANCODE_INSERT -> Keyboard.KEY_INSERT;
            case SDL_SCANCODE_DELETE -> Keyboard.KEY_DELETE;
            case SDL_SCANCODE_HOME -> Keyboard.KEY_HOME;
            case SDL_SCANCODE_END -> Keyboard.KEY_END;
            case SDL_SCANCODE_PAGEUP -> Keyboard.KEY_PRIOR;
            case SDL_SCANCODE_PAGEDOWN -> Keyboard.KEY_NEXT;
            case SDL_SCANCODE_F1 -> Keyboard.KEY_F1;
            case SDL_SCANCODE_F2 -> Keyboard.KEY_F2;
            case SDL_SCANCODE_F3 -> Keyboard.KEY_F3;
            case SDL_SCANCODE_F4 -> Keyboard.KEY_F4;
            case SDL_SCANCODE_F5 -> Keyboard.KEY_F5;
            case SDL_SCANCODE_F6 -> Keyboard.KEY_F6;
            case SDL_SCANCODE_F7 -> Keyboard.KEY_F7;
            case SDL_SCANCODE_F8 -> Keyboard.KEY_F8;
            case SDL_SCANCODE_F9 -> Keyboard.KEY_F9;
            case SDL_SCANCODE_F10 -> Keyboard.KEY_F10;
            case SDL_SCANCODE_F11 -> Keyboard.KEY_F11;
            case SDL_SCANCODE_F12 -> Keyboard.KEY_F12;
            case SDL_SCANCODE_F13 -> Keyboard.KEY_F13;
            case SDL_SCANCODE_F14 -> Keyboard.KEY_F14;
            case SDL_SCANCODE_F15 -> Keyboard.KEY_F15;
            case SDL_SCANCODE_F16 -> Keyboard.KEY_F16;
            case SDL_SCANCODE_F17 -> Keyboard.KEY_F17;
            case SDL_SCANCODE_F18 -> Keyboard.KEY_F18;
            case SDL_SCANCODE_F19 -> Keyboard.KEY_F19;
            case SDL_SCANCODE_KP_1 -> Keyboard.KEY_NUMPAD1;
            case SDL_SCANCODE_KP_2 -> Keyboard.KEY_NUMPAD2;
            case SDL_SCANCODE_KP_3 -> Keyboard.KEY_NUMPAD3;
            case SDL_SCANCODE_KP_4 -> Keyboard.KEY_NUMPAD4;
            case SDL_SCANCODE_KP_5 -> Keyboard.KEY_NUMPAD5;
            case SDL_SCANCODE_KP_6 -> Keyboard.KEY_NUMPAD6;
            case SDL_SCANCODE_KP_7 -> Keyboard.KEY_NUMPAD7;
            case SDL_SCANCODE_KP_8 -> Keyboard.KEY_NUMPAD8;
            case SDL_SCANCODE_KP_9 -> Keyboard.KEY_NUMPAD9;
            case SDL_SCANCODE_KP_0 -> Keyboard.KEY_NUMPAD0;
            case SDL_SCANCODE_KP_PLUS -> Keyboard.KEY_ADD;
            case SDL_SCANCODE_KP_MINUS -> Keyboard.KEY_SUBTRACT;
            case SDL_SCANCODE_KP_MULTIPLY -> Keyboard.KEY_MULTIPLY;
            case SDL_SCANCODE_KP_DIVIDE -> Keyboard.KEY_DIVIDE;
            case SDL_SCANCODE_KP_DECIMAL -> Keyboard.KEY_DECIMAL;
            case SDL_SCANCODE_KP_EQUALS -> Keyboard.KEY_NUMPADEQUALS;
            case SDL_SCANCODE_KP_ENTER -> Keyboard.KEY_NUMPADENTER;
            case SDL_SCANCODE_NUMLOCKCLEAR -> Keyboard.KEY_NUMLOCK;
            case SDL_SCANCODE_SEMICOLON -> Keyboard.KEY_SEMICOLON;
            case SDL_SCANCODE_BACKSLASH -> Keyboard.KEY_BACKSLASH;
            case SDL_SCANCODE_COMMA -> Keyboard.KEY_COMMA;
            case SDL_SCANCODE_PERIOD -> Keyboard.KEY_PERIOD;
            case SDL_SCANCODE_SLASH -> Keyboard.KEY_SLASH;
            case SDL_SCANCODE_GRAVE -> Keyboard.KEY_GRAVE;
            case SDL_SCANCODE_CAPSLOCK -> Keyboard.KEY_CAPITAL;
            case SDL_SCANCODE_SCROLLLOCK -> Keyboard.KEY_SCROLL;
            case SDL_SCANCODE_PAUSE -> Keyboard.KEY_PAUSE;

            case SDL_SCANCODE_MINUS -> Keyboard.KEY_MINUS;
            case SDL_SCANCODE_EQUALS -> Keyboard.KEY_EQUALS;
            case SDL_SCANCODE_LEFTBRACKET -> Keyboard.KEY_LBRACKET;
            case SDL_SCANCODE_RIGHTBRACKET -> Keyboard.KEY_RBRACKET;
            case SDL_SCANCODE_APOSTROPHE -> Keyboard.KEY_APOSTROPHE;
            case SDL_SCANCODE_KP_AT -> Keyboard.KEY_AT; /* (NEC PC98) */
            case SDL_SCANCODE_KP_COLON -> Keyboard.KEY_COLON; /* (NEC PC98) */
            // case SDL_SCANCODE_UNDERLINE -> Keyboard.KEY_UNDERLINE; /* (NEC PC98) */

            case SDL_SCANCODE_LANG3 -> Keyboard.KEY_KANA; /* (Japanese keyboard) */
            case SDL_SCANCODE_LANG2 -> Keyboard.KEY_CONVERT; /* (Japanese keyboard) */
            case SDL_SCANCODE_LANG4 -> Keyboard.KEY_NOCONVERT; /* (Japanese keyboard) */
            case SDL_SCANCODE_INTERNATIONAL3 -> Keyboard.KEY_YEN; /* (Japanese keyboard) */

            case SDL_SCANCODE_LANG1 -> Keyboard.KEY_CIRCUMFLEX; /* (Japanese keyboard) */
            case SDL_SCANCODE_LANG5 -> Keyboard.KEY_KANJI; /* (Japanese keyboard) */
            case SDL_SCANCODE_STOP -> Keyboard.KEY_STOP; /* (NEC PC98) */
            case SDL_SCANCODE_LANG6 -> Keyboard.KEY_AX; /* (Japan AX) */
            case SDL_SCANCODE_LANG8 -> Keyboard.KEY_SECTION; /* Section symbol (Mac) */
            case SDL_SCANCODE_KP_COMMA -> Keyboard.KEY_NUMPADCOMMA; /* , on numeric keypad (NEC PC98) */
            case SDL_SCANCODE_SYSREQ -> Keyboard.KEY_SYSRQ;
            // case SDL_SCANCODE_UNKNOWN -> Keyboard.KEY_FUNCTION; /* Function (Mac) */

            case SDL_SCANCODE_CLEAR -> Keyboard.KEY_CLEAR; /* Clear key (Mac) */

            case SDL_SCANCODE_APPLICATION -> Keyboard.KEY_APPS; /* AppMenu key */
            case SDL_SCANCODE_POWER -> Keyboard.KEY_POWER;
            case SDL_SCANCODE_SLEEP -> Keyboard.KEY_SLEEP;

            default -> Keyboard.KEY_NONE;
        };
    }

    public static int lwjglToSdlKeycode(int lwjglKeyCode) {
        return switch (lwjglKeyCode) {
            case Keyboard.KEY_NONE -> -1;
            case Keyboard.KEY_ESCAPE -> SDLK_ESCAPE;
            case Keyboard.KEY_BACK -> SDLK_BACKSPACE;
            case Keyboard.KEY_TAB -> SDLK_TAB;
            case Keyboard.KEY_RETURN -> SDLK_RETURN;
            case Keyboard.KEY_SPACE -> SDLK_SPACE;
            case Keyboard.KEY_LCONTROL -> SDLK_LCTRL;
            case Keyboard.KEY_LSHIFT -> SDLK_LSHIFT;
            case Keyboard.KEY_LMENU -> SDLK_MENU;
            case Keyboard.KEY_LMETA -> SDLK_LGUI;
            case Keyboard.KEY_RCONTROL -> SDLK_RCTRL;
            case Keyboard.KEY_RSHIFT -> SDLK_RSHIFT;
            case Keyboard.KEY_RMENU -> SDLK_MENU;
            case Keyboard.KEY_RMETA -> SDLK_RGUI;
            case Keyboard.KEY_1 -> SDLK_1;
            case Keyboard.KEY_2 -> SDLK_2;
            case Keyboard.KEY_3 -> SDLK_3;
            case Keyboard.KEY_4 -> SDLK_4;
            case Keyboard.KEY_5 -> SDLK_5;
            case Keyboard.KEY_6 -> SDLK_6;
            case Keyboard.KEY_7 -> SDLK_7;
            case Keyboard.KEY_8 -> SDLK_8;
            case Keyboard.KEY_9 -> SDLK_9;
            case Keyboard.KEY_0 -> SDLK_0;
            case Keyboard.KEY_A -> SDLK_A;
            case Keyboard.KEY_B -> SDLK_B;
            case Keyboard.KEY_C -> SDLK_C;
            case Keyboard.KEY_D -> SDLK_D;
            case Keyboard.KEY_E -> SDLK_E;
            case Keyboard.KEY_F -> SDLK_F;
            case Keyboard.KEY_G -> SDLK_G;
            case Keyboard.KEY_H -> SDLK_H;
            case Keyboard.KEY_I -> SDLK_I;
            case Keyboard.KEY_J -> SDLK_J;
            case Keyboard.KEY_K -> SDLK_K;
            case Keyboard.KEY_L -> SDLK_L;
            case Keyboard.KEY_M -> SDLK_M;
            case Keyboard.KEY_N -> SDLK_N;
            case Keyboard.KEY_O -> SDLK_O;
            case Keyboard.KEY_P -> SDLK_P;
            case Keyboard.KEY_Q -> SDLK_Q;
            case Keyboard.KEY_R -> SDLK_R;
            case Keyboard.KEY_S -> SDLK_S;
            case Keyboard.KEY_T -> SDLK_T;
            case Keyboard.KEY_U -> SDLK_U;
            case Keyboard.KEY_V -> SDLK_V;
            case Keyboard.KEY_W -> SDLK_W;
            case Keyboard.KEY_X -> SDLK_X;
            case Keyboard.KEY_Y -> SDLK_Y;
            case Keyboard.KEY_Z -> SDLK_Z;
            case Keyboard.KEY_UP -> SDLK_UP;
            case Keyboard.KEY_DOWN -> SDLK_DOWN;
            case Keyboard.KEY_LEFT -> SDLK_LEFT;
            case Keyboard.KEY_RIGHT -> SDLK_RIGHT;
            case Keyboard.KEY_INSERT -> SDLK_INSERT;
            case Keyboard.KEY_DELETE -> SDLK_DELETE;
            case Keyboard.KEY_HOME -> SDLK_HOME;
            case Keyboard.KEY_END -> SDLK_END;
            case Keyboard.KEY_PRIOR -> SDLK_PAGEUP;
            case Keyboard.KEY_NEXT -> SDLK_PAGEDOWN;
            case Keyboard.KEY_F1 -> SDLK_F1;
            case Keyboard.KEY_F2 -> SDLK_F2;
            case Keyboard.KEY_F3 -> SDLK_F3;
            case Keyboard.KEY_F4 -> SDLK_F4;
            case Keyboard.KEY_F5 -> SDLK_F5;
            case Keyboard.KEY_F6 -> SDLK_F6;
            case Keyboard.KEY_F7 -> SDLK_F7;
            case Keyboard.KEY_F8 -> SDLK_F8;
            case Keyboard.KEY_F9 -> SDLK_F9;
            case Keyboard.KEY_F10 -> SDLK_F10;
            case Keyboard.KEY_F11 -> SDLK_F11;
            case Keyboard.KEY_F12 -> SDLK_F12;
            case Keyboard.KEY_F13 -> SDLK_F13;
            case Keyboard.KEY_F14 -> SDLK_F14;
            case Keyboard.KEY_F15 -> SDLK_F15;
            case Keyboard.KEY_F16 -> SDLK_F16;
            case Keyboard.KEY_F17 -> SDLK_F17;
            case Keyboard.KEY_F18 -> SDLK_F18;
            case Keyboard.KEY_F19 -> SDLK_F19;
            case Keyboard.KEY_NUMPAD1 -> SDLK_KP_1;
            case Keyboard.KEY_NUMPAD2 -> SDLK_KP_2;
            case Keyboard.KEY_NUMPAD3 -> SDLK_KP_3;
            case Keyboard.KEY_NUMPAD4 -> SDLK_KP_4;
            case Keyboard.KEY_NUMPAD5 -> SDLK_KP_5;
            case Keyboard.KEY_NUMPAD6 -> SDLK_KP_6;
            case Keyboard.KEY_NUMPAD7 -> SDLK_KP_7;
            case Keyboard.KEY_NUMPAD8 -> SDLK_KP_8;
            case Keyboard.KEY_NUMPAD9 -> SDLK_KP_9;
            case Keyboard.KEY_NUMPAD0 -> SDLK_KP_0;
            case Keyboard.KEY_ADD -> SDLK_KP_PLUS;
            case Keyboard.KEY_SUBTRACT -> SDLK_KP_MINUS;
            case Keyboard.KEY_MULTIPLY -> SDLK_KP_MULTIPLY;
            case Keyboard.KEY_DIVIDE -> SDLK_KP_DIVIDE;
            case Keyboard.KEY_DECIMAL -> SDLK_KP_DECIMAL;
            case Keyboard.KEY_NUMPADEQUALS -> SDLK_KP_EQUALS;
            case Keyboard.KEY_NUMPADENTER -> SDLK_KP_ENTER;
            case Keyboard.KEY_NUMLOCK -> SDLK_NUMLOCKCLEAR;
            case Keyboard.KEY_SEMICOLON -> SDLK_SEMICOLON;
            case Keyboard.KEY_BACKSLASH -> SDLK_BACKSLASH;
            case Keyboard.KEY_COMMA -> SDLK_COMMA;
            case Keyboard.KEY_PERIOD -> SDLK_PERIOD;
            case Keyboard.KEY_SLASH -> SDLK_SLASH;
            case Keyboard.KEY_GRAVE -> SDLK_GRAVE;
            case Keyboard.KEY_CAPITAL -> SDLK_CAPSLOCK;
            case Keyboard.KEY_SCROLL -> SDLK_SCROLLLOCK;
            case Keyboard.KEY_PAUSE -> SDLK_PAUSE;

            case Keyboard.KEY_MINUS -> SDLK_MINUS;
            case Keyboard.KEY_EQUALS -> SDLK_EQUALS;
            case Keyboard.KEY_LBRACKET -> SDLK_LEFTBRACKET;
            case Keyboard.KEY_RBRACKET -> SDLK_RIGHTBRACKET;
            case Keyboard.KEY_APOSTROPHE -> SDLK_APOSTROPHE;
            case Keyboard.KEY_AT -> SDLK_AT; /* (NEC PC98) */
            case Keyboard.KEY_COLON -> SDLK_COLON; /* (NEC PC98) */
            // case Keyboard.KEY_UNDERLINE -> SDLK_UNDERLINE; /* (NEC PC98) */

            case Keyboard.KEY_KANA -> L3F_SDLK_LANG3; /* (Japanese keyboard) */
            case Keyboard.KEY_CONVERT -> L3F_SDLK_LANG2; /* (Japanese keyboard) */
            case Keyboard.KEY_NOCONVERT -> L3F_SDLK_LANG4; /* (Japanese keyboard) */
            case Keyboard.KEY_YEN -> L3F_SDLK_INTERNATIONAL3; /* (Japanese keyboard) */

            case Keyboard.KEY_CIRCUMFLEX -> L3F_SDLK_LANG1; /* (Japanese keyboard) */
            case Keyboard.KEY_KANJI -> L3F_SDLK_LANG5; /* (Japanese keyboard) */
            case Keyboard.KEY_STOP -> SDLK_STOP; /* (NEC PC98) */
            case Keyboard.KEY_AX -> L3F_SDLK_LANG6; /* (Japan AX) */
            case Keyboard.KEY_SECTION -> L3F_SDLK_LANG8; /* Section symbol (Mac) */
            case Keyboard.KEY_NUMPADCOMMA -> SDLK_KP_COMMA; /* , on numeric keypad (NEC PC98) */
            case Keyboard.KEY_SYSRQ -> SDLK_SYSREQ;
            // case Keyboard.KEY_FUNCTION -> ; /* Function (Mac) */

            case Keyboard.KEY_CLEAR -> SDLK_CLEAR; /* Clear key (Mac) */

            case Keyboard.KEY_APPS -> SDLK_APPLICATION; /* AppMenu key */
            case Keyboard.KEY_POWER -> SDLK_POWER;
            case Keyboard.KEY_SLEEP -> SDLK_SLEEP;

            default -> SDLK_UNKNOWN;
        };
    }

    public static int lwjglToSdlScancode(int lwjglCode) {
        return switch (lwjglCode) {
            case Keyboard.KEY_UNLABELED -> -1;
            case Keyboard.KEY_ESCAPE -> SDL_SCANCODE_ESCAPE;
            case Keyboard.KEY_BACK -> SDL_SCANCODE_BACKSPACE;
            case Keyboard.KEY_TAB -> SDL_SCANCODE_TAB;
            case Keyboard.KEY_RETURN -> SDL_SCANCODE_RETURN;
            case Keyboard.KEY_SPACE -> SDL_SCANCODE_SPACE;
            case Keyboard.KEY_LCONTROL -> SDL_SCANCODE_LCTRL;
            case Keyboard.KEY_LSHIFT -> SDL_SCANCODE_LSHIFT;
            case Keyboard.KEY_LMENU -> SDL_SCANCODE_MENU;
            case Keyboard.KEY_LMETA -> SDL_SCANCODE_LGUI;
            case Keyboard.KEY_RCONTROL -> SDL_SCANCODE_RCTRL;
            case Keyboard.KEY_RSHIFT -> SDL_SCANCODE_RSHIFT;
            case Keyboard.KEY_1 -> SDL_SCANCODE_1;
            case Keyboard.KEY_2 -> SDL_SCANCODE_2;
            case Keyboard.KEY_3 -> SDL_SCANCODE_3;
            case Keyboard.KEY_4 -> SDL_SCANCODE_4;
            case Keyboard.KEY_5 -> SDL_SCANCODE_5;
            case Keyboard.KEY_6 -> SDL_SCANCODE_6;
            case Keyboard.KEY_7 -> SDL_SCANCODE_7;
            case Keyboard.KEY_8 -> SDL_SCANCODE_8;
            case Keyboard.KEY_9 -> SDL_SCANCODE_9;
            case Keyboard.KEY_0 -> SDL_SCANCODE_0;
            case Keyboard.KEY_A -> SDL_SCANCODE_A;
            case Keyboard.KEY_B -> SDL_SCANCODE_B;
            case Keyboard.KEY_C -> SDL_SCANCODE_C;
            case Keyboard.KEY_D -> SDL_SCANCODE_D;
            case Keyboard.KEY_E -> SDL_SCANCODE_E;
            case Keyboard.KEY_F -> SDL_SCANCODE_F;
            case Keyboard.KEY_G -> SDL_SCANCODE_G;
            case Keyboard.KEY_H -> SDL_SCANCODE_H;
            case Keyboard.KEY_I -> SDL_SCANCODE_I;
            case Keyboard.KEY_J -> SDL_SCANCODE_J;
            case Keyboard.KEY_K -> SDL_SCANCODE_K;
            case Keyboard.KEY_L -> SDL_SCANCODE_L;
            case Keyboard.KEY_M -> SDL_SCANCODE_M;
            case Keyboard.KEY_N -> SDL_SCANCODE_N;
            case Keyboard.KEY_O -> SDL_SCANCODE_O;
            case Keyboard.KEY_P -> SDL_SCANCODE_P;
            case Keyboard.KEY_Q -> SDL_SCANCODE_Q;
            case Keyboard.KEY_R -> SDL_SCANCODE_R;
            case Keyboard.KEY_S -> SDL_SCANCODE_S;
            case Keyboard.KEY_T -> SDL_SCANCODE_T;
            case Keyboard.KEY_U -> SDL_SCANCODE_U;
            case Keyboard.KEY_V -> SDL_SCANCODE_V;
            case Keyboard.KEY_W -> SDL_SCANCODE_W;
            case Keyboard.KEY_X -> SDL_SCANCODE_X;
            case Keyboard.KEY_Y -> SDL_SCANCODE_Y;
            case Keyboard.KEY_Z -> SDL_SCANCODE_Z;
            case Keyboard.KEY_UP -> SDL_SCANCODE_UP;
            case Keyboard.KEY_DOWN -> SDL_SCANCODE_DOWN;
            case Keyboard.KEY_LEFT -> SDL_SCANCODE_LEFT;
            case Keyboard.KEY_RIGHT -> SDL_SCANCODE_RIGHT;
            case Keyboard.KEY_INSERT -> SDL_SCANCODE_INSERT;
            case Keyboard.KEY_DELETE -> SDL_SCANCODE_DELETE;
            case Keyboard.KEY_HOME -> SDL_SCANCODE_HOME;
            case Keyboard.KEY_END -> SDL_SCANCODE_END;
            case Keyboard.KEY_PRIOR -> SDL_SCANCODE_PAGEUP;
            case Keyboard.KEY_NEXT -> SDL_SCANCODE_PAGEDOWN;
            case Keyboard.KEY_F1 -> SDL_SCANCODE_F1;
            case Keyboard.KEY_F2 -> SDL_SCANCODE_F2;
            case Keyboard.KEY_F3 -> SDL_SCANCODE_F3;
            case Keyboard.KEY_F4 -> SDL_SCANCODE_F4;
            case Keyboard.KEY_F5 -> SDL_SCANCODE_F5;
            case Keyboard.KEY_F6 -> SDL_SCANCODE_F6;
            case Keyboard.KEY_F7 -> SDL_SCANCODE_F7;
            case Keyboard.KEY_F8 -> SDL_SCANCODE_F8;
            case Keyboard.KEY_F9 -> SDL_SCANCODE_F9;
            case Keyboard.KEY_F10 -> SDL_SCANCODE_F10;
            case Keyboard.KEY_F11 -> SDL_SCANCODE_F11;
            case Keyboard.KEY_F12 -> SDL_SCANCODE_F12;
            case Keyboard.KEY_F13 -> SDL_SCANCODE_F13;
            case Keyboard.KEY_F14 -> SDL_SCANCODE_F14;
            case Keyboard.KEY_F15 -> SDL_SCANCODE_F15;
            case Keyboard.KEY_F16 -> SDL_SCANCODE_F16;
            case Keyboard.KEY_F17 -> SDL_SCANCODE_F17;
            case Keyboard.KEY_F18 -> SDL_SCANCODE_F18;
            case Keyboard.KEY_F19 -> SDL_SCANCODE_F19;
            case Keyboard.KEY_NUMPAD1 -> SDL_SCANCODE_KP_1;
            case Keyboard.KEY_NUMPAD2 -> SDL_SCANCODE_KP_2;
            case Keyboard.KEY_NUMPAD3 -> SDL_SCANCODE_KP_3;
            case Keyboard.KEY_NUMPAD4 -> SDL_SCANCODE_KP_4;
            case Keyboard.KEY_NUMPAD5 -> SDL_SCANCODE_KP_5;
            case Keyboard.KEY_NUMPAD6 -> SDL_SCANCODE_KP_6;
            case Keyboard.KEY_NUMPAD7 -> SDL_SCANCODE_KP_7;
            case Keyboard.KEY_NUMPAD8 -> SDL_SCANCODE_KP_8;
            case Keyboard.KEY_NUMPAD9 -> SDL_SCANCODE_KP_9;
            case Keyboard.KEY_NUMPAD0 -> SDL_SCANCODE_KP_0;
            case Keyboard.KEY_ADD -> SDL_SCANCODE_KP_PLUS;
            case Keyboard.KEY_SUBTRACT -> SDL_SCANCODE_KP_MINUS;
            case Keyboard.KEY_MULTIPLY -> SDL_SCANCODE_KP_MULTIPLY;
            case Keyboard.KEY_DIVIDE -> SDL_SCANCODE_KP_DIVIDE;
            case Keyboard.KEY_DECIMAL -> SDL_SCANCODE_KP_DECIMAL;
            case Keyboard.KEY_NUMPADEQUALS -> SDL_SCANCODE_KP_EQUALS;
            case Keyboard.KEY_NUMPADENTER -> SDL_SCANCODE_KP_ENTER;
            case Keyboard.KEY_NUMLOCK -> SDL_SCANCODE_NUMLOCKCLEAR;
            case Keyboard.KEY_SEMICOLON -> SDL_SCANCODE_SEMICOLON;
            case Keyboard.KEY_BACKSLASH -> SDL_SCANCODE_BACKSLASH;
            case Keyboard.KEY_COMMA -> SDL_SCANCODE_COMMA;
            case Keyboard.KEY_PERIOD -> SDL_SCANCODE_PERIOD;
            case Keyboard.KEY_SLASH -> SDL_SCANCODE_SLASH;
            case Keyboard.KEY_GRAVE -> SDL_SCANCODE_GRAVE;
            case Keyboard.KEY_CAPITAL -> SDL_SCANCODE_CAPSLOCK;
            case Keyboard.KEY_SCROLL -> SDL_SCANCODE_SCROLLLOCK;
            case Keyboard.KEY_PAUSE -> SDL_SCANCODE_PAUSE;

            case Keyboard.KEY_MINUS -> SDL_SCANCODE_MINUS;
            case Keyboard.KEY_EQUALS -> SDL_SCANCODE_EQUALS;
            case Keyboard.KEY_LBRACKET -> SDL_SCANCODE_LEFTBRACKET;
            case Keyboard.KEY_RBRACKET -> SDL_SCANCODE_RIGHTBRACKET;
            case Keyboard.KEY_APOSTROPHE -> SDL_SCANCODE_APOSTROPHE;
            case Keyboard.KEY_AT -> SDL_SCANCODE_KP_AT; /* (NEC PC98) */
            case Keyboard.KEY_COLON -> SDL_SCANCODE_KP_COLON; /* (NEC PC98) */
            // case Keyboard.KEY_UNDERLINE -> SDL_SCANCODE_UNDERLINE; /* (NEC PC98) */

            case Keyboard.KEY_KANA -> SDL_SCANCODE_LANG3; /* (Japanese keyboard) */
            case Keyboard.KEY_CONVERT -> SDL_SCANCODE_LANG2; /* (Japanese keyboard) */
            case Keyboard.KEY_NOCONVERT -> SDL_SCANCODE_LANG4; /* (Japanese keyboard) */
            case Keyboard.KEY_YEN -> SDL_SCANCODE_INTERNATIONAL3; /* (Japanese keyboard) */

            case Keyboard.KEY_CIRCUMFLEX -> SDL_SCANCODE_LANG1; /* (Japanese keyboard) */
            case Keyboard.KEY_KANJI -> SDL_SCANCODE_LANG5; /* (Japanese keyboard) */
            case Keyboard.KEY_STOP -> SDL_SCANCODE_STOP; /* (NEC PC98) */
            case Keyboard.KEY_AX -> SDL_SCANCODE_LANG6; /* (Japan AX) */
            case Keyboard.KEY_SECTION -> SDL_SCANCODE_LANG8; /* Section symbol (Mac) */
            case Keyboard.KEY_NUMPADCOMMA -> SDL_SCANCODE_KP_COMMA; /* , on numeric keypad (NEC PC98) */
            case Keyboard.KEY_SYSRQ -> SDL_SCANCODE_SYSREQ;
            // case Keyboard.KEY_FUNCTION -> SDL_SCANCODE_UNKNOWN; /* Function (Mac) */

            case Keyboard.KEY_CLEAR -> SDL_SCANCODE_CLEAR; /* Clear key (Mac) */

            case Keyboard.KEY_APPS -> SDL_SCANCODE_APPLICATION; /* AppMenu key */
            case Keyboard.KEY_POWER -> SDL_SCANCODE_POWER;
            case Keyboard.KEY_SLEEP -> SDL_SCANCODE_SLEEP;

            default -> SDL_SCANCODE_UNKNOWN;
        };
    }

    public static int awtToLwjgl(int awtCode) {
        return switch (awtCode) {
            case KeyEvent.VK_ESCAPE -> Keyboard.KEY_ESCAPE;
            case KeyEvent.VK_1 -> Keyboard.KEY_1;
            case KeyEvent.VK_2 -> Keyboard.KEY_2;
            case KeyEvent.VK_3 -> Keyboard.KEY_3;
            case KeyEvent.VK_4 -> Keyboard.KEY_4;
            case KeyEvent.VK_5 -> Keyboard.KEY_5;
            case KeyEvent.VK_6 -> Keyboard.KEY_6;
            case KeyEvent.VK_7 -> Keyboard.KEY_7;
            case KeyEvent.VK_8 -> Keyboard.KEY_8;
            case KeyEvent.VK_9 -> Keyboard.KEY_9;
            case KeyEvent.VK_0 -> Keyboard.KEY_0;
            case KeyEvent.VK_MINUS -> Keyboard.KEY_MINUS;
            case KeyEvent.VK_EQUALS -> Keyboard.KEY_EQUALS;
            case KeyEvent.VK_BACK_SPACE -> Keyboard.KEY_BACK;
            case KeyEvent.VK_TAB -> Keyboard.KEY_TAB;
            case KeyEvent.VK_Q -> Keyboard.KEY_Q;
            case KeyEvent.VK_W -> Keyboard.KEY_W;
            case KeyEvent.VK_E -> Keyboard.KEY_E;
            case KeyEvent.VK_R -> Keyboard.KEY_R;
            case KeyEvent.VK_T -> Keyboard.KEY_T;
            case KeyEvent.VK_Y -> Keyboard.KEY_Y;
            case KeyEvent.VK_U -> Keyboard.KEY_U;
            case KeyEvent.VK_I -> Keyboard.KEY_I;
            case KeyEvent.VK_O -> Keyboard.KEY_O;
            case KeyEvent.VK_P -> Keyboard.KEY_P;
            case KeyEvent.VK_OPEN_BRACKET -> Keyboard.KEY_LBRACKET;
            case KeyEvent.VK_CLOSE_BRACKET -> Keyboard.KEY_RBRACKET;
            case KeyEvent.VK_ENTER -> Keyboard.KEY_RETURN;
            case KeyEvent.VK_CONTROL -> Keyboard.KEY_LCONTROL;
            case KeyEvent.VK_A -> Keyboard.KEY_A;
            case KeyEvent.VK_S -> Keyboard.KEY_S;
            case KeyEvent.VK_D -> Keyboard.KEY_D;
            case KeyEvent.VK_F -> Keyboard.KEY_F;
            case KeyEvent.VK_G -> Keyboard.KEY_G;
            case KeyEvent.VK_H -> Keyboard.KEY_H;
            case KeyEvent.VK_J -> Keyboard.KEY_J;
            case KeyEvent.VK_K -> Keyboard.KEY_K;
            case KeyEvent.VK_L -> Keyboard.KEY_L;
            case KeyEvent.VK_SEMICOLON -> Keyboard.KEY_SEMICOLON;
            case KeyEvent.VK_QUOTE -> Keyboard.KEY_APOSTROPHE;
            case KeyEvent.VK_DEAD_GRAVE -> Keyboard.KEY_GRAVE;
            case KeyEvent.VK_SHIFT -> Keyboard.KEY_LSHIFT;
            case KeyEvent.VK_BACK_SLASH -> Keyboard.KEY_BACKSLASH;
            case KeyEvent.VK_Z -> Keyboard.KEY_Z;
            case KeyEvent.VK_X -> Keyboard.KEY_X;
            case KeyEvent.VK_C -> Keyboard.KEY_C;
            case KeyEvent.VK_V -> Keyboard.KEY_V;
            case KeyEvent.VK_B -> Keyboard.KEY_B;
            case KeyEvent.VK_N -> Keyboard.KEY_N;
            case KeyEvent.VK_M -> Keyboard.KEY_M;
            case KeyEvent.VK_COMMA -> Keyboard.KEY_COMMA;
            case KeyEvent.VK_PERIOD -> Keyboard.KEY_PERIOD;
            case KeyEvent.VK_SLASH -> Keyboard.KEY_SLASH;
            case KeyEvent.VK_MULTIPLY -> Keyboard.KEY_MULTIPLY;
            case KeyEvent.VK_ALT -> Keyboard.KEY_LMENU;
            case KeyEvent.VK_SPACE -> Keyboard.KEY_SPACE;
            case KeyEvent.VK_CAPS_LOCK -> Keyboard.KEY_CAPITAL;
            case KeyEvent.VK_F1 -> Keyboard.KEY_F1;
            case KeyEvent.VK_F2 -> Keyboard.KEY_F2;
            case KeyEvent.VK_F3 -> Keyboard.KEY_F3;
            case KeyEvent.VK_F4 -> Keyboard.KEY_F4;
            case KeyEvent.VK_F5 -> Keyboard.KEY_F5;
            case KeyEvent.VK_F6 -> Keyboard.KEY_F6;
            case KeyEvent.VK_F7 -> Keyboard.KEY_F7;
            case KeyEvent.VK_F8 -> Keyboard.KEY_F8;
            case KeyEvent.VK_F9 -> Keyboard.KEY_F9;
            case KeyEvent.VK_F10 -> Keyboard.KEY_F10;
            case KeyEvent.VK_NUM_LOCK -> Keyboard.KEY_NUMLOCK;
            case KeyEvent.VK_SCROLL_LOCK -> Keyboard.KEY_SCROLL;
            case KeyEvent.VK_NUMPAD7 -> Keyboard.KEY_NUMPAD7;
            case KeyEvent.VK_NUMPAD8 -> Keyboard.KEY_NUMPAD8;
            case KeyEvent.VK_NUMPAD9 -> Keyboard.KEY_NUMPAD9;
            case KeyEvent.VK_SUBTRACT -> Keyboard.KEY_SUBTRACT;
            case KeyEvent.VK_NUMPAD4 -> Keyboard.KEY_NUMPAD4;
            case KeyEvent.VK_NUMPAD5 -> Keyboard.KEY_NUMPAD5;
            case KeyEvent.VK_NUMPAD6 -> Keyboard.KEY_NUMPAD6;
            case KeyEvent.VK_ADD -> Keyboard.KEY_ADD;
            case KeyEvent.VK_NUMPAD1 -> Keyboard.KEY_NUMPAD1;
            case KeyEvent.VK_NUMPAD2 -> Keyboard.KEY_NUMPAD2;
            case KeyEvent.VK_NUMPAD3 -> Keyboard.KEY_NUMPAD3;
            case KeyEvent.VK_NUMPAD0 -> Keyboard.KEY_NUMPAD0;
            case KeyEvent.VK_DECIMAL -> Keyboard.KEY_DECIMAL;
            case KeyEvent.VK_F11 -> Keyboard.KEY_F11;
            case KeyEvent.VK_F12 -> Keyboard.KEY_F12;
            case KeyEvent.VK_F13 -> Keyboard.KEY_F13;
            case KeyEvent.VK_F14 -> Keyboard.KEY_F14;
            case KeyEvent.VK_F15 -> Keyboard.KEY_F15;
            case KeyEvent.VK_KANA -> Keyboard.KEY_KANA;
            case KeyEvent.VK_CONVERT -> Keyboard.KEY_CONVERT;
            case KeyEvent.VK_NONCONVERT -> Keyboard.KEY_NOCONVERT;
            case KeyEvent.VK_CIRCUMFLEX -> Keyboard.KEY_CIRCUMFLEX;
            case KeyEvent.VK_AT -> Keyboard.KEY_AT;
            case KeyEvent.VK_COLON -> Keyboard.KEY_COLON;
            case KeyEvent.VK_UNDERSCORE -> Keyboard.KEY_UNDERLINE;
            case KeyEvent.VK_KANJI -> Keyboard.KEY_KANJI;
            case KeyEvent.VK_STOP -> Keyboard.KEY_STOP;
            case KeyEvent.VK_DIVIDE -> Keyboard.KEY_DIVIDE;
            case KeyEvent.VK_PAUSE -> Keyboard.KEY_PAUSE;
            case KeyEvent.VK_HOME -> Keyboard.KEY_HOME;
            case KeyEvent.VK_UP -> Keyboard.KEY_UP;
            case KeyEvent.VK_PAGE_UP -> Keyboard.KEY_PRIOR;
            case KeyEvent.VK_LEFT -> Keyboard.KEY_LEFT;
            case KeyEvent.VK_RIGHT -> Keyboard.KEY_RIGHT;
            case KeyEvent.VK_END -> Keyboard.KEY_END;
            case KeyEvent.VK_DOWN -> Keyboard.KEY_DOWN;
            case KeyEvent.VK_PAGE_DOWN -> Keyboard.KEY_NEXT;
            case KeyEvent.VK_INSERT -> Keyboard.KEY_INSERT;
            case KeyEvent.VK_DELETE -> Keyboard.KEY_DELETE;
            case KeyEvent.VK_META -> Keyboard.KEY_LWIN;
            default -> Keyboard.KEY_NONE;
        };
    }

    public static int lwjglToAwt(int lwjglCode) {
        return switch (lwjglCode) {
            case Keyboard.KEY_ESCAPE -> KeyEvent.VK_ESCAPE;
            case Keyboard.KEY_1 -> KeyEvent.VK_1;
            case Keyboard.KEY_2 -> KeyEvent.VK_2;
            case Keyboard.KEY_3 -> KeyEvent.VK_3;
            case Keyboard.KEY_4 -> KeyEvent.VK_4;
            case Keyboard.KEY_5 -> KeyEvent.VK_5;
            case Keyboard.KEY_6 -> KeyEvent.VK_6;
            case Keyboard.KEY_7 -> KeyEvent.VK_7;
            case Keyboard.KEY_8 -> KeyEvent.VK_8;
            case Keyboard.KEY_9 -> KeyEvent.VK_9;
            case Keyboard.KEY_0 -> KeyEvent.VK_0;
            case Keyboard.KEY_MINUS -> KeyEvent.VK_MINUS;
            case Keyboard.KEY_EQUALS -> KeyEvent.VK_EQUALS;
            case Keyboard.KEY_BACK -> KeyEvent.VK_BACK_SPACE;
            case Keyboard.KEY_TAB -> KeyEvent.VK_TAB;
            case Keyboard.KEY_Q -> KeyEvent.VK_Q;
            case Keyboard.KEY_W -> KeyEvent.VK_W;
            case Keyboard.KEY_E -> KeyEvent.VK_E;
            case Keyboard.KEY_R -> KeyEvent.VK_R;
            case Keyboard.KEY_T -> KeyEvent.VK_T;
            case Keyboard.KEY_Y -> KeyEvent.VK_Y;
            case Keyboard.KEY_U -> KeyEvent.VK_U;
            case Keyboard.KEY_I -> KeyEvent.VK_I;
            case Keyboard.KEY_O -> KeyEvent.VK_O;
            case Keyboard.KEY_P -> KeyEvent.VK_P;
            case Keyboard.KEY_LBRACKET -> KeyEvent.VK_OPEN_BRACKET;
            case Keyboard.KEY_RBRACKET -> KeyEvent.VK_CLOSE_BRACKET;
            case Keyboard.KEY_RETURN -> KeyEvent.VK_ENTER;
            case Keyboard.KEY_LCONTROL -> KeyEvent.VK_CONTROL;
            case Keyboard.KEY_A -> KeyEvent.VK_A;
            case Keyboard.KEY_S -> KeyEvent.VK_S;
            case Keyboard.KEY_D -> KeyEvent.VK_D;
            case Keyboard.KEY_F -> KeyEvent.VK_F;
            case Keyboard.KEY_G -> KeyEvent.VK_G;
            case Keyboard.KEY_H -> KeyEvent.VK_H;
            case Keyboard.KEY_J -> KeyEvent.VK_J;
            case Keyboard.KEY_K -> KeyEvent.VK_K;
            case Keyboard.KEY_L -> KeyEvent.VK_L;
            case Keyboard.KEY_SEMICOLON -> KeyEvent.VK_SEMICOLON;
            case Keyboard.KEY_APOSTROPHE -> KeyEvent.VK_QUOTE;
            case Keyboard.KEY_GRAVE -> KeyEvent.VK_DEAD_GRAVE;
            case Keyboard.KEY_LSHIFT -> KeyEvent.VK_SHIFT;
            case Keyboard.KEY_BACKSLASH -> KeyEvent.VK_BACK_SLASH;
            case Keyboard.KEY_Z -> KeyEvent.VK_Z;
            case Keyboard.KEY_X -> KeyEvent.VK_X;
            case Keyboard.KEY_C -> KeyEvent.VK_C;
            case Keyboard.KEY_V -> KeyEvent.VK_V;
            case Keyboard.KEY_B -> KeyEvent.VK_B;
            case Keyboard.KEY_N -> KeyEvent.VK_N;
            case Keyboard.KEY_M -> KeyEvent.VK_M;
            case Keyboard.KEY_COMMA -> KeyEvent.VK_COMMA;
            case Keyboard.KEY_PERIOD -> KeyEvent.VK_PERIOD;
            case Keyboard.KEY_SLASH -> KeyEvent.VK_SLASH;
            case Keyboard.KEY_MULTIPLY -> KeyEvent.VK_MULTIPLY;
            case Keyboard.KEY_LMENU -> KeyEvent.VK_ALT;
            case Keyboard.KEY_SPACE -> KeyEvent.VK_SPACE;
            case Keyboard.KEY_CAPITAL -> KeyEvent.VK_CAPS_LOCK;
            case Keyboard.KEY_F1 -> KeyEvent.VK_F1;
            case Keyboard.KEY_F2 -> KeyEvent.VK_F2;
            case Keyboard.KEY_F3 -> KeyEvent.VK_F3;
            case Keyboard.KEY_F4 -> KeyEvent.VK_F4;
            case Keyboard.KEY_F5 -> KeyEvent.VK_F5;
            case Keyboard.KEY_F6 -> KeyEvent.VK_F6;
            case Keyboard.KEY_F7 -> KeyEvent.VK_F7;
            case Keyboard.KEY_F8 -> KeyEvent.VK_F8;
            case Keyboard.KEY_F9 -> KeyEvent.VK_F9;
            case Keyboard.KEY_F10 -> KeyEvent.VK_F10;
            case Keyboard.KEY_NUMLOCK -> KeyEvent.VK_NUM_LOCK;
            case Keyboard.KEY_SCROLL -> KeyEvent.VK_SCROLL_LOCK;
            case Keyboard.KEY_NUMPAD7 -> KeyEvent.VK_NUMPAD7;
            case Keyboard.KEY_NUMPAD8 -> KeyEvent.VK_NUMPAD8;
            case Keyboard.KEY_NUMPAD9 -> KeyEvent.VK_NUMPAD9;
            case Keyboard.KEY_SUBTRACT -> KeyEvent.VK_SUBTRACT;
            case Keyboard.KEY_NUMPAD4 -> KeyEvent.VK_NUMPAD4;
            case Keyboard.KEY_NUMPAD5 -> KeyEvent.VK_NUMPAD5;
            case Keyboard.KEY_NUMPAD6 -> KeyEvent.VK_NUMPAD6;
            case Keyboard.KEY_ADD -> KeyEvent.VK_ADD;
            case Keyboard.KEY_NUMPAD1 -> KeyEvent.VK_NUMPAD1;
            case Keyboard.KEY_NUMPAD2 -> KeyEvent.VK_NUMPAD2;
            case Keyboard.KEY_NUMPAD3 -> KeyEvent.VK_NUMPAD3;
            case Keyboard.KEY_NUMPAD0 -> KeyEvent.VK_NUMPAD0;
            case Keyboard.KEY_DECIMAL -> KeyEvent.VK_DECIMAL;
            case Keyboard.KEY_F11 -> KeyEvent.VK_F11;
            case Keyboard.KEY_F12 -> KeyEvent.VK_F12;
            case Keyboard.KEY_F13 -> KeyEvent.VK_F13;
            case Keyboard.KEY_F14 -> KeyEvent.VK_F14;
            case Keyboard.KEY_F15 -> KeyEvent.VK_F15;
            case Keyboard.KEY_KANA -> KeyEvent.VK_KANA;
            case Keyboard.KEY_CONVERT -> KeyEvent.VK_CONVERT;
            case Keyboard.KEY_NOCONVERT -> KeyEvent.VK_NONCONVERT;
            case Keyboard.KEY_CIRCUMFLEX -> KeyEvent.VK_CIRCUMFLEX;
            case Keyboard.KEY_AT -> KeyEvent.VK_AT;
            case Keyboard.KEY_COLON -> KeyEvent.VK_COLON;
            case Keyboard.KEY_UNDERLINE -> KeyEvent.VK_UNDERSCORE;
            case Keyboard.KEY_KANJI -> KeyEvent.VK_KANJI;
            case Keyboard.KEY_STOP -> KeyEvent.VK_STOP;
            case Keyboard.KEY_DIVIDE -> KeyEvent.VK_DIVIDE;
            case Keyboard.KEY_PAUSE -> KeyEvent.VK_PAUSE;
            case Keyboard.KEY_HOME -> KeyEvent.VK_HOME;
            case Keyboard.KEY_UP -> KeyEvent.VK_UP;
            case Keyboard.KEY_PRIOR -> KeyEvent.VK_PAGE_UP;
            case Keyboard.KEY_LEFT -> KeyEvent.VK_LEFT;
            case Keyboard.KEY_RIGHT -> KeyEvent.VK_RIGHT;
            case Keyboard.KEY_END -> KeyEvent.VK_END;
            case Keyboard.KEY_DOWN -> KeyEvent.VK_DOWN;
            case Keyboard.KEY_NEXT -> KeyEvent.VK_PAGE_DOWN;
            case Keyboard.KEY_INSERT -> KeyEvent.VK_INSERT;
            case Keyboard.KEY_DELETE -> KeyEvent.VK_DELETE;
            case Keyboard.KEY_LWIN -> KeyEvent.VK_META;
            default -> Keyboard.KEY_NONE;
        };
    }
}
