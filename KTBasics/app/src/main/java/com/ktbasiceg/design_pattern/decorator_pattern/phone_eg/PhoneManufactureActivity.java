package com.ktbasiceg.design_pattern.decorator_pattern.phone_eg;

import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_component.BasicPhone;
import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_decorator.AndroidPhone;
import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.concrete_decorator.IPhone;
import com.ktbasiceg.design_pattern.decorator_pattern.phone_eg.interfaces.Phone;

public class PhoneManufactureActivity {

    public static void main(String[] args) {

        Phone phone = new AndroidPhone(new BasicPhone());
        phone.printModel();

        int simSlots = phone.physicalSIMslots();
        System.out.println("TOTAL SIM slots: "+simSlots);

        boolean isEnable= phone.fourGSupported(true);
        System.out.println("4G is "+isEnable);


        Phone phone1 = new IPhone(new BasicPhone());
/*        phone1.printModel();

        Phone phone2 = new IPhone(phone);
        phone2.printModel();

        Phone phone3 = new AndroidPhone(phone1);
        phone3.printModel();*/


    }


}
