package com.hb.springframework.beans.factory.support;

import java.util.ArrayList;
import java.util.List;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.BeanPostProcessor;
import com.hb.springframework.beans.factory.config.ConfigurableBeanFactory;

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
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistory implements ConfigurableBeanFactory {

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /**
     * 通过bean的name获取bean
     *
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
     *
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
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * 调用父类DefaultSingletonBeanRegistory的getSingletonBean从单例容器中获取bean，获取不到则创建
     * <p>
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
     *
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

}
