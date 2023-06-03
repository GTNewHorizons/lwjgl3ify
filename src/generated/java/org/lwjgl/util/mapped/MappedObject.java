package org.lwjgl.util.mapped;

public abstract class MappedObject {

    public static int SIZEOF = 0;
    public long baseAddress = 0;
    public int view = 0;
    public long viewAddress = 0;

    public final org.lwjgl.util.mapped.MappedObject[] asArray() {
        throw new UnsupportedOperationException();
    }

    public final java.nio.ByteBuffer backingByteBuffer() {
        throw new UnsupportedOperationException();
    }

    public final int capacity() {
        throw new UnsupportedOperationException();
    }

    public final void copyRange(org.lwjgl.util.mapped.MappedObject arg0, int arg1) {
        throw new UnsupportedOperationException();
    }

    public final void copyTo(org.lwjgl.util.mapped.MappedObject arg0) {
        throw new UnsupportedOperationException();
    }

    public final org.lwjgl.util.mapped.MappedObject dup() {
        throw new UnsupportedOperationException();
    }

    public static java.lang.Iterable foreach(org.lwjgl.util.mapped.MappedObject arg0) {
        throw new UnsupportedOperationException();
    }

    public static java.lang.Iterable foreach(org.lwjgl.util.mapped.MappedObject arg0, int arg1) {
        throw new UnsupportedOperationException();
    }

    public final int getAlign() {
        throw new UnsupportedOperationException();
    }

    public final int getSizeof() {
        throw new UnsupportedOperationException();
    }

    public static org.lwjgl.util.mapped.MappedObject malloc(int arg0) {
        throw new UnsupportedOperationException();
    }

    public static org.lwjgl.util.mapped.MappedObject map(long arg0, int arg1) {
        throw new UnsupportedOperationException();
    }

    public static org.lwjgl.util.mapped.MappedObject map(java.nio.ByteBuffer arg0) {
        throw new UnsupportedOperationException();
    }

    public final void next() {
        throw new UnsupportedOperationException();
    }

    public final void runViewConstructor() {
        throw new UnsupportedOperationException();
    }

    public final void setViewAddress(long arg0) {
        throw new UnsupportedOperationException();
    }

    public final org.lwjgl.util.mapped.MappedObject slice() {
        throw new UnsupportedOperationException();
    }

}
