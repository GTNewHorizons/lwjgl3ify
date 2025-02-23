package me.eigenraven.lwjgl3ify.redirects;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.sdl.SDLMisc;

import me.eigenraven.lwjgl3ify.client.MainThreadExec;

/**
 * Mixins redirect {@link java.awt.Desktop#browse(URI)} here.
 */
@SuppressWarnings("unused")
public final class Desktop {

    public static final Desktop INSTANCE = new Desktop();
    private static final Logger LOGGER = LogManager.getLogger("lwjgl3ify");

    public static Desktop getDesktop() {
        return INSTANCE;
    }

    public void browse(URI uri) {
        final String uriString = uri.toString();
        LOGGER.info("Opening URL via SDL: {}", uriString);
        MainThreadExec.runOnMainThread(() -> { SDLMisc.SDL_OpenURL(uriString); });
    }
}
