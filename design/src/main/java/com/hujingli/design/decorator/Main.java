package com.hujingli.design.decorator;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public class Main {

    public static void main(String[] args) {
        new ManDecorator(new Man("手", "头")).sleep();
        new WomanDecorator(new Woman("手", "头")).sleep();
    }
}
