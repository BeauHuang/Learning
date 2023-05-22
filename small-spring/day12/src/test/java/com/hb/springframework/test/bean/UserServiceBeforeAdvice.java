package com.hb.springframework.test.bean;

import java.lang.reflect.Method;

import com.hb.springframework.aop.framework.MethodBeforeAdvice;


public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
