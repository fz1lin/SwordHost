package com.swordHostDemo.utls;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * @date: 2023/2/11 15:49
 * @description:
 */
public class ipAddressUtls {

    public static String ipToLonginit(String ipstr) {
        long iplong = ipToLong(ipstr);
        return String.valueOf(iplong);
    }

    //将192.168.0.1字符串形式的IP地址转换为十进制整数
    public static long ipToLong(String strIp) {
        long[] ip = new long[4];

        try {
            //先找出字符串中点的位置
            int position1 = strIp.indexOf(".");
            int position2 = strIp.indexOf(".", position1 + 1);
            int position3 = strIp.indexOf(".", position2 + 1);
            //将点分隔的字符串转换为整数
            ip[0] = Long.parseLong(strIp.substring(0, position1));
            ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
            ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
            ip[3] = Long.parseLong(strIp.substring(position3 + 1));

            return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + (ip[3]);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    //167772160 数字地址转换为127.0.0.1
    public static String longToIP(long ip) {
        StringBuilder sb = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {
            sb.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                sb.insert(0, '.');
            }
            ip >>= 8;
        }

        return sb.toString();
    }

    //地址转换
    public static HashMap<Integer, String> CIDRConverter(String cidr) {

        String[] cidrParts = cidr.split("/");
        String baseIpAddress = cidrParts[0];
        int prefixLength = Integer.parseInt(cidrParts[1]);
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();

        byte[] bytes = new byte[0];
        try {
            bytes = InetAddress.getByName(baseIpAddress).getAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int ipAddress = ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                (bytes[3] & 0xFF);

        int subnetMask = -1 << (32 - prefixLength);
        int networkAddress = ipAddress & subnetMask;
        int startAddress = networkAddress + 1;
        int endAddress = (networkAddress | ~subnetMask) - 1;
        int totalIpAddressCount = endAddress - startAddress + 1;

        String subnetMaskString = String.format("%d.%d.%d.%d",
                (subnetMask >> 24) & 0xFF,
                (subnetMask >> 16) & 0xFF,
                (subnetMask >> 8) & 0xFF,
                subnetMask & 0xFF);

        String networkAddressString = String.format("%d.%d.%d.%d",
                (networkAddress >> 24) & 0xFF,
                (networkAddress >> 16) & 0xFF,
                (networkAddress >> 8) & 0xFF,
                networkAddress & 0xFF);

        String startAddressString = String.format("%d.%d.%d.%d",
                (startAddress >> 24) & 0xFF,
                (startAddress >> 16) & 0xFF,
                (startAddress >> 8) & 0xFF,
                startAddress & 0xFF);

        String endAddressString = String.format("%d.%d.%d.%d",
                (endAddress >> 24) & 0xFF,
                (endAddress >> 16) & 0xFF,
                (endAddress >> 8) & 0xFF,
                endAddress & 0xFF);

        Sites.put(1,subnetMaskString);
        Sites.put(2,networkAddressString);
        Sites.put(3,startAddressString);
        Sites.put(4,endAddressString);
        Sites.put(5, String.valueOf(totalIpAddressCount));


        System.out.println("子网掩码: " + subnetMaskString);
        System.out.println("网络地址: " + networkAddressString);
        System.out.println("起始地址: " + startAddressString);
        System.out.println("结束位址: " + endAddressString);
        System.out.println("IP地址数量：" + totalIpAddressCount);
        return Sites;
    }

}
