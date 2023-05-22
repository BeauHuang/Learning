package com.hb.Chapter03.Decorator.test;

import org.junit.Test;

import com.hb.Chapter03.Decorator.Condiment.Doy;
import com.hb.Chapter03.Decorator.Condiment.Mocha;
import com.hb.Chapter03.Decorator.Condiment.Whip;
import com.hb.Chapter03.Decorator.coffee.Beverage;
import com.hb.Chapter03.Decorator.coffee.Espresso;

/**
 * @ClassName DecoratorTest
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:33
 * @Version 1.0
 */
public class DecoratorTest {

    @Test
    public void test01(){
        Beverage beverage01 = new Espresso();

        System.out.println(beverage01.getDescription()+", $"+beverage01.cost());

        Beverage beverage02 = new Espresso();

        beverage02 = new Mocha(beverage02);
        beverage02 = new Doy(beverage02);
        beverage02 = new Whip(beverage02);

        System.out.println(beverage02.getDescription()+", $"+beverage02.cost());

        Beverage beverage03 = new Espresso();

        beverage03 = new Mocha(beverage03);
        beverage03 = new Mocha(beverage03);
        beverage03 = new Doy(beverage03);
        beverage03 = new Whip(beverage03);

        System.out.println(beverage03.getDescription()+", $"+beverage03.cost());


    }
}
