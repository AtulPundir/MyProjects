package com.ap.design.lld_design.cartservice;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CartEvent {
    @Id
    private String userId;

    private EventType eventType;

}
