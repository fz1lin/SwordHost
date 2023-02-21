package com.swordHostDemo.view;

/**
 * @date: 2023/2/21 15:13
 * @description:
 */
public class TestMain {

    public void Test(){
       String site= "isLetter()";
        System.out.println(site.length());
        String fs;
        Object floatVar = null;
        Object intVar = null;
        Object stringVar = null;
        fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", floatVar, intVar, stringVar);
        System.out.println(fs);
    }


    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.Test();
    }
}
