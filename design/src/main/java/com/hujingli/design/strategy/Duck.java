package com.hujingli.design.strategy;

/**
 * 抽象鸭子
 */
public abstract class Duck {

    /**
     * 鸭子有自己特有行为  飞行
     */
    protected AboutFlyStrategy aboutFlyStrategy;

    /**
     * 叫声
     */
    protected AboutQuackStrategy aboutQuackStrategy;

    public void setAboutFlyStrategy(AboutFlyStrategy strategy) {
        this.aboutFlyStrategy = strategy;
    }

    public void setAboutQuackStrategy(AboutQuackStrategy aboutQuackStrategy) {
        this.aboutQuackStrategy = aboutQuackStrategy;
    }

    /**
     * 行为操作  调用具体的策略进行行为的执行 飞行
     */
    public void doFly(){
        aboutFlyStrategy.doFly();
    }

    public void doQuack(){
        aboutQuackStrategy.quack();
    }

    /**
     * 鸭子共有特征 展示自己的外貌
     */
    public abstract void display();


}
