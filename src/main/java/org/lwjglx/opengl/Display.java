package org.lwjglx.opengl;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_QUIT;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_EXPOSED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_FOCUS_GAINED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_FOCUS_LOST;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_MINIMIZED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_MOVED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_RESIZED;
import static org.lwjgl.sdl.SDLEvents.SDL_EVENT_WINDOW_RESTORED;
import static org.lwjgl.sdl.SDLHints.*;
import static org.lwjgl.sdl.SDLPixels.*;
import static org.lwjgl.sdl.SDLProperties.*;
import static org.lwjgl.sdl.SDLSurface.*;
import static org.lwjgl.sdl.SDLVideo.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.sdl.SDLKeyboard;
import org.lwjgl.sdl.SDLVideo;
import org.lwjgl.sdl.SDL_DisplayMode;
import org.lwjgl.sdl.SDL_Surface;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.Lwjgl3ifyEventLoop;
import org.lwjglx.Sys;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;
import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;
import me.eigenraven.lwjgl3ify.core.Lwjgl3ifyCoremod;

public class Display {

    enum WindowedState {

        WINDOWED(false),
        BORDERLESS(true),
        FULLSCREEN(true);

        public final boolean isFullscreen;

        WindowedState(boolean isFullscreen) {
            this.isFullscreen = isFullscreen;
        }

        public static WindowedState fullscreen() {
            return Config.WINDOW_BORDERLESS_REPLACES_FULLSCREEN ? BORDERLESS : FULLSCREEN;
        }
    }

    private static String windowTitle = "Game";

    public static final ReentrantLock glContextMutex = new ReentrantLock();

    private static boolean displayCreated = false;
    private static boolean displayFocused = false;
    private static boolean displayVisible = true;
    private static boolean displayDirty = false;
    private static boolean displayResizable = false;
    private static boolean displayCloseRequested = false;
    private static WindowedState displayWindowed = WindowedState.WINDOWED;

    private static DisplayMode mode = new DisplayMode(854, 480);

    private static int latestEventKey = 0;

    private static int displayX = 0;
    private static int displayY = 0;

    private static boolean displayResized = false;
    private static int displayWidth = 1;
    private static int displayHeight = 1;
    private static int displayFramebufferWidth = 1;
    private static int displayFramebufferHeight = 1;

    private static boolean latestResized = false;
    private static int latestWidth = 0;
    private static int latestHeight = 0;
    private static boolean cancelNextChar = false;
    private static Keyboard.KeyEvent ingredientKeyEvent;
    private static ByteBuffer[] savedIcons;
    private static boolean lastAltIsRightAlt = false;

    public static volatile long sdlWindow, sdlHiddenWindow, sdlMainGlContext, sdlCloneableGlContext;
    public static int sdlWindowId;

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

