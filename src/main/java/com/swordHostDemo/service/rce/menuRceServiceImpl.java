package com.swordHostDemo.service.rce;

import com.swordHostDemo.controller.RceController;
import com.swordHostDemo.pojo.menuBeanListener;

import javax.swing.*;

import static com.swordHostDemo.pojo.menuBeanListener.*;

/**
 * @date: 2023/1/20 21:48
 * @description:
 */
public class menuRceServiceImpl implements menuRceService {

    @Override
    public void rceMenu(JTextField Curl1TextField, JTextField Curl2TextField,
                        JTextArea Wget1TextArea, JTextArea PythonTextArea
    ) {


        //Curl1
        String Curl1Options = RceController.Curl1Command();
        Curl1TextField.setText(Curl1Options);
        //Curl2
        String Curl2Options = RceController.Curl2Command();
        Curl2TextField.setText(Curl2Options);

        //wget
        String WgetOptions = RceController.Wget1Command();
        Wget1TextArea.setText(WgetOptions);

        //Python
        String PythonOptions = RceController.pythonCommand();
        PythonTextArea.setText(PythonOptions);
    }
}
