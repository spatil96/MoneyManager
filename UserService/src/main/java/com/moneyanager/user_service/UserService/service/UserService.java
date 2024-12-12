package com.moneyanager.user_service.UserService.service;

import com.moneyanager.user_service.UserService.entity.User;

import java.util.Map;

public interface UserService {

    Map<String, Object> getUserDetails(String email);  // New method to fetch user details with income, expenses, and total
}
