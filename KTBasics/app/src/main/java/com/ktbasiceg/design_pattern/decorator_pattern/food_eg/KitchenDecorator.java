package com.ktbasiceg.design_pattern.decorator_pattern.food_eg;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public abstract class KitchenDecorator implements Resturant {

    protected Resturant ingradient;

    public KitchenDecorator(Resturant resturant) {
        this.ingradient = resturant;
    }


    @Override
    public double cost() {
        return ingradient.cost();
    }

    @Override
    public String description() {
        return ingradient.description();
    }

}
