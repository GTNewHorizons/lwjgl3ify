package me.eigenraven.lwjgl3ify.ime;

import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;
import me.eigenraven.lwjgl3ify.ime.impl.DummyIme;
import me.eigenraven.lwjgl3ify.ime.impl.LinuxIme;

import org.lwjgl.system.Platform;

@Lwjgl3Aware
public class ImeNativeInterface {

    public static IImeNativeInterface make() {
        try {
            return switch (Platform.get()) {
                case LINUX -> new LinuxIme();
                default -> new DummyIme();
            };
        } catch (Exception e) {
            System.err.println("Could not construct a native platform IME wrapper: " + e);
            e.printStackTrace();
            return new DummyIme();
        }
    }
}
