package com.hb.Chapter04.AbstractFactoryPattern.pizzastore;

import com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory.NYPizzaIngredientFactory;
import com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory.PizzaIngredientFactory;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.CheesePizza;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.ClamPizza;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.Pizza;


/**
 * @ClassName NYPizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:24
 * @Version 1.0
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {

        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY cheese Pizza");
        }
        else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("NY clam Pizza");
        }
        return pizza;
    }
}
