package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Accounts")
public class Account {
	@Id
	@NotBlank(message="{NotBlank.account.username}")
    private String username;
	@NotBlank(message = "{NotBlank.account.password}")
	@Size(min = 6, message = "{Size.account.password}")
    private String password;
	@NotBlank(message = "{NotBlank.account.fullname}")
    private String fullname;
	@NotBlank(message="{NotBlank.account.email}")
    @Email(message="{Email.account.email")
    private String email;
	@NotBlank(message="{NotBlank.account.phone}")
    private String phone ;
    private Boolean enabled;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Booking> bookings;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Authority> authorities;
    @OneToMany(mappedBy = "account")
    private List<Review> reviews;
}
