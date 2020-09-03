package com.hujingli.springboot.rest;

import com.hujingli.spring.ioc.factorybean.FactoryBeanTest;
import com.hujingli.spring.ioc.factorybean.MyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huh20
 * @since
 */
@RestController("/")
public class FactoryBeanTestController {

    @Autowired
    FactoryBeanTest factoryBeanTest;

    @Autowired
    ApplicationContext context;

    @GetMapping("/hello")
    public void sayHello(){
        Object myFactoryBean = context.getBean("myFactoryBean");
        System.out.println(myFactoryBean);
//        factoryBeanTest.testHello();
    }
}
