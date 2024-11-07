package com.moneymanager.expenses.repository;

import com.moneymanager.expenses.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
