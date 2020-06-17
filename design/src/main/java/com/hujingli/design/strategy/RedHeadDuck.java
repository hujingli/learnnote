package com.hujingli.design.strategy;

/**
 * 红头鸭
 */
public class RedHeadDuck extends Duck{

    public RedHeadDuck() {
        this.aboutFlyStrategy = new FlyAboutFlyStrategy();
        this.aboutQuackStrategy = new GUGUQuackStrategy();
    }

    @Override
    public void display() {
        System.out.println("我是红头鸭");
    }

}
