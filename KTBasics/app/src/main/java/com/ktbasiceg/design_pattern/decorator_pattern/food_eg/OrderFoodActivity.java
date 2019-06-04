package com.ktbasiceg.design_pattern.decorator_pattern.food_eg;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.concrete_decorator.*;
import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class OrderFoodActivity {

    public static void main(String[] args) {

        Resturant resturant = new Meet(new Fruits(new VegeTables(new Table())));
        System.out.println(resturant.description()+" \ncost:"+resturant.cost());


        Resturant resturant1 = new VegeTables(new Juice(new IceCream(new Table())));
        System.out.println(resturant1.description()+" \ncost:"+resturant1.cost());


        Resturant resturant2 = new Meet(new Table());
        System.out.println(resturant2.description()+" \ncost:"+resturant2.cost());


    }

}
