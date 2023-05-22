package com.hb.springframework.beans;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:06
 * @Version 1.0
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
