package org.lwjglx.input;

import static org.lwjgl.sdl.SDLKeyboard.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.sdl.SDLKeycode;
import org.lwjgl.sdl.SDLScancode;
import org.lwjglx.Sys;
import org.lwjglx.opengl.Display;

import com.google.common.base.Objects;

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;

public class Keyboard {

    /**
     * The special character meaning that no character was translated for the event.
     */
    public static final int CHAR_NONE = '\0';

    /**
     * The special keycode meaning that only the translated character is valid.
     */
    public static final int KEY_NONE = 0x00;

    public static final int KEY_ESCAPE = 0x01;
    public static final int KEY_1 = 0x02;
    public static final int KEY_2 = 0x03;
    public static final int KEY_3 = 0x04;
    public static final int KEY_4 = 0x05;
    public static final int KEY_5 = 0x06;
    public static final int KEY_6 = 0x07;
    public static final int KEY_7 = 0x08;
    public static final int KEY_8 = 0x09;
    public static final int KEY_9 = 0x0A;
    public static final int KEY_0 = 0x0B;
    public static final int KEY_MINUS = 0x0C; /* - on main keyboard */
    public static final int KEY_EQUALS = 0x0D;
    public static final int KEY_BACK = 0x0E; /* backspace */
    public static final int KEY_TAB = 0x0F;
    public static final int KEY_Q = 0x10;
    public static final int KEY_W = 0x11;
    public static final int KEY_E = 0x12;
    public static final int KEY_R = 0x13;
    public static final int KEY_T = 0x14;
    public static final int KEY_Y = 0x15;
    public static final int KEY_U = 0x16;
    public static final int KEY_I = 0x17;
    public static final int KEY_O = 0x18;
    public static final int KEY_P = 0x19;
    public static final int KEY_LBRACKET = 0x1A;
    public static final int KEY_RBRACKET = 0x1B;
    public static final int KEY_RETURN = 0x1C; /* Enter on main keyboard */
    public static final int KEY_LCONTROL = 0x1D;
    public static final int KEY_A = 0x1E;
    public static final int KEY_S = 0x1F;
    public static final int KEY_D = 0x20;
    public static final int KEY_F = 0x21;
    public static final int KEY_G = 0x22;
    public static final int KEY_H = 0x23;
    public static final int KEY_J = 0x24;
    public static final int KEY_K = 0x25;
    public static final int KEY_L = 0x26;
    public static final int KEY_SEMICOLON = 0x27;
    public static final int KEY_APOSTROPHE = 0x28;
    public static final int KEY_GRAVE = 0x29; /* accent grave */
    public static final int KEY_LSHIFT = 0x2A;
    public static final int KEY_BACKSLASH = 0x2B;
    public static final int KEY_Z = 0x2C;
    public static final int KEY_X = 0x2D;
    public static final int KEY_C = 0x2E;
    public static final int KEY_V = 0x2F;
    public static final int KEY_B = 0x30;
    public static final int KEY_N = 0x31;
    public static final int KEY_M = 0x32;
    public static final int KEY_COMMA = 0x33;
    public static final int KEY_PERIOD = 0x34; /* . on main keyboard */
    public static final int KEY_SLASH = 0x35; /* / on main keyboard */
    public static final int KEY_RSHIFT = 0x36;
    public static final int KEY_MULTIPLY = 0x37; /* * on numeric keypad */
    public static final int KEY_LMENU = 0x38; /* left Alt */
    public static final int KEY_SPACE = 0x39;
    public static final int KEY_CAPITAL = 0x3A;
    public static final int KEY_F1 = 0x3B;
    public static final int KEY_F2 = 0x3C;
    public static final int KEY_F3 = 0x3D;
    public static final int KEY_F4 = 0x3E;
    public static final int KEY_F5 = 0x3F;
    public static final int KEY_F6 = 0x40;
    public static final int KEY_F7 = 0x41;
    public static final int KEY_F8 = 0x42;
    public static final int KEY_F9 = 0x43;
    public static final int KEY_F10 = 0x44;
    public static final int KEY_NUMLOCK = 0x45;
    public static final int KEY_SCROLL = 0x46; /* Scroll Lock */
    public static final int KEY_NUMPAD7 = 0x47;
    public static final int KEY_NUMPAD8 = 0x48;
    public static final int KEY_NUMPAD9 = 0x49;
    public static final int KEY_SUBTRACT = 0x4A; /* - on numeric keypad */
    public static final int KEY_NUMPAD4 = 0x4B;
    public static final int KEY_NUMPAD5 = 0x4C;
    public static final int KEY_NUMPAD6 = 0x4D;
    public static final int KEY_ADD = 0x4E; /* + on numeric keypad */
    public static final int KEY_NUMPAD1 = 0x4F;
    public static final int KEY_NUMPAD2 = 0x50;
    public static final int KEY_NUMPAD3 = 0x51;
    public static final int KEY_NUMPAD0 = 0x52;
    public static final int KEY_DECIMAL = 0x53; /* . on numeric keypad */
    public static final int KEY_F11 = 0x57;
    public static final int KEY_F12 = 0x58;
    public static final int KEY_F13 = 0x64; /* (NEC PC98) */
    public static final int KEY_F14 = 0x65; /* (NEC PC98) */
    public static final int KEY_F15 = 0x66; /* (NEC PC98) */
    public static final int KEY_F16 = 0x67; /* Extended Function keys - (Mac) */
    public static final int KEY_F17 = 0x68;
    public static final int KEY_F18 = 0x69;
    public static final int KEY_KANA = 0x70; /* (Japanese keyboard) */
    public static final int KEY_F19 = 0x71; /* Extended Function keys - (Mac) */
    public static final int KEY_CONVERT = 0x79; /* (Japanese keyboard) */
    public static final int KEY_NOCONVERT = 0x7B; /* (Japanese keyboard) */
    public static final int KEY_YEN = 0x7D; /* (Japanese keyboard) */
    public static final int KEY_NUMPADEQUALS = 0x8D; /* = on numeric keypad (NEC PC98) */
    public static final int KEY_CIRCUMFLEX = 0x90; /* (Japanese keyboard) */
    public static final int KEY_AT = 0x91; /* (NEC PC98) */
    public static final int KEY_COLON = 0x92; /* (NEC PC98) */
    public static final int KEY_UNDERLINE = 0x93; /* (NEC PC98) */
    public static final int KEY_KANJI = 0x94; /* (Japanese keyboard) */
    public static final int KEY_STOP = 0x95; /* (NEC PC98) */
    public static final int KEY_AX = 0x96; /* (Japan AX) */
    public static final int KEY_UNLABELED = 0x97; /* (J3100) */
    public static final int KEY_NUMPADENTER = 0x9C; /* Enter on numeric keypad */
    public static final int KEY_RCONTROL = 0x9D;
    public static final int KEY_SECTION = 0xA7; /* Section symbol (Mac) */
    public static final int KEY_NUMPADCOMMA = 0xB3; /* , on numeric keypad (NEC PC98) */
    public static final int KEY_DIVIDE = 0xB5; /* / on numeric keypad */
    public static final int KEY_SYSRQ = 0xB7;
    public static final int KEY_RMENU = 0xB8; /* right Alt */
    public static final int KEY_FUNCTION = 0xC4; /* Function (Mac) */
    public static final int KEY_PAUSE = 0xC5; /* Pause */
    public static final int KEY_HOME = 0xC7; /* Home on arrow keypad */
    public static final int KEY_UP = 0xC8; /* UpArrow on arrow keypad */
    public static final int KEY_PRIOR = 0xC9; /* PgUp on arrow keypad */
    public static final int KEY_LEFT = 0xCB; /* LeftArrow on arrow keypad */
    public static final int KEY_RIGHT = 0xCD; /* RightArrow on arrow keypad */
    public static final int KEY_END = 0xCF; /* End on arrow keypad */
    public static final int KEY_DOWN = 0xD0; /* DownArrow on arrow keypad */
    public static final int KEY_NEXT = 0xD1; /* PgDn on arrow keypad */
    public static final int KEY_INSERT = 0xD2; /* Insert on arrow keypad */
    public static final int KEY_DELETE = 0xD3; /* Delete on arrow keypad */
    public static final int KEY_CLEAR = 0xDA; /* Clear key (Mac) */
    public static final int KEY_LMETA = 0xDB; /* Left Windows/Option key */
    public static final int KEY_LWIN = KEY_LMETA; /* Left Windows key */
    public static final int KEY_RMETA = 0xDC; /* Right Windows/Option key */
    public static final int KEY_RWIN = KEY_RMETA; /* Right Windows key */
    public static final int KEY_APPS = 0xDD; /* AppMenu key */
    public static final int KEY_POWER = 0xDE;
    public static final int KEY_SLEEP = 0xDF;

