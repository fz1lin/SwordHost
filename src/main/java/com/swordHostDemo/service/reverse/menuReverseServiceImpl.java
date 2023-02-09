package com.swordHostDemo.service.reverse;

import com.swordHostDemo.controller.ReverseController;
import com.swordHostDemo.utls.enCodeUtls;

import javax.swing.*;

/**
 * @date: 2023/1/20 12:05
 * @description:
 */
public class menuReverseServiceImpl implements menuReverseService {

    @Override
    public void reverseOptionsMenu(JTextField LhostValue, JTextField LportValue, JTextField Bash1TextArea, JTextField Bash2TextArea, JTextField JavaBashTextArea) {
        //BashOption
        String bash1Option = ReverseController.ReverseBash1(LhostValue.getText(), LportValue.getText());
        Bash1TextArea.setText(bash1Option);

        //BashOption
        String bash2Option = ReverseController.ReverseBash2(LhostValue.getText(), LportValue.getText());
        Bash2TextArea.setText(bash2Option);

        //JavaBashOption
        String javaBashOption = enCodeUtls.JavaEncode(LhostValue.getText(), LportValue.getText());
        JavaBashTextArea.setText(javaBashOption);

    }
}
