package com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory;

import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.Cheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.Clams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.Dough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.Pepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.Sauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Veggies;

/**
 * @ClassName PizzaIngredientFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/21 23:41
 * @Version 1.0
 */
public interface PizzaIngredientFactory {

    Dough createDaugh();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
