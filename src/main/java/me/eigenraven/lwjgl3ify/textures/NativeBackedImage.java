package me.eigenraven.lwjgl3ify.textures;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

import org.apache.commons.io.IOUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.util.spng.SPNG;
import org.lwjgl.util.spng.spng_ihdr;

public class NativeBackedImage extends BufferedImage implements AutoCloseable {

    private final int width;
    private final int height;
    private long pointer;
    private final int sizeBytes;

    private NativeBackedImage(int width, int height, long pointer) {
        super(width, height, TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
        this.pointer = pointer;

        // 4 channels: RGBA
        this.sizeBytes = width * height * 4;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int[] getRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize) {

        // Inverse itr for cache coherency
        for (int z = startY; z < h; z++) {
            for (int x = startX; x < w; x++) {
                int color = MemoryUtil.memGetInt(this.pointer + ((x + z * width) * 4));
                // ABGR -> ARGB
                int a = (color >> 24) & 0xFF;
                int b = (color >> 16) & 0xFF;
                int g = (color >> 8) & 0xFF;
                int r = (color >> 0) & 0xFF;

                int finalColor = (a << 24) | (r << 16) | (g << 8) | b;

                rgbArray[x + (z * width)] = finalColor;
            }
        }

        return rgbArray;
    }

    @Override
    public int getRGB(int x, int z) {
        checkBounds(x, z);

        return MemoryUtil.memGetInt(this.pointer + ((x + z * width) * 4));
    }

    @Override
    public void setRGB(int x, int z, int rgb) {
        checkBounds(x, z);

        MemoryUtil.memPutInt(this.pointer + ((x + z * width) * 4), rgb);
    }

    @Override
    public BufferedImage getSubimage(int x, int y, int w, int h) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void close() throws Exception {
        if (this.pointer != 0) {
            MemoryUtil.nmemFree(this.pointer);

            this.pointer = 0;
        }
    }

    private void checkBounds(int x, int z) {
        if (x < 0 || x >= this.width || z < 0 || z >= this.height) {
            throw new IllegalStateException(
                "Out of bounds: " + x + ", " + z + " (width: " + this.width + ", height: " + this.height + ")");
        }
    }

    // Parsing

    static final int MAX_IMAGE_DIM = 32768;

    private static final void spngCheck(int ec) throws IOException {
        if (ec == 0) {
            return;
        }
        throw new IOException("Error while decoding PNG data: " + SPNG.spng_strerror(ec));
    }

    public static NativeBackedImage make(InputStream stream) throws IOException {
        ByteBuffer imgBuf = null;

        try {
            imgBuf = readResource(stream);
            imgBuf.rewind();

            try (MemoryStack memoryStack = MemoryStack.stackPush()) {
                PointerBuffer outSize = memoryStack.mallocPointer(1);
                spng_ihdr ihdr = spng_ihdr.calloc(memoryStack);

                long ctx = SPNG.spng_ctx_new(0);
                final long imageBuffer;
                try {
                    spngCheck(SPNG.spng_set_image_limits(ctx, 2_097_152, 2_097_152));
                    // 1 GB PNG file ought to be enough for anyone
                    spngCheck(SPNG.spng_set_chunk_limits(ctx, 1 << 30, 1 << 30));
                    spngCheck(SPNG.spng_set_png_buffer(ctx, imgBuf));
                    spngCheck(SPNG.spng_decoded_image_size(ctx, SPNG.SPNG_FMT_RGBA8, outSize));
                    if (outSize.get(0) > MAX_IMAGE_DIM * MAX_IMAGE_DIM) {
                        throw new IOException(
                            String.format(
                                "Could not load image: output buffer size %d larger than max supported %d x %d",
                                outSize.get(0),
                                MAX_IMAGE_DIM,
                                MAX_IMAGE_DIM));
                    }
                    final int outSizeI = Math.toIntExact(outSize.get(0));
                    spngCheck(SPNG.spng_get_ihdr(ctx, ihdr));

                    imageBuffer = MemoryUtil.nmemAlloc(outSizeI);
                    final int decodeEc = SPNG.nspng_decode_image(
                        ctx,
                        imageBuffer,
                        outSizeI,
                        SPNG.SPNG_FMT_RGBA8,
                        SPNG.SPNG_DECODE_TRNS | SPNG.SPNG_DECODE_GAMMA);
                    if (decodeEc != 0) {
                        MemoryUtil.nmemFree(imageBuffer);
                        spngCheck(decodeEc);
                    }
                } finally {
                    SPNG.spng_ctx_free(ctx);
                }

                return new NativeBackedImage(ihdr.width(), ihdr.height(), imageBuffer);
            }

        } finally {
            // free
            MemoryUtil.memFree(imgBuf);
            IOUtils.closeQuietly(stream);
        }
    }

    private static ByteBuffer readResource(InputStream inputStream) throws IOException {
        ByteBuffer byteBuffer;
        if (inputStream instanceof FileInputStream) {
            FileChannel fileChannel = ((FileInputStream) inputStream).getChannel();
            byteBuffer = MemoryUtil.memAlloc((int) fileChannel.size() + 1);

            while (fileChannel.read(byteBuffer) != -1) {}
        } else {
            int sizeGuess = 4096;
            try {
                sizeGuess = Math.max(4096, inputStream.available());
            } catch (IOException ignored) {}

            byteBuffer = MemoryUtil.memAlloc(sizeGuess * 2);
            ReadableByteChannel readableByteChannel = new FastByteChannel(inputStream);

            while (readableByteChannel.read(byteBuffer) != -1) {
                // If we've filled the buffer, make it twice as large and re-parse
                if (byteBuffer.remaining() == 0) {
                    byteBuffer = MemoryUtil.memRealloc(byteBuffer, byteBuffer.capacity() * 2);
                }
            }
        }

        return byteBuffer;
    }
}
