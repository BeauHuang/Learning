package com.hb.learn.hashcode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @ClassName Person
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/9/25 15:20
 * @Version 1.0
 */
public class Person {

    private int age;

    private String name;

    private String sex;

    private String phone;

    public Person(int age, String name, String sex, String phone) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return new EqualsBuilder().append(getAge(), person.getAge()).append(getName(), person.getName()).append(getSex(), person.getSex()).append(getPhone(), person.getPhone()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getAge()).append(getName()).append(getSex()).append(getPhone()).toHashCode();
    }
}
