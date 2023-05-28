package com.hb.springframework.context;

import com.hb.springframework.beans.factory.HierarchicalBeanFactory;
import com.hb.springframework.beans.factory.ListableBeanFactory;
import com.hb.springframework.core.io.ResourceLoader;

/**
 * @ClassName ApplicationContext
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/8 21:48
 * @Version 1.0
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
