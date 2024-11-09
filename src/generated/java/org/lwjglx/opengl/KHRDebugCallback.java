package org.lwjglx.opengl;

import org.lwjgl.opengl.GLDebugMessageCallback;
import org.lwjgl.opengl.GLDebugMessageCallbackI;

public class KHRDebugCallback extends org.lwjglx.PointerWrapperAbstract implements GLDebugMessageCallbackI {

    /** Severity levels. */
    private static final int GL_DEBUG_SEVERITY_HIGH = 0x9146, GL_DEBUG_SEVERITY_MEDIUM = 0x9147,
        GL_DEBUG_SEVERITY_LOW = 0x9148, GL_DEBUG_SEVERITY_NOTIFICATION = 0x826B;

    /** Sources. */
    private static final int GL_DEBUG_SOURCE_API = 0x8246, GL_DEBUG_SOURCE_WINDOW_SYSTEM = 0x8247,
        GL_DEBUG_SOURCE_SHADER_COMPILER = 0x8248, GL_DEBUG_SOURCE_THIRD_PARTY = 0x8249,
        GL_DEBUG_SOURCE_APPLICATION = 0x824A, GL_DEBUG_SOURCE_OTHER = 0x824B;

    /** Types. */
    private static final int GL_DEBUG_TYPE_ERROR = 0x824C, GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 0x824D,
        GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 0x824E, GL_DEBUG_TYPE_PORTABILITY = 0x824F,
        GL_DEBUG_TYPE_PERFORMANCE = 0x8250, GL_DEBUG_TYPE_OTHER = 0x8251, GL_DEBUG_TYPE_MARKER = 0x8268;

    private static final long CALLBACK_POINTER;

    static {
        long pointer = 0;
        try {
            // Call reflectively so that we can compile this class for the Generator.
            pointer = (Long) Class.forName("org.lwjgl.opengl.CallbackUtil")
                .getDeclaredMethod("getDebugCallbackKHR")
                .invoke(null);
        } catch (Exception e) {
            // ignore
        }
        CALLBACK_POINTER = pointer;
    }

    private final Handler handler;

    /**
     * Creates an KHRebugCallback with a default callback handler.
     * The default handler will simply print the message on System.err.
     */
    public KHRDebugCallback() {
        this(new Handler() {

            public void handleMessage(final int source, final int type, final int id, final int severity,
                final String message) {
                System.err.println("[LWJGL] KHR_debug message");
                System.err.println("\tID: " + id);

                String description = null;
                switch (source) {
                    case GL_DEBUG_SOURCE_API:
                        description = "API";
                        break;
                    case GL_DEBUG_SOURCE_WINDOW_SYSTEM:
                        description = "WINDOW SYSTEM";
                        break;
                    case GL_DEBUG_SOURCE_SHADER_COMPILER:
                        description = "SHADER COMPILER";
                        break;
                    case GL_DEBUG_SOURCE_THIRD_PARTY:
                        description = "THIRD PARTY";
                        break;
                    case GL_DEBUG_SOURCE_APPLICATION:
                        description = "APPLICATION";
                        break;
                    case GL_DEBUG_SOURCE_OTHER:
                        description = "OTHER";
                        break;
                    default:
                        description = printUnknownToken(source);
                        break;
                };
                System.err.println("\tSource: " + description);

                description = null;
                switch (type) {
                    case GL_DEBUG_TYPE_ERROR:
                        description = "ERROR";
                        break;
                    case GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR:
                        description = "DEPRECATED BEHAVIOR";
                        break;
                    case GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR:
                        description = "UNDEFINED BEHAVIOR";
                        break;
                    case GL_DEBUG_TYPE_PORTABILITY:
                        description = "PORTABILITY";
                        break;
                    case GL_DEBUG_TYPE_PERFORMANCE:
                        description = "PERFORMANCE";
                        break;
                    case GL_DEBUG_TYPE_OTHER:
                        description = "OTHER";
                        break;
                    case GL_DEBUG_TYPE_MARKER:
                        description = "MARKER";
                        break;
                    default:
                        description = printUnknownToken(type);
                        break;
                };
                System.err.println("\tType: " + description);

                description = null;
                switch (severity) {
                    case GL_DEBUG_SEVERITY_HIGH:
                        description = "HIGH";
                        break;
                    case GL_DEBUG_SEVERITY_MEDIUM:
                        description = "MEDIUM";
                        break;
                    case GL_DEBUG_SEVERITY_LOW:
                        description = "LOW";
                        break;
                    case GL_DEBUG_SEVERITY_NOTIFICATION:
                        description = "NOTIFICATION";
                        break;
                    default:
                        description = printUnknownToken(severity);
                        break;
                };
                System.err.println("\tSeverity: " + description);

                System.err.println("\tMessage: " + message);
            }

            private String printUnknownToken(final int token) {
                return "Unknown (0x" + Integer.toHexString(token)
                    .toUpperCase() + ")";
            }
        });
    }

    /**
     * Creates an ARBDebugOutputCallback with the specified callback handler.
     * The handler's {@code handleMessage} method will be called whenever
     * debug output is generated by the GL.
     *
     * @param handler the callback handler
     */
    public KHRDebugCallback(final Handler handler) {
        super(CALLBACK_POINTER);

        this.handler = handler;
    }

    Handler getHandler() {
        return handler;
    }

    @Override
    public void invoke(int source, int type, int id, int severity, int length, long message, long userParam) {
        if (this.handler == null) {
            return;
        }
        this.handler.handleMessage(source, type, id, severity, GLDebugMessageCallback.getMessage(length, message));
    }

    @Override
    public long address() {
        return GLDebugMessageCallbackI.super.address();
    }

    /** Implementations of this interface can be used to receive ARB_debug_output notifications. */
    public interface Handler {

        /**
         * This method will be called when an ARB_debug_output message is generated.
         *
         * @param source   the message source
         * @param type     the message type
         * @param id       the message ID
         * @param severity the message severity
         * @param message  the string representation of the message.
         */
        void handleMessage(int source, int type, int id, int severity, String message);

    }

}
