package com.moneymanager.auth_server.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long userId;  // ID field, mapped to BigInt (Long in Java)

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;  // URL for avatar, String (255 characters)

    @Column(name = "email", length = 255)
    private String email;  // Email address, String (255 characters)

    @Column(name = "name", length = 255)
    private String name;  // User's name, String (255 characters)

    @Column(name = "token", length = 255)
    private String token;  // User's authentication token, String (255 characters)

    @Column(name = "login_time")
    private LocalDateTime loginTime;  // User's login time, LocalDateTime for timestamp

    @Column(name = "logout_time")
    private LocalDateTime logoutTime;  // User's logout time, LocalDateTime for timestamp

    @Column(name = "income", nullable = false)
    private BigDecimal income;  // User's income, BigDecimal for numeric data

    @Column(name = "expense", nullable = false)
    private BigDecimal expense;  // User's expense, BigDecimal for numeric data

    @Column(name = "total", nullable = false)
    private BigDecimal total;  // User's total balance, BigDecimal for numeric data
}