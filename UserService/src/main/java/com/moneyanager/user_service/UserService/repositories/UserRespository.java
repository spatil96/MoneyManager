package com.moneyanager.user_service.UserService.repositories;

import com.moneyanager.user_service.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, String> {


}
