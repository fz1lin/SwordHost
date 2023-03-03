package com.swordHostDemo.dao.menuCurd;

import com.swordHostDemo.dao.menuBean.menuBeanDaoImpl;
import com.swordHostDemo.pojo.MenuBean;
import com.swordHostDemo.utls.regularUtls;

import javax.swing.*;

/**
 * @date: 2023/1/22 20:00
 * @description:
 */
public class menuCurdDaoImpl implements menuCurdDao {
    //查询数据
    @Override
    public void selectData(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue
            , JTextField HTTPPortValue, JTextField LDAPPortVaule, JTextField CommandVaule, JTextField FileNameVaule) throws Exception {

        menuBeanDaoImpl menuDaoImpl = new menuBeanDaoImpl(menuBeanDaoImpl.getConnection());
        MenuBean idMenuBean = menuDaoImpl.getIdMenuBean(menuDaoImpl.getIdMaxInteger());
        String lhost = idMenuBean.getLhost();
        String lport = idMenuBean.getLport();
        String dnslog = idMenuBean.getDnsLog();
        String httpPortValue = idMenuBean.getHTTPPort();
        String rport = idMenuBean.getLDAPPort();
        String command = idMenuBean.getCommand();
        String fileName = idMenuBean.getFileName();
        System.out.println("selectData：" + idMenuBean);

        LhostValue.setText(lhost);
        LportValue.setText(lport);
        DNSlogValue.setText(dnslog);
        HTTPPortValue.setText(httpPortValue);
        LDAPPortVaule.setText(rport);
        CommandVaule.setText(command);
        FileNameVaule.setText(fileName);
        //释放资源
        menuDaoImpl.closeAllSQL();
    }

    //添加数据
    @Override
    public void addData(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue
            , JTextField HTTPPortValue, JTextField LDAPPortVaule, JTextField CommandVaule, JTextField FileNameVaule) throws Exception {
        menuBeanDaoImpl menuDaoImpl = new menuBeanDaoImpl(menuBeanDaoImpl.getConnection());

        //最大值me
        Integer idMaxInteger = menuDaoImpl.getIdMaxInteger();
        idMaxInteger++;

        String strLhost = LhostValue.getText();
        String strLport = LportValue.getText();
        String strHTTPPort = HTTPPortValue.getText();
        String strLDAPPort = LDAPPortVaule.getText();

        //判断数值是否是正确格式，是正确格式存入数据库，不是正确格式不存入
        if (!regularUtls.reHost(strLhost)) {
            strLhost = "";
        }
        if (!regularUtls.rePort(strLport)) {
            strLport = "";
        }
        if (!regularUtls.rePort(strHTTPPort)) {
            strHTTPPort = "";
        }
        if (!regularUtls.rePort(strLDAPPort)) {
            strLDAPPort = "";
        }

        MenuBean menuBean = new MenuBean(idMaxInteger, strLhost, strLport, DNSlogValue.getText()
                , FileNameVaule.getText(), strHTTPPort, strLDAPPort, CommandVaule.getText(), "null");
        System.out.println("addData " + menuBean);
        menuDaoImpl.setInsertMenuBean(menuBean);

    }
}
