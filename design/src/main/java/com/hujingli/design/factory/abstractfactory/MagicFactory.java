package com.hujingli.design.factory.abstractfactory;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 01 日
 * @Description
 * @since
 */
public class MagicFactory  extends AbstractFactory{
    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Carpet();
    }
}
