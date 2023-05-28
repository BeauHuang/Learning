package com.hb.learn.hashcode;

import java.util.HashMap;

/**
 * @ClassName HashCode
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2022/9/25 15:20
 * @Version 1.0
 */
public class HashCode {

    public static void main(String[] args) {


        HashMap map = new HashMap();

        Person p1 = new Person(20, "李明", "男", "18260038858");

        map.put(p1, "大吉大利，今晚吃鸡！");

        Person p2 = new Person(20, "李明", "男", "18260038858");

        System.out.println(p1.hashCode() + "===" + p2.hashCode());

        System.out.println(map.get(p2));


    }
}
