package com.hb.Chapter04.simplefactory;

import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName PizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/5/28 15:19
 * @Version 1.0
 */
public class PizzaStore {

    SimpleFactory simpleFactory;

    public PizzaStore(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = simpleFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
