package com.swordHostDemo.service.java;

import javax.swing.*;

/**
 * @date: 2023/1/22 19:42
 * @description:
 */
public interface menuJavaService {

    /**
     * @param FaEXP1TextArea:
     * @param FaDNSlogTextArea:
     * @return: void
     * @date: 2023/1/22 21:44
     * @description: fastjson菜单相关
     */
    void fastjsonMenu(  JTextArea FaEXP1TextArea, JTextArea FaDNSlogTextArea,String inputString);

    /**
     * @param LoIPTextArea:
     * @param LoDNSlogTextArea:
     * @return: void
     * @date: 2023/1/22 21:44
     * @description: Log4j2 相关
     */
    void log4j2Menu( JTextField LoIPTextArea, JTextField LoDNSlogTextArea);
}
