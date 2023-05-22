package com.hb.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import com.hb.springframework.beans.factory.config.SingletonRegist;

/**
 * @ClassName AbstractSingletonFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:02
 * @Version 1.0
 */
public abstract class AbstractSingletonFactory implements SingletonRegist {

    private Map<String, Object> singletons = new HashMap<>();

    public Object getSingleton(String name) {
        Object singleton = singletons.get(name);
        if (singleton != null) {
            return singleton;
        }
        return singleton;
    }

    public void setSingleton(String name, Object object) {
        singletons.put(name, object);
    }
}
