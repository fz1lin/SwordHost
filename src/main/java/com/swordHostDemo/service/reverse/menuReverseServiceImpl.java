package com.swordHostDemo.service.reverse;

import com.swordHostDemo.controller.ReverseController;
import com.swordHostDemo.pojo.menuBeanListener;

import javax.swing.*;

/**
 * @date: 2023/1/20 12:05
 * @description:
 */
public class menuReverseServiceImpl implements menuReverseService {

    @Override
    public void reverseBashOptionsMenu( JTextField Bash1TextArea,
                                       JTextField Bash2TextArea, JTextField Bash3TCPTextField
            , JTextField Bash1UDPTextField, JTextField Bash2UDPTextField, JTextField  BashTCP4TextField
) {
     //Bash1Option
        String bash1Option = ReverseController.ReverseBashTCP1();
        Bash1TextArea.setText(bash1Option);

        //Bash2Option
        String bash2Option = ReverseController.ReverseBashTCP2();
        Bash2TextArea.setText(bash2Option);

        //Bash3TCP
        String bash3Options = ReverseController.ReverseBashTCP3();
        Bash3TCPTextField.setText(bash3Options);

        String bash4Option = ReverseController.ReverseBashTCP4();
        BashTCP4TextField.setText(bash4Option);

        //Bash udp 1
        String bash1UDP = ReverseController.ReverseBashUDPVictim();
        Bash1UDPTextField.setText(bash1UDP);

        //bash udp 2
        String bash2UDP = ReverseController.ReverseBashUDPListener();
        Bash2UDPTextField.setText(bash2UDP);
    }

    @Override
    public void reverseAwkOptionsMenu( JTextField ReverseAwkTextField) {

        String reverseAwkTextField = ReverseController.ReverseAWKString1();
        ReverseAwkTextField.setText(reverseAwkTextField);

    }
}
