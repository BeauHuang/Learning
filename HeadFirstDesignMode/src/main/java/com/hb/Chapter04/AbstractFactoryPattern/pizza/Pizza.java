package com.hb.Chapter04.AbstractFactoryPattern.pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.Cheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.Clams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.Dough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.Pepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.Sauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Veggies;

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
    public Dough dough;
    public Sauce sauce;
    public Veggies veggies[];
    public Cheese cheese;
    public Pepperoni pepperoni;
    public Clams clam;

    public List<String> toppings = new ArrayList<>();

    public abstract void prepare();

    public void bake(){
        System.out.println("烘烤中。。。");
    }

    public void cut(){
        System.out.println("切片中。。。");
    }

    public void box(){
        System.out.println("包装中。。。");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", dough=" + dough + ", sauce='" + sauce + '\'' + ", veggies=" + Arrays.toString(veggies) + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", clam=" + clam + ", toppings=" + toppings + '}';
    }
}
