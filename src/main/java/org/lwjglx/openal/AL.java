package org.lwjglx.openal;

import org.lwjgl.openal.ALC10;
import org.lwjglx.LWJGLException;
import org.lwjglx.Sys;

public class AL {

    public static long alContext = -1;
    public static ALCdevice alcDevice = null;

    private static boolean created = false;

    static {
        Sys.initialize(); // init using dummy sys method
    }

    public static void create() throws LWJGLException {
        if (alContext == -1) {
            final String defaultDevice = ALC10.alcGetString(0, ALC10.ALC_DEFAULT_DEVICE_SPECIFIER);
            alcDevice = new ALCdevice(ALC10.alcOpenDevice(defaultDevice));

            final int[] attribs = new int[] {
                org.lwjgl.openal.ALC10.ALC_FREQUENCY,
                44100,

                org.lwjgl.openal.ALC10.ALC_REFRESH,
                60,

                org.lwjgl.openal.ALC10.ALC_SYNC,
                org.lwjgl.openal.ALC10.ALC_FALSE,

                0,
            };

            alContext = org.lwjgl.openal.ALC10.alcCreateContext(alcDevice.device, attribs);
            created = true;
        }
    }

    public static boolean isCreated() {
        return created;
    }

    public static void destroy() {
        ALC10.alcDestroyContext(alContext);
        ALC10.alcCloseDevice(alcDevice.device);
        alContext = -1;
        alcDevice = null;
        created = false;
    }

    public static ALCdevice getDevice() {
        return alcDevice;
    }
}
