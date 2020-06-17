package com.hujingli.design.strategy;

/**
 * gugu叫的具体行为
 */
public class GUGUQuackStrategy implements AboutQuackStrategy{

    @Override
    public void quack() {
        System.out.println("鸭子咕咕叫");
    }
}
