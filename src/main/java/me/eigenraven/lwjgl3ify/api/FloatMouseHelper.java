package me.eigenraven.lwjgl3ify.api;

/**
 * Implemented by MouseHelper to support floating point mouse movements.
 */
public interface FloatMouseHelper {

    int lwjgl3ify$getIntDX();

    int lwjgl3ify$getIntDY();

    void lwjgl3ify$setIntDX(int value);

    void lwjgl3ify$setIntDY(int value);

    float lwjgl3ify$getFloatDX();

    float lwjgl3ify$getFloatDY();

    void lwjgl3ify$setFloatDX(float value);

    void lwjgl3ify$setFloatDY(float value);
}
