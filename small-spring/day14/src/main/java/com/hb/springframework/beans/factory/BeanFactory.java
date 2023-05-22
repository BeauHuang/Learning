package com.hb.springframework.beans.factory;

import com.hb.springframework.beans.BeansException;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:06
 * @Version 1.0
 */

/**
 * Bean工厂最基础的接口，定义了一些方法规范
 * <p>
 *     1.getBean
 * </p>
 */
public interface BeanFactory {

    /**
     * 根据bean的name获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据bean的name获取含参构造函数的bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 根据bean的name和指定的类型获取相应的bean
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    <T> T getBean(Class<T> requiredType) throws BeansException;
}
