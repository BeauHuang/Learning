package com.hb.springframework.beans.factory.support;

import java.lang.reflect.Constructor;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName InstantiationStrategy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:24
 * @Version 1.0
 */
public interface InstantiationStrategy {

    Object instantiate(String name, BeanDefinition def, Constructor constructor, Object[] args) throws BeansException;
}
