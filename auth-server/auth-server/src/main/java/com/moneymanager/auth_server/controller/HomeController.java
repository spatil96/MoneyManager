package com.moneymanager.auth_server.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.user.OAuth2User;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello, Secured!";
    }
    @GetMapping("/user-info")
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", user.getAttribute("name"));
        userInfo.put("email", user.getAttribute("email"));
        userInfo.put("avatar_url", user.getAttribute("avatar_url"));
        System.out.println(userInfo.get("name"));
        System.out.println(userInfo.get("email"));
        System.out.println(user.toString());
        return userInfo;
    }
}