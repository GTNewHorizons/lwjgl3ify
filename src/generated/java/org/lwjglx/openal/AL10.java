package org.lwjglx.openal;

public class AL10 {

    public static final int AL_BITS = (int) 8194;
    public static final int AL_BUFFER = (int) 4105;
    public static final int AL_BUFFERS_PROCESSED = (int) 4118;
    public static final int AL_BUFFERS_QUEUED = (int) 4117;
    public static final int AL_CHANNELS = (int) 8195;
    public static final int AL_CHANNEL_MASK = (int) 12288;
    public static final int AL_CONE_INNER_ANGLE = (int) 4097;
    public static final int AL_CONE_OUTER_ANGLE = (int) 4098;
    public static final int AL_CONE_OUTER_GAIN = (int) 4130;
    public static final int AL_DATA = (int) 8197;
    public static final int AL_DIRECTION = (int) 4101;
    public static final int AL_DISTANCE_MODEL = (int) 53248;
    public static final int AL_DOPPLER_FACTOR = (int) 49152;
    public static final int AL_DOPPLER_VELOCITY = (int) 49153;
    public static final int AL_EXTENSIONS = (int) 45060;
    public static final int AL_FALSE = (int) 0;
    public static final int AL_FORMAT_MONO16 = (int) 4353;
    public static final int AL_FORMAT_MONO8 = (int) 4352;
    public static final int AL_FORMAT_STEREO16 = (int) 4355;
    public static final int AL_FORMAT_STEREO8 = (int) 4354;
    public static final int AL_FORMAT_VORBIS_EXT = (int) 65539;
    public static final int AL_FREQUENCY = (int) 8193;
    public static final int AL_GAIN = (int) 4106;
    public static final int AL_INITIAL = (int) 4113;
    public static final int AL_INVALID = (int) -1;
    public static final int AL_INVALID_ENUM = (int) 40962;
    public static final int AL_INVALID_NAME = (int) 40961;
    public static final int AL_INVALID_OPERATION = (int) 40964;
    public static final int AL_INVALID_VALUE = (int) 40963;
    public static final int AL_INVERSE_DISTANCE = (int) 53249;
    public static final int AL_INVERSE_DISTANCE_CLAMPED = (int) 53250;
    public static final int AL_LOOPING = (int) 4103;
    public static final int AL_MAX_DISTANCE = (int) 4131;
    public static final int AL_MAX_GAIN = (int) 4110;
    public static final int AL_MIN_GAIN = (int) 4109;
    public static final int AL_NONE = (int) 0;
    public static final int AL_NO_ERROR = (int) 0;
    public static final int AL_ORIENTATION = (int) 4111;
    public static final int AL_OUT_OF_MEMORY = (int) 40965;
    public static final int AL_PAUSED = (int) 4115;
    public static final int AL_PENDING = (int) 8209;
    public static final int AL_PITCH = (int) 4099;
    public static final int AL_PLAYING = (int) 4114;
    public static final int AL_POSITION = (int) 4100;
    public static final int AL_PROCESSED = (int) 8210;
    public static final int AL_REFERENCE_DISTANCE = (int) 4128;
    public static final int AL_RENDERER = (int) 45059;
    public static final int AL_ROLLOFF_FACTOR = (int) 4129;
    public static final int AL_SIZE = (int) 8196;
    public static final int AL_SOURCE_ABSOLUTE = (int) 513;
    public static final int AL_SOURCE_RELATIVE = (int) 514;
    public static final int AL_SOURCE_STATE = (int) 4112;
    public static final int AL_SOURCE_TYPE = (int) 4135;
    public static final int AL_STOPPED = (int) 4116;
    public static final int AL_TRUE = (int) 1;
    public static final int AL_UNUSED = (int) 8208;
    public static final int AL_VELOCITY = (int) 4102;
    public static final int AL_VENDOR = (int) 45057;
    public static final int AL_VERSION = (int) 45058;

