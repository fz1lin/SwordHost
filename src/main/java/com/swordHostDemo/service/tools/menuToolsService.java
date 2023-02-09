package com.swordHostDemo.service.tools;

import javax.swing.*;

/**
 * @date: 2023/1/22 20:14
 * @description:
 */
public interface menuToolsService {

    /**
     * @param timeStampEchoTextField:
     * @param StampTimeEchoTextField:
     * @return: void
     * @date: 2023/1/22 21:38
     * @description: 获取当前时间戳
     */
    void getTimeStamp(JTextField timeStampEchoTextField, JTextField StampTimeEchoTextField);

    /**
     * @param URLMenucomboBox:
     * @return: void
     * @date: 2023/1/22 21:38
     * @description: URL编码选择的值
     */
    void URLMenucomboBox1(JComboBox URLMenucomboBox);

    /**
     * @param ABCcheckBox:
     * @param abcckBox:
     * @param NumcheckBox:
     * @param PasswordLens:
     * @param RandomTextField:
     * @param SigncheckBox:
     * @return: void
     * @date: 2023/1/22 21:39
     * @description: 随机密码生成的初始化
     */
    void passwordcheckBoxInit(JCheckBox ABCcheckBox, JCheckBox abcckBox, JCheckBox NumcheckBox, JSpinner PasswordLens, JTextField RandomTextField, JCheckBox SigncheckBox);

    /**
     * @param ABCcheckBox:
     * @param abcckBox:
     * @param NumcheckBox:
     * @return: void
     * @date: 2023/1/22 21:40
     * @description:随机密码初始化
     */
    void passwordInit(JCheckBox ABCcheckBox, JCheckBox abcckBox, JCheckBox NumcheckBox);
}
