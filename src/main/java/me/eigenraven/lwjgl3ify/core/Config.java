package me.eigenraven.lwjgl3ify.core;

import java.io.File;
import java.util.Set;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

import me.eigenraven.lwjgl3ify.Tags;
import me.eigenraven.lwjgl3ify.rfb.EarlyConfig;

public class Config {

    private static boolean configLoaded = false;

    public static boolean MIXIN_STBI_TEXTURE_LOADING = true;
    public static boolean MIXIN_STBI_TEXTURE_STITCHING = true;
    public static boolean MIXIN_STBI_IGNORE_FASTCRAFT = false;

    public static boolean DEBUG_PRINT_KEY_EVENTS = false;
    public static boolean DEBUG_PRINT_MOUSE_EVENTS = false;
    public static boolean DEBUG_PRINT_WINDOW_EVENTS = false;
    public static boolean DEBUG_REGISTER_OPENGL_LOGGER = false;

    public static boolean SHOW_JAVA_VERSION = true;
    public static boolean SHOW_LWJGL_VERSION = true;

    public static boolean WINDOW_START_MAXIMIZED = false, WINDOW_START_FOCUSED = true, WINDOW_START_ICONIFIED = false;
    public static boolean WINDOW_CENTERED = true;
    public static boolean WINDOW_DECORATED = true;
    public static boolean WINDOW_LOADING_PROGRESS = true;
    public static boolean WINDOW_BORDERLESS_REPLACES_FULLSCREEN = false;
    public static boolean WINDOW_BORDERLESS_WINDOWS_COMPATIBILITY = true;
    public static boolean WINDOW_HIDPI_RENDERING = true;
    public static boolean WINDOW_LINUX_DESKTOP_ENTRY = true;
    public static boolean OPENGL_DEBUG_CONTEXT = false;
    public static boolean OPENGL_SRGB_CONTEXT = false;
    public static boolean OPENGL_DOUBLEBUFFER = true;
    public static boolean OPENGL_CONTEXT_NO_ERROR = false;

    public static boolean OPENAL_ENABLE_HRTF = false;

    public static boolean INPUT_INVERT_WHEEL = false;
    public static boolean INPUT_INVERT_X_WHEEL = false;
    public static double INPUT_SCROLL_SPEED = 1.0;
    public static boolean INPUT_CTRL_ALT_TEXT = false;
    public static boolean INPUT_ALTGR_ESCAPE_CODES = false;
    public static boolean INPUT_RAW_MOUSE = false;
    public static boolean FORCE_DISCRETE_SCROLLING = false;

    public static String APP_ID = "com.gtnewhorizons.Lwjgl3ifyMinecraft";

    public static String LWJGL3IFY_VERSION = Tags.VERSION;

    public static final String CATEGORY_MIXIN = "mixin";
    public static final String CATEGORY_CORE = "core";
    public static final String CATEGORY_IME = "ime";
    public static final String CATEGORY_DEBUG = "debug";
    public static final String CATEGORY_WINDOW = "window";
    public static final String CATEGORY_INPUT = "input";
    public static final String CATEGORY_GLCONTEXT = "openglcontext";
    public static final String CATEGORY_OPENALCONTEXT = "openalcontext";

    public static Configuration config = null;

