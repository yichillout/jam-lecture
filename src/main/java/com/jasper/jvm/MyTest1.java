package com.jasper.jvm;

/*
 *  对于静态字段来说，只有直接定义了该字段的类才会被初始化；
 *  当一个类在初始化的时候，要求其父母全部都已经初始化完毕了
 *
 *  static block 在初始化的时候被执行,在example 1 里面，MyChild1被加载了，但是没有被初始化，
 *  所以没有执行 System.out.println("child 1 static block");
 *
 *  -XX:+TraceClassLoading
 *
 *  -XX:+<option> 表示开启option选项
 *  -XX:-<option> 表示关闭option选项
 *  -XX:<option>=<value>
 *
 *
 */

class MyParent1 {
    public static String str1 = "hello world!";

    static {
        System.out.println("Parent 1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome!";

    static {
        System.out.println("Child 1 static block");
    }
}


public class MyTest1 {

    static {
        System.out.println("MyTest1 static block");
    }

    public static void main(String[] args) {
        // example 1
        System.out.println(MyChild1.str1);

        // example 2
//        System.out.println(MyChild1.str2);
    }

}
