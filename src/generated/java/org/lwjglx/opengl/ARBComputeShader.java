package org.lwjglx.opengl;

public class ARBComputeShader {
    public static void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
        org.lwjgl.opengl.ARBComputeShader.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z);
    }

    public static void glDispatchComputeIndirect(long indirect) {
        org.lwjgl.opengl.ARBComputeShader.glDispatchComputeIndirect(indirect);
    }
}