    public static void alBufferData(int buffer, int format, java.nio.ByteBuffer data, int freq) {
        org.lwjgl.openal.AL10.alBufferData(buffer, format, data, freq);
    }

    public static void alBufferData(int buffer, int format, java.nio.IntBuffer data, int freq) {
        org.lwjgl.openal.AL10.alBufferData(buffer, format, data, freq);
    }

    public static void alBufferData(int buffer, int format, java.nio.ShortBuffer data, int freq) {
        org.lwjgl.openal.AL10.alBufferData(buffer, format, data, freq);
    }

    public static void alDeleteBuffers(int buffer) {
        org.lwjgl.openal.AL10.alDeleteBuffers(buffer);
    }

    public static void alDeleteBuffers(java.nio.IntBuffer buffers) {
        org.lwjgl.openal.AL10.alDeleteBuffers(buffers);
    }

    public static void alDeleteSources(int source) {
        org.lwjgl.openal.AL10.alDeleteSources(source);
    }

    public static void alDeleteSources(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alDeleteSources(sources);
    }

    public static void alDisable(int capability) {
        org.lwjgl.openal.AL10.alDisable(capability);
    }

    public static void alDistanceModel(int value) {
        org.lwjgl.openal.AL10.alDistanceModel(value);
    }

    public static void alDopplerFactor(float value) {
        org.lwjgl.openal.AL10.alDopplerFactor(value);
    }

    public static void alDopplerVelocity(float value) {
        org.lwjgl.openal.AL10.alDopplerVelocity(value);
    }

    public static void alEnable(int capability) {
        org.lwjgl.openal.AL10.alEnable(capability);
    }

    public static int alGenBuffers() {
        return org.lwjgl.openal.AL10.alGenBuffers();
    }

    public static void alGenBuffers(java.nio.IntBuffer buffers) {
        org.lwjgl.openal.AL10.alGenBuffers(buffers);
    }

    public static int alGenSources() {
        return org.lwjgl.openal.AL10.alGenSources();
    }

    public static void alGenSources(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alGenSources(sources);
    }

    public static boolean alGetBoolean(int pname) {
        return org.lwjgl.openal.AL10.alGetBoolean(pname);
    }

    public static float alGetBufferf(int buffer, int pname) {
        return org.lwjgl.openal.AL10.alGetBufferf(buffer, pname);
    }

    public static int alGetBufferi(int buffer, int pname) {
        return org.lwjgl.openal.AL10.alGetBufferi(buffer, pname);
    }

    public static double alGetDouble(int pname) {
        return org.lwjgl.openal.AL10.alGetDouble(pname);
    }

    public static void alGetDouble(int pname, java.nio.DoubleBuffer data) {
        org.lwjgl.openal.AL10.alGetDoublev(pname, data);
    }

    public static int alGetEnumValue(java.lang.String ename) {

        int returnValue = org.lwjgl.openal.AL10.alGetEnumValue(ename);

        return returnValue;
    }

    public static int alGetError() {
        return org.lwjgl.openal.AL10.alGetError();
    }

    public static float alGetFloat(int pname) {
        return org.lwjgl.openal.AL10.alGetFloat(pname);
    }

    public static void alGetFloat(int pname, java.nio.FloatBuffer data) {
        org.lwjgl.openal.AL10.alGetFloatv(pname, data);
    }

    public static int alGetInteger(int pname) {
        return org.lwjgl.openal.AL10.alGetInteger(pname);
    }

    public static void alGetInteger(int pname, java.nio.IntBuffer data) {
        org.lwjgl.openal.AL10.alGetIntegerv(pname, data);
    }

    public static void alGetListener(int pname, java.nio.FloatBuffer floatdata) {
        org.lwjgl.openal.AL10.alGetListenerfv(pname, floatdata);
    }

    public static float alGetListenerf(int pname) {
        return org.lwjgl.openal.AL10.alGetListenerf(pname);
    }

