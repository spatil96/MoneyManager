package com.moneymanager.auth_server.service;

import com.moneymanager.auth_server.entity.User;
import com.moneymanager.auth_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


@Override
public User saveOrUpdate(User user) {
    System.out.println("Saving user: " + user);
    Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
    if (existingUser.isPresent()) {
        User updatedUser = existingUser.get();
        updatedUser.setName(user.getName());
        updatedUser.setAvatarUrl(user.getAvatarUrl());
        updatedUser.setToken(user.getToken());
        updatedUser.setLoginTime(user.getLoginTime());
        return userRepository.save(updatedUser);
    }
    return userRepository.save(user);
}

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateLogoutTime(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        user.ifPresent(u -> {
            u.setLogoutTime(LocalDateTime.now());
            userRepository.save(u);
        });
    }


}