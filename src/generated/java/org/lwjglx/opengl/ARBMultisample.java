package org.lwjglx.opengl;

public class ARBMultisample {
    public static final int GL_MULTISAMPLE_ARB = 32925;
    public static final int GL_MULTISAMPLE_BIT_ARB = 536870912;
    public static final int GL_SAMPLES_ARB = 32937;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE_ARB = 32926;
    public static final int GL_SAMPLE_ALPHA_TO_ONE_ARB = 32927;
    public static final int GL_SAMPLE_BUFFERS_ARB = 32936;
    public static final int GL_SAMPLE_COVERAGE_ARB = 32928;
    public static final int GL_SAMPLE_COVERAGE_INVERT_ARB = 32939;
    public static final int GL_SAMPLE_COVERAGE_VALUE_ARB = 32938;

    public static void glSampleCoverageARB(float value, boolean invert) {
        org.lwjgl.opengl.ARBMultisample.glSampleCoverageARB(value, invert);
    }
}
