package com.swordHostDemo.service.proxy;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:30
 * @description:
 */
public interface menuProxyService {

    /**
     * @param LhostValue:
     * @param LportValue:
     * @param FileNameVaule:
     * @param stAdminTextArea:
     * @param stLinuxAgentTextArea:
     * @param stWindowsAgentTextArea:
     * @return: void
     * @date: 2023/1/22 21:43
     * @description: stowaway 代理相关的参数
     */
    void stowawayOption(JTextField LhostValue, JTextField LportValue, JTextField FileNameVaule,
                        JTextArea stAdminTextArea, JTextArea stLinuxAgentTextArea,
                        JTextArea stWindowsAgentTextArea);

}
