package com.hb.Chapter04.FactoryPattern.product.chicago;

import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName ChicagoStyleCheesePizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:28
 * @Version 1.0
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
        dough = "超厚饼";
        sause = "李子番茄酱";
        toppings.add("Mozzarella芝士");
    }
}
