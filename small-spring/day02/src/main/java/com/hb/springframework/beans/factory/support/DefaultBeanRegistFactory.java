package com.hb.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName DefaultBeanRegistFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:04
 * @Version 1.0
 */
public class DefaultBeanRegistFactory extends AbstractAutowiredBeanFactory implements RigisterBeanDefinition {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public BeanDefinition getBeanDefinition(String name) {
        BeanDefinition bean = beanDefinitionMap.get(name);
        if (bean == null) {
            System.out.println("该bean未注册！！！" + name);
        }
        return bean;
    }

    @Override
    public void registBeanDefinition(String name, BeanDefinition def) {
        beanDefinitionMap.put(name, def);
    }
}
