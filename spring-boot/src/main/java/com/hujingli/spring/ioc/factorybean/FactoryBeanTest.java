package com.hujingli.spring.ioc.factorybean;

import org.springframework.stereotype.Component;

/**
 * @author huh20
 * @since
 */
@Component
public class FactoryBeanTest implements FactoryBeanTestInterface {

    @Override
    public void testHello(){
        System.out.println("hello");
    }

}
