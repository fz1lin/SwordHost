package com.swordHostDemo.service.tools;

import com.swordHostDemo.controller.RandomController;
import com.swordHostDemo.controller.TimeStampController;

import javax.swing.*;

/**
 * @date: 2023/1/22 20:15
 * @description:
 */
public class menuToolsServiceImpl implements menuToolsService {
    //获取当前时间戳
    @Override
    public void getTimeStamp(JTextField timeStampEchoTextField, JTextField StampTimeEchoTextField) {
        timeStampEchoTextField.setText(TimeStampController.timeStamp());
        String TimeStampEcho = TimeStampController.timeStamp2DateStr(TimeStampController.timeStamp());
        StampTimeEchoTextField.setText(TimeStampEcho);
    }

    @Override
    public void URLMenucomboBox1(JComboBox URLMenucomboBox) {
        URLMenucomboBox.setEnabled(true);
        URLMenucomboBox.addItem("UTF-8");
        URLMenucomboBox.addItem("gb2312");
    }

    @Override
    public void passwordcheckBoxInit(JCheckBox ABCcheckBox, JCheckBox abcckBox, JCheckBox NumcheckBox, JSpinner PasswordLens, JTextField RandomTextField, JCheckBox SigncheckBox) {

        //判断勾选那个添加那个
        String ABCstr = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
        String abcstr = "abcdefghjkmnopqrstuvwxyz";
        String numstr = "123456789";
        String Singstr = "!@#$%^&*()_+";

        if (!ABCcheckBox.isSelected()) {
            ABCstr = "";
        }
        if (!abcckBox.isSelected()) {
            abcstr = "";
        }
        if (!NumcheckBox.isSelected()) {
            numstr = "";
        }
        if (!SigncheckBox.isSelected()) {
            Singstr = "";
        }
        String ALLstr = ABCstr + abcstr + numstr + Singstr;
        System.out.println("GUI-ALLstr：" + ALLstr);


        //随机读取
        int value = (int) PasswordLens.getValue();
        for (int i = 0; i < 4; ) {
            RandomTextField.setText(RandomController.RandomComplexPassword(ALLstr, value));
            i++;
        }
        System.out.println("GUI-RandomButtonMouse：" + ALLstr);
        int num = 16;
        PasswordLens.setValue(num);
        RandomTextField.setText(RandomController.RandomComplexPassword(ALLstr, num));
    }

    @Override
    public void passwordInit(JCheckBox ABCcheckBox, JCheckBox abcckBox, JCheckBox NumcheckBox) {
        //初始化checkbox
        ABCcheckBox.setSelected(true);
        abcckBox.setSelected(true);
        NumcheckBox.setSelected(true);

    }
}
