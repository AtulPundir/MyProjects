package com.ap.pre.designpatterns.strategy;

public class StrategyTestPayment {

    public interface PaymentStrategy{
        void payment(Double amount);
    }

    public class CardPayment implements PaymentStrategy{
        @Override
        public void payment(Double amount) {
            System.out.println("Going for card payment");
        }
        
    }

    public class COD implements PaymentStrategy{
        @Override
        public void payment(Double amount) {
            System.out.println("Its COD. Proceed for the order");
        }
        
    }

    public class UPIPayment implements PaymentStrategy{
        @Override
        public void payment(Double amount) {
            System.out.println("Going for UPI payment");
        }
        
    }

    public class PaymentStrategyContext{
        PaymentStrategy paymentStrategy;

        void setPaymentStrategy(PaymentStrategy paymentStrategy){
            this.paymentStrategy =  paymentStrategy;
        }
        public void payment (Double amount){
            if (paymentStrategy == null) {
               // throw IllegalStateException;
            }
            paymentStrategy.payment(amount);
        }


    }

    public static void main(String[] args) {
        StrategyTestPayment mainObj = new StrategyTestPayment();
        PaymentStrategyContext context = mainObj.new PaymentStrategyContext();

        context.setPaymentStrategy(mainObj.new CardPayment());
        context.payment(12435.00);

        context.setPaymentStrategy(mainObj.new UPIPayment());
        context.payment(2312734.00);

        context.setPaymentStrategy(mainObj.new COD());
        context.payment(2312734.00);
    }

}
