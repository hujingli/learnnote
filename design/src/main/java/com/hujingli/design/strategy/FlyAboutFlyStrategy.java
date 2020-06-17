package com.hujingli.design.strategy;

/**
 * 具体的飞行行为
 */
public class FlyAboutFlyStrategy implements AboutFlyStrategy {

    @Override
    public void doFly() {
        System.out.println("鸭子会飞");
    }
}
