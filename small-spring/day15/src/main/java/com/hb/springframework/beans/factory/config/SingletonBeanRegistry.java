package com.hb.springframework.beans.factory.config;

import com.hb.springframework.beans.BeansException;

/**
 * @ClassName SingletonBeanRegistry
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:03
 * @Version 1.0
 */

/**
 * 单例注册工厂
 */
public interface SingletonBeanRegistry {
    /**
     * 通过bean的name获取单例对象
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getSingleton(String name);

    void registerSingleton(String beanName, Object singletonObject);
}
