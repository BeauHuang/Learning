package com.hb.learn.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @ClassName DynamicProxyByCglib
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/8 23:32
 * @Version 1.0
 */
public class DynamicProxyByCglib {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Student3("张三"));
        Student3 student = (Student3) proxy.getProxy();
        student.wakeup();
        student.sleep();
    }
}

interface Person3 {
    void wakeup();

    void sleep();
}

class Student3 implements Person3 {

    private String name;

    public Student3() {
    }

    public Student3(String name) {
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

class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    private Object bean;

    public CglibProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() {
        //设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //实现MethodInterceptor接口方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("wakeup")) {
            System.out.println("早安~~~");
        }
        else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }

        //调用原bean的方法
        return method.invoke(bean, args);
    }

}
