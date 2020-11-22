package com.jvm;

public class TestString {

    public static void main(String[] args) {
        System.out.println(TestString.class.getClassLoader().getParent());
    }

}
