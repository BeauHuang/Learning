package com.hb.Chapter04.simplefactory.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Pizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:26
 * @Version 1.0
 */
public abstract class Pizza {

    public String name;
    public List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("准备中。。。" + name);
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }

    public void bake() {
        System.out.println("烘烤中。。。");
    }

    public void cut() {
        System.out.println("切片中。。。");
    }

    public void box() {
        System.out.println("包装中。。。");
    }
    public String getName() {
        return name;
    }
}