        MainThreadExec.runOnMainThread(() -> {
            final int ctxMajor = (attribs != null) ? attribs.getMajorVersion() : 2;
            final int ctxMinor = (attribs != null) ? attribs.getMinorVersion() : 1;
            final boolean ctxForwardCompat = attribs != null && attribs.isForwardCompatible();
            final boolean ctxDebug = (attribs != null && attribs.isDebug()) || Config.OPENGL_DEBUG_CONTEXT
                || Config.DEBUG_REGISTER_OPENGL_LOGGER;
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

                Sys.checkSdl(
                    SDL_SetNumberProperty(
                        props,
                        SDL_PROP_WINDOW_CREATE_X_NUMBER,
                        Config.WINDOW_CENTERED ? SDL_WINDOWPOS_CENTERED : SDL_WINDOWPOS_UNDEFINED));
                Sys.checkSdl(
                    SDL_SetNumberProperty(
                        props,
                        SDL_PROP_WINDOW_CREATE_Y_NUMBER,
                        Config.WINDOW_CENTERED ? SDL_WINDOWPOS_CENTERED : SDL_WINDOWPOS_UNDEFINED));
                Sys.checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_WIDTH_NUMBER, mode.getWidth()));
                Sys.checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_HEIGHT_NUMBER, mode.getHeight()));
                Sys.checkSdl(SDL_SetNumberProperty(props, SDL_PROP_WINDOW_CREATE_FLAGS_NUMBER, windowFlags));
                Sys.checkSdl(SDL_SetStringProperty(props, SDL_PROP_WINDOW_CREATE_TITLE_STRING, windowTitle));
                Sys.checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_OPENGL_BOOLEAN, true));
                Sys.checkSdl(
                    SDL_SetBooleanProperty(
                        props,
                        SDL_PROP_WINDOW_CREATE_HIGH_PIXEL_DENSITY_BOOLEAN,
                        Config.WINDOW_HIDPI_RENDERING));
                Sys.checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_HIDDEN_BOOLEAN, false));
                Sys.checkSdl(SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_RESIZABLE_BOOLEAN, true));
                Sys.checkSdl(
                    SDL_SetBooleanProperty(props, SDL_PROP_WINDOW_CREATE_BORDERLESS_BOOLEAN, !Config.WINDOW_DECORATED));
                Sys.checkSdl(
                    SDL_SetBooleanProperty(
                        props,
                        SDL_PROP_WINDOW_CREATE_MAXIMIZED_BOOLEAN,
                        Config.WINDOW_START_MAXIMIZED));

                int ctxFlags = 0;
                if (ctxForwardCompat) {
                    ctxFlags |= SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG;
                }
                if (ctxDebug) {
                    ctxFlags |= SDL_GL_CONTEXT_DEBUG_FLAG;
                }
                SDL_GL_ResetAttributes();
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_FLAGS, ctxFlags));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, ctxMajor));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, ctxMinor));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG, ctxForwardCompat ? 1 : 0));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_FRAMEBUFFER_SRGB_CAPABLE, ctxSrgb ? 1 : 0));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_DOUBLEBUFFER, Config.OPENGL_DOUBLEBUFFER ? 1 : 0));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_NO_ERROR, Config.OPENGL_CONTEXT_NO_ERROR ? 1 : 0));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_DEPTH_SIZE, 24));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_STENCIL_SIZE, 8));
                Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_SHARE_WITH_CURRENT_CONTEXT, 1));
                if (attribs != null) {
                    if (attribs.isProfileCore()) {
                        Sys.checkSdl(SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_CORE));
                    } else if (attribs.isProfileCompatibility()) {
                        Sys.checkSdl(
                            SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY));
                    }
                }

                sdlWindow = SDL_CreateWindowWithProperties(props);
                if (sdlWindow == NULL) {
                    throw new RuntimeException("Could not create the Display window: " + SDL_GetError());
                }
                sdlWindowId = SDL_GetWindowID(sdlWindow);

                Sys.checkSdl(SDL_GL_MakeCurrent(sdlWindow, NULL));
                sdlMainGlContext = SDL_GL_CreateContext(sdlWindow);
                if (sdlMainGlContext == NULL) {
                    throw new RuntimeException("Could not create an OpenGL context: " + SDL_GetError());
                }

                sdlHiddenWindow = SDL_CreateWindow(
                    "lwjgl3ify-cloneableGlContext",
                    1,
                    1,
                    SDL_WINDOW_OPENGL | SDL_WINDOW_HIDDEN);
                if (sdlHiddenWindow == NULL) {
                    throw new RuntimeException(
                        "Could not create the hidden Display window for sharing GL contexts: " + SDL_GetError());
                }

                sdlCloneableGlContext = SDL_GL_CreateContext(sdlHiddenWindow);
                if (sdlCloneableGlContext == NULL) {
                    throw new RuntimeException("Could not create a secondary OpenGL context: " + SDL_GetError());
                }

                Sys.checkSdl(SDL_GL_MakeCurrent(sdlWindow, sdlMainGlContext));
                Sys.checkSdl(nSDL_GL_LoadLibrary(NULL));
                Sys.checkSdl(SDL_GL_MakeCurrent(sdlWindow, NULL));

                if (Config.WINDOW_LOADING_PROGRESS) {
                    SDL_SetWindowProgressState(sdlWindow, SDL_PROGRESS_STATE_INDETERMINATE);
                }
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

            Keyboard.sdlKeyPressedArray = SDLKeyboard.SDL_GetKeyboardState();

            Mouse.create();
            Keyboard.create();

            if (displayWindowed.isFullscreen) {
                setFullscreen(true);
            }
        });

        Sys.checkSdl(SDL_GL_MakeCurrent(sdlWindow, sdlMainGlContext));
        GL.create(SDLVideo::SDL_GL_GetProcAddress);
        drawable = new DrawableGL();
        drawable.makeCurrent();
        if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
            Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-created");
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
        Sys.checkSdl(SDL_SetWindowPosition(sdlWindow, new_x, new_y));
    }

    public static void setVSyncEnabled(boolean sync) {
        Sys.checkSdl(SDL_GL_SetSwapInterval(sync ? 1 : 0));
    }

    /** @return The SDL window pointer */
    public static long getWindow() {
        return sdlWindow;
    }

    /** @return The SDL GL context pointer */
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

        if (latestResized) {
            latestResized = false;
            displayResized = true;
        } else {
            displayResized = false;
        }
    }

    public static void processMessages() {
        Lwjgl3ifyEventLoop.pumpEvents();
        Keyboard.poll();
        Mouse.poll();
    }

    public static void swapBuffers() {
        Sys.checkSdl(SDL_GL_SwapWindow(sdlWindow));
    }

    public static void destroy() {
        if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
            Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-destroy");
        }
        try {
            GL.setCapabilities(null);
        } catch (Throwable t) {/* no-op */}
        try {
            GL.destroy();
        } catch (Throwable t) {/* no-op */}
        MainThreadExec.runOnMainThread(() -> {
            if (sdlCloneableGlContext != NULL) {
                SDL_GL_DestroyContext(sdlCloneableGlContext);
                sdlCloneableGlContext = NULL;
            }
            if (sdlHiddenWindow != NULL) {
                SDL_DestroyWindow(sdlHiddenWindow);
                sdlHiddenWindow = NULL;
            }
            if (sdlMainGlContext != NULL) {
                SDL_GL_DestroyContext(sdlMainGlContext);
                sdlMainGlContext = NULL;
            }
            if (sdlWindow != NULL) {
                SDL_DestroyWindow(sdlWindow);
                sdlWindow = NULL;
                sdlWindowId = 0;
            }
        });

        displayCreated = false;
    }

    /**
     * Set the current display mode. If no OpenGL context has been created, the given mode will apply to
     * the context when create() is called, and no immediate mode switching will happen. If there is a
     * context already, it will be resized according to the given mode. If the context is also a
     * fullscreen context, the mode will also be switched immediately. The native cursor position
     * is also reset.
     *
     * @param dm The new display mode to set
     */
    public static synchronized void setDisplayMode(DisplayMode dm) {
        mode = dm;
        if (isCreated()) {
            if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-set desktop mode: {}", dm);
            }
            MainThreadExec.runOnMainThread(() -> { SDL_SetWindowSize(sdlWindow, dm.getWidth(), dm.getHeight()); });
        }
    }

    /**
     * Return the current display mode, as set by setDisplayMode().
     *
     * @return The current display mode
     */
    public static DisplayMode getDisplayMode() {
        return mode;
    }

    public static DisplayMode[] getAvailableDisplayModes() {
        return MainThreadExec.runOnMainThread(() -> {
            int monitor = Sys.checkSdl(SDL_GetPrimaryDisplay());
            final PointerBuffer modes = Sys.checkSdl(SDL_GetFullscreenDisplayModes(monitor));
            DisplayMode[] displayModes = new DisplayMode[modes.remaining()];
            for (int i = 0; i < displayModes.length; i++) {
                final SDL_DisplayMode reader = new SDL_DisplayMode(modes.getByteBuffer(i, SDL_DisplayMode.SIZEOF));
                final int bpp = Sys.checkSdl(SDL_GetPixelFormatDetails(reader.format()))
                    .bits_per_pixel();
                displayModes[i] = new DisplayMode(reader.w(), reader.h(), bpp, Math.round(reader.refresh_rate()));
            }
            modes.free();
            return displayModes;
        });
    }

    public static DisplayMode getDesktopDisplayMode() {
        return MainThreadExec.runOnMainThread(() -> {
            int monitor = Sys.checkSdl(SDL_GetPrimaryDisplay());
            final SDL_DisplayMode mode = Sys.checkSdl(SDL_GetDesktopDisplayMode(monitor));
            final DisplayMode lwjglMode = new DisplayMode(
                mode.w(),
                mode.h(),
                Sys.checkSdl(SDL_GetPixelFormatDetails(mode.format()))
                    .bits_per_pixel(),
                Math.round(mode.refresh_rate()));
            if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-get desktop mode: {}", lwjglMode);
            }
            return lwjglMode;
        });
    }

    public static synchronized boolean wasResized() {
        return displayResized;
    }

    public static synchronized int getX() {
        return displayX;
    }

    public static synchronized int getY() {
        return displayY;
    }

    // vanilla and forge both expect these to return the framebuffer width
    // rather than the window width, and they both call glViewport with the
    // result
    public static synchronized int getWidth() {
        return displayFramebufferWidth;
    }

    public static synchronized int getHeight() {
        return displayFramebufferHeight;
    }

    public static synchronized void setTitle(String title) {
        windowTitle = title;
        if (isCreated()) {
            MainThreadExec.runOnMainThread(() -> { Sys.checkSdl(SDL_SetWindowTitle(sdlWindow, title)); });
        }
    }

    public static synchronized boolean isCloseRequested() {
        final boolean saved = displayCloseRequested;
        displayCloseRequested = false;
        return saved;
    }

    public static synchronized boolean isDirty() {
        return displayDirty;
    }

    public static void setInitialBackground(float red, float green, float blue) {
        // no-op
    }

    /**
     * Sets one or more icons for the Display.
     * <ul>
     * <li>On Windows you should supply at least one 16x16 icon and one 32x32.</li>
     * <li>Linux (and similar platforms) expect one 32x32 icon.</li>
     * <li>Mac OS X should be supplied one 128x128 icon</li>
     * </ul>
     * The implementation will use the supplied ByteBuffers with image data in RGBA (size must be a power of two) and
     * perform any conversions nescesarry for the specific platform.
     * <p/>
     * <b>NOTE:</b> The display will make a deep copy of the supplied byte buffer array, for the purpose
     * of recreating the icons when you go back and forth fullscreen mode. You therefore only need to
     * set the icon once per instance.
     *
     * @param icons Array of icons in RGBA mode. Pass the icons in order of preference.
     *
     * @return number of icons used, or 0 if display hasn't been created
     */
    public static int setIcon(java.nio.ByteBuffer[] icons) {
        if (icons == null || icons.length == 0) {
            return 0;
        }
        if (sdlWindow == NULL) {
            savedIcons = new ByteBuffer[icons.length];
            for (int i = 0; i < icons.length; i++) {
                final ByteBuffer icon = icons[i];
                savedIcons[i] = ByteBuffer.allocate(icon.remaining())
                    .order(ByteOrder.nativeOrder());
                final int oldPos = icon.position();
                savedIcons[i].put(icon);
                icon.position(oldPos);
                savedIcons[i].flip();
            }
            return icons.length;
        }

        try (MemoryStack stack = stackPush()) {
            SDL_Surface iconSet = null;
            ByteBuffer[] sortedIcons = Arrays.copyOf(icons, icons.length);
            // Make sure to use the largest icon first
            Arrays.sort(sortedIcons, Comparator.comparingInt(bb -> -bb.remaining()));
            for (int icon = 0; icon < sortedIcons.length; icon++) {
                final ByteBuffer iconRgba = sortedIcons[icon];
                final int dimension = (int) Math.sqrt(iconRgba.remaining() / 4D);
                if (dimension * dimension * 4 != iconRgba.remaining()) {
                    throw new IllegalStateException(
                        "Could not determine icon size from a buffer length of " + iconRgba.remaining());
                }
                final SDL_Surface iconSurface = Sys
                    .checkSdl(SDL_CreateSurface(dimension, dimension, SDL_PIXELFORMAT_RGBA32));
                Sys.checkSdl(SDL_LockSurface(iconSurface));
                final ByteBuffer pixels = Objects.requireNonNull(iconSurface.pixels());
                final int oldPos = iconRgba.position();
                pixels.put(iconRgba);
                iconRgba.position(oldPos);
                SDL_UnlockSurface(iconSurface);
                if (iconSet == null) {
                    iconSet = iconSurface;
                } else {
                    SDL_AddSurfaceAlternateImage(iconSet, iconSurface);
                }
            }
            SDL_SetWindowIcon(getWindow(), iconSet);
            SDL_DestroySurface(iconSet);
        }
        return icons.length;
    }

    public static synchronized void setResizable(boolean resizable) {
        displayResizable = resizable;
        // Ignore the request because why would you make the game window non-resizable
    }

    public static synchronized boolean isResizable() {
        return displayResizable;
    }

    public static void setDisplayModeAndFullscreen(DisplayMode mode) {
        setDisplayMode(mode);
        setFullscreen(true);
    }

    public static void setFullscreen(boolean fullscreen) {
        displayWindowed = fullscreen ? WindowedState.fullscreen() : WindowedState.WINDOWED;
        if (sdlWindow != NULL) {
            // TODO
            // Fix bothered from
            // https: //
            // github.com/Kir-Antipov/cubes-without-borders/blob/b38306bf17d3f0936475a3a28c4ee2be4e881a62/src/main/java/
            // dev/kir/cubeswithoutborders/mixin/WindowMixin.java#L130
            // There's a bug that causes a fullscreen window to flicker when it loses focus.
            // As far as I know, this is relevant for Windows and X11 desktops.
            // Fuck X11 - it's a perpetually broken piece of legacy.
            // However, we do need to implement a fix for Windows desktops, as they
            // are not going anywhere in the foreseeable future (sadly enough).
            // This "fix" involves not bringing a window into a "proper" fullscreen mode,
            // but rather stretching it 1 pixel beyond the screen's supported resolution.
            MainThreadExec.runOnMainThread(() -> {
                SDL_SetWindowFullscreen(sdlWindow, fullscreen);
                // restore original window size as dictated by the game
                if (!fullscreen) {
                    SDL_SetWindowSize(sdlWindow, mode.getWidth(), mode.getHeight());
                }
                SDL_SyncWindow(sdlWindow);
            });
        }
    }

    public static boolean isFullscreen() {
        return displayWindowed.isFullscreen;
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
        MainThreadExec.runOnMainThread(() -> { SDL_GL_SetSwapInterval(value); });
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
    public static synchronized boolean lwjgl3ify$handleSdlEvent() {
        return switch (Lwjgl3ifyEventLoop.event.type()) {
            case SDL_EVENT_QUIT -> {
                displayCloseRequested = true;
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-close-request");
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_EXPOSED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayDirty = true;
                yield true;
            }
            case SDL_EVENT_WINDOW_FOCUS_GAINED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayFocused = true;
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-focus");
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_FOCUS_LOST -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayFocused = false;
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-unfocus");
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_MINIMIZED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayVisible = false;
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-minimize");
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_RESTORED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayVisible = true;
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info("[DEBUG-WINDOW] window-restore");
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_RESIZED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayWidth = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayHeight = Lwjgl3ifyEventLoop.windowEvent.data2();
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info(
                        "[DEBUG-WINDOW] window-resize window:{} w:{} h:{}",
                        Lwjgl3ifyEventLoop.windowEvent.windowID(),
                        displayWidth,
                        displayHeight);
                }
                yield true;
            }
            case SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayFramebufferWidth = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayFramebufferHeight = Lwjgl3ifyEventLoop.windowEvent.data2();
                if (Config.DEBUG_PRINT_WINDOW_EVENTS) {
                    Lwjgl3ify.LOG.info(
                        "[DEBUG-WINDOW] framebuffer-pixel scale change window:{} w:{} h:{}",
                        Lwjgl3ifyEventLoop.windowEvent.windowID(),
                        displayFramebufferWidth,
                        displayFramebufferHeight);
                }
                latestResized = true;
                latestWidth = displayFramebufferWidth;
                latestHeight = displayFramebufferHeight;
                yield true;
            }
            case SDL_EVENT_WINDOW_MOVED -> {
                if (Lwjgl3ifyEventLoop.windowEvent.windowID() != sdlWindowId) {
                    yield true;
                }
                displayX = Lwjgl3ifyEventLoop.windowEvent.data1();
                displayY = Lwjgl3ifyEventLoop.windowEvent.data2();
                yield true;
            }
            default -> false;
        };
    }
}
