package com.ap.design.lld_design.cartservice;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        CartService cs =new CartService();

        Cart c = cs.addItem("1CU2", 
        Arrays.asList(new CartItem("productId1", 3, 100d)),  new Cart("1CU2", new ArrayList<>()));



        c=  cs.addItem("1CU2", 
        Arrays.asList(new CartItem("productId2", 3, 200d), 
        new CartItem("productId1", 2, 100d),
        new CartItem("productId3", 5, 500d)), c);
        
    }

   

    
}
