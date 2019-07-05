package com.ktbasiceg.basic2.myjava;

import com.ktbasiceg.basic2.mykotlin.MyCustomFileName;
import com.ktbasiceg.basic2.mykotlin.oops.MyCompanionClass;

public class MyJava implements A,B{


    public static void main(String args[]){

        //Access 'add()' method from Kotlin file
        int sum = MyCustomFileName.add(4,5);
        System.out.println("sum of two no is: "+sum);

        int volume = MyCustomFileName.findVolume();
        int volume2 = MyCustomFileName.findVolume(1);
        int volume3 = MyCustomFileName.findVolume(4,2);
        int volume4 = MyCustomFileName.findVolume(4,2,3);
        System.out.println("vol1: "+volume+" \tvol2: "+volume2+ "\t vol3:"+volume3+" \tvol4: "+volume4);

        String customerType = MyCompanionClass.typeOfCustomers();
        System.out.println("customer type: "+customerType);

    }

    public static int getArea(int a, int b){
        return a*b;
    }

    @Override
    public void displayMsg() {

    }



}





interface A {
    void displayMsg();
}

interface B {
    void displayMsg();
}