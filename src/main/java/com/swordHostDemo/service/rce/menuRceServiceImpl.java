package com.swordHostDemo.service.rce;

import com.swordHostDemo.controller.RceController;

import javax.swing.*;

/**
 * @date: 2023/1/20 21:48
 * @description:
 */
public class menuRceServiceImpl implements menuRceService {

    @Override
    public void rceMenu(JTextField LhostValue, JTextField LportValue, JTextField FileNameVaule,
                        JTextField Curl1TextField, JTextField Curl2TextField,
                        JTextArea Wget1TextArea, JTextArea PythonTextArea
    ) {

        //Curl1
        String Curl1Options = RceController.Curl1Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Curl1TextField.setText(Curl1Options);
        //Curl2
        String Curl2Options = RceController.Curl2Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Curl2TextField.setText(Curl2Options);

        //wget
        String WgetOptions = RceController.Wget1Command(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        Wget1TextArea.setText(WgetOptions);

        //Python
        String PythonOptions = RceController.pythonCommand(LhostValue.getText(), LportValue.getText(), FileNameVaule.getText());
        PythonTextArea.setText(PythonOptions);
    }
}
