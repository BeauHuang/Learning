package com.hb.Chapter04.AbstractFactoryPattern.pizzastore;


import com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory.ChicagoPizzaIngredientFactory;
import com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory.PizzaIngredientFactory;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.CheesePizza;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.ClamPizza;
import com.hb.Chapter04.AbstractFactoryPattern.pizza.Pizza;

/**
 * @ClassName ChicagoPizzaStore
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/20 0:25
 * @Version 1.0
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (type.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago cheese Pizza");
        }
        else if (type.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Clam Pizza");
        }
        return pizza;
    }
}