    public static final int keyCount;

    public static ByteBuffer sdlKeyPressedArray;

    private static final TIntObjectHashMap<String> keyMap = new TIntObjectHashMap<>(512, 0.5f);
    private static final TObjectIntHashMap<String> reverseKeyMap = new TObjectIntHashMap<>(512, 0.5f, -1);

    public enum KeyState {

        PRESS(true),
        RELEASE(false),
        REPEAT(true);

        public final boolean isPressed;

        KeyState(boolean isPressed) {
            this.isPressed = isPressed;
        }
    }

    private static boolean doRepeatEvents = true;

    public static final int KEYBOARD_SIZE = Short.MAX_VALUE;
    public static Queue<KeyEvent> eventQueue = new ArrayBlockingQueue<>(256);
    private static final String[] unlocalizedKeyNameMiniLut = new String[Short.MAX_VALUE];

    static {
        // Use reflection to find out key names
        Field[] fields = Keyboard.class.getFields();
        int keyCounter = 0;
        try {
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())
                    && Modifier.isFinal(field.getModifiers())
                    && field.getType()
                        .equals(int.class)
                    && field.getName()
                        .startsWith("KEY_")
                    && !field.getName()
                        .endsWith("WIN")) {
                    /* Don't use deprecated names */
                    int key = field.getInt(null);
                    String name = field.getName()
                        .substring(4);
                    unlocalizedKeyNameMiniLut[key] = name;
                    reverseKeyMap.put(name, key);
                    keyCounter++;
                }
            }
        } catch (Exception e) {}
        keyCount = keyCounter;
        for (int i = 0; i < unlocalizedKeyNameMiniLut.length; i++) {
            if (unlocalizedKeyNameMiniLut[i] == null) {
                unlocalizedKeyNameMiniLut[i] = "Key " + i;
            }
        }
        eventQueue.add(new KeyEvent(0, 0, '\0', KeyState.RELEASE, Sys.getNanoTime()));
    }

    /** Populates the key name->index lookup table with the current keyboard layout based names. */
    public static void populateKeyLookupTables() {
        keyMap.clear();
        reverseKeyMap.clear();
        for (int key = 0; key <= 255; key++) {
            getKeyName(key);
        }
    }

    public static void addRawKeyEvent(KeyEvent event) {
        if (event == null || (event.state == KeyState.REPEAT && !doRepeatEvents)) {
            return;
        }
        if (Config.DEBUG_PRINT_KEY_EVENTS) {
            Lwjgl3ify.LOG.info(
                "[DEBUG-KEY-QUEUE] queued key event key:{} action:{} state:{} charname:{} naive-char:{}",
                event.key,
                event.state,
                event.state,
                java.awt.event.KeyEvent.getKeyText(KeyCodes.lwjglToAwt(event.key)),
                (event.key >= 32 && event.key < 127) ? (event.key) : '?');
        }
        try {
            eventQueue.add(event);
        } catch (IllegalStateException ignored) {}
    }

    public static void addSdlKeyEvent(int key, int scancode, InputEvents.KeyAction action, int mods, int c,
        long nanoTime) {
        final KeyState state = switch (action) {
            case PRESSED -> KeyState.PRESS;
            case RELEASED -> KeyState.RELEASE;
            case REPEATED -> KeyState.REPEAT;
        };
        addRawKeyEvent(
            new KeyEvent(KeyCodes.sdlScancodeToLwjgl(scancode), KeyCodes.sdlKeycodeToLwjgl(key), c, state, nanoTime));
    }

    public static void addCharEvent(int key, int c) {
        if (Config.DEBUG_PRINT_KEY_EVENTS) {
            Lwjgl3ify.LOG.info("[DEBUG-KEY-QUEUE] queued char virtual keypress codepoint:{} char:{}", c, c);
        }
        try {
            eventQueue.add(new KeyEvent(KEY_NONE, KEY_NONE, c, KeyState.PRESS, Sys.getNanoTime()));
        } catch (IllegalStateException ignored) {}
    }

    public static void create() {}

    public static boolean isKeyDown(int key) {
        final ByteBuffer array = sdlKeyPressedArray;
        if (key == KEY_NONE || array == null) {
            return false;
        }
        final int sdlScancode = KeyCodes.lwjglToSdlScancode(key);
        if (sdlScancode <= 0 || sdlScancode >= array.limit()) {
            return false;
        }
        return array.get(sdlScancode) != 0;
    }

    public static void poll() {
        // no-op
    }

    public static void enableRepeatEvents(boolean enable) {
        doRepeatEvents = enable;
    }

    public static boolean areRepeatEventsEnabled() {
        return doRepeatEvents;
    }

    public static int getKeyCount() {
        return keyCount;
    }

    public static int getNumKeyboardEvents() {
        return eventQueue.size();
    }

    public static boolean isRepeatEvent() {
        return eventQueue.peek().state == KeyState.REPEAT;
    }

    public static boolean next() {
        boolean next = eventQueue.size() > 1;
        if (next) {
            eventQueue.remove();
        }
        return next;
    }

    public static int getEventKey() {
        return eventQueue.peek().key;
    }

    public static int lwjgl3ify$getEventKeyNonScancode() {
        return eventQueue.peek().keyNonScancode;
    }

    public static char getEventCharacter() {
        return (char) eventQueue.peek().codepoint;
    }

    public static int lwjgl3ify$getEventCodePoint() {
        return eventQueue.peek().codepoint;
    }

    public static boolean getEventKeyState() {
        return eventQueue.peek().state.isPressed;
    }

    public static long getEventNanoseconds() {
        return eventQueue.peek().nano;
    }

    public static synchronized String getKeyName(int key) {
        if (key == KEY_NONE) {
            return "NONE";
        }
        final String cached = keyMap.get(key);
        if (cached != null) {
            return cached;
        }
        int sdlScan = KeyCodes.lwjglToSdlScancode(key);
        if (sdlScan == -1 || sdlScan == SDLScancode.SDL_SCANCODE_UNKNOWN) {
            return "Key " + key;
        }
        int sdlKey = SDL_GetKeyFromScancode(sdlScan, (short) 0, true);
        if (sdlKey == SDLKeycode.SDLK_UNKNOWN) {
            return "Key " + key;
        }
        String name = Objects.firstNonNull(MainThreadExec.runOnMainThread(() -> SDL_GetKeyName(sdlKey)), "UNKNOWN")
            .toUpperCase(Locale.ROOT);
        keyMap.put(key, name);
        reverseKeyMap.put(name, key);
        return name;
    }

    public static synchronized int getKeyIndex(String keyName) {
        if (keyName.equals("NONE")) {
            return KEY_NONE;
        }

        int ret = reverseKeyMap.get(keyName);
        if (ret == -1) {
            if (keyName.matches("Key -?[0-9]+]")) {
                return Integer.parseInt(StringUtils.removeStart(keyName, "Key "));
            }
            return KEY_NONE;
        } else return ret;
    }

    public static boolean isCreated() {
        return Display.isCreated();
    }

    public static void destroy() {}

    public static final class KeyEvent {

        public int key;
        public int keyNonScancode;
        public int codepoint;
        public KeyState state;
        public long nano;
        public boolean queueOutOfOrderRelease = false;

        public KeyEvent(int key, int keyNonScancode, int codepoint, KeyState state, long nano) {
            this.key = shouldTreatAsScancode(key) ? key : keyNonScancode;
            this.keyNonScancode = keyNonScancode;
            this.codepoint = codepoint;
            this.state = state;
            this.nano = nano;
        }

        public KeyEvent copy() {
            final KeyEvent ev = new KeyEvent(key, keyNonScancode, codepoint, state, nano);
            ev.queueOutOfOrderRelease = this.queueOutOfOrderRelease;
            return ev;
        }

        /**
         * These are all the keys where we use the actual keycodes as inputs to respect different keyboard
         * layouts/remappings better
         */
        public static boolean shouldTreatAsScancode(int lwjglKey) {
            return switch (lwjglKey) {
                // spotless:off
                case Keyboard.KEY_ESCAPE, Keyboard.KEY_HOME,
                     Keyboard.KEY_NUMLOCK, Keyboard.KEY_CAPITAL, Keyboard.KEY_SCROLL,
                     Keyboard.KEY_LCONTROL , Keyboard.KEY_LSHIFT, Keyboard.KEY_LMETA, Keyboard.KEY_LMENU,
                     Keyboard.KEY_RCONTROL , Keyboard.KEY_RSHIFT, Keyboard.KEY_RMETA, Keyboard.KEY_RMENU
                    -> false;
                // spotless:on
                default -> true;
            };
        }

    }
}
