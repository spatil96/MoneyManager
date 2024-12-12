package com.moneymanager.auth_server.controller;

import com.moneymanager.auth_server.TokenUtil;
import com.moneymanager.auth_server.entity.User;
import com.moneymanager.auth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User oauthUser) {


        String token = TokenUtil.generateToken();
        LocalDateTime loginTime = LocalDateTime.now();

        User dbUser = new User();

        dbUser.setName(oauthUser.getAttribute("name"));
        dbUser.setEmail(oauthUser.getAttribute("login")); // May be null
        dbUser.setAvatarUrl(oauthUser.getAttribute("avatar_url"));
        dbUser.setToken(token);
        dbUser.setLoginTime(loginTime);


        userService.saveOrUpdate(dbUser);

        // Fetch updated user data from the database
        Optional<User> updatedUser = userService.findByEmail(oauthUser.getAttribute("login"));

        // Prepare response
        Map<String, Object> userInfo = new HashMap<>();
        if (updatedUser.isPresent()) {
            User user = updatedUser.get();
            userInfo.put("name", user.getName());
            userInfo.put("email", user.getEmail());
            userInfo.put("avatar_url", user.getAvatarUrl());
            userInfo.put("token", user.getToken());
            userInfo.put("income", user.getIncome());
            userInfo.put("expense", user.getExpense());
            userInfo.put("total", user.getTotal());
        } else {
            userInfo.put("error", "User not found after update");
        }

        return userInfo;
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@AuthenticationPrincipal OAuth2User user) {
        String email = user.getAttribute("email");
        userService.updateLogoutTime(email);
        return ResponseEntity.ok("User logged out successfully.");
    }
}