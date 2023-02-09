package com.swordHostDemo.utls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date: 2023/2/4 11:04
 * @description:
 */
public class regularUtls {
    public static final String REHOST = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";
    public static final String REPORT = "([0-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";

    public static boolean reHost(String host) {
        Pattern compile = Pattern.compile(REHOST);
        Matcher matcher = compile.matcher(host);
        return matcher.matches();
    }

    public static boolean rePort(String port) {
        Pattern compile = Pattern.compile(REPORT);
        Matcher matcher = compile.matcher(port);
        return matcher.matches();
    }

}
