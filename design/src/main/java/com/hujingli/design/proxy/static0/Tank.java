package com.hujingli.design.proxy.static0;

import com.hujingli.design.factory.simple.Moveable;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 07 日
 * @Description
 * @since
 */
public class Tank implements Moveable {
    @Override
    public void go() {
        System.out.println("坦克开动了");
    }
}
