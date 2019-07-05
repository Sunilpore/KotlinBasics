package com.ktbasiceg.design_pattern.prototype_pattern.II;

import java.util.List;

public class PrototypeRunTest {

    public static void main(String[] args) {

        Employees emps = new Employees();
        emps.loadData();

        //Use the clone method to get the Employee object
        Employees empsNew = null;
        Employees empsNew1 = null;

        try {

            empsNew = (Employees) emps.clone();
            empsNew1 = (Employees) emps.clone();

            List<String> list = empsNew.getEmpList();
            list.add("John");
            List<String> list1 = empsNew1.getEmpList();
            list1.remove("Pankaj");

            System.out.println("emp: "+emps+"\tempNew: "+empsNew+"\tempNew1: "+empsNew1);

            System.out.println("emps List: "+emps.getEmpList());
            System.out.println("empsNew List: "+list);
            System.out.println("empsNew1 List: "+list1);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }


}
