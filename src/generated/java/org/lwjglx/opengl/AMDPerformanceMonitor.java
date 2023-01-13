package org.lwjglx.opengl;

public class AMDPerformanceMonitor {
    public static void glBeginPerfMonitorAMD(int arg0) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glBeginPerfMonitorAMD(arg0);
    }

    public static void glDeletePerfMonitorsAMD(int arg0) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glDeletePerfMonitorsAMD(arg0);
    }

    public static void glDeletePerfMonitorsAMD(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glDeletePerfMonitorsAMD(arg0);
    }

    public static void glEndPerfMonitorAMD(int arg0) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glEndPerfMonitorAMD(arg0);
    }

    public static int glGenPerfMonitorsAMD() {
        return org.lwjgl.opengl.AMDPerformanceMonitor.glGenPerfMonitorsAMD();
    }

    public static void glGenPerfMonitorsAMD(java.nio.IntBuffer arg0) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGenPerfMonitorsAMD(arg0);
    }

    public static void glGetPerfMonitorCounterDataAMD(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCounterDataAMD(arg0, arg1, arg2, arg3);
    }

    public static void glGetPerfMonitorCounterInfoAMD(int arg0, int arg1, int arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCounterInfoAMD(arg0, arg1, arg2, arg3);
    }

    public static void glGetPerfMonitorCounterStringAMD(int arg0, int arg1, java.nio.IntBuffer arg2, java.nio.ByteBuffer arg3) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCounterStringAMD(arg0, arg1, arg2, arg3);
    }

    public static void glGetPerfMonitorCountersAMD(int arg0, java.nio.IntBuffer arg1, java.nio.IntBuffer arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCountersAMD(arg0, arg1, arg2, arg3);
    }

    public static void glGetPerfMonitorGroupStringAMD(int arg0, java.nio.IntBuffer arg1, java.nio.ByteBuffer arg2) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorGroupStringAMD(arg0, arg1, arg2);
    }

    public static void glGetPerfMonitorGroupsAMD(java.nio.IntBuffer arg0, java.nio.IntBuffer arg1) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorGroupsAMD(arg0, arg1);
    }

    public static void glSelectPerfMonitorCountersAMD(int arg0, boolean arg1, int arg2, int arg3) {

        org.lwjgl.opengl.AMDPerformanceMonitor.glSelectPerfMonitorCountersAMD(arg0, arg1, arg2, new int[]{arg3});

    }

    public static void glSelectPerfMonitorCountersAMD(int arg0, boolean arg1, int arg2, java.nio.IntBuffer arg3) {
        org.lwjgl.opengl.AMDPerformanceMonitor.glSelectPerfMonitorCountersAMD(arg0, arg1, arg2, arg3);
    }


}
