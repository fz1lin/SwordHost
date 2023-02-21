package com.swordHostDemo.service.msf;

import javax.swing.*;

/**
 * @date: 2023/1/20 21:27
 * @description:
 */
public interface menuMsfService {
    /**
     * @param sessionIdTextField:
     * @param msfRootTextArea:
     * @param msfLinuxHexTextField:
     * @param msfLinuxELFTextField:
     * @param msfLinuxListenerTextArea:
     * @param msfWindowsListenerTextArea:
     * @param csMsfTextArea:
     * @param MSFcsTextArea:
     * @return: void
     * @date: 2023/1/20 21:47
     * @description: msf传入的值
     */
    void msfShellMenu(
                      JTextField sessionIdTextField,
                      JTextArea msfRootTextArea, JTextField msfLinuxHexTextField,
                      JTextField msfLinuxELFTextField, JTextArea msfLinuxListenerTextArea,
                      JTextArea msfWindowsListenerTextArea,
                      JTextArea csMsfTextArea, JTextArea MSFcsTextArea
    );
}
