package com.hb.springframework.beans.factory;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @ClassName ConfigurableListableBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 23:15
 * @Version 1.0
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

}
