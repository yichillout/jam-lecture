package com.jasper.jvm;

/*
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化。
 * 所以这里的MyParent3的static block没有被执行。
 * 注意：这里指的是将MyParent3常量存放到了MyTest2的常量池当中，之后MyTest2与MyParent3就没有任何关系了，
 * 甚至，我们可以将MyParent3的class文件删除。
 *
 * javap -c MyTest2.class
 *
 * 助记符：
 * ldc表示将float或是String类型的常量值从常量池中推送到栈顶。
 * bipush表示将单字节（-127～127）的常量值推送到栈顶。
 * sipush表示将单字节（-32768～32767）的常量值推送到栈顶。
 * iconst_1表示将int类型1推送到栈顶。
 * iconst_2表示将int类型2推送到栈顶。
 * (iconst_0 - iconst_5) 常用的
 */
class MyParent2 {
    public static String str = "parent 2 str";

    static {
        System.out.println("MyParent 2 static block");
    }
}

class MyParent3 {
    public static final String str = "parent 3 str";
    public static final short smallnum = 13;
    public static final short bignum = 128;
    public static final short one = 1;
    public static final short two = 2;
    public static final short five = 5;
    public static final short six = 6;

    static {
        System.out.println("MyParent 3 static block");
    }
}

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println("------------------");
        System.out.println(MyParent3.str);
        System.out.println(MyParent3.smallnum);
        System.out.println(MyParent3.bignum);
        System.out.println(MyParent3.one);
        System.out.println(MyParent3.two);
        System.out.println(MyParent3.five);
        System.out.println(MyParent3.six);
    }
}
