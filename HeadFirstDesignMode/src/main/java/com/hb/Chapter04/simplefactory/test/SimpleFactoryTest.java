package com.hb.Chapter04.simplefactory.test;

import org.junit.Test;

import com.hb.Chapter04.simplefactory.factory.SimpleFactory;
import com.hb.Chapter04.simplefactory.pizza.Pizza;
import com.hb.Chapter04.simplefactory.store.PizzaStore;

/**
 * @ClassName SimpleFactoryTest
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/6/9 23:19
 * @Version 1.0
 */
public class SimpleFactoryTest {
  @Test
  public void test01() {
    PizzaStore pizzaStore = new PizzaStore(new SimpleFactory());

    Pizza pizza = pizzaStore.orderPizza("cheese");

    System.out.println(pizza.getName());
  }
}
