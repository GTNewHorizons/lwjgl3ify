package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLInit.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.sdl.SDL_MainThreadCallback;
import org.lwjgl.system.Platform;

/**
 * Utilities for running code on the main thread for interacting with the SDL video/event subsystem.
 */
public class MainThreadExec {

    public static final boolean IS_MACOS = Platform.get() == Platform.MACOSX;
    private static final RuntimeException NO_EXCEPTION_TOKEN = new RuntimeException("no exception");
    private static final MethodHandle macOsMainSelectorInvoker;

    static {
        MethodHandle invoker = null;
        if (IS_MACOS) {
            try {
                final Class<?> lwcToolkit = Class.forName("sun.lwawt.macosx.LWCToolkit");
                final Method performOnMainThreadAfterDelay = lwcToolkit
                    .getDeclaredMethod("performOnMainThreadAfterDelay", Runnable.class, long.class);
                performOnMainThreadAfterDelay.setAccessible(true);
                invoker = MethodHandles.lookup()
                    .unreflect(performOnMainThreadAfterDelay);
            } catch (Throwable t) {
                throw new IllegalStateException(t);
            }
        }
        macOsMainSelectorInvoker = invoker;
    }

    private static void jdkPerformOnMainThreadAfterDelay(Runnable r, long delayMs) {
        if (macOsMainSelectorInvoker == null) {
            throw new UnsupportedOperationException();
        } else {
            try {
                macOsMainSelectorInvoker.invokeExact((Runnable) r, (long) delayMs);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }
    }

    /**
     * @param r The Runnable to run either on the main selector thread on macOS, or current thread on other platforms.
     */
    public static void runOnMainSelectorOnMac(Runnable r) {
        if (!IS_MACOS) {
            r.run();
            return;
        }
        final ArrayBlockingQueue<Throwable> lock = new ArrayBlockingQueue<>(1);
        final ClassLoader outerLoader = Thread.currentThread()
            .getContextClassLoader();
        jdkPerformOnMainThreadAfterDelay(() -> {
            final ClassLoader innerLoader = Thread.currentThread()
                .getContextClassLoader();
            Thread.currentThread()
                .setContextClassLoader(outerLoader);
            try {
                r.run();
                lock.add(NO_EXCEPTION_TOKEN);
            } catch (Throwable t) {
                lock.add(t);
            } finally {
                Thread.currentThread()
                    .setContextClassLoader(innerLoader);
            }
        }, 0);
        while (true) {
            try {
                final Throwable ex = lock.take();
                if (ex != NO_EXCEPTION_TOKEN) {
                    throw new RuntimeException("Exception occurred on the main selector thread", ex);
                } else {
                    break;
                }
            } catch (InterruptedException iex) {
                // try again
            }
        }
    }

    /**
     * @param r The Supplier to run either on the main selector thread on macOS, or current thread on other platforms.
     * @return The value produced by the supplier.
     */
    public static <ReturnType> ReturnType runOnMainSelectorOnMac(Supplier<ReturnType> r) {
        final AtomicReference<ReturnType> output = new AtomicReference<>(null);
        final Runnable wrapper = () -> { output.set(r.get()); };
        runOnMainSelectorOnMac(wrapper);
        return output.get();
    }

    /**
     * Requires SDL to already have been initialized on the correct thread.
     *
     * @param r The Runnable to run on the main thread - if the current thread is main, it gets run immediately.
     */
    public static void runOnMainThread(Runnable r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            r.run();
        } else if (IS_MACOS) {
            runOnMainSelectorOnMac(r);
        } else {
            final int runHandle = allocateRunHandle(r);
            if (!SDL_RunOnMainThread(mtCallback, runHandle, true)) {
                throw new RuntimeException("Could not SDL_RunOnMainThread: " + SDL_GetError());
            }
            dequeueAndThrowException(runHandle);
        }
    }

    /**
     * Requires SDL to already have been initialized on the correct thread.
     *
     * @param r The Supplier to run on the main thread - if the current thread is main, it gets run immediately.
     * @return The value produced by the supplier.
     */
    public static <ReturnType> @Nullable ReturnType runOnMainThread(Supplier<@Nullable ReturnType> r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            return r.get();
        } else if (IS_MACOS) {
            return runOnMainSelectorOnMac(r);
        } else {
            final AtomicReference<ReturnType> output = new AtomicReference<>(null);
            final Runnable wrapper = () -> { output.set(r.get()); };
            final int runHandle = allocateRunHandle(wrapper);
            if (!SDL_RunOnMainThread(mtCallback, runHandle, true)) {
                throw new RuntimeException("Could not SDL_RunOnMainThread: " + SDL_GetError());
            }
            dequeueAndThrowException(runHandle);
            return output.get();
        }
    }

    public static boolean runOnMainThread(BooleanSupplier r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            return r.getAsBoolean();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Boolean) r.getAsBoolean()));
    }

    public static int runOnMainThread(IntSupplier r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            return r.getAsInt();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Integer) r.getAsInt()));
    }

    public static long runOnMainThread(LongSupplier r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            return r.getAsLong();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Long) r.getAsLong()));
    }

    public static double runOnMainThread(DoubleSupplier r) {
        Objects.requireNonNull(r);
        if (SDL_IsMainThread()) {
            return r.getAsDouble();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Double) r.getAsDouble()));
    }

    private static final AtomicReferenceArray<Runnable> runHandles = new AtomicReferenceArray<>(256);
    private static final List<ArrayBlockingQueue<Throwable>> exceptionQueues = IntStream.range(0, runHandles.length())
        .mapToObj(i -> new ArrayBlockingQueue<Throwable>(1))
        .collect(Collectors.toList());
    private static final SDL_MainThreadCallback mtCallback = SDL_MainThreadCallback
        .create(MainThreadExec::mtCallbackImpl);

    private static void mtCallbackImpl(long userdata) {
        final int handle = (int) userdata;
        Throwable exception = NO_EXCEPTION_TOKEN;
        try {
            final Runnable runHandle = deallocateRunHandle(handle);
            runHandle.run();
        } catch (Throwable t) {
            exception = t;
        }
        while (true) {
            try {
                exceptionQueues.get(handle)
                    .put(exception);
                break;
            } catch (InterruptedException e) {
                // continue
            }
        }
    }

    private static int allocateRunHandle(@NotNull Runnable handle) {
        Objects.requireNonNull(handle);
        for (int i = 0; i < 256; i++) {
            if (runHandles.compareAndSet(i, null, handle)) {
                return i;
            }
        }
        throw new IllegalStateException(
            "More than " + runHandles.length()
                + " threads attempted to queue operations on the SDL main thread simultaneously");
    }

    private static @NotNull Runnable deallocateRunHandle(int h) {
        final Runnable o = runHandles.getAndSet(h, null);
        Objects.requireNonNull(o, "Invalid handle " + h);
        return o;
    }

    private static void dequeueAndThrowException(int runHandle) {
        final ArrayBlockingQueue<Throwable> queue = exceptionQueues.get(runHandle);
        while (true) {
            try {
                final Throwable ex = queue.take();
                if (ex != NO_EXCEPTION_TOKEN) {
                    throw new RuntimeException("Exception occurred on the main selector thread", ex);
                } else {
                    break;
                }
            } catch (InterruptedException iex) {
                // try again
            }
        }
    }
}
