package com.ktbasiceg.design_pattern.decorator_pattern.food_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.KitchenDecorator;
import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class Meet extends KitchenDecorator {

    public Meet(Resturant resturant) {
        super(resturant);
    }

    @Override
    public double cost() {
        return super.cost()+30;
    }

    @Override
    public String description() {
        return super.description()+" with Meet";
    }


}
