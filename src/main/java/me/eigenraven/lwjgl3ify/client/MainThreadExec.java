package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.sdl.SDLError.*;
import static org.lwjgl.sdl.SDLInit.*;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.Platform;

import com.google.common.base.Throwables;
import com.gtnewhorizons.retrofuturabootstrap.MainStartOnFirstThread;

/**
 * Utilities for running code on the main thread for interacting with the SDL video/event subsystem.
 */
public class MainThreadExec {

    public static final boolean IS_MACOS = Platform.get() == Platform.MACOSX;
    private static final ExecutorService executor = MainStartOnFirstThread.instance();
    private static final Thread mainThread;

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
        final AtomicReference<Thread> mainThreadStorage = new AtomicReference<>();
        // Lambdas cause a deadlock on the class initializer monitor here
        // noinspection Convert2Lambda
        futureGet(executor.submit(new CallableWithClassLoader<>(new Callable<>() {

            @Override
            public Object call() {
                mainThreadStorage.set(Thread.currentThread());
                return null;
            }
        })));
        mainThread = Objects.requireNonNull(mainThreadStorage.get());
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

    private static <V> V futureGet(Future<V> future) {
        while (true) {
            try {
                return future.get();
            } catch (ExecutionException e) {
                throw Throwables.propagate(e.getCause());
            } catch (InterruptedException e) {
                // continue
            }
        }
    }

    /**
     * @param r The Runnable to run on the main thread - if the current thread is main, it gets run immediately.
     */
    public static void runOnMainThread(Runnable r) {
        Objects.requireNonNull(r);
        if (isMainThread()) {
            r.run();
        } else {
            futureGet(executor.submit(bindClassloader(Executors.callable(r))));
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
            } else {
                return futureGet(executor.submit(bindClassloader(r)));
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
