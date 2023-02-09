package com.swordHostDemo.service.java;

import com.swordHostDemo.controller.FastjsonController;
import com.swordHostDemo.controller.Log4j2Controller;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:45
 * @description:
 */
public class menuJavaServiceImpl implements menuJavaService {

    @Override
    public void fastjsonMenu(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue, JTextArea FaEXP1TextArea, JTextArea FaDNSlogTextArea) {
        //FastjsonOption
        String fastjsonOption = FastjsonController.fastjsonEXP1(LhostValue.getText(), LportValue.getText());
        FaEXP1TextArea.setText(fastjsonOption);
        //FaDNSlogOption
        String faDNSlogOption = FastjsonController.fastjsonDnslog(DNSlogValue.getText());
        FaDNSlogTextArea.setText(faDNSlogOption);
    }

    @Override
    public void log4j2Menu(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue, JTextField LoIPTextArea, JTextField LoDNSlogTextArea) {
        //Log4j2Option
        String Log4j2Option = Log4j2Controller.LoIPlog4j2(LhostValue.getText(), LportValue.getText());
        LoIPTextArea.setText(Log4j2Option);
        //Log4j2DNSlogOption
        String Log4j2DNSlogOption = Log4j2Controller.LoDnslog4j2(DNSlogValue.getText());
        LoDNSlogTextArea.setText(Log4j2DNSlogOption);

    }
}
