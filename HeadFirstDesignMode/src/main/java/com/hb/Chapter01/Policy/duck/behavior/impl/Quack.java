package com.hb.Chapter01.Policy.duck.behavior.impl;

import com.hb.Chapter01.Policy.duck.behavior.QuackBehavior;

/**
 * @ClassName Quack
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/11 23:02
 * @Version 1.0
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("gua gua gua~~~");
    }
}
