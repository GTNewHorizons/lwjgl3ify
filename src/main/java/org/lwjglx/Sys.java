package org.lwjglx;

import static org.lwjgl.sdl.SDLHints.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLMessageBox.*;
import static org.lwjgl.sdl.SDLStdinc.*;
import static org.lwjgl.sdl.SDLTimer.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.awt.GraphicsEnvironment;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.Version;
import org.lwjgl.sdl.SDLClipboard;
import org.lwjgl.sdl.SDLMisc;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjglx.opengl.Display;

import me.eigenraven.lwjgl3ify.client.MainThreadExec;
import me.eigenraven.lwjgl3ify.core.Config;

public class Sys {

    static private void firstTimeInit() {
        Configuration.OPENGL_EXPLICIT_INIT.set(true);
        if (Platform.get() == Platform.MACOSX) {
            if (!GraphicsEnvironment.isHeadless()) {
                throw new IllegalStateException(
                    "java.awt.headless must be set to true on macOS, this is normally set by RFB!");
            }
        }
        MainThreadExec.ensureInitialised();
        MainThreadExec.runOnMainThread(() -> {
            SDL_SetMemoryFunctions(
                MemoryUtil::nmemAllocChecked,
                MemoryUtil::nmemCallocChecked,
                MemoryUtil::nmemReallocChecked,
                MemoryUtil::nmemFree);
            checkSdl(SDL_SetAppMetadata("Lwjgl3ify Minecraft", "1.7.10", Config.APP_ID));
            checkSdl(
                SDL_SetAppMetadataProperty(
                    SDL_PROP_APP_METADATA_URL_STRING,
                    "https://github.com/GTNewHorizons/lwjgl3ify"));
            checkSdl(SDL_SetAppMetadataProperty(SDL_PROP_APP_METADATA_CREATOR_STRING, "Mojang, GTNH Team"));
            checkSdl(
                SDL_SetAppMetadataProperty(
                    SDL_PROP_APP_METADATA_COPYRIGHT_STRING,
                    "https://www.minecraft.net/en-us/eula"));
            checkSdl(SDL_SetAppMetadataProperty(SDL_PROP_APP_METADATA_TYPE_STRING, "game"));
            if (!SDL_Init(
                SDL_INIT_VIDEO | SDL_INIT_EVENTS
                    | SDL_INIT_JOYSTICK
                    | SDL_INIT_GAMEPAD
                    | SDL_INIT_HAPTIC
                    | SDL_INIT_SENSOR)) {
                throw new SDLException("Could not initialize SDL.");
            }
            if (Platform.get() == Platform.MACOSX) {
                SDL_SetHint(SDL_HINT_MAC_OPENGL_ASYNC_DISPATCH, "1");
            }
        });
    }

    private static final AtomicBoolean isFirstInit = new AtomicBoolean(true);

    public static void initialize() {
        if (!isFirstInit.compareAndSet(true, false)) {
            return;
        } else {
            firstTimeInit();
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

    public static void checkSdl(boolean result) {
        if (!result) {
            throw new SDLException();
        }
    }

    public static <T> @NotNull T checkSdl(@Nullable T result) {
        if (result == null) {
            throw new SDLException();
        }
        return result;
    }

    public static int checkSdl(int result) {
        if (result == NULL) {
            throw new SDLException();
        }
        return result;
    }

    public static long checkSdl(long result) {
        if (result == NULL) {
            throw new SDLException();
        }
        return result;
    }
}
