package org.lwjglx;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLMessageBox.*;
import static org.lwjgl.sdl.SDLStdinc.*;
import static org.lwjgl.sdl.SDLTimer.*;

import java.awt.Toolkit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.sdl.SDLClipboard;
import org.lwjgl.sdl.SDLMisc;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjglx.opengl.Display;

import me.eigenraven.lwjgl3ify.client.MainThreadExec;

public class Sys {

    static private void firstTimeInit() {
        if (Platform.get() == Platform.MACOSX) {
            Toolkit.getDefaultToolkit(); // Initialize AWT before SDL
        }
        MainThreadExec.runOnMainSelectorOnMac(() -> {
            SDL_SetMemoryFunctions(
                MemoryUtil::nmemAllocChecked,
                MemoryUtil::nmemCallocChecked,
                MemoryUtil::nmemReallocChecked,
                MemoryUtil::nmemFree);
            checkSdlError(SDL_SetAppMetadata("Lwjgl3ify Minecraft", "1.7.10", "com.gtnewhorizons.Lwjgl3ifyMinecraft"));
            checkSdlError(
                SDL_SetAppMetadataProperty(
                    SDL_PROP_APP_METADATA_URL_STRING,
                    "https://github.com/GTNewHorizons/lwjgl3ify"));
            checkSdlError(SDL_SetAppMetadataProperty(SDL_PROP_APP_METADATA_CREATOR_STRING, "Mojang, GTNH Team"));
            checkSdlError(
                SDL_SetAppMetadataProperty(
                    SDL_PROP_APP_METADATA_COPYRIGHT_STRING,
                    "https://www.minecraft.net/en-us/eula"));
            checkSdlError(SDL_SetAppMetadataProperty(SDL_PROP_APP_METADATA_TYPE_STRING, "game"));
            if (!SDL_Init(
                SDL_INIT_VIDEO | SDL_INIT_EVENTS
                    | SDL_INIT_JOYSTICK
                    | SDL_INIT_GAMEPAD
                    | SDL_INIT_HAPTIC
                    | SDL_INIT_SENSOR)) {
                throw new RuntimeException("Could not initialize SDL.");
            }
        });
        // TODO: remove
        if (MainThreadExec.IS_MACOS) {
            Configuration.GLFW_CHECK_THREAD0.set(false);
            Configuration.GLFW_LIBRARY_NAME.set("glfw_async");
        }
        GLFW.glfwInit();
    }

    private static final AtomicBoolean isFirstInit = new AtomicBoolean(true);

    private static void checkSdlError(boolean b) {
        if (!b) {
            throw new RuntimeException("SDL Error: " + SDL_GetError());
        }
    }

    public static void initialize() {
        if (!isFirstInit.compareAndSet(true, false)) {
            return;
        } else {
            firstTimeInit();
        }
        if (!MainThreadExec.IS_MACOS && !SDL_IsMainThread()) {
            throw new IllegalStateException("SDL was initialized on the wrong thread.");
        }
    }

    /** Returns the LWJGL version. */
    public static String getVersion() {
        return Version.getVersion();
    }

    /**
     * Obtains the number of ticks that the hires timer does in a second. This method is fast; it should be called as
     * frequently as possible, as it recalibrates the timer.
     *
     * @return timer resolution in ticks per second or 0 if no timer is present.
     */
    public static long getTimerResolution() {
        return 1_000_000;
    }

    /**
     * Gets the current value of the hires timer, in ticks. When the Sys class is first loaded the hires timer is reset
     * to 0. If no hires timer is present then this method will always return 0.
     * <p>
     * <strong>NOTEZ BIEN</strong> that the hires timer WILL wrap around.
     *
     * @return the current hires time, in ticks (always >= 0)
     */
    public static long getTime() {
        return SDL_GetTicksNS() / 1_000;
    }

    public static long getNanoTime() {
        return SDL_GetTicksNS();
    }

    public static boolean openURL(String url) {
        return MainThreadExec.runOnMainThread(() -> SDLMisc.SDL_OpenURL(url));
    }

    public static void alert(String title, String message) {
        MainThreadExec.runOnMainThread(
            () -> { SDL_ShowSimpleMessageBox(SDL_MESSAGEBOX_WARNING, title, message, Display.getWindow()); });
    }

    public static boolean is64Bit() {
        return Pointer.BITS64;
    }

    public static String getClipboard() {
        return MainThreadExec.runOnMainThread(SDLClipboard::SDL_GetClipboardText);
    }
}
