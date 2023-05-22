package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractAutowiredBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:03
 * @Version 1.0
 */
public abstract class AbstractAutowiredBeanFactory extends AbstractBeanFactory {
    public Object createbean(String name, BeanDefinition def) {
        Object bean = null;
        try {
            bean = def.getClazz().newInstance();
            setSingleton(name, bean);
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
