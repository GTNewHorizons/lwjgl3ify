package me.eigenraven.lwjgl3ify.ime.impl;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.libffi.LibFFI.*;

import java.io.IOException;
import java.nio.ByteBuffer;

import me.eigenraven.lwjgl3ify.UnsafeHacks;
import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;
import me.eigenraven.lwjgl3ify.ime.IImeNativeInterface;

import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeX11;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.linux.X11;
import org.lwjglx.opengl.Display;

import sun.misc.Unsafe;

@Lwjgl3Aware
public class LinuxIme implements IImeNativeInterface {

    private static final Unsafe UNSAFE = UnsafeHacks.UNSAFE;
    private static final int POINTER_SIZE = Pointer.POINTER_SIZE;

    private final long xicPtr;

    private final long XVaCreateNestedList_PFN, XGetICValues_PFN;
    private final FFICIF XVaCreateNestedList_CIF, XGetICValues_CIF;
    private static final ByteBuffer XNPreeditState = memASCII("preeditState");
    private static final ByteBuffer XNPreeditAttributes = memASCII("preeditAttributes");
    private static final long XIMPreeditUnKnown = 0;
    private static final long XIMPreeditEnable = 1;
    private static final long XIMPreeditDisable = 2;

    private static long peekPointer(long address) {
        return switch (POINTER_SIZE) {
            case 4 -> UNSAFE.getInt(address);
            case 8 -> UNSAFE.getLong(address);
            default -> throw new UnsupportedOperationException("Pointer size is " + POINTER_SIZE);
        };
    }

    public LinuxIme() {
        final long glfwWindowPtr = Display.getWindow();
        GLFW.glfwPollEvents();
        final long x11Window = GLFWNativeX11.glfwGetX11Window(glfwWindowPtr);

        // On Raven's system it is at 1184 (0x4a0)
        int windowOffset = 0;
        for (int i = 64; i < 2048; i += 4) {
            final int fieldValue = UNSAFE.getInt(glfwWindowPtr + i);
            if (fieldValue == x11Window) {
                windowOffset = i;
                break;
            }
            System.err.flush();
        }
        if (windowOffset == 0) {
            throw new RuntimeException("Can't find the X11 window ID offset.");
        }
        int xicOffset = windowOffset + 2 * POINTER_SIZE;
        // XIC is a pointer
        if ((xicOffset % POINTER_SIZE) != 0) {
            xicOffset += POINTER_SIZE - (xicOffset % POINTER_SIZE);
        }
        xicPtr = glfwWindowPtr + xicOffset;

        SharedLibrary xlib = X11.getLibrary();
        XVaCreateNestedList_PFN = xlib.getFunctionAddress("XVaCreateNestedList");
        if (XVaCreateNestedList_PFN == 0) {
            throw new UnsupportedOperationException("Could not find XVaCreateNestedList");
        }
        XGetICValues_PFN = xlib.getFunctionAddress("XGetICValues");
        if (XGetICValues_PFN == 0) {
            throw new UnsupportedOperationException("Could not find XGetICValues");
        }

        try (MemoryStack stack = MemoryStack.stackPush()) {
            // XVaCreateNestedList(0, XNPreeditState, &state, NULL);
            XVaCreateNestedList_CIF = APIUtil.apiCreateCIFVar(
                    FFI_DEFAULT_ABI,
                    1,
                    ffi_type_pointer,
                    ffi_type_sint32,
                    ffi_type_pointer,
                    ffi_type_pointer,
                    ffi_type_pointer);

            // XGetICValues((void*)XIC, XNPreeditAttributes, (XVaNestedList)pr_atrb, NULL);
            XGetICValues_CIF = APIUtil.apiCreateCIFVar(
                    FFI_DEFAULT_ABI,
                    1,
                    ffi_type_pointer,
                    ffi_type_pointer,
                    ffi_type_pointer,
                    ffi_type_pointer,
                    ffi_type_pointer);
        }

        System.out.println("Linux IME native interface intialized");
    }

    @Override
    public boolean isCompositionEnabled() {
        final long xicValue = peekPointer(xicPtr);

        try (MemoryStack stack = MemoryStack.stackPush()) {
            final PointerBuffer nestedList = stack.callocPointer(1);
            final PointerBuffer state = stack.callocPointer(1);

            {
                final PointerBuffer argValues = stack.pointers(0, memAddress(XNPreeditState), memAddress(state), 0);
                final PointerBuffer args = stack.pointers(
                        memAddress(argValues, 0),
                        memAddress(argValues, 1),
                        memAddress(argValues, 2),
                        memAddress(argValues, 3));

                // nestedList = XVaCreateNestedList(0, XNPreeditState, &state, NULL);
                ffi_call(XVaCreateNestedList_CIF, XVaCreateNestedList_PFN, memByteBuffer(nestedList), args);
            }

            // ret = XGetICValues(xic, XNPreeditAttributes, nestedList, NULL);
            {
                final PointerBuffer argValues = stack
                        .pointers(xicValue, memAddress(XNPreeditAttributes), nestedList.get(0), 0);
                final PointerBuffer ret = stack.callocPointer(1);
                final PointerBuffer args = stack.pointers(
                        memAddress(argValues, 0),
                        memAddress(argValues, 1),
                        memAddress(argValues, 2),
                        memAddress(argValues, 3));
                ffi_call(XGetICValues_CIF, XGetICValues_PFN, memByteBuffer(ret), args);

                X11.nXFree(nestedList.get(0));

                if (ret.get(0) != 0) {
                    System.err.println("Xlib error: " + ret.getStringUTF8(0));
                    return false;
                }
            }

            final long stateValue = state.get(0);

            return stateValue == XIMPreeditEnable;
        }
    }

    @Override
    public void close() throws IOException {
        XVaCreateNestedList_CIF.close();
        XGetICValues_CIF.close();
    }
}
