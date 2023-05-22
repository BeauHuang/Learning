package com.hb.springframework.test;

import org.junit.Test;

import com.hb.springframework.BeanDefinition;
import com.hb.springframework.BeanFactory;
import com.hb.springframework.test.bean.UserService;

/**
 * @ClassName Day01Test
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:06
 * @Version 1.0
 */
public class Day01Test {

    @Test
    public void test01() {

        BeanFactory beanFactory = new BeanFactory();

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));

        UserService bean = (UserService) beanFactory.getBean("userService");

        bean.getUserService();
    }
}
