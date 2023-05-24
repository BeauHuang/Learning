package com.hb.Chapter11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/5/24 0:22
 * @Version 1.0
 */
public class JDKProxy {

    public static void main(String[] args) {
        StudentProxy student1 = new StudentProxy(new Student("小明", 18));
        StudentProxy student2 = new StudentProxy(new Student("小红", 17));

        Person person1 = (Person) Proxy.newProxyInstance(student1.getClass().getClassLoader(), new Class[]{Person.class}, student1);
        Person person2 = (Person) Proxy.newProxyInstance(student2.getClass().getClassLoader(), new Class[]{Person.class}, student2);
        person1.getName();
        person1.getAge();
        person2.getName();
        person2.getAge();
    }
}


interface Person {
    String getName();

    int getAge();

    void setName(String name);

    void setAge(int age);
}

class Student implements Person {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}

class StudentProxy implements InvocationHandler {

    private Person person;

    public StudentProxy(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("getAge")) {
            System.out.println("查年龄");
        }
        else if (method.getName().equals("getName")) {
            System.out.println("查姓名");
        }

        return method.invoke(person, args);
    }
}