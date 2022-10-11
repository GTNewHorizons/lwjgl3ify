package org.lwjglx.opengl;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_DEBUG_CONTEXT;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.glfw.Callbacks.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.glfw.GLFWWindowFocusCallback;
import org.lwjgl.glfw.GLFWWindowIconifyCallback;
import org.lwjgl.glfw.GLFWWindowPosCallback;
import org.lwjgl.glfw.GLFWWindowRefreshCallback;
import org.lwjgl.glfw.*;
import org.lwjglx.LWJGLException;
import org.lwjglx.Sys;
import org.lwjglx.input.Keyboard;
import org.lwjglx.input.Mouse;

public class Display {
	
	private static String windowTitle = "Game";
	
	private static org.lwjgl.opengl.GLContext context;
	
	private static boolean displayCreated = false;
	private static boolean displayFocused = false;
	private static boolean displayVisible = true;
	private static boolean displayDirty = false;
	private static boolean displayResizable = false;
	
	private static DisplayMode mode = new DisplayMode(640, 480);
	private static DisplayMode desktopDisplayMode = new DisplayMode(640, 480);
	
	private static int latestEventKey = 0;
	
	private static int displayX = 0;
	private static int displayY = 0;
	
	private static boolean displayResized = false;
	private static int displayWidth = 0;
	private static int displayHeight = 0;
	private static int displayFramebufferWidth = 0;
	private static int displayFramebufferHeight = 0;
	
	private static boolean latestResized = false;
	private static int latestWidth = 0;
	private static int latestHeight = 0;
	
