package com.poly.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Authorities", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"username", "authority"})})
public class Authority {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String roleId;
	@ManyToOne
	@JoinColumn(name = "username")
	Account account;
}
