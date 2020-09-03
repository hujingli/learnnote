package com.hujingli.spring.ioc.factorybean.config;

import com.hujingli.spring.ioc.factorybean.FactoryBeanTest;
import com.hujingli.spring.ioc.factorybean.FactoryBeanTestInterface;
import com.hujingli.spring.ioc.factorybean.MyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author huh20
 * @since
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    FactoryBeanTestInterface factoryBeanTest;

    @Bean
    public MyFactoryBean myFactoryBean(){
        MyFactoryBean myFactoryBean = new MyFactoryBean();
        myFactoryBean.setClassName("com.hujingli.spring.ioc.factorybean.FactoryBeanTestInterface");
        myFactoryBean.setTarget(factoryBeanTest);
        return myFactoryBean;
    }
}
