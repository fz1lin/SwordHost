package com.swordHostDemo.utls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date: 2023/2/4 11:04
 * @description:
 */
public class regularUtls {
    public static final String REHOST = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
    public static final String REPORT = "([0-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
    public final static String REurl = "http[s]?://(?:[-\\w.]|(?:%[\\da-fA-F]{2}))+";
    public final static String REurlPath = "http[s]?://(?:(?!http[s]?://)[a-zA-Z]|[0-9]|[$\\-_@.&+/]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+";
    public final static String REurlPort = "http[s]?://(?:(?!http[s]?://)[a-zA-Z]|[0-9]|[$\\-_@.&+/]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F])){0,62}(\\\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62}|(:[0-9]{1,4}))";
    public final static String REAliyunAccessKey = "[Aa](ccess|CCESS)_?[Kk](ey|EY)|[Aa](ccess|CCESS)_?[sS](ecret|ECRET)|[Aa](ccess|CCESS)_?(id|ID|Id)";
    public final static String REAliyunSecretKey = "[Ss](ecret|ECRET)_?[Kk](ey|EY)";
    public final static String REAliyunOssUrl = "[\\\\w-.]\\\\.oss.aliyuncs.com";
    public final static String REAWS_AccessKeyId = "AKIA[0-9A-Z]{16}";
    public final static String REAWS_AuthToken = "amzn\\\\.mws\\\\.[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    public final static String REAWS_url = "s3\\\\.amazonaws.com[/]+|[a-zA-Z0-9_-]*\\\\.s3\\\\.amazonaws.com";
    public final static String RESSH_key = "-----BEGIN PRIVATE KEY-----[a-zA-Z0-9\\\\S]{100,}-----END PRIVATE KEY——";
    public final static String RErsa_key = "-----BEGIN RSA PRIVATE KEY-----[a-zA-Z0-9\\\\S]{100,}-----END RSA PRIVATE KEY-----";
    public final static String REportMasscaName = "(\\d+)\\/tcp";
    public final static String REIPMasscanName = "\\b(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\b";


    public static String Masscaninit(String input) {
        return "nmap -sV -p " + rePortMasscan(input) + " " + (reIPMasscan(input));
    }

    //判断IP格式
    public static boolean reHost(String host) {
        Pattern compile = Pattern.compile(REHOST);
        Matcher matcher = compile.matcher(host);
        return matcher.matches();
    }

    //判断端口格式
    public static boolean rePort(String port) {
        Pattern compile = Pattern.compile(REPORT);
        Matcher matcher = compile.matcher(port);
        return matcher.matches();
    }


    //提取 Masscan 端口号
    public static String rePortMasscan(String input) {
        Pattern pattern = Pattern.compile(REportMasscaName);
        Matcher matcher = pattern.matcher(input);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group()).append(",");
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
//        System.out.println(result.toString());
        String string = result.toString();
        String replace = string.replace("/tcp", "");
        return replace;
    }

    //提取 Masscan IP
    public static String reIPMasscan(String value) {
        Pattern pattern = Pattern.compile(REIPMasscanName);
        Matcher matcher = pattern.matcher(value);
        Set<String> ipSet = new HashSet<>();
        while (matcher.find()) {
            ipSet.add(matcher.group(1));
        }
        System.out.println("Discovered IP addresses: " + ipSet);

        String ipSet1 = String.valueOf(ipSet);

        String replaces = ipSet1.replace("[", "");
        replaces = replaces.replace("]", "");
        return replaces;
    }

    //提取 Masscan IP:PORT格式
    public static List<String> IPAndPortExtractor (String input) {
        List<String> result = new ArrayList<>();
        String re = "(\\d+\\.\\d+\\.\\d+\\.\\d+)";
        String re1 = "(\\d+)/tcp on (\\d+\\.\\d+\\.\\d+\\.\\d+)";
        Pattern ipPattern = Pattern.compile(re);
        Matcher ipMatcher = ipPattern.matcher(input);

        Pattern portPattern = Pattern.compile(re1);
        Matcher portMatcher = portPattern.matcher(input);

        int portStart = 1;
        int portEnd = 65535;

        while (ipMatcher.find() && portMatcher.find()) {
            String ip = portMatcher.group(2);
            int port = Integer.parseInt(portMatcher.group(1));

            if (port >= portStart && port <= portEnd) {
                String formattedOutput = String.format("%s:%d", ip, port);
//                System.out.println(formattedOutput);
                result.add(formattedOutput);
            }
        }
        return result;
    }


}
