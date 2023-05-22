package com.hb.springframework.beans.support;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.config.BeanDefinition;

/**
 * @ClassName BeanDefinitionRegistry
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:19
 * @Version 1.0
 */
public interface BeanDefinitionRegistry {
    void registBeanDefinition(String name, BeanDefinition def) throws BeansException;
}
