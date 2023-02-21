package com.swordHostDemo.utls;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class TextAreaWithContextMenu {

    private JTextArea textArea;

    public TextAreaWithContextMenu(JTextArea textArea) {
        this.textArea = textArea;
        textArea.addMouseListener(new PopupListener());
    }

    class PopupListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                JPopupMenu popup = new JPopupMenu();
                JMenuItem copyItem = new JMenuItem("Copy");
                JMenuItem cutItem = new JMenuItem("Cut");
                JMenuItem pasteItem = new JMenuItem("Paste");
                JMenuItem selectAllItem = new JMenuItem("Select All");

                copyItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        StringSelection selection = new StringSelection(textArea.getSelectedText());
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
                    }
                });

                cutItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        StringSelection selection = new StringSelection(textArea.getSelectedText());
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
                        textArea.replaceSelection("");
                    }
                });

                pasteItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            textArea.insert(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor).toString(), textArea.getCaretPosition());
                        } catch (UnsupportedFlavorException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                selectAllItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.selectAll();
                    }
                });

                popup.add(copyItem);
                popup.add(cutItem);
                popup.add(pasteItem);
                popup.add(selectAllItem);
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}
