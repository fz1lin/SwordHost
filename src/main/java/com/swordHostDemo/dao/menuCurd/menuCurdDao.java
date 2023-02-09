package com.swordHostDemo.dao.menuCurd;

import javax.swing.*;

/**
 * @date: 2023/1/22 20:00
 * @description:
 */
public interface menuCurdDao {

    /**
    * @param LhostValue:
     * @param LportValue:
     * @param DNSlogValue:
     * @param RhostValue:
     * @param RportVaule:
     * @param CommandVaule:
     * @param FileNameVaule:
     * @return: void
     * @date: 2023/1/22 21:54
     * @description: 查询数据库
     */
    void selectData(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue
            , JTextField RhostValue, JTextField RportVaule, JTextField CommandVaule, JTextField FileNameVaule) throws Exception;

    /**
    * @param LhostValue:
     * @param LportValue:
     * @param DNSlogValue:
     * @param RhostValue:
     * @param RportVaule:
     * @param CommandVaule:
     * @param FileNameVaule:
     * @return: void
     * @date: 2023/1/22 21:54
     * @description:添加数据库
     */

    void addData(JTextField LhostValue, JTextField LportValue, JTextField DNSlogValue
            , JTextField RhostValue, JTextField RportVaule, JTextField CommandVaule, JTextField FileNameVaule) throws Exception;
}
