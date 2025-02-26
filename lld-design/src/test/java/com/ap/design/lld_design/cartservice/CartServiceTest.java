package com.ap.design.lld_design.cartservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import com.ap.design.lld_design.cartservice.Cart;
import com.ap.design.lld_design.cartservice.CartEvent;
import com.ap.design.lld_design.cartservice.CartItem;
import com.ap.design.lld_design.cartservice.CartRepository;
import com.ap.design.lld_design.cartservice.CartService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private KafkaTemplate<String, CartEvent> kafkaTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddItem() {
        String userId = "1CU2";

        // Initial cart with "productId1"
        Cart existingCart = new Cart(userId, new ArrayList<>());
        existingCart.getItems().add(new CartItem("productId1", 3, 100d));

        when(cartRepository.findById(userId)).thenReturn(Optional.of(existingCart));
        when(cartRepository.save(any(Cart.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // First addition
        Cart cart = cartService.addItem(userId, Arrays.asList(
                new CartItem("productId2", 3, 200d),
                new CartItem("productId1", 2, 100d), // Existing item, should update quantity
                new CartItem("productId3", 5, 500d)
        ), existingCart);

        // Assertions
        assertEquals(3, cart.getItems().size()); // Ensure we have 3 unique products

        // Verify quantities
        assertEquals(5, cart.getItems().stream().filter(i -> i.getProductId().equals("productId1")).findFirst().get().getQuantity());
        assertEquals(3, cart.getItems().stream().filter(i -> i.getProductId().equals("productId2")).findFirst().get().getQuantity());
        assertEquals(5, cart.getItems().stream().filter(i -> i.getProductId().equals("productId3")).findFirst().get().getQuantity());

        // Ensure repository save was called
        verify(cartRepository, times(1)).save(cart);
        // Ensure Kafka event was sent
        verify(kafkaTemplate, times(1)).send(eq("cart-updates"), any(CartEvent.class));
    }
}

