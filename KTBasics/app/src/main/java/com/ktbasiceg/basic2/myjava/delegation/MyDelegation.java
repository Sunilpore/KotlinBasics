package com.ktbasiceg.basic2.myjava.delegation;

public class MyDelegation {

    public static void main(String[] args) {

        Employee steve = new Employee(new FastCoder(), new GoodDesigner(), new DangerousTester());
        steve.code();
        steve.design();
        steve.test();
        steve.testFail();
    }

}



class Employee implements WhoCanCode, WhoCanDesign, WhoCanTest{

    WhoCanCode coder;
    WhoCanDesign designer;
    WhoCanTest tester;

    public Employee(WhoCanCode coder, WhoCanDesign designer, WhoCanTest tester) {
        this.coder = coder;
        this.designer = designer;
        this.tester = tester;
    }

    @Override
    public void code() {
        coder.code();
    }

    @Override
    public void design() {
        designer.design();
    }

    @Override
    public void test() {
        tester.test();
    }

    @Override
    public void testFail() {
        tester.testFail();
    }

}

class FastCoder implements WhoCanCode{

    @Override
    public void code() {
        System.out.println("Coded by FastCoder");
    }
}

class GoodDesigner implements WhoCanDesign{

    @Override
    public void design() {
        System.out.println("Design by Good Designer");
    }
}


class DangerousTester implements WhoCanTest{

    @Override
    public void test() {
        System.out.println("Tested by dangerous Tester");
    }

    @Override
    public void testFail() {
        System.out.println("Tested fail report");
    }

}



interface WhoCanCode{
    void code();
}


interface WhoCanDesign{
    void design();
}

interface WhoCanTest{
    void test();
    void testFail();
}

