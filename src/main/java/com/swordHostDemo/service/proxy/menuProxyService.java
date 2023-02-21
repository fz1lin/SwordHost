package com.swordHostDemo.service.proxy;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:30
 * @description:
 */
public interface menuProxyService {

    /**
     * @param stAdminTextArea:
     * @param stLinuxAgentTextArea:
     * @param stWindowsAgentTextArea:
     * @return: void
     * @date: 2023/1/22 21:43
     * @description: stowaway 代理相关的参数
     */
    void stowawayOption(
                        JTextArea stAdminTextArea, JTextArea stLinuxAgentTextArea,
                        JTextArea stWindowsAgentTextArea);

}
