package com.hujingli.design.decorator;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public abstract class Person {

    public Person(String head, String hand) {
        this.head = head;
        this.hand = hand;
    }

    protected String head;

    protected String hand;

    abstract void sleep();

}