    public static int alGetListeneri(int pname) {
        return org.lwjgl.openal.AL10.alGetListeneri(pname);
    }

    public static void alGetSource(int source, int pname, java.nio.FloatBuffer floatdata) {
        org.lwjgl.openal.AL10.alGetSourcefv(source, pname, floatdata);
    }

    public static float alGetSourcef(int source, int pname) {
        return org.lwjgl.openal.AL10.alGetSourcef(source, pname);
    }

    public static int alGetSourcei(int source, int pname) {
        return org.lwjgl.openal.AL10.alGetSourcei(source, pname);
    }

    public static java.lang.String alGetString(int pname) {
        return org.lwjgl.openal.AL10.alGetString(pname);
    }

    public static boolean alIsBuffer(int buffer) {
        return org.lwjgl.openal.AL10.alIsBuffer(buffer);
    }

    public static boolean alIsEnabled(int capability) {
        return org.lwjgl.openal.AL10.alIsEnabled(capability);
    }

    public static boolean alIsExtensionPresent(java.lang.String fname) {

        boolean returnValue = org.lwjgl.openal.AL10.alIsExtensionPresent(fname);

        return returnValue;
    }

    public static boolean alIsSource(int id) {
        return org.lwjgl.openal.AL10.alIsSource(id);
    }

    public static void alListener3f(int pname, float v1, float v2, float v3) {
        org.lwjgl.openal.AL10.alListener3f(pname, v1, v2, v3);
    }

    public static void alListener(int pname, java.nio.FloatBuffer value) {
        org.lwjgl.openal.AL10.alListenerfv(pname, value);
    }

    public static void alListenerf(int pname, float value) {
        org.lwjgl.openal.AL10.alListenerf(pname, value);
    }

    public static void alListeneri(int pname, int value) {
        org.lwjgl.openal.AL10.alListeneri(pname, value);
    }

    public static void alSource3f(int source, int pname, float v1, float v2, float v3) {
        org.lwjgl.openal.AL10.alSource3f(source, pname, v1, v2, v3);
    }

    public static void alSource(int source, int pname, java.nio.FloatBuffer value) {
        org.lwjgl.openal.AL10.alSourcefv(source, pname, value);
    }

    public static void alSourcePause(int source) {
        org.lwjgl.openal.AL10.alSourcePause(source);
    }

    public static void alSourcePause(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alSourcePausev(sources);
    }

    public static void alSourcePlay(int source) {
        org.lwjgl.openal.AL10.alSourcePlay(source);
    }

    public static void alSourcePlay(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alSourcePlayv(sources);
    }

    public static void alSourceQueueBuffers(int source, int buffer) {
        org.lwjgl.openal.AL10.alSourceQueueBuffers(source, buffer);
    }

    public static void alSourceQueueBuffers(int source, java.nio.IntBuffer buffers) {
        org.lwjgl.openal.AL10.alSourceQueueBuffers(source, buffers);
    }

    public static void alSourceRewind(int source) {
        org.lwjgl.openal.AL10.alSourceRewind(source);
    }

    public static void alSourceRewind(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alSourceRewindv(sources);
    }

    public static void alSourceStop(int source) {
        org.lwjgl.openal.AL10.alSourceStop(source);
    }

    public static void alSourceStop(java.nio.IntBuffer sources) {
        org.lwjgl.openal.AL10.alSourceStopv(sources);
    }

    public static int alSourceUnqueueBuffers(int source) {
        return org.lwjgl.openal.AL10.alSourceUnqueueBuffers(source);
    }

    public static void alSourceUnqueueBuffers(int source, java.nio.IntBuffer buffers) {
        org.lwjgl.openal.AL10.alSourceUnqueueBuffers(source, buffers);
    }

    public static void alSourcef(int source, int pname, float value) {
        org.lwjgl.openal.AL10.alSourcef(source, pname, value);
    }

    public static void alSourcei(int source, int pname, int value) {
        org.lwjgl.openal.AL10.alSourcei(source, pname, value);
    }

}
