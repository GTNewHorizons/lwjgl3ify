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
package org.lwjglx.util.glu;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_BGR;
import static org.lwjgl.opengl.GL12.GL_BGRA;
import static org.lwjgl.stb.STBImageResize.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjglx.util.glu.GLU.*;

import java.nio.ByteBuffer;

/**
 * MipMap.java
 *
 *
 * Created 11-jan-2004
 *
 * @author Erik Duijs
 */
public class MipMap extends Util {

    private static final ThreadLocal<PixelStoreState> pixelStoreState = new ThreadLocal<>() {

        @Override
        protected PixelStoreState initialValue() {
            return new PixelStoreState();
        }
    };

    /**
     * gluBuild2DMipmaps builds a series of prefiltered 2D texture maps of decreasing resolution. Mipmaps can be used so
     * that textures don't appear aliased.
     * <br>
     * A return value of 0 indicates success. Otherwise a GLU error code is returned (see gluErrorString).
     * <br>
     * gluBuild2DMipmaps first check whether width and height of data are both powers of 2. If not, gluBuild2DMipmaps
     * scales a copy of data up or down to the nearest power of 2. This copy is then used as the base for subsequent
     * mipmapping operations. For example, if width is 57 and height is 23, then a copy of data scales up to 64 and down
     * to 16, respectively, before mipmapping takes place. (If width or height is exactly between powers of 2, the copy
     * of data is scaled upward.)
     * <br>
     * If the GL version is 1.1 or greater, gluBuild2DMipmaps then uses proxy textures (see glTexImage1D) to determine
     * whether there's enough room for the requested texture in the implementation. If not, width is halved (and halved
     * again) until it fits.
     * <br>
     * gluBuild2DMipmaps then uses proxy textures (see glTexImage2D) to determine if the implementation can store the
     * requested texture in texture memory. If not, both dimensions are continually halved until it fits.
     * <br>
     * Next, gluBuild2DMipmaps builds a series of images; it halves a copy of type (or a scaled version of type, if
     * necessary) along both dimensions until size 1x1 is reached. At each level, each texel in the halved mipmap is an
     * average of the corresponding four texels in the larger mipmap. (In the case of rectangular images, halving the
     * images repeatedly eventually results in an nx1 or 1xn configuration. Here, two texels are averaged instead.)
     * <br>
     * glTexImage2D is called to load each of these images by level. If width and height are both powers of 2 which fit
     * in the implementation, level 0 is a copy of data, and the highest level is log2(max(width, height)). For example,
     * if width is 64 and height is 16, the following mipmaps are built: 64x16, 32x8, 16x4, 8x2, 4x1, 2x1 and 1x1. These
     * correspond to levels 0 through 6, respectively.
     * <br>
     * See the glTexImage1D reference page for a description of the acceptable values for format. See the glDrawPixels
     * reference page for a description of the acceptable values for type
     *
     * @param target     Specifies the target texture. Must be GL_TEXTURE_2D
     * @param components Specifies the number of color components in the texture. Must be 1, 2, 3, or 4
     * @param width      Specifies the width and height, respectively, of the texture image
     * @param height     Specifies the width and height, respectively, of the texture image
     * @param format     Specifies the format of the pixel data. Must be one of: GL_COLOR_INDEX, GL_RED, GL_GREEN,
     *                   GL_BLUE, GL_ALPHA, GL_RGB, GL_RGBA, GL_LUMINANCE, and GL_LUMINANCE_ALPHA
     * @param type       Specifies the data type for data. Must be one of: GL_UNSIGNED_BYTE, GL_BYTE, GL_BITMAP,
     *                   GL_UNSIGNED_SHORT, GL_SHORT, GL_UNSIGNED_INT, GL_INT, or GL_FLOAT
     * @param data       Specifies a pointer to the image data in memory
     * @return int A return value of 0 indicates success. Otherwise, a GLU error code is returned (see gluErrorString).
     */
    public static int gluBuild2DMipmaps(final int target, final int components, final int width, final int height,
        final int format, final int type, final ByteBuffer data) {
        if (width < 1 || height < 1) return GLU_INVALID_VALUE;

        final int bpp = bytesPerPixel(format, type);
        if (bpp == 0) return GLU_INVALID_ENUM;

        final int maxSize = glGetIntegerv(GL_MAX_TEXTURE_SIZE);

        int w = nearestPower(width);
        if (w > maxSize) w = maxSize;

        int h = nearestPower(height);
        if (h > maxSize) h = maxSize;

        // Get current glPixelStore state
        PixelStoreState pss = pixelStoreState.get();
        pss.load();

        // set pixel packing
        glPixelStorei(GL_PACK_ROW_LENGTH, 0);
        glPixelStorei(GL_PACK_ALIGNMENT, 1);
        glPixelStorei(GL_PACK_SKIP_ROWS, 0);
        glPixelStorei(GL_PACK_SKIP_PIXELS, 0);

        ByteBuffer image, newImage;
        int retVal = 0;
        image = memAlloc((w + 4) * h * bpp);
        newImage = memAlloc((w + 4) * h * bpp);

        if (w != width || h != height) {
            // must rescale image to get "top" mipmap texture image
            int error = gluScaleImage(format, width, height, type, data, w, h, type, image);
            if (error != 0) {
                retVal = error;
            }
        } else {
            memCopy(data, image);
        }

        int level = 0;
        while (retVal == 0) {
            glTexImage2D(target, level, components, w, h, 0, format, type, image);

            if (w == 1 && h == 1) break;

            final int newW = (w < 2) ? 1 : w >> 1;
            final int newH = (h < 2) ? 1 : h >> 1;

            int error = gluScaleImage(format, w, h, type, image, newW, newH, type, newImage);
            if (error != 0) {
                retVal = error;
                break;
            }

            // Swap the buffers
            final ByteBuffer oldImage = image;
            image = newImage;
            newImage = oldImage;

            w = newW;
            h = newH;
            level++;
        }

        // Restore original glPixelStore state
        pss.save();

        memFree(image);
        memFree(newImage);

        return retVal;
    }

