package com.swordHostDemo.utls;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * 文本域高亮
 */
public class customHighlightTextArea {
    private RSyntaxTextArea syntaxTextArea;

    public customHighlightTextArea(JTextArea jTextArea, JScrollPane scrollPane) {

        syntaxTextArea = new RSyntaxTextArea();
        syntaxTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        syntaxTextArea.setCodeFoldingEnabled(true);
        syntaxTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        syntaxTextArea.setText(jTextArea.getText());
        scrollPane.setViewportView(syntaxTextArea);
    }
    public String getSyntaxTextArea(){
        return syntaxTextArea.getText();
    }

}
