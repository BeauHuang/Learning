package com.hb.springframework.test;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import cn.hutool.core.io.IoUtil;
import com.hb.springframework.beans.PropertyValue;
import com.hb.springframework.beans.PropertyValues;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.BeanReference;
import com.hb.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hb.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.hb.springframework.core.io.DefaultResourceLoader;
import com.hb.springframework.core.io.Resource;
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
    public void testDay05() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        factory.registerBeanDefinition("userdao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10086"));

        //这样不行，传进去的是一个字符串，而不是一个引用类型
        //propertyValues.addPropertyValue(new PropertyValue("userDao", "userdao"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userdao")));

        factory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
        UserService userService = (UserService) factory.getBean("userService");

        String s = userService.queryUserInfo();
        System.out.println(s);

    }

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {

        String url = "https://blog.csdn.net/weixin_40413961/article/details/106740423?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-106740423-blog-111762786.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-106740423-blog-111762786.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=1";
        //Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
        Resource resource = resourceLoader.getResource(url);
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
