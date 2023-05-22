package com.hb.springframework.test;

import org.junit.Test;

import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.support.DefaultBeanRegistFactory;
import com.hb.springframework.test.bean.UserService;

/**
 * @ClassName Day01Test
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:06
 * @Version 1.0
 */
public class Day02Test {


    @Test
    public void testDayo2() {
        DefaultBeanRegistFactory factory = new DefaultBeanRegistFactory();

        factory.registBeanDefinition("userService", new BeanDefinition(UserService.class));

        UserService userService = (UserService) factory.getBean("userService");

        userService.getUserService();

        UserService userService2 = (UserService) factory.getBean("userService");

        userService2.getUserService();
    }
}
