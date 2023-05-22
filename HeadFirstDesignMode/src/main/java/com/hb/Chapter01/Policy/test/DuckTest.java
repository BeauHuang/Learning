package com.hb.Chapter01.Policy.test;

import org.junit.Test;

import com.hb.Chapter01.Policy.duck.Duck;
import com.hb.Chapter01.Policy.duck.WhiteDuck;
import com.hb.Chapter01.Policy.duck.behavior.impl.FlyWithWings;
import com.hb.Chapter01.Policy.duck.behavior.impl.Quack;

/**
 * @ClassName DuckTest
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/11 23:11
 * @Version 1.0
 */
public class DuckTest {

    @Test
    public void testDUck(){
        Duck duck = new WhiteDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackbehavior(new Quack());
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}
