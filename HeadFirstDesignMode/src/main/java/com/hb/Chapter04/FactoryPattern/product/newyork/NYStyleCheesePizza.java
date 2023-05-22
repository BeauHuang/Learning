package com.hb.Chapter04.FactoryPattern.product.newyork;

import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName NYStyleCheesePizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:27
 * @Version 1.0
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "薄饼";
        sause = "大蒜番茄酱";
        toppings.add("Reggiano芝士");
    }
}
