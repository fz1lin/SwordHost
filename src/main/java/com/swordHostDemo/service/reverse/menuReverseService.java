package com.swordHostDemo.service.reverse;

import javax.swing.*;

/**
 * @date: 2023/1/20 12:05
 * @description:
 */
public interface menuReverseService {
    /**
     * @param LhostValue:
     * @param LportValue:
     * @param Bash1TextArea:
     * @param Bash2TextArea:
     * @param JavaBashTextArea:
     * @return: void
     * @date: 2023/1/20 21:28
     * @description: bash反弹shell选项菜单
     */
    void reverseOptionsMenu(JTextField LhostValue, JTextField LportValue, JTextField Bash1TextArea, JTextField Bash2TextArea, JTextField JavaBashTextArea);
}
