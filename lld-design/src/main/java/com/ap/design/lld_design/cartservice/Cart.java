package com.ap.design.lld_design.cartservice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Cart")
public class Cart {
    @Id
    private String userId;
    private List<CartItem> items;
}