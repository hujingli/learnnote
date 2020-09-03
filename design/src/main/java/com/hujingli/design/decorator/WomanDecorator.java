package com.hujingli.design.decorator;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public class WomanDecorator extends PersonDecorator{


    public WomanDecorator(Person person) {
        super(person);
    }

    @Override
    public void sleep() {
        System.out.println("女人用" + hand + "脱掉内衣");
    }
}
