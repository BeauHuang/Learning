package com.hb.Chapter03.Decorator.coffee;

/**
 * @ClassName Beverage
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/14 22:30
 * @Version 1.0
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
