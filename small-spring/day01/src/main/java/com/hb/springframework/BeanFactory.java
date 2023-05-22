package com.hb.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/29 23:02
 * @Version 1.0
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanMap = new HashMap<>();

    public Object getBean(String name) {

        if (beanMap.get(name) == null) {
            System.out.println("没有注册name为" + name + "的bean");
            return null;
        }

        return beanMap.get(name).getObject();
    }

    public void registerBeanDefinition(String name, BeanDefinition def) {
        beanMap.put(name, def);
    }

}
