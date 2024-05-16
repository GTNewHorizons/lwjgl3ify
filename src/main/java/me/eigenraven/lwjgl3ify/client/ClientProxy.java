package me.eigenraven.lwjgl3ify.client;

import static org.lwjgl.nuklear.Nuklear.*;

import java.lang.ref.WeakReference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjglx.input.Keyboard;
import org.lwjglx.opengl.Display;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import me.eigenraven.lwjgl3ify.CommonProxy;
import me.eigenraven.lwjgl3ify.api.DebugUi;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.core.Config;

public class ClientProxy extends CommonProxy {

    static final String javaVersion;
    static final String lwjglVersion = "LWJGL: " + org.lwjgl.Version.getVersion();
    static final KeyBinding debugUiKeybind = new KeyBinding(
        "key.lwjgl3ify.debuggui",
        Keyboard.KEY_F6,
        "key.categories.misc");

    static {
        String javaVersionRaw = "Java: " + System.getProperty("java.version");
        if (javaVersionRaw.length() > 32) {
            javaVersionRaw = javaVersionRaw.substring(0, 29) + "...";
        }
        javaVersion = javaVersionRaw;
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
        ClientRegistry.registerKeyBinding(debugUiKeybind);
        FMLCommonHandler.instance()
            .bus()
            .register(this);

        DebugUi.registerProvider("FPS Display", new FpsDisplay());
    }

    private static final class McKeybindHandler implements InputEvents.KeyboardListener {

        @Override
        public void onKeyEvent(InputEvents.KeyEvent event) {
            final Minecraft mc = Minecraft.getMinecraft();
            if (mc == null) {
                return;
            }
            if (mc.currentScreen != null) {
                return;
            }
            if (event.lwjgl2KeyCode > Keyboard.KEY_NONE) {
                KeyBinding.setKeyBindState(event.lwjgl2KeyCode, event.action != InputEvents.KeyAction.RELEASED);
                if (event.action != InputEvents.KeyAction.RELEASED) {
                    KeyBinding.onTick(event.lwjgl2KeyCode);
                }
            }
        }
    }

    private void registerKeybindHandler() {
        InputEvents.addKeyboardListener(new McKeybindHandler());
    }

    @Override
    public void registerF3Handler() {
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

    NuklearUi ui;
    WeakReference<GuiNuklear> debugUi = new WeakReference<>(null);

    @SubscribeEvent(priority = EventPriority.LOWEST)
    @SuppressWarnings("unused")
    public void onRenderHud(RenderGameOverlayEvent.Post event) {
        if (event.type == RenderGameOverlayEvent.ElementType.ALL) {
            final Minecraft mc = Minecraft.getMinecraft();
            final boolean inDebugScreen = mc.currentScreen != null && mc.currentScreen == debugUi.get();
            GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
            if (ui == null) {
                ui = new NuklearUi();
                ui.setup();
            }
            MemoryUtil.memPutFloat(ui.ctx.address() + NkContext.DELTA_TIME_SECONDS, event.partialTicks);
            DebugUi.drawAll(ui.ctx, inDebugScreen);
            ui.render(NK_ANTI_ALIASING_ON);
            GL11.glPopAttrib();
        }
    }

    @SubscribeEvent
    @SuppressWarnings("unused") // event handler
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }
        final Minecraft mc = Minecraft.getMinecraft();
        if (ui != null && mc.inGameHasFocus && debugUiKeybind.isPressed()) {
            final GuiNuklear gui = new GuiNuklear(ui);
            debugUi = new WeakReference<>(gui);
            mc.displayGuiScreen(gui);
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

    private static final class FpsDisplay implements DebugUi.DebugUiProvider {

        @Override
        public void onDebugUiDraw(NkContext ctx, boolean interactive) {
            final Minecraft mc = Minecraft.getMinecraft();
            try (final MemoryStack stack = MemoryStack.stackPush()) {
                if (nk_begin_titled(
                    ctx,
                    "lwjgl3ify.fps",
                    "FPS",
                    NkRect.malloc(stack)
                        .set(8, 8, 180, 32),
                    NK_WINDOW_BORDER | NK_WINDOW_MOVABLE | NK_WINDOW_NO_SCROLLBAR)) {
                    nk_layout_row_dynamic(ctx, 20.0f, 1);
                    nk_label(ctx, mc.debug, NK_TEXT_ALIGN_LEFT | NK_TEXT_ALIGN_TOP);
                }
                nk_end(ctx);
            }
        }
    }
}
