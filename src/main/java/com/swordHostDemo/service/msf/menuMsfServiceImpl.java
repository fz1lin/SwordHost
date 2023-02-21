package com.swordHostDemo.service.msf;

import com.swordHostDemo.controller.MetasploitController;

import javax.swing.*;

/**
 * @date: 2023/1/20 21:34
 * @description:
 */
public class menuMsfServiceImpl implements menuMsfService {


    @Override
    public void msfShellMenu(
                             JTextField sessionIdTextField,
                             JTextArea msfRootTextArea, JTextField msfLinuxHexTextField,
                             JTextField msfLinuxELFTextField, JTextArea msfLinuxListenerTextArea,
                             JTextArea msfWindowsListenerTextArea,
                             JTextArea csMsfTextArea, JTextArea MSFcsTextArea
    ) {
        //msf init
        String payload = "exploit/linux/local/cve_2021_4034_pwnkit_lpe_pkexec";
        String rootCommand = MetasploitController.RootCommand(payload, sessionIdTextField.getText());
        msfRootTextArea.setText(rootCommand);

        //msf linuxPayload
        String MsflinuxHex = MetasploitController.MsflinuxHexCommand();
        msfLinuxHexTextField.setText(MsflinuxHex);

        //MSF linuxElfPayload
        String msflinuxELFCommand = MetasploitController.MsflinuxELFCommand();
        msfLinuxELFTextField.setText(msflinuxELFCommand);

        //msf LinuxListener
        String msfLinuxListener = MetasploitController.ListenerLinuxhandler();
        msfLinuxListenerTextArea.setText(msfLinuxListener);

        //msf WindowsListener
        String msfWindowsListener = MetasploitController.ListenerWindowshandler();
        msfWindowsListenerTextArea.setText(msfWindowsListener);

        //cs->msf CsMsfForeignCommand
        String CsMsfForeignStr = MetasploitController.CsMsfForeignCommand();
        csMsfTextArea.setText(CsMsfForeignStr);

        //msf->cs MsfCsForeignCommand
        String MsfCsForeign = MetasploitController.MsfCsForeignCommand();
        MSFcsTextArea.setText(MsfCsForeign);

    }
}
