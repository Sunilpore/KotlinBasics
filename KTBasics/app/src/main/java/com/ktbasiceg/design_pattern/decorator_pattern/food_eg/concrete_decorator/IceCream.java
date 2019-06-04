package com.ktbasiceg.design_pattern.decorator_pattern.food_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.KitchenDecorator;
import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class IceCream extends KitchenDecorator {

    public IceCream(Resturant resturant) {
        super(resturant);
    }

    @Override
    public double cost() {
        return super.cost()+10;
    }

    @Override
    public String description() {
        return super.description()+" Ice Cream";
    }
}
