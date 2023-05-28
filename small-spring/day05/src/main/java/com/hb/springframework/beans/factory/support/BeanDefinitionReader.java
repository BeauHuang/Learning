package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.core.io.Resource;
import com.hb.springframework.core.io.ResourceLoader;

/**
 * @ClassName BeanDefinitionReader
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/4 22:57
 * @Version 1.0
 */

/**
 * 读取Bean的定义
 * bean可以来源于配置文件或者其他
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册信息的方法，返回的是BeanDefinitionRegistry类型的对象
     * 通过BeanDefinitionRegistry类型的对象（子类或实现类）就能够注册BeanDefinition,以及获取BeanDefinition的详情
     * 拿到BeanDefinition的详情，就能拿到bean的class信息和属性信息
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器，返回ResourceLoader类型的对象
     * 拿到ResourceLoader对象后，就能拿到getResource()获取Resource对象
     * 拿到Resource对象后，就能通过getInputStream()获取到字节流了
     *
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
