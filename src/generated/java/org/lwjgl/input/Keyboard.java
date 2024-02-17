package org.lwjgl.input;

import org.lwjglx.LWJGLException;

public class Keyboard {

    public static final int CHAR_NONE = (int) 0;
    public static final int EVENT_SIZE = (int) 18;
    public static final int KEYBOARD_SIZE = (int) 256;
    public static final int KEY_0 = (int) 11;
    public static final int KEY_1 = (int) 2;
    public static final int KEY_2 = (int) 3;
    public static final int KEY_3 = (int) 4;
    public static final int KEY_4 = (int) 5;
    public static final int KEY_5 = (int) 6;
    public static final int KEY_6 = (int) 7;
    public static final int KEY_7 = (int) 8;
    public static final int KEY_8 = (int) 9;
    public static final int KEY_9 = (int) 10;
    public static final int KEY_A = (int) 30;
    public static final int KEY_ADD = (int) 78;
    public static final int KEY_APOSTROPHE = (int) 40;
    public static final int KEY_APPS = (int) 221;
    public static final int KEY_AT = (int) 145;
    public static final int KEY_AX = (int) 150;
    public static final int KEY_B = (int) 48;
    public static final int KEY_BACK = (int) 14;
    public static final int KEY_BACKSLASH = (int) 43;
    public static final int KEY_C = (int) 46;
    public static final int KEY_CAPITAL = (int) 58;
    public static final int KEY_CIRCUMFLEX = (int) 144;
    public static final int KEY_CLEAR = (int) 218;
    public static final int KEY_COLON = (int) 146;
    public static final int KEY_COMMA = (int) 51;
    public static final int KEY_CONVERT = (int) 121;
    public static final int KEY_D = (int) 32;
    public static final int KEY_DECIMAL = (int) 83;
    public static final int KEY_DELETE = (int) 211;
    public static final int KEY_DIVIDE = (int) 181;
    public static final int KEY_DOWN = (int) 208;
    public static final int KEY_E = (int) 18;
    public static final int KEY_END = (int) 207;
    public static final int KEY_EQUALS = (int) 13;
    public static final int KEY_ESCAPE = (int) 1;
    public static final int KEY_F10 = (int) 68;
    public static final int KEY_F11 = (int) 87;
    public static final int KEY_F12 = (int) 88;
    public static final int KEY_F13 = (int) 100;
    public static final int KEY_F14 = (int) 101;
    public static final int KEY_F15 = (int) 102;
    public static final int KEY_F16 = (int) 103;
    public static final int KEY_F17 = (int) 104;
    public static final int KEY_F18 = (int) 105;
    public static final int KEY_F19 = (int) 113;
    public static final int KEY_F1 = (int) 59;
    public static final int KEY_F2 = (int) 60;
    public static final int KEY_F3 = (int) 61;
    public static final int KEY_F4 = (int) 62;
    public static final int KEY_F5 = (int) 63;
    public static final int KEY_F6 = (int) 64;
    public static final int KEY_F7 = (int) 65;
    public static final int KEY_F8 = (int) 66;
    public static final int KEY_F9 = (int) 67;
    public static final int KEY_F = (int) 33;
    public static final int KEY_FUNCTION = (int) 196;
    public static final int KEY_G = (int) 34;
    public static final int KEY_GRAVE = (int) 41;
    public static final int KEY_H = (int) 35;
    public static final int KEY_HOME = (int) 199;
    public static final int KEY_I = (int) 23;
    public static final int KEY_INSERT = (int) 210;
    public static final int KEY_J = (int) 36;
    public static final int KEY_K = (int) 37;
    public static final int KEY_KANA = (int) 112;
    public static final int KEY_KANJI = (int) 148;
    public static final int KEY_L = (int) 38;
    public static final int KEY_LBRACKET = (int) 26;
    public static final int KEY_LCONTROL = (int) 29;
    public static final int KEY_LEFT = (int) 203;
    public static final int KEY_LMENU = (int) 56;
    public static final int KEY_LMETA = (int) 219;
    public static final int KEY_LSHIFT = (int) 42;
    public static final int KEY_LWIN = (int) 219;
    public static final int KEY_M = (int) 50;
    public static final int KEY_MINUS = (int) 12;
    public static final int KEY_MULTIPLY = (int) 55;
    public static final int KEY_N = (int) 49;
    public static final int KEY_NEXT = (int) 209;
    public static final int KEY_NOCONVERT = (int) 123;
    public static final int KEY_NONE = (int) 0;
    public static final int KEY_NUMLOCK = (int) 69;
    public static final int KEY_NUMPAD0 = (int) 82;
    public static final int KEY_NUMPAD1 = (int) 79;
    public static final int KEY_NUMPAD2 = (int) 80;
    public static final int KEY_NUMPAD3 = (int) 81;
    public static final int KEY_NUMPAD4 = (int) 75;
    public static final int KEY_NUMPAD5 = (int) 76;
    public static final int KEY_NUMPAD6 = (int) 77;
    public static final int KEY_NUMPAD7 = (int) 71;
    public static final int KEY_NUMPAD8 = (int) 72;
    public static final int KEY_NUMPAD9 = (int) 73;
    public static final int KEY_NUMPADCOMMA = (int) 179;
    public static final int KEY_NUMPADENTER = (int) 156;
    public static final int KEY_NUMPADEQUALS = (int) 141;
    public static final int KEY_O = (int) 24;
    public static final int KEY_P = (int) 25;
    public static final int KEY_PAUSE = (int) 197;
    public static final int KEY_PERIOD = (int) 52;
    public static final int KEY_POWER = (int) 222;
    public static final int KEY_PRIOR = (int) 201;
    public static final int KEY_Q = (int) 16;
    public static final int KEY_R = (int) 19;
    public static final int KEY_RBRACKET = (int) 27;
    public static final int KEY_RCONTROL = (int) 157;
    public static final int KEY_RETURN = (int) 28;
    public static final int KEY_RIGHT = (int) 205;
    public static final int KEY_RMENU = (int) 184;
    public static final int KEY_RMETA = (int) 220;
    public static final int KEY_RSHIFT = (int) 54;
    public static final int KEY_RWIN = (int) 220;
    public static final int KEY_S = (int) 31;
    public static final int KEY_SCROLL = (int) 70;
    public static final int KEY_SECTION = (int) 167;
    public static final int KEY_SEMICOLON = (int) 39;
    public static final int KEY_SLASH = (int) 53;
    public static final int KEY_SLEEP = (int) 223;
    public static final int KEY_SPACE = (int) 57;
    public static final int KEY_STOP = (int) 149;
    public static final int KEY_SUBTRACT = (int) 74;
    public static final int KEY_SYSRQ = (int) 183;
    public static final int KEY_T = (int) 20;
    public static final int KEY_TAB = (int) 15;
    public static final int KEY_U = (int) 22;
    public static final int KEY_UNDERLINE = (int) 147;
    public static final int KEY_UNLABELED = (int) 151;
    public static final int KEY_UP = (int) 200;
    public static final int KEY_V = (int) 47;
    public static final int KEY_W = (int) 17;
    public static final int KEY_X = (int) 45;
    public static final int KEY_Y = (int) 21;
    public static final int KEY_YEN = (int) 125;
    public static final int KEY_Z = (int) 44;

