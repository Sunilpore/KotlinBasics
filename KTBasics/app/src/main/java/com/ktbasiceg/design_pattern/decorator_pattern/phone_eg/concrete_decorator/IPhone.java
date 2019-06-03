package com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.PhoneDecorator;
import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.interfaces.Phone;

public class IPhone extends PhoneDecorator {


    public IPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("Adding features to IPhone");
    }

    @Override
    public int physicalSIMslots() {
        return super.physicalSIMslots();
    }

    @Override
    public boolean fourGSupported(boolean enable) {
        return enable;
    }
}
