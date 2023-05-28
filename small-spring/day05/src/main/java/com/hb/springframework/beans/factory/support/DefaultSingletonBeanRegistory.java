package com.hb.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.SingletonBeanRegistry;

/**
 * @ClassName DefaultSingletonBeanRegistory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:07
 * @Version 1.0
 */

/**
 * 注册单例Bean的工厂具体实现类
 */
public class DefaultSingletonBeanRegistory implements SingletonBeanRegistry {

    /**
     * 存放单例的容器
     * key：beanName
     * value：单例对象
     */
    private Map<String, Object> singletonBeanMap = new HashMap<>();

    /**
     * 实现的接口方法，通过bean的name从容器中获取单例bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getSingletonBean(String name) throws BeansException {
        return singletonBeanMap.get(name);
    }

    /**
     * 注册单例Bean,在继承了DefaultSingletonBeanRegistory的子类中直接使用方法名就可以调用
     *
     * @param name
     * @param bean
     */
    public void setSingletonBean(String name, Object bean) {
        singletonBeanMap.put(name, bean);
    }
}
