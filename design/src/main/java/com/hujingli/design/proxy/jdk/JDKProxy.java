package com.hujingli.design.proxy.jdk;

import com.hujingli.design.factory.simple.Moveable;
import com.hujingli.design.proxy.static0.Tank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 07 日
 * @Description
 * @since
 */
public class JDKProxy {


    public static void main(String[] args) {
        Tank tank = new Tank();
        Moveable m = (Moveable) Proxy.newProxyInstance(Tank.class.getClassLoader(), Tank.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("坦克准备动了");
                Object invoke = method.invoke(tank, args);
                System.out.println("坦克动完了");
                return invoke;
            }
        });
        m.go();

    }

}
