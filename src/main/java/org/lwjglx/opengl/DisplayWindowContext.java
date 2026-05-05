package org.lwjglx.opengl;

import com.github.bsideup.jabel.Desugar;

@Desugar
public record DisplayWindowContext(int props, long window, long glContext, PixelFormat pixelFormat,
    ContextAttribs attribs, DisplayMode mode, String windowTitle, boolean glContextEnabled) {}
