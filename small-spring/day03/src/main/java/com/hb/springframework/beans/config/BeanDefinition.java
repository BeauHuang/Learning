package com.hb.springframework.beans.config;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 22:43
 * @Version 1.0
 */
public class BeanDefinition {

    private Class clazz;


    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

    public Class getBeanDefinition() {
        return clazz;
    }

    public void setBeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

}
