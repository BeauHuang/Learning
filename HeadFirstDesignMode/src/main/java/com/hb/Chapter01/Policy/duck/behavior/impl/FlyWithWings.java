package com.hb.Chapter01.Policy.duck.behavior.impl;

import com.hb.Chapter01.Policy.duck.behavior.FlyBehavior;

/**
 * @ClassName FlyWithWings
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/11 23:01
 * @Version 1.0
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm fly");
    }
}
