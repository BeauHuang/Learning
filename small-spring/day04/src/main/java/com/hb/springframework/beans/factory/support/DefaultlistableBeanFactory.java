package com.hb.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName DefaultlistableBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:21
 * @Version 1.0
 */
public class DefaultlistableBeanFactory extends AbstractAutowiredCapableBeanFactory implements BeanDefinitionRegistry {
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    protected BeanDefinition getBeanDefinition(String name) throws BeansException {
        return beanDefinitionMap.get(name);
    }

    @Override
    public void registBeanDefinition(String name, BeanDefinition def) throws BeansException {
        beanDefinitionMap.put(name, def);
    }
}
