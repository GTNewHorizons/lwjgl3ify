package org.lwjglx.opengl;

public class ARBES2Compatibility {
    public static void glClearDepthf(float d) {
        org.lwjgl.opengl.ARBES2Compatibility.glClearDepthf(d);
    }

    public static void glDepthRangef(float n, float f) {
        org.lwjgl.opengl.ARBES2Compatibility.glDepthRangef(n, f);
    }

    public static void glGetShaderPrecisionFormat(
            int shadertype, int precisiontype, java.nio.IntBuffer range, java.nio.IntBuffer precision) {
        org.lwjgl.opengl.ARBES2Compatibility.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
    }

    public static void glReleaseShaderCompiler() {
        org.lwjgl.opengl.ARBES2Compatibility.glReleaseShaderCompiler();
    }

    public static void glShaderBinary(java.nio.IntBuffer shaders, int binaryformat, java.nio.ByteBuffer binary) {
        org.lwjgl.opengl.ARBES2Compatibility.glShaderBinary(shaders, binaryformat, binary);
    }
}
