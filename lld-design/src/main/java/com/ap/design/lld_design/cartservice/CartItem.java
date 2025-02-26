package com.ap.design.lld_design.cartservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Cart Item

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private String productId;
    private int quantity;
    private double price;
}