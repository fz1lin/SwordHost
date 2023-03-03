/*
 * Created by JFormDesigner on Sun Feb 05 18:30:11 CST 2023
 */

package com.swordHostDemo.view.listViewGUI;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swordHostDemo.dao.menuBean.menuBeanDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author DXAJUI
 */
public class listViewGUI extends JFrame {
    public listViewGUI() {
        initComponents();
    }


    public void start() {
        menuBeanDaoImpl menuDao = new menuBeanDaoImpl(menuBeanDaoImpl.getConnection());
        String studentJson = JSON.toJSONString(menuDao);
        DefaultTableModel model = new DefaultTableModel();
        System.out.println("menuHistroyListImpl：" + studentJson);
        JSONObject json = JSON.parseObject(studentJson);
        JSONArray data = json.getJSONArray("allMenuBean");

        model.setColumnIdentifiers(new Object[]{"ID", "Lhost", "Lport", "DnsLog", "FileName","HTTPPort", "LDAPPort", "Command"}); //
        for (int i = 0; i < data.size(); i++) {
            int id = (int) data.getJSONObject(i).get("id");
            String lhostData = (String) data.getJSONObject(i).get("lhost");
            String lportData = (String) data.getJSONObject(i).get("lport");
            String dnsLogData = (String) data.getJSONObject(i).get("dnsLog");
            String fileNameData = (String) data.getJSONObject(i).get("fileName");
            String rhostData = (String) data.getJSONObject(i).get("hTTPPort");
            String rportData = (String) data.getJSONObject(i).get("lDAPPort");
            String commandData = (String) data.getJSONObject(i).get("command");
            model.addRow(new Object[]{id, lhostData, lportData, dnsLogData, fileNameData, rhostData, rportData, commandData});
        }
        //放入数据
        listViewTable.setModel(model);
        listViewTable.setAutoCreateRowSorter(true);
        menuDao.closeAllSQL();
    }

    public void deleteButton(){
        menuBeanDaoImpl menuDao = new menuBeanDaoImpl(menuBeanDaoImpl.getConnection());
        String studentJson = JSON.toJSONString(menuDao);
        JSONObject json = JSON.parseObject(studentJson);
        JSONArray data = json.getJSONArray("allMenuBean");
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject item = data.getJSONObject(i);
            id.add(item.getInteger("id"));
        }
        System.out.println();
        if (id.contains(Integer.parseInt(listDelectTextField.getText()))) {
            menuDao.deleteId(Integer.parseInt(listDelectTextField.getText()));
            JOptionPane.showMessageDialog(null, "成功删除！id为：" + listDelectTextField.getText(), "提示", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ID：" + listDelectTextField.getText() + "\r\n不在数据中或者被删除", "提示", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("删除了id为：" + listDelectTextField.getText());
        start();
        listViewTable.repaint();
        menuDao.closeAllSQL();
    }

    private void listDelectButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        deleteButton();

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        ResourceBundle bundle = ResourceBundle.getBundle("listViewGUI");
        ListViewPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        listViewTable = new JTable();
        listDelectButton = new JButton();
        listDelectTextField = new JTextField();
        label1 = new JLabel();

        //======== this ========
        setTitle(bundle.getString("this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== ListViewPanel ========
        {
            ListViewPanel.setLayout(null);

            //======== scrollPane1 ========
            {

                //---- listViewTable ----
                listViewTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                listViewTable.setAutoCreateRowSorter(true);
                scrollPane1.setViewportView(listViewTable);
            }
            ListViewPanel.add(scrollPane1);
            scrollPane1.setBounds(15, 10, 815, 440);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < ListViewPanel.getComponentCount(); i++) {
                    Rectangle bounds = ListViewPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = ListViewPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                ListViewPanel.setMinimumSize(preferredSize);
                ListViewPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(ListViewPanel);
        ListViewPanel.setBounds(10, 85, 845, 470);

        //---- listDelectButton ----
        listDelectButton.setText(bundle.getString("listDelectButton.text"));
        listDelectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listDelectButtonMouseClicked(e);
            }
        });
        contentPane.add(listDelectButton);
        listDelectButton.setBounds(new Rectangle(new Point(150, 35), listDelectButton.getPreferredSize()));
        contentPane.add(listDelectTextField);
        listDelectTextField.setBounds(new Rectangle(new Point(80, 35), listDelectTextField.getPreferredSize()));

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(60, 10), label1.getPreferredSize()));

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
    private JPanel ListViewPanel;
    private JScrollPane scrollPane1;
    private JTable listViewTable;
    private JButton listDelectButton;
    private JTextField listDelectTextField;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
