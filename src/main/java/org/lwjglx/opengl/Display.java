package org.lwjglx.opengl;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_QUIT;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_EXPOSED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_FOCUS_GAINED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_FOCUS_LOST;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_HIDDEN;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_MINIMIZED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_MOVED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_RESIZED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_RESTORED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_SHOWN;
import static org.lwjgl.sdl.SDLVideo.*;
import static org.lwjgl.sdl.SDLPixels.*;
import static org.lwjgl.sdl.SDLProperties.*;
import static org.lwjgl.sdl.SDLHints.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.Canvas;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import net.minecraft.client.Minecraft;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.sdl.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.BufferUtils;
import org.lwjglx.Lwjgl3ifyEventLoop;
import org.lwjglx.Sys;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;
import org.lwjglx.util.Rectangle;

import com.github.bsideup.jabel.Desugar;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.core.Config;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class Display {

    private static String windowTitle = "Game";

    public static final ReentrantLock glContextMutex = new ReentrantLock();

    private static boolean displayCreated = false;
    private static boolean displayFocused = false;
    private static boolean displayVisible = true;
    private static boolean displayDirty = false;
    private static boolean displayResizable = false;
    private static boolean displayCloseRequested = false;
    private static boolean startFullscreen = false;
    private static boolean borderlessInsteadOfFullscreen = true;

    private static DisplayMode mode = new DisplayMode(854, 480);

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
    private static Int2ObjectOpenHashMap<String> sdlKeycodeNames = new Int2ObjectOpenHashMap<>();

    public static volatile long sdlWindow, sdlWindowProps, sdlMainGlContext;

    private static void sdlThrow() {
        throw new RuntimeException("SDL error: " + SDL_GetError());
    }

    private static void checkSdl(boolean result) {
        if (!result) {sdlThrow();}
    }

    private static <T> @NotNull T checkSdl(@Nullable T result) {
        if (result == null) {sdlThrow();}
        return result;
    }

    private static int checkSdl(int result) {
        if (result == NULL) {sdlThrow();}
        return result;
    }

    private static long checkSdl(long result) {
        if (result == NULL) {sdlThrow();}
        return result;
    }

    static {
        try {
            Class<SDLKeycode> glfwClass = SDLKeycode.class;
            for (Field f : glfwClass.getFields()) {
                if (f.getName()
                    .startsWith("SDLK") && f.getType() == int.class
                    && Modifier.isStatic(f.getModifiers())) {
                    int value = f.getInt(null);
                    sdlKeycodeNames.put(value, f.getName());
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
     * @throws org.lwjglx.LWJGLException
     */
    public static void create(PixelFormat pixelFormat, Drawable sharedDrawable) {
        create(pixelFormat, (ContextAttribs) null, sharedDrawable.getSdlWindowId());
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
        Sys.initialize();

        final int ctxMajor = (attribs != null) ? attribs.getMajorVersion() : 2;
        final int ctxMinor = (attribs != null) ? attribs.getMinorVersion() : 1;
        final boolean ctxForwardCompat = attribs != null && attribs.isForwardCompatible();
        final boolean ctxDebug = (attribs != null && attribs.isDebug()) || Config.OPENGL_DEBUG_CONTEXT || Config.DEBUG_REGISTER_OPENGL_LOGGER;
        final boolean ctxSrgb = pixelFormat != null ? pixelFormat.isSRGB() : Config.OPENGL_SRGB_CONTEXT;

        final int props = SDL_CreateProperties();
        try {
            long windowFlags = 0;

            if (Config.WINDOW_START_FOCUSED) {
                windowFlags |= SDL_WINDOW_INPUT_FOCUS | SDL_WINDOW_MOUSE_FOCUS;
            }

            if (Config.WINDOW_START_ICONIFIED) {
                windowFlags |= SDL_WINDOW_MINIMIZED;
            }

            if (!Config.WINDOW_DECORATED) {
                windowFlags |= SDL_WINDOW_BORDERLESS;
            }

            checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_X_NUMBER, Config.WINDOW_CENTERED ? SDL_WINDOWPOS_CENTERED : SDL_WINDOWPOS_UNDEFINED));
            checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_Y_NUMBER, Config.WINDOW_CENTERED ? SDL_WINDOWPOS_CENTERED : SDL_WINDOWPOS_UNDEFINED));
            checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_WIDTH_NUMBER, mode.getWidth()));
            checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_HEIGHT_NUMBER, mode.getHeight()));
            checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_FLAGS_NUMBER, windowFlags));
            checkSdl(SDL_SetStringProperty(props, SDL_PROP_WINDOW_CREATE_TITLE_STRING, windowTitle));
            checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_OPENGL_BOOLEAN, true));
            checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_HIDDEN_BOOLEAN, false));
            checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_RESIZABLE_BOOLEAN, true));
            checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_BORDERLESS_BOOLEAN, !Config.WINDOW_DECORATED));
            checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_MAXIMIZED_BOOLEAN, Config.WINDOW_START_MAXIMIZED));

            int ctxFlags = 0;
            if (ctxForwardCompat) {
                ctxFlags |= SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG;
            }
            if (ctxDebug) {
                ctxFlags |= SDL_GL_CONTEXT_DEBUG_FLAG;
            }
            SDL_GL_ResetAttributes();
            checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_FLAGS, ctxFlags));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, ctxMajor));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, ctxMinor));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG, ctxForwardCompat ? 1 : 0));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_FRAMEBUFFER_SRGB_CAPABLE, ctxSrgb ? 1 : 0));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_DOUBLEBUFFER, Config.OPENGL_DOUBLEBUFFER ? 1 : 0));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_NO_ERROR, Config.OPENGL_CONTEXT_NO_ERROR ? 1 : 0));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_DEPTH_SIZE, 24));
            checkSdl(SDL_GL_SetAttribute(SDL_GL_STENCIL_SIZE, 8));
            if (attribs != null) {
                if (attribs.isProfileCore()) {
                    checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_CORE));
                } else if (attribs.isProfileCompatibility()) {
                    checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY));
                }
            }
            // TODO: shared context
            sdlWindow = SDL_CreateWindowWithProperties(props);
            if (sdlWindow == NULL) {
                throw new RuntimeException("Could not create the Display window: " + SDL_GetError());
            }

            sdlMainGlContext = SDL_GL_CreateContext(sdlWindow);
            if (sdlMainGlContext == NULL) {
                throw new RuntimeException("Could not create an OpenGL context: " + SDL_GetError());
            }
            checkSdl(nSDL_GL_LoadLibrary(NULL));
            GL.create(SDLVideo::SDL_GL_GetProcAddress);
            GL.createCapabilities();
            drawable = new DrawableGL();
        } finally {
            SDL_DestroyProperties(props);
        }

        final long actualWindowFlags = SDL_GetWindowFlags(sdlWindow);
        displayFocused = (actualWindowFlags & SDL_WINDOW_INPUT_FOCUS) != 0;
        displayVisible = (actualWindowFlags & SDL_WINDOW_MINIMIZED) == 0;

        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.ints(0);
            IntBuffer h = stack.ints(0);
            SDL_GetWindowSize(sdlWindow, w, h);
            displayWidth = w.get(0);
            displayHeight = h.get(0);
            SDL_GetWindowSizeInPixels(sdlWindow, w, h);
            displayFramebufferWidth = w.get(0);
            latestWidth = displayFramebufferWidth;
            displayFramebufferHeight = h.get(0);
            latestHeight = displayFramebufferHeight;
        }

        if (savedIcons != null) {
            setIcon(savedIcons);
            savedIcons = null;
        }

        SDL_GL_SetSwapInterval(1);

        displayCreated = true;

        lwjgl3ify$updateRawMouseMode(Config.INPUT_RAW_MOUSE);

        if (startFullscreen) {
            // TODO setFullscreen(true);
        }
    }

    private static final ByteBuffer HINT_MOUSE_RELATIVE_SYSTEM_SCALE = memASCII(SDL_HINT_MOUSE_RELATIVE_SYSTEM_SCALE);
    private static final ByteBuffer STR_0 = memASCII("0");
    private static final ByteBuffer STR_1 = memASCII("1");

    public static void lwjgl3ify$updateRawMouseMode(boolean mode) {
        MainThreadExec.runOnMainThread(() -> {
            SDL_SetHintWithPriority(HINT_MOUSE_RELATIVE_SYSTEM_SCALE, mode ? STR_0 : STR_1, SDL_HINT_OVERRIDE);
            Lwjgl3ifyCoremod.LOGGER.info("Updated raw mouse input mode to " + mode);
        });
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
        checkSdl(SDL_SetWindowPosition(sdlWindow, new_x, new_y));
    }

    public static void setVSyncEnabled(boolean sync) {
        checkSdl(SDL_GL_SetSwapInterval(sync ? 1 : 0));
    }

    public static long getWindow() {
        return sdlWindow;
    }

    public static long getGlContext() {
        return sdlMainGlContext;
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
        Lwjgl3ifyEventLoop.pumpEvents();
        Keyboard.poll();
        Mouse.poll();

        if (latestResized) {
            latestResized = false;
            displayResized = true;
        } else {
            displayResized = false;
        }
    }

    public static void swapBuffers() {
        checkSdl(SDL_GL_SwapWindow(sdlWindow));
    }

    public static void destroy() {
        try {
            GL.setCapabilities(null);
        } catch (Throwable t) {/* no-op */}
        try {
            GL.destroy();
        } catch (Throwable t) {/* no-op */}
        MainThreadExec.runOnMainThread(() -> {
                if (sdlMainGlContext != NULL) {
                    SDL_GL_DestroyContext(sdlMainGlContext);
                    sdlMainGlContext = NULL;
                }
                if (sdlWindow != NULL) {
                    SDL_DestroyWindow(sdlWindow);
                    sdlWindow = NULL;
                }
            });

        displayCreated = false;
    }

    public static void setDisplayMode(DisplayMode dm) {
        mode = dm;
    }

    public static DisplayMode getDisplayMode() {
        return mode;
    }

    public static DisplayMode[] getAvailableDisplayModes() {
        return MainThreadExec.runOnMainThread(() -> {
            int monitor = checkSdl(SDL_GetPrimaryDisplay());
            final PointerBuffer modes = checkSdl(SDL_GetFullscreenDisplayModes(monitor));
            DisplayMode[] displayModes = new DisplayMode[modes.remaining()];
            for (int i = 0; i < displayModes.length; i++) {
                final SDL_DisplayMode reader = new SDL_DisplayMode(modes.getByteBuffer(i, SDL_DisplayMode.SIZEOF));
                final int bpp = checkSdl(SDL_GetPixelFormatDetails(reader.format())).bits_per_pixel();
                displayModes[i] = new DisplayMode(reader.w(), reader.h(), bpp, Math.round(reader.refresh_rate()));
            }
            modes.free();
            return displayModes;
        });
    }

    public static DisplayMode getDesktopDisplayMode() {
        return MainThreadExec.runOnMainThread(() -> {
            int monitor = checkSdl(SDL_GetPrimaryDisplay());
            if (monitor == 0) {sdlThrow();}
            final SDL_DisplayMode mode = checkSdl(SDL_GetDesktopDisplayMode(monitor));
            return new DisplayMode(mode.w(), mode.h(), checkSdl(SDL_GetPixelFormatDetails(mode.format())).bits_per_pixel(), Math.round(mode.refresh_rate()));
        });
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

    // vanilla and forge both expect these to return the framebuffer width
    // rather than the window width, and they both call glViewport with the
    // result
    public static int getWidth() {
        return displayFramebufferWidth;
    }

    public static int getHeight() {
        return displayFramebufferHeight;
    }

    public static void setTitle(String title) {
        windowTitle = title;
        if (isCreated()) {
            MainThreadExec.runOnMainThread(() -> {
                checkSdl(SDL_SetWindowTitle(sdlWindow, title));
            });
        }
    }

    public static boolean isCloseRequested() {
        final boolean saved = displayCloseRequested;
        displayCloseRequested = false;
        return saved;
    }

    public static boolean isDirty() {
        return displayDirty;
    }

    public static void setInitialBackground(float red, float green, float blue) {
        // no-op
    }

    public static int setIcon(java.nio.ByteBuffer[] icons) {
        if (sdlWindow == NULL) {
            savedIcons = icons;
            return 0;
        }
        /*
        GLFWImage.Buffer glfwImages = GLFWImage.calloc(icons.length);
        try (MemoryStack stack = stackPush()) {
            ByteBuffer[] nativeBuffers = new ByteBuffer[icons.length];
            for (int icon = 0; icon < icons.length; icon++) {
                nativeBuffers[icon] = stack.malloc(icons[icon].capacity());
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
        }
        glfwImages.free();
         TODO:
         */
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

    /*
    private static int savedX[] = new int[1], savedY[] = new int[1];
    private static int savedW[] = new int[1], savedH[] = new int[1];

    public static PositionedGLFWVidMode getTargetFullscreenMonitor() {
        int x = savedX[0] + (savedW[0] / 2);
        int y = savedY[0] + (savedH[0] / 2);

        PointerBuffer monitors = glfwGetMonitors();
        assert monitors != null;
        ArrayList<PositionedGLFWVidMode> monitorInfos = new ArrayList<>(monitors.limit());
        for (int i = 0; i < monitors.limit(); i++) {
            long monitor = monitors.get(i);

            PositionedGLFWVidMode monitorInfo = getPositionedMonitorInfo(monitor);
            monitorInfos.add(monitorInfo);

            if (monitorInfo.bounds.contains(x, y)) {
                return monitorInfo;
            }
        }

        // If the center of the screen doesn't contains in any monitors, try to look by intersect area
        Rectangle windowBounds = new Rectangle(savedX[0], savedY[0], savedW[0], savedH[0]);
        Optional<PositionedGLFWVidMode> targetMonitor = monitorInfos.stream()
            .filter(
                o -> !o.bounds.intersection(windowBounds, null)
                    .isEmpty())
            .max(
                Comparator.comparingInt(
                    o -> o.bounds.intersection(windowBounds, null)
                        .getArea()));

        return targetMonitor.orElse(getPositionedMonitorInfo(glfwGetPrimaryMonitor()));
    }

    private static PositionedGLFWVidMode getPositionedMonitorInfo(long monitorId) {
        int x, y;
        try (MemoryStack stack = stackPush()) {
            IntBuffer posX = stack.mallocInt(1);
            IntBuffer posY = stack.mallocInt(1);

            glfwGetMonitorPos(monitorId, posX, posY);
            x = posX.get(0);
            y = posY.get(0);
        }

        GLFWVidMode vidmode = glfwGetVideoMode(monitorId);
        assert vidmode != null;
        return new PositionedGLFWVidMode(
            x,
            y,
            new Rectangle(x, y, vidmode.width(), vidmode.height()),
            monitorId,
            vidmode);
    }

    @Desugar
    public record PositionedGLFWVidMode(int x, int y, Rectangle bounds, long monitorId, GLFWVidMode vidMode) {}

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

        glfwSetWindowSizeLimits(window, 0, 0, GLFW_DONT_CARE, GLFW_DONT_CARE);
        if (fullscreen) {
            glfwGetWindowPos(window, savedX, savedY);
            glfwGetWindowSize(window, savedW, savedH);
            PositionedGLFWVidMode monitorInfo = getTargetFullscreenMonitor();
            GLFWVidMode vidMode = monitorInfo.vidMode;
            glfwSetWindowMonitor(
                window,
                monitorInfo.monitorId,
                0,
                0,
                vidMode.width(),
                vidMode.height(),
                vidMode.refreshRate());
            Minecraft.getMinecraft()
                .resize(vidMode.width(), vidMode.height());
        } else {
            glfwSetWindowSize(window, savedW[0], savedH[0]);
            glfwSetWindowMonitor(window, NULL, savedX[0], savedY[0], savedW[0], savedH[0], 0);
        }
    }

    public static void toggleBorderless() {
        setBorderless(!isBorderless());
    }

    public static void setBorderless(boolean toBorderless) {
        final long window = getWindow();
        if (window == NULL) {
            return;
        }
        if (toBorderless) {
            glfwGetWindowPos(window, savedX, savedY);
            glfwGetWindowSize(window, savedW, savedH);
            PositionedGLFWVidMode monitorInfo = getTargetFullscreenMonitor();
            GLFWVidMode vidMode = monitorInfo.vidMode;

            int height = vidMode.height();

            // Fix bothered from
            // https://github.com/Kir-Antipov/cubes-without-borders/blob/b38306bf17d3f0936475a3a28c4ee2be4e881a62/src/main/java/dev/kir/cubeswithoutborders/mixin/WindowMixin.java#L130
            // There's a bug that causes a fullscreen window to flicker when it loses focus.
            // As far as I know, this is relevant for Windows and X11 desktops.
            // Fuck X11 - it's a perpetually broken piece of legacy.
            // However, we do need to implement a fix for Windows desktops, as they
            // are not going anywhere in the foreseeable future (sadly enough).
            // This "fix" involves not bringing a window into a "proper" fullscreen mode,
            // but rather stretching it 1 pixel beyond the screen's supported resolution.
            if (Config.WINDOW_BORDERLESS_WINDOWS_COMPATIBILITY && System.getProperty("os.name")
                .toLowerCase()
                .contains("win")) {
                height = height + 1;
            }

            glfwSetWindowSizeLimits(window, 0, 0, vidMode.width(), height);
            glfwSetWindowSize(window, vidMode.width(), height);
            glfwSetWindowMonitor(
                window,
                NULL,
                monitorInfo.x,
                monitorInfo.y,
                vidMode.width(),
                height,
                vidMode.refreshRate());
        } else {
            glfwSetWindowSizeLimits(window, 0, 0, GLFW_DONT_CARE, GLFW_DONT_CARE);
            glfwSetWindowSize(window, savedW[0], savedH[0]);
            glfwSetWindowMonitor(window, NULL, savedX[0], savedY[0], savedW[0], savedH[0], 0);
        }
    }

    public static boolean isBorderless() {
        long window = Display.getWindow();
        long windowMonitor = glfwGetWindowMonitor(Display.getWindow());
        if (Display.getWindow() != 0 && windowMonitor == NULL) {
            try (MemoryStack stack = stackPush()) {
                IntBuffer windowX = stack.mallocInt(1);
                IntBuffer windowY = stack.mallocInt(1);
                IntBuffer windowWidth = stack.mallocInt(1);
                IntBuffer windowHeight = stack.mallocInt(1);

                glfwGetWindowPos(window, windowX, windowY);
                glfwGetWindowSize(window, windowWidth, windowHeight);

                Display.PositionedGLFWVidMode monitorInfo = Display.getTargetFullscreenMonitor();
                GLFWVidMode vidMode = monitorInfo.vidMode();

                return windowX.get(0) == monitorInfo.x() && windowY.get(0) == monitorInfo.y()
                    && windowWidth.get(0) == vidMode.width()
                    && (windowHeight.get(0) >= vidMode.height());
            }
        }
        return false;
    }
     */

    public static boolean isFullscreen() {
        if (sdlWindow != NULL) {
            return MainThreadExec.runOnMainThread(() -> {
                return SDL_GetWindowFullscreenMode(sdlWindow) != null;
            });
        }
        return false;
    }

    public static void setParent(java.awt.Canvas parent) {
        // Do nothing as set parent not supported
    }

    public static void releaseContext() {
        glContextMutex.lock();
        try {
            SDL_GL_MakeCurrent(sdlWindow, NULL);
        } finally {
            glContextMutex.unlock();
        }
    }

    public static boolean isCurrent() {
        return SDL_GL_GetCurrentContext() == sdlMainGlContext;
    }

    public static void makeCurrent() {
        glContextMutex.lock();
        try {
            SDL_GL_MakeCurrent(sdlWindow, sdlMainGlContext);
        } finally {
            glContextMutex.unlock();
        }
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
        return (float) MainThreadExec.runOnMainThread(() -> SDL_GetWindowPixelDensity(sdlWindow));
    }

    public static void setSwapInterval(int value) {
        MainThreadExec.runOnMainThread(() -> {
            SDL_GL_SetSwapInterval(value);
        });
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

    /**
     * @return true if the event was handled here.
     */
    public static boolean lwjgl3ify$handleSdlEvent() {
        return switch(Lwjgl3ifyEventLoop.event.type()) {
            case SDL_EVENT_QUIT -> {
                displayCloseRequested = true;
                yield true;
            }
            case SDL_EVENT_WINDOW_EXPOSED -> {
                displayDirty = true;
                yield true;
            }
            case SDL_EVENT_WINDOW_FOCUS_GAINED -> {
                displayFocused = true;
                yield true;
            }
            case SDL_EVENT_WINDOW_FOCUS_LOST -> {
                displayFocused = false;
                yield true;
            }
            case SDL_EVENT_WINDOW_MINIMIZED -> {
                displayVisible = false;
                yield true;
            }
            case SDL_EVENT_WINDOW_RESTORED -> {
                displayVisible = true;
                yield true;
            }
            case SDL_EVENT_WINDOW_RESIZED -> {
                displayWidth = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayHeight = Lwjgl3ifyEventLoop.windowEvent.data2();
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] window-resize window:{} w:{} h:{}", Lwjgl3ifyEventLoop.windowEvent.windowID(), displayWidth, displayHeight);
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED -> {
                displayFramebufferWidth = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayFramebufferHeight = Lwjgl3ifyEventLoop.windowEvent.data2();
                if (Config.DEBUG_PRINT_MOUSE_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-MOUSE] framebuffer-resize window:{} w:{} h:{}", Lwjgl3ifyEventLoop.windowEvent.windowID(), displayFramebufferWidth, displayFramebufferHeight);
                }
                latestResized = true;
                latestWidth = displayFramebufferWidth;
                latestHeight = displayFramebufferHeight;
                yield true;
            }
            case SDL_EVENT_WINDOW_MOVED -> {
                displayX = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayY = Lwjgl3ifyEventLoop.windowEvent.data2();
                yield true;
            }
            default -> false;
        };
    }
}
