package me.eigenraven.lwjgl3ify.mixins.late.bq;

import net.minecraft.client.gui.GuiScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import betterquesting.client.gui2.GuiQuestSearch;
import betterquesting.client.gui2.editors.GuiQuestLinesEditor;
import betterquesting.client.gui2.editors.GuiTaskEditor;
import betterquesting.client.gui2.editors.nbt.GuiEntitySelection;
import betterquesting.client.gui2.editors.nbt.GuiFluidSelection;
import betterquesting.client.gui2.editors.nbt.GuiNbtAdd;
import bq_standard.client.gui.editors.GuiEditLootGroup;
import bq_standard.client.gui.editors.tasks.GuiEditTaskScoreboard;
import me.eigenraven.lwjgl3ify.client.TextFieldHandler;

@Mixin(
    value = { GuiQuestSearch.class, GuiEditLootGroup.class, GuiEditTaskScoreboard.class, GuiEntitySelection.class,
        GuiFluidSelection.class, GuiQuestLinesEditor.class, GuiTaskEditor.class, GuiNbtAdd.class })
public abstract class BqTextInput extends GuiScreen {

    @Inject(method = "initPanel()V", at = @At("HEAD"), remap = false)
    private void lwjgl3ify$onInit(CallbackInfo ci) {
        TextFieldHandler.beginTextInput();
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        TextFieldHandler.endTextInput(null);
    }
}
