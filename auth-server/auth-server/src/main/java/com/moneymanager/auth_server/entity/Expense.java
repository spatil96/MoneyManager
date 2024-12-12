package com.moneymanager.auth_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@Data
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private Long id;

    private Instant expensedate;

    private String description;

    private String location;

    @ManyToOne
    @JoinColumn(name = "category_id") // Foreign key for Category
    private Category category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key for User
    private User user;


}
