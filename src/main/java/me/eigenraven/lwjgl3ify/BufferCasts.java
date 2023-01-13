package me.eigenraven.lwjgl3ify;

import java.nio.*;
import java.nio.charset.StandardCharsets;

public class BufferCasts {
    public static ByteBuffer toByteBuffer(CharBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asCharBuffer().put(buffer);
        return newBuffer;
    }
    public static ByteBuffer toByteBuffer(ShortBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asShortBuffer().put(buffer);
        return newBuffer;
    }
    public static ByteBuffer toByteBuffer(IntBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asIntBuffer().put(buffer);
        return newBuffer;
    }
    public static ByteBuffer toByteBuffer(LongBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asLongBuffer().put(buffer);
        return newBuffer;
    }
    public static ByteBuffer toByteBuffer(FloatBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asFloatBuffer().put(buffer);
        return newBuffer;
    }
    public static ByteBuffer toByteBuffer(DoubleBuffer buffer) {
        ByteBuffer newBuffer = ByteBuffer.allocateDirect(buffer.capacity() * 4);
        newBuffer.asDoubleBuffer().put(buffer);
        return newBuffer;
    }

    public static void updateBuffer(CharBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asCharBuffer());
    }
    public static void updateBuffer(ShortBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asShortBuffer());
    }
    public static void updateBuffer(IntBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asIntBuffer());
    }
    public static void updateBuffer(LongBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asLongBuffer());
    }
    public static void updateBuffer(FloatBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asFloatBuffer());
    }
    public static void updateBuffer(DoubleBuffer destination, ByteBuffer source) {
        destination.clear();
        destination.put(source.asDoubleBuffer());
    }

    public static CharSequence bufferToCharSeq(ByteBuffer buffer) {
        if (buffer.hasArray()) {
            return new String(buffer.array(), StandardCharsets.UTF_8);
        } else {
            byte[] tmp = new byte[buffer.remaining()];
            buffer.get(tmp);
            return new String(tmp, StandardCharsets.UTF_8);
        }
    }
}
