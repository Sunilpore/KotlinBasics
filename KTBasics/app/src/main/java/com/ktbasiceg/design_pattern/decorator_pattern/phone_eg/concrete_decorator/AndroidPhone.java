package com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_decorator;

import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.interfaces.Phone;
import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.PhoneDecorator;

public class AndroidPhone extends PhoneDecorator {

    public AndroidPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("Adding features to Android");
    }

    @Override
    public int physicalSIMslots() {
        return super.physicalSIMslots()+1;
    }


    @Override
    public boolean fourGSupported(boolean enable) {
        return enable;
    }

}
