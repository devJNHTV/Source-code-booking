package com.poly.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.DAO.AuthorityDAO;
import com.poly.Entity.Account;
import com.poly.Entity.Authority;
import com.poly.Service.AccountService;
import com.poly.Service.AuthorityService;

@Service
public class AuthorityServiceIML implements AuthorityService {
	@Autowired 
	AuthorityDAO auDAO;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Override
	public void save(Authority auth) {
		auDAO.save(auth);
		
	}
	
	
}
