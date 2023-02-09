package com.swordHostDemo.utls;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @date: 2023/2/8 18:53
 * @description:
 */
public class deCodeUtls {
    public static String encodeCharSetUTF8 = "UTF-8";
    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:28
     * @description: base64 解码
     */
    public static String base64Decodes(String str) {
        String base64decodedByte = null;
        byte[] base64decodedBytes = Base64.getDecoder().decode(str);
        base64decodedByte = new String(base64decodedBytes, StandardCharsets.UTF_8);
        return base64decodedByte;
    }
    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:29
     * @description: unicode 解码
     */
    public static String unicodeToString1(String str) {
        int start = 0;
        int end = 0;
        StringBuilder buffer = new StringBuilder();
        while (start > -1) {
            end = str.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = str.substring(start + 2);
            } else {
                charStr = str.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(letter);
            start = end;
        }
        return buffer.toString();
    }

    /**
     * @param str:
     * @return: java.lang.String
     * @date: 2023/2/9 19:30
     * @description:  url 解码
     */
    public static String getURLDecoderString(String str) {
        String result = null;
        try {
            System.out.println("DecodeCharSet "+encodeCharSetUTF8);
            result = URLDecoder.decode(str, encodeCharSetUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }




}
