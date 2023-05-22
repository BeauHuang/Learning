package com.hb.springframework.beans.factory.config;

/**
 * @ClassName BeanReference
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/1 22:48
 * @Version 1.0
 */

/**
 * 注册引用类型的bean
 * 目的是，注册的是引用类型，就去bean容器里面根据name找
 */
public class BeanReference {

    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
