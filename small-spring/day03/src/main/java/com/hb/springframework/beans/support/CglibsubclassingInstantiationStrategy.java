package com.hb.springframework.beans.support;

import java.lang.reflect.Constructor;

import com.hb.springframework.beans.BeansException;
import com.hb.springframework.beans.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @ClassName CglibsubclassingInstantiationStrategy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 23:27
 * @Version 1.0
 */
public class CglibsubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String name, BeanDefinition def, Constructor constructor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(def.getBeanDefinition());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == constructor) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
