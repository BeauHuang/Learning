package com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory;

import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.Cheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.MozzarellaCheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.Clams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.FrozenClams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.Dough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.ThickCrustDough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.Pepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.XPepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.PlumTomatoSauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.Sauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Potato;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Veggies;

/**
 * @ClassName ChicagoPizzaIngredientFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/21 23:49
 * @Version 1.0
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDaugh() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {

        Veggies[] veggies = new Veggies[1];
        veggies[0] = new Potato();

        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new XPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
