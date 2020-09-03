package com.hujingli.design.decorator;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 03 日
 * @Description
 * @since
 */
public abstract class PersonDecorator extends Person {

    protected Person person;

    public PersonDecorator(Person person) {
        super(person.hand, person.head);
        this.person = person;
    }

}
