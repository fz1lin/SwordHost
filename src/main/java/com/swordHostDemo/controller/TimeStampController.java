package com.swordHostDemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date: 2022/12/29 19:48
 * @description: 时间戳转换
 */
public class TimeStampController {
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }


    //时间戳转换为日期 格式：2023-08-04 10:34:42
    public static String timeStamp2DateStr(String timeStamp ){
        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
        return date;
    }
    //日期转换为时间戳 2023-08-04 10:34:42
    public static String date2TimeStampStr(String date){
        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
        return timeStamp2;
    }
}

