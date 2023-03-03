package com.swordHostDemo.service.history;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.swordHostDemo.dao.menuBean.menuBeanDaoImpl;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date: 2023/1/23 18:36
 * @description:
 */
public class menuHistroyListImpl implements menuHistroyList{
    @Override
    public  void HistroyList(JList  HistoryLhostValueJList, JList HistoryLportValueJList,
                             JList HistoryDnslogtValueJList, JList HistoryFileNameValueJList,
                             JList HistoryRhostValueJList, JList HistoryRportValueJList, JList HistoryCommandValueJList) throws SQLException {
        menuBeanDaoImpl menuDao = new menuBeanDaoImpl(menuBeanDaoImpl.getConnection());

        String studentJson = JSON.toJSONString(menuDao);

        System.out.println("menuHistroyListImpl："+studentJson);
        //{"allMenuBean":[{"command":"","dnsLog":"","fileName":"","id":1,"lhost":"","lport":"","remark":"","rhost":"","rport":""},
        // {"command":"111","dnsLog":"111","fileName":"111","id":2,"lhost":"2221","lport":"111","remark":"null","rhost":"111","rport":"111"}

        JSONObject json = JSON.parseObject(studentJson);
        JSONArray data = json.getJSONArray("allMenuBean");
        List<String> lhost = new ArrayList<>();
        List<String> lport = new ArrayList<>();
        List<String> dnsLong = new ArrayList<>();
        List<String> fileName = new ArrayList<>();
        List<String> hTTPPort = new ArrayList<>();
        List<String> lDAPPort = new ArrayList<>();
        List<String> command = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JSONObject item = data.getJSONObject(i);
            lhost.add(item.getString("lhost"));
            lport.add(item.getString("lport"));
            dnsLong.add(item.getString("dnsLog"));
            fileName.add(item.getString("fileName"));
            hTTPPort.add(item.getString("hTTPPort"));
            lDAPPort.add(item.getString("lDAPPort"));
            command.add(item.getString("command"));
        }


        //lhost
        List<String> lhostCollect = dataManager(lhost);
        HistoryLhostValueJList.setListData(lhostCollect.toArray());

        //lport
        List<String> lportCollect = dataManager(lport);
        HistoryLportValueJList.setListData(lportCollect.toArray());
        //dnsLong
        List<String> dnsLongCollect = dataManager(dnsLong);
        HistoryDnslogtValueJList.setListData(dnsLongCollect.toArray());
        //fileName
        List<String> fileNameCollect = dataManager(fileName);
        HistoryFileNameValueJList.setListData(fileNameCollect.toArray());
        //rhost
        List<String> rhostCollect = dataManager(hTTPPort);
        HistoryRhostValueJList.setListData(rhostCollect.toArray());
        //rport
        List<String> rportCollect = dataManager(lDAPPort);
        HistoryRportValueJList.setListData(rportCollect.toArray());
        //command
        List<String> commandCollect = dataManager(command);
        HistoryCommandValueJList.setListData(commandCollect.toArray());

    }

    @Override
    public  List<String> dataManager(List<String> data){
        //去重
        List<String> collect = data.stream().distinct().collect(Collectors.toList());
        return collect;

    }

    public static void main(String[] args) throws SQLException {
//        TestHistroyList();
    }

}

