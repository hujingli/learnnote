package com.hujingli.design.factory.simple;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 08 月 31 日
 * @Description
 * @since
 */
public class Main {


    public static void main(String[] args) {
        Moveable moveable = new CarFactory().create();

        moveable.go();

        Moveable moveable1 = new PlaneFactory().create();
        moveable1.go();
    }

}
