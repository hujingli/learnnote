package com.hujingli.design.strategy;

/**
 * 绿头鸭
 */
public class GreenHeadDuck extends Duck{

    public GreenHeadDuck() {
        this.aboutFlyStrategy = new NoFlyAboutFlyStrategy();
        this.aboutQuackStrategy = new GaGaQuackStrategy();
    }

    @Override
    public void display() {
        System.out.println("我是一只绿头鸭");
    }
}
