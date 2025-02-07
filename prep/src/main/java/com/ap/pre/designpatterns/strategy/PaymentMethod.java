package com.ap.pre.designpatterns.strategy;

public enum PaymentMethod {
    CREDIT_CARD {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of Rs" + amount);
        }
    },
    UPI {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing UPI payment of Rs" + amount);
        }
    },
    DEBITCARD {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing DEBITCARD payment of Rs" + amount);
        }
    },
    COD {
        @Override
        public void processPayment(double amount) {
          //Allow order to be placed
        }
    };

    public abstract void processPayment(double amount);
}