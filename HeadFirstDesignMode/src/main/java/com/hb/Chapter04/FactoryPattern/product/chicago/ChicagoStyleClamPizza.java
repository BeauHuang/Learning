package com.hb.Chapter04.FactoryPattern.product.chicago;

import com.hb.Chapter04.FactoryPattern.product.Pizza;

/**
 * @ClassName ChicagoStyleClamPizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:29
 * @Version 1.0
 */
public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        name = "Chicago Style Clam Pizza";
        dough = "超厚饼";
        sause = "沙拉酱";
        toppings.add("Mozzarella芝士");
    }
}
