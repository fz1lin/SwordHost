package com.swordHostDemo.service.proxy;

import com.swordHostDemo.controller.ProxyController;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:33
 * @description:
 */
public class menuProxyServiceImpl implements menuProxyService {
    @Override
    public void stowawayOption(
                               JTextArea stAdminTextArea, JTextArea stLinuxAgentTextArea,
                               JTextArea stWindowsAgentTextArea) {
        //admin
        String stowawayAdmin = ProxyController.StowawayAdmin();
        stAdminTextArea.setText(stowawayAdmin);
        //linux agent
        String stowawayLinuxAgent = ProxyController.StowawayLinuxAgent();
        stLinuxAgentTextArea.setText(stowawayLinuxAgent);
        //windows agent
        String stowawayWindowsAgent = ProxyController.StowawayWindosAgent();
        stWindowsAgentTextArea.setText(stowawayWindowsAgent);
    }
}
