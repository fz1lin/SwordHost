package com.swordHostDemo.service.reverse;

import javax.swing.*;

/**
 * @date: 2023/1/20 12:05
 * @description:
 */
public interface menuReverseService {
    /**
     * @param Bash1TextArea:
     * @param Bash2TextArea:
     * @return: void
     * @date: 2023/1/20 21:28
     * @description: bash反弹shell选项菜单
     */
    void reverseBashOptionsMenu(JTextField Bash1TextArea
            , JTextField Bash2TextArea,JTextField Bash3TCPTextField,JTextField Bash1UDPTextField,JTextField Bash2UDPTextField);
    void reverseAwkOptionsMenu(JTextField ReverseAwkTextField);
}
