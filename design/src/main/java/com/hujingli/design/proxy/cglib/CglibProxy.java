package com.hujingli.design.proxy.cglib;

import com.hujingli.design.proxy.static0.Tank;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxy {


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("坦克准备开动了");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("坦克动完了");
            return result;
        });

        Tank tank = (Tank) enhancer.create();
        tank.go();

    }

}
