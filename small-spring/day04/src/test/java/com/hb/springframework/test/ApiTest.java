package com.hb.springframework.test;

import org.junit.Test;

import com.hb.springframework.beans.PropertyValue;
import com.hb.springframework.beans.PropertyValues;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.BeanReference;
import com.hb.springframework.beans.factory.support.DefaultlistableBeanFactory;
import com.hb.springframework.test.bean.UserDao;
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
    public void testDay04() {
        DefaultlistableBeanFactory factory = new DefaultlistableBeanFactory();

        factory.registBeanDefinition("userdao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10086"));

        //这样不行，传进去的是一个字符串，而不是一个引用类型
        //propertyValues.addPropertyValue(new PropertyValue("userDao", "userdao"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userdao")));

        factory.registBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        UserService userService = (UserService) factory.getBean("userService");

        userService.queryUserInfo();

    }
}
