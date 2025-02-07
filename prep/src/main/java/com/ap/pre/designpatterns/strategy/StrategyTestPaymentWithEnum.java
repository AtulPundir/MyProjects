package com.ap.pre.designpatterns.strategy;

public class StrategyTestPaymentWithEnum {

    public enum PaymentStrategy {
        CREDIT_CARD {
            @Override
            void pay(Double amount) {
                System.out.println("Going for CREDIT_CARD payment");
                //BL
            }
        }, COD {
            @Override
            void pay(Double amount) {
                System.out.println("Going for COD payment");
            }
        }, UPI {
            @Override
            void pay(Double amount) {
                System.out.println("Going for UPI payment");;
            }
        };

        abstract void pay(Double amount);

    }

    public static void main(String[] args) {
        PaymentStrategy strategy = PaymentStrategy.COD;
        strategy.pay(12314.00);

        strategy = PaymentStrategy.UPI;
        strategy.pay(11231.00);

        strategy = PaymentStrategy.CREDIT_CARD;
        strategy.pay(11231.00);
    }

}
