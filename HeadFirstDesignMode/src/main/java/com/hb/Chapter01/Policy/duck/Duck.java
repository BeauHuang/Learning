package com.hb.Chapter01.Policy.duck;

import com.hb.Chapter01.Policy.duck.behavior.FlyBehavior;
import com.hb.Chapter01.Policy.duck.behavior.QuackBehavior;

/**
 * @ClassName Duck
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/11 22:58
 * @Version 1.0
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior behavior) {
        flyBehavior = behavior;
    }

    public void setQuackbehavior(QuackBehavior behavior) {
        quackBehavior = behavior;
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