    public static void loadConfig() {
        if (configLoaded) {
            return;
        }
        configLoaded = true;
        final File configDir = new File(Launch.minecraftHome, "config");
        if (!configDir.isDirectory()) {
            configDir.mkdirs();
        }
        final File configFile = new File(configDir, "lwjgl3ify.cfg");
        config = new Configuration(configFile);

        reloadConfigObject();

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static void reloadConfigObject() {
        MIXIN_STBI_TEXTURE_LOADING = config.getBoolean(
            "stbiTextureLoading",
            CATEGORY_MIXIN,
            MIXIN_STBI_TEXTURE_LOADING,
            "Use the faster spng-based texture loader");
        MIXIN_STBI_TEXTURE_STITCHING = config.getBoolean(
            "stbiTextureStitching",
            CATEGORY_MIXIN,
            MIXIN_STBI_TEXTURE_STITCHING,
            "Use the much faster stb_rectpack-based texture stitcher");
        MIXIN_STBI_IGNORE_FASTCRAFT = config.getBoolean(
            "stbiIgnoreFastcraft",
            CATEGORY_MIXIN,
            MIXIN_STBI_IGNORE_FASTCRAFT,
            "Force-enable the STB mixins even if FastCraft is present, may lead to a rapidly flashing screen and other visual artifacts");

        DEBUG_PRINT_KEY_EVENTS = config.getBoolean(
            "printKeyEvents",
            CATEGORY_DEBUG,
            DEBUG_PRINT_KEY_EVENTS,
            "Print keyboard-related events to the log");
        DEBUG_PRINT_MOUSE_EVENTS = config.getBoolean(
            "printMouseEvents",
            CATEGORY_DEBUG,
            DEBUG_PRINT_MOUSE_EVENTS,
            "Print mouse-related events to the log");
        DEBUG_PRINT_WINDOW_EVENTS = config.getBoolean(
            "printWindowEvents",
            CATEGORY_DEBUG,
            DEBUG_PRINT_WINDOW_EVENTS,
            "Print window-related events to the log");
        DEBUG_REGISTER_OPENGL_LOGGER = config.getBoolean(
            "registerOpenGLLogger",
            CATEGORY_DEBUG,
            DEBUG_REGISTER_OPENGL_LOGGER,
            "Register an OpenGL debug handler that can log OpenGL errors and performance warnings");

        SHOW_JAVA_VERSION = config
            .getBoolean("showJavaVersion", CATEGORY_CORE, SHOW_JAVA_VERSION, "Show java version in the debug hud");
        SHOW_LWJGL_VERSION = config
            .getBoolean("showLwjglVersion", CATEGORY_CORE, SHOW_LWJGL_VERSION, "Show lwjgl version in the debug hud");

        WINDOW_START_MAXIMIZED = config
            .getBoolean("maximized", CATEGORY_WINDOW, WINDOW_START_MAXIMIZED, "Start maximized?");
        WINDOW_START_FOCUSED = config.getBoolean("focused", CATEGORY_WINDOW, WINDOW_START_FOCUSED, "Start focused?");
        WINDOW_START_ICONIFIED = config
            .getBoolean("iconified", CATEGORY_WINDOW, WINDOW_START_ICONIFIED, "Start iconified?");
        WINDOW_CENTERED = config.getBoolean("centered", CATEGORY_WINDOW, WINDOW_CENTERED, "Start centered?");
        WINDOW_BORDERLESS_REPLACES_FULLSCREEN = config.getBoolean(
            "borderless",
            CATEGORY_WINDOW,
            WINDOW_BORDERLESS_REPLACES_FULLSCREEN,
            "Should exclusive fullscreen mode replaced with borderless fullscreen mode");
        WINDOW_BORDERLESS_WINDOWS_COMPATIBILITY = config.getBoolean(
            "borderlessWindowsCompatibility",
            CATEGORY_WINDOW,
            WINDOW_BORDERLESS_WINDOWS_COMPATIBILITY,
            "Windows-only - should borderless window have height increased by 1 to solve flickering on un-focusing");
        WINDOW_DECORATED = config.getBoolean(
            "decorated",
            CATEGORY_WINDOW,
            WINDOW_DECORATED,
            "Should the window have decorations (titlebar, border, close button)");
        WINDOW_LOADING_PROGRESS = config.getBoolean(
            "showLoadingProgress",
            CATEGORY_WINDOW,
            WINDOW_LOADING_PROGRESS,
            "Show game loading progress in the task bar on supported systems");
        APP_ID = config.getString(
            "appId",
            CATEGORY_WINDOW,
            APP_ID,
            "Changes the application ID used for categorizing windows in window managers, saving per-app settings etc.");
        WINDOW_HIDPI_RENDERING = config.getBoolean(
            "hidpiRendering",
            CATEGORY_WINDOW,
            WINDOW_HIDPI_RENDERING,
            "Enables high DPI rendering in the window, make sure to increase your GUI scale in options if enabled");
        WINDOW_LINUX_DESKTOP_ENTRY = config.getBoolean(
            "linuxCreateAppDesktopEntry",
            CATEGORY_WINDOW,
            WINDOW_LINUX_DESKTOP_ENTRY,
            "On Linux only, creates a hidden .desktop file in your XDG_DATA_HOME/applications folder matching the appId to improve Wayland support");

        INPUT_INVERT_WHEEL = config
            .getBoolean("invertScrollWheel", CATEGORY_INPUT, INPUT_INVERT_WHEEL, "Invert scrolling direction");
        INPUT_INVERT_X_WHEEL = config.getBoolean(
            "invertHorizontalScroll",
            CATEGORY_INPUT,
            INPUT_INVERT_X_WHEEL,
            "Invert horizontal scrolling direction (respects invertScrollWheel)");
        INPUT_SCROLL_SPEED = (double) config.getFloat(
            "scrollSpeedMultiplier",
            CATEGORY_INPUT,
            (float) INPUT_SCROLL_SPEED,
            +0.05f,
            +20.0f,
            "Scrolling speed multiplier");
        INPUT_CTRL_ALT_TEXT = config.getBoolean(
            "ctrlAltText",
            CATEGORY_INPUT,
            INPUT_CTRL_ALT_TEXT,
            "Allow text character input when Ctrl+Left Alt are pressed (disables special escape code handling for this combination of keys)");
        INPUT_ALTGR_ESCAPE_CODES = config.getBoolean(
            "altGrEscapeCodes",
            CATEGORY_INPUT,
            INPUT_ALTGR_ESCAPE_CODES,
            "Allows AltGr use in Ctrl+key special key combinations (disables text character input handling when AltGr is pressed)");
        INPUT_RAW_MOUSE = config
            .getBoolean("rawMouseInput", CATEGORY_INPUT, INPUT_RAW_MOUSE, "Use raw (unaccelerated) mouse input");
        FORCE_DISCRETE_SCROLLING = config.getBoolean(
            "forceDiscreteScrolling",
            CATEGORY_INPUT,
            FORCE_DISCRETE_SCROLLING,
            "Forces all scrolling events to receive a discrete mouse wheel value, this can fix problems when scrolling doesn't change slot");

        OPENGL_DEBUG_CONTEXT = config.getBoolean(
            "debugContext",
            CATEGORY_GLCONTEXT,
            OPENGL_DEBUG_CONTEXT,
            "Enable KHR_debug in the OpenGL context for advanced debugging capabilities");
        OPENGL_SRGB_CONTEXT = config.getBoolean(
            "srgb",
            CATEGORY_GLCONTEXT,
            OPENGL_SRGB_CONTEXT,
            "Make the framebuffer use the sRGB color space");
        OPENGL_DOUBLEBUFFER = config.getBoolean(
            "doubleBuffer",
            CATEGORY_GLCONTEXT,
            OPENGL_DOUBLEBUFFER,
            "Make the framebuffer double-buffered (will cause visual artifacts if disabled)");
        OPENGL_CONTEXT_NO_ERROR = config.getBoolean(
            "noError",
            CATEGORY_GLCONTEXT,
            OPENGL_CONTEXT_NO_ERROR,
            "Enable GL_KHR_no_error to use faster driver code, but which can cause memory corruption in case of OpenGL errors");

        OPENAL_ENABLE_HRTF = config
            .getBoolean("enableHRTF", CATEGORY_OPENALCONTEXT, OPENAL_ENABLE_HRTF, "Enable HRTF sound support");
    }

    public static Set<String> getExtensibleEnums() {
        return EarlyConfig.EXTENSIBLE_ENUMS;
    }

    public static void addExtensibleEnum(String className) {
        EarlyConfig.EXTENSIBLE_ENUMS.add(className);
    }

    public static boolean isConfigLoaded() {
        return configLoaded;
    }
}
