package com.hb.Chapter04.FactoryPattern.test;

import org.junit.Test;

import com.hb.Chapter04.FactoryPattern.factory.ChicagoPizzaStore;
import com.hb.Chapter04.FactoryPattern.factory.NYPizzaStore;
import com.hb.Chapter04.FactoryPattern.factory.PizzaStore;
import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName TestFactoryPattern
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:30
 * @Version 1.0
 */
public class TestFactoryPattern {

    @Test
    public void test01() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza("cheese");

        System.out.println(nyPizza.getName());
        System.out.println(chicagoPizza.getName());

    }
}
