package com.poly.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo ;
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
