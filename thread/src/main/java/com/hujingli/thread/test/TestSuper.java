package com.hujingli.thread.test;

public class TestSuper {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.hello();
    }
}

class Zi extends Fu {
    String name = "zi";
    void hello() {
        System.out.println(this);
        super.fun();
    }

}
class Fu{
    protected String name;
    Fu() {
        this.name = "fu";
    }
    void fun() {
        System.out.println(this.name);
        System.out.println(this);
    }
}
