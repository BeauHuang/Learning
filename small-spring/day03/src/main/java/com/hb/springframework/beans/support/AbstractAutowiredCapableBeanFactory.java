package com.hb.springframework.beans.support;

import java.lang.reflect.Constructor;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.config.BeanDefinition;

/**
 * @ClassName AbstractAutowiredCapableBeanFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:15
 * @Version 1.0
 */
public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibsubclassingInstantiationStrategy();

    public Object createBean(String name, BeanDefinition def, Object[] args) throws BeansException {

        Object bean = null;
        try {
            bean = createBeanInstance(def, name, args);
        }
        catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        setSingletonBean(name, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanDefinition();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
