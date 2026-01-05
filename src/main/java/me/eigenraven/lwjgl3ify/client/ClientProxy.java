package me.eigenraven.lwjgl3ify.client;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.sdl.SDLVersion;
import org.lwjgl.sdl.SDLVideo;
import org.lwjglx.input.Keyboard;
import org.lwjglx.opengl.Display;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ProgressManager;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.eigenraven.lwjgl3ify.CommonProxy;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.core.Config;

public class ClientProxy extends CommonProxy {

    static final String javaVersion;
    static final String lwjglVersion;

    static {
        String javaVersionRaw = "Java: " + System.getProperty("java.version");
        if (javaVersionRaw.length() > 32) {
            javaVersionRaw = javaVersionRaw.substring(0, 29) + "...";
        }
        javaVersion = javaVersionRaw;
        final int sdlVer = SDLVersion.SDL_GetVersion();
        final int sdlMajor = SDLVersion.SDL_VERSIONNUM_MAJOR(sdlVer);
        final int sdlMinor = SDLVersion.SDL_VERSIONNUM_MINOR(sdlVer);
        final int sdlMicro = SDLVersion.SDL_VERSIONNUM_MICRO(sdlVer);
        lwjglVersion = String
            .format("LWJGL: %s  SDL: %d.%d.%d", org.lwjgl.Version.getVersion(), sdlMajor, sdlMinor, sdlMicro);
    }

    @Override
    public void runCompatHooks() {
        super.runCompatHooks();
        if (Config.DEBUG_REGISTER_OPENGL_LOGGER) {
            GLDebugLog.setupDebugMessageCallback();
        }
        // Populate keyboard-layout-dependent key lookup tables
        Keyboard.populateKeyLookupTables();
        registerKeybindHandler();
        FMLCommonHandler.instance()
            .bus()
            .register(this);
    }

    private static final class McKeybindHandler implements InputEvents.KeyboardListener {

        @Override
        public void onKeyEvent(InputEvents.KeyEvent event) {}

        @Override
        public void onTextEvent(InputEvents.TextEvent event) {
            TextFieldHandler.onTextInput(event);
        }
    }

    private void registerKeybindHandler() {
        InputEvents.addKeyboardListener(new McKeybindHandler());
    }

    @Override
    public void registerEventHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    @SuppressWarnings("unused") // event handler
    public void onRenderGameOverlayTextEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo
            && event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            if (Config.SHOW_LWJGL_VERSION) {
                event.right.add(Math.min(3, event.right.size()), lwjglVersion);
            }
            if (Config.SHOW_JAVA_VERSION) {
                event.right.add(Math.min(3, event.right.size()), javaVersion);
            }
        }
    }

    @SubscribeEvent
    @SuppressWarnings("unused") // event handler
    public void onConfigChange(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (!event.modID.equals("lwjgl3ify")) {
            return;
        }
        Config.config.save();
        Config.reloadConfigObject();
        Display.lwjgl3ify$updateRawMouseMode(Config.INPUT_RAW_MOUSE);
    }

    private static final AtomicBoolean gameIsLoading = new AtomicBoolean(true);

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void onGuiChange(final GuiOpenEvent event) {
        final GuiScreen oldScreen = Minecraft.getMinecraft().currentScreen;
        final GuiScreen newScreen = event.gui;
        if (gameIsLoading.get()) {
            gameIsLoading.set(false);
            MainThreadExec.runOnMainThread(
                () -> { SDLVideo.SDL_SetWindowProgressState(Display.getWindow(), SDLVideo.SDL_PROGRESS_STATE_NONE); });
        }
        if (oldScreen != newScreen) {
            TextFieldHandler.resetTextInput();
        }
    }

    static float lastProgress = -1.0f;

    @SuppressWarnings("deprecation")
    public static void onProgressUpdate() {
        if (!Config.WINDOW_LOADING_PROGRESS || !gameIsLoading.get()) {
            return;
        }
        float newProgress = 0.0f;
        float curUnit = 1.0f;
        for (final Iterator<ProgressManager.ProgressBar> it = ProgressManager.barIterator(); it.hasNext();) {
            final ProgressManager.ProgressBar bar = it.next();
            final float barUnit = 1.0f / (bar.getSteps() + 1);
            final float barProgress = (bar.getStep() + 1) * barUnit;
            newProgress += curUnit * barProgress;
            curUnit *= barUnit;
        }
        newProgress = Math.max(0.0f, Math.min(newProgress, 1.0f));
        if (Math.abs(newProgress - lastProgress) < 0.01f) {
            return;
        }
        final float finalNewProgress = newProgress;
        MainThreadExec.runOnMainThread(() -> {
            final long window = Display.getWindow();
            SDLVideo.SDL_SetWindowProgressState(window, SDLVideo.SDL_PROGRESS_STATE_NORMAL);
            SDLVideo.SDL_SetWindowProgressValue(window, finalNewProgress);
        });
        lastProgress = finalNewProgress;
    }
}
