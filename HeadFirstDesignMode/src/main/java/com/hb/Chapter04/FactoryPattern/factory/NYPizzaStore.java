package com.hb.Chapter04.FactoryPattern.factory;

import com.hb.Chapter04.FactoryPattern.product.Pizza;
import com.hb.Chapter04.FactoryPattern.product.newyork.NYStyleCheesePizza;
import com.hb.Chapter04.FactoryPattern.product.newyork.NYStyleClamPizza;

/**
 * @ClassName NYPizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:24
 * @Version 1.0
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        else if (type.equals("clam")) {
            return new NYStyleClamPizza();
        }
        return null;
    }
}
