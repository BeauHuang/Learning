package com.hb.springframework.beans.factory.config;

import com.hb.springframework.beans.PropertyValues;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 22:43
 * @Version 1.0
 */

/**
 * 定义Bean
 * 两个属性，一个是要注册的Bean的类对象，一个是Bean的属性
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
