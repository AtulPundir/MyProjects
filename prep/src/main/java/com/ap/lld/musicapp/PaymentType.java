package com.ap.lld.musicapp;

public enum PaymentType {

    CC  {
        @Override
        Payment pay() {
           Payment payment = null;
            System.out.println("Going for Card Payment");
            //BL
            return payment;
        }
    }, UPI {
        @Override
        Payment pay() {
            Payment payment = null;
            System.out.println("Going for UPI Payment");
            //BL
            return payment;
        }
    };   
    abstract Payment pay();

}
