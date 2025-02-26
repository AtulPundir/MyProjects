package com.ap.design.lld_design.cartservice;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findByUserId(String userId);
  
}
