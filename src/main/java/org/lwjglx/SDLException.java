package org.lwjglx;

import static org.lwjgl.sdl.SDLError.SDL_GetError;

public class SDLException extends RuntimeException {

    public SDLException() {
        super("SDL error: " + SDL_GetError());
    }
}
