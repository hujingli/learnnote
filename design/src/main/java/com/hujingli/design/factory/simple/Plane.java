package com.hujingli.design.factory.simple;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 08 月 31 日
 * @Description
 * @since
 */
public class Plane implements Moveable {

    @Override
    public void go() {
        System.out.println("plane fly wuwuwu .....");
    }
}
