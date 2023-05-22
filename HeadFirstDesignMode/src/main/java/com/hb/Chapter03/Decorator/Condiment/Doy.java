package com.hb.Chapter03.Decorator.Condiment;

import com.hb.Chapter03.Decorator.coffee.Beverage;

/**
 * @ClassName Doy
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:40
 * @Version 1.0
 */
public class Doy extends CondimentDecorator{
    public Doy(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Doy";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.3;
    }
}
