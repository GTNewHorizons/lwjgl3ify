package org.lwjglx.opengl;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.nio.ByteBuffer;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.GL15;
import org.lwjgl.system.MemoryStack;

public class GL15x {

    public static ByteBuffer glGetBufferPointer(int target, int pname) {
        int size = GL15.glGetBufferParameteri(target, GL15.GL_BUFFER_SIZE);
        try (MemoryStack stack = stackPush()) {
            PointerBuffer pb = stack.mallocPointer(1);
            GL15.glGetBufferPointerv(target, pname, pb);

            return pb.getByteBuffer(0, size);
        }
    }
}
