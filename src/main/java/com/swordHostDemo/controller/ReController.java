package com.swordHostDemo.controller;

/**
 * @date: 2023/1/2 16:27
 * @description:
 */
public class ReController {
    public static String REip="((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
    public static String REurl="http[s]?://(?:[-\\w.]|(?:%[\\da-fA-F]{2}))+";
    public static String REurlPath="http[s]?://(?:(?!http[s]?://)[a-zA-Z]|[0-9]|[$\\-_@.&+/]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+";
    public static String REurlPort="http[s]?://(?:(?!http[s]?://)[a-zA-Z]|[0-9]|[$\\-_@.&+/]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F])){0,62}(\\\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62}|(:[0-9]{1,4}))";
    public static String REAliyunAccessKey ="[Aa](ccess|CCESS)_?[Kk](ey|EY)|[Aa](ccess|CCESS)_?[sS](ecret|ECRET)|[Aa](ccess|CCESS)_?(id|ID|Id)";
    public static String REAliyunSecretKey="[Ss](ecret|ECRET)_?[Kk](ey|EY)";
    public static String REAliyunOssUrl="[\\\\w-.]\\\\.oss.aliyuncs.com";
    public static String REAWS_AccessKeyId="AKIA[0-9A-Z]{16}";
    public static String REAWS_AuthToken="amzn\\\\.mws\\\\.[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    public static String REAWS_url="s3\\\\.amazonaws.com[/]+|[a-zA-Z0-9_-]*\\\\.s3\\\\.amazonaws.com";
    public static String RESSH_key="-----BEGIN PRIVATE KEY-----[a-zA-Z0-9\\\\S]{100,}-----END PRIVATE KEY——";
    public static String RErsa_key="-----BEGIN RSA PRIVATE KEY-----[a-zA-Z0-9\\\\S]{100,}-----END RSA PRIVATE KEY-----";
}
