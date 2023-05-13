package me.eigenraven.lwjgl3ify.core;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.common.config.Configuration;

import me.eigenraven.lwjgl3ify.Tags;

public class Config {

    public static final String[] DEFAULT_EXTENSIBLE_ENUMS = new String[] {
            // From EnumHelper
            "net.minecraft.item.EnumAction", "net.minecraft.item.ItemArmor$ArmorMaterial",
            "net.minecraft.entity.item.EntityPainting$EnumArt", "net.minecraft.entity.EnumCreatureAttribute",
            "net.minecraft.entity.EnumCreatureType",
            "net.minecraft.world.gen.structure.StructureStrongholdPieces$Stronghold$Door",
            "net.minecraft.enchantment.EnumEnchantmentType", "net.minecraft.entity.Entity$EnumEntitySize",
            "net.minecraft.block.BlockPressurePlate$Sensitivity",
            "net.minecraft.util.MovingObjectPosition$MovingObjectType", "net.minecraft.world.EnumSkyBlock",
            "net.minecraft.entity.player.EntityPlayer$EnumStatus", "net.minecraft.item.Item$ToolMaterial",
            "net.minecraft.item.EnumRarity",
            //
            "net.minecraftforge.event.terraingen.PopulateChunkEvent$Populate$EventType",
            "net.minecraftforge.event.terraingen.InitMapGenEvent$EventType",
            "net.minecraftforge.event.terraingen.OreGenEvent$GenerateMinable$EventType",
            "net.minecraftforge.event.terraingen.DecorateBiomeEvent$Decorate$EventType",
            // From GTNH crashes
            "vswe.stevesfactory.Localization", "vswe.stevesfactory.blocks.ClusterMethodRegistration",
            "vswe.stevesfactory.blocks.ConnectionBlockType", "vswe.stevesfactory.components.ComponentType",
            "vswe.stevesfactory.components.ConnectionSet", "vswe.stevesfactory.components.ConnectionOption",
            "ic2.core.init.InternalName", "gregtech.api.enums.Element", "gregtech.api.enums.OrePrefixes",
            "net.minecraft.client.audio.MusicTicker$MusicType", "org.bukkit.Material",
            "buildcraft.api.transport.IPipeTile.PipeType", "thaumcraft.common.entities.golems.EnumGolemType",
            // Non-GTNH Mods Compat
            // The Lord of the Rings Mod: Legacy
            "net.minecraft.event.HoverEvent$Action",
            // Reika's mods
            "net.minecraft.client.audio.SoundCategory",
            "Reika.RotaryCraft.TileEntities.Processing.TileEntityFuelConverter$Conversions",
            "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Fertility",
            "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Speeds",
            "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Flowering",
            "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Territory",
            "Reika.DragonAPI.ModInteract.Bees.BeeAlleleRegistry$Life",
            "Reika.DragonAPI.ModInteract.Bees.ButterflyAlleleRegistry$Fertility",
            "Reika.DragonAPI.ModInteract.Bees.ButterflyAlleleRegistry$Life",
            // Et Futurum Requiem
            "net.minecraft.world.WorldSettings$GameType",
            //
    };

    private static final Set<String> EXTENSIBLE_ENUMS = new HashSet<>(Arrays.asList(DEFAULT_EXTENSIBLE_ENUMS));
    private static boolean configLoaded = false;

    public static boolean MIXIN_STBI_TEXTURE_LOADING = true;
    public static boolean MIXIN_STBI_TEXTURE_STICHING = true;
    public static boolean MIXIN_STBI_IGNORE_FASTCRAFT = false;

    public static boolean DEBUG_PRINT_KEY_EVENTS = false;
    public static boolean DEBUG_PRINT_MOUSE_EVENTS = false;

    public static boolean SHOW_JAVA_VERSION = true;
    public static boolean SHOW_LWJGL_VERSION = true;

    public static boolean WINDOW_START_MAXIMIZED = false, WINDOW_START_FOCUSED = true, WINDOW_START_ICONIFIED = false;
    public static boolean WINDOW_DECORATED = true;
    public static boolean OPENGL_DEBUG_CONTEXT = false;
    public static boolean OPENGL_SRGB_CONTEXT = false;
    public static boolean OPENGL_DOUBLEBUFFER = true;
    public static boolean OPENGL_CONTEXT_NO_ERROR = false;

    public static boolean INPUT_INVERT_WHEEL = false;
    public static double INPUT_SCROLL_SPEED = 1.0;

    public static String X11_CLASS_NAME = "minecraft";
    public static String COCOA_FRAME_NAME = "minecraft";

    public static String LWJGL3IFY_VERSION = Tags.VERSION;

    public static final String CATEGORY_MIXIN = "mixin";
    public static final String CATEGORY_CORE = "core";
    public static final String CATEGORY_IME = "ime";
    public static final String CATEGORY_DEBUG = "debug";
    public static final String CATEGORY_WINDOW = "window";
    public static final String CATEGORY_INPUT = "input";
    public static final String CATEGORY_GLCONTEXT = "openglContext";

    public static Configuration config = null;

