package me.eigenraven.lwjgl3ify.api;

import java.util.ArrayList;
import java.util.function.Consumer;

import me.eigenraven.lwjgl3ify.Lwjgl3ify;

@SuppressWarnings({ "ForLoopReplaceableByForEach", "unused" })
public class DisplayEvents {

    private static final ArrayList<Consumer<DisplayWindowContext>> preWindowCreateListeners = new ArrayList<>();
    private static final ArrayList<Consumer<DisplayWindowContext>> postWindowCreateListeners = new ArrayList<>();
    private static final ArrayList<Consumer<SwapchainInvalidatingChange>> preSwapchainInvalidatingChangeListeners = new ArrayList<>();

    private static boolean createGLContext = true;

    /** Set before {@code Display.create}; when false no GL context is made and the caller claims the window. */
    public static void setCreateGLContext(boolean enabled) {
        createGLContext = enabled;
    }

    public static boolean isCreateGLContextEnabled() {
        return createGLContext;
    }

    public static void addPreWindowCreateListener(Consumer<DisplayWindowContext> listener) {
        preWindowCreateListeners.add(listener);
    }

    public static void addPostWindowCreateListener(Consumer<DisplayWindowContext> listener) {
        postWindowCreateListeners.add(listener);
    }

    /**
     * Listeners fire synchronously on the thread calling the mutating Display method.
     * Not fired from create/destroy - use the window create listeners for those.
     */
    public static void addPreSwapchainInvalidatingChangeListener(Consumer<SwapchainInvalidatingChange> listener) {
        preSwapchainInvalidatingChangeListeners.add(listener);
    }

    public static void firePreWindowCreate(DisplayWindowContext ctx) {
        fire(preWindowCreateListeners, ctx);
    }

    public static void firePostWindowCreate(DisplayWindowContext ctx) {
        fire(postWindowCreateListeners, ctx);
    }

    public static void firePreSwapchainInvalidatingChange(SwapchainInvalidatingChange change) {
        fire(preSwapchainInvalidatingChangeListeners, change);
    }

    private static <T> void fire(ArrayList<Consumer<T>> listeners, T event) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i)
                    .accept(event);
            } catch (Throwable t) {
                Lwjgl3ify.LOG.error("Display event listener error", t);
            }
        }
    }
}