    /**
     * Method gluScaleImage.
     *
     * @param format
     * @param widthIn
     * @param heightIn
     * @param typein
     * @param dataIn
     * @param widthOut
     * @param heightOut
     * @param typeOut
     * @param dataOut
     * @return int
     */
    public static int gluScaleImage(int format, int widthIn, int heightIn, int typein, ByteBuffer dataIn, int widthOut,
        int heightOut, int typeOut, ByteBuffer dataOut) {

        final int components = compPerPix(format);
        if (components == -1) return GLU_INVALID_ENUM;
        final int strideIn = widthIn * components;
        final int strideOut = widthOut * components;
        final int pixelType = switch (format) {
            case GL_COLOR_INDEX, GL_STENCIL_INDEX, GL_DEPTH_COMPONENT, GL_RED, GL_GREEN, GL_BLUE, GL_ALPHA, GL_LUMINANCE -> STBIR_1CHANNEL;
            case GL_LUMINANCE_ALPHA -> STBIR_AR;
            case GL_RGB -> STBIR_RGB;
            case GL_BGR -> STBIR_BGR;
            case GL_RGBA -> STBIR_RGBA;
            case GL_BGRA -> STBIR_BGRA;
            default -> components;
        };

        if (typein != typeOut) {
            // We don't care about float->int resizing unless proven otherwise
            return GLU_INVALID_ENUM;
        }

        // Determine bytes per input type
        switch (typein) {
            case GL_UNSIGNED_BYTE -> {
                if (stbir_resize_uint8_srgb(
                    dataIn,
                    widthIn,
                    heightIn,
                    strideIn,
                    dataOut,
                    widthOut,
                    heightOut,
                    strideOut,
                    pixelType) == null) {
                    throw new RuntimeException("Couldn't resize image with stbir");
                }
            }
            case GL_FLOAT -> {
                if (stbir_resize_float_linear(
                    dataIn.asFloatBuffer(),
                    widthIn,
                    heightIn,
                    strideIn * 4,
                    dataOut.asFloatBuffer(),
                    widthOut,
                    heightOut,
                    strideOut * 4,
                    pixelType) == null) {
                    throw new RuntimeException("Couldn't resize image with stbir");
                }
            }
            default -> {
                return GL_INVALID_ENUM;
            }
        }

        return 0;
    }
}
