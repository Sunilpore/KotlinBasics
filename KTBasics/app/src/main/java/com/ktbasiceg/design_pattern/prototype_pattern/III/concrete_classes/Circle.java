package com.ktbasiceg.design_pattern.prototype_pattern.III.concrete_classes;

import com.ktbasiceg.design_pattern.prototype_pattern.III.Shape;

public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

}
