package com.swordHostDemo.view;

import com.swordHostDemo.view.mainjFormGUI.jFormGUI;
import org.junit.Test;

import javax.swing.*;

/**
 * @date: 2022/12/27 21:51
 * @description:
 */
public class jFormGUITest {
    @Test
    public void jFormGUITest1(){
        jFormGUI jFormGUI = new jFormGUI();
        jFormGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFormGUI.setVisible(true);
    }
}
