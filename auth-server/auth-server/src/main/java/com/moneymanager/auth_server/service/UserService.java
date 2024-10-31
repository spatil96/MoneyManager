package com.moneymanager.auth_server.service;

import com.moneymanager.auth_server.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);
//    User get(String user);
//    public Optional<User> findById(Long Id);
}
