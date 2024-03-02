package me.eigenraven.lwjgl3ify.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjglx.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import me.eigenraven.lwjgl3ify.CommonProxy;
import me.eigenraven.lwjgl3ify.api.InputEvents;
import me.eigenraven.lwjgl3ify.core.Config;

public class ClientProxy extends CommonProxy {

    static final String javaVersion;
    static final String lwjglVersion = "LWJGL: " + org.lwjgl.Version.getVersion();

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
}
