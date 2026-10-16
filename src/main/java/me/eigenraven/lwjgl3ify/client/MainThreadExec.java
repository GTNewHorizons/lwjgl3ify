package me.eigenraven.lwjgl3ify.client;

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

    private static <R> R submit(Callable<R> callable) {
        return futureGet(executor.submit(new CallableWithClassLoader<>(callable)));
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
            submit(Executors.callable(r));
        }
    }

    /**
     * Requires SDL to already have been initialized on the correct thread.
     *
     * @param r   The Supplier to run on the main thread - if the current thread is main, it gets run immediately.
     * @param <R> The supplier return type
     * @return The value produced by the supplier.
     */
    public static <R> @Nullable R runOnMainThread(Callable<@Nullable R> r) {
        Objects.requireNonNull(r);
        try {
            return isMainThread() ? r.call() : submit(r);
        } catch (Exception e) {
            throw Throwables.propagate(e);
        }
    }

    public static boolean runOnMainThread(BooleanSupplier r) {
        Objects.requireNonNull(r);
        return isMainThread() ? r.getAsBoolean() : submit(r::getAsBoolean);
    }

    public static int runOnMainThread(IntSupplier r) {
        Objects.requireNonNull(r);
        return isMainThread() ? r.getAsInt() : submit(r::getAsInt);
    }

    public static long runOnMainThread(LongSupplier r) {
        Objects.requireNonNull(r);
        return isMainThread() ? r.getAsLong() : submit(r::getAsLong);
    }

    public static double runOnMainThread(DoubleSupplier r) {
        Objects.requireNonNull(r);
        return isMainThread() ? r.getAsDouble() : submit(r::getAsDouble);
    }
}
