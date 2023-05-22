package com.hb.springframework.beans.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.config.BeanDefinition;

/**
 * @ClassName SimpleInstantiationStrategy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:26
 * @Version 1.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String name, BeanDefinition def, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = def.getBeanDefinition();
        try {
            if (null != constructor) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
            else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