	static {
		Sys.initialize(); // init using dummy sys method
		
		long monitor = glfwGetPrimaryMonitor();
		ByteBuffer vidmode = glfwGetVideoMode(monitor);
		
		int monitorWidth = GLFWvidmode.width(vidmode);
		int monitorHeight = GLFWvidmode.height(vidmode);
		int monitorBitPerPixel = GLFWvidmode.redBits(vidmode) + GLFWvidmode.greenBits(vidmode) + GLFWvidmode.blueBits(vidmode);
		int monitorRefreshRate = GLFWvidmode.refreshRate(vidmode);
		
		desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);
	}
	
	public static void create(PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
		System.out.println("TODO: Implement Display.create(PixelFormat, Drawable)"); // TODO
		create();
	}
	
	public static void create(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
		System.out.println("TODO: Implement Display.create(PixelFormat, ContextAttribs)"); // TODO
		create();
	}
	
	public static void create(PixelFormat pixel_format) throws LWJGLException {
		System.out.println("TODO: Implement Display.create(PixelFormat)"); // TODO
		create();
	}
	
	public static void create() throws LWJGLException {
		long monitor = glfwGetPrimaryMonitor();
		ByteBuffer vidmode = glfwGetVideoMode(monitor);

		int monitorWidth = GLFWvidmode.width(vidmode);
		int monitorHeight = GLFWvidmode.height(vidmode);
		int monitorBitPerPixel = GLFWvidmode.redBits(vidmode) + GLFWvidmode.greenBits(vidmode) + GLFWvidmode.blueBits(vidmode);
		int monitorRefreshRate = GLFWvidmode.refreshRate(vidmode);
		
		desktopDisplayMode = new DisplayMode(monitorWidth, monitorHeight, monitorBitPerPixel, monitorRefreshRate);

		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, displayResizable ? GL_TRUE : GL_FALSE);
		glfwWindowHint(GLFW_OPENGL_DEBUG_CONTEXT, GL_TRUE);

		
		Window.handle = glfwCreateWindow(mode.getWidth(), mode.getHeight(), windowTitle, NULL, NULL);
		if ( Window.handle == 0L )
			throw new IllegalStateException("Failed to create Display window");
		
		
		Window.keyCallback = new GLFWKeyCallback() {
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				latestEventKey = key;
				
				if (action == GLFW_RELEASE || action == GLFW.GLFW_PRESS) {
					Keyboard.addKeyEvent(key, action == GLFW.GLFW_PRESS ? true : false);
				}
			}
		};
		
		Window.charCallback = new GLFWCharCallback() {
			@Override
			public void invoke(long window, int codepoint) {
				Keyboard.addCharEvent(latestEventKey, (char)codepoint);
			}
		};
		
		Window.cursorPosCallback = new GLFWCursorPosCallback() {
			@Override
			public void invoke(long window, double xpos, double ypos) {
				Mouse.addMoveEvent(xpos, ypos);
			}
		};
		
		Window.mouseButtonCallback = new GLFWMouseButtonCallback() {
			@Override
			public void invoke(long window, int button, int action, int mods) {
				Mouse.addButtonEvent(button, action == GLFW.GLFW_PRESS ? true : false);
			}
		};
		
		Window.windowFocusCallback = new GLFWWindowFocusCallback() {
			@Override
			public void invoke(long window, int focused) {
				displayFocused = focused == GL11.GL_TRUE;
			}
		};
		
		Window.windowIconifyCallback = new GLFWWindowIconifyCallback() {
			@Override
			public void invoke(long window, int iconified) {
				displayVisible = iconified == GL11.GL_FALSE;
			}
		};
		
		Window.windowSizeCallback = new GLFWWindowSizeCallback() {
			@Override
			public void invoke(long window, int width, int height) {
				latestResized = true;
				latestWidth = width;
				latestHeight = height;
			}
		};
		
		Window.windowPosCallback = new GLFWWindowPosCallback() {
			@Override
			public void invoke(long window, int xpos, int ypos) {
				displayX = xpos;
				displayY = ypos;
			}
		};
		
		Window.windowRefreshCallback = new GLFWWindowRefreshCallback() {
			@Override
			public void invoke(long window) {
				displayDirty = true;
			}
		};
		
		Window.framebufferSizeCallback = new GLFWFramebufferSizeCallback() {
			@Override
			public void invoke(long window, int width, int height) {
				displayFramebufferWidth = width;
				displayFramebufferHeight = height;
			}
		};
		
		Window.setCallbacks();
		
		displayWidth = mode.getWidth();
		displayHeight = mode.getHeight();
		
		IntBuffer fbw = BufferUtils.createIntBuffer(1);
		IntBuffer fbh = BufferUtils.createIntBuffer(1);
		GLFW.glfwGetFramebufferSize(Window.handle, fbw, fbh);
		displayFramebufferWidth = fbw.get(0);
		displayFramebufferHeight = fbh.get(0);
		
		glfwSetWindowPos(
			Window.handle,
			(monitorWidth - mode.getWidth()) / 2,
			(monitorHeight - mode.getHeight()) / 2
		);
		
		displayX = (monitorWidth - mode.getWidth()) / 2;
		displayY = (monitorHeight - mode.getHeight()) / 2;

		glfwMakeContextCurrent(Window.handle);
		context = org.lwjgl.opengl.GLContext.createFromCurrent();
		
		glfwSwapInterval(1);
		glfwShowWindow(Window.handle);
		
		displayCreated = true;
	}
	
	public static boolean isCreated() {
		return displayCreated;
	}
	
	public static boolean isActive() {
		return displayFocused;
	}
	
	public static boolean isVisible() {
		return displayVisible;
	}
	
	public static org.lwjgl.opengl.GLContext getContext() {
		return context;
	}
	
	public static void setLocation(int new_x, int new_y) {
		System.out.println("TODO: Implement Display.setLocation(int, int)");
	}
	
	public static void setVSyncEnabled(boolean sync) {
		System.out.println("TODO: Implement Display.setVSyncEnabled(boolean)");// TODO
	}
	
	public static long getWindow() {
		return Window.handle;
	}
	
	public static void update() {
		update(true);
	}
	
	public static void update(boolean processMessages) {
		try {
			swapBuffers();
			displayDirty = false;
		}
		catch (LWJGLException e) {
			throw new RuntimeException(e);
		}
		
		if (processMessages) processMessages();
	}
	
	public static void processMessages() {
		glfwPollEvents();
		Keyboard.poll();
		Mouse.poll();
		
		if (latestResized) {
			latestResized = false;
			displayResized = true;
			displayWidth = latestWidth;
			displayHeight = latestHeight;
		}
		else {
			displayResized = false;
		}
	}
	
	public static void swapBuffers() throws LWJGLException {
		glfwSwapBuffers(Window.handle);
	}
	
	public static void destroy() {
		Window.releaseCallbacks();
		glfwDestroyWindow(Window.handle);
		
		/*try {
			glfwTerminate();
		} catch (Throwable t) {
			t.printStackTrace();
		}*/
		displayCreated = false;
	}
	
	public static void setDisplayMode(DisplayMode dm) throws LWJGLException {
		mode = dm;
	}
	
	public static DisplayMode getDisplayMode() {
		return mode;
	}
	
	public static DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
		IntBuffer count = BufferUtils.createIntBuffer(1);
		ByteBuffer modes = GLFW.glfwGetVideoModes(GLFW.glfwGetPrimaryMonitor(), count);

		DisplayMode[] displayModes = new DisplayMode[count.get(0)];

		for (int i = 0; i < count.get(0); i++) {
			modes.position(i * GLFWvidmode.SIZEOF);

			int w = GLFWvidmode.width(modes);
			int h = GLFWvidmode.height(modes);
			int b = GLFWvidmode.redBits(modes) + GLFWvidmode.greenBits(modes)
					+ GLFWvidmode.blueBits(modes);
			int r = GLFWvidmode.refreshRate(modes);

			displayModes[i] = new DisplayMode(w, h, b, r);
		}

		return displayModes;
	}
	
	public static DisplayMode getDesktopDisplayMode() {
		return desktopDisplayMode;
	}
	
	public static boolean wasResized() {
		return displayResized;
	}
	
	public static int getX() {
		return displayX;
	}
	
	public static int getY() {
		return displayY;
	}
	
	public static int getWidth() {
		return displayWidth;
	}
	
	public static int getHeight() {
		return displayHeight;
	}
	
	public static int getFramebufferWidth() {
		return displayFramebufferWidth;
	}
	
	public static int getFramebufferHeight() {
		return displayFramebufferHeight;
	}
	
	public static void setTitle(String title) {
		windowTitle = title;
	}
	
	public static boolean isCloseRequested() {
		return glfwWindowShouldClose(Window.handle) == GL_TRUE;
	}
	
	public static boolean isDirty() {
		return displayDirty;
	}
	
	public static void setInitialBackground(float red, float green, float blue) {
		// TODO
		System.out.println("TODO: Implement Display.setInitialBackground(float, float, float)");
	}
	
	public static int setIcon(java.nio.ByteBuffer[] icons) {
		// TODO
		System.out.println("TODO: Implement Display.setIcon(ByteBuffer[])");
		return 0;
	}
	
	public static void setResizable(boolean resizable) {
		displayResizable = resizable;
		// TODO
	}
	
	public static boolean isResizable() {
		return displayResizable;
	}
	
	public static void setDisplayModeAndFullscreen(DisplayMode mode) throws LWJGLException {
		// TODO
		System.out.println("TODO: Implement Display.setDisplayModeAndFullscreen(DisplayMode)");
	}
	
	public static void setFullscreen(boolean fullscreen) throws LWJGLException {
		// TODO
	}
	
	public static boolean isFullscreen() {
		// TODO
		return false;
	}
	
	public static void setParent(java.awt.Canvas parent) throws LWJGLException {
		// Do nothing as set parent not supported
	}
	
	public static void releaseContext() throws LWJGLException {
		glfwMakeContextCurrent(0);
	}
	
	public static boolean isCurrent() throws LWJGLException {
		return context.isCurrent();
	}
	
	public static void makeCurrent() throws LWJGLException {
		glfwMakeContextCurrent(Window.handle);
	}
	
	public static java.lang.String getAdapter() {
		// TODO
		return "GeNotSupportedAdapter";
	}
	
	public static java.lang.String getVersion() {
		// TODO
		return "1.0 NOT SUPPORTED";
	}
	
	/**
	 * An accurate sync method that will attempt to run at a constant frame rate.
	 * It should be called once every frame.
	 *
	 * @param fps - the desired frame rate, in frames per second
	 */
	public static void sync(int fps) {
		Sync.sync(fps);
	}
	
	public static Drawable getDrawable() {
		return null;
	}
	
	static DisplayImplementation getImplementation() {
		return null;
	}
	
	private static class Window {
		static long handle;
		
		static GLFWKeyCallback keyCallback;
		static GLFWCharCallback charCallback;
		static GLFWCursorPosCallback cursorPosCallback;
		static GLFWMouseButtonCallback mouseButtonCallback;
		static GLFWWindowFocusCallback windowFocusCallback;
		static GLFWWindowIconifyCallback windowIconifyCallback;
		static GLFWWindowSizeCallback windowSizeCallback;
		static GLFWWindowPosCallback windowPosCallback;
		static GLFWWindowRefreshCallback windowRefreshCallback;
		static GLFWFramebufferSizeCallback framebufferSizeCallback;
		
		public static void setCallbacks() {
			glfwSetCallback(handle, keyCallback);
			glfwSetCallback(handle, charCallback);
			glfwSetCallback(handle, cursorPosCallback);
			glfwSetCallback(handle, mouseButtonCallback);
			glfwSetCallback(handle, windowFocusCallback);
			glfwSetCallback(handle, windowIconifyCallback);
			glfwSetCallback(handle, windowSizeCallback);
			glfwSetCallback(handle, windowPosCallback);
			glfwSetCallback(handle, windowRefreshCallback);
			glfwSetCallback(handle, framebufferSizeCallback);
		}
		
		public static void releaseCallbacks() {
			keyCallback.release();
			charCallback.release();
			cursorPosCallback.release();
			mouseButtonCallback.release();
			windowFocusCallback.release();
			windowIconifyCallback.release();
			windowSizeCallback.release();
			windowPosCallback.release();
			windowRefreshCallback.release();
			framebufferSizeCallback.release();
		}
	}

}
