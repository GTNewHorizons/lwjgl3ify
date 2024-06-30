package me.eigenraven.lwjgl3ify.redirects;

import java.io.EOFException;
import java.io.IOException;
import java.util.jar.JarEntry;

public final class JarInputStream {

    public static JarEntry getNextJarEntrySafe(final java.util.jar.JarInputStream jis) throws IOException {
        try {
            return jis.getNextJarEntry();
        } catch (EOFException eof) {
            System.err.println("EOF caught while searching for forge patches: " + eof);
            eof.printStackTrace(System.err);
            return null;
        }
    }
}
