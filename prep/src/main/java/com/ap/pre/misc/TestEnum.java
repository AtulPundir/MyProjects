package com.ap.pre.misc;




public class TestEnum {

    public enum EnumTest {
        INSTANCE {
            @Override
            public void processPayment(double amount) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'processPayment'");
            }
        };
    
    
         void display(){
            System.out.println("HELLO WORLD");
        }

        public abstract void processPayment(double amount);
    }

    public static void main(String[] args) {
       EnumTest.INSTANCE.display(); 
    }

}
