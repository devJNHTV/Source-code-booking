package com.poly.Componen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.poly.Entity.Account;
import com.poly.Service.AccountService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
@Component
public class PasswordMigrator {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountService accountService;

    @PostConstruct
    @Transactional
    public void migratePasswords() {
        List<Account> users = accountService.findAll();
        for (Account user : users) {
            if (!user.getPassword().startsWith("$2a$")) { // Kiểm tra nếu mật khẩu đã mã hóa
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                accountService.save(user);
            }
        }
    }
}