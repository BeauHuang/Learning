package com.hb.springframework.beans.factory.support;

import com.hb.springframework.beans.factory.BeanFactory;
import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName AbstractBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:10
 * @Version 1.0
 */

/**
 * 抽象bean工厂
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistory implements BeanFactory {
    /**
     * 通过bean的name获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    /**
     * 获取带参构造函数的bean
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    /**
     * 获取指定类型的bean
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * 调用父类DefaultSingletonBeanRegistory的getSingletonBean从单例容器中获取bean，获取不到则创建
     *
     * 在此处，获取bean的方法由其父类DefaultSingletonBeanRegistory实现
     * 而创建bean的方法只在本抽象类中定义，具体实现由其实现类AbstractAutowireCapableBeanFactory实现
     * 这样，就做到了职责分离
     *
     * @param name
     * @param args
     * @return
     */
    private Object doGetBean(String name, Object[] args) {

        Object bean = getSingletonBean(name);
        if (bean == null) {
            bean = createBean(name, getBeanDefinition(name), args);
        }
        return bean;
    }

    /**
     * 创建bean，是个抽象方法，自定义规范，具体实现让子类搞
     */
    protected abstract Object createBean(String name, BeanDefinition def, Object[] args) throws BeansException;

    /**
     * 通过name获取BeanDefinition，也由其子类实现
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

}
