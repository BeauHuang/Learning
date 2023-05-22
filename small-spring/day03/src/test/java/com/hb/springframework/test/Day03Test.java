package com.hb.springframework.test;

import org.junit.Test;

import com.hb.springframework.beans.config.BeanDefinition;
import com.hb.springframework.beans.support.DefaultlistableBeanFactory;
import com.hb.springframework.test.bean.UserService;

/**
 * @ClassName Day01Test
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:06
 * @Version 1.0
 */
public class Day03Test {


    @Test
    public void testDay03() {
        //创建一个工厂
        DefaultlistableBeanFactory factory = new DefaultlistableBeanFactory();

        //向工厂注册一个bean的definition
        factory.registBeanDefinition("userService", new BeanDefinition(UserService.class));

        //获取含参构造函数的bean，并传入参数
        UserService userService = (UserService) factory.getBean("userService", "初始化", 100);

        //执行方法
        userService.getUserService();

        UserService userService2 = (UserService) factory.getBean("userService");

        userService2.getUserService();
    }
}
