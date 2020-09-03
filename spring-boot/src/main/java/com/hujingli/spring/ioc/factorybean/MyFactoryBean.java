package com.hujingli.spring.ioc.factorybean;

import com.hujingli.spring.ioc.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author huh20
 * @since
 */
public class MyFactoryBean  implements FactoryBean<Object>, InitializingBean, DisposableBean {

    private String className;

    private Object target;

    private Object proxyObj;

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public Object getObject() throws Exception {
        return proxyObj;
    }

    @Override
    public Class<?> getObjectType() {
        return proxyObj == null?Object.class:proxyObj.getClass();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(), Class.forName(className).getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始前");
                Object invoke = method.invoke(target, args);
                System.out.println("结束");
                return invoke;
            }
        });
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
