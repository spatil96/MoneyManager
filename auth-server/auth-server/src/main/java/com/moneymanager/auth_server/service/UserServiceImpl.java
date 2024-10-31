package com.moneymanager.auth_server.service;

import com.moneymanager.auth_server.entity.User;
import com.moneymanager.auth_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

//    @Override
//    public User get(String email) {
//        return userRepository.get(email);
//    }

//    @Override
//    public Optional<User> findById(Long id) {
//        return Optional.ofNullable(userRepository.get(id));
//    }
}