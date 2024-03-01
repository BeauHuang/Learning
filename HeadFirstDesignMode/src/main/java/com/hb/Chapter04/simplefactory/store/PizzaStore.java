package com.hb.Chapter04.simplefactory.store;


import com.hb.Chapter04.simplefactory.factory.SimpleFactory;
import com.hb.Chapter04.simplefactory.pizza.Pizza;

/**
 * @ClassName PizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/5/28 15:19
 * @Version 1.0
 */
public class PizzaStore {

    public String name;
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
