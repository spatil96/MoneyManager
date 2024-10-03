package com.moneyanager.user_service.UserService.controller;

import com.moneyanager.user_service.UserService.entity.User;
import com.moneyanager.user_service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserDetails(@RequestBody User user){
        return ResponseEntity.ok(userService.getUser(user.getUserId()));
    }
}
