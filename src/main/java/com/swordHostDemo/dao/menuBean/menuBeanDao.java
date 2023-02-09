package com.swordHostDemo.dao.menuBean;

import com.swordHostDemo.pojo.MenuBean;

import java.util.List;

/**
 * @date: 2023/1/17 22:24
 * @description:
 */
public interface menuBeanDao {
    /**
     * 插入所有字段数据
     *
     * @param menuBean
     * @return
     * @throws Exception
     */
    void setInsertMenuBean(MenuBean menuBean) throws Exception;

    /**
     * 查询指定id的所有值
     *
     * @param id
     * @return
     * @throws Exception
     */
    MenuBean getIdMenuBean(int id) throws Exception;

    /**
     * 查询所有表
     *
     * @return
     * @throws Exception
     */
    List<MenuBean> getAllMenuBean() throws Exception;

    /**
     * 查询id最大值
     *
     * @return
     */
    Integer getIdMaxInteger();

    /**
     * 查询id最小值
     *
     * @return
     * @throws Exception
     */
    Integer getIdMinInteger();

    /**
     * 更新指定id内容
     *
     * @return
     * @throws Exception
     */

    Integer updateIdMenuBean(int id,MenuBean menuBean) throws Exception;

    /**
     * 释放所有资源
     *
     * @return boolean
     * @throws
     */
    void closeAllSQL();

    /**
    * @param id:
     * @return: java.lang.Integer
     * @date: 2023/2/5 19:08
     * @description:  删除指定ID
     */
    boolean deleteId(int id);

}
