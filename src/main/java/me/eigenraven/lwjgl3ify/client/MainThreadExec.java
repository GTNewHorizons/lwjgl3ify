package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLInit.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.Platform;

import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Utilities for running code on the main thread for interacting with the SDL video/event subsystem.
 */
public class MainThreadExec {

    public static final boolean IS_MACOS = Platform.get() == Platform.MACOSX;
    private static final RuntimeException NO_EXCEPTION_TOKEN = new RuntimeException("no exception");
    private static final MethodHandle macOsMainSelectorInvoker;
    // Use a custom "main" thread to allow any thread to poll SDL events without deadlocks, on macOS use the main
    // selector instead.
    private static final ExecutorService nonMacOsMainThread;
    private static final @NotNull Thread mainThread;

    static class CallableWithClassLoader<Ret> implements Callable<Ret> {

        private final ClassLoader loader;
        private final Callable<Ret> inner;

        public CallableWithClassLoader(Callable<Ret> inner) {
            this.loader = Thread.currentThread()
                .getContextClassLoader();
            this.inner = inner;
        }

        @Override
        public Ret call() throws Exception {
            final ClassLoader savedLoader = Thread.currentThread()
                .getContextClassLoader();
            Thread.currentThread()
                .setContextClassLoader(loader);
            try {
                return inner.call();
            } finally {
                Thread.currentThread()
                    .setContextClassLoader(savedLoader);
            }
        }
    }

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
            nonMacOsMainThread = null;
        } else {
            nonMacOsMainThread = Executors.newSingleThreadExecutor((runnable) -> {
                final Thread t = new Thread(runnable, "lwjgl3ify-SDL-main");
                t.setDaemon(true);
                t.setContextClassLoader(
                    Thread.currentThread()
                        .getContextClassLoader());
                return t;
            });
        }
        macOsMainSelectorInvoker = invoker;
        final AtomicReference<Thread> mainThreadStorage = new AtomicReference<>();
        if (IS_MACOS) {
            // noinspection Convert2Lambda
            runOnMainSelectorOnMac(new Runnable() {

                @Override
                public void run() {
                    mainThreadStorage.set(Thread.currentThread());
                }
            });
        } else {
            try {
                // Lambdas cause a deadlock on the class initializer monitor here
                // noinspection Convert2Lambda
                Uninterruptibles
                    .getUninterruptibly(nonMacOsMainThread.submit(new CallableWithClassLoader<>(new Callable<>() {

                        @Override
                        public Object call() {
                            mainThreadStorage.set(Thread.currentThread());
                            return null;
                        }
                    })));
            } catch (ExecutionException e) {
                throw Throwables.propagate(e.getCause());
            }
        }
        mainThread = Objects.requireNonNull(mainThreadStorage.get());
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
    private static void runOnMainSelectorOnMac(Runnable r) {
        final ArrayBlockingQueue<Throwable> lock = new ArrayBlockingQueue<>(1);
        final ClassLoader outerLoader = Thread.currentThread()
            .getContextClassLoader();
        final Throwable noExceptionToken = NO_EXCEPTION_TOKEN;
        // noinspection Convert2Lambda
        jdkPerformOnMainThreadAfterDelay(new Runnable() {

            @Override
            public void run() {
                final ClassLoader innerLoader = Thread.currentThread()
                    .getContextClassLoader();
                Thread.currentThread()
                    .setContextClassLoader(outerLoader);
                try {
                    r.run();
                    lock.add(noExceptionToken);
                } catch (Throwable t) {
                    lock.add(t);
                } finally {
                    Thread.currentThread()
                        .setContextClassLoader(innerLoader);
                }
            }
        }, 0);
        while (true) {
            try {
                final Throwable ex = lock.take();
                if (ex != noExceptionToken) {
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
     * @param r The Callable to run either on the main selector thread on macOS, or current thread on other platforms.
     * @return The value produced by the callable.
     */
    private static <ReturnType> ReturnType runOnMainSelectorOnMac(Callable<ReturnType> r) {
        final AtomicReference<ReturnType> output = new AtomicReference<>(null);
        // noinspection Convert2Lambda
        final Runnable wrapper = new Runnable() {

            @Override
            public void run() {
                try {
                    output.set(r.call());
                } catch (Exception e) {
                    throw Throwables.propagate(e);
                }
            }
        };
        runOnMainSelectorOnMac(wrapper);
        return output.get();
    }

    public static void ensureInitialised() {}

    /**
     * @return If the current thread is the main thread that can run thread-specific SDL commands.
     */
    public static boolean isMainThread() {
        return Thread.currentThread() == mainThread;
    }

    private static <R> Callable<R> bindClassloader(Callable<R> callable) {
        return new CallableWithClassLoader<>(callable);
    }

    /**
     * @param r The Runnable to run on the main thread - if the current thread is main, it gets run immediately.
     */
    public static void runOnMainThread(Runnable r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            r.run();
        } else if (IS_MACOS) {
            runOnMainSelectorOnMac(r);
        } else {
            try {
                Uninterruptibles.getUninterruptibly(nonMacOsMainThread.submit(bindClassloader(Executors.callable(r))));
            } catch (ExecutionException e) {
                throw Throwables.propagate(e.getCause());
            }
        }
    }

    /**
     * Requires SDL to already have been initialized on the correct thread.
     *
     * @param r The Supplier to run on the main thread - if the current thread is main, it gets run immediately.
     * @return The value produced by the supplier.
     */
    public static <ReturnType> @Nullable ReturnType runOnMainThread(Callable<@Nullable ReturnType> r) {
        Objects.requireNonNull(r);
        try {
            if (isMainThread()) {
                return r.call();
            } else if (IS_MACOS) {
                return runOnMainSelectorOnMac(r);
            } else {
                try {
                    return Uninterruptibles.getUninterruptibly(nonMacOsMainThread.submit(bindClassloader(r)));
                } catch (ExecutionException e) {
                    throw Throwables.propagate(e.getCause());
                }
            }
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    public static boolean runOnMainThread(BooleanSupplier r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            return r.getAsBoolean();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Boolean) r.getAsBoolean()));
    }

    public static int runOnMainThread(IntSupplier r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            return r.getAsInt();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Integer) r.getAsInt()));
    }

    public static long runOnMainThread(LongSupplier r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            return r.getAsLong();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Long) r.getAsLong()));
    }

    public static double runOnMainThread(DoubleSupplier r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            return r.getAsDouble();
        }
        return Objects.requireNonNull(runOnMainThread(() -> (Double) r.getAsDouble()));
    }
}
