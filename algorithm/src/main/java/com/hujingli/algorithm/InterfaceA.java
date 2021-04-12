package com.hujingli.algorithm;

/**
 * @author exphuhong
 * @date 2021/4/4 0004
 */
public interface InterfaceA {


    default void hello() {
        System.out.println("hello");
    }

    public static void hello2() {
        System.out.println("hello2");
    }

}

class A implements InterfaceA {

    public static void main(String[] args) {
        InterfaceA.hello2();
        A a = new A();
        a.hello();
    }

}
