package org.lwjgl.util.mapped;

public interface MappedType {

    public abstract int align();

    public abstract boolean autoGenerateOffsets();

    public abstract boolean cacheLinePadding();

    public abstract int padding();

}
