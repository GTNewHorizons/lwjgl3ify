package me.eigenraven.lwjgl3ify.client;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallback;

public class GLDebugLog {

    private static void printDetail(java.io.PrintStream stream, String type, String message) {
        stream.printf("  %s: %s\n", type, message);
    }

    private static void trace(java.util.function.Consumer<String> output) {
        /*
         * We can not just use a fixed stacktrace element offset, because some methods
         * are intercepted and some are not. So, check the package name.
         */
        StackTraceElement[] elems = filterStackTrace(new Throwable(), 4).getStackTrace();
        for (StackTraceElement ste : elems) {
            output.accept(ste.toString());
        }
    }

    public static Throwable filterStackTrace(Throwable throwable, int offset) {
        StackTraceElement[] elems = throwable.getStackTrace();
        StackTraceElement[] filtered = new StackTraceElement[elems.length];
        int j = 0;
        for (int i = offset; i < elems.length; i++) {
            String className = elems[i].getClassName();
            if (className == null) {
                className = "";
            }
            filtered[j++] = elems[i];
        }
        StackTraceElement[] newElems = new StackTraceElement[j];
        System.arraycopy(filtered, 0, newElems, 0, j);
        throwable.setStackTrace(newElems);
        return throwable;
    }

    private static void printTrace(java.io.PrintStream stream) {
        trace(new java.util.function.Consumer<String>() {

            boolean first = true;

            public void accept(String str) {
                if (first) {
                    printDetail(stream, "Stacktrace", str);
                    first = false;
                } else {
                    printDetailLine(stream, "Stacktrace", str);
                }
            }
        });
    }

    private static void printDetailLine(java.io.PrintStream stream, String type, String message) {
        stream.append("    ");
        for (int i = 0; i < type.length(); i++) {
            stream.append(" ");
        }
        stream.append(message)
            .append("\n");
    }

    private static String getDebugSource(int source) {
        switch (source) {
            case GL43.GL_DEBUG_SOURCE_API:
                return "API";
            case GL43.GL_DEBUG_SOURCE_WINDOW_SYSTEM:
                return "WINDOW SYSTEM";
            case GL43.GL_DEBUG_SOURCE_SHADER_COMPILER:
                return "SHADER COMPILER";
            case GL43.GL_DEBUG_SOURCE_THIRD_PARTY:
                return "THIRD PARTY";
            case GL43.GL_DEBUG_SOURCE_APPLICATION:
                return "APPLICATION";
            case GL43.GL_DEBUG_SOURCE_OTHER:
                return "OTHER";
            default:
                return String.format("Unknown [0x%X]", source);
        }
    }

    private static String getDebugType(int type) {
        switch (type) {
            case GL43.GL_DEBUG_TYPE_ERROR:
                return "ERROR";
            case GL43.GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR:
                return "DEPRECATED BEHAVIOR";
            case GL43.GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR:
                return "UNDEFINED BEHAVIOR";
            case GL43.GL_DEBUG_TYPE_PORTABILITY:
                return "PORTABILITY";
            case GL43.GL_DEBUG_TYPE_PERFORMANCE:
                return "PERFORMANCE";
            case GL43.GL_DEBUG_TYPE_OTHER:
                return "OTHER";
            case GL43.GL_DEBUG_TYPE_MARKER:
                return "MARKER";
            default:
                return String.format("Unknown [0x%X]", type);
        }
    }

    private static String getDebugSeverity(int severity) {
        switch (severity) {
            case GL43.GL_DEBUG_SEVERITY_NOTIFICATION:
                return "NOTIFICATION";
            case GL43.GL_DEBUG_SEVERITY_HIGH:
                return "HIGH";
            case GL43.GL_DEBUG_SEVERITY_MEDIUM:
                return "MEDIUM";
            case GL43.GL_DEBUG_SEVERITY_LOW:
                return "LOW";
            default:
                return String.format("Unknown [0x%X]", severity);
        }
    }

    public static void setupDebugMessageCallback() {
        GLCapabilities caps = GL.getCapabilities();
        final java.io.PrintStream stream = org.lwjgl.system.APIUtil.DEBUG_STREAM;
        if (caps.OpenGL43) {
            org.lwjgl.system.APIUtil.apiLog("[GL] Using OpenGL 4.3 for error logging.");
            GLDebugMessageCallback proc = GLDebugMessageCallback
                .create((source, type, id, severity, length, message, userParam) -> {
                    String level;
                    if (severity == GL43.GL_DEBUG_SEVERITY_NOTIFICATION) {
                        // skip
                        return;
                    }
                    if (severity == GL43.GL_DEBUG_SEVERITY_LOW) level = "info ";
                    else if (severity == GL43.GL_DEBUG_SEVERITY_MEDIUM) level = "warn ";
                    else level = "error";
                    stream.println("[" + level + "] OpenGL debug message");
                    printDetail(stream, "ID", String.format("0x%X", id));
                    printDetail(stream, "Source", getDebugSource(source));
                    printDetail(stream, "Type", getDebugType(type));
                    printDetail(stream, "Severity", getDebugSeverity(severity));
                    printDetail(stream, "Message", GLDebugMessageCallback.getMessage(length, message));
                    printTrace(stream);

                });
            GL43.glDebugMessageCallback(proc, org.lwjgl.system.MemoryUtil.NULL);
            if ((GL11.glGetInteger(GL43.GL_CONTEXT_FLAGS) & GL43.GL_CONTEXT_FLAG_DEBUG_BIT) == 0) {
                org.lwjgl.system.APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
                GL11.glEnable(GL43.GL_DEBUG_OUTPUT);
            }
            GL11.glEnable(GL43.GL_DEBUG_OUTPUT_SYNCHRONOUS);
        }
    }
}
