package com.swordHostDemo.service.proxy;

import com.swordHostDemo.controller.StowawayController;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:33
 * @description:
 */
public class menuProxyServiceImpl implements menuProxyService {
    @Override
    public void stowawayOption(JTextField LhostValue, JTextField LportValue, JTextField FileNameVaule,
                               JTextArea stAdminTextArea, JTextArea stLinuxAgentTextArea,
                               JTextArea stWindowsAgentTextArea) {
        //admin
        String stowawayAdmin = StowawayController.StowawayAdmin(LportValue.getText(), "243141");
        stAdminTextArea.setText(stowawayAdmin);
        //linux agent
        String stowawayLinuxAgent = StowawayController.StowawayLinuxAgent(LhostValue.getText(), LportValue.getText(), "243141", FileNameVaule.getText());
        stLinuxAgentTextArea.setText(stowawayLinuxAgent);
        //windows agent
        String stowawayWindowsAgent = StowawayController.StowawayWindosAgent(LhostValue.getText(), LportValue.getText(), "243141");
        stWindowsAgentTextArea.setText(stowawayWindowsAgent);
    }
}
