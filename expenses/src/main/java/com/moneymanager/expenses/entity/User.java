package com.moneymanager.expenses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="user")
public class User {

	@Id
	private String id;
	
	private String  name;
	
	private String email;

}