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
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibsubclassingInstantiationStrategy();

    /**
     * 创建bean的方法的具体实现
     * 通过bean的name,definition，和含参构造函数创建bean
     * 创建完bean后，填充属性
     * 再将bean注册到单例工厂的容器中
     * 最后返回bean
     * @param name
     * @param def
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
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


    /**
     * 创建bean实例
     *
     * @param beanDefinition--根据BeanDefinition获取到bean的类对象，然后
     * @param beanName--记录日志的，其他地方用不上
     * @param args--含参构造函数初始化
     * @return
     */
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

    /**
     * 填充属性
     * @param beanName--记录日志，无其他作用
     * @param bean--已经创建好的bean
     * @param def--通过BeanDefinition除了拿到类对象，还能拿到属性信息
     */
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

    /**
     * 获取实例化对象的工具
     * @return
     */
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * 设置实例化对象的工具，目前本类中是写死的
     * 后续可以考虑放在其他地方设置
     * @param instantiationStrategy
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
