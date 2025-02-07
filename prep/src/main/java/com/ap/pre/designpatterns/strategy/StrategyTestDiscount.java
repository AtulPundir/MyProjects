package com.ap.pre.designpatterns.strategy;

import javax.resource.spi.IllegalStateException;

public class StrategyTestDiscount {
    public interface DiscountStrategy {
        public int discountPercentage();
    
    }

    public class NormalDaysDiscount implements DiscountStrategy {
        @Override
        public int discountPercentage() {
          System.out.println("Normal Days");
            return 10;
        }
    }
    public class RepublicSaleDiscount implements DiscountStrategy {
        @Override
        public int discountPercentage() {
            System.out.println("Republic sale Days");
            return 20;
        }
    }
    public class FreedomSaleDiscount implements DiscountStrategy {
        @Override
        public int discountPercentage() {
            System.out.println("Freedom sale Days");
            return 50;
        }
        
    }

    public class DiscountStrategyContext {
        private DiscountStrategy discountStrategy;
        
        public void setDiscountStrategyContext(DiscountStrategy discountStrategy){
            this.discountStrategy =discountStrategy;
        }

        public int discountPercentage() throws IllegalStateException{
            if (discountStrategy == null){
                throw new IllegalStateException();
            }

           return discountStrategy.discountPercentage();

        }
        
        
    }

    public static void main(String[] args) throws IllegalStateException{
        StrategyTestDiscount obj = new StrategyTestDiscount();
        DiscountStrategyContext discountContext = obj.new DiscountStrategyContext();
        discountContext.setDiscountStrategyContext(obj.new FreedomSaleDiscount());
        discountContext.discountPercentage();
        discountContext.setDiscountStrategyContext(obj.new RepublicSaleDiscount());
        System.out.println(discountContext.discountPercentage());

    }

}
