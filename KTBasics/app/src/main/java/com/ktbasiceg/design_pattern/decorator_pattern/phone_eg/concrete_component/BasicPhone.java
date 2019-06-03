package com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_component;

import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.interfaces.Phone;

public class BasicPhone implements Phone {

    @Override
    public void printModel() {
        System.out.println("Basic phone features");
    }

    @Override
    public int physicalSIMslots() {
        return 1;
    }


    @Override
    public boolean fourGSupported(boolean enable) {
        return enable;
    }


}
