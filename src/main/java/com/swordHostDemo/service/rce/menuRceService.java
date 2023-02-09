package com.swordHostDemo.service.rce;

import javax.swing.*;

/**
 * @date: 2023/1/20 21:47
 * @description:
 */
public interface menuRceService {
    /**
     * @param LhostValue:
     * @param LportValue:
     * @param FileNameVaule:
     * @param Curl1TextField:
     * @param Curl2TextField:
     * @param Wget1TextArea:
     * @param PythonTextArea:
     * @return: void
     * @date: 2023/1/20 22:00
     * @description: RCE返回的值
     */
    void rceMenu(JTextField LhostValue, JTextField LportValue, JTextField FileNameVaule,
                 JTextField Curl1TextField, JTextField Curl2TextField,
                 JTextArea Wget1TextArea, JTextArea PythonTextArea
    );
}
