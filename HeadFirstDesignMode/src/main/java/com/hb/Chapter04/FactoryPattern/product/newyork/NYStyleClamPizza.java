package com.hb.Chapter04.FactoryPattern.product.newyork;

import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName NYStyleClamPizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:27
 * @Version 1.0
 */
public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "薄饼";
        sause = "烘焙芝麻酱";
        toppings.add("Reggiano芝士");
    }
}
