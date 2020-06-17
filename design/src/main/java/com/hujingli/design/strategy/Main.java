package com.hujingli.design.strategy;

public class Main {

    public static void main(String[] args) {

        Duck redHeadDuck= new RedHeadDuck();
        redHeadDuck.doFly();
        redHeadDuck.doQuack();
        redHeadDuck.display();

        Duck greenHeadDuck = new GreenHeadDuck();
        greenHeadDuck.doFly();
        greenHeadDuck.doQuack();
        greenHeadDuck.display();
    }
}
