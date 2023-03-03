package com.swordHostDemo.pojo;

/**
 * @date: 2022/12/26 19:00
 * @description:
 */
public class MenuBean{
    private int id;
    private String Lhost;
    private String Lport;
    private String DnsLog;
    private String FileName;
    private String HTTPPort;
    private String LDAPPort;
    private String Command;
    private String remark;

    public MenuBean() {
    }

    public MenuBean(int id, String lhost, String lport, String dnsLog, String fileName, String HTTPPort, String LDAPPort, String command, String remark) {
        this.id = id;
        Lhost = lhost;
        Lport = lport;
        DnsLog = dnsLog;
        FileName = fileName;
        this.HTTPPort = HTTPPort;
        this.LDAPPort = LDAPPort;
        Command = command;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLhost() {
        return Lhost;
    }

    public void setLhost(String lhost) {
        Lhost = lhost;
    }

    public String getLport() {
        return Lport;
    }

    public void setLport(String lport) {
        Lport = lport;
    }

    public String getDnsLog() {
        return DnsLog;
    }

    public void setDnsLog(String dnsLog) {
        DnsLog = dnsLog;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getHTTPPort() {
        return HTTPPort;
    }

    public void setHTTPPort(String HTTPPort) {
        this.HTTPPort = HTTPPort;
    }

    public String getLDAPPort() {
        return LDAPPort;
    }

    public void setLDAPPort(String LDAPPort) {
        this.LDAPPort = LDAPPort;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