    public static boolean areRepeatEventsEnabled() {
        return org.lwjglx.input.Keyboard.areRepeatEventsEnabled();
    }

    public static void create() throws LWJGLException {
        org.lwjglx.input.Keyboard.create();
    }

    public static void destroy() {
        org.lwjglx.input.Keyboard.destroy();
    }

    public static void enableRepeatEvents(boolean arg0) {
        org.lwjglx.input.Keyboard.enableRepeatEvents(arg0);
    }

    public static char getEventCharacter() {
        return org.lwjglx.input.Keyboard.getEventCharacter();
    }

    public static int getEventKey() {
        return org.lwjglx.input.Keyboard.getEventKey();
    }

    public static boolean getEventKeyState() {
        return org.lwjglx.input.Keyboard.getEventKeyState();
    }

    public static long getEventNanoseconds() {
        return org.lwjglx.input.Keyboard.getEventNanoseconds();
    }

    public static int getKeyCount() {
        return org.lwjglx.input.Keyboard.getKeyCount();
    }

    public static int getKeyIndex(java.lang.String arg0) {
        return org.lwjglx.input.Keyboard.getKeyIndex(arg0);
    }

    public static java.lang.String getKeyName(int arg0) {
        return org.lwjglx.input.Keyboard.getKeyName(arg0);
    }

    public static int getNumKeyboardEvents() {
        return org.lwjglx.input.Keyboard.getNumKeyboardEvents();
    }

    public static boolean isCreated() {
        return org.lwjglx.input.Keyboard.isCreated();
    }

    public static boolean isKeyDown(int arg0) {
        return org.lwjglx.input.Keyboard.isKeyDown(arg0);
    }

    public static boolean isRepeatEvent() {
        return org.lwjglx.input.Keyboard.isRepeatEvent();
    }

    public static boolean next() {
        return org.lwjglx.input.Keyboard.next();
    }

    public static void poll() {
        org.lwjglx.input.Keyboard.poll();
    }

}
