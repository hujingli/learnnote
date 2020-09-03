package com.hujingli.design.decorator;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public class ManDecorator extends PersonDecorator{

    public ManDecorator(Person person) {
        super(person);
    }


    @Override
    public void sleep() {
        System.out.println("男人用" +hand + "脱掉裤子");
    }
}
