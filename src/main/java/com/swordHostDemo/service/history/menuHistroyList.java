package com.swordHostDemo.service.history;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * @date: 2023/2/5 15:15
 * @description:
 */
public interface menuHistroyList {
    /**
    * @param HistoryLhostValueJList:
     * @param HistoryLportValueJList:
     * @param HistoryDnslogtValueJList:
     * @param HistoryFileNameValueJList:
     * @param HistoryRhostValueJList:
     * @param HistoryRportValueJList:
     * @param HistoryCommandValueJList:
     * @return: void
     * @date: 2023/2/5 15:19
     * @description: 菜单的历史记录框
     */
    void HistroyList(JList HistoryLhostValueJList, JList HistoryLportValueJList, JList HistoryDnslogtValueJList, JList HistoryFileNameValueJList, JList HistoryRhostValueJList, JList HistoryRportValueJList, JList HistoryCommandValueJList) throws SQLException;

    /**
    * @param data:
     * @return: java.util.List<java.lang.String>
     * @date: 2023/2/5 15:19
     * @description:去重
     */
    List<String> dataManager(List<String> data);
}
