package com.hb.Chapter04.AbstractFactoryPattern.test;

import org.junit.Test;

import com.hb.Chapter04.AbstractFactoryPattern.pizza.Pizza;
import com.hb.Chapter04.AbstractFactoryPattern.pizzastore.CaliforniaPizzaStore;
import com.hb.Chapter04.AbstractFactoryPattern.pizzastore.ChicagoPizzaStore;
import com.hb.Chapter04.AbstractFactoryPattern.pizzastore.NYPizzaStore;
import com.hb.Chapter04.AbstractFactoryPattern.pizzastore.PizzaStore;


/**
 * @ClassName TestFactoryPattern
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:30
 * @Version 1.0
 */
public class TestAbstractFactoryPattern {

    @Test
    public void test01() {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();

        Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println();
        Pizza chicagoPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println();
        Pizza californiaPizza = californiaPizzaStore.orderPizza("cheese");
        System.out.println();

        System.out.println(nyPizza.getName());
        System.out.println(chicagoPizza.getName());
        System.out.println(californiaPizza.getName());

    }
}
