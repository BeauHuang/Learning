package com.hb.Chapter04.AbstractFactoryPattern.pizza;

import com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory.PizzaIngredientFactory;

/**
 * @ClassName ClamPizza
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/22 15:37
 * @Version 1.0
 */
public class ClamPizza extends Pizza{
    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }


    @Override
    public void prepare() {
        System.out.println("preparing " + name);
        dough = pizzaIngredientFactory.createDaugh();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        clam = pizzaIngredientFactory.createClams();
    }
}
