package com.hb.springframework.context;

import com.hb.springframework.beans.BeansException;

/**
 * @ClassName ConfigurableApplicationContext
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/8 21:48
 * @Version 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
