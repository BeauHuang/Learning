package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.factory.BeanFactory;
import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:10
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistory implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    private Object doGetBean(String name, Object[] args) {

        Object bean = getSingletonBean(name);
        if (bean == null) {
            bean = createBean(name, getBeanDefinition(name), args);
        }
        return bean;
    }

    protected abstract Object createBean(String name, BeanDefinition def, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

}
