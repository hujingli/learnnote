package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @since
 *
 * @Description 传统饿汉式单例
 */
public class Singleton01 {

    private static  final Singleton01 singleton01 = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance() {
        return singleton01;
    }

    public static void main(String[] args) {
        System.out.println(Singleton01.getInstance());
    }

}
