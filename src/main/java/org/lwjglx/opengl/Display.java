package org.lwjglx.opengl;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;
import org.lwjgl.glfw.*;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjglx.BufferUtils;
import org.lwjglx.Sys;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;

public class Display {

    private static String windowTitle = "Game";

    private static boolean displayCreated = false;
    private static boolean displayFocused = false;
    private static boolean displayVisible = true;
    private static boolean displayDirty = false;
    private static boolean displayResizable = false;

    private static DisplayMode mode = new DisplayMode(640, 480);
    private static DisplayMode desktopDisplayMode = new DisplayMode(640, 480);

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

    static {
        Sys.initialize(); // init using dummy sys method

        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);

        int monitorWidth = vidmode.width();
        int monitorHeight = vidmode.height();
        int monitorBitPerPixel = vidmode.redBits() + vidmode.greenBits() + vidmode.blueBits();
        int monitorRefreshRate = vidmode.refreshRate();

        desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);
    }

    public static void create(PixelFormat pixel_format, Drawable shared_drawable) {
        System.out.println("TODO: Implement Display.create(PixelFormat, Drawable)"); // TODO
        create();
    }

    public static void create(PixelFormat pixel_format, ContextAttribs attribs) {
        System.out.println("TODO: Implement Display.create(PixelFormat, ContextAttribs)"); // TODO
        create();
    }

    public static void create(PixelFormat pixel_format) {
        System.out.println("TODO: Implement Display.create(PixelFormat)"); // TODO
        create();
    }

    public static void create() {
        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidmode = glfwGetVideoMode(monitor);

        int monitorWidth = vidmode.width();
        int monitorHeight = vidmode.height();
        int monitorBitPerPixel = vidmode.redBits() + vidmode.greenBits() + vidmode.blueBits();
        int monitorRefreshRate = vidmode.refreshRate();

        desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, displayResizable ? GL_TRUE : GL_FALSE);
        glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GL_TRUE);

        Window.handle = glfwCreateWindow(mode.getWidth(), mode.getHeight(), windowTitle, NULL, NULL);
        if (Window.handle == 0L) throw new IllegalStateException("Failed to create Display window");

        Window.keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                latestEventKey = key;

                if (action == GLFW_RELEASE || action == GLFW.GLFW_PRESS) {
                    Keyboard.addKeyEvent(key, action == GLFW.GLFW_PRESS ? true : false);
                }
            }
        };

        Window.charCallback = new GLFWCharCallback() {
            @Override
            public void invoke(long window, int codepoint) {
                Keyboard.addCharEvent(latestEventKey, (char) codepoint);
            }
        };

        Window.cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                Mouse.addMoveEvent(xpos, ypos);
            }
        };

        Window.mouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                Mouse.addButtonEvent(button, action == GLFW.GLFW_PRESS ? true : false);
            }
        };

        Window.windowFocusCallback = new GLFWWindowFocusCallback() {
            @Override
            public void close() {
                super.close();
            }

            @Override
            public FFICIF getCallInterface() {
                return super.getCallInterface();
            }

            @Override
            public void callback(long ret, long args) {
                super.callback(ret, args);
            }

            @Override
            public void invoke(long l, boolean b) {
                displayFocused = b == true;
            }
        };

        Window.windowIconifyCallback = new GLFWWindowIconifyCallback() {
            @Override
            public void close() {
                super.close();
            }

            @Override
            public FFICIF getCallInterface() {
                return super.getCallInterface();
            }

            @Override
            public void callback(long ret, long args) {
                super.callback(ret, args);
            }

            @Override
            public void invoke(long l, boolean b) {
                displayVisible = b == false;
            }
        };

        Window.windowSizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
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

        glfwSetWindowPos(Window.handle, (monitorWidth - mode.getWidth()) / 2, (monitorHeight - mode.getHeight()) / 2);

        displayX = (monitorWidth - mode.getWidth()) / 2;
        displayY = (monitorHeight - mode.getHeight()) / 2;

        glfwMakeContextCurrent(Window.handle);
        GL.createCapabilities();

        glfwSwapInterval(1);
        glfwShowWindow(Window.handle);

        displayCreated = true;
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

        /*try {
        	glfwTerminate();
        } catch (Throwable t) {
        	t.printStackTrace();
        }*/
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
    }

    public static boolean isCloseRequested() {
        return glfwWindowShouldClose(Window.handle) == true;
    }

    public static boolean isDirty() {
        return displayDirty;
    }

    public static void setInitialBackground(float red, float green, float blue) {
        // TODO
        System.out.println("TODO: Implement Display.setInitialBackground(float, float, float)");
    }

    public static int setIcon(java.nio.ByteBuffer[] icons) {
        // TODO
        System.out.println("TODO: Implement Display.setIcon(ByteBuffer[])");
        return 0;
    }

    public static void setResizable(boolean resizable) {
        displayResizable = resizable;
        // TODO
    }

    public static boolean isResizable() {
        return displayResizable;
    }

    public static void setDisplayModeAndFullscreen(DisplayMode mode) {
        // TODO
        System.out.println("TODO: Implement Display.setDisplayModeAndFullscreen(DisplayMode)");
    }

    public static void setFullscreen(boolean fullscreen) {
        // TODO
    }

    public static boolean isFullscreen() {
        // TODO
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
        // TODO
        return "GeNotSupportedAdapter";
    }

    public static java.lang.String getVersion() {
        // TODO
        return "1.0 NOT SUPPORTED";
    }

    /**
     * An accurate sync method that will attempt to run at a constant frame rate.
     * It should be called once every frame.
     *
     * @param fps - the desired frame rate, in frames per second
     */
    public static void sync(int fps) {
        Sync.sync(fps);
    }

    public static Drawable getDrawable() {
        return null;
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
            windowFocusCallback.free();
            windowIconifyCallback.free();
            windowSizeCallback.free();
            windowPosCallback.free();
            windowRefreshCallback.free();
            framebufferSizeCallback.free();
        }
    }
}
