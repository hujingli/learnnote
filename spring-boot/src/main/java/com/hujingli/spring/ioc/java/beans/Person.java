package com.hujingli.spring.ioc.java.beans;

/**
 * 描述人的POJO 类
 * Setter / Getter 方法
 * 可写和可读方法
 * huh20
 */
public class Person {

    // String to String
    String name;  // property

    // String to Integer
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
