package com.ktbasiceg.design_pattern.prototype_pattern.I;

public class PrototypeRunDemo {

    public static void main(String[] args) {


        EmployeeRecord e1=new EmployeeRecord(1,"Praful","writer",30000,"ABC road,XYZ");

        e1.showRecord();

        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
        e2.showRecord();


    }





}
