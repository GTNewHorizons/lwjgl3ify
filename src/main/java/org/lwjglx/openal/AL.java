package org.lwjglx.openal;

import java.nio.IntBuffer;
import org.lwjglx.BufferUtils;
import org.lwjglx.LWJGLException;
import org.lwjglx.Sys;

public class AL {

    static ALCdevice alcDevice;

    private static boolean created = false;

    static {
        Sys.initialize(); // init using dummy sys method
    }

    public static void create() throws LWJGLException {
        AL.create();

        IntBuffer attribs = BufferUtils.createIntBuffer(16);

        attribs.put(org.lwjgl.openal.ALC10.ALC_FREQUENCY);
        attribs.put(44100);

        attribs.put(org.lwjgl.openal.ALC10.ALC_REFRESH);
        attribs.put(60);

        attribs.put(org.lwjgl.openal.ALC10.ALC_SYNC);
        attribs.put(org.lwjgl.openal.ALC10.ALC_FALSE);

        attribs.put(0);
        attribs.flip();

        long contextHandle = org.lwjgl.openal.ALC10.alcCreateContext(AL.getDevice().device, attribs);

        alcDevice = new ALCdevice(contextHandle);

        created = true;
    }

    public static boolean isCreated() {
        return created;
    }

    public static void destroy() {
        AL.destroy();
        alcDevice = null;
        created = false;
    }

    public static ALCdevice getDevice() {
        return alcDevice;
    }
}
