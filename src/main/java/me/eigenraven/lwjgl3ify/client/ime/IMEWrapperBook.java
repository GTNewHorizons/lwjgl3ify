package me.eigenraven.lwjgl3ify.client.ime;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import me.eigenraven.lwjgl3ify.mixins.game.ime.IMixinGuiScreen;
import me.eigenraven.lwjgl3ify.mixins.game.ime.IMixinGuiScreenBook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class IMEWrapperBook extends IMEWrapper {

    private JTextArea textArea;

    public static IMEWrapperBook instance = new IMEWrapperBook();
    private GuiScreenBook guiScreenBook = null;

    public void setBookGui(GuiScreenBook gui) {
        SwingUtilities.invokeLater(() -> { guiScreenBook = gui; });
    }

    @Override
    public void setText(String text) {
        SwingUtilities.invokeLater(() -> {
            textArea.setText(text);
            textArea.setCaretPosition(text.length());
        });
    }

    public IMEWrapperBook() {
        super();
        textArea = new JTextArea();
        textArea.setFocusTraversalKeysEnabled(false);
        textArea.requestFocusInWindow();
        textArea.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                if (guiScreenBook != null) {
                    String s = textArea.getText();
                    if (((ISetPageable) guiScreenBook).canPageSet(s)) {
                        ((IMixinGuiScreenBook) guiScreenBook).invokeFunc_146457_a(s);
                    } else {
                        textArea.setText(s.substring(0, s.length() - documentEvent.getLength()));
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                if (guiScreenBook != null) {
                    String s = textArea.getText();
                    ((IMixinGuiScreenBook) guiScreenBook).invokeFunc_146457_a(s);

                }
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                if (guiScreenBook != null) {
                    String s = textArea.getText();
                    if (((ISetPageable) guiScreenBook).canPageSet(s)) {
                        ((IMixinGuiScreenBook) guiScreenBook).invokeFunc_146457_a(s);
                    } else {
                        textArea.setText(s.substring(0, s.length() - documentEvent.getLength()));
                    }
                }
            }
        });
        textArea.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent keyEvent) {}

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_TAB, KeyEvent.VK_ESCAPE, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_PAGE_UP, KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT -> {
                        if (guiScreenBook != null) {

                            Minecraft.getMinecraft().func_152344_a(
                                    () -> {
                                        ((IMixinGuiScreen) (guiScreenBook)).invokeKeyTyped(
                                                '\0',
                                                IMEHelper.translateFromAWT(keyEvent.getKeyCode()));
                                    });

                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {}
        });
        textArea.addCaretListener(caretEvent -> {
            if (textArea.getCaretPosition() < textArea.getText().length())
                textArea.setCaretPosition(textArea.getText().length());
        });
        this.add(textArea);
    }
}
