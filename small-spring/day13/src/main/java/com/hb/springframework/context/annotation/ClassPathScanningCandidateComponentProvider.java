package com.hb.springframework.context.annotation;

import java.util.LinkedHashSet;
import java.util.Set;

import com.hb.springframework.beans.factory.config.BeanDefinition;
import com.hb.springframework.stereotype.Component;
import cn.hutool.core.util.ClassUtil;

/**
 * A component provider that scans the classpath from a base package. It then
 * applies exclude and include filters to the resulting classes to find candidates.
 * <p>
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
