package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.factory.BeanFactroy;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:01
 * @Version 1.0
 */
public abstract class AbstractBeanFactory extends AbstractSingletonFactory implements BeanFactroy {

    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean == null) {
            bean = createbean(name, getBeanDefinition(name));
        }
        return bean;
    }

    public abstract Object createbean(String name, BeanDefinition def);

    public abstract BeanDefinition getBeanDefinition(String name);

}
