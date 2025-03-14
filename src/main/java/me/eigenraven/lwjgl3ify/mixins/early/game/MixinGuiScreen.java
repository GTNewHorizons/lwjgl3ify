package me.eigenraven.lwjgl3ify.mixins.early.game;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(GuiScreen.class)
public class MixinGuiScreen extends Gui {

    /**
     * @author eigenraven
     * @reason Replace AWT reliance with SDL APIs.
     */
    @Overwrite
    public static String getClipboardString() {
        return TextFieldHandler.getClipboardText();
    }

    /**
     * @author eigenraven
     * @reason Replace AWT reliance with SDL APIs.
     */
    @Overwrite
    public static void setClipboardString(final String newText) {
        TextFieldHandler.setClipboardText(newText);
    }
}
