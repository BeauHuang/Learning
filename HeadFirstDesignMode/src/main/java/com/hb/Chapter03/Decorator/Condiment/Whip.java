package com.hb.Chapter03.Decorator.Condiment;

import com.hb.Chapter03.Decorator.coffee.Beverage;

/**
 * @ClassName Whip
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:41
 * @Version 1.0
 */
public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {

        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.4;
    }
}
