package com.swordHostDemo.service.msf;

import com.swordHostDemo.controller.MetasploitController;

import javax.swing.*;

/**
 * @date: 2023/1/20 21:34
 * @description:
 */
public class menuMsfServiceImpl implements menuMsfService {


    @Override
    public void msfShellMenu(JTextField LhostValue, JTextField LportValue, JTextField FileNameVaule,
                             JTextField sessionIdTextField,
                             JTextArea msfRootTextArea, JTextField msfLinuxHexTextField,
                             JTextField msfLinuxELFTextField, JTextArea msfLinuxListenerTextArea,
                             JTextArea msfWindowsListenerTextArea,
                             JTextArea csMsfTextArea, JTextArea MSFcsTextArea
    ) {
        String getLhost = LhostValue.getText();
        String getLport = LportValue.getText();
        String getFileName = FileNameVaule.getText();
        //msf init
        String payload = "exploit/linux/local/cve_2021_4034_pwnkit_lpe_pkexec";
        String rootCommand = MetasploitController.RootCommand(payload, getLhost, getLport, sessionIdTextField.getText());
        msfRootTextArea.setText(rootCommand);

        //msf linuxPayload
        String MsflinuxHex = MetasploitController.MsflinuxHexCommand(getLhost, getLport);
        msfLinuxHexTextField.setText(MsflinuxHex);

        //MSF linuxElfPayload
        String msflinuxELFCommand = MetasploitController.MsflinuxELFCommand(getLhost, getLport, getFileName);
        msfLinuxELFTextField.setText(msflinuxELFCommand);

        //msf LinuxListener
        String msfLinuxListener = MetasploitController.ListenerLinuxhandler(getLhost, getLport);
        msfLinuxListenerTextArea.setText(msfLinuxListener);

        //msf WindowsListener
        String msfWindowsListener = MetasploitController.ListenerWindowshandler(getLhost, getLport);
        msfWindowsListenerTextArea.setText(msfWindowsListener);

        //cs->msf CsMsfForeignCommand
        String CsMsfForeignStr = MetasploitController.CsMsfForeignCommand(getLhost, getLport);
        csMsfTextArea.setText(CsMsfForeignStr);

        //msf->cs MsfCsForeignCommand
        String MsfCsForeign = MetasploitController.MsfCsForeignCommand(getLhost, getLport);
        MSFcsTextArea.setText(MsfCsForeign);

    }
}
