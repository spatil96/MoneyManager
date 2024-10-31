package com.moneymanager.auth_server.controller;

import com.moneymanager.auth_server.entity.User;
import com.moneymanager.auth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.user.OAuth2User;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

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
        String name = user.getAttribute("name");
        String email = user.getAttribute("email");
        String avatarUrl = user.getAttribute("avatar_url");

        userInfo.put("name", name);
        userInfo.put("email", email);
        userInfo.put("avatar_url", avatarUrl);

        User dbUser = new User();
        dbUser.setName(name);
        dbUser.setEmail(email);
        dbUser.setAvatarUrl(avatarUrl);

        userService.save(dbUser);

        return userInfo;
    }
}