package com.ap.design.lld_design.cartservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired 
    private CartRepository cartRepository;
    @Autowired 
    private KafkaTemplate<String, CartEvent> kafkaTemplate;

    public Cart addItem(String userId, List<CartItem> items, Cart cart) {
        //Commented for demo purpose
        //Cart cart = cartRepository.findById(userId).orElse(new Cart(userId, new ArrayList<>()));
       try {
         // Convert existing items into a Map for quick lookup
          Map<String, CartItem> existingItemsMap = cart.getItems().stream()
                  .collect(Collectors.toMap(CartItem::getProductId, Function.identity()));
                  //OR .collect(Collectors.toMap(CartItem::getProductId, cartItem -> cartItem));
  
          for (CartItem newItem : items) {
              if (existingItemsMap.containsKey(newItem.getProductId())) {
                  // If item already exists, update the quantity
                  CartItem existingItem = existingItemsMap.get(newItem.getProductId());
                  existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
              } else {
                  // If new item, add it to the cart
                  cart.getItems().add(newItem);
              }
          }
          sendTokafka(cart);
  
          //cartRepository.save(cart); 
          //return cart;
       } catch (Exception e) {
        // TODO: handle exception
       }
       return cart;
    }

    @Async
    private void sendTokafka(Cart cart) {
      try {
        kafkaTemplate.send("cart-updates", new CartEvent(cart.getUserId(), EventType.ITEM_ADDED));
      } catch (Exception e) {
        System.out.println("Error occurred while sending to kafka");
      }
    }
}