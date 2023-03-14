package com.github.wohaopa;

public class InputFix {

    private static boolean openedGui = false;

    private static final int MAX = 256;
    static char[] chars = new char[MAX];

    private static int head = 0;
    private static int back = 0;
    private static int count = 0;

    public static void enableRepeatEvents(boolean enable) {
        openedGui = enable;
    }

    public static boolean hasNextChar() {
        return count > 0;
    }

    public static char nextChar() {
        char c = chars[head++];
        count--;
        if (head >= MAX) head = 0;
        return c;
    }

    public static void addChar(char c) {
        if (!openedGui) return;
        chars[back++] = c;
        if (back >= MAX) back = 0;
        count++;
    }

}