    static void loadConfig() {
        if (configLoaded) {
            return;
        }
        configLoaded = true;
        final File configDir = new File(Launch.minecraftHome, "config");
        if (!configDir.isDirectory()) {
            configDir.mkdirs();
        }
        final File configFile = new File(configDir, "lwjgl3ify.cfg");
        config = new Configuration(configFile);

        reloadConfigObject();

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static void reloadConfigObject() {
        EXTENSIBLE_ENUMS.addAll(
                Arrays.asList(
                        config.get(
                                CATEGORY_CORE,
                                "extensibleEnums",
                                EXTENSIBLE_ENUMS.toArray(new String[0]),
                                "Enums to make extensible at runtime").getStringList()));

        MIXIN_STBI_TEXTURE_LOADING = config.getBoolean(
                "stbiTextureLoading",
                CATEGORY_MIXIN,
                MIXIN_STBI_TEXTURE_LOADING,
                "Use the faster stb_image-based texture loader");
        MIXIN_STBI_TEXTURE_STICHING = config.getBoolean(
                "stbiTextureStiching",
                CATEGORY_MIXIN,
                MIXIN_STBI_TEXTURE_STICHING,
                "Use the much faster stb_rectpack-based texture stitcher");
        MIXIN_STBI_IGNORE_FASTCRAFT = config.getBoolean(
                "stbiIgnoreFastcraft",
                CATEGORY_MIXIN,
                MIXIN_STBI_IGNORE_FASTCRAFT,
                "Force-enable the STB mixins even if FastCraft is present, may lead to a rapidly flashing screen and other visual artifacts");

        DEBUG_PRINT_KEY_EVENTS = config.getBoolean(
                "printKeyEvents",
                CATEGORY_DEBUG,
                DEBUG_PRINT_KEY_EVENTS,
                "Print keyboard-related events to the log");
        DEBUG_PRINT_MOUSE_EVENTS = config.getBoolean(
                "printMouseEvents",
                CATEGORY_DEBUG,
                DEBUG_PRINT_MOUSE_EVENTS,
                "Print mouse-related events to the log");

        SHOW_JAVA_VERSION = config
                .getBoolean("showJavaVersion", CATEGORY_CORE, SHOW_JAVA_VERSION, "Show java version in the debug hud");
        SHOW_LWJGL_VERSION = config.getBoolean(
                "showLwjglVersion",
                CATEGORY_CORE,
                SHOW_LWJGL_VERSION,
                "Show lwjgl version in the debug hud");

        WINDOW_START_MAXIMIZED = config
                .getBoolean("maximized", CATEGORY_WINDOW, WINDOW_START_MAXIMIZED, "Start maximized?");
        WINDOW_START_FOCUSED = config.getBoolean("focused", CATEGORY_WINDOW, WINDOW_START_FOCUSED, "Start focused?");
        WINDOW_START_ICONIFIED = config
                .getBoolean("iconified", CATEGORY_WINDOW, WINDOW_START_ICONIFIED, "Start iconified?");
        WINDOW_DECORATED = config.getBoolean(
                "decorated",
                CATEGORY_WINDOW,
                WINDOW_DECORATED,
                "Should the window have decorations (titlebar, border, close button)");
        X11_CLASS_NAME = config.getString(
                "x11ClassName",
                CATEGORY_WINDOW,
                X11_CLASS_NAME,
                "Linux-only - change the X11 class name, which is used by your window manager to identify the running application");
        COCOA_FRAME_NAME = config.getString(
                "cocoaFrameName",
                CATEGORY_WINDOW,
                COCOA_FRAME_NAME,
                "OSX-only - identifier used to save and restore the window position and size");

        INPUT_INVERT_WHEEL = config
                .getBoolean("invertScrollWheel", CATEGORY_INPUT, INPUT_INVERT_WHEEL, "Invert scrolling direction");
        INPUT_SCROLL_SPEED = (double) config.getFloat(
                "scrollSpeedMultiplier",
                CATEGORY_INPUT,
                (float) INPUT_SCROLL_SPEED,
                +0.05f,
                +20.0f,
                "Scrolling speed multiplier");

        OPENGL_DEBUG_CONTEXT = config.getBoolean(
                "debugContext",
                CATEGORY_GLCONTEXT,
                OPENGL_DEBUG_CONTEXT,
                "Enable KHR_debug in the OpenGL context for advanced debugging capabilities");
        OPENGL_SRGB_CONTEXT = config.getBoolean(
                "srgb",
                CATEGORY_GLCONTEXT,
                OPENGL_SRGB_CONTEXT,
                "Make the framebuffer use the sRGB color space");
        OPENGL_DOUBLEBUFFER = config.getBoolean(
                "doubleBuffer",
                CATEGORY_GLCONTEXT,
                OPENGL_DOUBLEBUFFER,
                "Make the framebuffer double-buffered (will cause visual artifacts if disabled)");
        OPENGL_CONTEXT_NO_ERROR = config.getBoolean(
                "noError",
                CATEGORY_GLCONTEXT,
                OPENGL_CONTEXT_NO_ERROR,
                "Enable GL_KHR_no_error to use faster driver code, but which can cause memory corruption in case of OpenGL errors");
    }

    public static Set<String> getExtensibleEnums() {
        return EXTENSIBLE_ENUMS;
    }

    public static void addExtensibleEnum(String className) {
        EXTENSIBLE_ENUMS.add(className);
    }

    public static boolean isConfigLoaded() {
        return configLoaded;
    }
}
