package me.eigenraven.lwjgl3ify.client.ime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import me.eigenraven.lwjgl3ify.mixins.game.ime.IMixinGuiEditSign;
import me.eigenraven.lwjgl3ify.mixins.game.ime.IMixinGuiScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IMEWrapperSign extends IMEWrapper {

    public static IMEWrapperSign instance = new IMEWrapperSign();
    private TileEntitySign tileEntitySign = null;
    private GuiEditSign guiEditSign = null;

    public void setSign(GuiEditSign gui, TileEntitySign tile) {
        SwingUtilities.invokeLater(() -> {
            guiEditSign = gui;
            tileEntitySign = tile;
        });
    }

    public IMEWrapperSign() {
        super();
        this.add(textField);
        textField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                if (tileEntitySign != null) {
                    tileEntitySign.signText[((IMixinGuiEditSign) guiEditSign).getEditLine()] = textField.getText();
                }
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                if (tileEntitySign != null) {
                    tileEntitySign.signText[((IMixinGuiEditSign) guiEditSign).getEditLine()] = textField.getText();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                if (tileEntitySign != null) {
                    tileEntitySign.signText[((IMixinGuiEditSign) guiEditSign).getEditLine()] = textField.getText();
                }
            }
        });
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent keyEvent) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_TAB, KeyEvent.VK_ENTER, KeyEvent.VK_ESCAPE, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_PAGE_UP, KeyEvent.VK_PAGE_DOWN -> {

                        if (guiEditSign != null) {
                            Minecraft.getMinecraft().func_152344_a(() -> {
                                ((IMixinGuiScreen) (guiEditSign))
                                        .invokeKeyTyped('\0', IMEHelper.translateFromAWT(keyEvent.getKeyCode()));
                                textField.setText(
                                        tileEntitySign.signText[((IMixinGuiEditSign) guiEditSign).getEditLine()]);
                                textField.setCaretPosition(textField.getText().length());
                            });
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {}
        });

        textField.addCaretListener(caretEvent -> {
            if (textField.getCaretPosition() < textField.getText().length())
                textField.setCaretPosition(textField.getText().length());

        });
    }
}
