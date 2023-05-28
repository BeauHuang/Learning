package com.hb.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyByJDK
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/8 0:40
 * @Version 1.0
 */
public class DynamicProxyByJDK {
    public static void main(String[] args) {
        //新建代理
        JdkProxy proxy = new JdkProxy(new Student2("张三"));
        //听过代理创建对象，代理中，已经对该对象要执行的方法进行了增强
        Person2 student = (Person2) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[] {Person2.class}, proxy);
        //调用代理增强后的方法
        student.wakeup();
        student.sleep();
    }
}

interface Person2 {
    void wakeup();

    void sleep();
}

class Student2 implements Person2 {

    private String name;

    public Student2() {
    }

    public Student2(String name) {
        this.name = name;
    }

    @Override
    public void wakeup() {
        System.out.println("学生<" + name + ">早晨醒来啦");
    }

    @Override
    public void sleep() {
        System.out.println("学生<" + name + ">晚上睡觉啦");
    }
}

class JdkProxy implements InvocationHandler {

    private Object bean;

    public JdkProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //执行代理后的自定义逻辑
        String methodName = method.getName();
        if (methodName.equals("wakeup")) {
            System.out.println("早安~~~");
        }
        else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }

        //最后执行原方法，当然，可以先执行
        return method.invoke(bean, args);
    }
}
