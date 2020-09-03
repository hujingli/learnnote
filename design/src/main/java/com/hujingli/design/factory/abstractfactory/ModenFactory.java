package com.hujingli.design.factory.abstractfactory;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 01 日
 * @Description
 * @since
 */
public class ModenFactory extends AbstractFactory{
    @Override
    Weapon createWeapon() {
        return new AK47();
    }

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
