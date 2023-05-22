package com.hb.Chapter03.Decorator.Condiment;

import com.hb.Chapter03.Decorator.coffee.Beverage;

/**
 * @ClassName CondimentDecorator
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:30
 * @Version 1.0
 */
public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    public abstract String getDescription();

}
