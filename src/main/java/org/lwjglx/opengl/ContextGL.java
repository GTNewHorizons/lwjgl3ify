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
package org.lwjglx.opengl;

import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.opengl.GL;
import org.lwjgl.sdl.SDLVideo;
import org.lwjglx.LWJGLException;
import org.lwjglx.PointerBuffer;

/**
 * <p/>
 * Context encapsulates an OpenGL context.
 * <p/>
 * <p/>
 * This class is thread-safe.
 *
 * @author elias_naur <elias_naur@users.sourceforge.net>
 * @version $Revision$ $Id$
 */
public final class ContextGL implements Context {

    public long sdlWindow = 0, sdlContext = 0;
    public final boolean shared;

    public ContextGL(long sdlWindow, long sdlContext, boolean shared) {
        this.sdlWindow = sdlWindow;
        this.sdlContext = sdlContext;
        this.shared = shared;
    }

    public void releaseCurrent() throws LWJGLException {
        Display.glContextMutex.lock();
        try {
            GL.setCapabilities(null);
            SDLVideo.SDL_GL_MakeCurrent(sdlWindow, NULL);
        } finally {
            Display.glContextMutex.unlock();
        }
    }

    public synchronized void releaseDrawable() throws LWJGLException {}

    public synchronized void update() {}

    public static void swapBuffers() throws LWJGLException {
        Display.swapBuffers();
    }

    public synchronized void makeCurrent() throws LWJGLException {
        Display.glContextMutex.lock();
        try {
            SDLVideo.SDL_GL_MakeCurrent(sdlWindow, sdlContext);
            GL.createCapabilities();
        } finally {
            Display.glContextMutex.unlock();
        }
    }

    public synchronized boolean isCurrent() throws LWJGLException {
        return SDLVideo.SDL_GL_GetCurrentContext() == sdlContext;
    }

    public static void setSwapInterval(int value) {
        Display.setSwapInterval(value);
    }

    public synchronized void forceDestroy() throws LWJGLException {
        destroy();
    }

    public synchronized void destroy() throws LWJGLException {
        if (shared && sdlWindow != NULL) {
            if (sdlContext != NULL) {
                SDLVideo.SDL_GL_DestroyContext(sdlContext);
                sdlContext = NULL;
            }
            SDLVideo.SDL_DestroyWindow(sdlWindow);
            sdlWindow = NULL;
        }
    }

    public synchronized void setCLSharingProperties(final PointerBuffer properties) throws LWJGLException {}
}
