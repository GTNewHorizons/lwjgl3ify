package me.eigenraven.lwjgl3ify.api;

import org.jetbrains.annotations.Nullable;
import org.lwjglx.opengl.DisplayMode;

import com.github.bsideup.jabel.Desugar;

/**
 * Describes a pending change to the SDL window that invalidates the swapchain.
 *
 * @param kind          which kind of mutation triggered the hook
 * @param newFullscreen for {@link Kind#FULLSCREEN}, the requested fullscreen state. Undefined for other kinds.
 * @param newMode       for {@link Kind#DISPLAY_MODE}, the new mode being applied. {@code null} for other kinds.
 */
@Desugar
public record SwapchainInvalidatingChange(Kind kind, boolean newFullscreen, @Nullable DisplayMode newMode) {

    public enum Kind {
        FULLSCREEN,
        DISPLAY_MODE
    }
}
