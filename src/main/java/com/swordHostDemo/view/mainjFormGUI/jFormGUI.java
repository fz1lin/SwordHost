/*
 * Created by JFormDesigner on Tue Dec 27 14:58:35 CST 2022
 */

package com.swordHostDemo.view.mainjFormGUI;

import com.swordHostDemo.controller.MetasploitController;
import com.swordHostDemo.controller.ReController;
import com.swordHostDemo.controller.TimeStampController;
import com.swordHostDemo.dao.menuCurd.menuCurdDaoImpl;
import com.swordHostDemo.service.history.menuHistroyListImpl;
import com.swordHostDemo.service.java.menuJavaServiceImpl;
import com.swordHostDemo.service.msf.menuMsfServiceImpl;
import com.swordHostDemo.service.proxy.menuProxyServiceImpl;
import com.swordHostDemo.service.rce.menuRceServiceImpl;
import com.swordHostDemo.service.reverse.menuReverseServiceImpl;
import com.swordHostDemo.service.tools.menuToolsServiceImpl;
import com.swordHostDemo.utls.*;
import com.swordHostDemo.view.listViewGUI.listViewGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * @author null
 */
public class jFormGUI extends JFrame {
    public jFormGUI() {
        initComponents();
    }

    private final String VersionString = "Version：SwordHost " + "v1.0.0";
    private final String GitHubString = "\r\n" + "GitHub：https://github.com/fz1lin/SwordHost";
    private final String AuthorString = "\r\n" + "Author：By fz1lin";


    //程序启动的时候做的事情
    public void windowStartInit() {
        menuCurdDaoImpl menuDataService = new menuCurdDaoImpl();
        menuToolsServiceImpl menuToolsService = new menuToolsServiceImpl();

        try {
            //查询数据库值
            menuDataService.selectData(LhostValue, LportValue, DNSlogValue, RhostValue, RportVaule, CommandVaule, FileNameVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //menuToolsService
        menuToolsService.getTimeStamp(timeStampEchoTextField, StampTimeEchoTextField);
        menuToolsService.URLMenucomboBox1(URLMenucomboBox);
        menuToolsService.passwordInit(ABCcheckBox, abcckBox, NumcheckBox);
        menuToolsService.passwordcheckBoxInit(ABCcheckBox, abcckBox, NumcheckBox, PasswordLens, RandomTextField, SigncheckBox);

        //历史菜单初始化
        historyListInit();
    }


    //保存输入框输入的数据
    public void saveMenuData() {
        menuCurdDaoImpl menuDataService = new menuCurdDaoImpl();
        try {
            menuDataService.addData(LhostValue, LportValue, DNSlogValue, RhostValue, RportVaule, CommandVaule, FileNameVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //历史记录初始化
    public void historyListInit() {
        //List 隐藏
        HistoryLhostListScrollPane.setVisible(false);
        HistoryLportListScrollPane.setVisible(false);
        HistoryDnslogListScrollPane.setVisible(false);
        HistoryFilenameListScrollPane.setVisible(false);
        HistoryRhostListScrollPane.setVisible(false);
        HistoryRportListScrollPane.setVisible(false);
        HistoryCommandListScrollPane.setVisible(false);

        menuHistroyListImpl menuHistroyList = new menuHistroyListImpl();
        try {
            menuHistroyList.HistroyList(HistoryLhostValueJList, HistoryLportValueJList, HistoryDnslogtValueJList,
                    HistoryFilenametValueJList, HistoryRhostValueJList, HistoryRportValueJList, HistoryCommandValueJList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //实时监听菜单栏输入的值，然后变化对应的值
    public void menuKeyInit() {
        //menuReverseService
        menuReverseServiceImpl menuReverseService = new menuReverseServiceImpl();
        menuReverseService.reverseOptionsMenu(LhostValue, LportValue, Bash1TextArea, Bash2TextArea, JavaBashTextArea);

        //menuRceService
        menuRceServiceImpl menuRceService = new menuRceServiceImpl();
        menuRceService.rceMenu(LhostValue, LportValue, FileNameVaule, Curl1TextField, Curl2TextField, Wget1TextArea, PythonTextArea);

        //menuMsfService
        menuMsfServiceImpl menuMsfService = new menuMsfServiceImpl();
        menuMsfService.msfShellMenu(LhostValue, LportValue, FileNameVaule, sessionIdTextField, msfRootTextArea,
                msfLinuxHexTextField, msfLinuxELFTextField, msfLinuxListenerTextArea, msfWindowsListenerTextArea,
                csMsfTextArea, MSFcsTextArea);

        //menuProxyService
        menuProxyServiceImpl menuProxyService = new menuProxyServiceImpl();
        menuProxyService.stowawayOption(LhostValue, LportValue, FileNameVaule, stAdminTextArea, stLinuxAgentTextArea, stWindowsAgentTextArea);


        //menuJavaService
        menuJavaServiceImpl menuJavaService = new menuJavaServiceImpl();
        menuJavaService.fastjsonMenu(LhostValue, LportValue, DNSlogValue, FaEXP1TextArea, FaDNSlogTextArea);
        menuJavaService.log4j2Menu(LhostValue, LportValue, DNSlogValue, LoIPTextField, LoDNSlogTextField);

    }

    //Lhost
    private void LhostValueKeyReleased(KeyEvent e) {

        // TODO add your code here
        //测试
        System.out.println("GUI-lhost：" + LhostValue.getText());
        //调用方法
        menuKeyInit();

    }

    //Lport
    private void LportValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        System.out.println("GUI-lport：" + LportValue.getText());
        //调用方法
        menuKeyInit();
    }

    //Dnslog
    private void DNSlogValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        System.out.println("GUI-dnslog：" + DNSlogValue.getText());
        //调用方法
        menuKeyInit();
    }

    //Rhost
    private void RhostValueKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        System.out.println("GUI-rhost：" + RhostValue.getText());
        //调用方法
        menuKeyInit();
    }

    //Rport
    private void RportVauleKeyReleased(KeyEvent e) {
        //测试
        System.out.println("GUI-rport：" + RportVaule.getText());
        //调用方法
        menuKeyInit();

    }

    //Command
    private void CommandVauleKeyReleased(KeyEvent e) {
        // TODO add your code here
        //测试
        System.out.println("GUI-Command：" + CommandVaule.getText());
        //调用方法
        menuKeyInit();

    }

    //FielName
    private void FileNameVauleKeyReleased(KeyEvent e) {
        // TODO add your code here
        System.out.println("GUI-FileName：" + FileNameVaule.getText());
        menuKeyInit();
    }

    //base64按钮实现
    private void Babut2DeCodeMouseClicked(MouseEvent e) {
        // TODO add your code here
        String Base64DeText = Base64EnsTextArea.getText();
        String vaule = deCodeUtls.base64Decodes(Base64DeText);
        Bas64DeTextArea.setText(vaule);
    }

    private void Babut1EnCodeMouseClicked(MouseEvent e) {
        // TODO add your code here
        String Base64DeText = Base64EnsTextArea.getText();
        String vaule = enCodeUtls.base64Encode(Base64DeText);
        Bas64DeTextArea.setText(vaule);
    }

    //交换按钮功能实现
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        //交换按钮功能实现
        String a = Base64EnsTextArea.getText();
        String b = Bas64DeTextArea.getText();
        String t = a;
        Base64EnsTextArea.setText(t);
        a = b;
        Base64EnsTextArea.setText(a);
        b = t;
        Bas64DeTextArea.setText(b);
    }

    //窗口启动做的事情
    private void thisWindowOpened(WindowEvent e) {
        // TODO add your code here
        windowStartInit();
        menuKeyInit();
    }


    //password随机按钮点击
    private void RandomButtonMouseClicked(MouseEvent e) {
        // TODO add your code here

        menuToolsServiceImpl menuToolsService = new menuToolsServiceImpl();
        menuToolsService.passwordcheckBoxInit(ABCcheckBox, abcckBox, NumcheckBox, PasswordLens, RandomTextField, SigncheckBox);
    }


    private void IPCopybuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REip);
        CopyEcholabel.setText("复制IP正则表达式成功\r\n内容为：" + ReController.REip);
    }

    private void URLCopybuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REurl);
        CopyEcholabel.setText("复制URL正则表达式成功\r\n内容为：" + ReController.REurl);
    }

