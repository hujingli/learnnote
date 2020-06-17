package com.hujingli.design.strategy;

/**
 * gaga叫的具体行为
 */
public class GaGaQuackStrategy implements AboutQuackStrategy{

    @Override
    public void quack() {
        System.out.println("鸭子嘎嘎叫");
    }
}
