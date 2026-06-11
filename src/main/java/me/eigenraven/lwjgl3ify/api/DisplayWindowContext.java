package me.eigenraven.lwjgl3ify.api;

import org.lwjglx.opengl.ContextAttribs;
import org.lwjglx.opengl.DisplayMode;
import org.lwjglx.opengl.PixelFormat;

import com.github.bsideup.jabel.Desugar;

/** Window state for DisplayEvents listeners; props is only valid pre-create, window/glContext only post-create. */
@Desugar
public record DisplayWindowContext(int props, long window, long glContext, PixelFormat pixelFormat,
    ContextAttribs attribs, DisplayMode mode, String windowTitle, boolean glContextEnabled) {}
