package com.ktbasiceg.design_pattern.decorator_pattern.food_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.KitchenDecorator;
import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class Rice extends KitchenDecorator {

    public Rice(Resturant resturant) {
        super(resturant);
    }

    @Override
    public double cost() {
        return super.cost()+20;
    }

    @Override
    public String description() {
        return super.description()+" Rice";
    }
}
