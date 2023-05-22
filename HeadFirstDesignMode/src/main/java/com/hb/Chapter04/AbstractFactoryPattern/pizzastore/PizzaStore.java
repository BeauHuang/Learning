package com.hb.Chapter04.AbstractFactoryPattern.pizzastore;


import com.hb.Chapter04.AbstractFactoryPattern.pizza.Pizza;

/**
 * @ClassName PizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:23
 * @Version 1.0
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){

        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
