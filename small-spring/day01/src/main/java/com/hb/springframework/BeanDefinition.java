package com.hb.springframework;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:03
 * @Version 1.0
 */
public class BeanDefinition {

    private Object object;

    public BeanDefinition() {

    }

    public BeanDefinition(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


}
