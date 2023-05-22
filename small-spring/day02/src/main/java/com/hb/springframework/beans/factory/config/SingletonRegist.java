package com.hb.springframework.beans.factory.config;

/**
 * @ClassName SingletonRegist
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/30 0:00
 * @Version 1.0
 */
public interface SingletonRegist {
    Object getSingleton(String name);
}
