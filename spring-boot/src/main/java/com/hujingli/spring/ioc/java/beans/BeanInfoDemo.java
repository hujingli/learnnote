package com.hujingli.spring.ioc.java.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo}示例
 * huh20
 */
public class BeanInfoDemo {



    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        // propertyDescriptor 配置元信息
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor->{

            // propertyDescriptor 允许添加属性编辑器 - propertyEditor
            // GUI -> text(String) -> PropertyType
            // name -> String
            // age -> Integer
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();

            if ("age".equals(propertyName)){
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
            }

        });

        beanInfo.getBeanDescriptor().setValue("age", "1");

        System.out.println(beanInfo.getBeanDescriptor().getValue("age"));


    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

}
