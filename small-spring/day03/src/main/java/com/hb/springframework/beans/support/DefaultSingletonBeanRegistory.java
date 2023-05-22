package com.hb.springframework.beans.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.config.SingletonBeanRegistry;

/**
 * @ClassName DefaultSingletonBeanRegistory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:07
 * @Version 1.0
 */
public class DefaultSingletonBeanRegistory implements SingletonBeanRegistry {

    private Map<String, Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingletonBean(String name) throws BeansException {
        return singletonBeanMap.get(name);
    }

    public void setSingletonBean(String name, Object bean) {
        singletonBeanMap.put(name, bean);
    }
}