    private void URLPathbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REurlPath);
        CopyEcholabel.setText("复制URL+Path正则表达式成功\r\n内容为：" + ReController.REurlPath);
    }

    private void URLPortbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REurlPort);
        CopyEcholabel.setText("复制URL+port正则表达式成功\r\n内容为：" + ReController.REurlPort);
    }

    private void AliyunaAccessKeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAliyunAccessKey);
        CopyEcholabel.setText("复制AliyunAccessKey正则表达式成功\r\n内容为：" + ReController.REAliyunAccessKey);
    }

    private void AliyunSecretKeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAliyunSecretKey);
        CopyEcholabel.setText("复制AliyunSecretKey正则表达式成功\r\n内容为：" + ReController.REAliyunSecretKey);
    }

    private void AliyunOssUrlMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAliyunOssUrl);
        CopyEcholabel.setText("复制AliyunOssUrl正则表达式成功\r\n内容为：" + ReController.REAliyunOssUrl);
    }

    private void AWSAccessKeyIdMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAWS_AccessKeyId);
        CopyEcholabel.setText("复制AWS_AccessKeyId正则表达式成功\r\n内容为：" + ReController.REAWS_AccessKeyId);
    }

    private void AWSAuthTokenMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAWS_AuthToken);
        CopyEcholabel.setText("复制AWS_AuthToken正则表达式成功\r\n内容为：" + ReController.REAWS_AuthToken);
    }

    private void AWSURLMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.REAWS_url);
        CopyEcholabel.setText("复制AWS_url正则表达式成功\r\n内容为：" + ReController.REAWS_url);
    }


    private void SSHkeyMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.RESSH_key);
        CopyEcholabel.setText("复制SSH_key正则表达式成功\r\n内容为：" + ReController.RESSH_key);
    }

    private void RSAKEYbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(ReController.RErsa_key);
        CopyEcholabel.setText("复制rsa_key正则表达式成功\r\n内容为：" + ReController.RErsa_key);
    }

    private void CopyPasswordbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(RandomTextField.getText());
    }

    private void stCopyIpSocksButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String SocksText = stSocksTextField.getText();
        copyEchoText.init(LhostValue.getText() + ":" + SocksText);
    }

    private void msfCopyRootButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(msfRootTextField.getText());
    }

    private void msfCopyRootButton2MouseClicked(MouseEvent e) {
        // TODO add your code here
        String rootCommand = MetasploitController.RootCommand(msfPayloadCopyTextField.getText(), LhostValue.getText(), LportValue.getText(), sessionIdTextField.getText());
        copyEchoText.init(rootCommand);
        msfRootTextArea.setText(rootCommand);
    }

    private void FaCopyEXP1TextAreaMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(FaEXP1TextArea.getText());
        FaCopyEcholabel.setText("复制成功~");
    }

    private void BaCopyResButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(Bas64DeTextArea.getText());
        BaCopyEcholabel.setText("复制成功~");

    }


    private void thisWindowClosing(WindowEvent e) {
        // TODO add your code here
        System.out.println("程序关闭");
    }


    private void ReBash1ButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(Bash1TextArea.getText());
        ReCopyEcholabel.setText("复制 Bash1 成功");
    }

    private void ReBash2ButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(Bash2TextArea.getText());
        ReCopyEcholabel.setText("复制 Bash2 成功");
    }

    private void ReJavaBashbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(JavaBashTextArea.getText());
        ReCopyEcholabel.setText("复制 JavaBash 成功");
    }

    private void msfCopyHexButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(msfLinuxHexTextField.getText());
        msfCopyEcholabel.setText("复制 LinuxHex 成功");
    }

    private void msfCopyElfButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(msfLinuxELFTextField.getText());
        msfCopyEcholabel.setText("复制 LinuxELF 成功");
    }

    private void URLEnCodebuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String urlEncoderString = enCodeUtls.getURLEncoderString(URLEnCodeTextArea.getText());
        URLDeCodetextArea.setText(urlEncoderString);

    }

    private void button6MouseClicked(MouseEvent e) {
        // TODO add your code here
        String urlDecoderString = deCodeUtls.getURLDecoderString(URLEnCodeTextArea.getText());
        URLDeCodetextArea.setText(urlDecoderString);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        URLEnCodeTextArea.setText("");
        URLDeCodetextArea.setText("");
    }

    private void URLcopyEnCodeButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(URLEnCodeTextArea.getText());
        URLechoPageLabel.setText("复制 URLEnCode 成功~");
    }

    private void URLcopyDeCodeButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        copyEchoText.init(URLDeCodetextArea.getText());
        URLechoPageLabel.setText("复制 URLDeCode 成功~");
    }


    private void URLMenucomboBoxPopupMenuWillBecomeInvisible(PopupMenuEvent e) {
        // TODO add your code here

        String itemAt1 = (String) URLMenucomboBox.getSelectedItem();
        deCodeUtls.encodeCharSetUTF8 = itemAt1;
        enCodeUtls.encodeCharSetUTF8 = itemAt1;
        System.out.println(itemAt1);
    }


    private void timeStampEchobuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String s = TimeStampController.timeStamp2DateStr(timeStampEchoTextField.getText());
        timeStampEndTextField.setText(s);
    }

    private void StampTimeEchoButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String s = TimeStampController.date2TimeStampStr(StampTimeEchoTextField.getText());
        StampTimeEndTextField.setText(s);
    }

    private void button3MouseClicked(MouseEvent e) {
        // TODO add your code here
        timeStampEchoTextField.setText(TimeStampController.timeStamp());
    }

    private void button4MouseClicked(MouseEvent e) {
        // TODO add your code here
        String TimeStampEcho = TimeStampController.timeStamp2DateStr(TimeStampController.timeStamp());
        StampTimeEchoTextField.setText(TimeStampEcho);
    }

    private void sessionIdTextFieldKeyReleased(KeyEvent e) {
        // TODO add your code here
        String rootCommand = MetasploitController.RootCommand(msfPayloadCopyTextField.getText(), LhostValue.getText(), LportValue.getText(), sessionIdTextField.getText());
        copyEchoText.init(rootCommand);
        msfRootTextArea.setText(rootCommand);

    }

    private void msfPayloadCopyTextFieldKeyReleased(KeyEvent e) {
        // TODO add your code here
        String rootCommand = MetasploitController.RootCommand(msfPayloadCopyTextField.getText(), LhostValue.getText(), LportValue.getText(), sessionIdTextField.getText());
        copyEchoText.init(rootCommand);
        msfRootTextArea.setText(rootCommand);
    }

    private void unicodeEnCodeButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String unicodeEnCodestr = enCodeUtls.stringToUnicode(unicodeEnCodeTextArea.getText());
        System.out.println(unicodeEnCodestr);
        unicodeDeCodeTextArea.setText(unicodeEnCodestr);
    }

    private void unicodeDeCodeButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String unicodeDeCodestr = deCodeUtls.unicodeToString1(unicodeEnCodeTextArea.getText());
        unicodeDeCodeTextArea.setText(unicodeDeCodestr);
    }


    public JTextField getLhostValue() {
        return LhostValue;
    }

    private void HistoryLhostValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here

        String selectedValue = (String) HistoryLhostValueJList.getSelectedValue();
        System.out.println("HistoryLhostValueJList value: " + selectedValue);
        LhostValue.setText(selectedValue);
        menuKeyInit();
    }

    private void LhostValueFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryLhostListScrollPane.setVisible(true);
    }

    private void LhostValueFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryLhostListScrollPane.setVisible(false);

    }

    private void HistoryLportValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryLportValueJList.getSelectedValue();
        System.out.println("HistoryLportValueJList value: " + selectedValue);
        LportValue.setText(selectedValue);
        menuKeyInit();
    }

    private void LportValueFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryLportListScrollPane.setVisible(true);
    }

    private void LportValueFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryLportListScrollPane.setVisible(false);
    }

    private void DNSlogValueFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryDnslogListScrollPane.setVisible(true);
    }

    private void DNSlogValueFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryDnslogListScrollPane.setVisible(false);
    }

    private void FileNameVauleFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryFilenameListScrollPane.setVisible(true);
    }

    private void FileNameVauleFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryFilenameListScrollPane.setVisible(false);
    }

    private void RhostValueFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryRhostListScrollPane.setVisible(true);
    }

    private void RhostValueFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryRhostListScrollPane.setVisible(false);
    }

    private void RportVauleFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryRportListScrollPane.setVisible(true);
    }

    private void RportVauleFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryRportListScrollPane.setVisible(false);
    }

    private void CommandVauleFocusGained(FocusEvent e) {
        // TODO add your code here
        HistoryCommandListScrollPane.setVisible(true);
    }

    private void CommandVauleFocusLost(FocusEvent e) {
        // TODO add your code here
        HistoryCommandListScrollPane.setVisible(false);
    }

    private void HistoryDnslogtValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryDnslogtValueJList.getSelectedValue();
        System.out.println("HistoryDnslogtValueJList value: " + selectedValue);
        DNSlogValue.setText(selectedValue);
        menuKeyInit();
    }

    private void HistoryFilenametValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryFilenametValueJList.getSelectedValue();
        System.out.println("HistoryFilenametValueJList value: " + selectedValue);
        FileNameVaule.setText(selectedValue);
        menuKeyInit();
    }

    private void HistoryRhostValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryRhostValueJList.getSelectedValue();
        System.out.println("HistoryRhostValueJList value: " + selectedValue);
        RhostValue.setText(selectedValue);
        menuKeyInit();
    }

    private void HistoryRportValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryRportValueJList.getSelectedValue();
        System.out.println("HistoryRportValueJList value: " + selectedValue);
        RportVaule.setText(selectedValue);
        menuKeyInit();
    }

    private void HistoryCommandValueJListMouseClicked(MouseEvent e) {
        // TODO add your code here
        String selectedValue = (String) HistoryCommandValueJList.getSelectedValue();
        System.out.println("HistoryCommandValueJList value: " + selectedValue);
        CommandVaule.setText(selectedValue);
        menuKeyInit();
    }

    private void saveMenuButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        if (!regularUtls.reHost(LhostValue.getText())) {
            JOptionPane.showMessageDialog(null, "保存失败！ LHOST 输入非法！\r\n范围：0.0.0.0~255.255.255.255", "提示", JOptionPane.ERROR_MESSAGE);
        } else if (!regularUtls.rePort(LportValue.getText())) {
            JOptionPane.showMessageDialog(null, "保存失败！ LPORT 输入非法！\r\n范围：1~65535", "提示", JOptionPane.ERROR_MESSAGE);
        } else if (!regularUtls.reHost(RhostValue.getText())) {
            JOptionPane.showMessageDialog(null, "保存失败！ RHOST 输入非法！\r\n范围：0.0.0.0~255.255.255.255", "提示", JOptionPane.ERROR_MESSAGE);
        } else if (!regularUtls.rePort(RportVaule.getText()) || RportVaule.getText() == null) {
            JOptionPane.showMessageDialog(null, "保存失败！ RPORT 输入非法！\r\n范围：1~65535", "提示", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "保存成功！\r\n请不要删除 data.db 文件", "提示", JOptionPane.INFORMATION_MESSAGE);
            saveMenuData();
        }

    }

    private void AboutOptionsMenuItemMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void AboutOptions(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null, VersionString + GitHubString + AuthorString, "关于", JOptionPane.INFORMATION_MESSAGE);

    }

    private void DelectbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        listViewGUI listviewGUI = new listViewGUI();
        listviewGUI.setVisible(true);
        listviewGUI.start();
        System.out.println("点击了");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("jFormGUI");
        AboutOptionsMenuBar = new JMenuBar();
        AboutOptionsMenu = new JMenu();
        AboutOptionsMenuItem = new JMenuItem();
        inputFields = new JPanel();
        RPanel2 = new JPanel();
        RHOST = new JLabel();
        RPORT = new JLabel();
        RhostValue = new JTextField();
        RportVaule = new JTextField();
        Command = new JLabel();
        CommandVaule = new JTextField();
        HistoryRhostListScrollPane = new JScrollPane();
        HistoryRhostValueJList = new JList();
        HistoryCommandListScrollPane = new JScrollPane();
        HistoryCommandValueJList = new JList();
        HistoryRportListScrollPane = new JScrollPane();
        HistoryRportValueJList = new JList();
        saveMenuButton = new JButton();
        Delectbutton = new JButton();
        LPanel1 = new JPanel();
        LHOST = new JLabel();
        LPORT = new JLabel();
        LhostValue = new JTextField();
        LportValue = new JTextField();
        DNSLog = new JLabel();
        DNSlogValue = new JTextField();
        FileName = new JLabel();
        FileNameVaule = new JTextField();
        HistoryLhostListScrollPane = new JScrollPane();
        HistoryLhostValueJList = new JList();
        HistoryLportListScrollPane = new JScrollPane();
        HistoryLportValueJList = new JList();
        HistoryDnslogListScrollPane = new JScrollPane();
        HistoryDnslogtValueJList = new JList();
        HistoryFilenameListScrollPane = new JScrollPane();
        HistoryFilenametValueJList = new JList();
        outputPanel = new JPanel();
        JtabbedPan11 = new JTabbedPane();
        ReverseMenu = new JTabbedPane();
        BashOptions = new JPanel();
        label30 = new JLabel();
        label35 = new JLabel();
        Bash1TextArea = new JTextField();
        Bash2TextArea = new JTextField();
        label43 = new JLabel();
        JavaBashTextArea = new JTextField();
        ReBash1Button = new JButton();
        ReBash2Button = new JButton();
        ReJavaBashbutton = new JButton();
        ReCopyEcholabel = new JLabel();
        RCEMenu = new JPanel();
        CurlOption = new JTabbedPane();
        panel3 = new JPanel();
        label6 = new JLabel();
        Curl2TextField = new JTextField();
        label8 = new JLabel();
        Curl1TextField = new JTextField();
        label7 = new JLabel();
        label9 = new JLabel();
        WgetOption = new JPanel();
        scrollPane7 = new JScrollPane();
        Wget1TextArea = new JTextArea();
        PythonOption = new JPanel();
        scrollPane12 = new JScrollPane();
        PythonTextArea = new JTextArea();
        msfs = new JTabbedPane();
        LinuxPayloadOptions = new JPanel();
        msfLinuxHexText = new JLabel();
        msfLinuxHexTextField = new JTextField();
        label34 = new JLabel();
        msfLinuxELFTextField = new JTextField();
        msfCopyHexButton = new JButton();
        msfCopyElfButton = new JButton();
        msfCopyEcholabel = new JLabel();
        msfListenerOptions = new JPanel();
        label36 = new JLabel();
        label37 = new JLabel();
        scrollPane16 = new JScrollPane();
        msfLinuxListenerTextArea = new JTextArea();
        scrollPane17 = new JScrollPane();
        msfWindowsListenerTextArea = new JTextArea();
        msfRootOptions = new JPanel();
        msfRootTextField = new JTextField();
        label28 = new JLabel();
        msfCopyRootButton = new JButton();
        label29 = new JLabel();
        msfCopyRootButton2 = new JButton();
        label31 = new JLabel();
        sessionIdTextField = new JTextField();
        scrollPane15 = new JScrollPane();
        msfRootTextArea = new JTextArea();
        msfPayloadCopyTextField = new JTextField();
        label32 = new JLabel();
        label67 = new JLabel();
        CsMsfOptions = new JPanel();
        scrollPane3 = new JScrollPane();
        csMsfTextArea = new JTextArea();
        label33 = new JLabel();
        label42 = new JLabel();
        label46 = new JLabel();
        label47 = new JLabel();
        label48 = new JLabel();
        label49 = new JLabel();
        label50 = new JLabel();
        label51 = new JLabel();
        label59 = new JLabel();
        MsfCsOptions = new JPanel();
        label52 = new JLabel();
        label53 = new JLabel();
        label54 = new JLabel();
        label55 = new JLabel();
        label56 = new JLabel();
        label57 = new JLabel();
        label58 = new JLabel();
        label60 = new JLabel();
        scrollPane5 = new JScrollPane();
        MSFcsTextArea = new JTextArea();
        Stoways = new JTabbedPane();
        AdminOptions = new JPanel();
        label5 = new JLabel();
        scrollPane4 = new JScrollPane();
        stAdminTextArea = new JTextArea();
        label19 = new JLabel();
        label20 = new JLabel();
        label21 = new JLabel();
        stSocksTextField = new JTextField();
        stCopyIpSocksButton = new JButton();
        label22 = new JLabel();
        label23 = new JLabel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        label27 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        AgentOptions = new JPanel();
        label17 = new JLabel();
        label18 = new JLabel();
        scrollPane13 = new JScrollPane();
        stLinuxAgentTextArea = new JTextArea();
        scrollPane14 = new JScrollPane();
        stWindowsAgentTextArea = new JTextArea();
        JavaMenu = new JPanel();
        tabbedPane4 = new JTabbedPane();
        FastjsonOptions = new JPanel();
        label38 = new JLabel();
        textField5 = new JTextField();
        label39 = new JLabel();
        scrollPane18 = new JScrollPane();
        FaDNSlogTextArea = new JTextArea();
        FaEXP1Options = new JPanel();
        FaEXP1 = new JScrollPane();
        FaEXP1TextArea = new JTextArea();
        FaCopyEXP1TextArea = new JButton();
        FaCopyEcholabel = new JLabel();
        Log4j2Options = new JPanel();
        label40 = new JLabel();
        LoIPTextField = new JTextField();
        label41 = new JLabel();
        LoDNSlogTextField = new JTextField();
        REs = new JPanel();
        tabbedPane3 = new JTabbedPane();
        panel9 = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        IPCopybutton = new JButton();
        CopyEcholabel = new JLabel();
        URLCopybutton = new JButton();
        URLPathbutton = new JButton();
        URLPortbutton = new JButton();
        AliyunaAccessKey = new JButton();
        label10 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        AliyunSecretKey = new JButton();
        AliyunOssUrl = new JButton();
        label15 = new JLabel();
        AWSAccessKeyId = new JButton();
        AWSAuthToken = new JButton();
        AWSURL = new JButton();
        label16 = new JLabel();
        SSHkey = new JButton();
        RSAKEYbutton = new JButton();
        DeCodeAndEnCodes = new JPanel();
        DeAndEnCodeBase64s = new JTabbedPane();
        Base64DeCodes = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane10 = new JScrollPane();
        Bas64DeTextArea = new JTextArea();
        Babut1EnCode = new JButton();
        Babut2DeCode = new JButton();
        Base64buttonSwap = new JButton();
        scrollPane11 = new JScrollPane();
        Base64EnsTextArea = new JTextArea();
        BaCopyResButton = new JButton();
        BaCopyEcholabel = new JLabel();
        URLOptions = new JPanel();
        scrollPane1 = new JScrollPane();
        URLEnCodeTextArea = new JTextArea();
        URLEnCodebutton = new JButton();
        scrollPane2 = new JScrollPane();
        URLDeCodetextArea = new JTextArea();
        URLcopyDeCodeButton = new JButton();
        URLcopyEnCodeButton = new JButton();
        button6 = new JButton();
        label44 = new JLabel();
        label45 = new JLabel();
        button1 = new JButton();
        URLechoPageLabel = new JLabel();
        URLMenucomboBox = new JComboBox();
        UnicodeOptions = new JPanel();
        scrollPane6 = new JScrollPane();
        unicodeEnCodeTextArea = new JTextArea();
        scrollPane8 = new JScrollPane();
        unicodeDeCodeTextArea = new JTextArea();
        label3 = new JLabel();
        unicodeEnCodeButton = new JButton();
        unicodeDeCodeButton = new JButton();
        label64 = new JLabel();
        RandomMenu = new JTabbedPane();
        RaPasswordOptions = new JPanel();
        RaPasswordpanel = new JPanel();
        RandomButton = new JButton();
        RandomTextField = new JTextField();
        ABCcheckBox = new JCheckBox();
        abcckBox = new JCheckBox();
        NumcheckBox = new JCheckBox();
        SigncheckBox = new JCheckBox();
        PasswordLens = new JSpinner();
        label4 = new JLabel();
        CopyPasswordbutton = new JButton();
        panel1 = new JPanel();
        label61 = new JLabel();
        timeStampEchoTextField = new JTextField();
        timeStampEchobutton = new JButton();
        timeStampEndTextField = new JTextField();
        label62 = new JLabel();
        label63 = new JLabel();
        StampTimeEchoTextField = new JTextField();
        StampTimeEchoButton = new JButton();
        StampTimeEndTextField = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        label65 = new JLabel();
        label66 = new JLabel();
        CustomEditMenu = new JTabbedPane();
        CustomEditOptions = new JScrollPane();
        CustomEdit1TextArea = new JTextArea();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
            @Override
            public void windowOpened(WindowEvent e) {
                thisWindowOpened(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== AboutOptionsMenuBar ========
        {

            //======== AboutOptionsMenu ========
            {
                AboutOptionsMenu.setText(bundle.getString("AboutOptionsMenu.text"));

                //---- AboutOptionsMenuItem ----
                AboutOptionsMenuItem.setText(bundle.getString("AboutOptionsMenuItem.text"));
                AboutOptionsMenuItem.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        AboutOptionsMenuItemMouseClicked(e);
                    }
                });
                AboutOptionsMenuItem.addActionListener(e -> AboutOptions(e));
                AboutOptionsMenu.add(AboutOptionsMenuItem);
            }
            AboutOptionsMenuBar.add(AboutOptionsMenu);
        }
        setJMenuBar(AboutOptionsMenuBar);

        //======== inputFields ========
        {
            inputFields.setBorder(new EmptyBorder(12, 12, 12, 12));
            inputFields.setLayout(null);

            //======== RPanel2 ========
            {
                RPanel2.setLayout(null);

                //---- RHOST ----
                RHOST.setText(bundle.getString("RHOST.text"));
                RPanel2.add(RHOST);
                RHOST.setBounds(10, 10, 55, RHOST.getPreferredSize().height);

                //---- RPORT ----
                RPORT.setText("RPORT");
                RPanel2.add(RPORT);
                RPORT.setBounds(210, 10, 55, RPORT.getPreferredSize().height);

                //---- RhostValue ----
                RhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RhostValueKeyReleased(e);
                    }
                });
                RhostValue.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        RhostValueFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        RhostValueFocusLost(e);
                    }
                });
                RPanel2.add(RhostValue);
                RhostValue.setBounds(65, 5, 130, RhostValue.getPreferredSize().height);

                //---- RportVaule ----
                RportVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        RportVauleKeyReleased(e);
                    }
                });
                RportVaule.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        RportVauleFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        RportVauleFocusLost(e);
                    }
                });
                RPanel2.add(RportVaule);
                RportVaule.setBounds(265, 5, 75, RportVaule.getPreferredSize().height);

                //---- Command ----
                Command.setText("Command");
                RPanel2.add(Command);
                Command.setBounds(350, 10, 70, Command.getPreferredSize().height);

                //---- CommandVaule ----
                CommandVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        CommandVauleKeyReleased(e);
                    }
                });
                CommandVaule.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        CommandVauleFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        CommandVauleFocusLost(e);
                    }
                });
                RPanel2.add(CommandVaule);
                CommandVaule.setBounds(420, 5, 125, CommandVaule.getPreferredSize().height);

                //======== HistoryRhostListScrollPane ========
                {

                    //---- HistoryRhostValueJList ----
                    HistoryRhostValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryRhostValueJListMouseClicked(e);
                        }
                    });
                    HistoryRhostListScrollPane.setViewportView(HistoryRhostValueJList);
                }
                RPanel2.add(HistoryRhostListScrollPane);
                HistoryRhostListScrollPane.setBounds(65, 30, 130, 85);

                //======== HistoryCommandListScrollPane ========
                {

                    //---- HistoryCommandValueJList ----
                    HistoryCommandValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryCommandValueJListMouseClicked(e);
                        }
                    });
                    HistoryCommandListScrollPane.setViewportView(HistoryCommandValueJList);
                }
                RPanel2.add(HistoryCommandListScrollPane);
                HistoryCommandListScrollPane.setBounds(420, 30, 125, 80);

                //======== HistoryRportListScrollPane ========
                {

                    //---- HistoryRportValueJList ----
                    HistoryRportValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryRportValueJListMouseClicked(e);
                        }
                    });
                    HistoryRportListScrollPane.setViewportView(HistoryRportValueJList);
                }
                RPanel2.add(HistoryRportListScrollPane);
                HistoryRportListScrollPane.setBounds(265, 30, 75, 80);

                //---- saveMenuButton ----
                saveMenuButton.setText(bundle.getString("saveMenuButton.text"));
                saveMenuButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        saveMenuButtonMouseClicked(e);
                    }
                });
                RPanel2.add(saveMenuButton);
                saveMenuButton.setBounds(new Rectangle(new Point(570, 5), saveMenuButton.getPreferredSize()));

                //---- Delectbutton ----
                Delectbutton.setText(bundle.getString("Delectbutton.text"));
                Delectbutton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DelectbuttonMouseClicked(e);
                    }
                });
                RPanel2.add(Delectbutton);
                Delectbutton.setBounds(new Rectangle(new Point(670, 5), Delectbutton.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < RPanel2.getComponentCount(); i++) {
                        Rectangle bounds = RPanel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = RPanel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    RPanel2.setMinimumSize(preferredSize);
                    RPanel2.setPreferredSize(preferredSize);
                }
            }
            inputFields.add(RPanel2);
            RPanel2.setBounds(10, 95, 785, 105);

            //======== LPanel1 ========
            {
                LPanel1.setLayout(null);

                //---- LHOST ----
                LHOST.setText(bundle.getString("LHOST.text"));
                LPanel1.add(LHOST);
                LHOST.setBounds(10, 10, 55, LHOST.getPreferredSize().height);

                //---- LPORT ----
                LPORT.setText("LPORT");
                LPanel1.add(LPORT);
                LPORT.setBounds(210, 10, 55, LPORT.getPreferredSize().height);

                //---- LhostValue ----
                LhostValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LhostValueKeyReleased(e);
                    }
                });
                LhostValue.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        LhostValueFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        LhostValueFocusLost(e);
                    }
                });
                LPanel1.add(LhostValue);
                LhostValue.setBounds(65, 5, 130, LhostValue.getPreferredSize().height);

                //---- LportValue ----
                LportValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        LportValueKeyReleased(e);
                    }
                });
                LportValue.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        LportValueFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        LportValueFocusLost(e);
                    }
                });
                LPanel1.add(LportValue);
                LportValue.setBounds(265, 5, 75, LportValue.getPreferredSize().height);

                //---- DNSLog ----
                DNSLog.setText("DNSLog");
                LPanel1.add(DNSLog);
                DNSLog.setBounds(350, 10, 65, DNSLog.getPreferredSize().height);

                //---- DNSlogValue ----
                DNSlogValue.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        DNSlogValueKeyReleased(e);
                    }
                });
                DNSlogValue.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        DNSlogValueFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        DNSlogValueFocusLost(e);
                    }
                });
                LPanel1.add(DNSlogValue);
                DNSlogValue.setBounds(425, 5, 125, DNSlogValue.getPreferredSize().height);

                //---- FileName ----
                FileName.setText("FileName");
                LPanel1.add(FileName);
                FileName.setBounds(555, 10, 70, 17);

                //---- FileNameVaule ----
                FileNameVaule.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        FileNameVauleKeyReleased(e);
                    }
                });
                FileNameVaule.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        FileNameVauleFocusGained(e);
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        FileNameVauleFocusLost(e);
                    }
                });
                LPanel1.add(FileNameVaule);
                FileNameVaule.setBounds(620, 5, 135, 30);

                //======== HistoryLhostListScrollPane ========
                {

                    //---- HistoryLhostValueJList ----
                    HistoryLhostValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryLhostValueJListMouseClicked(e);
                        }
                    });
                    HistoryLhostListScrollPane.setViewportView(HistoryLhostValueJList);
                }
                LPanel1.add(HistoryLhostListScrollPane);
                HistoryLhostListScrollPane.setBounds(65, 30, 130, 70);

                //======== HistoryLportListScrollPane ========
                {

                    //---- HistoryLportValueJList ----
                    HistoryLportValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryLportValueJListMouseClicked(e);
                        }
                    });
                    HistoryLportListScrollPane.setViewportView(HistoryLportValueJList);
                }
                LPanel1.add(HistoryLportListScrollPane);
                HistoryLportListScrollPane.setBounds(265, 30, 75, 70);

                //======== HistoryDnslogListScrollPane ========
                {

                    //---- HistoryDnslogtValueJList ----
                    HistoryDnslogtValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryDnslogtValueJListMouseClicked(e);
                        }
                    });
                    HistoryDnslogListScrollPane.setViewportView(HistoryDnslogtValueJList);
                }
                LPanel1.add(HistoryDnslogListScrollPane);
                HistoryDnslogListScrollPane.setBounds(425, 30, 125, 70);

                //======== HistoryFilenameListScrollPane ========
                {

                    //---- HistoryFilenametValueJList ----
                    HistoryFilenametValueJList.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            HistoryFilenametValueJListMouseClicked(e);
                        }
                    });
                    HistoryFilenameListScrollPane.setViewportView(HistoryFilenametValueJList);
                }
                LPanel1.add(HistoryFilenameListScrollPane);
                HistoryFilenameListScrollPane.setBounds(620, 30, 135, 65);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < LPanel1.getComponentCount(); i++) {
                        Rectangle bounds = LPanel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = LPanel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    LPanel1.setMinimumSize(preferredSize);
                    LPanel1.setPreferredSize(preferredSize);
                }
            }
            inputFields.add(LPanel1);
            LPanel1.setBounds(10, 0, 800, 100);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < inputFields.getComponentCount(); i++) {
                    Rectangle bounds = inputFields.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = inputFields.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                inputFields.setMinimumSize(preferredSize);
                inputFields.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(inputFields);
        inputFields.setBounds(5, 0, 820, 210);

        //======== outputPanel ========
        {
            outputPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
            outputPanel.setLayout(null);

            //======== JtabbedPan11 ========
            {

                //======== ReverseMenu ========
                {
                    ReverseMenu.setTabPlacement(SwingConstants.LEFT);

                    //======== BashOptions ========
                    {
                        BashOptions.setLayout(null);

                        //---- label30 ----
                        label30.setText(bundle.getString("label30.text"));
                        BashOptions.add(label30);
                        label30.setBounds(new Rectangle(new Point(25, 10), label30.getPreferredSize()));

                        //---- label35 ----
                        label35.setText(bundle.getString("label35.text"));
                        BashOptions.add(label35);
                        label35.setBounds(new Rectangle(new Point(25, 75), label35.getPreferredSize()));
                        BashOptions.add(Bash1TextArea);
                        Bash1TextArea.setBounds(20, 35, 565, Bash1TextArea.getPreferredSize().height);
                        BashOptions.add(Bash2TextArea);
                        Bash2TextArea.setBounds(20, 100, 565, Bash2TextArea.getPreferredSize().height);

                        //---- label43 ----
                        label43.setText(bundle.getString("label43.text"));
                        BashOptions.add(label43);
                        label43.setBounds(new Rectangle(new Point(25, 145), label43.getPreferredSize()));
                        BashOptions.add(JavaBashTextArea);
                        JavaBashTextArea.setBounds(20, 175, 565, JavaBashTextArea.getPreferredSize().height);

                        //---- ReBash1Button ----
                        ReBash1Button.setText(bundle.getString("ReBash1Button.text"));
                        ReBash1Button.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                ReBash1ButtonMouseClicked(e);
                            }
                        });
                        BashOptions.add(ReBash1Button);
                        ReBash1Button.setBounds(new Rectangle(new Point(605, 35), ReBash1Button.getPreferredSize()));

                        //---- ReBash2Button ----
                        ReBash2Button.setText(bundle.getString("ReBash2Button.text"));
                        ReBash2Button.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                ReBash2ButtonMouseClicked(e);
                            }
                        });
                        BashOptions.add(ReBash2Button);
                        ReBash2Button.setBounds(new Rectangle(new Point(605, 100), ReBash2Button.getPreferredSize()));

                        //---- ReJavaBashbutton ----
                        ReJavaBashbutton.setText(bundle.getString("ReJavaBashbutton.text"));
                        ReJavaBashbutton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                ReJavaBashbuttonMouseClicked(e);
                            }
                        });
                        BashOptions.add(ReJavaBashbutton);
                        ReJavaBashbutton.setBounds(new Rectangle(new Point(605, 175), ReJavaBashbutton.getPreferredSize()));
                        BashOptions.add(ReCopyEcholabel);
                        ReCopyEcholabel.setBounds(25, 315, 655, 30);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < BashOptions.getComponentCount(); i++) {
                                Rectangle bounds = BashOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = BashOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            BashOptions.setMinimumSize(preferredSize);
                            BashOptions.setPreferredSize(preferredSize);
                        }
                    }
                    ReverseMenu.addTab(bundle.getString("BashOptions.tab.title"), BashOptions);
                }
                JtabbedPan11.addTab(bundle.getString("ReverseMenu.tab.title"), ReverseMenu);

                //======== RCEMenu ========
                {
                    RCEMenu.setLayout(null);

                    //======== CurlOption ========
                    {
                        CurlOption.setTabPlacement(SwingConstants.LEFT);

                        //======== panel3 ========
                        {
                            panel3.setLayout(null);

                            //---- label6 ----
                            label6.setText(bundle.getString("label6.text"));
                            panel3.add(label6);
                            label6.setBounds(new Rectangle(new Point(20, 35), label6.getPreferredSize()));
                            panel3.add(Curl2TextField);
                            Curl2TextField.setBounds(20, 150, 645, 30);

                            //---- label8 ----
                            label8.setText(bundle.getString("label8.text"));
                            panel3.add(label8);
                            label8.setBounds(20, 125, 43, 17);
                            panel3.add(Curl1TextField);
                            Curl1TextField.setBounds(20, 85, 645, 30);

                            //---- label7 ----
                            label7.setText(bundle.getString("label7.text"));
                            panel3.add(label7);
                            label7.setBounds(20, 60, 43, 17);

                            //---- label9 ----
                            label9.setText(bundle.getString("label9.text"));
                            panel3.add(label9);
                            label9.setBounds(20, 5, 105, 30);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel3.getComponentCount(); i++) {
                                    Rectangle bounds = panel3.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel3.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel3.setMinimumSize(preferredSize);
                                panel3.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("panel3.tab.title"), panel3);

                        //======== WgetOption ========
                        {
                            WgetOption.setLayout(null);

                            //======== scrollPane7 ========
                            {
                                scrollPane7.setViewportView(Wget1TextArea);
                            }
                            WgetOption.add(scrollPane7);
                            scrollPane7.setBounds(20, 25, 670, 130);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < WgetOption.getComponentCount(); i++) {
                                    Rectangle bounds = WgetOption.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = WgetOption.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                WgetOption.setMinimumSize(preferredSize);
                                WgetOption.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("WgetOption.tab.title"), WgetOption);

                        //======== PythonOption ========
                        {
                            PythonOption.setLayout(null);

                            //======== scrollPane12 ========
                            {
                                scrollPane12.setViewportView(PythonTextArea);
                            }
                            PythonOption.add(scrollPane12);
                            scrollPane12.setBounds(20, 25, 665, 145);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < PythonOption.getComponentCount(); i++) {
                                    Rectangle bounds = PythonOption.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = PythonOption.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                PythonOption.setMinimumSize(preferredSize);
                                PythonOption.setPreferredSize(preferredSize);
                            }
                        }
                        CurlOption.addTab(bundle.getString("PythonOption.tab.title"), PythonOption);
                    }
                    RCEMenu.add(CurlOption);
                    CurlOption.setBounds(0, 0, 800, 380);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < RCEMenu.getComponentCount(); i++) {
                            Rectangle bounds = RCEMenu.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = RCEMenu.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        RCEMenu.setMinimumSize(preferredSize);
                        RCEMenu.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPan11.addTab(bundle.getString("RCEMenu.tab.title"), RCEMenu);

                //======== msfs ========
                {
                    msfs.setTabPlacement(SwingConstants.LEFT);

                    //======== LinuxPayloadOptions ========
                    {
                        LinuxPayloadOptions.setLayout(null);

                        //---- msfLinuxHexText ----
                        msfLinuxHexText.setText(bundle.getString("msfLinuxHexText.text"));
                        LinuxPayloadOptions.add(msfLinuxHexText);
                        msfLinuxHexText.setBounds(new Rectangle(new Point(25, 25), msfLinuxHexText.getPreferredSize()));
                        LinuxPayloadOptions.add(msfLinuxHexTextField);
                        msfLinuxHexTextField.setBounds(20, 50, 545, msfLinuxHexTextField.getPreferredSize().height);

                        //---- label34 ----
                        label34.setText(bundle.getString("label34.text"));
                        LinuxPayloadOptions.add(label34);
                        label34.setBounds(new Rectangle(new Point(25, 95), label34.getPreferredSize()));
                        LinuxPayloadOptions.add(msfLinuxELFTextField);
                        msfLinuxELFTextField.setBounds(20, 125, 545, msfLinuxELFTextField.getPreferredSize().height);

                        //---- msfCopyHexButton ----
                        msfCopyHexButton.setText(bundle.getString("msfCopyHexButton.text"));
                        msfCopyHexButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyHexButtonMouseClicked(e);
                            }
                        });
                        LinuxPayloadOptions.add(msfCopyHexButton);
                        msfCopyHexButton.setBounds(new Rectangle(new Point(580, 50), msfCopyHexButton.getPreferredSize()));

                        //---- msfCopyElfButton ----
                        msfCopyElfButton.setText(bundle.getString("msfCopyElfButton.text"));
                        msfCopyElfButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyElfButtonMouseClicked(e);
                            }
                        });
                        LinuxPayloadOptions.add(msfCopyElfButton);
                        msfCopyElfButton.setBounds(new Rectangle(new Point(580, 125), msfCopyElfButton.getPreferredSize()));
                        LinuxPayloadOptions.add(msfCopyEcholabel);
                        msfCopyEcholabel.setBounds(35, 290, 485, 30);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < LinuxPayloadOptions.getComponentCount(); i++) {
                                Rectangle bounds = LinuxPayloadOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = LinuxPayloadOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            LinuxPayloadOptions.setMinimumSize(preferredSize);
                            LinuxPayloadOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("LinuxPayloadOptions.tab.title"), LinuxPayloadOptions);

                    //======== msfListenerOptions ========
                    {
                        msfListenerOptions.setLayout(null);

                        //---- label36 ----
                        label36.setText(bundle.getString("label36.text"));
                        msfListenerOptions.add(label36);
                        label36.setBounds(new Rectangle(new Point(30, 20), label36.getPreferredSize()));

                        //---- label37 ----
                        label37.setText(bundle.getString("label37.text"));
                        msfListenerOptions.add(label37);
                        label37.setBounds(new Rectangle(new Point(30, 175), label37.getPreferredSize()));

                        //======== scrollPane16 ========
                        {
                            scrollPane16.setViewportView(msfLinuxListenerTextArea);
                        }
                        msfListenerOptions.add(scrollPane16);
                        scrollPane16.setBounds(25, 45, 610, 110);

                        //======== scrollPane17 ========
                        {
                            scrollPane17.setViewportView(msfWindowsListenerTextArea);
                        }
                        msfListenerOptions.add(scrollPane17);
                        scrollPane17.setBounds(25, 205, 610, 105);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < msfListenerOptions.getComponentCount(); i++) {
                                Rectangle bounds = msfListenerOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = msfListenerOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            msfListenerOptions.setMinimumSize(preferredSize);
                            msfListenerOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("msfListenerOptions.tab.title"), msfListenerOptions);

                    //======== msfRootOptions ========
                    {
                        msfRootOptions.setLayout(null);

                        //---- msfRootTextField ----
                        msfRootTextField.setText(bundle.getString("msfRootTextField.text"));
                        msfRootOptions.add(msfRootTextField);
                        msfRootTextField.setBounds(20, 35, 300, msfRootTextField.getPreferredSize().height);

                        //---- label28 ----
                        label28.setText(bundle.getString("label28.text"));
                        msfRootOptions.add(label28);
                        label28.setBounds(new Rectangle(new Point(20, 10), label28.getPreferredSize()));

                        //---- msfCopyRootButton ----
                        msfCopyRootButton.setText(bundle.getString("msfCopyRootButton.text"));
                        msfCopyRootButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyRootButtonMouseClicked(e);
                            }
                        });
                        msfRootOptions.add(msfCopyRootButton);
                        msfCopyRootButton.setBounds(new Rectangle(new Point(340, 35), msfCopyRootButton.getPreferredSize()));

                        //---- label29 ----
                        label29.setText(bundle.getString("label29.text"));
                        msfRootOptions.add(label29);
                        label29.setBounds(new Rectangle(new Point(30, 75), label29.getPreferredSize()));

                        //---- msfCopyRootButton2 ----
                        msfCopyRootButton2.setText(bundle.getString("msfCopyRootButton2.text"));
                        msfCopyRootButton2.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                msfCopyRootButton2MouseClicked(e);
                            }
                        });
                        msfRootOptions.add(msfCopyRootButton2);
                        msfCopyRootButton2.setBounds(new Rectangle(new Point(505, 285), msfCopyRootButton2.getPreferredSize()));

                        //---- label31 ----
                        label31.setText(bundle.getString("label31.text"));
                        msfRootOptions.add(label31);
                        label31.setBounds(new Rectangle(new Point(25, 145), label31.getPreferredSize()));

                        //---- sessionIdTextField ----
                        sessionIdTextField.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyReleased(KeyEvent e) {
                                sessionIdTextFieldKeyReleased(e);
                            }
                        });
                        msfRootOptions.add(sessionIdTextField);
                        sessionIdTextField.setBounds(new Rectangle(new Point(100, 140), sessionIdTextField.getPreferredSize()));

                        //======== scrollPane15 ========
                        {
                            scrollPane15.setViewportView(msfRootTextArea);
                        }
                        msfRootOptions.add(scrollPane15);
                        scrollPane15.setBounds(20, 200, 445, 155);

                        //---- msfPayloadCopyTextField ----
                        msfPayloadCopyTextField.setText(bundle.getString("msfPayloadCopyTextField.text"));
                        msfPayloadCopyTextField.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyReleased(KeyEvent e) {
                                msfPayloadCopyTextFieldKeyReleased(e);
                            }
                        });
                        msfRootOptions.add(msfPayloadCopyTextField);
                        msfPayloadCopyTextField.setBounds(85, 100, 370, msfPayloadCopyTextField.getPreferredSize().height);

                        //---- label32 ----
                        label32.setText(bundle.getString("label32.text"));
                        msfRootOptions.add(label32);
                        label32.setBounds(new Rectangle(new Point(25, 110), label32.getPreferredSize()));

                        //---- label67 ----
                        label67.setText(bundle.getString("label67.text"));
                        msfRootOptions.add(label67);
                        label67.setBounds(new Rectangle(new Point(25, 175), label67.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < msfRootOptions.getComponentCount(); i++) {
                                Rectangle bounds = msfRootOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = msfRootOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            msfRootOptions.setMinimumSize(preferredSize);
                            msfRootOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("msfRootOptions.tab.title"), msfRootOptions);

                    //======== CsMsfOptions ========
                    {
                        CsMsfOptions.setLayout(null);

                        //======== scrollPane3 ========
                        {
                            scrollPane3.setViewportView(csMsfTextArea);
                        }
                        CsMsfOptions.add(scrollPane3);
                        scrollPane3.setBounds(30, 45, 570, 100);

                        //---- label33 ----
                        label33.setText(bundle.getString("label33.text"));
                        CsMsfOptions.add(label33);
                        label33.setBounds(new Rectangle(new Point(30, 15), label33.getPreferredSize()));

                        //---- label42 ----
                        label42.setText(bundle.getString("label42.text"));
                        CsMsfOptions.add(label42);
                        label42.setBounds(new Rectangle(new Point(25, 165), label42.getPreferredSize()));

                        //---- label46 ----
                        label46.setText(bundle.getString("label46.text"));
                        CsMsfOptions.add(label46);
                        label46.setBounds(new Rectangle(new Point(35, 190), label46.getPreferredSize()));

                        //---- label47 ----
                        label47.setText(bundle.getString("label47.text"));
                        CsMsfOptions.add(label47);
                        label47.setBounds(new Rectangle(new Point(35, 215), label47.getPreferredSize()));

                        //---- label48 ----
                        label48.setText(bundle.getString("label48.text"));
                        CsMsfOptions.add(label48);
                        label48.setBounds(new Rectangle(new Point(35, 240), label48.getPreferredSize()));

                        //---- label49 ----
                        label49.setText(bundle.getString("label49.text"));
                        CsMsfOptions.add(label49);
                        label49.setBounds(new Rectangle(new Point(35, 265), label49.getPreferredSize()));

                        //---- label50 ----
                        label50.setText(bundle.getString("label50.text"));
                        CsMsfOptions.add(label50);
                        label50.setBounds(new Rectangle(new Point(35, 315), label50.getPreferredSize()));

                        //---- label51 ----
                        label51.setText(bundle.getString("label51.text"));
                        CsMsfOptions.add(label51);
                        label51.setBounds(new Rectangle(new Point(35, 290), label51.getPreferredSize()));

                        //---- label59 ----
                        label59.setText(bundle.getString("label59.text"));
                        CsMsfOptions.add(label59);
                        label59.setBounds(new Rectangle(new Point(100, 15), label59.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < CsMsfOptions.getComponentCount(); i++) {
                                Rectangle bounds = CsMsfOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = CsMsfOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            CsMsfOptions.setMinimumSize(preferredSize);
                            CsMsfOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("CsMsfOptions.tab.title_2"), CsMsfOptions);

                    //======== MsfCsOptions ========
                    {
                        MsfCsOptions.setLayout(null);

                        //---- label52 ----
                        label52.setText(bundle.getString("label52.text"));
                        MsfCsOptions.add(label52);
                        label52.setBounds(new Rectangle(new Point(35, 20), label52.getPreferredSize()));

                        //---- label53 ----
                        label53.setText(bundle.getString("label53.text"));
                        MsfCsOptions.add(label53);
                        label53.setBounds(new Rectangle(new Point(35, 45), label53.getPreferredSize()));

                        //---- label54 ----
                        label54.setText(bundle.getString("label54.text"));
                        MsfCsOptions.add(label54);
                        label54.setBounds(new Rectangle(new Point(35, 70), label54.getPreferredSize()));

                        //---- label55 ----
                        label55.setText(bundle.getString("label55.text"));
                        MsfCsOptions.add(label55);
                        label55.setBounds(new Rectangle(new Point(35, 95), label55.getPreferredSize()));

                        //---- label56 ----
                        label56.setText(bundle.getString("label56.text"));
                        MsfCsOptions.add(label56);
                        label56.setBounds(new Rectangle(new Point(35, 120), label56.getPreferredSize()));

                        //---- label57 ----
                        label57.setText(bundle.getString("label57.text"));
                        MsfCsOptions.add(label57);
                        label57.setBounds(new Rectangle(new Point(35, 145), label57.getPreferredSize()));

                        //---- label58 ----
                        label58.setText(bundle.getString("label58.text"));
                        MsfCsOptions.add(label58);
                        label58.setBounds(new Rectangle(new Point(110, 20), label58.getPreferredSize()));

                        //---- label60 ----
                        label60.setText(bundle.getString("label60.text"));
                        MsfCsOptions.add(label60);
                        label60.setBounds(new Rectangle(new Point(35, 185), label60.getPreferredSize()));

                        //======== scrollPane5 ========
                        {
                            scrollPane5.setViewportView(MSFcsTextArea);
                        }
                        MsfCsOptions.add(scrollPane5);
                        scrollPane5.setBounds(35, 215, 585, 130);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < MsfCsOptions.getComponentCount(); i++) {
                                Rectangle bounds = MsfCsOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = MsfCsOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            MsfCsOptions.setMinimumSize(preferredSize);
                            MsfCsOptions.setPreferredSize(preferredSize);
                        }
                    }
                    msfs.addTab(bundle.getString("MsfCsOptions.tab.title_2"), MsfCsOptions);
                }
                JtabbedPan11.addTab(bundle.getString("msfs.tab.title"), msfs);

                //======== Stoways ========
                {
                    Stoways.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    Stoways.setTabPlacement(SwingConstants.LEFT);

                    //======== AdminOptions ========
                    {
                        AdminOptions.setLayout(null);

                        //---- label5 ----
                        label5.setText(bundle.getString("label5.text"));
                        AdminOptions.add(label5);
                        label5.setBounds(new Rectangle(new Point(25, 10), label5.getPreferredSize()));

                        //======== scrollPane4 ========
                        {
                            scrollPane4.setViewportView(stAdminTextArea);
                        }
                        AdminOptions.add(scrollPane4);
                        scrollPane4.setBounds(20, 35, 650, 105);

                        //---- label19 ----
                        label19.setText(bundle.getString("label19.text"));
                        AdminOptions.add(label19);
                        label19.setBounds(new Rectangle(new Point(20, 165), label19.getPreferredSize()));

                        //---- label20 ----
                        label20.setText(bundle.getString("label20.text"));
                        AdminOptions.add(label20);
                        label20.setBounds(new Rectangle(new Point(20, 190), label20.getPreferredSize()));
                        AdminOptions.add(label21);
                        label21.setBounds(new Rectangle(new Point(555, 85), label21.getPreferredSize()));

                        //---- stSocksTextField ----
                        stSocksTextField.setText(bundle.getString("stSocksTextField.text"));
                        AdminOptions.add(stSocksTextField);
                        stSocksTextField.setBounds(60, 210, 75, stSocksTextField.getPreferredSize().height);

                        //---- stCopyIpSocksButton ----
                        stCopyIpSocksButton.setText(bundle.getString("stCopyIpSocksButton.text"));
                        stCopyIpSocksButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                stCopyIpSocksButtonMouseClicked(e);
                            }
                        });
                        AdminOptions.add(stCopyIpSocksButton);
                        stCopyIpSocksButton.setBounds(new Rectangle(new Point(150, 210), stCopyIpSocksButton.getPreferredSize()));

                        //---- label22 ----
                        label22.setText(bundle.getString("label22.text"));
                        AdminOptions.add(label22);
                        label22.setBounds(new Rectangle(new Point(20, 215), label22.getPreferredSize()));
                        AdminOptions.add(label23);
                        label23.setBounds(new Rectangle(new Point(550, 115), label23.getPreferredSize()));
                        AdminOptions.add(label24);
                        label24.setBounds(20, 300, label24.getPreferredSize().width, 17);
                        AdminOptions.add(label25);
                        label25.setBounds(new Rectangle(new Point(20, 275), label25.getPreferredSize()));

                        //---- label26 ----
                        label26.setText(bundle.getString("label26.text"));
                        AdminOptions.add(label26);
                        label26.setBounds(new Rectangle(new Point(20, 145), label26.getPreferredSize()));

                        //---- label27 ----
                        label27.setText(bundle.getString("label27.text"));
                        AdminOptions.add(label27);
                        label27.setBounds(new Rectangle(new Point(25, 250), label27.getPreferredSize()));

                        //---- textField1 ----
                        textField1.setText(bundle.getString("textField1.text"));
                        AdminOptions.add(textField1);
                        textField1.setBounds(new Rectangle(new Point(20, 275), textField1.getPreferredSize()));

                        //---- textField2 ----
                        textField2.setText(bundle.getString("textField2.text"));
                        AdminOptions.add(textField2);
                        textField2.setBounds(new Rectangle(new Point(20, 310), textField2.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < AdminOptions.getComponentCount(); i++) {
                                Rectangle bounds = AdminOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = AdminOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            AdminOptions.setMinimumSize(preferredSize);
                            AdminOptions.setPreferredSize(preferredSize);
                        }
                    }
                    Stoways.addTab(bundle.getString("AdminOptions.tab.title"), AdminOptions);

                    //======== AgentOptions ========
                    {
                        AgentOptions.setLayout(null);

                        //---- label17 ----
                        label17.setText(bundle.getString("label17.text"));
                        AgentOptions.add(label17);
                        label17.setBounds(20, 15, 150, 17);

                        //---- label18 ----
                        label18.setText(bundle.getString("label18.text"));
                        AgentOptions.add(label18);
                        label18.setBounds(20, 175, 150, 17);

                        //======== scrollPane13 ========
                        {
                            scrollPane13.setViewportView(stLinuxAgentTextArea);
                        }
                        AgentOptions.add(scrollPane13);
                        scrollPane13.setBounds(20, 45, 645, 105);

                        //======== scrollPane14 ========
                        {
                            scrollPane14.setViewportView(stWindowsAgentTextArea);
                        }
                        AgentOptions.add(scrollPane14);
                        scrollPane14.setBounds(20, 220, 645, 80);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < AgentOptions.getComponentCount(); i++) {
                                Rectangle bounds = AgentOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = AgentOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            AgentOptions.setMinimumSize(preferredSize);
                            AgentOptions.setPreferredSize(preferredSize);
                        }
                    }
                    Stoways.addTab(bundle.getString("AgentOptions.tab.title"), AgentOptions);
                }
                JtabbedPan11.addTab(bundle.getString("Stoways.tab.title"), Stoways);

                //======== JavaMenu ========
                {
                    JavaMenu.setLayout(null);

                    //======== tabbedPane4 ========
                    {
                        tabbedPane4.setTabPlacement(SwingConstants.LEFT);

                        //======== FastjsonOptions ========
                        {
                            FastjsonOptions.setLayout(null);

                            //---- label38 ----
                            label38.setText(bundle.getString("label38.text"));
                            FastjsonOptions.add(label38);
                            label38.setBounds(new Rectangle(new Point(25, 20), label38.getPreferredSize()));

                            //---- textField5 ----
                            textField5.setText(bundle.getString("textField5.text"));
                            FastjsonOptions.add(textField5);
                            textField5.setBounds(20, 45, 480, textField5.getPreferredSize().height);

                            //---- label39 ----
                            label39.setText(bundle.getString("label39.text"));
                            FastjsonOptions.add(label39);
                            label39.setBounds(new Rectangle(new Point(25, 90), label39.getPreferredSize()));

                            //======== scrollPane18 ========
                            {
                                scrollPane18.setViewportView(FaDNSlogTextArea);
                            }
                            FastjsonOptions.add(scrollPane18);
                            scrollPane18.setBounds(25, 125, 475, 90);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < FastjsonOptions.getComponentCount(); i++) {
                                    Rectangle bounds = FastjsonOptions.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = FastjsonOptions.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                FastjsonOptions.setMinimumSize(preferredSize);
                                FastjsonOptions.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("FastjsonOptions.tab.title"), FastjsonOptions);

                        //======== FaEXP1Options ========
                        {
                            FaEXP1Options.setLayout(null);

                            //======== FaEXP1 ========
                            {
                                FaEXP1.setViewportView(FaEXP1TextArea);
                            }
                            FaEXP1Options.add(FaEXP1);
                            FaEXP1.setBounds(10, 10, 620, 265);

                            //---- FaCopyEXP1TextArea ----
                            FaCopyEXP1TextArea.setText(bundle.getString("FaCopyEXP1TextArea.text"));
                            FaCopyEXP1TextArea.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    FaCopyEXP1TextAreaMouseClicked(e);
                                }
                            });
                            FaEXP1Options.add(FaCopyEXP1TextArea);
                            FaCopyEXP1TextArea.setBounds(new Rectangle(new Point(15, 305), FaCopyEXP1TextArea.getPreferredSize()));
                            FaEXP1Options.add(FaCopyEcholabel);
                            FaCopyEcholabel.setBounds(170, 305, 255, 25);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < FaEXP1Options.getComponentCount(); i++) {
                                    Rectangle bounds = FaEXP1Options.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = FaEXP1Options.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                FaEXP1Options.setMinimumSize(preferredSize);
                                FaEXP1Options.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("FaEXP1Options.tab.title"), FaEXP1Options);

                        //======== Log4j2Options ========
                        {
                            Log4j2Options.setLayout(null);

                            //---- label40 ----
                            label40.setText(bundle.getString("label40.text"));
                            Log4j2Options.add(label40);
                            label40.setBounds(new Rectangle(new Point(25, 25), label40.getPreferredSize()));
                            Log4j2Options.add(LoIPTextField);
                            LoIPTextField.setBounds(25, 55, 510, LoIPTextField.getPreferredSize().height);

                            //---- label41 ----
                            label41.setText(bundle.getString("label41.text"));
                            Log4j2Options.add(label41);
                            label41.setBounds(new Rectangle(new Point(25, 95), label41.getPreferredSize()));
                            Log4j2Options.add(LoDNSlogTextField);
                            LoDNSlogTextField.setBounds(25, 130, 510, LoDNSlogTextField.getPreferredSize().height);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < Log4j2Options.getComponentCount(); i++) {
                                    Rectangle bounds = Log4j2Options.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = Log4j2Options.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                Log4j2Options.setMinimumSize(preferredSize);
                                Log4j2Options.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane4.addTab(bundle.getString("Log4j2Options.tab.title"), Log4j2Options);
                    }
                    JavaMenu.add(tabbedPane4);
                    tabbedPane4.setBounds(0, 0, 805, 390);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < JavaMenu.getComponentCount(); i++) {
                            Rectangle bounds = JavaMenu.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = JavaMenu.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        JavaMenu.setMinimumSize(preferredSize);
                        JavaMenu.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPan11.addTab(bundle.getString("JavaMenu.tab.title"), JavaMenu);

                //======== REs ========
                {
                    REs.setLayout(null);

                    //======== tabbedPane3 ========
                    {
                        tabbedPane3.setTabPlacement(SwingConstants.LEFT);

                        //======== panel9 ========
                        {
                            panel9.setLayout(null);
                            panel9.add(label11);
                            label11.setBounds(new Rectangle(new Point(25, 40), label11.getPreferredSize()));
                            panel9.add(label12);
                            label12.setBounds(new Rectangle(new Point(15, 65), label12.getPreferredSize()));

                            //---- IPCopybutton ----
                            IPCopybutton.setText(bundle.getString("IPCopybutton.text"));
                            IPCopybutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    IPCopybuttonMouseClicked(e);
                                }
                            });
                            panel9.add(IPCopybutton);
                            IPCopybutton.setBounds(new Rectangle(new Point(15, 35), IPCopybutton.getPreferredSize()));

                            //---- CopyEcholabel ----
                            CopyEcholabel.setAutoscrolls(true);
                            panel9.add(CopyEcholabel);
                            CopyEcholabel.setBounds(20, 285, 630, 45);

                            //---- URLCopybutton ----
                            URLCopybutton.setText(bundle.getString("URLCopybutton.text"));
                            URLCopybutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLCopybuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLCopybutton);
                            URLCopybutton.setBounds(new Rectangle(new Point(115, 35), URLCopybutton.getPreferredSize()));

                            //---- URLPathbutton ----
                            URLPathbutton.setText(bundle.getString("URLPathbutton.text"));
                            URLPathbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLPathbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLPathbutton);
                            URLPathbutton.setBounds(new Rectangle(new Point(240, 35), URLPathbutton.getPreferredSize()));

                            //---- URLPortbutton ----
                            URLPortbutton.setText(bundle.getString("URLPortbutton.text"));
                            URLPortbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLPortbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(URLPortbutton);
                            URLPortbutton.setBounds(new Rectangle(new Point(350, 35), URLPortbutton.getPreferredSize()));

                            //---- AliyunaAccessKey ----
                            AliyunaAccessKey.setText(bundle.getString("AliyunaAccessKey.text"));
                            AliyunaAccessKey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunaAccessKeyMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunaAccessKey);
                            AliyunaAccessKey.setBounds(new Rectangle(new Point(15, 90), AliyunaAccessKey.getPreferredSize()));

                            //---- label10 ----
                            label10.setText(bundle.getString("label10.text"));
                            panel9.add(label10);
                            label10.setBounds(new Rectangle(new Point(20, 10), label10.getPreferredSize()));

                            //---- label13 ----
                            label13.setText(bundle.getString("label13.text"));
                            panel9.add(label13);
                            label13.setBounds(new Rectangle(new Point(120, 10), label13.getPreferredSize()));

                            //---- label14 ----
                            label14.setText(bundle.getString("label14.text"));
                            panel9.add(label14);
                            label14.setBounds(20, 70, 59, 17);

                            //---- AliyunSecretKey ----
                            AliyunSecretKey.setText(bundle.getString("AliyunSecretKey.text"));
                            AliyunSecretKey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunSecretKeyMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunSecretKey);
                            AliyunSecretKey.setBounds(new Rectangle(new Point(115, 90), AliyunSecretKey.getPreferredSize()));

                            //---- AliyunOssUrl ----
                            AliyunOssUrl.setText(bundle.getString("AliyunOssUrl.text"));
                            AliyunOssUrl.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AliyunOssUrlMouseClicked(e);
                                }
                            });
                            panel9.add(AliyunOssUrl);
                            AliyunOssUrl.setBounds(new Rectangle(new Point(215, 90), AliyunOssUrl.getPreferredSize()));

                            //---- label15 ----
                            label15.setText(bundle.getString("label15.text"));
                            panel9.add(label15);
                            label15.setBounds(new Rectangle(new Point(20, 125), label15.getPreferredSize()));

                            //---- AWSAccessKeyId ----
                            AWSAccessKeyId.setText(bundle.getString("AWSAccessKeyId.text"));
                            AWSAccessKeyId.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSAccessKeyIdMouseClicked(e);
                                }
                            });
                            panel9.add(AWSAccessKeyId);
                            AWSAccessKeyId.setBounds(new Rectangle(new Point(15, 150), AWSAccessKeyId.getPreferredSize()));

                            //---- AWSAuthToken ----
                            AWSAuthToken.setText(bundle.getString("AWSAuthToken.text"));
                            AWSAuthToken.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSAuthTokenMouseClicked(e);
                                }
                            });
                            panel9.add(AWSAuthToken);
                            AWSAuthToken.setBounds(new Rectangle(new Point(130, 150), AWSAuthToken.getPreferredSize()));

                            //---- AWSURL ----
                            AWSURL.setText(bundle.getString("AWSURL.text"));
                            AWSURL.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    AWSURLMouseClicked(e);
                                }
                            });
                            panel9.add(AWSURL);
                            AWSURL.setBounds(new Rectangle(new Point(245, 150), AWSURL.getPreferredSize()));

                            //---- label16 ----
                            label16.setText(bundle.getString("label16.text"));
                            panel9.add(label16);
                            label16.setBounds(new Rectangle(new Point(20, 185), label16.getPreferredSize()));

                            //---- SSHkey ----
                            SSHkey.setText(bundle.getString("SSHkey.text"));
                            SSHkey.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    SSHkeyMouseClicked(e);
                                }
                            });
                            panel9.add(SSHkey);
                            SSHkey.setBounds(new Rectangle(new Point(15, 210), SSHkey.getPreferredSize()));

                            //---- RSAKEYbutton ----
                            RSAKEYbutton.setText(bundle.getString("RSAKEYbutton.text"));
                            RSAKEYbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    RSAKEYbuttonMouseClicked(e);
                                }
                            });
                            panel9.add(RSAKEYbutton);
                            RSAKEYbutton.setBounds(new Rectangle(new Point(110, 210), RSAKEYbutton.getPreferredSize()));

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < panel9.getComponentCount(); i++) {
                                    Rectangle bounds = panel9.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = panel9.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                panel9.setMinimumSize(preferredSize);
                                panel9.setPreferredSize(preferredSize);
                            }
                        }
                        tabbedPane3.addTab(bundle.getString("panel9.tab.title"), panel9);
                    }
                    REs.add(tabbedPane3);
                    tabbedPane3.setBounds(0, 0, 770, 385);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < REs.getComponentCount(); i++) {
                            Rectangle bounds = REs.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = REs.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        REs.setMinimumSize(preferredSize);
                        REs.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPan11.addTab(bundle.getString("REs.tab.title"), REs);

                //======== DeCodeAndEnCodes ========
                {
                    DeCodeAndEnCodes.setLayout(null);

                    //======== DeAndEnCodeBase64s ========
                    {
                        DeAndEnCodeBase64s.setTabPlacement(SwingConstants.LEFT);

                        //======== Base64DeCodes ========
                        {
                            Base64DeCodes.setLayout(null);

                            //---- label1 ----
                            label1.setText(bundle.getString("label1.text"));
                            Base64DeCodes.add(label1);
                            label1.setBounds(new Rectangle(new Point(25, 10), label1.getPreferredSize()));

                            //---- label2 ----
                            label2.setText(bundle.getString("label2.text"));
                            Base64DeCodes.add(label2);
                            label2.setBounds(30, 165, label2.getPreferredSize().width, 21);

                            //======== scrollPane10 ========
                            {
                                scrollPane10.setViewportView(Bas64DeTextArea);
                            }
                            Base64DeCodes.add(scrollPane10);
                            scrollPane10.setBounds(25, 195, 680, 140);

                            //---- Babut1EnCode ----
                            Babut1EnCode.setText(bundle.getString("Babut1EnCode.text"));
                            Babut1EnCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut1EnCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut1EnCode);
                            Babut1EnCode.setBounds(new Rectangle(new Point(185, 160), Babut1EnCode.getPreferredSize()));

                            //---- Babut2DeCode ----
                            Babut2DeCode.setText(bundle.getString("Babut2DeCode.text"));
                            Babut2DeCode.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    Babut2DeCodeMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Babut2DeCode);
                            Babut2DeCode.setBounds(new Rectangle(new Point(320, 160), Babut2DeCode.getPreferredSize()));

                            //---- Base64buttonSwap ----
                            Base64buttonSwap.setText(bundle.getString("Base64buttonSwap.text"));
                            Base64buttonSwap.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button2MouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(Base64buttonSwap);
                            Base64buttonSwap.setBounds(new Rectangle(new Point(460, 160), Base64buttonSwap.getPreferredSize()));

                            //======== scrollPane11 ========
                            {
                                scrollPane11.setViewportView(Base64EnsTextArea);
                            }
                            Base64DeCodes.add(scrollPane11);
                            scrollPane11.setBounds(25, 30, 680, 125);

                            //---- BaCopyResButton ----
                            BaCopyResButton.setText(bundle.getString("BaCopyResButton.text"));
                            BaCopyResButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    BaCopyResButtonMouseClicked(e);
                                }
                            });
                            Base64DeCodes.add(BaCopyResButton);
                            BaCopyResButton.setBounds(new Rectangle(new Point(25, 340), BaCopyResButton.getPreferredSize()));
                            Base64DeCodes.add(BaCopyEcholabel);
                            BaCopyEcholabel.setBounds(130, 340, 170, 30);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < Base64DeCodes.getComponentCount(); i++) {
                                    Rectangle bounds = Base64DeCodes.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = Base64DeCodes.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                Base64DeCodes.setMinimumSize(preferredSize);
                                Base64DeCodes.setPreferredSize(preferredSize);
                            }
                        }
                        DeAndEnCodeBase64s.addTab(bundle.getString("Base64DeCodes.tab.title"), Base64DeCodes);

                        //======== URLOptions ========
                        {
                            URLOptions.setLayout(null);

                            //======== scrollPane1 ========
                            {
                                scrollPane1.setViewportView(URLEnCodeTextArea);
                            }
                            URLOptions.add(scrollPane1);
                            scrollPane1.setBounds(30, 45, 555, 100);

                            //---- URLEnCodebutton ----
                            URLEnCodebutton.setText(bundle.getString("URLEnCodebutton.text"));
                            URLEnCodebutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLEnCodebuttonMouseClicked(e);
                                }
                            });
                            URLOptions.add(URLEnCodebutton);
                            URLEnCodebutton.setBounds(new Rectangle(new Point(125, 170), URLEnCodebutton.getPreferredSize()));

                            //======== scrollPane2 ========
                            {
                                scrollPane2.setViewportView(URLDeCodetextArea);
                            }
                            URLOptions.add(scrollPane2);
                            scrollPane2.setBounds(25, 245, 560, 105);

                            //---- URLcopyDeCodeButton ----
                            URLcopyDeCodeButton.setText(bundle.getString("URLcopyDeCodeButton.text"));
                            URLcopyDeCodeButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLcopyDeCodeButtonMouseClicked(e);
                                }
                            });
                            URLOptions.add(URLcopyDeCodeButton);
                            URLcopyDeCodeButton.setBounds(new Rectangle(new Point(595, 280), URLcopyDeCodeButton.getPreferredSize()));

                            //---- URLcopyEnCodeButton ----
                            URLcopyEnCodeButton.setText(bundle.getString("URLcopyEnCodeButton.text"));
                            URLcopyEnCodeButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    URLcopyEnCodeButtonMouseClicked(e);
                                }
                            });
                            URLOptions.add(URLcopyEnCodeButton);
                            URLcopyEnCodeButton.setBounds(new Rectangle(new Point(595, 75), URLcopyEnCodeButton.getPreferredSize()));

                            //---- button6 ----
                            button6.setText(bundle.getString("button6.text"));
                            button6.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button6MouseClicked(e);
                                }
                            });
                            URLOptions.add(button6);
                            button6.setBounds(new Rectangle(new Point(265, 170), button6.getPreferredSize()));

                            //---- label44 ----
                            label44.setText(bundle.getString("label44.text"));
                            URLOptions.add(label44);
                            label44.setBounds(new Rectangle(new Point(35, 20), label44.getPreferredSize()));

                            //---- label45 ----
                            label45.setText(bundle.getString("label45.text"));
                            URLOptions.add(label45);
                            label45.setBounds(new Rectangle(new Point(25, 215), label45.getPreferredSize()));

                            //---- button1 ----
                            button1.setText(bundle.getString("button1.text"));
                            button1.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    button1MouseClicked(e);
                                }
                            });
                            URLOptions.add(button1);
                            button1.setBounds(new Rectangle(new Point(485, 170), button1.getPreferredSize()));
                            URLOptions.add(URLechoPageLabel);
                            URLechoPageLabel.setBounds(185, 210, 165, 25);

                            //---- URLMenucomboBox ----
                            URLMenucomboBox.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                                    URLMenucomboBoxPopupMenuWillBecomeInvisible(e);
                                }
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}
                            });
                            URLOptions.add(URLMenucomboBox);
                            URLMenucomboBox.setBounds(20, 170, 85, URLMenucomboBox.getPreferredSize().height);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < URLOptions.getComponentCount(); i++) {
                                    Rectangle bounds = URLOptions.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = URLOptions.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                URLOptions.setMinimumSize(preferredSize);
                                URLOptions.setPreferredSize(preferredSize);
                            }
                        }
                        DeAndEnCodeBase64s.addTab(bundle.getString("URLOptions.tab.title_2"), URLOptions);

                        //======== UnicodeOptions ========
                        {
                            UnicodeOptions.setLayout(null);

                            //======== scrollPane6 ========
                            {
                                scrollPane6.setViewportView(unicodeEnCodeTextArea);
                            }
                            UnicodeOptions.add(scrollPane6);
                            scrollPane6.setBounds(30, 50, 555, 110);

                            //======== scrollPane8 ========
                            {
                                scrollPane8.setViewportView(unicodeDeCodeTextArea);
                            }
                            UnicodeOptions.add(scrollPane8);
                            scrollPane8.setBounds(30, 215, 555, 125);

                            //---- label3 ----
                            label3.setText(bundle.getString("label3.text"));
                            UnicodeOptions.add(label3);
                            label3.setBounds(new Rectangle(new Point(30, 20), label3.getPreferredSize()));

                            //---- unicodeEnCodeButton ----
                            unicodeEnCodeButton.setText(bundle.getString("unicodeEnCodeButton.text"));
                            unicodeEnCodeButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    unicodeEnCodeButtonMouseClicked(e);
                                }
                            });
                            UnicodeOptions.add(unicodeEnCodeButton);
                            unicodeEnCodeButton.setBounds(new Rectangle(new Point(195, 175), unicodeEnCodeButton.getPreferredSize()));

                            //---- unicodeDeCodeButton ----
                            unicodeDeCodeButton.setText(bundle.getString("unicodeDeCodeButton.text"));
                            unicodeDeCodeButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    unicodeDeCodeButtonMouseClicked(e);
                                }
                            });
                            UnicodeOptions.add(unicodeDeCodeButton);
                            unicodeDeCodeButton.setBounds(new Rectangle(new Point(345, 175), unicodeDeCodeButton.getPreferredSize()));

                            //---- label64 ----
                            label64.setText(bundle.getString("label64.text"));
                            UnicodeOptions.add(label64);
                            label64.setBounds(new Rectangle(new Point(35, 185), label64.getPreferredSize()));

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < UnicodeOptions.getComponentCount(); i++) {
                                    Rectangle bounds = UnicodeOptions.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = UnicodeOptions.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                UnicodeOptions.setMinimumSize(preferredSize);
                                UnicodeOptions.setPreferredSize(preferredSize);
                            }
                        }
                        DeAndEnCodeBase64s.addTab(bundle.getString("UnicodeOptions.tab.title_2"), UnicodeOptions);
                    }
                    DeCodeAndEnCodes.add(DeAndEnCodeBase64s);
                    DeAndEnCodeBase64s.setBounds(0, 0, 795, 380);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < DeCodeAndEnCodes.getComponentCount(); i++) {
                            Rectangle bounds = DeCodeAndEnCodes.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = DeCodeAndEnCodes.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        DeCodeAndEnCodes.setMinimumSize(preferredSize);
                        DeCodeAndEnCodes.setPreferredSize(preferredSize);
                    }
                }
                JtabbedPan11.addTab(bundle.getString("DeCodeAndEnCodes.tab.title"), DeCodeAndEnCodes);

                //======== RandomMenu ========
                {
                    RandomMenu.setTabPlacement(SwingConstants.LEFT);

                    //======== RaPasswordOptions ========
                    {
                        RaPasswordOptions.setLayout(null);

                        //======== RaPasswordpanel ========
                        {
                            RaPasswordpanel.setLayout(null);

                            //---- RandomButton ----
                            RandomButton.setText(bundle.getString("RandomButton.text"));
                            RandomButton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    RandomButtonMouseClicked(e);
                                }
                            });
                            RaPasswordpanel.add(RandomButton);
                            RandomButton.setBounds(new Rectangle(new Point(10, 10), RandomButton.getPreferredSize()));
                            RaPasswordpanel.add(RandomTextField);
                            RandomTextField.setBounds(10, 70, 425, 35);

                            //---- ABCcheckBox ----
                            ABCcheckBox.setText(bundle.getString("ABCcheckBox.text"));
                            RaPasswordpanel.add(ABCcheckBox);
                            ABCcheckBox.setBounds(new Rectangle(new Point(20, 45), ABCcheckBox.getPreferredSize()));

                            //---- abcckBox ----
                            abcckBox.setText(bundle.getString("abcckBox.text"));
                            RaPasswordpanel.add(abcckBox);
                            abcckBox.setBounds(80, 45, 47, 22);

                            //---- NumcheckBox ----
                            NumcheckBox.setText(bundle.getString("NumcheckBox.text"));
                            RaPasswordpanel.add(NumcheckBox);
                            NumcheckBox.setBounds(140, 45, 47, 22);

                            //---- SigncheckBox ----
                            SigncheckBox.setText(bundle.getString("SigncheckBox.text"));
                            RaPasswordpanel.add(SigncheckBox);
                            SigncheckBox.setBounds(200, 45, 47, 22);
                            RaPasswordpanel.add(PasswordLens);
                            PasswordLens.setBounds(new Rectangle(new Point(320, 40), PasswordLens.getPreferredSize()));

                            //---- label4 ----
                            label4.setText(bundle.getString("label4.text"));
                            RaPasswordpanel.add(label4);
                            label4.setBounds(new Rectangle(new Point(265, 45), label4.getPreferredSize()));

                            //---- CopyPasswordbutton ----
                            CopyPasswordbutton.setText(bundle.getString("CopyPasswordbutton.text"));
                            CopyPasswordbutton.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    CopyPasswordbuttonMouseClicked(e);
                                }
                            });
                            RaPasswordpanel.add(CopyPasswordbutton);
                            CopyPasswordbutton.setBounds(new Rectangle(new Point(455, 75), CopyPasswordbutton.getPreferredSize()));

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < RaPasswordpanel.getComponentCount(); i++) {
                                    Rectangle bounds = RaPasswordpanel.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = RaPasswordpanel.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                RaPasswordpanel.setMinimumSize(preferredSize);
                                RaPasswordpanel.setPreferredSize(preferredSize);
                            }
                        }
                        RaPasswordOptions.add(RaPasswordpanel);
                        RaPasswordpanel.setBounds(0, 0, 680, 385);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < RaPasswordOptions.getComponentCount(); i++) {
                                Rectangle bounds = RaPasswordOptions.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = RaPasswordOptions.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            RaPasswordOptions.setMinimumSize(preferredSize);
                            RaPasswordOptions.setPreferredSize(preferredSize);
                        }
                    }
                    RandomMenu.addTab(bundle.getString("RaPasswordOptions.tab.title"), RaPasswordOptions);

                    //======== panel1 ========
                    {
                        panel1.setLayout(null);

                        //---- label61 ----
                        label61.setText(bundle.getString("label61.text"));
                        panel1.add(label61);
                        label61.setBounds(new Rectangle(new Point(30, 25), label61.getPreferredSize()));
                        panel1.add(timeStampEchoTextField);
                        timeStampEchoTextField.setBounds(30, 65, 150, timeStampEchoTextField.getPreferredSize().height);

                        //---- timeStampEchobutton ----
                        timeStampEchobutton.setText(bundle.getString("timeStampEchobutton.text"));
                        timeStampEchobutton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                timeStampEchobuttonMouseClicked(e);
                            }
                        });
                        panel1.add(timeStampEchobutton);
                        timeStampEchobutton.setBounds(new Rectangle(new Point(210, 65), timeStampEchobutton.getPreferredSize()));
                        panel1.add(timeStampEndTextField);
                        timeStampEndTextField.setBounds(325, 65, 210, timeStampEndTextField.getPreferredSize().height);

                        //---- label62 ----
                        label62.setText(bundle.getString("label62.text"));
                        panel1.add(label62);
                        label62.setBounds(new Rectangle(new Point(35, 160), label62.getPreferredSize()));
                        panel1.add(label63);
                        label63.setBounds(new Rectangle(new Point(35, 225), label63.getPreferredSize()));
                        panel1.add(StampTimeEchoTextField);
                        StampTimeEchoTextField.setBounds(30, 195, 150, StampTimeEchoTextField.getPreferredSize().height);

                        //---- StampTimeEchoButton ----
                        StampTimeEchoButton.setText(bundle.getString("StampTimeEchoButton.text"));
                        StampTimeEchoButton.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                StampTimeEchoButtonMouseClicked(e);
                            }
                        });
                        panel1.add(StampTimeEchoButton);
                        StampTimeEchoButton.setBounds(new Rectangle(new Point(210, 195), StampTimeEchoButton.getPreferredSize()));
                        panel1.add(StampTimeEndTextField);
                        StampTimeEndTextField.setBounds(320, 195, 205, StampTimeEndTextField.getPreferredSize().height);

                        //---- button3 ----
                        button3.setText(bundle.getString("button3.text"));
                        button3.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                button3MouseClicked(e);
                            }
                        });
                        panel1.add(button3);
                        button3.setBounds(new Rectangle(new Point(190, 20), button3.getPreferredSize()));

                        //---- button4 ----
                        button4.setText(bundle.getString("button4.text"));
                        button4.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                button4MouseClicked(e);
                            }
                        });
                        panel1.add(button4);
                        button4.setBounds(new Rectangle(new Point(195, 145), button4.getPreferredSize()));

                        //---- label65 ----
                        label65.setText(bundle.getString("label65.text"));
                        panel1.add(label65);
                        label65.setBounds(new Rectangle(new Point(325, 155), label65.getPreferredSize()));

                        //---- label66 ----
                        label66.setText(bundle.getString("label66.text"));
                        panel1.add(label66);
                        label66.setBounds(new Rectangle(new Point(335, 30), label66.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < panel1.getComponentCount(); i++) {
                                Rectangle bounds = panel1.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = panel1.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            panel1.setMinimumSize(preferredSize);
                            panel1.setPreferredSize(preferredSize);
                        }
                    }
                    RandomMenu.addTab(bundle.getString("panel1.tab.title"), panel1);
                }
                JtabbedPan11.addTab(bundle.getString("RandomMenu.tab.title"), RandomMenu);

                //======== CustomEditMenu ========
                {
                    CustomEditMenu.setTabPlacement(SwingConstants.LEFT);

                    //======== CustomEditOptions ========
                    {

                        //---- CustomEdit1TextArea ----
                        CustomEdit1TextArea.setText(bundle.getString("CustomEdit1TextArea.text"));
                        CustomEditOptions.setViewportView(CustomEdit1TextArea);
                    }
                    CustomEditMenu.addTab("\u81ea\u5b9a\u4e49\u7f16\u8f91\u533a\u57df", CustomEditOptions);
                }
                JtabbedPan11.addTab(bundle.getString("CustomEditMenu.tab.title"), CustomEditMenu);
            }
            outputPanel.add(JtabbedPan11);
            JtabbedPan11.setBounds(5, 30, 815, 420);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < outputPanel.getComponentCount(); i++) {
                    Rectangle bounds = outputPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = outputPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                outputPanel.setMinimumSize(preferredSize);
                outputPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(outputPanel);
        outputPanel.setBounds(10, 180, 810, 450);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JMenuBar AboutOptionsMenuBar;
    private JMenu AboutOptionsMenu;
    private JMenuItem AboutOptionsMenuItem;
    private JPanel inputFields;
    private JPanel RPanel2;
    private JLabel RHOST;
    private JLabel RPORT;
    private JTextField RhostValue;
    private JTextField RportVaule;
    private JLabel Command;
    private JTextField CommandVaule;
    private JScrollPane HistoryRhostListScrollPane;
    private JList HistoryRhostValueJList;
    private JScrollPane HistoryCommandListScrollPane;
    private JList HistoryCommandValueJList;
    private JScrollPane HistoryRportListScrollPane;
    private JList HistoryRportValueJList;
    private JButton saveMenuButton;
    private JButton Delectbutton;
    public JPanel LPanel1;
    private JLabel LHOST;
    private JLabel LPORT;
    public JTextField LhostValue;
    private JTextField LportValue;
    private JLabel DNSLog;
    private JTextField DNSlogValue;
    private JLabel FileName;
    private JTextField FileNameVaule;
    private JScrollPane HistoryLhostListScrollPane;
    private JList HistoryLhostValueJList;
    private JScrollPane HistoryLportListScrollPane;
    private JList HistoryLportValueJList;
    private JScrollPane HistoryDnslogListScrollPane;
    private JList HistoryDnslogtValueJList;
    private JScrollPane HistoryFilenameListScrollPane;
    private JList HistoryFilenametValueJList;
    private JPanel outputPanel;
    private JTabbedPane JtabbedPan11;
    private JTabbedPane ReverseMenu;
    private JPanel BashOptions;
    private JLabel label30;
    private JLabel label35;
    private JTextField Bash1TextArea;
    private JTextField Bash2TextArea;
    private JLabel label43;
    private JTextField JavaBashTextArea;
    private JButton ReBash1Button;
    private JButton ReBash2Button;
    private JButton ReJavaBashbutton;
    private JLabel ReCopyEcholabel;
    private JPanel RCEMenu;
    private JTabbedPane CurlOption;
    private JPanel panel3;
    private JLabel label6;
    private JTextField Curl2TextField;
    private JLabel label8;
    private JTextField Curl1TextField;
    private JLabel label7;
    private JLabel label9;
    private JPanel WgetOption;
    private JScrollPane scrollPane7;
    private JTextArea Wget1TextArea;
    private JPanel PythonOption;
    private JScrollPane scrollPane12;
    private JTextArea PythonTextArea;
    private JTabbedPane msfs;
    private JPanel LinuxPayloadOptions;
    private JLabel msfLinuxHexText;
    private JTextField msfLinuxHexTextField;
    private JLabel label34;
    private JTextField msfLinuxELFTextField;
    private JButton msfCopyHexButton;
    private JButton msfCopyElfButton;
    private JLabel msfCopyEcholabel;
    private JPanel msfListenerOptions;
    private JLabel label36;
    private JLabel label37;
    private JScrollPane scrollPane16;
    private JTextArea msfLinuxListenerTextArea;
    private JScrollPane scrollPane17;
    private JTextArea msfWindowsListenerTextArea;
    private JPanel msfRootOptions;
    private JTextField msfRootTextField;
    private JLabel label28;
    private JButton msfCopyRootButton;
    private JLabel label29;
    private JButton msfCopyRootButton2;
    private JLabel label31;
    private JTextField sessionIdTextField;
    private JScrollPane scrollPane15;
    private JTextArea msfRootTextArea;
    private JTextField msfPayloadCopyTextField;
    private JLabel label32;
    private JLabel label67;
    private JPanel CsMsfOptions;
    private JScrollPane scrollPane3;
    private JTextArea csMsfTextArea;
    private JLabel label33;
    private JLabel label42;
    private JLabel label46;
    private JLabel label47;
    private JLabel label48;
    private JLabel label49;
    private JLabel label50;
    private JLabel label51;
    private JLabel label59;
    private JPanel MsfCsOptions;
    private JLabel label52;
    private JLabel label53;
    private JLabel label54;
    private JLabel label55;
    private JLabel label56;
    private JLabel label57;
    private JLabel label58;
    private JLabel label60;
    private JScrollPane scrollPane5;
    private JTextArea MSFcsTextArea;
    private JTabbedPane Stoways;
    private JPanel AdminOptions;
    private JLabel label5;
    private JScrollPane scrollPane4;
    private JTextArea stAdminTextArea;
    private JLabel label19;
    private JLabel label20;
    private JLabel label21;
    private JTextField stSocksTextField;
    private JButton stCopyIpSocksButton;
    private JLabel label22;
    private JLabel label23;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel AgentOptions;
    private JLabel label17;
    private JLabel label18;
    private JScrollPane scrollPane13;
    private JTextArea stLinuxAgentTextArea;
    private JScrollPane scrollPane14;
    private JTextArea stWindowsAgentTextArea;
    private JPanel JavaMenu;
    private JTabbedPane tabbedPane4;
    private JPanel FastjsonOptions;
    private JLabel label38;
    private JTextField textField5;
    private JLabel label39;
    private JScrollPane scrollPane18;
    private JTextArea FaDNSlogTextArea;
    private JPanel FaEXP1Options;
    private JScrollPane FaEXP1;
    private JTextArea FaEXP1TextArea;
    private JButton FaCopyEXP1TextArea;
    private JLabel FaCopyEcholabel;
    private JPanel Log4j2Options;
    private JLabel label40;
    private JTextField LoIPTextField;
    private JLabel label41;
    private JTextField LoDNSlogTextField;
    private JPanel REs;
    private JTabbedPane tabbedPane3;
    private JPanel panel9;
    private JLabel label11;
    private JLabel label12;
    private JButton IPCopybutton;
    private JLabel CopyEcholabel;
    private JButton URLCopybutton;
    private JButton URLPathbutton;
    private JButton URLPortbutton;
    private JButton AliyunaAccessKey;
    private JLabel label10;
    private JLabel label13;
    private JLabel label14;
    private JButton AliyunSecretKey;
    private JButton AliyunOssUrl;
    private JLabel label15;
    private JButton AWSAccessKeyId;
    private JButton AWSAuthToken;
    private JButton AWSURL;
    private JLabel label16;
    private JButton SSHkey;
    private JButton RSAKEYbutton;
    private JPanel DeCodeAndEnCodes;
    private JTabbedPane DeAndEnCodeBase64s;
    private JPanel Base64DeCodes;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane10;
    private JTextArea Bas64DeTextArea;
    private JButton Babut1EnCode;
    private JButton Babut2DeCode;
    private JButton Base64buttonSwap;
    private JScrollPane scrollPane11;
    private JTextArea Base64EnsTextArea;
    private JButton BaCopyResButton;
    private JLabel BaCopyEcholabel;
    private JPanel URLOptions;
    private JScrollPane scrollPane1;
    private JTextArea URLEnCodeTextArea;
    private JButton URLEnCodebutton;
    private JScrollPane scrollPane2;
    private JTextArea URLDeCodetextArea;
    private JButton URLcopyDeCodeButton;
    private JButton URLcopyEnCodeButton;
    private JButton button6;
    private JLabel label44;
    private JLabel label45;
    private JButton button1;
    private JLabel URLechoPageLabel;
    private JComboBox URLMenucomboBox;
    private JPanel UnicodeOptions;
    private JScrollPane scrollPane6;
    private JTextArea unicodeEnCodeTextArea;
    private JScrollPane scrollPane8;
    private JTextArea unicodeDeCodeTextArea;
    private JLabel label3;
    private JButton unicodeEnCodeButton;
    private JButton unicodeDeCodeButton;
    private JLabel label64;
    private JTabbedPane RandomMenu;
    private JPanel RaPasswordOptions;
    private JPanel RaPasswordpanel;
    private JButton RandomButton;
    private JTextField RandomTextField;
    private JCheckBox ABCcheckBox;
    private JCheckBox abcckBox;
    private JCheckBox NumcheckBox;
    private JCheckBox SigncheckBox;
    private JSpinner PasswordLens;
    private JLabel label4;
    private JButton CopyPasswordbutton;
    private JPanel panel1;
    private JLabel label61;
    private JTextField timeStampEchoTextField;
    private JButton timeStampEchobutton;
    private JTextField timeStampEndTextField;
    private JLabel label62;
    private JLabel label63;
    private JTextField StampTimeEchoTextField;
    private JButton StampTimeEchoButton;
    private JTextField StampTimeEndTextField;
    private JButton button3;
    private JButton button4;
    private JLabel label65;
    private JLabel label66;
    private JTabbedPane CustomEditMenu;
    private JScrollPane CustomEditOptions;
    private JTextArea CustomEdit1TextArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
