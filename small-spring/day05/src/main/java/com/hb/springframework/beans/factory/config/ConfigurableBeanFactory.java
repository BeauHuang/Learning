package com.hb.springframework.beans.factory.config;

import com.hb.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @ClassName ConfigurableBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 23:18
 * @Version 1.0
 */

/**
 * 配置Bean的接口
 * 目前配置选项有俩，单例和多例，默认单例
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}

