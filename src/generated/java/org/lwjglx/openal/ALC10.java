package org.lwjglx.openal;

public class ALC10 {

    public static final int ALC_ALL_ATTRIBUTES = (int) 4099;
    public static final int ALC_ATTRIBUTES_SIZE = (int) 4098;
    public static final int ALC_DEFAULT_DEVICE_SPECIFIER = (int) 4100;
    public static final int ALC_DEVICE_SPECIFIER = (int) 4101;
    public static final int ALC_EXTENSIONS = (int) 4102;
    public static final int ALC_FALSE = (int) 0;
    public static final int ALC_FREQUENCY = (int) 4103;
    public static final int ALC_INVALID = (int) 0;
    public static final int ALC_INVALID_CONTEXT = (int) 40962;
    public static final int ALC_INVALID_DEVICE = (int) 40961;
    public static final int ALC_INVALID_ENUM = (int) 40963;
    public static final int ALC_INVALID_VALUE = (int) 40964;
    public static final int ALC_MAJOR_VERSION = (int) 4096;
    public static final int ALC_MINOR_VERSION = (int) 4097;
    public static final int ALC_NO_ERROR = (int) 0;
    public static final int ALC_OUT_OF_MEMORY = (int) 40965;
    public static final int ALC_REFRESH = (int) 4104;
    public static final int ALC_SYNC = (int) 4105;
    public static final int ALC_TRUE = (int) 1;

    public static boolean alcCloseDevice(org.lwjglx.openal.ALCdevice device) {

        boolean returnValue = org.lwjgl.openal.ALC10.alcCloseDevice(device.device);

        return returnValue;
    }

    public static org.lwjglx.openal.ALCcontext alcCreateContext(org.lwjglx.openal.ALCdevice arg0,
            java.nio.IntBuffer arg1) {

        org.lwjglx.openal.ALCcontext returnValue = new ALCcontext(
                org.lwjgl.openal.ALC10.alcCreateContext(arg0.device, arg1));

        return returnValue;
    }

    public static org.lwjglx.openal.ALCcontext alcGetCurrentContext() {

        org.lwjglx.openal.ALCcontext returnValue = new ALCcontext(org.lwjgl.openal.ALC10.alcGetCurrentContext());

        return returnValue;
    }

    public static void alcDestroyContext(org.lwjglx.openal.ALCcontext ctx) {
        org.lwjgl.openal.ALC10.alcDestroyContext(ctx.context);
    }

    public static org.lwjglx.openal.ALCdevice alcGetContextsDevice(org.lwjglx.openal.ALCcontext ctx) {
        final long devId = org.lwjgl.openal.ALC10.alcGetContextsDevice(ctx.context);
        return new ALCdevice(devId);
    }

    public static int alcMakeContextCurrent(org.lwjglx.openal.ALCcontext ctx) {
        return org.lwjgl.openal.ALC10.alcMakeContextCurrent(ctx.context) ? ALC_TRUE : ALC_FALSE;
    }

    public static void alcProcessContext(org.lwjglx.openal.ALCcontext ctx) {
        org.lwjgl.openal.ALC10.alcProcessContext(ctx.context);
    }

    public static void alcSuspendContext(org.lwjglx.openal.ALCcontext ctx) {
        org.lwjgl.openal.ALC10.alcSuspendContext(ctx.context);
    }

    public static int alcGetEnumValue(org.lwjglx.openal.ALCdevice device, java.lang.String enumName) {

        int returnValue = org.lwjgl.openal.ALC10.alcGetEnumValue(device.device, enumName);

        return returnValue;
    }

    public static int alcGetError(org.lwjglx.openal.ALCdevice device) {

        int returnValue = org.lwjgl.openal.ALC10.alcGetError(device.device);

        return returnValue;
    }

    public static void alcGetInteger(org.lwjglx.openal.ALCdevice device, int pname, java.nio.IntBuffer integerdata) {

        org.lwjgl.openal.ALC10.alcGetIntegerv(device.device, pname, integerdata);

    }

    public static java.lang.String alcGetString(org.lwjglx.openal.ALCdevice device, int pname) {

        java.lang.String returnValue = org.lwjgl.openal.ALC10.alcGetString(device.device, pname);

        return returnValue;
    }

    public static boolean alcIsExtensionPresent(org.lwjglx.openal.ALCdevice device, java.lang.String extName) {

        boolean returnValue = org.lwjgl.openal.ALC10.alcIsExtensionPresent(device.device, extName);

        return returnValue;
    }

    public static org.lwjglx.openal.ALCdevice alcOpenDevice(java.lang.String arg0) {

        org.lwjglx.openal.ALCdevice returnValue = new org.lwjglx.openal.ALCdevice(
                org.lwjgl.openal.ALC10.alcOpenDevice(arg0));

        return returnValue;
    }

}
