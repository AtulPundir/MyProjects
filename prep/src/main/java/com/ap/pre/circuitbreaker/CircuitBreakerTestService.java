package com.ap.pre.circuitbreaker;

import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class CircuitBreakerTestService {

    @RateLimiter(name ="circuitBreakerTestService", fallbackMethod ="rateLimitFallBack")
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackResponse")
    Object getUserData(Integer id){
    System.out.println("Goint to get the user");
    Object user = null;
    // get user
    return user;

   }

   void rateLimitFallBack(){

   }

}
