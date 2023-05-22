package com.hb.springframework.test;

import org.junit.Test;

import com.hb.springframework.context.support.ClassPathXmlApplicationContext;
import com.hb.springframework.test.bean.UserService;

/**
 * @ClassName Day01Test
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:06
 * @Version 1.0
 */
public class ApiTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //applicationContext.
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
