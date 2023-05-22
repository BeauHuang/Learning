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
public interface SingletonBeanRegistry {
    Object getSingletonBean(String name) throws BeansException;
}
