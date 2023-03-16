package me.eigenraven.lwjgl3ify.ime.impl;

import java.io.IOException;

import me.eigenraven.lwjgl3ify.ime.IImeNativeInterface;

public class DummyIme implements IImeNativeInterface {

    public DummyIme() {
        System.err.println("Creating a dummy IME implementation, CJK input might not work as intended");
    }

    @Override
    public void close() throws IOException {}

    @Override
    public boolean isCompositionEnabled() {
        return false;
    }
}
