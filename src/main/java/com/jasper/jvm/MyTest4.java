package com.jasper.jvm;

/*
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcom.jasper.jvm.MyParent5
 * 这种形式，动态生成的类型，其父类是Object。
 *
 * 对于数组来说，JavaDoc经常将构成数组的元素为component，实际上就是将数组降低一个维度后的类型。
 *
 * javap -c MyTest4.class
 *
 * 助记符：
 * anewarray：表示创建一个引用类型的（如类，接口，数组）数组，并将其引用压入栈顶。
 * newarray：表示创建一个指定的原始类型的（如int, float,char等）数组，并将其引用压入栈顶。
 */
public class MyTest4 {

    public static void main(String[] args) {

        // example 1
//        System.out.println("--------- example 1 ---------");
//        MyParent5 myParent5_1 = new MyParent5(); // 首次主动使用
//        MyParent5 myParent5_2 = new MyParent5();

        // example 2
        System.out.println("--------- example 2 ---------");
        MyParent5[] myParent5s = new MyParent5[5];
        System.out.println(myParent5s.getClass());
        System.out.println(myParent5s.getClass().getSuperclass());

        MyParent5[][] myParent5ss = new MyParent5[5][5];
        System.out.println(myParent5ss.getClass());
        System.out.println(myParent5ss.getClass().getSuperclass());

        int[] ints = new int[5];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[5];
        System.out.println(chars.getClass());
        System.out.println(chars.getClass().getSuperclass());

        boolean[] booleans = new boolean[5];
        System.out.println(booleans.getClass());
        System.out.println(booleans.getClass().getSuperclass());
    }
}

class MyParent5 {

    static {
        System.out.println("Parent 5 static block");
    }
}
