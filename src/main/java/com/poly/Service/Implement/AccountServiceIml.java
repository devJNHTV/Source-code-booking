package com.poly.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.Entity.Account;
import com.poly.Service.AccountService;

@Service
public class AccountServiceIml implements AccountService {
	@Autowired 
	AccountDAO aDAO;
	@Override
	public List<Account> findAll() {
		
		return aDAO.findAll();
	}

	@Override
	public void save(Account user) {
		aDAO.save(user);
		
	}

	@Override
	public Account findbyID(String username) {
		// TODO Auto-generated method stub
		return aDAO.findById(username).get();
	}
			
}
