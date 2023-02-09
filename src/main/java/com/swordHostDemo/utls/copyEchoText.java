package com.swordHostDemo.utls;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * @date: 2023/1/2 16:19
 * @description:
 */
public class copyEchoText {

    //点击按钮复制文本
    public static void init(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
        System.out.println(text);
    }

}
