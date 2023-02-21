package com.swordHostDemo;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.swordHostDemo.utls.SQLiteUtls;
import com.swordHostDemo.view.mainjFormGUI.jFormGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @date: 2022/12/27 19:11
 * @description:
 */
public class MainJFormGUI {


    public final static String VersionString = "Version：SwordHost " + "v1.0.0 beta 内测版";
    public static void main(String[] args) {
        //主题
        themeSwitch();

        //数据库类
        SQLiteUtls.init();

        //入口文件初始化必须在底下
        MainJFormGUI.init();
    }

    //入口文件
    public static void init() {
        //入口文件
        jFormGUI formTest = new jFormGUI();
        formTest.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        formTest.setVisible(true);
    }

    //主题
    public static void themeSwitch() {
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //圆角方角：
        UIManager.put("Button.arc", 50);
        UIManager.put("Component.arc", 50);
        //箭头类型：
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("Component.arrowType", "triangle");
        //滚动条
        UIManager.put("ScrollBar.showButtons", true);
        UIManager.put("ScrollBar.width", 16);

        //选项卡面板
        //选项颜色
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        //选项分割线
        UIManager.put("TabbedPane.showTabSeparators", true);

        //箭头类型
        UIManager.put("Component.arrowType", "triangle");
    }
}
