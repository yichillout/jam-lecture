package com.jasper.jvm;

import java.util.UUID;

/*
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
 * 这时程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类的初始化。
 * uuid只有当运行时才能确定的，导致MyParent4需要被初始化。
 */
public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(MyParent4.uuid);
    }
}

class MyParent4 {
    public static final String uuid = UUID.randomUUID().toString();

    static {
        System.out.println("Parent 4 static block");
    }
}
