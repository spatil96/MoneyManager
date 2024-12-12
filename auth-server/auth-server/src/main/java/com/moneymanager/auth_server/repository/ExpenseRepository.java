package com.moneymanager.auth_server.repository;


import com.moneymanager.auth_server.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
