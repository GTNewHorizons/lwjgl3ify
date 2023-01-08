package org.lwjglx.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL15;

public class GL15x {

    public static ByteBuffer glGetBufferPointer(int target, int pname) {
        int size = GL15.glGetBufferParameteri(target, GL15.GL_BUFFER_SIZE);

        PointerBuffer pb = BufferUtils.createPointerBuffer(1);
        pb.put(0, GL15.glGetBufferPointer(target, pname));

        return pb.getByteBuffer(0, size);
    }
}
