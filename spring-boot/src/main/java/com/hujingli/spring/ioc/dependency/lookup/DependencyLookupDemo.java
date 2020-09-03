package com.hujingli.spring.ioc.dependency.lookup;

import com.hujingli.spring.ioc.annotation.Super;
import com.hujingli.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * huh20
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        // 配置xml配置文件
        // 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        // 延时查找
        lookupByLazy(beanFactory);
        // 实时查找
        lookupByRealtime(beanFactory);
        // 按类型查找
        lookupByType(beanFactory);
        // 按类型集合查找
        lookupCollectionByType(beanFactory);
        // 按注解查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByLazy(BeanFactory beanFactory){

        ObjectFactory<User> userObjectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = userObjectFactory.getObject();
        System.out.println("延迟查找"+ user);

    }

    private static void lookupByRealtime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找"+ user);
    }

    private static void lookupByType(BeanFactory beanFactory){
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型查找" + user);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("按类型查找集合" + beansOfType);
        }

    }

    private static void lookupByAnnotation(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("按注解方式查找" + beansWithAnnotation);
        }
    }

}
