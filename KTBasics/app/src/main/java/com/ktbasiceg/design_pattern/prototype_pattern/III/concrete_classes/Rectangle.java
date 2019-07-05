package com.ktbasiceg.design_pattern.prototype_pattern.III.concrete_classes;

import com.ktbasiceg.design_pattern.prototype_pattern.III.Shape;

public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

}
