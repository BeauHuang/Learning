package com.hb.learn.proxy;

/**
 * @ClassName StaticProxy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/3/8 0:36
 * @Version 1.0
 */
public class StaticProxy {

    public static void main(String[] args) {
        //新建要被代理的对象
        Person student = new Student("张三");
        //将该对象交给代理
        PersonProxy studentProxy = new PersonProxy(student);
        studentProxy.wakeup();
        studentProxy.sleep();
    }

}

interface Person {
    void wakeup();

    void sleep();
}

class Student implements Person {

    private String name;

    public Student() {
    }

    public Student(String name) {
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

class PersonProxy implements Person {

    private Person person;

    public PersonProxy(Person person) {
        this.person = person;
    }

    @Override
    public void wakeup() {
        System.out.println("早安~");
        person.wakeup();
    }

    @Override
    public void sleep() {
        System.out.println("晚安~");
        person.sleep();
    }
}

