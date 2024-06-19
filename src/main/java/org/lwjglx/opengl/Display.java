package org.lwjglx.opengl;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.awt.Canvas;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.Platform;
import org.lwjglx.BufferUtils;
import org.lwjglx.Sys;
import org.lwjglx.input.KeyCodes;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.core.Config;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class Display {

    private static String windowTitle = "Game";

    private static boolean displayCreated = false;
    private static boolean displayFocused = false;
    private static boolean displayVisible = true;
    private static boolean displayDirty = false;
    private static boolean displayResizable = false;
    private static boolean startFullscreen = false;

    private static DisplayMode mode = new DisplayMode(854, 480);
    private static DisplayMode desktopDisplayMode = new DisplayMode(854, 480);

    private static int latestEventKey = 0;

    private static int displayX = 0;
    private static int displayY = 0;

    private static boolean displayResized = false;
    private static int displayWidth = 0;
    private static int displayHeight = 0;
    private static int displayFramebufferWidth = 0;
    private static int displayFramebufferHeight = 0;

    private static boolean latestResized = false;
    private static int latestWidth = 0;
    private static int latestHeight = 0;
    private static boolean cancelNextChar = false;
    private static Keyboard.KeyEvent ingredientKeyEvent;
    private static ByteBuffer[] savedIcons;
    private static boolean lastAltIsRightAlt = false;
    private static HashMap<Integer, String> glfwKeycodeNames = new HashMap<>();

    static {
        Sys.initialize(); // init using dummy sys method

        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);

        int monitorWidth = vidmode.width();
        int monitorHeight = vidmode.height();
        int monitorBitPerPixel = vidmode.redBits() + vidmode.greenBits() + vidmode.blueBits();
        int monitorRefreshRate = vidmode.refreshRate();

        desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);

        try {
            Class<GLFW> glfwClass = GLFW.class;
            for (Field f : glfwClass.getFields()) {
                if (f.getName()
                    .startsWith("GLFW_KEY_") && f.getType() == int.class
                    && Modifier.isStatic(f.getModifiers())) {
                    int value = f.getInt(null);
                    glfwKeycodeNames.put(value, f.getName());
                }
            }
        } catch (ReflectiveOperationException e) {
            // ignore
        }
    }

    /**
     * Create the OpenGL context with the given minimum parameters. If isFullscreen() is true or if windowed context are
     * not supported on the platform, the display mode will be switched to the mode returned by getDisplayMode(), and a
     * fullscreen context will be created. If isFullscreen() is false, a windowed context will be created with the
     * dimensions given in the mode returned by getDisplayMode(). If a context can't be created with the given
     * parameters, a LWJGLException will be thrown.
     * <p/>
     * <p>
     * The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
     *
     * @param pixelFormat    Describes the minimum specifications the context must fulfill.
     * @param sharedDrawable The Drawable to share context with. (optional, may be null)
     *
     * @throws org.lwjglx.LWJGLException
     */
    public static void create(PixelFormat pixelFormat, Drawable sharedDrawable) {
        create(pixelFormat, (ContextAttribs) null, sharedDrawable.getGlfwWindowId());
    }

    public static void create() {
        create(null, (ContextAttribs) null);
    }

    public static void create(PixelFormat pixelFormat) {
        create(pixelFormat, (ContextAttribs) null);
    }

    public static void create(PixelFormat pixelFormat, ContextAttribs attribs) {
        create(pixelFormat, attribs, NULL);
    }

    public static void create(PixelFormat pixelFormat, ContextAttribs attribs, long sharedWindow) {
        if (displayCreated) {
            return;
        }

        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);

        int monitorWidth = vidmode.width();
        int monitorHeight = vidmode.height();
        int monitorBitPerPixel = vidmode.redBits() + vidmode.greenBits() + vidmode.blueBits();
        int monitorRefreshRate = vidmode.refreshRate();

        desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);

        final int ctxMajor = (attribs != null) ? attribs.getMajorVersion() : 2;
        final int ctxMinor = (attribs != null) ? attribs.getMinorVersion() : 1;
        final boolean ctxForwardCompat = attribs != null && attribs.isForwardCompatible();
        final boolean ctxSrgb = pixelFormat != null ? pixelFormat.isSRGB() : Config.OPENGL_SRGB_CONTEXT;

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, ctxMajor);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, ctxMinor);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, ctxForwardCompat ? GLFW_TRUE : GLFW_FALSE);
        if (attribs != null) {
            if (attribs.isProfileCore()) {
                glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
            } else if (attribs.isProfileCompatibility()) {
                glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_COMPAT_PROFILE);
            }
        }

        glfwWindowHint(GLFW_MAXIMIZED, Config.WINDOW_START_MAXIMIZED ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(GLFW_FOCUSED, Config.WINDOW_START_FOCUSED ? GLFW_TRUE : GLFW_FALSE);
        displayFocused = Config.WINDOW_START_FOCUSED;
        glfwWindowHint(GLFW_ICONIFIED, Config.WINDOW_START_ICONIFIED ? GLFW_TRUE : GLFW_FALSE);
        displayVisible = !Config.WINDOW_START_ICONIFIED;
        glfwWindowHint(GLFW_DECORATED, Config.WINDOW_DECORATED ? GLFW_TRUE : GLFW_FALSE);

        glfwWindowHint(GLFW_SRGB_CAPABLE, ctxSrgb ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(GLFW_DOUBLEBUFFER, Config.OPENGL_DOUBLEBUFFER ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(GLFW_CONTEXT_NO_ERROR, Config.OPENGL_CONTEXT_NO_ERROR ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(
            GLFW_OPENGL_DEBUG_CONTEXT,
            (Config.OPENGL_DEBUG_CONTEXT || Config.DEBUG_REGISTER_OPENGL_LOGGER) ? GLFW_TRUE : GLFW_FALSE);
        glfwWindowHint(
            GLFW_OPENGL_DEBUG_CONTEXT,
            (Config.OPENGL_DEBUG_CONTEXT || Config.DEBUG_REGISTER_OPENGL_LOGGER) ? GLFW_TRUE : GLFW_FALSE);

        glfwWindowHintString(GLFW_X11_CLASS_NAME, Config.X11_CLASS_NAME);
        glfwWindowHintString(GLFW_COCOA_FRAME_NAME, Config.COCOA_FRAME_NAME);

        glfwWindowHint(GLFW_COCOA_RETINA_FRAMEBUFFER, GLFW_FALSE); // request a non-hidpi framebuffer on Retina displays
                                                                   // on MacOS

        Window.handle = glfwCreateWindow(mode.getWidth(), mode.getHeight(), windowTitle, NULL, sharedWindow);
        if (Window.handle == 0L) {
            throw new IllegalStateException("Failed to create Display window");
        }

        Window.keyCallback = new GLFWKeyCallback() {

            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (Config.DEBUG_PRINT_KEY_EVENTS) {
                    Lwjgl3ify.LOG.info(
                        "[DEBUG-KEY] key window:{} key:{} ({}) scancode:{} action:{} mods:{} charname:{} naive-char:{}",
                        window,
                        key,
                        glfwKeycodeNames.getOrDefault(key, "unknown"),
                        scancode,
                        action == GLFW_PRESS ? "PRESS" : (action == GLFW_RELEASE ? "RELEASE" : "REPEAT"),
                        mods,
                        KeyEvent.getKeyText(KeyCodes.lwjglToAwt(KeyCodes.glfwToLwjgl(key))),
                        (key >= 32 && key < 127) ? ((char) key) : '?');
                }
                final InputEvents.KeyAction enumAction = switch (action) {
                    case GLFW_PRESS -> InputEvents.KeyAction.PRESSED;
                    case GLFW_RELEASE -> InputEvents.KeyAction.RELEASED;
                    case GLFW_REPEAT -> InputEvents.KeyAction.REPEATED;
                    default -> InputEvents.KeyAction.PRESSED;
                };
                InputEvents.injectKeyEvent(
                    new InputEvents.KeyEvent(
                        KeyCodes.glfwToLwjgl(key),
                        key,
                        scancode,
                        enumAction,
                        (mods & GLFW_MOD_CONTROL) != 0,
                        (mods & GLFW_MOD_SHIFT) != 0,
                        (mods & GLFW_MOD_ALT) != 0,
                        (mods & GLFW_MOD_SUPER) != 0));
                cancelNextChar = false;
                if (action == GLFW_PRESS) {
                    if (key == GLFW_KEY_LEFT_ALT) {
                        lastAltIsRightAlt = false;
                    } else if (key == GLFW_KEY_RIGHT_ALT) {
                        lastAltIsRightAlt = true;
                    }
                }
                if (key > GLFW_KEY_SPACE && key <= GLFW_KEY_GRAVE_ACCENT) { // Handle keys have a char. Exclude space to
                                                                            // avoid extra input when switching IME

                    /*
                     * AltGr and LAlt require special consideration.
                     * On Windows, AltGr and Ctrl+Alt send the same `mods` value of ALT|CTRL in this event.
                     * This means that to distinguish potential text input from special key combos we have to look at
                     * the last pressed Alt key side.
                     * Ctrl combos have to send a (key & 0x1f) ASCII Escape code to work correctly with a lot of older
                     * mods, but this obviously breaks text input.
                     * Therefore, we assume text input with AltGr, and control combination input with Left Alt, but both
                     * can be switched in the config if the player desires.
                     */
                    final boolean isAlt = (GLFW_MOD_ALT & mods) != 0;
                    final boolean isAltGr = lastAltIsRightAlt;
                    final boolean ctrlGraphicalMode;
                    if (isAlt) {
                        if (isAltGr) {
                            ctrlGraphicalMode = !Config.INPUT_ALTGR_ESCAPE_CODES;
                        } else {
                            // is left alt
                            ctrlGraphicalMode = Config.INPUT_CTRL_ALT_TEXT;
                        }
                        if (ctrlGraphicalMode) {
                            Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) (key & 0x1f));
                        }
                    } else {
                        ctrlGraphicalMode = false;
                    }

                    if ((GLFW_MOD_SUPER & mods) != 0) {
                        Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) key);
                        if (Platform.get() != Platform.MACOSX) {
                            // MacOS doesn't send a char event for Cmd+KEY presses, but other platforms do.
                            cancelNextChar = true;
                        }
                    } else if ((GLFW_MOD_CONTROL & mods) != 0 && !ctrlGraphicalMode) { // Handle ctrl + x/c/v.
                        if (Config.DEBUG_PRINT_KEY_EVENTS) {
                            Lwjgl3ify.LOG.info(
                                "[DEBUG-KEY] Handling key as escape code, skipping next char input. isAlt:{} isAltGr:{}",
                                isAlt,
                                isAltGr);
                        }
                        Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, (char) (key & 0x1f));
                        cancelNextChar = true; // Cancel char event from ctrl key since its already handled here
                    } else if (action > 0) { // Delay press and repeat key event to actual char input. There is ALWAYS a
                                             // char after them
                        ingredientKeyEvent = new Keyboard.KeyEvent(
                            KeyCodes.glfwToLwjgl(key),
                            '\0',
                            action > 1 ? Keyboard.KeyState.REPEAT : Keyboard.KeyState.PRESS,
                            Sys.getNanoTime());
                    } else { // Release event
                        if (ingredientKeyEvent != null && ingredientKeyEvent.key == KeyCodes.glfwToLwjgl(key)) {
                            ingredientKeyEvent.queueOutOfOrderRelease = true;
                        }
                        Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, '\0');
                    }
                } else { // Other key with no char event associated
                    char mappedChar = switch (key) {
                        case GLFW_KEY_ENTER -> 0x0D;
                        case GLFW_KEY_ESCAPE -> 0x1B;
                        case GLFW_KEY_TAB -> 0x09;
                        case GLFW_KEY_BACKSPACE -> 0x08;
                        default -> '\0';
                    };
                    Keyboard.addGlfwKeyEvent(window, key, scancode, action, mods, mappedChar);
                }
            }
        };

        Window.charCallback = new GLFWCharCallback() {

            @Override
            public void invoke(long window, int codepoint) {
                if (Config.DEBUG_PRINT_KEY_EVENTS) {
                    Lwjgl3ify.LOG
                        .info("[DEBUG-KEY] char window:{} codepoint:{} char:{}", window, codepoint, (char) codepoint);
                }
                InputEvents.injectTextEvent(new InputEvents.TextEvent(String.valueOf((char) codepoint)));
                if (cancelNextChar) { // Char event being cancelled
                    cancelNextChar = false;
                } else if (ingredientKeyEvent != null) {
                    ingredientKeyEvent.aChar = (char) codepoint; // Send char with ASCII key event here
                    Keyboard.addRawKeyEvent(ingredientKeyEvent);
                    if (ingredientKeyEvent.queueOutOfOrderRelease) {
                        ingredientKeyEvent = ingredientKeyEvent.copy();
                        ingredientKeyEvent.state = Keyboard.KeyState.RELEASE;
                        Keyboard.addRawKeyEvent(ingredientKeyEvent);
                    }
                    ingredientKeyEvent = null;
                } else {
                    Keyboard.addCharEvent(0, (char) codepoint); // Non-ASCII chars
                }
            }
        };

        Window.cursorPosCallback = new GLFWCursorPosCallback() {

            @Override
            public void invoke(long window, double xpos, double ypos) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] cursorPos window:{} xpos:{} ypos:{}", window, xpos, ypos);
                }
                Mouse.addMoveEvent(xpos, ypos);
            }
        };

        Window.mouseButtonCallback = new GLFWMouseButtonCallback() {

            @Override
            public void invoke(long window, int button, int action, int mods) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info(
                        "[DEBUG-MOUSE] button window:{} button:{} action:{} mods:{}",
                        window,
                        button,
                        action,
                        mods);
                }
                Mouse.addButtonEvent(button, action == GLFW.GLFW_PRESS ? true : false);
            }
        };

        Window.scrollCallback = new GLFWScrollCallback() {

            @Override
            public void invoke(long window, double xoffset, double yoffset) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] wheel window:{} xoffset:{} yoffset:{}", window, xoffset, yoffset);
                }
                Mouse.addWheelEvent(yoffset == 0 ? (Config.INPUT_INVERT_X_WHEEL ? -xoffset : xoffset) : yoffset);
            }
        };

        Window.windowFocusCallback = new GLFWWindowFocusCallback() {

            @Override
            public void invoke(long window, boolean focused) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] focus window:{} focus:{}", window, focused);
                }
                displayFocused = focused;
            }
        };

        Window.windowIconifyCallback = new GLFWWindowIconifyCallback() {

            @Override
            public void invoke(long window, boolean iconified) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] focus window:{} iconified:{}", window, iconified);
                }
                displayVisible = !iconified;
            }
        };

        Window.windowSizeCallback = new GLFWWindowSizeCallback() {

            @Override
            public void invoke(long window, int width, int height) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] window-resize window:{} w:{} h:{}", window, width, height);
                }
                latestResized = true;
                latestWidth = width;
                latestHeight = height;
            }
        };

        Window.windowPosCallback = new GLFWWindowPosCallback() {

            @Override
            public void invoke(long window, int xpos, int ypos) {
                displayX = xpos;
                displayY = ypos;
            }
        };

        Window.windowRefreshCallback = new GLFWWindowRefreshCallback() {

            @Override
            public void invoke(long window) {
                displayDirty = true;
            }
        };

        Window.framebufferSizeCallback = new GLFWFramebufferSizeCallback() {

            @Override
            public void invoke(long window, int width, int height) {
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] framebuffer-resize window:{} w:{} h:{}", window, width, height);
                }
                displayFramebufferWidth = width;
                displayFramebufferHeight = height;
            }
        };

        Window.setCallbacks();

        displayWidth = mode.getWidth();
        displayHeight = mode.getHeight();

        IntBuffer fbw = BufferUtils.createIntBuffer(1);
        IntBuffer fbh = BufferUtils.createIntBuffer(1);
        GLFW.glfwGetFramebufferSize(Window.handle, fbw, fbh);
        displayFramebufferWidth = fbw.get(0);
        displayFramebufferHeight = fbh.get(0);

        displayX = (monitorWidth - mode.getWidth()) / 2;
        displayY = (monitorHeight - mode.getHeight()) / 2;

        glfwMakeContextCurrent(Window.handle);
        drawable = new DrawableGL();
        GL.createCapabilities();

        if (savedIcons != null) {
            setIcon(savedIcons);
            savedIcons = null;
        }

        glfwSwapInterval(1);

        displayCreated = true;

        lwjgl3ify$updateRawMouseMode(Config.INPUT_RAW_MOUSE);

        if (startFullscreen) {
            setFullscreen(true);
        }

        int[] x = new int[1], y = new int[1];
        GLFW.glfwGetWindowSize(Window.handle, x, y);
        Window.windowSizeCallback.invoke(Window.handle, x[0], y[0]);
        GLFW.glfwGetFramebufferSize(Window.handle, x, y);
        Window.framebufferSizeCallback.invoke(Window.handle, x[0], y[0]);
    }

    public static void lwjgl3ify$updateRawMouseMode(boolean mode) {
        final boolean supported = GLFW.glfwRawMouseMotionSupported();
        if (isCreated()) {
            if (supported) {
                GLFW.glfwSetInputMode(Window.handle, GLFW_RAW_MOUSE_MOTION, mode ? GLFW_TRUE : GLFW_FALSE);
                Lwjgl3ifyCoremod.LOGGER.info("Updated raw mouse input mode to " + mode);
            } else if (mode) {
                Lwjgl3ifyCoremod.LOGGER.warn("Raw mouse input not supported on your system.");
            }
        }
    }

    public static boolean isCreated() {
        return displayCreated;
    }

    public static boolean isActive() {
        return displayFocused;
    }

    public static boolean isVisible() {
        return displayVisible;
    }

    public static void setLocation(int new_x, int new_y) {
        System.out.println("TODO: Implement Display.setLocation(int, int)");
    }

    public static void setVSyncEnabled(boolean sync) {
        glfwSwapInterval(sync ? 1 : 0);
    }

    public static long getWindow() {
        return Window.handle;
    }

    public static void update() {
        update(true);
    }

    public static void update(boolean processMessages) {
        swapBuffers();
        displayDirty = false;

        if (processMessages) processMessages();
    }

    public static void processMessages() {
        glfwPollEvents();
        Keyboard.poll();
        Mouse.poll();

        if (latestResized) {
            latestResized = false;
            displayResized = true;
            displayWidth = latestWidth;
            displayHeight = latestHeight;
        } else {
            displayResized = false;
        }
    }

    public static void swapBuffers() {
        glfwSwapBuffers(Window.handle);
    }

    public static void destroy() {
        Window.releaseCallbacks();
        glfwDestroyWindow(Window.handle);

        /*
         * try { glfwTerminate(); } catch (Throwable t) { t.printStackTrace(); }
         */
        displayCreated = false;
    }

    public static void setDisplayMode(DisplayMode dm) {
        mode = dm;
    }

    public static DisplayMode getDisplayMode() {
        return mode;
    }

    public static DisplayMode[] getAvailableDisplayModes() {
        IntBuffer count = BufferUtils.createIntBuffer(1);
        GLFWVidMode.Buffer modes = GLFW.glfwGetVideoModes(glfwGetPrimaryMonitor());

        DisplayMode[] displayModes = new DisplayMode[count.get(0)];

        for (int i = 0; i < count.get(0); i++) {
            modes.position(i * GLFWVidMode.SIZEOF);

            int w = modes.width();
            int h = modes.height();
            int b = modes.redBits() + modes.greenBits() + modes.blueBits();
            int r = modes.refreshRate();

            displayModes[i] = new DisplayMode(w, h, b, r);
        }

        return displayModes;
    }

    public static DisplayMode getDesktopDisplayMode() {
        return desktopDisplayMode;
    }

    public static boolean wasResized() {
        return displayResized;
    }

    public static int getX() {
        return displayX;
    }

    public static int getY() {
        return displayY;
    }

    public static int getWidth() {
        return displayWidth;
    }

    public static int getHeight() {
        return displayHeight;
    }

    public static int getFramebufferWidth() {
        return displayFramebufferWidth;
    }

    public static int getFramebufferHeight() {
        return displayFramebufferHeight;
    }

    public static void setTitle(String title) {
        windowTitle = title;
        if (isCreated()) {
            glfwSetWindowTitle(getWindow(), title);
        }
    }

    public static boolean isCloseRequested() {
        final boolean saved = glfwWindowShouldClose(Window.handle);
        glfwSetWindowShouldClose(Window.handle, false);
        return saved;
    }

    public static boolean isDirty() {
        return displayDirty;
    }

    public static void setInitialBackground(float red, float green, float blue) {
        // no-op
    }

    public static int setIcon(java.nio.ByteBuffer[] icons) {
        if (getWindow() == 0) {
            savedIcons = icons;
            return 0;
        }
        GLFWImage.Buffer glfwImages = GLFWImage.calloc(icons.length);
        ByteBuffer[] nativeBuffers = new ByteBuffer[icons.length];
        for (int icon = 0; icon < icons.length; icon++) {
            nativeBuffers[icon] = org.lwjgl.BufferUtils.createByteBuffer(icons[icon].capacity());
            nativeBuffers[icon].put(icons[icon]);
            nativeBuffers[icon].flip();
            int dimension = (int) Math.sqrt(nativeBuffers[icon].limit() / 4D);
            if (dimension * dimension * 4 != nativeBuffers[icon].limit()) {
                throw new IllegalStateException();
            }
            glfwImages.put(
                icon,
                GLFWImage.create()
                    .set(dimension, dimension, nativeBuffers[icon]));
        }
        GLFW.glfwSetWindowIcon(getWindow(), glfwImages);
        glfwImages.free();
        return 0;
    }

    public static void setResizable(boolean resizable) {
        displayResizable = resizable;
        // Ignore the request because why would you make the game window non-resizable
    }

    public static boolean isResizable() {
        return displayResizable;
    }

    public static void setDisplayModeAndFullscreen(DisplayMode mode) {
        // TODO
        System.out.println("TODO: Implement Display.setDisplayModeAndFullscreen(DisplayMode)");
    }

    private static int savedX[] = new int[1], savedY[] = new int[1];
    private static int savedW[] = new int[1], savedH[] = new int[1];

    public static void setFullscreen(boolean fullscreen) {
        final long window = getWindow();
        if (window == 0) {
            startFullscreen = fullscreen;
            return;
        }
        final boolean currentState = isFullscreen();
        if (currentState == fullscreen) {
            return;
        }
        if (fullscreen) {
            glfwGetWindowPos(window, savedX, savedY);
            glfwGetWindowSize(window, savedW, savedH);
            long monitorId = glfwGetPrimaryMonitor();
            final GLFWVidMode vidMode = glfwGetVideoMode(monitorId);
            glfwSetWindowMonitor(window, monitorId, 0, 0, vidMode.width(), vidMode.height(), vidMode.refreshRate());
        } else {
            glfwSetWindowMonitor(window, NULL, savedX[0], savedY[0], savedW[0], savedH[0], 0);
        }
    }

    public static boolean isFullscreen() {
        if (getWindow() != 0) {
            return glfwGetWindowMonitor(getWindow()) != NULL;
        }
        return false;
    }

    public static void setParent(java.awt.Canvas parent) {
        // Do nothing as set parent not supported
    }

    public static void releaseContext() {
        glfwMakeContextCurrent(0);
    }

    public static boolean isCurrent() {
        return true;
    }

    public static void makeCurrent() {
        glfwMakeContextCurrent(Window.handle);
    }

    public static java.lang.String getAdapter() {
        if (isCreated()) {
            return GL11.glGetString(GL11.GL_VENDOR);
        }
        return "Unknown";
    }

    public static java.lang.String getVersion() {
        if (isCreated()) {
            return GL11.glGetString(GL11.GL_VERSION);
        }
        return "Unknown";
    }

    public static String getTitle() {
        return windowTitle;
    }

    public static Canvas getParent() {
        return null;
    }

    public static float getPixelScaleFactor() {
        if (!isCreated()) {
            return 1.0f;
        }
        float[] xScale = new float[1];
        float[] yScale = new float[1];
        glfwGetWindowContentScale(getWindow(), xScale, yScale);
        return Math.max(xScale[0], yScale[0]);
    }

    public static void setSwapInterval(int value) {
        glfwSwapInterval(value);
    }

    public static void setDisplayConfiguration(float gamma, float brightness, float contrast) {
        // ignore
    }

    /**
     * An accurate sync method that will attempt to run at a constant frame rate. It should be called once every frame.
     *
     * @param fps - the desired frame rate, in frames per second
     */
    public static void sync(int fps) {
        Sync.sync(fps);
    }

    protected static DrawableGL drawable = null;

    public static Drawable getDrawable() {
        return drawable;
    }

    static DisplayImplementation getImplementation() {
        return null;
    }

    private static class Window {

        static long handle;

        static GLFWKeyCallback keyCallback;
        static GLFWCharCallback charCallback;
        static GLFWCursorPosCallback cursorPosCallback;
        static GLFWMouseButtonCallback mouseButtonCallback;
        static GLFWScrollCallback scrollCallback;
        static GLFWWindowFocusCallback windowFocusCallback;
        static GLFWWindowIconifyCallback windowIconifyCallback;
        static GLFWWindowSizeCallback windowSizeCallback;
        static GLFWWindowPosCallback windowPosCallback;
        static GLFWWindowRefreshCallback windowRefreshCallback;
        static GLFWFramebufferSizeCallback framebufferSizeCallback;

        public static void setCallbacks() {
            GLFW.glfwSetKeyCallback(handle, keyCallback);
            GLFW.glfwSetCharCallback(handle, charCallback);
            GLFW.glfwSetCursorPosCallback(handle, cursorPosCallback);
            GLFW.glfwSetMouseButtonCallback(handle, mouseButtonCallback);
            GLFW.glfwSetScrollCallback(handle, scrollCallback);
            GLFW.glfwSetWindowFocusCallback(handle, windowFocusCallback);
            GLFW.glfwSetWindowIconifyCallback(handle, windowIconifyCallback);
            GLFW.glfwSetWindowSizeCallback(handle, windowSizeCallback);
            GLFW.glfwSetWindowPosCallback(handle, windowPosCallback);
            GLFW.glfwSetWindowRefreshCallback(handle, windowRefreshCallback);
            GLFW.glfwSetFramebufferSizeCallback(handle, framebufferSizeCallback);
        }

        public static void releaseCallbacks() {
            keyCallback.free();
            charCallback.free();
            cursorPosCallback.free();
            mouseButtonCallback.free();
            scrollCallback.free();
            windowFocusCallback.free();
            windowIconifyCallback.free();
            windowSizeCallback.free();
            windowPosCallback.free();
            windowRefreshCallback.free();
            framebufferSizeCallback.free();
        }
    }
}
