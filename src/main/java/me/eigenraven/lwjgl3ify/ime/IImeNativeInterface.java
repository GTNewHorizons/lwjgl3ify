package me.eigenraven.lwjgl3ify.ime;

import java.io.Closeable;

public interface IImeNativeInterface extends Closeable {

    boolean isCompositionEnabled();
}
