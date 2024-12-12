package com.moneyanager.user_service.UserService.serviceImpl;

import com.moneyanager.user_service.UserService.entity.User;
import com.moneyanager.user_service.UserService.exceptions.ResourceNotFoundException;
import com.moneyanager.user_service.UserService.repositories.UserRespository;
import com.moneyanager.user_service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    @Transactional
    public Map<String, Object> getUserDetails(String email) {
        System.out.println("userId userSrvice serviceIMPL"+email);
        User user = userRespository.findById(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));


        double income = getIncomeForCurrentMonth(String.valueOf(10));


        // Prepare the user details map
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("userId", user.getUserId());
        userDetails.put("name", user.getName());
        userDetails.put("email", user.getEmail());
        userDetails.put("income", income);
        userDetails.put("expense", user.getExpense());
        userDetails.put("totalAmount", user.getIncome());

        return userDetails;
    }

    private double getIncomeForCurrentMonth(String userId) {

        // Please write a query to get data for the income reported for the month
        return 1000.0;
    }


}
