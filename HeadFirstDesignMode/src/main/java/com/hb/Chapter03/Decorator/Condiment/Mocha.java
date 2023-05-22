package com.hb.Chapter03.Decorator.Condiment;

import com.hb.Chapter03.Decorator.coffee.Beverage;

/**
 * @ClassName Mocha
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:38
 * @Version 1.0
 */
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.2;
    }
}
