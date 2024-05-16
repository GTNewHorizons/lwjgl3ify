package me.eigenraven.lwjgl3ify.api;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryStack;
import org.lwjglx.opengl.Display;

import com.github.bsideup.jabel.Desugar;

/**
 * Provides access to a debug overlay toggleable with a keybind, using
 * <a href="https://immediate-mode-ui.github.io/Nuklear/doc/index.html">Nuklear</a> for a nice immediate mode UI API.
 */
public final class DebugUi {

    /**
     * Implement to add custom debug UI components
     */
    public interface DebugUiProvider {

        /**
         * Draw the debug UI here.
         * 
         * @param ctx         The Nuklear context to draw to
         * @param interactive Whether the currently drawn UI is interactive (true), or background HUD (false)
         */
        void onDebugUiDraw(NkContext ctx, boolean interactive);
    }

    /**
     * Adds a new debug UI provider
     * 
     * @param name     Name of the UI, appears in the toggle list
     * @param provider The provider to register
     */
    public static void registerProvider(String name, DebugUiProvider provider) {
        providers.add(new ProviderRecord(name, provider, new AtomicBoolean(false)));
    }

    /**
     * Renders all GUIs from the registered providers.
     * 
     * @param ctx         The Nuklear context
     * @param interactive Whether the currently drawn UI is interactive (true), or background HUD (false)
     */
    public static void drawAll(NkContext ctx, boolean interactive) {
        try (final MemoryStack stack = MemoryStack.stackPush()) {
            if (interactive && nk_begin_titled(
                ctx,
                "lwjgl3ify.debugToggles",
                "Views",
                NkRect.malloc(stack)
                    .set(Display.getWidth() - 256 - 8, 8, 256, 256),
                NK_WINDOW_SCALE_LEFT | NK_WINDOW_SCALABLE | NK_WINDOW_MINIMIZABLE | NK_WINDOW_MOVABLE)) {
                final ByteBuffer active = stack.bytes((byte) 0);
                nk_layout_row_dynamic(ctx, 16.0f, 1);
                for (final ProviderRecord record : providers) {
                    active.put(0, record.visible.get() ? (byte) 1 : (byte) 0);
                    nk_checkbox_label(ctx, record.name, active);
                    record.visible.set(active.get(0) == 1);
                }
            }
            nk_end(ctx);
        }

        for (final ProviderRecord record : providers) {
            if (record.visible()
                .get()) {
                record.provider()
                    .onDebugUiDraw(ctx, interactive);
            }
        }
    }

    private static final ArrayList<ProviderRecord> providers = new ArrayList<>();

    @Desugar
    private record ProviderRecord(String name, DebugUiProvider provider, AtomicBoolean visible) {}
}
