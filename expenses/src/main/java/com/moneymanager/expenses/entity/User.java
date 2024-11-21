package com.moneymanager.expenses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class User {

	@Id
	private Long id;
	
	private String  name;
	
	private String email;

}