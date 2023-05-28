package com.hb.springframework.test.bean2;

import java.lang.reflect.Method;

import com.hb.springframework.aop.MethodBeforeAdvice;

public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
