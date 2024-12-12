package com.moneyanager.user_service.UserService.controller;

import com.moneyanager.user_service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}/user-info")
    public ResponseEntity<Map<String, Object>> userInfo(@PathVariable("id") int userId, @RequestHeader HttpHeaders headers) {
        System.out.println("Authorization Header: " + headers.get("Authorization"));
        Map<String, Object> userInfo = userService.getUserDetails(String.valueOf(userId));
        return ResponseEntity.ok(userInfo);
    }
}
