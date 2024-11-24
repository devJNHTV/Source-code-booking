package com.poly.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.DAO.AccountDAO;
import com.poly.DAO.AuthorityDAO;
import com.poly.Entity.Account;
import com.poly.Entity.Authority;
import com.poly.Entity.Role;
import com.poly.Service.AccountService;

@Service
public class AccountServiceIml implements AccountService {
	@Autowired 
	AccountDAO aDAO;
	@Autowired 
	AuthorityDAO auDAO;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Override
	public List<Account> findAll() {
		
		return aDAO.findAll();
	}

	@Override
	public void save(Account user) {
		if (!user.getPassword().startsWith("$2a$")) { // Kiểm tra nếu mật khẩu đã mã hóa
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            
        }
		user.setEnabled(true);
		aDAO.save(user);
		Authority author = new Authority();
		author.setAccount(user);
		Role role = new Role();
		role.setId("CUST");
		author.setRoleid(role);
		auDAO.save(author);
		
		
	}

	@Override
	public Account findbyID(String username) {
		// TODO Auto-generated method stub
		return aDAO.findById(username).get();
	}

	@Override
	public boolean isUsernameTaken(String username) {
		
		return aDAO.existsById(username);
	}

	@Override
	public Account findByUsernameAndEmail(String username, String email) {
		
		return aDAO.findByUsernameAndEmail(username, email);
	}
			
}
