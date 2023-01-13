package org.lwjglx.openal;

public class ALC11 {
    public static boolean alcCaptureCloseDevice(org.lwjglx.openal.ALCdevice arg0) {

        boolean returnValue = org.lwjgl.openal.ALC11.alcCaptureCloseDevice(arg0.device);

        return returnValue;
    }

    public static org.lwjglx.openal.ALCdevice alcCaptureOpenDevice(java.lang.String arg0, int arg1, int arg2, int arg3) {

        org.lwjglx.openal.ALCdevice returnValue = new ALCdevice(org.lwjgl.openal.ALC11.alcCaptureOpenDevice(arg0, arg1, arg2, arg3));

        return returnValue;
    }

    public static void alcCaptureSamples(org.lwjglx.openal.ALCdevice arg0, java.nio.ByteBuffer arg1, int arg2) {

        org.lwjgl.openal.ALC11.alcCaptureSamples(arg0.device, arg1, arg2);

    }

    public static void alcCaptureStart(org.lwjglx.openal.ALCdevice arg0) {

        org.lwjgl.openal.ALC11.alcCaptureStart(arg0.device);

    }

    public static void alcCaptureStop(org.lwjglx.openal.ALCdevice arg0) {

        org.lwjgl.openal.ALC11.alcCaptureStop(arg0.device);

    }


}
