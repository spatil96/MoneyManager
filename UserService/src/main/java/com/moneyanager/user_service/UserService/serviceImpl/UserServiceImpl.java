package com.moneyanager.user_service.UserService.serviceImpl;

import com.moneyanager.user_service.UserService.entity.User;
import com.moneyanager.user_service.UserService.exceptions.ResourceNotFoundException;
import com.moneyanager.user_service.UserService.repositories.UserRespository;
import com.moneyanager.user_service.UserService.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    private Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUser(String userId) {
        User user = userRespository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        return user;
    }
}
