package com.hb.springframework.beans.factory.support;

import java.lang.reflect.Constructor;

import cn.hutool.core.bean.BeanUtil;
import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.PropertyValue;
import com.hb.springframework.beans.PropertyValues;
import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.beans.factory.config.BeanReference;

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
            applyPropertyValues(name, bean, def);
        }
        catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        setSingletonBean(name, bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanName, beanDefinition, constructorToUse, args);
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition def) {
        try {
            PropertyValues propertyValues = def.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        }
        catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
