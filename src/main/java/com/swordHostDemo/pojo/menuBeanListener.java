package com.swordHostDemo.pojo;

/**
 * @date: 2023/2/15 19:38
 * @description:
 */
public class menuBeanListener {
    private static String Lhost;
    private static String Lport;
    private static String DnsLog;
    private static String FileName;
    private static String HTTPPort;
    private static String LDAPPort;
    private static String Command;

    public static String getLhost() {
        return Lhost;
    }

    public static void setLhost(String lhost) {
        Lhost = lhost;
    }

    public static String getLport() {
        return Lport;
    }

    public static void setLport(String lport) {
        Lport = lport;
    }

    public static String getDnsLog() {
        return DnsLog;
    }

    public static void setDnsLog(String dnsLog) {
        DnsLog = dnsLog;
    }

    public static String getFileName() {
        return FileName;
    }

    public static void setFileName(String fileName) {
        FileName = fileName;
    }

    public static String getHTTPPort() {
        return HTTPPort;
    }

    public static void setHTTPPort(String HTTPPort) {
        menuBeanListener.HTTPPort = HTTPPort;
    }

    public static String getLDAPPort() {
        return LDAPPort;
    }

    public static void setLDAPPort(String LDAPPort) {
        menuBeanListener.LDAPPort = LDAPPort;
    }

    public static String getCommand() {
        return Command;
    }

    public static void setCommand(String command) {
        Command = command;
    }
}
