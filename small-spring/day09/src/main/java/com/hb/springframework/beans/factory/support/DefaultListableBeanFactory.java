package com.hb.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName DefaultlistableBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:21
 * @Version 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    /**
     * 存放BeanDefinition的容器
     */
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 通过bean的name获取BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    /**
     * 判断容器中是否包含BeanDefinition
     *
     * @param beanName
     * @return
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 返回BeanDefinition容器的keySet
     *
     * @return
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    /**
     * 注册BeanDefinition
     *
     * @param name
     * @param def
     * @throws BeansException
     */
    @Override
    public void registerBeanDefinition(String name, BeanDefinition def) throws BeansException {
        beanDefinitionMap.put(name, def);
    }

    /**
     * 在map中遍历，只要是type类型的子类或是实现类，都表示命中
     * 这时候可能找到多个
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }
}