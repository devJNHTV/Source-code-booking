package com.poly.Service;

import java.util.List;

import com.poly.Entity.Account;

public interface AccountService {

	List<Account> findAll();

	void save(Account user);

	Account findbyID(String username);

}
