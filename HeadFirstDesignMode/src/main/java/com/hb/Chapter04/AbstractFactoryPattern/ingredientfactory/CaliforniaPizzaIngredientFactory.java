package com.hb.Chapter04.AbstractFactoryPattern.ingredientfactory;

import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.Cheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Cheeese.GoatCheese;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.Clams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Clams.FreshClams;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.Dough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Dough.VeryThinCrustDough;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.Pepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Pepperoni.XPepperoni;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.BruschettaSauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Sauce.Sauce;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Potato;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Tomato;
import com.hb.Chapter04.AbstractFactoryPattern.ingredient.Veggies.Veggies;

/**
 * @ClassName CaliforniaPizzaIngredientFactory
 * @Description TODO
 * @Author huangbo
 * @Mail refusers@163.com
 * @Date 2023/4/21 23:58
 * @Version 1.0
 */
public class CaliforniaPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDaugh() {
        return new VeryThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new BruschettaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

    @Override
    public Veggies[] createVeggies() {

        Veggies[] veggies = new Veggies[2];
        veggies[0] = new Potato();
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
