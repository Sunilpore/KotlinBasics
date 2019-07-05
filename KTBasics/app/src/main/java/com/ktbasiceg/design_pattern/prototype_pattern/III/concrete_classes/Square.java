package com.ktbasiceg.design_pattern.prototype_pattern.III.concrete_classes;

import com.ktbasiceg.design_pattern.prototype_pattern.III.Shape;

public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

}
