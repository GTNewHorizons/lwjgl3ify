package me.eigenraven.lwjgl3ify;

import java.lang.reflect.Field;
import java.util.List;

import me.eigenraven.lwjgl3ify.client.GLInfoCrashCallable;
import me.eigenraven.lwjgl3ify.core.Config;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ICrashCallable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
        replaceOpenGLCrashHandler();
    }

    @Override
    public void registerF3Handler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("unchecked")
    private void replaceOpenGLCrashHandler() {
        // Use a crash handler that's safe against being called from another thread
        try {
            final Field callablesField = FMLCommonHandler.class.getDeclaredField("crashCallables");
            callablesField.setAccessible(true);
            List<ICrashCallable> crashCallables = (List<ICrashCallable>) callablesField
                    .get(FMLCommonHandler.instance());
            for (int i = 0; i < crashCallables.size(); i++) {
                ICrashCallable original = crashCallables.get(i);
                if ("GL info".equals(original.getLabel()) && !(original instanceof GLInfoCrashCallable)) {
                    crashCallables.set(i, new GLInfoCrashCallable());
                }
            }
        } catch (ReflectiveOperationException e) {
            Lwjgl3ify.LOG.error("Could not access crash callables to make them OpenGL thread-safe", e);
        }
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
