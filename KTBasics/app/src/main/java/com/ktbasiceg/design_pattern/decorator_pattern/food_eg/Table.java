package com.ktbasiceg.design_pattern.decorator_pattern.food_eg;

import com.ktbasiceg.design_pattern.decorator_pattern.food_eg.interfaces.Resturant;

public class Table implements Resturant {

    @Override
    public double cost() {
        return 50;
    }

    @Override
    public String description() {
        return "Reserve a Table for";
    }

}
