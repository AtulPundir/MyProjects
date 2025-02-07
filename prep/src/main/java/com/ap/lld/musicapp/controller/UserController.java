package com.ap.lld.musicapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ap.lld.musicapp.User;
import com.ap.lld.musicapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
    @Autowired  //Field Injection
    private UserService userService;
    
    /*//@Autowired      //Constructor injection
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    } */

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/susbcribe")
    public ResponseEntity<User> subscription(@RequestBody User user) {
        return ResponseEntity.ok(userService.subscribe(user));
    }

    @PostMapping("/subscribe/{userId}")
    public ResponseEntity<User> subscription(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.subscribeByUserId(userId));
    }


    @PostMapping("/subscribe/{userId}")
    public ResponseEntity<String> subscription2(@PathVariable Long userId) {
        userService.subscribeByUserId(userId);
        return ResponseEntity.ok("User successfully subscribed!");
    }

    @PostMapping("/subscribe") //POST /subscribe?userId=123
    public ResponseEntity<User> subscription3Entity(@RequestParam Long userId) {
        return ResponseEntity.ok(userService.subscribeByUserId(userId));
    }



}
