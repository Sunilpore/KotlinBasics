package com.ktbasiceg.design_pattern.decorator_pattern.phone_eg;

import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.interfaces.Phone;

public abstract class PhoneDecorator implements Phone {

    public Phone phone;

    public PhoneDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void printModel() {
        this.phone.printModel();
    }

    @Override
    public int physicalSIMslots() {
        return this.phone.physicalSIMslots();
    }

    @Override
    public boolean fourGSupported(boolean enable) {
        return enable;
    }


}
