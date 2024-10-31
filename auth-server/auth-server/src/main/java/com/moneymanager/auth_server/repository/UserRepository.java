package com.moneymanager.auth_server.repository;

import com.moneymanager.auth_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User get(String email);
    User save(User user);
//    User get(Long Id);
}