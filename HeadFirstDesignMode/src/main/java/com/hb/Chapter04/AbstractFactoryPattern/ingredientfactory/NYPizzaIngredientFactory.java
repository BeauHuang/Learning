package com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory;

import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.Cheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.ReggianoCheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.Clams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.FreshClams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.Dough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.ThinCrustDough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.Pepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.XPepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.MarinaraSauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.Sauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Tomato;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Veggies;

/**
 * @ClassName NYPizzaIngredientFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/21 23:48
 * @Version 1.0
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDaugh() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {

        Veggies[] veggies = new Veggies[1];
        veggies[1] = new Tomato();

        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new XPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
