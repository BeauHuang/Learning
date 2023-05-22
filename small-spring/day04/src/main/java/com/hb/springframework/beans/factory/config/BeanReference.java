package com.hb.springframework.beans.factory.config;

/**
 * @ClassName BeanReference
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/1 22:48
 * @Version 1.0
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
