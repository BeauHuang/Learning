package com.hb.springframework.test.common;


import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.PropertyValue;
import com.hb.springframework.beans.PropertyValues;
import com.hb.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }


}


