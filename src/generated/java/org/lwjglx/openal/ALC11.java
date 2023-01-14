package org.lwjglx.openal;

public class ALC11 {
    public static boolean alcCaptureCloseDevice(org.lwjglx.openal.ALCdevice device) {

        boolean returnValue = org.lwjgl.openal.ALC11.alcCaptureCloseDevice(device.device);

        return returnValue;
    }

    public static org.lwjglx.openal.ALCdevice alcCaptureOpenDevice(
            java.lang.String arg0, int arg1, int frequency, int format) {

        org.lwjglx.openal.ALCdevice returnValue =
                new ALCdevice(org.lwjgl.openal.ALC11.alcCaptureOpenDevice(arg0, arg1, frequency, format));

        return returnValue;
    }

    public static void alcCaptureSamples(org.lwjglx.openal.ALCdevice device, java.nio.ByteBuffer buffer, int samples) {

        org.lwjgl.openal.ALC11.alcCaptureSamples(device.device, buffer, samples);
    }

    public static void alcCaptureStart(org.lwjglx.openal.ALCdevice device) {

        org.lwjgl.openal.ALC11.alcCaptureStart(device.device);
    }

    public static void alcCaptureStop(org.lwjglx.openal.ALCdevice device) {

        org.lwjgl.openal.ALC11.alcCaptureStop(device.device);
    }
}
