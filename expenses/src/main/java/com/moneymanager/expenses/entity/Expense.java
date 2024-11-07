package com.moneymanager.expenses.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Data
@Table(name="expense")
public class Expense {

    @Id
    private Long id;

    private Instant expensedate;

    private String description;

    private String location;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne
    private User user;


}
