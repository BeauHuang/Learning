package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName RigisterBeanDefinition
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:01
 * @Version 1.0
 */
public interface RigisterBeanDefinition {
    void registBeanDefinition(String name, BeanDefinition def);
}
