package com.hujingli.design.proxy.static0;

import com.hujingli.design.factory.simple.Moveable;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 07 日
 * @Description
 * @since
 */
public class TankProxy implements Moveable {
    Tank tank;

    TankProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void go() {
        System.out.println("坦克准备走了");
        tank.go();
        System.out.println("坦克走完了");
    }

    public static void main(String[] args) {
        TankProxy tankProxy = new TankProxy(new Tank());
        tankProxy.go();

    }
}
