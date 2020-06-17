package com.hujingli.design.strategy;

public class NoFlyAboutFlyStrategy implements AboutFlyStrategy {

    @Override
    public void doFly() {
        System.out.println("鸭子不会飞");
    }
}
