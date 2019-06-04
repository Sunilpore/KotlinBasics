package com.ktbasiceg.design_pattern.decorator_pattern.food_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.KitchenDecorator;
import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class VegeTables extends KitchenDecorator {


    public VegeTables(Resturant resturant) {
        super(resturant);
    }

    @Override
    public double cost() {
        return super.cost()+10;
    }

    @Override
    public String description() {
        return super.description()+" vegetables";
    }


}
