package com.hb.Chapter04.simplefactory;

import com.hb.Chapter04.simplefactory.pizza.CheesePizza;
import com.hb.Chapter04.simplefactory.pizza.Pizza;

/**
 * @ClassName SimpleFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/5/28 15:26
 * @Version 1.0
 */
public class SimpleFactory {

    public Pizza createPizza(String type) {

        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("cheese")){
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
