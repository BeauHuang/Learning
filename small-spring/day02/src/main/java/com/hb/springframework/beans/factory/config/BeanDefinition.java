package com.hb.springframework.beans.factory.config;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:00
 * @Version 1.0
 */
public class BeanDefinition {
    private Class clazz;

    public BeanDefinition() {
    }

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
