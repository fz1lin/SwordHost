package com.swordHostDemo.dao.menuBean;

import com.swordHostDemo.pojo.MenuBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2022/12/31 10:39
 * @description:
 */
public class menuBeanDaoImpl implements menuBeanDao {
    //连接
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs;

    public menuBeanDaoImpl(Connection connection) {
        this.connection = connection;
    }

    //连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:data.db");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


    @Override
    public void setInsertMenuBean(MenuBean menuBean) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO menu (id,Lhost,Lport,Dnslog,FileName,Rhost,Rport,Command,remark) VALUES (?,?,?,?,?,?,?,?,?);");
        preparedStatement.setInt(1, menuBean.getId());
        preparedStatement.setString(2, menuBean.getLhost());
        preparedStatement.setString(3, menuBean.getLport());
        preparedStatement.setString(4, menuBean.getDnsLog());
        preparedStatement.setString(5, menuBean.getFileName());
        preparedStatement.setString(6, menuBean.getRhost());
        preparedStatement.setString(7, menuBean.getRport());
        preparedStatement.setString(8, menuBean.getCommand());
        preparedStatement.setString(9, menuBean.getRemark());
        preparedStatement.executeUpdate();
    }

    @Override
    public MenuBean getIdMenuBean(int id) throws Exception {
        MenuBean menuBean = new MenuBean();
        preparedStatement = connection.prepareStatement("select * from menu where id=?");
        preparedStatement.setInt(1, id);
        rs = preparedStatement.executeQuery();
        while (rs.next()) {
            menuBean.setId(rs.getInt("id"));
            menuBean.setLhost(rs.getString("Lhost"));
            menuBean.setLport(rs.getString("Lport"));
            menuBean.setDnsLog(rs.getString("DnsLog"));
            menuBean.setFileName(rs.getString("FileName"));
            menuBean.setRhost(rs.getString("Rhost"));
            menuBean.setRport(rs.getString("Rport"));
            menuBean.setCommand(rs.getString("Command"));
            menuBean.setRemark(rs.getString("remark"));
        }
        return menuBean;
    }

    @Override
    public ArrayList<MenuBean> getAllMenuBean() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("select * from menu");
        rs = preparedStatement.executeQuery();
        //创建一个集合
        ArrayList<MenuBean> list = new ArrayList<>();

        //循环查询数据
        while (rs.next()) {
            MenuBean menuBean = new MenuBean();
            menuBean.setId(rs.getInt(1));
            menuBean.setLhost(rs.getString(2));
            menuBean.setLport(rs.getString(3));
            menuBean.setDnsLog(rs.getString(4));
            menuBean.setFileName(rs.getString(5));
            menuBean.setRhost(rs.getString(6));
            menuBean.setRport(rs.getString(7));
            menuBean.setCommand(rs.getString(8));
            menuBean.setRemark(rs.getString(9));
            list.add(menuBean);
        }
        return list;
    }

    @Override
    public Integer getIdMaxInteger() {
        int maxString = 0;
        try {
            preparedStatement = connection.prepareStatement("select Max(id) from menu");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                maxString = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxString;
    }

    @Override
    public Integer getIdMinInteger() {
        int minString = 0;
        try {
            preparedStatement = connection.prepareStatement("select min(id) from menu");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                minString = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minString;
    }


    @Override
    public Integer updateIdMenuBean(int id,MenuBean menuBean) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE menu SET Lhost = ?, Lport = ?,DnsLog =?,FileName=?,Rhost=?,Rport=?,Command=?,remark=? WHERE id = ?;");

        preparedStatement.setString(2, menuBean.getLhost());
        preparedStatement.setString(3, menuBean.getLport());
        preparedStatement.setString(4, menuBean.getDnsLog());
        preparedStatement.setString(5, menuBean.getFileName());
        preparedStatement.setString(6, menuBean.getRhost());
        preparedStatement.setString(7, menuBean.getRport());
        preparedStatement.setString(8, menuBean.getCommand());
        preparedStatement.setString(9, menuBean.getRemark());
        preparedStatement.setInt(1, menuBean.getId());
        int rows = preparedStatement.executeUpdate();
        System.out.println("Affected rows:" + rows);
        return rows;
    }

    @Override
    public boolean deleteId(int id) {

        try {
            preparedStatement = connection.prepareStatement("delete from menu where id=?");

            preparedStatement.setInt(1, id);
            Integer rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void closeAllSQL() {
        if (rs != null) {
            try {
                rs.close();
                rs = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
                connection = null;//GC回收
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }




    //入口测试
    public static void main(String[] args) throws Exception {

        menuBeanDaoImpl menuDaoImpl = new menuBeanDaoImpl(getConnection());
//        Integer idMaxString = menuDaoImpl.getIdMaxInteger();
//        //最大值
//        System.out.println(idMaxString);
//        Integer idMinInteger = menuDaoImpl.getIdMinInteger();
//        System.out.println(idMinInteger);
//
//        MenuBean menuBean = new MenuBean();
//        menuBean.setLhost("setlhost");
//
//        menuDaoImpl.updateIdMenuBean(2,menuBean);
        List<MenuBean> allMenuBean = menuDaoImpl.getAllMenuBean();
        for (MenuBean menuBean : allMenuBean) {
            System.out.println(menuBean);
        }

    }

}
