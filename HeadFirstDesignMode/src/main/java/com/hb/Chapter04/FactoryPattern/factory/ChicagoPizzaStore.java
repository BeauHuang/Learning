package com.hb.Chapter04.FactoryPattern.factory;

import com.hb.Chapter04.FactoryPattern.product.Pizza;
import com.hb.Chapter04.FactoryPattern.product.chicago.ChicagoStyleCheesePizza;
import com.hb.Chapter04.FactoryPattern.product.chicago.ChicagoStyleClamPizza;

/**
 * @ClassName ChicagoPizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:25
 * @Version 1.0
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        }
        return null;
    }
}
