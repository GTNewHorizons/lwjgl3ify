package me.eigenraven.lwjgl3ify;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;

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
    public void registerF3Handler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    @SuppressWarnings("unused") // event handler
    public void onRenderGameOverlayTextEvent(RenderGameOverlayEvent.Text event) {
        if (Minecraft.getMinecraft().gameSettings.showDebugInfo
                && event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            event.right.add(Math.min(3, event.right.size()), javaVersion);
            event.right.add(Math.min(4, event.right.size()), lwjglVersion);
        }
    }
}
