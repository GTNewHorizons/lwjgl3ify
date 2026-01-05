/*
 * Copyright (c) 2002-2008 LWJGL Project All rights reserved. Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following conditions are met: * Redistributions of source code
 * must retain the above copyright notice, this list of conditions and the following disclaimer. * Redistributions in
 * binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution. * Neither the name of 'LWJGL' nor the names of
 * its contributors may be used to endorse or promote products derived from this software without specific prior written
 * permission. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjglx.input;

import static org.lwjgl.sdl.SDLMouse.*;
import static org.lwjgl.sdl.SDLPixels.*;
import static org.lwjgl.sdl.SDLSurface.*;

import java.nio.IntBuffer;

import net.minecraft.util.MathHelper;

import org.lwjgl.sdl.SDL_Surface;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.Sys;

import me.eigenraven.lwjgl3ify.client.MainThreadExec;

/**
 *
 * A class representing a native cursor. Instances of this class can be used with Mouse.setCursor(), if available.
 *
 * @author elias_naur <elias_naur@users.sourceforge.net>
 * @version $Revision$ $Id$
 */
public class Cursor {

    /** 1 bit transparency for native cursor */
    public static final int CURSOR_ONE_BIT_TRANSPARENCY = 1;

    /** 8 bit alhpa native cursor */
    public static final int CURSOR_8_BIT_ALPHA = 2;

    /** animation native cursor */
    public static final int CURSOR_ANIMATION = 4;

    /** First element to display */
    private final CursorElement[] cursors = null;

    /** Index into list of cursors */
    private int index;

    private boolean destroyed;

    private long sdlCursor;
    private SDL_Surface sdlSurface;

    /**
     * Constructs a new Cursor, with the given parameters. Mouse must have been created before you can create Cursor
     * objects. Cursor images are in ARGB format, but only one bit transparancy is guaranteed to be supported. So to
     * maximize portability, lwjgl applications should only create cursor images with 0x00 or 0xff as alpha values. The
     * constructor will copy the images and delays, so there's no need to keep them around.
     *
     * @param width     cursor image width
     * @param height    cursor image height
     * @param xHotspot  the x coordinate of the cursor hotspot
     * @param yHotspot  the y coordinate of the cursor hotspot
     * @param numImages number of cursor images specified. Must be 1 if animations are not supported.
     * @param images    A buffer containing the images. The origin is at the lower left corner, like OpenGL.
     * @param delays    An int buffer of animation frame delays, if numImages is greater than 1, else null
     */
    public Cursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images,
        IntBuffer delays) {
        final int pixels = width * height;
        if (numImages < 1) {
            throw new IllegalArgumentException("There must be at least 1 cursor image");
        }
        if (images.remaining() < pixels) {
            throw new IllegalArgumentException("Not enough pixels in the cursor image");
        }
        try (MemoryStack stack = MemoryStack.stackPush()) {
            sdlSurface = Sys.checkSdl(SDL_CreateSurface(width, height, SDL_PIXELFORMAT_BGRA32));
            Sys.checkSdl(SDL_LockSurface(sdlSurface));
            final IntBuffer targetInts = sdlSurface.pixels()
                .asIntBuffer();
            for (int i = 0; i < pixels; i++) {
                targetInts.put(i, images.get(i));
            }
            SDL_UnlockSurface(sdlSurface);
            SDL_FlipSurface(sdlSurface, SDL_FLIP_VERTICAL);
            sdlCursor = Sys.checkSdl(
                SDL_CreateColorCursor(
                    sdlSurface,
                    MathHelper.clamp_int(xHotspot, 0, width - 1),
                    MathHelper.clamp_int(height - 1 - yHotspot, 0, height - 1)));
        }
    }

    /**
     * Gets the minimum size of a native cursor. Can only be called if The Mouse is created and cursor caps includes at
     * least CURSOR_ONE_BIT_TRANSPARANCY.
     *
     * @return the maximum size of a native cursor
     */
    public static int getMinCursorSize() {
        return 8;
    }

    /**
     * Gets the maximum size of a native cursor. Can only be called if The Mouse is created and cursor caps includes at
     * least CURSOR_ONE_BIT_TRANSPARANCY.
     *
     * @return the maximum size of a native cursor
     */
    public static int getMaxCursorSize() {
        return 64;
    }

    /**
     * Get the capabilities of the native cursor. Return a bit mask of the native cursor capabilities. The
     * CURSOR_ONE_BIT_TRANSPARANCY indicates support for cursors with one bit transparancy, the CURSOR_8_BIT_ALPHA
     * indicates support for 8 bit alpha and CURSOR_ANIMATION indicates support for cursor animations.
     *
     * @return A bit mask with native cursor capabilities.
     */
    public static int getCapabilities() {
        return CURSOR_ONE_BIT_TRANSPARENCY | CURSOR_8_BIT_ALPHA;
    }

    /**
     * Gets the native handle associated with the cursor object.
     */
    Object getHandle() {
        checkValid();
        return cursors[index].cursorHandle;
    }

    private void checkValid() {
        if (destroyed) throw new IllegalStateException("The cursor is destroyed");
    }

    /**
     * Destroy the native cursor. If the cursor is current, the current native cursor is set to null (the default OS
     * cursor)
     */
    public void destroy() {
        if (Mouse.getNativeCursor() == this) {
            Mouse.setNativeCursor(null);
        }
        if (sdlCursor != 0) {
            SDL_DestroyCursor(sdlCursor);
            sdlCursor = 0;
        }
        if (sdlSurface != null) {
            SDL_DestroySurface(sdlSurface);
            sdlSurface = null;
        }
    }

    /**
     * Sets the timout property to the time it should be changed
     */
    protected void setTimeout() {
        checkValid();
        cursors[index].timeout = System.currentTimeMillis() + cursors[index].delay;
    }

    /**
     * Determines whether this cursor has timed out
     *
     * @return true if the this cursor has timed out, false if not
     */
    protected boolean hasTimedOut() {
        checkValid();
        return cursors.length > 1 && cursors[index].timeout < System.currentTimeMillis();
    }

    /**
     * Changes to the next cursor
     */
    protected void nextCursor() {
        checkValid();
        index = ++index % cursors.length;
    }

    /**
     * A single cursor element, used when animating
     */
    private static class CursorElement {

        /** Handle to cursor */
        final Object cursorHandle;

        /** How long a delay this element should have */
        final long delay;

        /** Absolute time this element times out */
        long timeout;

        CursorElement(Object cursorHandle, long delay, long timeout) {
            this.cursorHandle = cursorHandle;
            this.delay = delay;
            this.timeout = timeout;
        }
    }

    void sdlSet() {
        if (sdlCursor == 0) {
            return;
        }
        MainThreadExec.runOnMainThread(() -> SDL_SetCursor(sdlCursor));
    }
}
