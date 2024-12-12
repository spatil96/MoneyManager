package com.moneymanager.auth_server.repository;


import com.moneymanager.auth_server.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
	Category findByName(String name);
	Optional<Category> findById(Long id);
}